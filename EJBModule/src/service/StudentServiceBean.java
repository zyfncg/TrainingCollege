package service;

import dao.daoService.*;
import factory.EJBFactory;
import model.*;

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
    private AccountDao accountDao = (AccountDao) EJBFactory.getEJB(
            "ejb:/EJBModule_ejb_exploded/AccountDaoBean!"+AccountDao.class.getName());
    private BankcardDao bankcardDao = (BankcardDao) EJBFactory.getEJB(
            "ejb:/EJBModule_ejb_exploded/BankcardDaoBean!"+BankcardDao.class.getName());
    private StudCourseDao studCourseDao = (StudCourseDao) EJBFactory.getEJB(
            "ejb:/EJBModule_ejb_exploded/StudCourseDaoBean!"+StudCourseDao.class.getName());

    @Override
    public boolean checkPassword(String studentid, String password) {
        System.out.print("check password");
        return studentDao.checkPassword(studentid,password);
//        return true;
    }

    @Override
    public List<Course> getAllCourses() {
       return null;
    }

    @Override
    public List<Course> getUnchooseCourses(String studendid) {

        List<Course> courseList = studCourseDao.getUnchooseCoursesByStudentID(studendid);
        return courseList;
    }


    @Override
    public List<StudCourse> getStudyCourses(String studentid) {

        List<StudCourse> courseList = studCourseDao.getStudyCoursesByStudentID(studentid);

        return courseList;
    }

    @Override
    public List<StudCourse> getReserveCourses(String studentid) {
        List<StudCourse> courseList = studCourseDao.getReserveCoursesByStudentID(studentid);
        return courseList;
    }

    @Override
    public List<StudCourse> getDropCourses(String studentid) {
        List<StudCourse> courseList = studCourseDao.getDropCoursesByStudentID(studentid);
        return courseList;
    }

    @Override
    public Student getStudentByID(String studentid) {
        Student student = studentDao.find(studentid);
        return student;
    }

    @Override
    public void reserveCourse(String studentid, String courseid) {

    }

    @Override
    public void studyCourse(String studentid, String courseid) {

    }

    @Override
    public void dropReserveCourse(String studentid, String courseid) {

    }

    @Override
    public void dropStudyCourse(String studentid, String courseid) {

    }

    @Override
    public boolean bindBankcard(String studentid, String bankcardid) {
        if(bankcardDao.isExist(bankcardid)){
            Student student = studentDao.find(studentid);
            Account account = student.getAccount();
            account.setBankcardid(bankcardid);
            accountDao.update(account);
        }else{
            return false;
        }

        return true;
    }

    @Override
    public boolean deposit(String studentid, double money) {
        Student student = studentDao.find(studentid);
        Account account = student.getAccount();
        Bankcard bankcard = bankcardDao.find(account.getBankcardid());
        if(bankcard.getBalance() > money){
            bankcardDao.withdraw(bankcard.getBankcardid(),money);
            accountDao.deposit(account.getAccountid(),money);
        }else {
            return false;
        }
        return true;
    }

    @Override
    public boolean register(Student student) {
        Account account = new Account();
        account.setAccountid(student.getStudentid());
        account.setMoney(0);
        student.setAccount(account);
        studentDao.insert(student);
        return true;
    }
}
