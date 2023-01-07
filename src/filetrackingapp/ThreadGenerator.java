/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetrackingapp;

import Dao.FileTrackingDao;
import Pojo.FileTrackingPojo;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Neel_Esh
 */
public class ThreadGenerator implements Runnable {
    
    private File file=null;
    public Thread th;
    private String Email;
    public ThreadGenerator(String email,File file)
    {   
        this.Email=email;
        this.file =file;
        
        FileTrackingPojo pojo=new FileTrackingPojo();
        pojo.setEmail(Email.trim());
        pojo.setFileName(file.toString().trim());
        
        if(FileTrackingDao.getTrackingStatus(pojo)==false)
        {
            th=new Thread(this);
            th.start();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Tracking Already running in this file ","SomeThing Went Wrong",JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    @Override
    public void run()
    {   
        FileTrackingApp.setEmail(Email);
        System.out.println("Thread Started before start");
        JOptionPane.showMessageDialog(null,"Tracking Starts on selected File ...  ","Success ",JOptionPane.INFORMATION_MESSAGE);
        FileTrackingApp.startTracking(file);
        System.out.println("Thread Started after start");
    }
    
}