package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table CODIGO_SERVICIO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

public class CodigoServicioDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1828972342;

    
    /**
    * id codigo servicio
    */
    private Integer idCodigoServicio;
    
    /**
    * cve codigo servicio
    */
    private String cveCodigoServicio;
    
    /**
    * nombre
    */
    private String nombre;
    
    /**
    * estatus
    */
    private Short estatus;
    
    /**
    * tipo codigo servicio
    */
    private int tipoCodigoServicio;

    /** 
     * Default Constructor
     */
    public CodigoServicioDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdCodigoServicio() {
        return this.idCodigoServicio;
    }
    public void setIdCodigoServicio(Integer v) {
        this.idCodigoServicio = v;
    }
    public String getCveCodigoServicio() {
        return this.cveCodigoServicio;
    }
    public void setCveCodigoServicio(String v) {
        this.cveCodigoServicio = v;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public Short getEstatus() {
        return this.estatus;
    }
    public void setEstatus(Short v) {
        this.estatus = v;
    }
    public int getTipoCodigoServicio() {
        return this.tipoCodigoServicio;
    }
    public void setTipoCodigoServicio(int v) {
        this.tipoCodigoServicio = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idCodigoServicio).hashCode();
		hash += String.valueOf(cveCodigoServicio).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(estatus).hashCode();
		hash += String.valueOf(tipoCodigoServicio).hashCode();
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
        if (!(o instanceof CodigoServicioDTO)) {
            return false;
        }		
		CodigoServicioDTO  other = (CodigoServicioDTO ) o;
		if (!Objects.equals(this.idCodigoServicio, other.idCodigoServicio)) { return false; }		
		if (!Objects.equals(this.cveCodigoServicio, other.cveCodigoServicio)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
		if (!Objects.equals(this.tipoCodigoServicio, other.tipoCodigoServicio)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idCodigoServicio", this.idCodigoServicio);
		jsonObj.put("cveCodigoServicio", this.cveCodigoServicio);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("estatus", this.estatus);
		jsonObj.put("tipoCodigoServicio", this.tipoCodigoServicio);
		return jsonObj.toString();
    }

	public static CodigoServicioDTO create(String json) throws IllegalArgumentException{
		CodigoServicioDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idCodigoServicio = (jObj.getInt("idCodigoServicio"));
		x.cveCodigoServicio = (jObj.getString("cveCodigoServicio"));
		x.nombre = (jObj.getString("nombre"));
		x.estatus = (short)(jObj.getInt("estatus"));
		x.tipoCodigoServicio = (jObj.getInt("tipoCodigoServicio"));
		
		return x;
	}

}
