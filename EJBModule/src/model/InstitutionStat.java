package model;

import java.io.Serializable;

/**
 * Created by ZhangYF on 2017/3/14.
 */
public class InstitutionStat implements Serializable{
    private String institutionid;
    private String institutionName;
    private int courseNum;
    private int studentNum;
    private int dropNum;

    public String getInstitutionid() {
        return institutionid;
    }

    public void setInstitutionid(String institutionid) {
        this.institutionid = institutionid;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public int getDropNum() {
        return dropNum;
    }

    public void setDropNum(int dropNum) {
        this.dropNum = dropNum;
    }
}
