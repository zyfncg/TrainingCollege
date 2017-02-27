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
}
