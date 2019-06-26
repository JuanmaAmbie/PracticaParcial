package edu.usal.vista.consola;

import java.util.*;
import java.util.Scanner;

import edu.usal.negocio.dominio.Empresas;
import edu.usal.util.IOGeneral;

public class VistaEmpresa {
	private Scanner sc;
	
	public VistaEmpresa() {

}
	public int menu() {
		System.out.println("");
		System.out.println("1-Agregar Empresa");
		System.out.println("2-ver Empresa");
		System.out.println("3-Eliminar Empresa");
		System.out.println("4-cancelar");
		return IOGeneral.leerInt("Elija una opcion", "Solo números");
		
	}
	
	public Empresas AltaEmpresa() {
		
		Empresas empresa= new Empresas();
		
		empresa.setId(IOGeneral.leerLinea("Ingrese id"));
		empresa.setNombre(IOGeneral.leerLinea("Ingrese nombre"));
		empresa.setCuit(IOGeneral.leerInt("Ingrese cuit", null));
		empresa.setDireccion(IOGeneral.leerLinea("Ingrese direccion"));
		
		
		return empresa;
		
	}
	
	public String eliminarEmpresa() {
		
		String id= IOGeneral.leerLinea("Ingrese id a eliminar");
		
		return id;
	}
	public void imprimirTodos(List<Empresas>listado) {
		for(Empresas empresa: listado) {
			System.out.println("ID" + empresa.getid()+
			"NOMBRE:"+ empresa.getNombre() +
			"Cuit"+ empresa.getCuit()+
			"Direccion"+empresa.getDireccion()+"||");
		}
	}
	public void mensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
