package com.enterprise.sandboxupgrade.controller;
import com.enterprise.sandboxupgrade.service.ICourseService;
import com.enterprise.sandboxupgrade.service.ILabService;
import com.enterprise.sandboxupgrade.service.ISemesterService;
import com.enterprise.sandboxupgrade.service.IVmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SandboxupgradeController {

    @Autowired
    ICourseService courseService;
    @Autowired
    ISemesterService semesterService;
    @Autowired
    IVmService vmService;
    @Autowired
    ILabService labService;

//    public
//    VirtualMachineTicket acquireTicket(final ManagedObjectReference vmMoRef, String ticketType)
//            throws Exception {
//        VirtualMachineTicket vmTicket = null;
//        vmTicket = super.getPortType().acquireTicket(vmMor, ticketType);
//        return vmTicket;
//    }
    /**
     * Display student VM.
     * @return capstone/vm page.
     * @throws Exception
     */
    @GetMapping("/")
    public String viewCapstonePage(Model model) throws Exception {
        model.addAttribute("listCourse", courseService.fetchAll());
//        model.addAttribute("listSemester", semesterService.fetchAll());
        model.addAttribute("listVMs", vmService.fetchAll());
        model.addAttribute("listLabs", labService.fetchAll());
        return "index";
    }

//    public VirtualMachineTicket acquireTicket(final ManagedObjectReference vmMoRef, String ticketType)
//            throws Exception {
//        VirtualMachineTicket vmTicket = null;
//        HostFirewallRulePortType h = null;
//        vmTicket = h.getPortType().acquireTicket(vmMoRef, ticketType);
//        return vmTicket;
//    }



//    /**
//     * List all events.
//     * @param model Display all Events
//     * @return The index page.
//     * @throws Exception
//     */
//    @GetMapping("/")
//    public String viewHomePage(Model model) throws Exception {
//        model.addAttribute("listEvents", eventService.fetchAll());
//        model.addAttribute("eventsSearchableData",eventService.generateEventsSearchableData());
//        return "index";
//    }
//
//    /**
//     * Present New Event form.
//     * @param model Allow user to create new event
//     * @return new event page.
//     * @throws Exception
//     */
//    @GetMapping("/showNewEventForm")
//    public String showNewEventForm(Model model) throws Exception {
//        Event event = new Event();
//        model.addAttribute("event", event);
//        model.addAttribute("eventsSearchableData", eventService.generateEventsSearchableData());
//        return "newEvent";
//    }
//
//    /**
//     * Saves event to our database.
//     * @param event Save event information
//     * @return event information that will be saved in the database.
//     * @throws Exception
//     */
//    @PostMapping("/save")
//    public String save(@ModelAttribute("event") Event event) throws Exception {
//        eventService.save(event);
//        return "redirect:/";
//    }
//
//    /**
//     * Create a new Event.
//     * @param event JSON Object.
//     * @return new event object.
//     * @throws Exception
//     */
//    @PostMapping("/createEvent")
//    public ResponseEntity createEvent(@RequestBody Event event) throws Exception {
//        if(event.getName() == null){
//            throw new InvalidInputException("Id cannot be null");
//        }
//        Event newEvent;
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        newEvent = eventService.save(event);
//        return new ResponseEntity(newEvent, headers, HttpStatus.OK);
//    }
//
//    /**
//     * Save an Event created.
//     * @param id Save Event
//     * @param event Save Event
//     * @return new event object.
//     * @throws Exception
//     */
//    @PostMapping("/saveEvent/{id}")
//    public ResponseEntity saveEvent(@PathVariable("id") int id, @RequestBody Event event) throws Exception {
//        Event newEvent;
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        event.setId(id);
//        newEvent = eventService.save(event);
//
//        return new ResponseEntity(newEvent, headers, HttpStatus.OK);
//    }
//
//    /**
//     * Delete an event.
//     * @param id Delete Event
//     * @return page where the deleted event does not exist anymore.
//     * @throws Exception
//     */
//    @DeleteMapping("/deleteEvent/{id}")
//    public ResponseEntity deleteEvent(@PathVariable("id") int id) throws Exception {
//        eventService.delete(id);
//        return new ResponseEntity(HttpStatus.OK);
//    }
//
//    /**
//     * Get event from the service. Set event as a model attribute to pre-populate the form.
//     * @param id edit event
//     * @param model edit event
//     * @return the edit event page .
//     * @throws Exception
//     */
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable(value = "id") int id, Model model) throws Exception{
//        Event event = eventService.fetch(id);
//        model.addAttribute("event", event);
//        model.addAttribute("eventsSearchableData", eventService.generateEventsSearchableData());
//        return "editEvent";
//    }
//
//    /**
//     * Delete event.
//     * @param id Delete Event
//     * @return page where the deleted event does not exist anymore.
//     * @throws Exception
//     */
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable(value = "id") int id) throws Exception {
//        this.eventService.delete(id);
//        return "redirect:/";
//    }
//
//    /**
//     * Fetching all information regarding events.
//     * @return all information regarding events.
//     * @throws Exception
//     */
//    @GetMapping("/event")
//    @ResponseBody
//    public Iterable<Event> fetchAllEvents() throws Exception {
//        return eventService.fetchAll();
//    }
//
//    /**
//     * Search for an event that exists.
//     * @param searchText Search for Event
//     * @return all events that were similar to the search term entered into the search field.
//     * @throws Exception
//     */
//    @GetMapping("/search/{str}")
//    @ResponseBody
//    public List<Event> searchEvents(@PathVariable(value = "str") String searchText) throws Exception{
//        return eventService.searchEvents(searchText);
//    }
}
