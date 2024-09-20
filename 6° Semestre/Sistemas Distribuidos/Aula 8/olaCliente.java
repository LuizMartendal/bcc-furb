package classes;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class olaCliente {
	
	private olaCliente() {}
	
	
	public static void main(String args[]) {
	
		try {
			//Obtém um stub de registro e invoca o método para obter o stub para o ojeto remoto registrado no servidor
			Registry registry = LocateRegistry.getRegistry();
			ola stub = (ola) registry.lookup("ola");
			
			//invoca o método remoto do objeto remoto
			String resposta = stub.digaOla();
			System.out.println("Resposta do Servidor " + resposta);
			
		} catch (Exception e) {
			// TODO: handle exceptions			
			System.out.println("OlaCliente exception: " + e.getMessage());
			e.printStackTrace();
		}
	}	
}