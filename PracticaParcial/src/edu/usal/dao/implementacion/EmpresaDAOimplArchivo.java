package edu.usal.dao.implementacion;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.usal.negocio.dominio.Empresas;
import edu.usal.negocio.dao.interfaces.EmpresasDAO;

public class EmpresaDAOimplArchivo  implements EmpresasDAO{
	
	private File archivo;
	private FileWriter w;
	private BufferedWriter bw;
	private FileReader r;
	private BufferedReader br;

	public EmpresaDAOimplArchivo() throws IOException{
		archivo=new File("empresa.txt");
	}
	@Override
	public void AgregarEmpresa(Empresas empresa) throws IOException {
		w= new FileWriter(archivo, true);
		bw= new BufferedWriter(w);
		
		String str= SaveEmpresa(empresa);
		
		bw.write(str);
		bw.flush();
		bw.close();
		
		
		
	}

	private String SaveEmpresa(Empresas empresa) {
		// TODO Auto-generated method stub
		return empresa.getid()+ "|" + empresa.getNombre()+ "|" + empresa.getRazonSocial()+ "|" + empresa.getCuit()+ "|" +empresa.getDireccion()+ "|" +empresa.getLocalidad()+empresa.getCodigopostal()+ "|" +empresa.getTelefono()+ "|" +empresa.getActividad()+"\n";
	}
	@Override
	public boolean EliminarEmpresa(String id) throws IOException {
		archivo = new File("empresa.txt");

		r = new FileReader(archivo );
		br = new BufferedReader(r);


		w= new FileWriter("eliminar.txt", false);
		bw = new BufferedWriter(w);
		
		String linea= br.readLine();
		
		boolean encontrado=false;
		while(linea!=null) {
			String[]lineaArray= linea.split(";");
			String idActual= lineaArray[1];
			
			if(id.equals(idActual)) {
				encontrado=true;
			}
			else {
				bw.write(linea);
				bw.newLine();
			}
			linea=br.readLine();
		}
		bw.flush();
		bw.close();
		
		if(encontrado==true) {
			r=new FileReader("eliminar.txt");
			br=new BufferedReader(r);
			
			w=new FileWriter("empresa.txt", false);
			bw= new BufferedWriter(w);
			
			String linea2= br.readLine();
			
			while(linea2!=null) {
				bw.write(linea2);
				bw.newLine();
				
				linea2= br.readLine();
			}
			bw.flush();
			bw.close();
			}
			
	

		return encontrado;
	}

	@Override
	public List<Empresas> GetAll() throws IOException {


		archivo=new File("empresa.txt");
		
		r= new FileReader(archivo);
		br= new BufferedReader(r);
		
		String linea;
		List<Empresas> listadoempresa= new ArrayList<Empresas>();
		
		while((linea=br.readLine())!=null) {
			listadoempresa.add(ParseEmpresa(linea));
		}
		return listadoempresa;
	}
	
	private Empresas ParseEmpresa(String linea) {
		String[] atributos=linea.split(";");
		
		Empresas empresa= new Empresas();
		empresa.setId(atributos[0]);
		empresa.setNombre(atributos[1]);
		int Cuit= Integer.parseInt(atributos[2]);
		empresa.setDireccion(atributos[3]);
		empresa.setLocalidad(atributos[4]);
		//empresa.setFechainicio(atributos[5]);
		int Codigopostal= Integer.parseInt(atributos[5]);
		int Telefono= Integer.parseInt(atributos[6]);
		
		empresa.setActividad(atributos[7]);
		
		return empresa;
		
	}

	@Override
	public void ModificarEmpresa(Empresas empresa) {
		// TODO Auto-generated method stub
		
	}
	
	

}
