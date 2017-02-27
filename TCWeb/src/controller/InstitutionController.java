package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZhangYF on 2017/2/17.
 */
@Controller
@RequestMapping(value = "/institution")
public class InstitutionController {

    @RequestMapping(value = "/institution")
    public String institutionHome(HttpServletRequest request, ModelMap model){
        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
        model.addAttribute("contextPath",contextpath);
        return "institution/institution";
    }
}
