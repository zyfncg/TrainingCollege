package dao.daoBean;

import dao.daoService.InstitutionDao;
import model.Institution;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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

    @Override
    public void insert(Institution institution) {
        em.persist(institution);
    }

    @Override
    public Institution find(String institutionid) {
        Institution institution = em.find(Institution.class, institutionid);
        return institution;
    }

    @Override
    public void update(Institution institution) {
        em.merge(institution);
    }

    @Override
    public List<Institution> getAllInstitution() {
        String jpql = "SELECT i FROM Institution i";
        Query query = em.createQuery(jpql);
        List<Institution> list = query.getResultList();
        return list;
    }
}
