/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.io.File;

/**
 *
 * @author Neel_Esh
 */
public class FileTrackingPojo {

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    public FileTrackingPojo(String Email, String FileName1, String FilePath, String FileName, int status) {
        this.Email = Email;
        this.FileName1 = FileName1;
        this.FilePath = FilePath;
        this.FileName = FileName;
        this.status = status;
    }

    public FileTrackingPojo() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String FilePath) {
        this.FilePath = FilePath;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getFileName1() {
        return FileName1;
    }

    public void setFileName1(String FileName1) {
        this.FileName1 = FileName1;
    }
    
    private String Email;
    private String FileName1;
    private String FilePath;
    private String FileName;
    private int status;
    
}
