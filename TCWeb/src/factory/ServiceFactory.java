package factory;


import service.*;

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

    public static InstitutionService getInstitutionService(){
        final String appName = "";
        final String moduleName = "EJBModule_ejb_exploded";
        final String distinctName = "";
        final String beanName = "InstitutionServiceBean";
        final String viewClassName = InstitutionService.class.getName();
        final String namespace = "ejb:" + appName + "/" + moduleName
                + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        System.out.println(namespace);
        InstitutionService institutionService = (InstitutionService)EJBFactory.getEJB(namespace);
        return institutionService;
    }

    public static ManagerService getManagerService(){
        final String appName = "";
        final String moduleName = "EJBModule_ejb_exploded";
        final String distinctName = "";
        final String beanName = "ManagerServiceBean";
        final String viewClassName = ManagerService.class.getName();
        final String namespace = "ejb:" + appName + "/" + moduleName
                + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        System.out.println(namespace);
        ManagerService managerService = (ManagerService)EJBFactory.getEJB(namespace);
        return managerService;
    }

    public static AuthorizeService getAuthorizeService(){
        final String appName = "";
        final String moduleName = "EJBModule_ejb_exploded";
        final String distinctName = "";
        final String beanName = "AuthorizeServiceBean";
        final String viewClassName = AuthorizeService.class.getName();
        final String namespace = "ejb:" + appName + "/" + moduleName
                + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        System.out.println(namespace);
        AuthorizeService authorizeService = (AuthorizeService)EJBFactory.getEJB(namespace);
        return authorizeService;
    }
}
