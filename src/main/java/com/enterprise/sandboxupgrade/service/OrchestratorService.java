package com.enterprise.sandboxupgrade.service;
import com.enterprise.sandboxupgrade.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrchestratorService implements IOrchestratorService {

    @Autowired
    ICourseService courseService;
    @Autowired
    IInstructorService instructorService;
    @Autowired
    IStudentService studentService;
    @Autowired
    IRoleService roleService;

    private String userType;

    // not sharable (with user) - original data
    private List<Course> courses;
    private Map<Integer, Course> coursesMappedByID;

    private List<Instructor> instructors;
    private List<Student> students;

    private List<Role> roles;


    // is sharable - altered data
    private Map<PublicUser, List<PublicCourse>> publicInstructorCourseMap;
    private Map<PublicUser, List<PublicVM>> publicInstructorVMsMap;
    private Map<PublicUser, List<PublicCourse>> publicStudentCourseMap;
    private Map<PublicUser, List<PublicVM>> publicStudentVMsMap;

    // Useful for searching which student relates to which courses
    // String - User Email only (the nested map will be shared and has Public user as key which includes name && email)
    private Map<String, PublicUser> searchStudentCourseMap;

    private Map<String, Student> emailStudentMap;
    private Map<String, Instructor> emailInstructorMap;

    @Override
    public void getStarted() throws Exception {
        // Get all courses
        fetchAllCoursesFromDB();
        fetchAllInstructorsFromDB();
        fetchAllStudentsFromDB();
        // Will be provided to frontend
        createUserPublicCoursesAndVMsMap();
        populateCourseByIdMap();

        fetchAllRoles();
    }

    private void fetchAllRoles() throws Exception {
        roles = new ArrayList<>();
        roles = roleService.fetchAll();
    }

    private void fetchAllCoursesFromDB() throws Exception {
        courses = new ArrayList<>();
        courses = courseService.fetchAll();
    }

    private void populateCourseByIdMap() throws Exception {
        coursesMappedByID = new HashMap<Integer, Course>();
        for(Course course : courses){
            coursesMappedByID.put(course.getCourseID(), course);
        }
    }

    private void fetchAllInstructorsFromDB() throws Exception {
        instructors = new ArrayList<>();
        instructors = instructorService.fetchAll();
    }

    private void fetchAllStudentsFromDB() throws Exception {
        students = new ArrayList<>();
        students = studentService.fetchAll();
    }

    private void createUserPublicCoursesAndVMsMap() throws Exception {
        publicInstructorCourseMap = new HashMap<PublicUser, List<PublicCourse>>();
        publicInstructorVMsMap = new HashMap<PublicUser, List<PublicVM>>();
        publicStudentCourseMap = new HashMap<PublicUser, List<PublicCourse>>();
        publicStudentVMsMap = new HashMap<PublicUser, List<PublicVM>>();
//        List<PublicCourse> userPublicCourses = new ArrayList<PublicCourse>();


        searchStudentCourseMap = new HashMap<String, PublicUser>();
        emailStudentMap = new HashMap<String, Student>();
        emailInstructorMap = new HashMap<String, Instructor>();

        for(Student s : students){
            List<Course> courses= s.getCourses();
            List<PublicCourse> userPublicCourses = new ArrayList<PublicCourse>();
            for(Course c : courses){
                PublicCourse publicCourse = new PublicCourse();
                publicCourse.id = c.getCourseID();
                publicCourse.uniqueName = c.getUniqueName();
                publicCourse.name = c.getName();
                publicCourse.number = c.getNumber();
                publicCourse.description = c.getDescription();
                publicCourse.section = c.getSection();
                publicCourse.semester = c.getSemester();
                publicCourse.year = c.getYear();
                publicCourse.publicLabs = new ArrayList<PublicLab>();
                for(Lab lab : c.getLabs()) {
                    PublicLab publicLab = new PublicLab();
                    publicLab.number = lab.getNumber();
                    publicLab.title = lab.getTitle();
                    publicLab.description = lab.getDescription();
                    publicLab.image = lab.getImage();
                    publicLab.link = lab.getLink();
                    publicLab.dueDate = lab.getDueDate();
                    publicLab.publicCourse = publicCourse;
                    publicCourse.publicLabs.add(publicLab);
                }

                publicCourse.publicVms = new ArrayList<PublicVM>();
                for(VM vm : c.getVMs()) {
                    PublicVM PublicVM = new PublicVM();
                    PublicVM.publicNumber = vm.getPublicNumber();
                    PublicVM.name = vm.getName();
                    PublicVM.vmID = vm.getVmID();
                    PublicVM.VMWareNumber = vm.getVMWareNumber();
                    publicCourse.publicVms.add(PublicVM);
                }

                userPublicCourses.add(publicCourse);


            };
            PublicUser publicStudent = new PublicUser();
            publicStudent.name = s.getName();
            publicStudent.username = s.getUsername();

            publicStudentCourseMap.put(publicStudent,userPublicCourses);
            searchStudentCourseMap.put(s.getUsername(),publicStudent);
            emailStudentMap.put(s.getUsername(),s);
        };


        //todo should this move location?
        for(Instructor ins : instructors){
            emailInstructorMap.put(ins.getUsername(),ins);
        };
    }

    private PublicCourse castToPublicCourse(Course course){
        PublicCourse publicCourse = new PublicCourse();
        return null;
    }

    private PublicCourse castToPublicVM(VM vm){
        return null;
    }

    @Override
    public List<PublicCourse> getUserCourses(String userId){

        // is student logged in
        if(searchStudentCourseMap.containsKey(userId)){
            return publicStudentCourseMap.get(searchStudentCourseMap.get(userId));
        }
        return null ;
    }

    @Override
    public List<PublicVM> getUserVMs(String userId){
        return null;
    }

    @Override
    public void assignLabCourse(Lab lab, int courseId){
        lab.setCourse(coursesMappedByID.get(courseId));
    }

    @Override
    public Student findStudentByUsername(String email){
        if(this.emailStudentMap.containsKey(email)){
            Student student = emailStudentMap.get(email);
            userType = "student";
            return student;
        }
        return null ;
    }

    @Override
    public Instructor findInstructorByUsername(String username) {
        Instructor instructor = null;
        if(this.emailInstructorMap.containsKey(username)){
            instructor = emailInstructorMap.get(username);
            userType = "instructor";
        }
        return instructor ;
    }

//    @Override
//    public void setUserType(String username) {
//        if(this.emailInstructorMap.containsKey(username)){
//            userType =  "instructor";
//        }
//        else if(this.emailStudentMap.containsKey(username)){
//            userType = "student";
//        }  else{
//            userType = "";
//        }
//    }

    @Override
    public String getUserType(String username) {
        return userType;
    }
}
