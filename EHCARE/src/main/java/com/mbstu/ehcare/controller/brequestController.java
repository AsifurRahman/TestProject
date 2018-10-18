package com.mbstu.ehcare.controller;
import com.mbstu.ehcare.dao.BrequestRepository;
import com.mbstu.ehcare.model.Brequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class brequestController {
    @Autowired
    BrequestRepository brequestRepository;

    @RequestMapping(value = "/brequest", method = RequestMethod.GET)
    public String brequestView() {
        System.out.println("---This  is Request page---");
        return "brequest";
    }
    @RequestMapping(value = "/brequest", method = RequestMethod.POST)
    public String brequestSaveView(Model model, @ModelAttribute()Brequest brequest) {
        System.out.println("---This  is Request page Backend---");
        brequestRepository.save(brequest);
        System.out.println("Successfully got the  object");
        return "redirect:./login";
    }
}


