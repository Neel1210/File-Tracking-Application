/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.DBConnection;
import Pojo.CreateNewAccountPojo;
import Pojo.LoginPojo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    
   
   public static boolean login(LoginPojo Lp)
   {
       try
       {    
           PreparedStatement ps =DBConnection.getConnection().prepareStatement("Select * from usersLogin where email=?");
           ps.setString(1,Lp.getEmail());
           ResultSet rs = ps.executeQuery();
           if(rs.next())
           {   if(Lp.getPassWord().equalsIgnoreCase(rs.getString(2)))
                   return true;
           }
           
       }
       catch(SQLException ex)
       {    
           System.out.println("Error in LoginDao - login");
           ex.printStackTrace();
       }
       return false;
   }
   
   public static String createNew(CreateNewAccountPojo newAccount)
   {
       try
       {  
           PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from usersLogin where email=?");
           ps.setString(1,newAccount.getEmail());
           ResultSet rs=ps.executeQuery();
           if(rs.next())
           {    
               return "Email address already present in DB";
           }
           else
           {
                ps=DBConnection.getConnection().prepareStatement("insert into usersLogin values(?,?,?)");
                ps.setString(1,newAccount.getEmail());
                ps.setString(2,newAccount.getPassword());
                ps.setInt(3,newAccount.getStatus());
                int res = ps.executeUpdate();
                if(res==1)
                return "Account Created !!!";
           }
       }
       catch(SQLException ex)
       {
           System.out.println("Error in LoginDao - createNew");
           ex.printStackTrace();
       }
       return "SomeThing Went Wrong !!!";
   }
}
