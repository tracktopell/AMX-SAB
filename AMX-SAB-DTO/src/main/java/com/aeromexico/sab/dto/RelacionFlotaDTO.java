package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table RELACION_FLOTA.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */

public class RelacionFlotaDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1072408673;

    
    /**
    * id relacion flota
    */
    private Integer idRelacionFlota;
    
    /**
    * revision
    */
    private int revision;
    
    /**
    * fecha
    */
    private java.sql.Date fecha;

    /** 
     * Default Constructor
     */
    public RelacionFlotaDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdRelacionFlota() {
        return this.idRelacionFlota;
    }
    public void setIdRelacionFlota(Integer v) {
        this.idRelacionFlota = v;
    }
    public int getRevision() {
        return this.revision;
    }
    public void setRevision(int v) {
        this.revision = v;
    }
    public java.sql.Date getFecha() {
        return this.fecha;
    }
    public void setFecha(java.sql.Date v) {
        this.fecha = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idRelacionFlota).hashCode();
		hash += String.valueOf(revision).hashCode();
		hash += String.valueOf(fecha).hashCode();
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
        if (!(o instanceof RelacionFlotaDTO)) {
            return false;
        }		
		RelacionFlotaDTO  other = (RelacionFlotaDTO ) o;
		if (!Objects.equals(this.idRelacionFlota, other.idRelacionFlota)) { return false; }		
		if (!Objects.equals(this.revision, other.revision)) { return false; }		
		if (!Objects.equals(this.fecha, other.fecha)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idRelacionFlota", this.idRelacionFlota);
		jsonObj.put("revision", this.revision);
		jsonObj.put("fecha", this.fecha);
		return jsonObj.toString();
    }

	public static RelacionFlotaDTO create(String json) throws IllegalArgumentException{
		RelacionFlotaDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idRelacionFlota = (jObj.getInt("idRelacionFlota"));
		x.revision = (jObj.getInt("revision"));
		x.fecha = new java.sql.Date(jObj.getLong("fecha"));
		
		return x;
	}

}
