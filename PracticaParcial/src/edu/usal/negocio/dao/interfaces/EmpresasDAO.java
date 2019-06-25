package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import edu.usal.negocio.dominio.Empresas;

public interface EmpresasDAO {
	
	public void AgregarEmpresa(Empresas empresa) throws IOException;
	
	public boolean EliminarEmpresa(String id) throws IOException;
	
	List<Empresas> GetAll() throws IOException;
	
	void ModificarEmpresa(Empresas empresa);

}
