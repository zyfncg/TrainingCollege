package controller;

import factory.ServiceFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by ZhangYF on 2017/2/16.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String getStudentLoginPage(HttpServletRequest request, ModelMap model){
        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
        model.addAttribute("contextPath",contextpath);
        model.addAttribute("actionURL",contextpath+"/login/studentCheck");
        return "login/login";
    }

    @RequestMapping(value = "/studentCheck", method = RequestMethod.POST)
    public String checkStudent(String login, String password,HttpServletRequest request, ModelMap model){
        StudentService studentService = ServiceFactory.getStudentService();
        if(studentService.checkPassword(login,password)){
//        if(login.equals("1234567")){
            HttpSession session = request.getSession(false);
            if (session == null){
                session = request.getSession(true);
            }
            session.setAttribute("studentid",login);
            return "redirect:/student/student";
        }else{
            String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
            String urlpath = contextpath + "/login/student";
            model.addAttribute("urlPath",urlpath);
            return "redirect:/login/loginFail";
        }
    }

    @RequestMapping(value = "/institution", method = RequestMethod.GET)
    public String getInstitutionLoginPage(HttpServletRequest request, ModelMap model){
        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
        model.addAttribute("contextPath",contextpath);
        model.addAttribute("actionURL",contextpath+"/login/institutionCheck");
        return "login/login";
    }

    @RequestMapping(value = "/institutionCheck", method = RequestMethod.POST)
    public String checkInstitution(String login, String password,HttpServletRequest request, ModelMap model){
        if(login.equals("9000001")){
            return "redirect:/institution/institution";
        }else{
            String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
            String urlpath = contextpath + "/login/institution";
            model.addAttribute("urlPath",urlpath);
            return "redirect:/login/loginFail";
        }
    }

    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String getManagerLoginPage(HttpServletRequest request, ModelMap model){
        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
        model.addAttribute("contextPath",contextpath);
        model.addAttribute("actionURL",contextpath+"/login/managerCheck");
        return "login/login";
    }

    @RequestMapping(value = "/managerCheck", method = RequestMethod.POST)
    public String checkManager(String login, String password,HttpServletRequest request, ModelMap model){
        if(login.equals("5000001")){
            return "redirect:/manager/manager";
        }else{
            String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
            String urlpath = contextpath + "/login/manager";
            model.addAttribute("urlPath",urlpath);
            return "redirect:/login/loginFail";
        }
    }

}