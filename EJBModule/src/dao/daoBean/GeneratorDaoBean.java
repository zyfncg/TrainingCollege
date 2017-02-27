package dao.daoBean;

import dao.daoService.GeneratorDao;
import model.GeneratorBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ZhangYF on 2017/2/19.
 */
@Stateless
public class GeneratorDaoBean implements GeneratorDao{

    @PersistenceContext
    protected EntityManager em;

    @Override
    public GeneratorBean getGenerator() {
        GeneratorBean generatorBean = em.find(GeneratorBean.class,"000");
        return generatorBean;
    }

    @Override
    public void save(GeneratorBean generatorBean) {
        em.merge(generatorBean);
    }
}
