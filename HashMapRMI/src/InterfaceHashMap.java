import java.rmi.Remote;
import java.rmi.RemoteException;
public interface InterfaceHashMap extends Remote {
	 Integer getTableValue(String inputKey) throws RemoteException;
	 String  putTableValue(String inputKey,int inputvalue) throws RemoteException;
}