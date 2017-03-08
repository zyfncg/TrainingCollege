package controller;

import factory.ServiceFactory;
import model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.GeneratorService;
import service.InstitutionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by ZhangYF on 2017/2/17.
 */
@Controller
@RequestMapping(value = "/institution")
public class InstitutionController {

    private InstitutionService institutionService = ServiceFactory.getInstitutionService();
    private GeneratorService generatorService = ServiceFactory.getGeneratorService();

    @RequestMapping(value = "/institution")
    public String institutionHome(HttpServletRequest request, ModelMap model){
        HttpSession session = request.getSession(false);
        if(null == session){
            return "redirect:/login/institution";
        }
        String institutionid = (String)session.getAttribute("institutionid");
        if(null == institutionid){
            return "redirect:/login/institution";
        }

        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
        model.addAttribute("contextPath",contextpath);

        List<Course> courses = institutionService.getCourseByInstitution(institutionid);
        model.addAttribute("courseList",courses);

        return "institution/institution";
    }

    @RequestMapping(value = "/createcourse", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createCourse(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(null != session){
            String institutionid = (String)session.getAttribute("institutionid");
        }
        Course course = new Course();
        course.setCourseID(generatorService.getCourseid());
        course.setCourseName(request.getParameter("coursename"));
        course.setStartTime(Date.valueOf(request.getParameter("starttime")));
        course.setEndTime(Date.valueOf(request.getParameter("endtime")));
        course.setTeacher(request.getParameter("teacher"));
        course.setPrice(Double.parseDouble(request.getParameter("price")));
        Map<String, Object> map = new HashMap<>();
        if(institutionService.createCourse(course)){
            map.put("msg","正在申请");
        }else{
            map.put("msg","错误");
        }
        return map;
    }
}
