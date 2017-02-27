package factory;


import model.Course;
import org.junit.Test;
import service.StudentService;

import java.util.List;

/**
 * Created by ZhangYF on 2017/2/7.
 */
public class ServiceFactoryTest {
    @Test
    public void getStudentService() throws Exception {
        StudentService studentService = ServiceFactory.getStudentService();
        System.out.println(studentService.checkPassword("1234567","123456"));
        List<Course> list = studentService.getAllCourses();
        System.out.println(list.size());
    }

}