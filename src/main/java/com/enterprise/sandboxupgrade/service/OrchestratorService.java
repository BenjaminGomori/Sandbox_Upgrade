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

//    private String userType = "";
//    private String userEmail = "";
//    private int userId = 0;
    private User user = new User();

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
    private Map<String, PublicUser> searchStudentMap;
    private Map<String, PublicUser> searchInstructorMap;

    private Map<String, Student> emailStudentMap;
    private Map<String, Instructor> emailInstructorMap;

    // vm mapping between public id shared with front end and real vm name
    private Map<Integer, String> vmPublicIdAndVMWareNameMap;


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
        populateVmPublicIdAndVMWareNameMap();
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


        searchStudentMap = new HashMap<String, PublicUser>();
        searchInstructorMap = new HashMap<String, PublicUser>();
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
                    publicLab.id = lab.getLabID();
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
                    PublicVM.VMWareName = vm.getVMWareName();
                    PublicVM.publicNumber = vm.getPublicNumber();
                    PublicVM.name = vm.getName();
                    PublicVM.vmID = vm.getVmID();
                    PublicVM.VMWareNumber = vm.getVMWareNumber();
                    PublicVM.student = vm.getStudent();
                    PublicVM.instructor = vm.getInstructor();
                    PublicVM.studentId = vm.getStudent().studentID;
                    PublicVM.instructorId = vm.getInstructor().instructorID;

                    // id of 1 means that this is a instructor VM
                    // TODO commented out on 03/10
//                    if(PublicVM.studentId == 1){
//                        PublicVM.username = vm.getInstructor().getFullName();
//                        PublicVM.email = vm.getInstructor().getUsername();
//                    }
                    // id of 1 means that this is a student VM
