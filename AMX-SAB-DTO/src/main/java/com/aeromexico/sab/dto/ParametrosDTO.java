package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table PARAMETROS.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */

public class ParametrosDTO implements java.io.Serializable {
    private static final long serialVersionUID = 868693306;

    
    /**
    * id parametro
    */
    private Integer idParametro;
    
    /**
    * clave
    */
    private String clave;
    
    /**
    * valor
    */
    private int valor;
    
    /**
    * estatus
    */
    private Short estatus;

    /** 
     * Default Constructor
     */
    public ParametrosDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdParametro() {
        return this.idParametro;
    }
    public void setIdParametro(Integer v) {
        this.idParametro = v;
    }
    public String getClave() {
        return this.clave;
    }
    public void setClave(String v) {
        this.clave = v;
    }
    public int getValor() {
        return this.valor;
    }
    public void setValor(int v) {
        this.valor = v;
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
		hash += String.valueOf(idParametro).hashCode();
		hash += String.valueOf(clave).hashCode();
		hash += String.valueOf(valor).hashCode();
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
        if (!(o instanceof ParametrosDTO)) {
            return false;
        }		
		ParametrosDTO  other = (ParametrosDTO ) o;
		if (!Objects.equals(this.idParametro, other.idParametro)) { return false; }		
		if (!Objects.equals(this.clave, other.clave)) { return false; }		
		if (!Objects.equals(this.valor, other.valor)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idParametro", this.idParametro);
		jsonObj.put("clave", this.clave);
		jsonObj.put("valor", this.valor);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static ParametrosDTO create(String json) throws IllegalArgumentException{
		ParametrosDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idParametro = (jObj.getInt("idParametro"));
		x.clave = (jObj.getString("clave"));
		x.valor = (jObj.getInt("valor"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
