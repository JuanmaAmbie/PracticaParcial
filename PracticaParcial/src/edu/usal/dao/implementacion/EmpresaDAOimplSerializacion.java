package edu.usal.dao.implementacion;

import java.io.*;
import java.util.*;

import edu.usal.negocio.dominio.Empresas;
import edu.usal.negocio.dao.interfaces.EmpresasDAO;

public class EmpresaDAOimplSerializacion implements EmpresasDAO{

	public EmpresaDAOimplSerializacion() throws IOException{

	}

	@Override
	public void AgregarEmpresa(Empresas empresa) throws IOException {
		FileOutputStream f= new FileOutputStream(new File("empresaS.txt"), true);
		ObjectOutputStream o= new ObjectOutputStream(f);
		
		o.writeObject(empresa);
		
		o.close();
		f.close();
	}

	@Override
	public boolean EliminarEmpresa(String id) {
		return false;
	}
	
	public Empresas getEmpresa() {
		try {
			FileInputStream fileIn= new FileInputStream("empresaS.txt");
			ObjectInputStream objectIn= new ObjectInputStream(fileIn);
			
			Empresas empresa=(Empresas) objectIn.readObject();
			
			System.out.println("Se ha leido el objeto desde el archivo");
			objectIn.close();
			return empresa;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Empresas> GetAll() throws IOException {
		
		FileInputStream fileis= new FileInputStream(new File("empresa.txt"));
		ObjectInputStream oiStream=new ObjectInputStream(fileis);
		List<Empresas> listadoempresa= new ArrayList<Empresas>();
		
		try {
			List<Empresas>readObject = (List<Empresas>) oiStream.readObject();
			listadoempresa= readObject;
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
			
		}finally {
			oiStream.close();
		}
		return listadoempresa;
	}

	@Override
	public void ModificarEmpresa(Empresas empresa) {
		// TODO Auto-generated method stub
		
	}

}
