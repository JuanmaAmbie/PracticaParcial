package edu.usal.dao.main;


import java.io.IOException;
import java.util.*;

import edu.usal.dao.implementacion.*;
import edu.usal.negocio.dominio.*;
import edu.usal.negocio.dao.interfaces.*;
import edu.usal.dao.factory.*;

public class Ejecucion {
	public static void main(String[]args) throws IOException, ClassNotFoundException{
		
		
		Empresas e1=new Empresas();
		Empresas e2=new Empresas("12","LUcasRT", "OSDE", 12314352, null, "Ituzango 1051", "Lujan", 3700, 23434532, "Lavado autos");
		e1.setId("15");
		e1.setNombre("Voy a desaprobar");
		e1.setTelefono(2345);
		Scanner sc= new Scanner(System.in);
		EmpresasDAO impDAO= EmpresaFactory.GetImplementation("Archivo");
		EmpresaDAOimplSerializacion cd= new EmpresaDAOimplSerializacion();
		
		try {
			e1.setNombre("Cambiadosfdgh");
			impDAO.AgregarEmpresa(e1);
			impDAO.AgregarEmpresa(e2);
			List<Empresas> lista=impDAO.GetAll();
			
			for(Empresas empresa: lista) {
				System.out.println(empresa.toString());
			}
			System.out.println(impDAO.EliminarEmpresa("12"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
 
}
