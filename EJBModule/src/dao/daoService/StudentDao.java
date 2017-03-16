package dao.daoService;

import model.Student;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Zhang YF on 2016/12/19.
 */

@Remote
public interface StudentDao {
    public boolean checkPassword(String userid, String password);

    public void insert(Student student);

    public Student find(String studentid);

    public void update(Student student);

    public List<Student> getAllStudent();

}
