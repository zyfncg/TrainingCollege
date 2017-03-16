package service;

import dao.daoService.AccountDao;
import dao.daoService.CourseDao;
import dao.daoService.InstitutionDao;
import dao.daoService.StudCourseDao;
import factory.EJBFactory;
import model.Account;
import model.Course;
import model.Institution;
import model.StudCourse;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ZhangYF on 2017/3/6.
 */
@Stateless
public class InstitutionServiceBean implements InstitutionService{

    private InstitutionDao institutionDao = (InstitutionDao) EJBFactory.getEJB(
            "ejb:/EJBModule_ejb_exploded/InstitutionDaoBean!"+InstitutionDao.class.getName());
    private AccountDao accountDao = (AccountDao) EJBFactory.getEJB(
            "ejb:/EJBModule_ejb_exploded/AccountDaoBean!"+AccountDao.class.getName());
    private CourseDao courseDao = (CourseDao) EJBFactory.getEJB(
            "ejb:/EJBModule_ejb_exploded/CourseDaoBean!"+CourseDao.class.getName());
    private StudCourseDao studCourseDao = (StudCourseDao) EJBFactory.getEJB(
            "ejb:/EJBModule_ejb_exploded/StudCourseDaoBean!"+StudCourseDao.class.getName());

    @Override
    public boolean register(Institution institution) {
        Account account = new Account();
        account.setAccountid(institution.getInstitutionid());
        account.setMoney(0);
        institution.setAccount(account);
        institutionDao.insert(institution);
        return true;
    }

    @Override
    public boolean checkPassword(String institutionid, String password) {
        Institution institution = institutionDao.find(institutionid);
        if(institution != null){
            if(password.equals(institution.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Institution getInstitutionByID(String institutionid) {
        Institution institution = institutionDao.find(institutionid);
        return institution;
    }

    @Override
    public boolean createCourse(Course course) {
        courseDao.add(course);
        return true;
    }

    @Override
    public boolean updateCourse(Course course) {
        courseDao.updata(course);
        return true;
    }

    @Override
    public List<Course> getCourseByInstitution(String institutionid) {
        Institution institution = institutionDao.find(institutionid);
        List<Course> courses = institution.getCourses();
        return courses;
    }

    @Override
    public List<StudCourse> getStudCoursesByCourseID(String courseid) {
        List<StudCourse> studCourseList = studCourseDao.getCoursesByCourseID(courseid);
        return studCourseList;
    }

    @Override
    public Course getCourseByID(String courseid) {
        return courseDao.getCourseByID(courseid);
    }

    @Override
    public void saveGrades(List<StudCourse> list) {
        for(StudCourse studCourse:list){
            studCourseDao.updateStudCourse(studCourse);
        }
    }

    @Override
    public StudCourse getStudCourse(String studentid, String courseid) {
        return studCourseDao.getStudCourse(studentid, courseid);
    }
}
