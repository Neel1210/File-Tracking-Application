package filetrackingapp;

import Connection.CheckConnection;
import Dao.FileTrackingDao;
import Pojo.FileTrackingPojo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Neel_Esh
 */
public class FileTrackingApp {
    
    private static String Email; 
    private static String path;
    private static int flag=0;

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String email) {
        Email=email;
    }
    
    private static FileTrackingPojo insertPojo;
    
    public static void startTracking(File file)
    {
        insertPojo = new FileTrackingPojo();
        insertPojo.setEmail(Email);
        insertPojo.setStatus(1);
        insertPojo.setFileName1(file.getName().trim());
        insertPojo.setFileName(file.toString().trim());
        
        try(WatchService service= FileSystems.getDefault().newWatchService())
        { 
            Map<WatchKey, Path> keyHash = new HashMap<>();
            String Dir=file.toString().trim();
            Path p = Paths.get(Dir);
            keyHash.put(p.register(service,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY)
                    ,p);

            WatchKey watchKey = null;
            
            fileCreating(file);
            int flag=0;
            do
            {
                watchKey=service.take();
                Path eventDir=keyHash.get(watchKey);

                for(WatchEvent<?> event : watchKey.pollEvents())
                {
                    WatchEvent.Kind<?> kind=event.kind();
                    Path eventPath=(Path)event.context();
                    String str= eventDir +","+new Date().toString()+"," + kind +","+eventPath;
                    
                    writeCsv(file,str);
                    
                    if(!FileTrackingDao.checkRecord(insertPojo) && CheckConnection.checkInternet())
                    {
                        FileTrackingDao.insertTrackingRecord(insertPojo);
                    }
                    else if(flag==0)
                    {
                        boolean res=FileTrackingDao.startTracking(insertPojo);
                        flag=flag+1;
                        System.out.println("Tracking start ..."+res);
                    }
                    if(CheckConnection.checkInternet())
                    {
                        FileTrackingDao.updateCsv(insertPojo);
                    }
                    
                    System.out.println(str);
                }
                
                System.out.println("Outside For");
                
                if(!FileTrackingDao.getTrackingStatus(insertPojo))
                    break;
            }
            while(watchKey.reset());
            System.out.println("ending of while");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            insertPojo.setFilePath(insertPojo.getFileName());
            try
            {
                FileTrackingDao.stopTracking(insertPojo);
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }  
        }
    }
    
    private static void writeCsv(File file , String str)
    {
        try
        {       
            
                path=file.toString().trim()+"/."+file.getName()+".csv";
                
                FileWriter csvWriter=new FileWriter(path,true);  
                
                if(str.contains(file.getName()+".csv"))
                {
                    return ;
                }
                
                csvWriter.append(String.join(",",str));
                csvWriter.append("\n");
                
                csvWriter.flush();
                csvWriter.close();
               
        }          
        catch(IOException ex)
        {
            System.out.println("erroe");
            ex.printStackTrace();
        }   
    }
    
    private static void fileCreating(File file)
    {
        try{
            
            path=file.toString().trim()+"/."+file.getName()+".csv";
            insertPojo.setFilePath(path);
            File f=new File(path);
            
            boolean res=f.createNewFile();
            if(res)
            {   
                
                System.out.println("File created :"+f.getName());
                FileWriter csvWriter=new FileWriter(f.toString(),true);
                csvWriter.append("File Path");
                csvWriter.append(",");
                csvWriter.append("Date & time");
                csvWriter.append(",");
                csvWriter.append("Modificatation Kind");
                csvWriter.append(",");
                csvWriter.append("File affected ");
                csvWriter.append("\n");
                
                csvWriter.flush();
                csvWriter.close();
            }
        }
        catch(IOException ex)
        {
            System.out.println("erroe");
            ex.printStackTrace();
        }   
    }
    
    
}
