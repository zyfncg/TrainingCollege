package controller;

import factory.ServiceFactory;
import model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/16.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @RequestMapping(value = "/student")
    public String studentHome(HttpServletRequest request, ModelMap model){

        HttpSession session = request.getSession(false);
        if(null == session){
            return "redirect:/login/student";
        }
        String studentid = (String)session.getAttribute("studentid");
        if(null == studentid){
            return "redirect:/login/student";
        }

        StudentService studentService = ServiceFactory.getStudentService();
        List<Course> coursesAll = studentService.getAllCourses();
        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
        model.addAttribute("contextPath",contextpath);
        model.addAttribute("coursesAll",coursesAll);
        return "student/student";
    }
}
