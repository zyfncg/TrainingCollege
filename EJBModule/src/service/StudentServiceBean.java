package service;

import dao.daoService.*;
import factory.EJBFactory;
import model.*;

import javax.ejb.Stateless;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by ZhangYF on 2017/1/24.
 */
@Stateless(name = "StudentServiceEJB")
public class StudentServiceBean implements StudentService {

    private String viewClassName = StudentDao.class.getName();
    private StudentDao studentDao = (StudentDao) EJBFactory.getEJB(
            "ejb:/EJBModule_ejb_exploded/StudentDaoBean!" + viewClassName);
    private AccountDao accountDao = (AccountDao) EJBFactory.getEJB(
            "ejb:/EJBModule_ejb_exploded/AccountDaoBean!"+AccountDao.class.getName());
    private BankcardDao bankcardDao = (BankcardDao) EJBFactory.getEJB(
            "ejb:/EJBModule_ejb_exploded/BankcardDaoBean!"+BankcardDao.class.getName());
    private StudCourseDao studCourseDao = (StudCourseDao) EJBFactory.getEJB(
            "ejb:/EJBModule_ejb_exploded/StudCourseDaoBean!"+StudCourseDao.class.getName());
    private CourseDao courseDao = (CourseDao) EJBFactory.getEJB(
            "ejb:/EJBModule_ejb_exploded/CourseDaoBean!"+CourseDao.class.getName());

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
    public boolean cancelVip(String studentid) {
        Student student = studentDao.find(studentid);
        student.setVip(-student.getVip());
        studentDao.update(student);
        return true;
    }

    @Override
    public boolean exchangePoint(String studentid) {
        Student student = studentDao.find(studentid);
        double point = student.getPoint()/10;
        Account account = student.getAccount();
        account.setMoney(account.getMoney() + point);
        student.setPoint(0);
        studentDao.update(student);
        return true;
    }

    @Override
    public boolean reserveCourse(String studentid, String courseid) {
        Student student = studentDao.find(studentid);
        Course course = courseDao.getCourseByID(courseid);
        Account account = student.getAccount();
        double money = account.getMoney();
        double price = course.getPrice();
        if(money > price){
            account.setMoney(money - price);
            course.setUnIncome(course.getUnIncome() + price);
            course.setReserveNum(course.getReserveNum() + 1);
            accountDao.update(account);
            courseDao.updata(course);

            String studCourid = studentid + courseid;
            StudCourse studCourse = new StudCourse();
            studCourse.setId(studCourid);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            studCourse.setScTime(Date.valueOf(df.format(new java.util.Date())));
            studCourse.setStudent(student);
            studCourse.setCourse(course);
            studCourse.setState(StudCourState.REVERSE);
            studCourseDao.addStudCourse(studCourse);
            if(student.getVip()>0){
                student.setPoint(student.getPoint()+ student.getVip()*price*0.1);
                studentDao.update(student);
            }
            return true;
        }else {
            return false;
        }


    }

    @Override
    public boolean studyCourse(String studentid, String courseid) {
        StudCourse studCourse = studCourseDao.getStudCourse(studentid,courseid);
        studCourse.setState(StudCourState.STUDY);
        Course course = studCourse.getCourse();
        studCourseDao.updateStudCourse(studCourse);
        return true;
    }

    @Override
    public boolean dropReserveCourse(String studentid, String courseid) {
        StudCourse studCourse = studCourseDao.getStudCourse(studentid,courseid);
        studCourse.setState(StudCourState.DROPREVERSE);
        Course course = studCourse.getCourse();
        course.setDropReserveNum(course.getDropReserveNum() + 1);
        Student student = studCourse.getStudent();
        Account account = student.getAccount();
        double price = course.getPrice();
        account.setMoney(account.getMoney() + price);
        course.setUnIncome(course.getUnIncome() - price);
        accountDao.update(account);
        courseDao.updata(course);
        studCourseDao.updateStudCourse(studCourse);
        return true;
    }

    @Override
    public boolean dropStudyCourse(String studentid, String courseid) {
        StudCourse studCourse = studCourseDao.getStudCourse(studentid,courseid);
        studCourse.setState(StudCourState.DROP);
        studCourseDao.updateStudCourse(studCourse);
        return true;
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
        if(bankcard != null && bankcard.getBalance() > money){
            bankcardDao.withdraw(bankcard.getBankcardid(),money);
            accountDao.deposit(account.getAccountid(),money);
            student = studentDao.find(studentid);
            double balance = student.getAccount().getMoney();
            if(student.getVip() == 0 && balance >= 1000){
                student.setVip(1);
            }else if(student.getVip()<0 && balance>0){
                student.setVip(0-student.getVip());
            }
            studentDao.update(student);
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
