package tallerRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HolaMundoRmiO extends UnicastRemoteObject implements HolaMundoRmiI{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HolaMundoRmiO() throws RemoteException{
		super();
	}
	
	public String objRemotoHola(String cliente) throws RemoteException{
		return ("Hola " + cliente);
	}

}
