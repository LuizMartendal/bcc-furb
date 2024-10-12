import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ola extends Remote {
	String digaOla() throws RemoteException;
}