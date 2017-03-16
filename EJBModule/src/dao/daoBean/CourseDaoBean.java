package dao.daoBean;

import dao.daoService.CourseDao;
import model.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/19.
 */
@Stateless
public class CourseDaoBean implements CourseDao{

    @PersistenceContext
    protected EntityManager em;

    @Override
    public void add(Course course) {
        em.persist(course);
    }

    @Override
    public void updata(Course course) {
        em.merge(course);
    }

    @Override
    public void delete(Course course) {
        em.remove(course);
    }

    @Override
    public void delete(String courseid) {
        Course course = em.find(Course.class,courseid);
        em.remove(course);
    }

    @Override
    public Course getCourseByID(String courseid) {
        if(courseid == null){
            return null;
        }
        Course course = em.find(Course.class,courseid);
        return course;
    }

    @Override
    public List<Course> getCoursesByInstitutionID(String institutionid) {
        String jpql = "SELECT c FROM Course c WHERE c.institution.id = :institutionid";
        Query query = em.createQuery(jpql);
        query.setParameter("institutionid",institutionid);
        List<Course> courseList = query.getResultList();
        return courseList;
    }

    @Override
    public List<Course> getAllCourses() {
        String jpql = "SELECT c FROM Course c";
        Query query = em.createQuery(jpql);
        List<Course> courseList = query.getResultList();
        return courseList;
    }

    @Override
    public List<Course> getCourseByState(int state) {
        String jpql = "SELECT c FROM Course c WHERE c.approveState = :state";
        Query query = em.createQuery(jpql);
        query.setParameter("state",state);
        List<Course> courseList = query.getResultList();
        return courseList;
    }

    @Override
    public List<Course> getUnapproveCourse() {
        String jpql = "SELECT c FROM Course c WHERE c.approveState = 0";
        Query query = em.createQuery(jpql);
        List<Course> courseList = query.getResultList();
        return courseList;
    }


}
