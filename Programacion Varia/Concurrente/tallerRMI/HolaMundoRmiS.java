package tallerRMI;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;

public class HolaMundoRmiS {
	
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			
			if(System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			
			HolaMundoRmiO objRemoto = new HolaMundoRmiO();
			Naming.rebind("ObjetoHola", objRemoto);
			System.out.println("Objeto remoto preparado");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
