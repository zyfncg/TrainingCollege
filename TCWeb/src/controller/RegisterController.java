package controller;

import factory.ServiceFactory;
import model.Institution;
import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.GeneratorService;
import service.InstitutionService;
import service.StudentService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZhangYF on 2017/2/16.
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    private GeneratorService generatorService = ServiceFactory.getGeneratorService();

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String getStudentRegisterPage(HttpServletRequest request, ModelMap model){
        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
        String studentid = generatorService.getStudentid();
        model.addAttribute("contextPath",contextpath);
        model.addAttribute("actionURL",contextpath+"/register/registerStudent");
        model.addAttribute("studentid", studentid);
        return "register/studentRegister";
    }

    @RequestMapping(value = "/registerStudent", method = RequestMethod.POST)
    public String studentRegister(HttpServletRequest request, ModelMap model){
        String studentid = request.getParameter("studentid");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Student student = new Student();
        student.setStudentid(studentid);
        student.setName(name);
        student.setPassword(password);

        StudentService studentService = ServiceFactory.getStudentService();
        studentService.register(student);
        return "redirect:/login/student";
    }

    @RequestMapping(value = "/institution")
    public String getInstitutionRegisterPage(HttpServletRequest request, ModelMap model){
        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
        model.addAttribute("contextPath",contextpath);
        model.addAttribute("actionURL",contextpath+"/register/registerInstitution");
        String institutionid = generatorService.getInstitutionid();
        model.addAttribute("institutionid", institutionid);
        return "register/institutionRegister";
    }

    @RequestMapping(value = "/registerInstitution")
    public String institutionRegister(HttpServletRequest request, ModelMap model){

        Institution institution = new Institution();
        institution.setInstitutionid(request.getParameter("institutionid"));
        institution.setName(request.getParameter("name"));
        institution.setPassword(request.getParameter("password"));

        InstitutionService institutionService = ServiceFactory.getInstitutionService();
        institutionService.register(institution);
        return "redirect:/login/institution";
    }

}
