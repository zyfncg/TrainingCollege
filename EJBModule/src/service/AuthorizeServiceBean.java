package service;

import dao.daoService.InstitutionDao;
import dao.daoService.ManagerDao;
import dao.daoService.StudentDao;
import model.AuthorUser;
import model.Institution;
import model.Manager;
import model.Student;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by ZhangYF on 2017/3/15.
 */
@Stateless
public class AuthorizeServiceBean implements AuthorizeService{

    @EJB
    private StudentDao studentDao;

    @EJB
    private InstitutionDao institutionDao;

    @EJB
    private ManagerDao managerDao;

    @Override
    public AuthorUser getUserByID(String userid) {
        Student student = studentDao.find(userid);
        if(student != null){
            AuthorUser authorUser = new AuthorUser();
            authorUser.setUserid(userid);
            authorUser.setPassword(student.getPassword());
            authorUser.setRole(AuthorUser.STUDENT);
            return authorUser;
        }
        Institution institution = institutionDao.find(userid);
        if(institution != null){
            AuthorUser authorUser = new AuthorUser();
            authorUser.setUserid(userid);
            authorUser.setPassword(institution.getPassword());
            authorUser.setRole(AuthorUser.INSTITUTION);
            return authorUser;
        }
        Manager manager = managerDao.find(userid);
        if(manager != null){
            AuthorUser authorUser = new AuthorUser();
            authorUser.setUserid(userid);
            authorUser.setPassword(manager.getPassword());
            authorUser.setRole(AuthorUser.MANAGER);
            return authorUser;
        }
        return null;
    }
}
