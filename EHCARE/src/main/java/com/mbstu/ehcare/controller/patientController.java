package com.mbstu.ehcare.controller;

import com.mbstu.ehcare.dao.PatientRepository;
import com.mbstu.ehcare.model.Patient;
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
public class patientController {
    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping(value = "/upsertPatient", method = RequestMethod.GET)
    public String patientEdit(Model model, @RequestParam(value ="patientId", required=false) Integer patientId) {
        System.out.println("----------PatientEdit---------");
        if(patientId== null){
            Patient patient = new Patient();
            model.addAttribute("patient", patient);
        }
        else {
            Patient patient = patientRepository.getPatientById(patientId);
            model.addAttribute("patient", patient);
        }
        return "patient";
    }

    @RequestMapping(value = "/upsertPatient", method = RequestMethod.POST)
    public String patientUpdatePost(Model model, @ModelAttribute("patient") Patient patient, HttpServletRequest request) {
        System.out.println("-----------patientPost-------------");
        System.out.println(patient);
        try{
            patientRepository.save(patient);
            request.setAttribute("message", "Edited successfully");
        }catch(Exception e){
            request.setAttribute("message", "Faild to save Edit");
        }
        return "redirect:./patientList";
    }

    @RequestMapping(value = "/deletePatient", method = RequestMethod.GET)
    public String deletePatient(Model model, @RequestParam(value="patientId", required=false) Integer patientId) {
        System.out.println("-----------delete-------------patientId:"+patientId);
        Patient patient = patientRepository.getPatientById(patientId);
        patientRepository.delete(patient);
        return "redirect:./patientList";
    }

    @RequestMapping(value = "/patientList", method = RequestMethod.GET)
    public String patientListView(Model model) {
        System.out.println("-----------patientListView-------------");
        List<Patient> patientList=patientRepository.findAll();
        model.addAttribute("patientList",patientList);
        return "patientList";
    }


}