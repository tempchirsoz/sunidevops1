import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 */

/**
 * @author  
 *
 */
public class JavaServer {
        static String line=null;
        static DataInputStream is;
        static PrintStream os;
        static ServerSocket jServer; 
        static Socket clientSocket = null;
        String msgtoclient;
        static int port = 9998;
        static BufferedReader sbr;
        static PrintWriter pw;
   	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
 
        try {
           jServer = new ServerSocket(port);
           if(jServer != null){System.out.println("The Server Socket is runing at port:" + port);}
        }
        catch (IOException e) {
           System.out.println("Failed to set up the server!"+ "\n"+e);
           e.printStackTrace();
        }   
 
        try {
           clientSocket = jServer.accept();
           if(clientSocket != null){
              System.out.println("Client/Server binding done!" + clientSocket.toString());}
                          
           			
			 sbr = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			//BufferedWriter sbw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
		    
			//try PrintStream, it supports println() method.             
             pw = new PrintWriter(clientSocket.getOutputStream(), true);
 
           
           while (true) {
             line = sbr.readLine();
             
             if(line!=null)
            	 {System.out.println("A message is received from the client: "+ line +"\n" + "Start processing request...");

             ////////////////////////Write server functions here -between Input and output ///////////////////////////////
             
             
             
             
             ////////////////////////////////////////////////////////////////////////////////////////////////////////////  
            	 pw.println(line); 
            	 }
             else 
            	 System.out.println("Message has not been received from the client!");
                                    
           }
        }   
    catch (IOException e) {
           System.out.println(e);
           e.printStackTrace();
           clientSocket.close();
           sbr.close();
           pw.close();
           jServer.close();
        }
    
		 
	}

}
