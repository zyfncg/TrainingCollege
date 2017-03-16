package service;

import dao.daoService.*;
import factory.EJBFactory;
import model.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangYF on 2017/3/8.
 */
@Stateless
public class ManagerServiceBean implements ManagerService{

    private CourseDao courseDao = (CourseDao) EJBFactory.getEJB(
            "ejb:/EJBModule_ejb_exploded/CourseDaoBean!"+CourseDao.class.getName());
    private ManagerDao managerDao = (ManagerDao) EJBFactory.getEJB(
            "ejb:/EJBModule_ejb_exploded/ManagerDaoBean!"+ManagerDao.class.getName());

    @EJB
    private StudentDao studentDao;

    @EJB
    private InstitutionDao institutionDao;

    @EJB
    private StudCourseDao studCourseDao;

    @EJB
    private AccountDao accountDao;

    @Override
    public boolean checkPassword(String managerid, String password) {
        return managerDao.checkPassword(managerid, password);
    }

    @Override
    public Manager getManagetByID(String managetid) {
        return managerDao.find(managetid);
    }

    @Override
    public List<Course> getApproveCourses() {
        List<Course> courseList = courseDao.getUnapproveCourse();
        return courseList;
    }

    @Override
    public List<Course> getSettleCourses() {
        return courseDao.getCourseByState(2);
    }

    @Override
    public boolean passCourse(String courseid) {
        Course course = courseDao.getCourseByID(courseid);
        course.setApproveState(1);
        courseDao.updata(course);
        return true;
    }

    @Override
    public boolean denyCourse(String courseid) {
        Course course = courseDao.getCourseByID(courseid);
        course.setApproveState(-1);
        courseDao.updata(course);
        return true;
    }

    @Override
    public boolean settleAccount(String courseid) {
        Course course = courseDao.getCourseByID(courseid);
        double money = course.getUnIncome();
        course.setIncome(money);
        course.setUnIncome(0);
        course.setApproveState(3);
        courseDao.updata(course);

        Institution institution = institutionDao.find(course.getInstitution().getInstitutionid());
        Account account = institution.getAccount();
        account.setMoney(account.getMoney()+money);
        accountDao.update(account);
        return true;
    }

    @Override
    public List<StudentStat> getStudentStat() {
        List<StudentStat> list = new ArrayList<>();
        List<Student> studentList = studentDao.getAllStudent();
        for(Student student:studentList){
            String studentid = student.getStudentid();
            List<Course> courseList = student.getCourses();
            int finishNum = 0;
            int reserveNum = 0;
            int studyNum = 0;
            int dropNum = 0;
            if(courseList != null){
                for(Course course : courseList){
                    String courseid = course.getCourseID();
                    StudCourse studCourse = studCourseDao.getStudCourse(studentid,courseid);
                    switch (studCourse.getState()){
                        case StudCourState.REVERSE:
                            reserveNum++;break;
                        case StudCourState.STUDY:
                            studyNum++;break;
                        case StudCourState.ENDSTUDY:
                            finishNum++;break;
                        case StudCourState.DROP:
                            dropNum++;
                        default:
                            break;
                    }
                }
            }
            StudentStat studentStat = new StudentStat();
            studentStat.setStudentid(studentid);
            studentStat.setStudentName(student.getName());
            studentStat.setFinishNum(finishNum);
            studentStat.setReserveNum(reserveNum);
            studentStat.setStudyNum(studyNum);
            studentStat.setDropNum(dropNum);
            list.add(studentStat);
        }
        return list;
    }

    @Override
    public List<InstitutionStat> getInstitutionStat() {
        List<InstitutionStat> list = new ArrayList<>();
        List<Institution> institutionList = institutionDao.getAllInstitution();
        for(Institution institution:institutionList){
            int courseNum = 0;
            int studentNum = 0;
            int dropNum = 0;
            InstitutionStat institutionStat = new InstitutionStat();
            List<Course> courseList = institution.getCourses();
            if(courseList != null){
                courseNum = courseList.size();
                for(Course course: courseList){
                    studentNum = studentNum + course.getReserveNum() - course.getDropReserveNum() - course.getDropNum();
                    dropNum = dropNum + course.getDropNum();
                }

            }
            institutionStat.setInstitutionid(institution.getInstitutionid());
            institutionStat.setInstitutionName(institution.getName());
            institutionStat.setCourseNum(courseNum);
            institutionStat.setStudentNum(studentNum);
            institutionStat.setDropNum(dropNum);
            list.add(institutionStat);
        }
        return list;
    }
}
