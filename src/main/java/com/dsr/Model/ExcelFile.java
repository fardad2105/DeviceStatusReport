package com.dsr.Model;

import org.springframework.web.multipart.MultipartFile;

public class ExcelFile {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
