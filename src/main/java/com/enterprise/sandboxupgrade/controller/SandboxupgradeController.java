package com.enterprise.sandboxupgrade.controller;
import com.enterprise.sandboxupgrade.entity.*;
import com.enterprise.sandboxupgrade.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;


//Based on content from UC's Enterprise Development course
@Controller
public class SandboxupgradeController {

    @Autowired
    ICourseService courseService;
    @Autowired
    ISemesterService semesterService;
    @Autowired
    IVmService vmService;
    @Autowired
    IVmConfigurationService VmConfigurationService;
    @Autowired
    ILabService labService;
    @Autowired
    IOrchestratorService orchestratorService;

    private boolean isStarted = false;


    @Autowired
    IStudentService studentService;

    @Autowired
    IInstructorService instructorService;

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
    public String viewMainPage(Model model) throws Exception {
        getStarted();
//        model.addAttribute("listCourse", orchestratorService.getUserCourses("jonesm@mail.uc.edu"));
        model.addAttribute("listCourse", orchestratorService.getUserCourses("petersa@mail.uc.edu"));
//        model.addAttribute("listSemester", semesterService.fetchAll());
        model.addAttribute("listVMs", vmService.fetchAll());
        model.addAttribute("listVMconfigureOptions", VmConfigurationService.fetchAll());
        model.addAttribute("listLabs", labService.fetchAll());
        return "index";
    }

    @GetMapping("/courses")
    public String viewCoursesPage(Model model) throws Exception {
        getStarted();
//        model.addAttribute("listCourse", orchestratorService.getUserCourses("jonesm@mail.uc.edu"));
        model.addAttribute("listCourse", orchestratorService.getUserCourses("petersa@mail.uc.edu"));
//        model.addAttribute("listSemester", semesterService.fetchAll());
        model.addAttribute("listVMs", vmService.fetchAll());
        model.addAttribute("listVMconfigureOptions", VmConfigurationService.fetchAll());
        model.addAttribute("listLabs", labService.fetchAll());
        return "index";
    }

    private void getStarted() throws Exception{
        if(!isStarted) orchestratorService.getStarted();
        isStarted = true;
    }


    @GetMapping("/create-lab")
    public String createLab(Model model) throws Exception {
        getStarted();
        Lab lab = new Lab();
        model.addAttribute("lab", lab);
        model.addAttribute("course", new PublicCourse());
        model.addAttribute("listCourse", orchestratorService.getUserCourses("petersa@mail.uc.edu"));
        return "create-lab";
    }

    @PostMapping("/saveLab")
//    public String saveLab(@ModelAttribute("lab") Lab lab, @RequestParam("imageFile") MultipartFile imageFile,
//                          @RequestParam("videoFile") MultipartFile videoFile)
    public String saveLab(@RequestParam("imageFile") MultipartFile imageFile,
                          @RequestParam("videoFile") MultipartFile videoFile,
                          @ModelAttribute("course") PublicCourse course,
                          @ModelAttribute("lab") Lab lab)
            throws Exception {
        getStarted();
        //From UC's Enterprise Development course by Prof. Jones
        //Storing file on server, (and String path in database)
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(absolutePath + "/src/main/resources/static/photos/" + imageFile.getOriginalFilename());
        Files.write(path, bytes);
        lab.setImage(path.toString());
        lab.setDueDate(new Date());
//        lab.setCourse(new Course());

        // same for video
        bytes = videoFile.getBytes();
        path = Paths.get(absolutePath + "/src/main/resources/static/videos/" + videoFile.getOriginalFilename());
        Files.write(path, bytes);
        lab.setLink(path.toString());

        // todo 1. correct courseID so submitted by user
        // todo 2. correct Due-date so submitted by user
        if(course.id <= 0){
            orchestratorService.assignLabCourse(lab, 4);
        } else {
            orchestratorService.assignLabCourse(lab, course.id);
        }
        labService.save(lab);
        return "redirect:/";
    }




    @GetMapping("/login")
    public String login(Model model) throws Exception {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(Model model) throws Exception {
        return "index";
    }


    //    @PostMapping("/save")
//    public String save(@ModelAttribute("event") Event event) throws Exception {
//        eventService.save(event);
//        return "redirect:/";
//    }

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
