package com.dsr.Controller;


import com.dsr.Service.uploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {


//    @Autowired
//    FileUploadService ups;

    @Autowired
    private uploadService uploadService;


    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("upload");
    }


}
