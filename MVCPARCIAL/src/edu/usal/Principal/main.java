package edu.usal.Principal;

import java.io.IOException;
import edu.usal.controlador.consola.ControladorEmpresa;
import edu.usal.vista.consola.VistaEmpresa;

public class main {

	
	public static void main(String[]args) throws IOException{
		
		VistaEmpresa vista= new VistaEmpresa();
		ControladorEmpresa controladorEmpresa= new ControladorEmpresa(vista);
		
		controladorEmpresa.MostrarMenu();
	}
}
