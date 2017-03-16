package controller;

import factory.ServiceFactory;
import model.Account;
import model.Course;
import model.StudCourse;
import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhangYF on 2017/2/16.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {
    private StudentService studentService = ServiceFactory.getStudentService();
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

        List<Course> unChooseCourses = studentService.getUnchooseCourses(studentid);
        List<StudCourse> reserveCourses = studentService.getReserveCourses(studentid);
        List<StudCourse> studyCourses = studentService.getStudyCourses(studentid);
        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
        model.addAttribute("contextPath",contextpath);
        model.addAttribute("unchoooseCourses",unChooseCourses);
        model.addAttribute("resserveCourses",reserveCourses);
        model.addAttribute("studyCourses",studyCourses);

        Student student = studentService.getStudentByID(studentid);
        Account account = student.getAccount();
        model.addAttribute("studentid",student.getStudentid());
        model.addAttribute("studentName",student.getName());
        model.addAttribute("balance",account.getMoney());
        model.addAttribute("bankcardid",account.getBankcardid());
        if(student.getVip() <= 0){
            model.addAttribute("vip",0-student.getVip());
            model.addAttribute("vipState", "未激活");
        }else{
            model.addAttribute("vip",student.getVip());
            model.addAttribute("vipState", "激活");

        }
        model.addAttribute("points",student.getPoint());

        return "student/student";
    }

    @RequestMapping(value = "/bindbankcard")
    @ResponseBody
    public Map<String,Object> bindBankcard(HttpServletRequest request, String bankcard){
        HttpSession session = request.getSession(false);
        System.out.println("bankcard: "+bankcard);
        System.out.println("request bankcard: "+ request.getParameter("bankcard"));
        if(null == session){
            System.out.println("session is null");
        }
        String studentid = (String)session.getAttribute("studentid");

        Map<String,Object> map = new HashMap<>();
        if(studentService.bindBankcard(studentid,bankcard)){
            System.out.println("成功");
            map.put("msg","添加成功");
        }else{
            System.out.println("失败");
            map.put("msg","添加失败");
        }

        return map;
    }

    @RequestMapping(value = "/recharge")
    @ResponseBody
    public  Map<String,Object> recharge(HttpServletRequest request, double money){
        HttpSession session = request.getSession(false);
        if(null == session){
            System.out.println("session is null");
        }
        String studentid = (String)session.getAttribute("studentid");
        Map<String,Object> map = new HashMap<>();
        if(studentService.deposit(studentid,money)){
            map.put("msg","充值成功");
        }else{
            map.put("msg","充值失败");
        }
        Student student = studentService.getStudentByID(studentid);
        map.put("balance",student.getAccount().getMoney());

        return map;
    }

    @RequestMapping(value = "/cancelvip")
    @ResponseBody
    public  Map<String,Object> cancelVip(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(null == session){
            System.out.println("session is null");
        }
        String studentid = (String)session.getAttribute("studentid");
        Map<String,Object> map = new HashMap<>();
        if(studentService.cancelVip(studentid)){
            map.put("msg","成功");
        }else{
            map.put("msg","失败");
        }

        return map;
    }

    @RequestMapping(value = "/exchangepoint")
    @ResponseBody
    public  Map<String,Object> exchangePoint(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(null == session){
            System.out.println("session is null");
        }
        String studentid = (String)session.getAttribute("studentid");
        Map<String,Object> map = new HashMap<>();
        if(studentService.exchangePoint(studentid)){
            map.put("msg","兑换成功");
        }else{
            map.put("msg","兑换失败");
        }

        return map;
    }

    @RequestMapping(value = "/reserveCourse")
    @ResponseBody
    public Map<String,Object> reserveCourse(HttpServletRequest request,String courseid){
        HttpSession session = request.getSession(false);
        if(null == session){
            System.out.println("session is null");
        }
        String studentid = (String)session.getAttribute("studentid");
        Map<String,Object> map = new HashMap<>();
        if (studentService.reserveCourse(studentid,courseid)){
            map.put("msg","选课成功");
        }else {
            map.put("msg","余额不足，请先充值");
        }
        return map;
    }

    @RequestMapping(value = "/dropReserveCourse")
    @ResponseBody
    public Map<String,Object> dropReserveCourse(HttpServletRequest request,String courseid){
        HttpSession session = request.getSession(false);
        if(null == session){
            System.out.println("session is null");
        }
        String studentid = (String)session.getAttribute("studentid");
        Map<String,Object> map = new HashMap<>();
        if (studentService.dropReserveCourse(studentid,courseid)){
            map.put("msg","退订成功");
        }else {
            map.put("msg","退订失败，请重试");
        }
        return map;
    }

    @RequestMapping(value = "/studyCourse")
    @ResponseBody
    public Map<String,Object> studyCourse(HttpServletRequest request,String courseid){
        HttpSession session = request.getSession(false);
        if(null == session){
            System.out.println("session is null");
        }
        String studentid = (String)session.getAttribute("studentid");
        Map<String,Object> map = new HashMap<>();
        if (studentService.studyCourse(studentid,courseid)){
            map.put("msg","成功");
        }else {
            map.put("msg","失败，请重试");
        }
        return map;
    }

    @RequestMapping(value = "/dropCourse")
    @ResponseBody
    public Map<String,Object> dropCourse(HttpServletRequest request,String courseid){
        HttpSession session = request.getSession(false);
        if(null == session){
            System.out.println("session is null");
        }
        String studentid = (String)session.getAttribute("studentid");
        Map<String,Object> map = new HashMap<>();
        if (studentService.dropStudyCourse(studentid,courseid)){
            map.put("msg","退课成功");
        }else {
            map.put("msg","退课失败，请重试");
        }
        return map;
    }



}
