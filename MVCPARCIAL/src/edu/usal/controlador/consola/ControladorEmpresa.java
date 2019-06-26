package edu.usal.controlador.consola;

import java.io.IOException;
import java.util.List;

import edu.usal.dao.factory.EmpresaFactory;
import edu.usal.negocio.dominio.Empresas;
import edu.usal.vista.consola.VistaEmpresa;
import edu.usal.negocio.dao.interfaces.EmpresasDAO;

public class ControladorEmpresa {

	
	private VistaEmpresa vista;
	private EmpresasDAO empresaDAO;
	
	public ControladorEmpresa(VistaEmpresa vista) throws IOException{
		super();
		this.vista=vista;
		this.empresaDAO= EmpresaFactory.GetImplementation("Archivo");	
}
	public void AgregarEmpresa() throws IOException{
		
		this.empresaDAO.AgregarEmpresa(vista.AltaEmpresa());
	}
	
	public boolean EliminarEmpresa() throws IOException{
		String id=vista.eliminarEmpresa();
		if(id.equals("back")) {
			return false;
		}
		boolean encontrado= this.empresaDAO.EliminarEmpresa(id);
		if(encontrado==true) {
			vista.mensaje("Se elimino el registro con id: "+id+"\n");
			Todos();
		}
		else {
			vista.mensaje("No se encontro");
		}
		return encontrado;
		
	}
	public void Todos() throws IOException{
		vista.imprimirTodos(this.empresaDAO.GetAll());
	}
	public void MostrarMenu() throws IOException{
		boolean fin= false;
		while(!fin) {
			int opcion=vista.menu();
			switch(opcion) {
			case 1:
				this.AgregarEmpresa();
				break;
			case 2:
				this.Todos();
				break;
				
			case 3:
				this.EliminarEmpresa();
				
			case 4:
				fin=true;
				break;
				
				default:
					System.out.println("Opción no válida");
			}
		}
	}
}