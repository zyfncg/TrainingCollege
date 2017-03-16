package service;

import dao.daoService.GeneratorDao;
import factory.EJBFactory;
import model.GeneratorBean;

import javax.ejb.Stateless;

/**
 * Created by ZhangYF on 2017/2/19.
 */
@Stateless
public class GeneratorServiceBean implements GeneratorService{

    private String viewClassName = GeneratorDao.class.getName();
    private GeneratorDao generatorDao = (GeneratorDao) EJBFactory.getEJB("ejb:/EJBModule_ejb_exploded/GeneratorDaoBean!" + viewClassName);

    @Override
    public String getStudentid() {
        GeneratorBean generatorBean = generatorDao.getGenerator();
        String studentid = generatorBean.getStudentid();
        Long student = Long.parseLong(studentid) + 1;
        generatorBean.setStudentid(String.valueOf(student));
        generatorDao.save(generatorBean);
        return studentid;
    }

    @Override
    public String getInstitutionid() {
        GeneratorBean generatorBean = generatorDao.getGenerator();
        String institutionid = generatorBean.getInstitutionid();
        Long institution = Long.parseLong(institutionid) + 1;
        generatorBean.setInstitutionid(String.valueOf(institution));
        generatorDao.save(generatorBean);
        return institutionid;
    }

    @Override
    public String getCourseid() {
        GeneratorBean generatorBean = generatorDao.getGenerator();
        String courseid = generatorBean.getCourseid();
        Long course = Long.parseLong(courseid) + 1;
        generatorBean.setCourseid(String.valueOf(course));
        generatorDao.save(generatorBean);
        return courseid;
    }
}
