//package com.enterprise.sandboxupgrade;
//import com.enterprise.sandboxupgrade.dto.Course;
//import com.enterprise.sandboxupgrade.service.IEventService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//
//
//@SpringBootTest
//class EventmanagementsystemApplicationTests {
//    @Autowired
//    private IEventService eventService;
//    private Course event;
//
//    @Test
//    void contextLoads() {
//    }
//    @Test
//    void addNewEvent_displayNewEvent() throws Exception {
//        givenNewEventIsAvailable();
//        whenCreatingNewEvent();
//        thenAddNewEvent();
//    }
//
//    private void givenNewEventIsAvailable() {
//    }
//
//    private void whenCreatingNewEvent() throws ParseException {
//        event= new Course();
//        event.setId(1);
//        event.setName("Birthday");
//        event.setAddress("567 Main St.");
//        event.setCity("Cincinnati");
//        event.setState("Ohio");
//        event.setCountry("USA");
//        event.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-01-28 17:00:00"));
//        event.setDescription("It is Sam's 31st Birthday!!");
//
//    }
//    private void thenAddNewEvent() throws Exception {
//        Course createCourse = eventService.save(event);
//        assertEquals(event, createCourse);
//    }
//    @Test
//    void saveEvent_displayEventUpdate() throws Exception {
//        givenEventUpdates();
//        whenEventUpdates();
//        thenEventUpdates();
//    }
//
//    private void givenEventUpdates() {
//    }
//    private void whenEventUpdates() throws ParseException {
//        event = new Course();
//        event.setId(1);
//        event.setName("Birthday");
//        event.setAddress("567 Main St.");
//        event.setCity("Cincinnati");
//        event.setState("Ohio");
//        event.setCountry("USA");
//        event.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-01-28 17:00:00"));
//        event.setDescription("It is Sam's 32nd Birthday!!");
//    }
//    private void thenEventUpdates() throws Exception {
//        eventService.save(event);
//        var updateEvent = eventService.fetch(event.getId());
//        assertEquals(event, updateEvent);
////        verify(eventService, atLeastOnce()).save(event);
//    }
//    @Test
//    void deleteEvent() throws Exception {
//        whenEventDeletes();
//        thenDeleteEvent();
//    }
//    private void whenEventDeletes() throws ParseException {
//        event = new Course();
//        event.setId(2);
//        event.setName("Monthly Office Event");
//        event.setAddress("456 Salt Rd.");
//        event.setCity("Sydney");
//        event.setState("Ohio");
//        event.setCountry("USA");
//        event.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-04-25 17:00:00"));
//        event.setDescription("Office monthly happy hour - Bowling");
//    }
//    private void thenDeleteEvent() throws Exception {
//        List<Course> eventList = new ArrayList<>();
//        eventService.save(event);
//        for (Course event: eventService.fetchAll()) {
//            eventList.add(event);
//        }
//        var deletedEvent = eventService.fetch(event.getId());
//        assertTrue(eventList.contains(deletedEvent));
//        eventService.delete(event.getId());
//        eventList = StreamSupport.stream(eventService.fetchAll().spliterator(), false).collect(Collectors.toList());
//        assertFalse(eventList.contains(deletedEvent));
//    }
//    @Test
//    void searchEvent() throws Exception {
//        whenEventDeletes();
//        eventService.save(event);
//        whenSearchingEvent();
//        thenSearchEvent();
//    }
//
//    private void thenSearchEvent() throws Exception {
//        eventService.save(event);
//        List<Course> eventList = eventService.searchEvents(event.getName());
//        assertEquals(2, eventList.size());
//    }
//
//    private void whenSearchingEvent() throws ParseException {
//        event= new Course();
//        event.setId(3);
//        event.setName("Birthday");
//        event.setAddress("567 Main St.");
//        event.setCity("Cincinnati");
//        event.setState("Ohio");
//        event.setCountry("USA");
//        event.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-01-28 17:00:00"));
//        event.setDescription("It is Sam's 50th Birthday!!");
//    }
//}
