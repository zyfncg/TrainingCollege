package dao.daoService;

import model.Manager;

import javax.ejb.Remote;

/**
 * Created by ZhangYF on 2017/2/19.
 */
@Remote
public interface ManagerDao {
    public boolean checkPassword(String managerid, String password);

    public boolean update(Manager manager);

    public Manager find(String managerid);

}
