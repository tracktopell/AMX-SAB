package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table CATEGORIA_MATERIAL.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

public class CategoriaMaterialDTO implements java.io.Serializable {
    private static final long serialVersionUID = 142257191;

    
    /**
    * id categoria material
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=idCategoriaMaterial
    private Integer idCategoriaMaterial;
    
    /**
    * nombre es
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=nombreEs
    private String nombreEs;
    
    /**
    * nombre en
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=nombreEn
    private String nombreEn;
    
    /**
    * descripcion
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=descripcion
    private String descripcion;
    
    /**
    * estatus
    */
    // Simple: PK?false, FK?false, class=java.lang.Short, o=estatus
    private Short estatus;

    /** 
     * Default Constructor
     */
    public CategoriaMaterialDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdCategoriaMaterial() {
        return this.idCategoriaMaterial;
    }
    public void setIdCategoriaMaterial(Integer v) {
        this.idCategoriaMaterial = v;
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
		hash += String.valueOf(idCategoriaMaterial).hashCode();
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
        if (!(o instanceof CategoriaMaterialDTO)) {
            return false;
        }		
		CategoriaMaterialDTO  other = (CategoriaMaterialDTO ) o;
		if (!Objects.equals(this.idCategoriaMaterial, other.idCategoriaMaterial)) { return false; }		
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
		jsonObj.put("idCategoriaMaterial", this.idCategoriaMaterial);
		jsonObj.put("nombreEs", this.nombreEs);
		jsonObj.put("nombreEn", this.nombreEn);
		jsonObj.put("descripcion", this.descripcion);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static CategoriaMaterialDTO create(String json) throws IllegalArgumentException{
		CategoriaMaterialDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idCategoriaMaterial = (jObj.getInt("idCategoriaMaterial"));
		x.nombreEs = (jObj.getString("nombreEs"));
		x.nombreEn = (jObj.getString("nombreEn"));
		x.descripcion = (jObj.getString("descripcion"));
		x.estatus = (jObj.getShort("estatus"));
		
		return x;
	}

}
