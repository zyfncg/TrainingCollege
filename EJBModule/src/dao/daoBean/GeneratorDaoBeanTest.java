package dao.daoBean;

import dao.daoService.GeneratorDao;
import factory.EJBFactory;
import model.GeneratorBean;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ZhangYF on 2017/2/19.
 */
public class GeneratorDaoBeanTest {

    private String viewClassName = GeneratorDao.class.getName();
    private GeneratorDao generatorDao = (GeneratorDao) EJBFactory.getEJB("ejb:/EJBModule_ejb_exploded/GeneratorDaoBean!" + viewClassName);
    @Test
    public void getGenerator() throws Exception {
        GeneratorBean generatorBean = generatorDao.getGenerator();
        System.out.println(generatorBean.getStudentid());
    }

    @Test
    public void save() throws Exception {

    }

}