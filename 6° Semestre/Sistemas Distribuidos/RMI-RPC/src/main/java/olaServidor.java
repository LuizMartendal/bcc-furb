import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class olaServidor implements ola {
	
	public olaServidor() {}
			
	public String digaOla() {
		System.out.println("A invocação para Ola foi com sucesso");
		return "Ola Mundo através do RMI Server";		
	}
	
	public static void main(String args[]) {
		try {
			//Cria e exporta um objeto remoto
			olaServidor obj = new olaServidor();
			ola stub = (ola) UnicastRemoteObject.exportObject(obj, 1099);
			
			//Registra o objeto remoto no registro Java RMI e vincula o método remoto ao stub criada
			//Registry registry = LocateRegistry.getRegistry();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("ola", stub);
			System.out.println("Ligado ao registro");						
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ocorreu um erro na ligação: " + e.getMessage());
		}
	}
}