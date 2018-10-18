package com.mbstu.ehcare.controller;
import com.mbstu.ehcare.dao.BrequestRepository;
import com.mbstu.ehcare.model.Brequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class indexController {

    @Autowired
    BrequestRepository brequestRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        System.out.println("---This  is Home page---");
        List<Brequest> brequestList = brequestRepository.findAll();
        model.addAttribute("brequestList", brequestList);
        return "index";
    }

    @RequestMapping(value = "/deletebrequest",method=RequestMethod.GET)
    public String deleteRequest(@RequestParam(value = "brequestId",required = false)Integer brequestId){
        Brequest brequest=brequestRepository.getbrequestById(brequestId);
        brequestRepository.delete(brequest);
        System.out.println("Deleting Blood Request");
        return "redirect:./";
    }

}