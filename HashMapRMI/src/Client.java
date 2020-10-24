import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

 
public class Client {
	   private Client() {}

	    public static void main(String[] args) {
	    	Scanner scan = new Scanner(System.in);
	    	int option = 0;
			String inputkey,key,value;
			int inputvalue;
	        String host = (args.length < 1) ? null : args[0];
	        try {
	            Registry registry = LocateRegistry.getRegistry(host);
	            InterfaceHashMap stub = (InterfaceHashMap) registry.lookup("HashMapRMI");
	            while (true) {
	        		System.out.println("\nHash Map Menu:");
	    			System.out.println("   1.  test put(key,value)");
	    			System.out.println("   2.  test get(key)");
	    			System.out.print("Write a command:  ");
	    			option = scan.nextInt();
	    			switch (option) {
	    			case 1:
	    				System.out.print("\n   Key = ");
	    				inputkey = scan.next();
	    				System.out.print("   Value = ");
	    				inputvalue = scan.nextInt();
	    				 String responsePut = stub.putTableValue(inputkey,inputvalue);
	    				 System.out.println(responsePut);
	    				break; 
	    			case 2:
	    				System.out.print("\n   Key = ");
	    			    	inputkey = scan.next();
	    				 Integer responseGet = stub.getTableValue(inputkey);
	    				 System.out.println("   Value = " + responseGet);
	    				break;   
	    			}
	            }
	        } catch (Exception e) {
	            System.err.println("Client exception: " + e.toString());
	            e.printStackTrace();
	        }
	    }
}
