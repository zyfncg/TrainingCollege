package model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/9.
 */
@Entity
@Table(name = "student")
public class Student implements Serializable{
    private String studentid;
    private String name;
    private String password;
    private Account account;
    private int vip;
    private double point;

    private List<Course> courses;

    @Id
    @Column(name = "studentid")
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "accountid" )
    @NotFound(action= NotFoundAction.IGNORE)
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Column(name = "vip")
    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    @Column(name = "point")
    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @ManyToMany(mappedBy = "students")
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courseList) {
        this.courses = courseList;
    }
}
