
package Connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;

/**
 *
 * @author Neel_Esh
 */
public class CallJar {
   
    
    public static void startTracking(String Email,String file)
    {
        try
        {
            Process ps=Runtime.getRuntime().exec(new String[]{"java","-jar","/Users/Neel_Esh/Projects/NetBeansProjects/FileTrackingJar/dist/FileTrackingJar.jar",Email,file}); 
            ps.waitFor();
            java.io.InputStream is=ps.getInputStream();
            
            InputStreamReader ins = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(ins);
            String line;

            while ((line = br.readLine()) != null) 
            {
                System.out.println(line);
            }

            byte b[]=new byte[is.available()];
            is.read(b,0,b.length);
            System.out.println(new String(b)); 
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            System.out.println("Error while start tracking through jar");
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
            System.out.println("Error while start tracking through jar");
        }
    }
}
