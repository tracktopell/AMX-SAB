package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table COMPANIA.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

public class CompaniaDTO implements java.io.Serializable {
    private static final long serialVersionUID = 980546781;

    
    /**
    * id compania
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=idCompania
    private Integer idCompania;
    
    /**
    * cve compania
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=cveCompania
    private String cveCompania;
    
    /**
    * nombre
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=nombre
    private String nombre;
    
    /**
    * estatus
    */
    // Simple: PK?false, FK?false, class=java.lang.Short, o=estatus
    private Short estatus;

    /** 
     * Default Constructor
     */
    public CompaniaDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdCompania() {
        return this.idCompania;
    }
    public void setIdCompania(Integer v) {
        this.idCompania = v;
    }
    public String getCveCompania() {
        return this.cveCompania;
    }
    public void setCveCompania(String v) {
        this.cveCompania = v;
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

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idCompania).hashCode();
		hash += String.valueOf(cveCompania).hashCode();
		hash += String.valueOf(nombre).hashCode();
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
        if (!(o instanceof CompaniaDTO)) {
            return false;
        }		
		CompaniaDTO  other = (CompaniaDTO ) o;
		if (!Objects.equals(this.idCompania, other.idCompania)) { return false; }		
		if (!Objects.equals(this.cveCompania, other.cveCompania)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idCompania", this.idCompania);
		jsonObj.put("cveCompania", this.cveCompania);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static CompaniaDTO create(String json) throws IllegalArgumentException{
		CompaniaDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idCompania = (jObj.getInt("idCompania"));
		x.cveCompania = (jObj.getString("cveCompania"));
		x.nombre = (jObj.getString("nombre"));
		x.estatus = (jObj.getShort("estatus"));
		
		return x;
	}

}
