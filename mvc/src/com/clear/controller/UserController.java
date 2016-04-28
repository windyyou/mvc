package com.clear.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clear.entity.User;
import com.clear.service.UserService;
import com.google.gson.Gson;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("getAllUser")
    public String getAllUser(HttpServletRequest request) {
        request.setAttribute("userList", userService.getAllUser());
        return "index";
    }

    @RequestMapping(value = "/getUser/{id}")
    public String getUser(@PathVariable Long id, HttpServletRequest request) {

        request.setAttribute("user", userService.getUser(id));

        return "/editUser";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser() {
        System.out.println("UserController.toAddUser()");
        return "/addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(User user, HttpServletRequest request) {
        userService.addUser(user);
        return "redirect:/user/getAllUser.action";
    }

    // @RequestMapping("/delUser")
    // @RequestMapping(value = "/delUser/{id}")
    // public void delUser(@PathVariable String id, HttpServletResponse
    // response) {
    //
    // String result = "{\"result\":\"error\"}";
    //
    // if (userService.delUser(id)) {
    // result = "{\"result\":\"success\"}";
    // }
    //
    // response.setContentType("application/json");
    //
    // try {
    // PrintWriter out = response.getWriter();
    // out.write(result);
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

    @RequestMapping(value = "/delUser")
    public @ResponseBody
    String deleteRole(Long id) {
        StringBuilder result = new StringBuilder();
        try {
            userService.delUser(id.toString());
            result.append("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.append("删除失败," + e.getMessage());
        }
        Gson gson = new Gson();
        String jsonStrq = gson.toJson(result.toString());
        return jsonStrq;

    }

    @RequestMapping("/updateUser")
    public String updateUser(User user, HttpServletRequest request) {

        if (userService.updateUser(user)) {
            // user = userService.getUser(user.getId());
            // request.setAttribute("user", user);
            return "redirect:/user/getAllUser.action";
        } else {
            return "/error";
        }
    }
}
