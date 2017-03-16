package service;

import model.Course;
import model.InstitutionStat;
import model.Manager;
import model.StudentStat;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/19.
 */
@Remote
public interface ManagerService {

    public boolean checkPassword(String managerid, String password);

    public Manager getManagetByID(String managetid);

    public List<Course> getApproveCourses();

    public List<Course> getSettleCourses();

    public boolean passCourse(String  courseid);

    public boolean denyCourse(String courseid);

    public boolean settleAccount(String courseid);

    public List<StudentStat> getStudentStat();

    public List<InstitutionStat> getInstitutionStat();

}
