package service;

import factory.EJBFactory;
import org.junit.Test;

/**
 * Created by ZhangYF on 2017/2/19.
 */
public class GeneratorBeanServiceBeanTest {
    @Test
    public void getStudentid() throws Exception {
        GeneratorService generatorService = (GeneratorService) EJBFactory.getEJB(
                "ejb:/EJBModule_ejb_exploded//GeneratorServiceBean!service.GeneratorService");
        System.out.println(generatorService.getStudentid());

    }

}