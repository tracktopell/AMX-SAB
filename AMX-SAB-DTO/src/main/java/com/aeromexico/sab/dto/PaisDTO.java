package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table PAIS.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

public class PaisDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1324119927;

    
    /**
    * id pais
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=idPais
    private Integer idPais;
    
    /**
    * cve pais
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=cvePais
    private String cvePais;
    
    /**
    * nombre
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=nombre
    private String nombre;
    
    /**
    * id region
    */
    // Simple: PK?false, FK?true, class=int, o=idRegion
    private int idRegion;
    
    /**
    * estatus
    */
    // Simple: PK?false, FK?false, class=java.lang.Short, o=estatus
    private Short estatus;

    /** 
     * Default Constructor
     */
    public PaisDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdPais() {
        return this.idPais;
    }
    public void setIdPais(Integer v) {
        this.idPais = v;
    }
    public String getCvePais() {
        return this.cvePais;
    }
    public void setCvePais(String v) {
        this.cvePais = v;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public int getIdRegion() {
        return this.idRegion;
    }
    public void setIdRegion(int v) {
        this.idRegion = v;
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
		hash += String.valueOf(idPais).hashCode();
		hash += String.valueOf(cvePais).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(idRegion).hashCode();
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
        if (!(o instanceof PaisDTO)) {
            return false;
        }		
		PaisDTO  other = (PaisDTO ) o;
		if (!Objects.equals(this.idPais, other.idPais)) { return false; }		
		if (!Objects.equals(this.cvePais, other.cvePais)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.idRegion, other.idRegion)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idPais", this.idPais);
		jsonObj.put("cvePais", this.cvePais);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("idRegion", this.idRegion);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static PaisDTO create(String json) throws IllegalArgumentException{
		PaisDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idPais = (jObj.getInt("idPais"));
		x.cvePais = (jObj.getString("cvePais"));
		x.nombre = (jObj.getString("nombre"));
		x.idRegion = (jObj.getInt("idRegion"));
		x.estatus = (jObj.getShort("estatus"));
		
		return x;
	}

}
