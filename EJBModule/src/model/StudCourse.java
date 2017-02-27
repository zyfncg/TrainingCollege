package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by ZhangYF on 2017/2/18.
 */
@Entity
@Table(name = "stud_cour")
public class StudCourse implements Serializable{
    private String id;
    private Date scTime;
    private Double grade;
    private int state;
    private Student student;
    private Course course;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getScTime() {
        return scTime;
    }

    public void setScTime(Date scTime) {
        this.scTime = scTime;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "studentid")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "courseid")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
