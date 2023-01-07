package Connection;

import Pojo.JarData;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
        private static Socket socket = null;
	private static ObjectInputStream input = null;
	private static ObjectOutputStream out	 = null;

        public static void setConnection(String ip,int port)throws IOException
        {
            socket = new Socket(ip, port);
            System.out.println("Connected");
        }
        
        public static void startClientSide(String email , File file)
        {
            try
		{
			//sends output to the socket
			out = new ObjectOutputStream(socket.getOutputStream());
                        
                        JarData jr=new JarData();
                        
                        jr.setEmail(email);
                        jr.setFile(file);
                        
                        System.out.println(jr);
                        
                        System.out.println(jr.getEmail()+jr.getFile());
                        
                        out.writeObject((JarData)jr);
                        
                        out.close();
			socket.close();
		}
		catch(UnknownHostException u)
		{
			System.out.println(u);
                        u.printStackTrace();
		}
		catch(IOException i)
		{
			System.out.println(i);
                        i.printStackTrace();
		}
        }
}