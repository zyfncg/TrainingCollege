package controller;

import factory.ServiceFactory;
import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.GeneratorService;
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
        model.addAttribute("institutionid", "5000001");
        return "register/institutionRegister";
    }

    @RequestMapping(value = "/registerInstitution")
    public String institutionRegister(HttpServletRequest request, ModelMap model){

        return "redirect:/login/institution";
    }

}
