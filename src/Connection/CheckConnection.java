/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Neel_Esh
 */
public class CheckConnection {
    
    public static boolean checkInternet()
    {
        try 
        {
             
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            
            connection.connect();
         
            System.out.println("Internet is connected");
            return true;
        } 
        catch (MalformedURLException e) 
        {
            System.out.println("Internet is not connected");
            return false;
        } 
        catch (IOException e) 
        {
            System.out.println("Internet is not connected");
            return false;
        }
    }
}
