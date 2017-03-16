package dao.daoBean;

import dao.daoService.ManagerDao;
import model.Manager;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ZhangYF on 2017/3/8.
 */
@Stateless(name = "ManagerDaoBean")
public class ManagerDaoBean implements ManagerDao{
    @PersistenceContext
    protected EntityManager em;
    public ManagerDaoBean() {
    }

    @Override
    public boolean checkPassword(String managerid, String password) {
        Manager manager = em.find(Manager.class, managerid);
        if(manager != null){
            if(password.equals(manager.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(Manager manager) {
        em.merge(manager);
        return true;
    }

    @Override
    public Manager find(String managerid) {
        Manager manager = em.find(Manager.class, managerid);
        return manager;
    }
}
