package com.enterprise.sandboxupgrade.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

import org.springframework.stereotype.Component;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
public class VMWareService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VMWareService.class);

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    private RestTemplate restTemplate;

    private final String VCENTER_URL = "https://10.127.68.17/";
    private String VCENTER_USERNAME = "administrator@vsphere.local";
    private String VCENTER_PASSWORD = "SeniorDesign22!";
    private String vcenterSessionId ="";









    public VMWareService(RestTemplateBuilder restTemplateBuilder,RestTemplate restTemplate) throws KeyManagementException, NoSuchAlgorithmException {
        this.restTemplate = restTemplate;
        this.restTemplateBuilder = restTemplateBuilder;
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
        };

        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

        this.restTemplate = restTemplateBuilder.build();
    }




    public String getSessionId() throws JsonProcessingException {
        if(vcenterSessionId != "") return vcenterSessionId;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String encodedCredentials = Base64.getEncoder().encodeToString((VCENTER_USERNAME + ":" + VCENTER_PASSWORD).getBytes());
        headers.set("Authorization", "Basic " + encodedCredentials);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(VCENTER_URL + "rest/com/vmware/cis/session", HttpMethod.POST, entity, String.class);
        jsonNode = mapper.readTree(response.getBody());
//        String value = jsonNode.findValue("value").toString();
        String value = jsonNode.get("value").textValue();
        LOGGER.info("Session ID: " + value);
//        return response.getHeaders().getFirst("vmware-api-session-id");
        return value;
    }

    public void powerOffVM(String vmId) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        String sessionId =  getSessionId();
        headers.set("vmware-api-session-id", sessionId);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = VCENTER_URL+ "rest/vcenter/vm/" + vmId + "/power/stop";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Virtual machine has been powered off successfully!");
        } else {
            System.out.println("Failed to power off the virtual machine. Error: " + response.getBody());
        }
    }

    public void powerOnVM(String vmId) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        String sessionId =  getSessionId();
        headers.set("vmware-api-session-id", sessionId);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = VCENTER_URL+ "rest/vcenter/vm/" + vmId + "/power/start";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Virtual machine has been powered on successfully!");
        } else {
            System.out.println("Failed to power on the virtual machine. Error: " + response.getBody());
        }
    }


    public String generateTicket(String vmId) throws JsonProcessingException {
        String BASE_URL = VCENTER_URL+ "api/vcenter/vm/";
        HttpHeaders headers = new HttpHeaders();
        String sessionId =  getSessionId();
        headers.set("vmware-api-session-id", sessionId);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
//        requestBody.put("spec", Collections.singletonMap("type", "VMRC"));
        requestBody.put("type", "VMRC");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Map> response = restTemplate.exchange(BASE_URL + vmId + "/console/tickets", HttpMethod.POST, request, Map.class);

        Map<String, Object> responseBody = response.getBody();
        return (String) responseBody.get("value");
    }
}
