package dao.daoBean;

import dao.daoService.CourseDao;
import factory.EJBFactory;
import model.Course;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ZhangYF on 2017/2/19.
 */
public class CourseDaoBeanTest {

    private String viewClassName = CourseDao.class.getName();
    private CourseDao courseDao = (CourseDao) EJBFactory.getEJB("ejb:/EJBModule_ejb_exploded/CourseDaoBean!" + viewClassName);

    @Test
    public void getCoursesByStudentID() throws Exception {

    }

    @Test
    public void getAllCourses() throws Exception {
        List<Course> list = courseDao.getAllCourses();
        System.out.println(list.size());
    }

}