package dao.daoBean;

import dao.daoService.InstitutionDao;
import model.Institution;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ZhangYF on 2017/2/19.
 */
@Stateless
public class InstitutionDaoBean implements InstitutionDao {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public boolean checkPassword(String institutionid, String password) {
        boolean isValid;
        Institution institution = em.find(Institution.class,institutionid);
        System.out.println(institution.getClass().getName());
        isValid = password.equals(institution.getPassword());
        return isValid;
    }
}
