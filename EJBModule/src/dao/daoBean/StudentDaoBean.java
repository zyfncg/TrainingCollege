package dao.daoBean;

import dao.daoService.StudentDao;
import model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Zhang YF on 2016/12/19.
 */

@Stateless
public class StudentDaoBean implements StudentDao {

//    private static DaoHelper daoHelper= DaoHelperImpl.getBaseDaoInstance();

    @PersistenceContext
    protected EntityManager em;

    @Override
    public boolean checkPassword(String studentid, String password) {
        boolean isValid = false;
        Student student = em.find(Student.class,studentid);
        isValid = password.equals(student.getPassword());

        return isValid;
    }

    @Override
    public void insert(Student student) {
        try {
            em.persist(student); //保存Entity到数据库中
        }catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public Student find(String studentid) {
        Student student = em.find(Student.class,studentid);
        return student;
    }

    @Override
    public void update(Student student) {
        em.merge(student);
    }


//    public Student getStudentById(String studentid){
//        Student student = em.find(Student.class,studentid);
//        return student;
//    }
}
