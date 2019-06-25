package edu.usal.dao.factory;

import edu.usal.negocio.dao.interfaces.EmpresasDAO;
import edu.usal.dao.implementacion.*;
import java.io.IOException;


public class EmpresaFactory {
	
	public static EmpresasDAO GetImplementation(String source)throws IOException{
		
		if(source.equalsIgnoreCase("Archivo")) {
			return new EmpresaDAOimplArchivo();
		}
		else if(source.equalsIgnoreCase("Serializacion")) {
			return new EmpresaDAOimplSerializacion();
			
		}
		return null;
	}

}
