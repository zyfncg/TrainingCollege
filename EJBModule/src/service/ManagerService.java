package service;

import model.Course;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/19.
 */
@Remote
public interface ManagerService {

    public boolean checkPassword(String managerid, String password);

    public List<Course> getApproveCourses();

    public boolean passCourse(String  courseid);

    public boolean denyCourse(String courseid);

    public boolean settleAccount(String courseid);

}
