package controller;

import factory.ServiceFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.StudentService;

/**
 * Created by ZhangYF on 2017/2/14.
 */
@Controller
@RequestMapping(value = "/hello", method = RequestMethod.GET)
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        StudentService studentService = ServiceFactory.getStudentService();
        String result;
        if(studentService.checkPassword("1234567","123456")){
            result = "password is true";
        }else{
            result = "password is false";
        }
        model.addAttribute("msg", "Hello World");
        model.addAttribute("name", result);
        return "hello";
    }
}