import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
 

public class Server implements InterfaceHashMap {
  static	HashMap<String,Integer > table = new HashMap<String,Integer>();
	   public Server() {}
		// verify file 	
		public static boolean fileVerify(String file){
			File inFile = new File(file);
			if (!inFile.isFile()) {
				return false;
			}
			else
				return true;
		}
	 
		public Integer getTableValue(String inputkey) {
			return table.get(inputkey);
		}
		public String putTableValue(String inputKey, int inputvalue) {
			table.put(inputKey,inputvalue);
			return "Ok";
		}
 
	    public static void main(String args[]) {
	 
			
	        try {
	            Server obj = new Server();
	            InterfaceHashMap stub = (InterfaceHashMap) UnicastRemoteObject.exportObject(obj, 0);

	            // Bind the remote object's stub in the registry
	            Registry registry = LocateRegistry.getRegistry();
	            registry.bind("HashMapRMI", stub);

	            System.err.println("Server ready");
	            
	            
	     

		
			
				Iterator<String> iterator;
			
				String file = "object.xml";//default file
				
				if (args.length == 1)
					file = args[0];		

				if (fileVerify(file)){//verify file
					table.clear();
					table = XMLCode.fileToMap(file);
				}	
				else{
					System.err.println ("error reading file "+file);
					System.exit(-1);
				}
	        } catch (Exception e) {
	            System.err.println("Server exception: " + e.toString());
	            e.printStackTrace();
	        }
	    }

	
}
