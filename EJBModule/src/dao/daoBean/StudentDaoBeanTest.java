package dao.daoBean;

import dao.daoService.StudentDao;
import factory.EJBFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ZhangYF on 2017/2/7.
 */
public class StudentDaoBeanTest {
    private String viewClassName = StudentDao.class.getName();
    private StudentDao studentDao = (StudentDao) EJBFactory.getEJB("ejb:/EJBModule_ejb_exploded/StudentDaoBean!" + viewClassName);

    @Test
    public void checkPassword() throws Exception {
        System.out.println(studentDao.checkPassword("1234567","123456"));
    }

}