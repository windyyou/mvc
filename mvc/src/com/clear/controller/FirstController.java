package com.clear.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clear.bo.LoginResultBo;
import com.clear.entity.AdminUser;
import com.clear.service.FirstService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/first")
public class FirstController extends BaseController {
    
    @Resource(name = "firstServiceImpl")
    private FirstService firstService;
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String first(AdminUser admin,String name,Model model, HttpServletRequest request){
        name = request.getParameter("name");
        
        model.addAttribute("name", admin.getName());
        model.addAttribute("user", admin);
        
        request.setAttribute("name", name);
        
        if(firstService.checkPwd(admin.getPwd())){
            return "success";
        }else{
            return "../../login";
        }
        
    }
    
    @RequestMapping(value = "/ajaxLogin",method=RequestMethod.POST)
    public @ResponseBody String ajaxPost(AdminUser user,Model model, HttpServletRequest request){
        
        model.addAttribute("name", user.getName());
        
        LoginResultBo bo = new LoginResultBo();
        if(firstService.checkPwd(user.getPwd())){
            bo.setStatus(LoginResultBo.LOGIN_SUCCESS);
            bo.setMsg("登录成功");
        }else{
            bo.setStatus(LoginResultBo.LOGIN_FAIL);
            bo.setMsg("登录失败");
        }
        
        Gson gson = new Gson();
        String jsonStrq = gson.toJson(bo);
        return jsonStrq;
    }
    
    @RequestMapping(value = "/next",method=RequestMethod.POST)
    public String getTfs(AdminUser admin,String name,Model model, HttpServletRequest request){
        firstService.saveUser(admin);
        model.addAttribute("name", name);
        return "index";
    }
}
