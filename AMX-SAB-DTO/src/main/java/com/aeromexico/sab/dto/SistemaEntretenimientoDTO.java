package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table SISTEMA_ENTRETENIMIENTO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

public class SistemaEntretenimientoDTO implements java.io.Serializable {
    private static final long serialVersionUID = 2129789493;

    
    /**
    * id sistema entretenimiento
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=idSistemaEntretenimiento
    private Integer idSistemaEntretenimiento;
    
    /**
    * tipo
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=tipo
    private String tipo;
    
    /**
    * version
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=version
    private String version;
    
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
    public SistemaEntretenimientoDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdSistemaEntretenimiento() {
        return this.idSistemaEntretenimiento;
    }
    public void setIdSistemaEntretenimiento(Integer v) {
        this.idSistemaEntretenimiento = v;
    }
    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String v) {
        this.tipo = v;
    }
    public String getVersion() {
        return this.version;
    }
    public void setVersion(String v) {
        this.version = v;
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
		hash += String.valueOf(idSistemaEntretenimiento).hashCode();
		hash += String.valueOf(tipo).hashCode();
		hash += String.valueOf(version).hashCode();
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
        if (!(o instanceof SistemaEntretenimientoDTO)) {
            return false;
        }		
		SistemaEntretenimientoDTO  other = (SistemaEntretenimientoDTO ) o;
		if (!Objects.equals(this.idSistemaEntretenimiento, other.idSistemaEntretenimiento)) { return false; }		
		if (!Objects.equals(this.tipo, other.tipo)) { return false; }		
		if (!Objects.equals(this.version, other.version)) { return false; }		
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
		jsonObj.put("idSistemaEntretenimiento", this.idSistemaEntretenimiento);
		jsonObj.put("tipo", this.tipo);
		jsonObj.put("version", this.version);
		jsonObj.put("descripcion", this.descripcion);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static SistemaEntretenimientoDTO create(String json) throws IllegalArgumentException{
		SistemaEntretenimientoDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idSistemaEntretenimiento = (jObj.getInt("idSistemaEntretenimiento"));
		x.tipo = (jObj.getString("tipo"));
		x.version = (jObj.getString("version"));
		x.descripcion = (jObj.getString("descripcion"));
		x.estatus = (jObj.getShort("estatus"));
		
		return x;
	}

}
