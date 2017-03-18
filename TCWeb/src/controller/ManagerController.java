package controller;

import factory.ServiceFactory;
import model.Course;
import model.InstitutionStat;
import model.Manager;
import model.StudentStat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ManagerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhangYF on 2017/2/17.
 */
@Controller
@RequestMapping(value = "/TCManager")
public class ManagerController {

    private ManagerService managerService = ServiceFactory.getManagerService();

    @RequestMapping(value = "/TCManager")
    public String managerHome(HttpServletRequest request, ModelMap model, Principal principal){

        HttpSession session = request.getSession(false);
        if(session == null){
            session = request.getSession(true);
        }
        if(principal.getName() == null){
            System.out.println("name is null");
        }
        String managerid = principal.getName();

        session.setAttribute("managerid", managerid);
        Manager manager = managerService.getManagetByID(managerid);

        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
        model.addAttribute("contextPath",contextpath);
        model.addAttribute("managerid",managerid);
        model.addAttribute("managerName",manager.getName());

        List<Course> approveCourses = managerService.getApproveCourses();
        List<Course> settleCourses = managerService.getSettleCourses();
        List<StudentStat> studentStats = managerService.getStudentStat();
        List<InstitutionStat> institutionStats = managerService.getInstitutionStat();
        model.addAttribute("approveCourses", approveCourses);
        model.addAttribute("settleCourses", settleCourses);
        model.addAttribute("studentStats", studentStats);
        model.addAttribute("institutionStats", institutionStats);
        return "tcManager/tcManager";
    }

    @RequestMapping(value = "/approveCourse")
    @ResponseBody
    public Map<String,Object> approveCourse(HttpServletRequest request){
        String courseid = request.getParameter("courseid");
        Map<String, Object> map = new HashMap<>();
        if(request.getParameter("result").equals("1")){
            managerService.passCourse(courseid);
            System.out.println("通过");
            map.put("msg","通过");
        }else{
            managerService.denyCourse(courseid);
            System.out.println("未通过");
            map.put("msg","未通过");
        }
        return map;
    }

    @RequestMapping(value = "/settleCourse")
    @ResponseBody
    public Map<String,Object> settleCourse(HttpServletRequest request){
        String courseid = request.getParameter("courseid");
        Map<String, Object> map = new HashMap<>();
        if(managerService.settleAccount(courseid)){
            map.put("msg","结算完成");
        }else{
            map.put("msg","结算异常");
        }
        return map;
    }


}
