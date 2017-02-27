package dao.daoBean;

import dao.daoService.InstitutionDao;
import factory.EJBFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ZhangYF on 2017/2/19.
 */
public class InstitutionDaoBeanTest {

    private String viewClassName = InstitutionDao.class.getName();
    private InstitutionDao institutionDao = (InstitutionDao) EJBFactory.getEJB("ejb:/EJBModule_ejb_exploded/InstitutionDaoBean!" + viewClassName);

    @Test
    public void checkPassword() throws Exception {
        if(institutionDao.checkPassword("9000001","123456")){
            System.out.println("instittution pw is right");
        }else {
            System.out.println("instittution pw is wrong");
        }
    }

}