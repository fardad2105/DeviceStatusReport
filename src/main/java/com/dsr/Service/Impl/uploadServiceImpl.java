package com.dsr.Service.Impl;

import com.dsr.Dao.FileUploadDao;
import com.dsr.Model.infoExcel;
import com.dsr.Service.uploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class uploadServiceImpl implements uploadService {


    @Autowired
    private FileUploadDao fileUploadDao;


    public void addExcel(infoExcel infoExcel) {
        fileUploadDao.addExcel(infoExcel);
    }
}
