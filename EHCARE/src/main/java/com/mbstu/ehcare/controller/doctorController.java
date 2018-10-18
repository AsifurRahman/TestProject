package com.mbstu.ehcare.controller;

import com.mbstu.ehcare.dao.DoctorRepository;
import com.mbstu.ehcare.model.Doctor;
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
public class doctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @RequestMapping(value = "/upsertDoctor", method = RequestMethod.GET)
    public String doctorEdit(Model model, @RequestParam(value ="doctorId", required=false) Integer doctorId) {
        System.out.println("----------DoctorEdit---------");
        if(doctorId== null){
            Doctor doctor = new Doctor();
            model.addAttribute("doctor", doctor);
        }
        else {
            Doctor doctor = doctorRepository.getDoctorById(doctorId);
            model.addAttribute("doctor", doctor);
        }
        return "doctor";
    }

    @RequestMapping(value = "/upsertDoctor", method = RequestMethod.POST)
    public String doctorUpdatePost(Model model, @ModelAttribute("doctor") Doctor doctor, HttpServletRequest request) {
        System.out.println("-----------doctorPost-------------");
        System.out.println(doctor);
        try{
            doctorRepository.save(doctor);
            request.setAttribute("message", "Edited successfully");
        }catch(Exception e){
            request.setAttribute("message", "Faild to save Edit");
        }
        return "redirect:./doctorList";
    }

    @RequestMapping(value = "/deleteDoctor", method = RequestMethod.GET)
    public String deleteDoctor(Model model, @RequestParam(value="doctorId", required=false) Integer doctorId) {
        System.out.println("-----------delete-------------doctorId:"+doctorId);
        Doctor doctor = doctorRepository.getDoctorById(doctorId);
        doctorRepository.delete(doctor);
        return "redirect:./doctorList";
    }

    @RequestMapping(value = "/doctorList", method = RequestMethod.GET)
    public String doctorListView(Model model) {
        System.out.println("-----------doctorListView-------------");
        List<Doctor> doctorList=doctorRepository.findAll();
        model.addAttribute("doctorList",doctorList);
        return "doctorList";
    }


}