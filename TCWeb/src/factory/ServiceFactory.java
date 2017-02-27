package factory;


import service.GeneratorService;
import service.StudentService;

/**
 * Created by ZhangYF on 2017/2/6.
 */
public class ServiceFactory {
    public static StudentService getStudentService(){
        final String appName = "";
        final String moduleName = "EJBModule_ejb_exploded";
        final String distinctName = "";
        final String beanName = "StudentServiceEJB";
        final String viewClassName = StudentService.class.getName();
        final String namespace = "ejb:" + appName + "/" + moduleName
                + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        System.out.println(namespace);
        StudentService studentService = (StudentService)EJBFactory.getEJB(namespace);
        return studentService;
    }

    public static GeneratorService getGeneratorService(){
        final String appName = "";
        final String moduleName = "EJBModule_ejb_exploded";
        final String distinctName = "";
        final String beanName = "GeneratorServiceBean";
        final String viewClassName = GeneratorService.class.getName();
        final String namespace = "ejb:" + appName + "/" + moduleName
                + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        System.out.println(namespace);
        GeneratorService generatorService = (GeneratorService) EJBFactory.getEJB(namespace);
        return generatorService;
    }
}
