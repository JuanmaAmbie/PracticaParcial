package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.util.Date;

public class Empresas implements Serializable {
	
	private String id;
	private String nombre;
	private String RazonSocial;
	private int cuit;
	private Date fechainicio;
	private String direccion;
	private String localidad;
	private int codigopostal;
	private int telefono;
	private String actividad;
	
	
	public Empresas(String id,String nombre, String razonSocial, int cuit, Date fechainicio, String direccion, String localidad,
			int codigopostal, int telefono, String actividad) {

		this.id=id;
		this.nombre = nombre;
		this.RazonSocial = razonSocial;
		this.cuit = cuit;
		this.fechainicio = fechainicio;
		this.direccion = direccion;
		this.localidad = localidad;
		this.codigopostal = codigopostal;
		this.telefono = telefono;
		this.actividad = actividad;
	}
	
	public Empresas() {
		
	}
      public String getid() {
	  return id;}
  public void setId(String id) {
	  this.id=id;}
  

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRazonSocial() {
		return RazonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		RazonSocial = razonSocial;
	}


	public int getCuit() {
		return cuit;
	}


	public void setCuit(int cuit) {
		this.cuit = cuit;
	}


	public Date getFechainicio() {
		return fechainicio;
	}


	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public int getCodigopostal() {
		return codigopostal;
	}


	public void setCodigopostal(int codigopostal) {
		this.codigopostal = codigopostal;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getActividad() {
		return actividad;
	}


	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	@Override
	public String toString() {
		return 
				 "id: " + this.id+ "\n Nombre: "+ this.nombre +
				"\nRazón Social: "+this.RazonSocial+ 
				"\nCuit: "+ this.cuit+
				"\nFecha inciio: "+this.fechainicio+
				"\nDireccion: "+this.direccion+
				"\nLocalidad: "+this.localidad+
				"\nCodigopostal: "+this.codigopostal+
				"\nTelefono: "+this.telefono+
				"\nActividad: "+this.actividad;
	}
	 
		 
	 }
	 
	 
	