//                    else if(PublicVM.instructorId == 1){
                     if(PublicVM.instructorId == 1){
                        PublicVM.username = vm.getStudent().getName();
                        PublicVM.email = vm.getStudent().getUsername();
                    }

                    publicCourse.publicVms.add(PublicVM);
                }

                userPublicCourses.add(publicCourse);


            };
            PublicUser publicStudent = new PublicUser();
            publicStudent.name = s.getName();
            publicStudent.username = s.getUsername();

            publicStudentCourseMap.put(publicStudent,userPublicCourses);
            searchStudentMap.put(s.getUsername(),publicStudent);
            emailStudentMap.put(s.getUsername(),s);
        };


        //todo should this move location?
        for(Instructor ins : instructors){
            List<Course> courses= ins.getCourses();
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
                    publicLab.id = lab.getLabID();
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
                publicCourse.publicStudentVmsMap = new HashMap<PublicUser, List<PublicVM>>(students.size());

                for(VM vm : c.getVMs()) {
                    PublicVM PublicVM = new PublicVM();
                    PublicVM.VMWareName = vm.getVMWareName();
                    PublicVM.publicNumber = vm.getPublicNumber();
                    PublicVM.name = vm.getName();
                    PublicVM.vmID = vm.getVmID();
                    PublicVM.VMWareNumber = vm.getVMWareNumber();
                    PublicVM.student = vm.getStudent();
                    PublicVM.instructor = vm.getInstructor();
                    PublicVM.studentId = vm.getStudent().studentID;
                    PublicVM.instructorId = vm.getInstructor().instructorID;
                    // id of 1 means that this is a instructor VM
                    if(PublicVM.studentId == 1){
                        PublicVM.username = vm.getInstructor().getFullName();
                        PublicVM.email = vm.getInstructor().getUsername();
                        // adds it to the instructor's vms
                        publicCourse.publicVms.add(PublicVM);
                    }
                    // id of 1 means that this is a student VM
                    else if(PublicVM.instructorId == 1){
                        PublicVM.username = vm.getStudent().getName();
                        PublicVM.email = vm.getStudent().getUsername();

                        // adds it to the students vms
                        if (!publicCourse.publicStudentVmsMap.containsKey(searchStudentMap.get(vm.getStudent().getUsername()))){
//                            PublicUser student = new PublicUser(emailStudentMap.get(vm.getStudent().getUsername()));
                            publicCourse.publicStudentVmsMap.put(searchStudentMap.get(vm.getStudent().getUsername()),new ArrayList<PublicVM>());
                            publicCourse.publicStudentVmsMap.get(searchStudentMap.get(vm.getStudent().getUsername())).add(PublicVM);
                        }else{
                            publicCourse.publicStudentVmsMap.get(searchStudentMap.get(vm.getStudent().getUsername())).add(PublicVM);
                        }

                    }
                }

                userPublicCourses.add(publicCourse);


            };
            PublicUser publicStudent = new PublicUser();
            publicStudent.name = ins.getFullName();
            publicStudent.username = ins.getUsername();

            publicInstructorCourseMap.put(publicStudent,userPublicCourses);
            searchInstructorMap.put(ins.getUsername(),publicStudent);
            emailInstructorMap.put(ins.getUsername(),ins);
        };
    }

    private void populateVmPublicIdAndVMWareNameMap(){
        vmPublicIdAndVMWareNameMap = new HashMap<Integer, String>();
        courses.forEach(c->{
            c.getVMs().forEach(vm->{
                vmPublicIdAndVMWareNameMap.put(vm.getVmID(), vm.getVMWareName());
            });
        });
    }

    @Override
    public String getVmRealName(int vmId){
        return vmPublicIdAndVMWareNameMap.get(vmId);
    }

    private PublicCourse castToPublicCourse(Course course){
        PublicCourse publicCourse = new PublicCourse();
        return null;
    }

    private PublicCourse castToPublicVM(VM vm){
        return null;
    }

    @Override
    public List<PublicCourse> getUserCourses(){

        // is student logged in
        if(searchStudentMap.containsKey(user.email)){
            List<PublicCourse> publicCourses = publicStudentCourseMap.get(searchStudentMap.get(user.email));
            // create a copy this object
            List<PublicCourse> filteredCourses = new ArrayList<PublicCourse>(publicCourses.size());
            publicCourses.forEach(c->{
                PublicCourse course = new PublicCourse();
                course.id = c.id;
                course.name = c.name;
                course.number = c.number;
                course.year = c.year;
                course.section = c.section;
                course.semester = c.semester;
                course.description = c.description;
                course.uniqueName = c.uniqueName;
                course.publicLabs = c.publicLabs;

                List<PublicVM> vms = new ArrayList<PublicVM>();
                //filter vm by user id - student only has access their vms (for each of the courses)
                c.publicVms.forEach(vm->{
                    if(vm.student.username.equals(user.email)){
                        vms.add(vm);
                    }
                });

                course.publicVms = vms;
                filteredCourses.add(course);
            });
            return filteredCourses;
        }

        // is instructor logged in - he needs access to all vms including their students (for each course )
        if(searchInstructorMap.containsKey(user.email)){
            return publicInstructorCourseMap.get(searchInstructorMap.get(user.email));
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
//            userType = "student";
//            userEmail = email;
//            userId = emailStudentMap.get(email).studentID;

            user.type = "student";
            user.email = email;
            user.id = emailStudentMap.get(email).studentID;
            user.name = emailStudentMap.get(email).name;

            return student;
        }
        return null ;
    }

    @Override
    public Instructor findInstructorByUsername(String email) {
        Instructor instructor = null;
        if(this.emailInstructorMap.containsKey(email)){
            instructor = emailInstructorMap.get(email);
//            userEmail = username;
//            userType = "instructor";
//            userId = emailInstructorMap.get(username).instructorID;

            user.type = "instructor";
            user.email = email;
            user.id = emailInstructorMap.get(email).instructorID;
            user.name = emailInstructorMap.get(email).fullName;

        }
        return instructor ;
    }

    @Override
    public String getUserType() {
        return user.type;
    }

    @Override
    public String getUserEmail() {
        return user.email;
    }

    @Override
    public int getUserId() {
        return user.id;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public PublicUser getStudentByEmail(String email) {
        return searchStudentMap.get(email);
    }

//    void createStudentsVmsForInstructors(){
//        Map<Student, PublicVM> studentVmMap = new HashMap<Student, PublicVM>();
//
//
//    }
}
