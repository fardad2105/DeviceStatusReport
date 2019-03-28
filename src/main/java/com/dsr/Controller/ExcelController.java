package com.dsr.Controller;


import com.dsr.Model.ExcelFile;
import com.dsr.Model.infoExcel;
import com.dsr.Utils.ExcelHelper;
import com.dsr.Utils.UploadFileHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping(value = "/excel")
public class ExcelController {

    private String fileLocation;


    @RequestMapping(value = "/importexcel",method = RequestMethod.GET)
    public String excel()
    {
        return "index";
    }

    @RequestMapping(value = "/uploadFile")
    public String importexcel(ModelMap modelMap)
    {
        modelMap.put("excelFile",new ExcelFile());
        return "index";
    }

    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public String importexcel(@ModelAttribute("excelFile")ExcelFile excelFile, ModelMap modelMap, HttpServletRequest request)
    {

        try {
            File file = UploadFileHelper.simpleUpload(excelFile.getFile(),request,true,"src");
            System.out.println(file.getAbsolutePath());
//            ExcelHelper eh = new ExcelHelper(file.getAbsolutePath());
//            modelMap.put("listDeviceInfo",eh.readData(infoExcel.class.getName()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.toString());
        }

        return "success";
    }

    @RequestMapping(value = "/uploadExcelFile", method = RequestMethod.POST)
    public String uploadFile(Model model, MultipartFile file) throws IOException
    {
        InputStream in = file.getInputStream();
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();
        FileOutputStream f = new FileOutputStream(fileLocation);
        int ch = 0;
        while ((ch = in.read()) != -1) {
            f.write(ch);
        }
        f.flush();
        f.close();
        model.addAttribute("message", "File: " + file.getOriginalFilename()
                + " has been uploaded successfully!");
        return "index";
    }
}
