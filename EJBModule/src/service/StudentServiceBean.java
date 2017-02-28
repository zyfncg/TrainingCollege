package service;

import dao.daoService.CourseDao;
import dao.daoService.StudentDao;
import factory.EJBFactory;
import model.Course;
import model.Student;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangYF on 2017/1/24.
 */
@Stateless(name = "StudentServiceEJB")
public class StudentServiceBean implements StudentService {

    private String viewClassName = StudentDao.class.getName();
    private StudentDao studentDao = (StudentDao) EJBFactory.getEJB("ejb:/EJBModule_ejb_exploded/StudentDaoBean!" + viewClassName);

    private CourseDao courseDao = (CourseDao) EJBFactory.getEJB("ejb:/EJBModule_ejb_exploded/CourseDaoBean!"+CourseDao.class.getName());

    @Override
    public boolean checkPassword(String studentid, String password) {
        System.out.print("check password");
        return studentDao.checkPassword(studentid,password);
//        return true;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = courseDao.getAllCourses();
        return courses;
    }

    @Override
    public List<Course> getUnchooseCourses(String studendid) {
        return null;
    }

    //
    //    public List<Course> getReserveCourses(String studentid);
    //
    @Override
    public List<Course> getStudyCourses(String studentid) {
        Student student = studentDao.find(studentid);
        List<Course> courseList = student.getCourses();
        List<Course> studyingCourse = new ArrayList<>();
        List<Course> reserveCourse = new ArrayList<>();
        //TODO
        return null;
    }

    @Override
    public List<Course> getReserveCourses(String studentid) {
        return null;
    }

    @Override
    public Student getStudentByID(String studentid) {
        Student student = studentDao.find(studentid);
        return student;
    }

    @Override
    public void register(Student student) {
        studentDao.insert(student);
    }
}
