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
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

public class ContactoProveedorEstacionDTO implements java.io.Serializable {
    private static final long serialVersionUID = 885284298;

    
    /**
    * id
    */
    private Integer id;
    
    /**
    * email usuario
    */
    private String emailUsuario;
    
    /**
    * id proveedor
    */
    private int idProveedor;
    
    /**
    * id estacion
    */
    private int idEstacion;
    
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
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer v) {
        this.id = v;
    }
    public String getEmailUsuario() {
        return this.emailUsuario;
    }
    public void setEmailUsuario(String v) {
        this.emailUsuario = v;
    }
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
    public Short getEstatus() {
        return this.estatus;
    }
    public void setEstatus(Short v) {
        this.estatus = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(emailUsuario).hashCode();
		hash += String.valueOf(idProveedor).hashCode();
		hash += String.valueOf(idEstacion).hashCode();
		hash += String.valueOf(telefono).hashCode();
		hash += String.valueOf(extencion).hashCode();
		hash += String.valueOf(puestoAreaEn).hashCode();
		hash += String.valueOf(puestoAreaEs).hashCode();
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
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.emailUsuario, other.emailUsuario)) { return false; }		
		if (!Objects.equals(this.idProveedor, other.idProveedor)) { return false; }		
		if (!Objects.equals(this.idEstacion, other.idEstacion)) { return false; }		
		if (!Objects.equals(this.telefono, other.telefono)) { return false; }		
		if (!Objects.equals(this.extencion, other.extencion)) { return false; }		
		if (!Objects.equals(this.puestoAreaEn, other.puestoAreaEn)) { return false; }		
		if (!Objects.equals(this.puestoAreaEs, other.puestoAreaEs)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("emailUsuario", this.emailUsuario);
		jsonObj.put("idProveedor", this.idProveedor);
		jsonObj.put("idEstacion", this.idEstacion);
		jsonObj.put("telefono", this.telefono);
		jsonObj.put("extencion", this.extencion);
		jsonObj.put("puestoAreaEn", this.puestoAreaEn);
		jsonObj.put("puestoAreaEs", this.puestoAreaEs);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static ContactoProveedorEstacionDTO create(String json) throws IllegalArgumentException{
		ContactoProveedorEstacionDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.id = (jObj.getInt("id"));
		x.emailUsuario = (jObj.getString("emailUsuario"));
		x.idProveedor = (jObj.getInt("idProveedor"));
		x.idEstacion = (jObj.getInt("idEstacion"));
		x.telefono = (jObj.getString("telefono"));
		x.extencion = (jObj.getString("extencion"));
		x.puestoAreaEn = (jObj.getString("puestoAreaEn"));
		x.puestoAreaEs = (jObj.getString("puestoAreaEs"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
