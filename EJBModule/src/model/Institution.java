package model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/18.
 */
@Entity
@Table(name = "institution")
public class Institution implements Serializable{
    private String institutionid;
    private String name;
    private String password;
    private Account account;
    private List<Course> courses;

    @Id
    @Column(name = "institutionid")
    public String getInstitutionid() {
        return institutionid;
    }

    public void setInstitutionid(String institutionid) {
        this.institutionid = institutionid;
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
    @JoinColumn(name = "accountid")
    @NotFound(action= NotFoundAction.IGNORE)
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @OneToMany(mappedBy = "institution",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courseList) {
        this.courses = courseList;
    }
}
