package tallerMonitores;

public class Program {
	
	public static void main(String[] args) {
		MonitorTenedores monitor = new MonitorTenedores();
		
		new Filosofo("Platon", monitor);
		new Filosofo("Confucio", monitor);
		new Filosofo("Socrates", monitor);
		new Filosofo("Voltaire", monitor);
		new Filosofo("Descartes", monitor);
	}

}
