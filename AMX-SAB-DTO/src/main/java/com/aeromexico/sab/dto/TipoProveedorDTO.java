package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table TIPO_PROVEEDOR.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/03 13:52
 */

public class TipoProveedorDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1450495309;

    
    /**
    * id tipo proveedor
    */
    private Integer idTipoProveedor;
    
    /**
    * nombre es
    */
    private String nombreEs;
    
    /**
    * nombre en
    */
    private String nombreEn;
    
    /**
    * descripcion
    */
    private String descripcion;
    
    /**
    * estatus
    */
    private Short estatus;

    /** 
     * Default Constructor
     */
    public TipoProveedorDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdTipoProveedor() {
        return this.idTipoProveedor;
    }
    public void setIdTipoProveedor(Integer v) {
        this.idTipoProveedor = v;
    }
    public String getNombreEs() {
        return this.nombreEs;
    }
    public void setNombreEs(String v) {
        this.nombreEs = v;
    }
    public String getNombreEn() {
        return this.nombreEn;
    }
    public void setNombreEn(String v) {
        this.nombreEn = v;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String v) {
        this.descripcion = v;
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
		hash += String.valueOf(idTipoProveedor).hashCode();
		hash += String.valueOf(nombreEs).hashCode();
		hash += String.valueOf(nombreEn).hashCode();
		hash += String.valueOf(descripcion).hashCode();
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
        if (!(o instanceof TipoProveedorDTO)) {
            return false;
        }		
		TipoProveedorDTO  other = (TipoProveedorDTO ) o;
		if (!Objects.equals(this.idTipoProveedor, other.idTipoProveedor)) { return false; }		
		if (!Objects.equals(this.nombreEs, other.nombreEs)) { return false; }		
		if (!Objects.equals(this.nombreEn, other.nombreEn)) { return false; }		
		if (!Objects.equals(this.descripcion, other.descripcion)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idTipoProveedor", this.idTipoProveedor);
		jsonObj.put("nombreEs", this.nombreEs);
		jsonObj.put("nombreEn", this.nombreEn);
		jsonObj.put("descripcion", this.descripcion);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static TipoProveedorDTO create(String json) throws IllegalArgumentException{
		TipoProveedorDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idTipoProveedor = (jObj.getInt("idTipoProveedor"));
		x.nombreEs = (jObj.getString("nombreEs"));
		x.nombreEn = (jObj.getString("nombreEn"));
		x.descripcion = (jObj.getString("descripcion"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
