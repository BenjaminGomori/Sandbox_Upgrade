package com.enterprise.sandboxupgrade.service;
import com.enterprise.sandboxupgrade.dto.*;
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

    // not sharable (with user) - original data
    private List<Course> courses;
    private List<Instructor> instructors;
    private List<Student> students;

    // is sharable - altered data
    private Map<PublicUser, List<PublicCourse>> publicInstructorCourseMap;
    private Map<PublicUser, List<PublicVM>> publicInstructorVMsMap;
    private Map<PublicUser, List<PublicCourse>> publicStudentCourseMap;
    private Map<PublicUser, List<PublicVM>> publicStudentVMsMap;

    // Useful for searching which student relates to which courses
    // String - User Email only (the nested map will be shared and has Public user as key which includes name && email)
    private Map<String, PublicUser> searchStudentCourseMap;

    @Override
    public void getStarted() throws Exception {
        // Get all courses
        fetchAllCoursesFromDB();
        fetchAllInstructorsFromDB();
        fetchAllStudentsFromDB();
        // Will be provided to frontend
        createUserPublicCoursesAndVMsMap();
    }

    private void fetchAllCoursesFromDB() throws Exception {
        courses = new ArrayList<>();
        courses = courseService.fetchAll();
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
                    publicCourse.publicLabs.add(publicLab);
                }

                userPublicCourses.add(publicCourse);
            };
            PublicUser publicStudent = new PublicUser();
            publicStudent.lastName = s.getLastName();
            publicStudent.firstname = s.getFirstname();
            publicStudent.email = s.getEmail();

            publicStudentCourseMap.put(publicStudent,userPublicCourses);
            searchStudentCourseMap.put(s.getEmail(),publicStudent);
        };

//        instructors.forEach(i->{
//            i.getCourses().forEach(c->{
//                userPublicCourses.add(c);
//            });
//            publicInstructorCourseMap.put(i,userPublicCourses);
//            userPublicCourses.clear();
//        });
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
}
