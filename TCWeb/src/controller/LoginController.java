package controller;

import factory.ServiceFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.InstitutionService;
import service.ManagerService;
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
        model.addAttribute("actionURL",contextpath+"/student/studentCheck");
        model.addAttribute("user","学生登录");
        return "login/login";
    }


    @RequestMapping(value = "/institution", method = RequestMethod.GET)
    public String getInstitutionLoginPage(HttpServletRequest request, ModelMap model){
        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
        model.addAttribute("contextPath",contextpath);
        model.addAttribute("actionURL",contextpath+"/institution/institutionCheck");
        model.addAttribute("user","机构登录");
        return "login/login";
    }

    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String getManagerLoginPage(HttpServletRequest request, ModelMap model){
        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
        model.addAttribute("contextPath",contextpath);
        model.addAttribute("actionURL",contextpath+"/TCManager/managerCheck");
        model.addAttribute("user","经理登录");
        return "login/login";
    }


}