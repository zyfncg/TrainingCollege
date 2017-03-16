package model;

import java.io.Serializable;

/**
 * Created by ZhangYF on 2017/3/14.
 */
public class StudentStat implements Serializable{
    private String studentid;
    private String studentName;
    private int finishNum;
    private int reserveNum;
    private int studyNum;
    private int dropNum;

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(int finishNum) {
        this.finishNum = finishNum;
    }

    public int getReserveNum() {
        return reserveNum;
    }

    public void setReserveNum(int reserveNum) {
        this.reserveNum = reserveNum;
    }

    public int getStudyNum() {
        return studyNum;
    }

    public void setStudyNum(int studyNum) {
        this.studyNum = studyNum;
    }

    public int getDropNum() {
        return dropNum;
    }

    public void setDropNum(int dropNum) {
        this.dropNum = dropNum;
    }
}
