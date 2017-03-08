package service;

import model.Course;
import model.Institution;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/19.
 */
@Remote
public interface InstitutionService {

    public boolean register(Institution institution);

    public boolean checkPassword(String institutionid, String password);

    public Institution getInstitutionByID(String institutionid);

    public boolean createCourse(Course course);

    public List<Course> getCourseByInstitution(String institution);


}
