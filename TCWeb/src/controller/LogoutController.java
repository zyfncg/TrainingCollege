package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZhangYF on 2017/2/17.
 */
@Controller
@RequestMapping(value = "/logout")
public class LogoutController {
    @RequestMapping(value = "/student")
    public String logoutStudent(){
        return "redirect:/login/student";
    }
    @RequestMapping(value = "/institution")
    public String logoutInstitution(){
        return "redirect:/login/institution";
    }
    @RequestMapping(value = "/manager")
    public String logoutManager(){
        return "redirect:/login/manager";
    }

}
