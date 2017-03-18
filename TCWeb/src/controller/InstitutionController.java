package controller;

import factory.ServiceFactory;
import model.Course;
import model.Institution;
import model.StudCourse;
import modelBean.Grade;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.GeneratorService;
import service.InstitutionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

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
        if(session == null){
            session = request.getSession(true);
        }
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        String institutionid = securityContextImpl.getAuthentication().getName();
        session.setAttribute("institutionid", institutionid);

        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
        model.addAttribute("contextPath",contextpath);

        List<Course> courses = institutionService.getCourseByInstitution(institutionid);
        Institution institution = institutionService.getInstitutionByID(institutionid);

        model.addAttribute("balance",institution.getAccount().getMoney());
        model.addAttribute("courseList",courses);
        model.addAttribute("institutionid",institutionid);
        model.addAttribute("institutionName",institution.getName());

        return "institution/institution";
    }

    @RequestMapping(value = "/createcourse", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createCourse(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<>();
        if(null != session){
            try {
                String institutionid = (String)session.getAttribute("institutionid");
                Institution institution = institutionService.getInstitutionByID(institutionid);
                Course course = new Course();
                course.setCourseID(generatorService.getCourseid());
                course.setCourseName(request.getParameter("coursename"));
                course.setStartTime(Date.valueOf(request.getParameter("starttime")));
                course.setEndTime(Date.valueOf(request.getParameter("endtime")));
                course.setTeacher(request.getParameter("teacher"));
                course.setPrice(Double.parseDouble(request.getParameter("price")));
                course.setInstitution(institution);

                if(institutionService.createCourse(course)){
                    System.out.println("成功");
                    map.put("msg","正在申请");
                }else{
                    System.out.println("失败");
                    map.put("msg","错误");
                }
            }catch (Exception e){
                map.put("msg","错误");
                return map;
            }

        }else {
            map.put("msg","错误");
        }

        return map;
    }

    @RequestMapping(value = "/modifyCoursePage")
    public String modifyCoursePage(String courseid, HttpServletRequest request, ModelMap model){
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
        Course course = institutionService.getCourseByID(courseid);
        model.addAttribute("course",course);
        return "course/course";
    }

    @RequestMapping(value = "modifyCourse")
    @ResponseBody
    public Map<String, Object> modifyCourse(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<>();
        if(null != session && request.getParameter("courseid") != null){
            try {

                Course course = institutionService.getCourseByID(request.getParameter("courseid"));
                course.setCourseName(request.getParameter("coursename"));
                course.setStartTime(Date.valueOf(request.getParameter("starttime")));
                course.setEndTime(Date.valueOf(request.getParameter("endtime")));
                course.setTeacher(request.getParameter("teacher"));
                course.setPrice(Double.parseDouble(request.getParameter("price")));
                course.setApproveState(0);
                if(institutionService.updateCourse(course)){
                    map.put("msg","提交成功，请等待审批");
                }else{
                    map.put("msg","信息同步错误，请重试");
                }
            }catch (Exception e){
                map.put("msg","发生错误，请重试");
                return map;
            }
        }else {
            map.put("msg","错误");
        }
        return map;
    }

    @RequestMapping(value = "/recordgrade")
    public String recordGrade(HttpServletRequest request, String courseid, ModelMap model){
        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
        model.addAttribute("contextPath",contextpath);
        List<StudCourse> studCourseList = institutionService.getStudCoursesByCourseID(courseid);
        Course course = institutionService.getCourseByID(courseid);
        model.addAttribute("studCourseList", studCourseList);
        model.addAttribute("course",course);
        return "course/gradeRecord";
    }

    @RequestMapping(value = "savegrade")
    @ResponseBody
    public Map<String, Object> saveGrade(@RequestBody Grade[] gradeList,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        System.out.println("get data");
        List<StudCourse> studCourseList = new ArrayList<>();
        for (Grade grade: gradeList){
            if(grade.getGrade() != 0){
                StudCourse studCourse = institutionService.getStudCourse(grade.getStudentid(), grade.getCourseid());
                studCourse.setGrade(grade.getGrade());
                studCourseList.add(studCourse);
            }
        }
        institutionService.saveGrades(studCourseList);
        map.put("msg","保存成功");
        return map;
    }

}
