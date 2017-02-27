package service;

import javax.ejb.Remote;

/**
 * Created by ZhangYF on 2017/2/19.
 */
@Remote
public interface GeneratorService {
    public String getStudentid();
    public String getInstitutionid();
    public String getCourseid();
}
