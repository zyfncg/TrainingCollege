package model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/18.
 */
@Entity
@Table(name = "course")
public class Course implements Serializable{
    private String courseID;
    private String courseName;
    private Date startTime;
    private Date endTime;
    private String teacher;
    private Institution institution;
    private double price;
    private int approveState;
    private int reserveNum;
    private int dropReserveNum;
    private int dropNum;
    private double income;
    private double unIncome;
    private List<Student> students;

    @Id
    @Column(name = "courseid")
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    @Column(name = "coursename")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String coursename) {
        this.courseName = coursename;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Column(name = "endTime")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "institutionid")
    @NotFound(action= NotFoundAction.IGNORE)
    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getApproveState() {
        return approveState;
    }

    public void setApproveState(int approveState) {
        this.approveState = approveState;
    }

    public int getReserveNum() {
        return reserveNum;
    }

    public void setReserveNum(int reserveNum) {
        this.reserveNum = reserveNum;
    }

    public int getDropReserveNum() {
        return dropReserveNum;
    }

    public void setDropReserveNum(int dropReserveNum) {
        this.dropReserveNum = dropReserveNum;
    }

    public int getDropNum() {
        return dropNum;
    }

    public void setDropNum(int dropNum) {
        this.dropNum = dropNum;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getUnIncome() {
        return unIncome;
    }

    public void setUnIncome(double unIncome) {
        this.unIncome = unIncome;
    }

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "stud_cour",
            joinColumns = @JoinColumn(name = "courseid"),
            inverseJoinColumns = @JoinColumn(name = "studentid")
    )
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
