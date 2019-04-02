package tallerRMI;

import java.rmi.*;

public interface HolaMundoRmiI extends Remote{
	
	String objRemotoHola(String cliente) throws RemoteException;

}
