package service;

import factory.EJBFactory;
import org.junit.Test;

/**
 * Created by ZhangYF on 2017/2/14.
 */
public class StudentServiceBeanTest {

    @Test
    public void checkPassword() throws Exception {
        StudentService studentService = (StudentService) EJBFactory.getEJB(
                "ejb:/EJBModule_ejb_exploded//StudentServiceEJB!service.StudentService");
        System.out.println(studentService.checkPassword("1234567","123456"));
    }
    @Test
    public void getAllCourses() throws Exception{
        StudentService studentService = (StudentService) EJBFactory.getEJB(
                "ejb:/EJBModule_ejb_exploded//StudentServiceEJB!service.StudentService");
        System.out.println(studentService.getAllCourses().size());
    }

}