package com.enterprise.sandboxupgrade.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IVMWareService {
    public String getSessionId() throws JsonProcessingException;

    public void powerOffVM(String vmId) throws JsonProcessingException;

    public void powerOnVM(String vmId) throws JsonProcessingException;

    public String getVmPowerState(String vmId) throws JsonProcessingException;

    boolean isVmPowerOff(String vmId) throws JsonProcessingException;

    boolean isVmPowerOn(String vmId) throws JsonProcessingException;

    public String generateTicket(String vmId) throws JsonProcessingException;
}
