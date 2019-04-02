package tallerRMI;

import java.rmi.Naming;

public class HolaMundoRmiC {
	
	public static void main(String[] args) {
		String direccion = "rmi://localhost/";
		
		try {
			HolaMundoRmiI hm = (HolaMundoRmiI) Naming.lookup(direccion + "ObjetoHola");
			System.out.println(hm.objRemotoHola("Mundo remoto!"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}

}
