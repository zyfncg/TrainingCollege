package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZhangYF on 2017/2/17.
 */
@Controller
@RequestMapping(value = "/TCManager")
public class ManagerController {

    @RequestMapping(value = "/TCManager")
    public String managerHome(HttpServletRequest request, ModelMap model){
        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
        model.addAttribute("contextPath",contextpath);
        return "tcManager/tcManager";
    }
}
