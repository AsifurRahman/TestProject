package com.mbstu.ehcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class fileUploadController {

    private String uploadFolder="C:\\Users\\Rayhan\\Desktop\\DocServer\\";

    @RequestMapping(method = RequestMethod.GET, value = "/fileupload")
    public  String fileupload_page(){
        return "fileupload";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/fileupload")
    public String fileupload(@RequestParam("file") MultipartFile file , RedirectAttributes redirectAttributes){

        System.out.println("----------In File-Upload-Controller----------");
        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute("msg","Please upload the file again!!!!");
            return "redirect:fileupload";
        }

        try {
            byte[] bytes=file.getBytes();

            Path path= Paths.get(uploadFolder+file.getOriginalFilename());
            Files.write(path,bytes);

            redirectAttributes.addFlashAttribute("msg","You have Uploaded "+file.getOriginalFilename()+" Successfully:");

            System.out.println("File has been Uploaded Successfully");
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";

    }

    @GetMapping("/uploadStatus")
    public String uploadStatus(){
        return "uploadStatus";
    }
}
