package com.mbstu.ehcare.controller;

import com.mbstu.ehcare.dao.UserRepository;
import com.mbstu.ehcare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class userController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/upsertUser", method = RequestMethod.GET)
    public String userEdit(Model model, @RequestParam(value ="userId", required=false) Integer userId) {
        System.out.println("----------UserEdit---------");
        if(userId== null){
            User user = new User();
            model.addAttribute("user", user);
        }
        else{
            User user = userRepository.getUserById(userId);
            model.addAttribute("user", user);
        }
        return "user";
    }

    @RequestMapping(value = "/upsertUser", method = RequestMethod.POST)
    public String userUpdatePost(Model model, @ModelAttribute("user") User user, HttpServletRequest request) {
        System.out.println("-----------userPost-------------");
        System.out.println(user);
        try{
            userRepository.save(user);
            request.setAttribute("message", "Edited successfully");
        }catch(Exception e){
            request.setAttribute("message", "Faild to save Edit");
        }
        return "redirect:./userList";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(Model model, @RequestParam(value="userId", required=false) Integer userId) {
        System.out.println("-----------delete-------------userId:"+userId);
        User user = userRepository.getUserById(userId);
        userRepository.delete(user);
        return "redirect:./userList";
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String userListView(Model model) {
        System.out.println("-----------userListView-------------");
        List<User> userList=userRepository.findAll();
        model.addAttribute("userList",userList);
        return "userList";
    }
}