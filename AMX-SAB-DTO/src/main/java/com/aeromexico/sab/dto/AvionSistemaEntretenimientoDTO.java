package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table AVION_SISTEMA_ENTRETENIMIENTO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

public class AvionSistemaEntretenimientoDTO implements java.io.Serializable {
    private static final long serialVersionUID = 455659002;

    
    /**
    * id avion sistema entretenimiento
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=idAvionSistemaEntretenimiento
    private Integer idAvionSistemaEntretenimiento;
    
    /**
    * id avion
    */
    // Simple: PK?false, FK?true, class=int, o=idAvion
    private int idAvion;
    
    /**
    * id sistema entretenimiento
    */
    // Simple: PK?false, FK?true, class=int, o=idSistemaEntretenimiento
    private int idSistemaEntretenimiento;

    /** 
     * Default Constructor
     */
    public AvionSistemaEntretenimientoDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdAvionSistemaEntretenimiento() {
        return this.idAvionSistemaEntretenimiento;
    }
    public void setIdAvionSistemaEntretenimiento(Integer v) {
        this.idAvionSistemaEntretenimiento = v;
    }
    public int getIdAvion() {
        return this.idAvion;
    }
    public void setIdAvion(int v) {
        this.idAvion = v;
    }
    public int getIdSistemaEntretenimiento() {
        return this.idSistemaEntretenimiento;
    }
    public void setIdSistemaEntretenimiento(int v) {
        this.idSistemaEntretenimiento = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idAvionSistemaEntretenimiento).hashCode();
		hash += String.valueOf(idAvion).hashCode();
		hash += String.valueOf(idSistemaEntretenimiento).hashCode();
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
        if (!(o instanceof AvionSistemaEntretenimientoDTO)) {
            return false;
        }		
		AvionSistemaEntretenimientoDTO  other = (AvionSistemaEntretenimientoDTO ) o;
		if (!Objects.equals(this.idAvionSistemaEntretenimiento, other.idAvionSistemaEntretenimiento)) { return false; }		
		if (!Objects.equals(this.idAvion, other.idAvion)) { return false; }		
		if (!Objects.equals(this.idSistemaEntretenimiento, other.idSistemaEntretenimiento)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idAvionSistemaEntretenimiento", this.idAvionSistemaEntretenimiento);
		jsonObj.put("idAvion", this.idAvion);
		jsonObj.put("idSistemaEntretenimiento", this.idSistemaEntretenimiento);
		return jsonObj.toString();
    }

	public static AvionSistemaEntretenimientoDTO create(String json) throws IllegalArgumentException{
		AvionSistemaEntretenimientoDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idAvionSistemaEntretenimiento = (jObj.getInt("idAvionSistemaEntretenimiento"));
		x.idAvion = (jObj.getInt("idAvion"));
		x.idSistemaEntretenimiento = (jObj.getInt("idSistemaEntretenimiento"));
		
		return x;
	}

}
