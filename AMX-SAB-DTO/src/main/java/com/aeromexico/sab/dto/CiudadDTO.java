package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table CIUDAD.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

public class CiudadDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1418481495;

    
    /**
    * id ciudad
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=idCiudad
    private Integer idCiudad;
    
    /**
    * nombre
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=nombre
    private String nombre;
    
    /**
    * id pais
    */
    // Simple: PK?false, FK?true, class=int, o=idPais
    private int idPais;
    
    /**
    * estatus
    */
    // Simple: PK?false, FK?false, class=java.lang.Short, o=estatus
    private Short estatus;

    /** 
     * Default Constructor
     */
    public CiudadDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdCiudad() {
        return this.idCiudad;
    }
    public void setIdCiudad(Integer v) {
        this.idCiudad = v;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public int getIdPais() {
        return this.idPais;
    }
    public void setIdPais(int v) {
        this.idPais = v;
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
		hash += String.valueOf(idCiudad).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(idPais).hashCode();
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
        if (!(o instanceof CiudadDTO)) {
            return false;
        }		
		CiudadDTO  other = (CiudadDTO ) o;
		if (!Objects.equals(this.idCiudad, other.idCiudad)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.idPais, other.idPais)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idCiudad", this.idCiudad);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("idPais", this.idPais);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static CiudadDTO create(String json) throws IllegalArgumentException{
		CiudadDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idCiudad = (jObj.getInt("idCiudad"));
		x.nombre = (jObj.getString("nombre"));
		x.idPais = (jObj.getInt("idPais"));
		x.estatus = (jObj.getShort("estatus"));
		
		return x;
	}

}
