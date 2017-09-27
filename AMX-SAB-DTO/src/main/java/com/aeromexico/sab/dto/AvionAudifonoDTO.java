package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table AVION_AUDIFONO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

public class AvionAudifonoDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1607521710;

    
    /**
    * id avion audifono
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=idAvionAudifono
    private Integer idAvionAudifono;
    
    /**
    * id avion
    */
    // Simple: PK?false, FK?true, class=int, o=idAvion
    private int idAvion;
    
    /**
    * id clase
    */
    // Simple: PK?false, FK?true, class=int, o=idClase
    private int idClase;
    
    /**
    * tipo audifono
    */
    // Simple: PK?false, FK?true, class=int, o=tipoAudifono
    private int tipoAudifono;

    /** 
     * Default Constructor
     */
    public AvionAudifonoDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdAvionAudifono() {
        return this.idAvionAudifono;
    }
    public void setIdAvionAudifono(Integer v) {
        this.idAvionAudifono = v;
    }
    public int getIdAvion() {
        return this.idAvion;
    }
    public void setIdAvion(int v) {
        this.idAvion = v;
    }
    public int getIdClase() {
        return this.idClase;
    }
    public void setIdClase(int v) {
        this.idClase = v;
    }
    public int getTipoAudifono() {
        return this.tipoAudifono;
    }
    public void setTipoAudifono(int v) {
        this.tipoAudifono = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idAvionAudifono).hashCode();
		hash += String.valueOf(idAvion).hashCode();
		hash += String.valueOf(idClase).hashCode();
		hash += String.valueOf(tipoAudifono).hashCode();
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
        if (!(o instanceof AvionAudifonoDTO)) {
            return false;
        }		
		AvionAudifonoDTO  other = (AvionAudifonoDTO ) o;
		if (!Objects.equals(this.idAvionAudifono, other.idAvionAudifono)) { return false; }		
		if (!Objects.equals(this.idAvion, other.idAvion)) { return false; }		
		if (!Objects.equals(this.idClase, other.idClase)) { return false; }		
		if (!Objects.equals(this.tipoAudifono, other.tipoAudifono)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idAvionAudifono", this.idAvionAudifono);
		jsonObj.put("idAvion", this.idAvion);
		jsonObj.put("idClase", this.idClase);
		jsonObj.put("tipoAudifono", this.tipoAudifono);
		return jsonObj.toString();
    }

	public static AvionAudifonoDTO create(String json) throws IllegalArgumentException{
		AvionAudifonoDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idAvionAudifono = (jObj.getInt("idAvionAudifono"));
		x.idAvion = (jObj.getInt("idAvion"));
		x.idClase = (jObj.getInt("idClase"));
		x.tipoAudifono = (jObj.getInt("tipoAudifono"));
		
		return x;
	}

}
