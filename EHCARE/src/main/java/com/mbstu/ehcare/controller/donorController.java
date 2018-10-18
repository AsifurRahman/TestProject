package com.mbstu.ehcare.controller;

import com.mbstu.ehcare.dao.DonorRepository;
import com.mbstu.ehcare.model.Donor;
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
public class donorController {
    @Autowired
    private DonorRepository donorRepository;

    @RequestMapping(value = "/upsertDonor", method = RequestMethod.GET)
    public String donorEdit(Model model, @RequestParam(value ="donorId", required=false) Integer donorId) {
        System.out.println("----------DonorEdit---------");
        if(donorId== null){
            Donor donor = new Donor();
            model.addAttribute("donor", donor);
        }
        else {
            Donor donor = donorRepository.getDonorById(donorId);
            model.addAttribute("donor", donor);
        }
        return "donor";
    }

    @RequestMapping(value = "/upsertDonor", method = RequestMethod.POST)
    public String donorUpdatePost(Model model, @ModelAttribute("donor") Donor donor, HttpServletRequest request) {
        System.out.println("-----------donorPost-------------");
        System.out.println(donor);
        try{
            donorRepository.save(donor);
            request.setAttribute("message", "Edited successfully");
        }catch(Exception e){
            request.setAttribute("message", "Faild to save Edit");
        }
        return "redirect:./donorList";
    }

    @RequestMapping(value = "/deleteDonor", method = RequestMethod.GET)
    public String deleteDonor(Model model, @RequestParam(value="donorId", required=false) Integer donorId) {
        System.out.println("-----------delete-------------donorId:"+donorId);
        Donor donor = donorRepository.getDonorById(donorId);
        donorRepository.delete(donor);
        return "redirect:./donorList";
    }

    @RequestMapping(value = "/donorList", method = RequestMethod.GET)
    public String donorListView(Model model) {
        System.out.println("-----------donorListView-------------");
        List<Donor> donorList=donorRepository.findAll();
        model.addAttribute("donorList",donorList);
        return "donorList";
    }

    @RequestMapping(value = "/bdonorList", method = RequestMethod.GET)
    public String BdonorListView(Model model,@RequestParam(value = "sbgroup") String sbgroup){
        System.out.println("-----------bdonorListView-------------");
        System.out.println(sbgroup);
        List<Donor> bdonorList=donorRepository.getDonorBybgroup(sbgroup);
        System.out.println(bdonorList);
        model.addAttribute("bdonorList",bdonorList);
        return "bdonorList";
    }

}