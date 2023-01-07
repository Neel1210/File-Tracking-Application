/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.DBConnection;
import Pojo.FileTrackingPojo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Neel_Esh
 */
public class FileTrackingDao {
    private static PreparedStatement ps;
    
    public static boolean insertTrackingRecord(FileTrackingPojo insertPojo)throws SQLException,FileNotFoundException
    {
        ps=DBConnection.getConnection().prepareStatement("insert into filestracking values(?,?,?,?,?)");
        ps.setString(1,insertPojo.getEmail());
        ps.setString(2,insertPojo.getFileName1());
        ps.setString(3,insertPojo.getFileName());
        ps.setInt(4,insertPojo.getStatus());
        
        InputStream csvFile = new FileInputStream(insertPojo.getFilePath());
        ps.setBlob(5, csvFile);
            
        int res = ps.executeUpdate();
        System.out.println("record inserted - ");
        return res==1;
        
    }
    
    
    public static boolean updateCsv(FileTrackingPojo updatePojo)throws SQLException,FileNotFoundException
    {
        ps=DBConnection.getConnection().prepareStatement("update filestracking set csv=? where email=? and filePath=?");
        
        InputStream csvFile = new FileInputStream(updatePojo.getFilePath());
        ps.setBlob(1,csvFile);
            
        ps.setString(2,updatePojo.getEmail());
        ps.setString(3,updatePojo.getFileName());
            
        int res = ps.executeUpdate();
        
        System.out.println("record Updated - ");
        return res==1;
    }
    
    public static void retriveCvs(FileTrackingPojo retrivePojo) throws SQLException,IOException
    {
            ps=DBConnection.getConnection().prepareStatement("select * from filestracking where email=? and filePath=?");
   
            ps.setString(1,retrivePojo.getEmail());
            ps.setString(2,retrivePojo.getFileName1());
            
            ResultSet rs=ps.executeQuery();
            
            if(rs.next())
            {
                 Blob b=rs.getBlob(5);
                 byte []arr=b.getBytes(1,(int)b.length());
                 FileOutputStream output=new FileOutputStream(retrivePojo.getFilePath()+"/"+retrivePojo.getFileName()+".csv");
                 output.write(arr);
            }
    }
    
    public static ResultSet showData(String Email) throws SQLException
    {
            ps=DBConnection.getConnection().prepareStatement("select * from filestracking where email=? and status=1");
   
            ps.setString(1,Email);
   
            return ps.executeQuery();
    }
    
    public static ResultSet showAllData(String Email) throws SQLException
    {
            ps=DBConnection.getConnection().prepareStatement("select * from filestracking where email=?");
   
            ps.setString(1,Email);
   
            return ps.executeQuery();
    }
    
    public static boolean checkRecord(FileTrackingPojo insertPojo)throws SQLException 
    {
        ps=DBConnection.getConnection().prepareStatement("select * from filestracking where email=? and filepath=?");
        ps.setString(1,insertPojo.getEmail());
        ps.setString(2,insertPojo.getFileName());
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
    
    public static boolean getTrackingStatus(FileTrackingPojo insertPojo)
    {
        try
        {
            ps=DBConnection.getConnection().prepareStatement("select * from filestracking where email=? and filepath=?");
            ps.setString(1,insertPojo.getEmail());
            ps.setString(2,insertPojo.getFileName());
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                if(rs.getInt(4)==1)
                {   System.out.println(rs.getInt(4));
                    return true;
                }
            }    
        }
        catch(SQLException ex)
        {   
            System.out.println("Error in FileTrackingDao - getTrackingStatus");
            ex.printStackTrace();
        }
        
        return false;   
    }
    
    public static int stopTracking(FileTrackingPojo insertPojo) throws SQLException
    {
        ps=DBConnection.getConnection().prepareStatement("update filestracking set status=0 where email=? and filepath=?");
        ps.setString(1,insertPojo.getEmail());
        ps.setString(2,insertPojo.getFilePath());
        return ps.executeUpdate();
    }   
    
    public static boolean startTracking(FileTrackingPojo insertPojo)
    {
        try
        {
            ps=DBConnection.getConnection().prepareStatement("update filestracking set status=1 where email=? and filepath=?");
            ps.setString(1,insertPojo.getEmail());
            ps.setString(2,insertPojo.getFileName());
            return ps.executeUpdate()==1; 
        }
        catch(SQLException ex)
        {   
            System.out.println("Error in FileTrackingDao - getTrackingStatus");
            ex.printStackTrace();
        }
        return false;
    }    
}
