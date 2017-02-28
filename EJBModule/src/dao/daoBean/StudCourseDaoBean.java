package dao.daoBean;

import dao.daoService.StudCourseDao;
import model.Course;
import model.StudCourse;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/28.
 */
@Stateless
public class StudCourseDaoBean implements StudCourseDao{

    @PersistenceContext
    protected EntityManager em;

    @Override
    public void addStudCourse(StudCourse studCourse) {
        em.persist(studCourse);
    }

    @Override
    public void updateStudCourse(StudCourse studCourse) {
        em.merge(studCourse);
    }

    @Override
    public void deleteStudCourse(StudCourse studCourse) {
        em.remove(studCourse);
    }

    @Override
    public void deleteStudCourse(String studentid, String courseid) {
        StudCourse studCourse = em.find(StudCourse.class,studentid+courseid);
        em.remove(studCourse);
    }

    @Override
    public StudCourse getStudCourse(String studentid, String courseid) {
        return em.find(StudCourse.class,studentid+courseid);
    }

    @Override
    public List<StudCourse> getReserveCoursesByStudentID(String studentid) {
        String jpql = "SELECT g FROM StudCourse g WHERE g.student.id = :studentid and g.state=0";
        Query query = em.createQuery(jpql);
        query.setParameter("studentid", studentid);//给参数设值
        List<StudCourse> list = query.getResultList();
        query.getResultList();
        return list;
    }

    @Override
    public List<StudCourse> getStudyCoursesByStudentID(String studentid) {
        String jpql = "SELECT g FROM StudCourse g WHERE g.student.id = :studentid and g.state=1";
        Query query = em.createQuery(jpql);
        query.setParameter("studentid", studentid);//给参数设值
        List<StudCourse> list = query.getResultList();
        query.getResultList();
        return list;
    }

    @Override
    public List<StudCourse> getChooseCourseByStudentID(String studentid) {
        String jpql = "SELECT g FROM StudCourse g WHERE g.student.id = :studentid and (g.state=0 or g.state=1)";
        Query query = em.createQuery(jpql);
        query.setParameter("studentid", studentid);//给参数设值
        List<StudCourse> list = query.getResultList();
        query.getResultList();
        return list;
    }

    @Override
    public List<StudCourse> getDropCoursesByStudentID(String studentid) {
        String jpql = "SELECT g FROM StudCourse g WHERE g.student.id = :studentid and g.state=2";
        Query query = em.createQuery(jpql);
        query.setParameter("studentid", studentid);//给参数设值
        List<StudCourse> list = query.getResultList();
        query.getResultList();
        return list;
    }

    @Override
    public List<Course> getUnchooseCoursesByStudentID(String studentid) {
        String jpql = "SELECT c FROM Course c WHERE c.id NOT IN (SELECT g.course.id FROM StudCourse g WHERE g.student.id = :studentid)";
        Query query = em.createQuery(jpql);
        query.setParameter("studentid", studentid);//给参数设值
        List<Course> list = query.getResultList();
        query.getResultList();
        return list;
    }
}
