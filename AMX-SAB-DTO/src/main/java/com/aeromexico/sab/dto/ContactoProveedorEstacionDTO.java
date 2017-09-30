package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table CONTACTO_PROVEEDOR_ESTACION.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */

public class ContactoProveedorEstacionDTO implements java.io.Serializable {
    private static final long serialVersionUID = 885284298;

    
    /**
    * id proveedor
    */
    private int idProveedor;
    
    /**
    * id estacion
    */
    private int idEstacion;
    
    /**
    * nombre
    */
    private String nombre;
    
    /**
    * email
    */
    private String email;
    
    /**
    * telefono
    */
    private String telefono;
    
    /**
    * extencion
    */
    private String extencion;
    
    /**
    * puesto area en
    */
    private String puestoAreaEn;
    
    /**
    * puesto area es
    */
    private String puestoAreaEs;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * id usuario
    */
    private int idUsuario;
    
    /**
    * estatus
    */
    private Short estatus;

    /** 
     * Default Constructor
     */
    public ContactoProveedorEstacionDTO() {
    }

    /**
     * Getters and Setters
     */
    public int getIdProveedor() {
        return this.idProveedor;
    }
    public void setIdProveedor(int v) {
        this.idProveedor = v;
    }
    public int getIdEstacion() {
        return this.idEstacion;
    }
    public void setIdEstacion(int v) {
        this.idEstacion = v;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String v) {
        this.email = v;
    }
    public String getTelefono() {
        return this.telefono;
    }
    public void setTelefono(String v) {
        this.telefono = v;
    }
    public String getExtencion() {
        return this.extencion;
    }
    public void setExtencion(String v) {
        this.extencion = v;
    }
    public String getPuestoAreaEn() {
        return this.puestoAreaEn;
    }
    public void setPuestoAreaEn(String v) {
        this.puestoAreaEn = v;
    }
    public String getPuestoAreaEs() {
        return this.puestoAreaEs;
    }
    public void setPuestoAreaEs(String v) {
        this.puestoAreaEs = v;
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer v) {
        this.id = v;
    }
    public int getIdUsuario() {
        return this.idUsuario;
    }
    public void setIdUsuario(int v) {
        this.idUsuario = v;
    }
    public Short getEstatus() {
        return this.estatus;
    }
    public void setEstatus(Short v) {
        this.estatus = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idProveedor).hashCode();
		hash += String.valueOf(idEstacion).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(email).hashCode();
		hash += String.valueOf(telefono).hashCode();
		hash += String.valueOf(extencion).hashCode();
		hash += String.valueOf(puestoAreaEn).hashCode();
		hash += String.valueOf(puestoAreaEs).hashCode();
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(idUsuario).hashCode();
		hash += String.valueOf(estatus).hashCode();
        return hash;
    }

	@Override
    public boolean equals(Object o){
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}        
        if (!(o instanceof ContactoProveedorEstacionDTO)) {
            return false;
        }		
		ContactoProveedorEstacionDTO  other = (ContactoProveedorEstacionDTO ) o;
		if (!Objects.equals(this.idProveedor, other.idProveedor)) { return false; }		
		if (!Objects.equals(this.idEstacion, other.idEstacion)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.email, other.email)) { return false; }		
		if (!Objects.equals(this.telefono, other.telefono)) { return false; }		
		if (!Objects.equals(this.extencion, other.extencion)) { return false; }		
		if (!Objects.equals(this.puestoAreaEn, other.puestoAreaEn)) { return false; }		
		if (!Objects.equals(this.puestoAreaEs, other.puestoAreaEs)) { return false; }		
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.idUsuario, other.idUsuario)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idProveedor", this.idProveedor);
		jsonObj.put("idEstacion", this.idEstacion);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("email", this.email);
		jsonObj.put("telefono", this.telefono);
		jsonObj.put("extencion", this.extencion);
		jsonObj.put("puestoAreaEn", this.puestoAreaEn);
		jsonObj.put("puestoAreaEs", this.puestoAreaEs);
		jsonObj.put("id", this.id);
		jsonObj.put("idUsuario", this.idUsuario);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static ContactoProveedorEstacionDTO create(String json) throws IllegalArgumentException{
		ContactoProveedorEstacionDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idProveedor = (jObj.getInt("idProveedor"));
		x.idEstacion = (jObj.getInt("idEstacion"));
		x.nombre = (jObj.getString("nombre"));
		x.email = (jObj.getString("email"));
		x.telefono = (jObj.getString("telefono"));
		x.extencion = (jObj.getString("extencion"));
		x.puestoAreaEn = (jObj.getString("puestoAreaEn"));
		x.puestoAreaEs = (jObj.getString("puestoAreaEs"));
		x.id = (jObj.getInt("id"));
		x.idUsuario = (jObj.getInt("idUsuario"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
