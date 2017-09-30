package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table MASTER.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */

public class MasterDTO implements java.io.Serializable {
    private static final long serialVersionUID = 468121027;

    
    /**
    * id kit
    */
    private String idKit;
    
    /**
    * nombre es
    */
    private String nombreEs;
    
    /**
    * nombre en
    */
    private String nombreEn;
    
    /**
    * url multimedia
    */
    private String urlMultimedia;
    
    /**
    * contenedor
    */
    private String contenedor;
    
    /**
    * id unidad medida
    */
    private int idUnidadMedida;
    
    /**
    * id instrucciones nacionales
    */
    private int idInstruccionesNacionales;
    
    /**
    * id instrucciones internac
    */
    private int idInstruccionesInternac;
    
    /**
    * id tipo kit
    */
    private int idTipoKit;

    /** 
     * Default Constructor
     */
    public MasterDTO() {
    }

    /**
     * Getters and Setters
     */
    public String getIdKit() {
        return this.idKit;
    }
    public void setIdKit(String v) {
        this.idKit = v;
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
    public String getUrlMultimedia() {
        return this.urlMultimedia;
    }
    public void setUrlMultimedia(String v) {
        this.urlMultimedia = v;
    }
    public String getContenedor() {
        return this.contenedor;
    }
    public void setContenedor(String v) {
        this.contenedor = v;
    }
    public int getIdUnidadMedida() {
        return this.idUnidadMedida;
    }
    public void setIdUnidadMedida(int v) {
        this.idUnidadMedida = v;
    }
    public int getIdInstruccionesNacionales() {
        return this.idInstruccionesNacionales;
    }
    public void setIdInstruccionesNacionales(int v) {
        this.idInstruccionesNacionales = v;
    }
    public int getIdInstruccionesInternac() {
        return this.idInstruccionesInternac;
    }
    public void setIdInstruccionesInternac(int v) {
        this.idInstruccionesInternac = v;
    }
    public int getIdTipoKit() {
        return this.idTipoKit;
    }
    public void setIdTipoKit(int v) {
        this.idTipoKit = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idKit).hashCode();
		hash += String.valueOf(nombreEs).hashCode();
		hash += String.valueOf(nombreEn).hashCode();
		hash += String.valueOf(urlMultimedia).hashCode();
		hash += String.valueOf(contenedor).hashCode();
		hash += String.valueOf(idUnidadMedida).hashCode();
		hash += String.valueOf(idInstruccionesNacionales).hashCode();
		hash += String.valueOf(idInstruccionesInternac).hashCode();
		hash += String.valueOf(idTipoKit).hashCode();
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
        if (!(o instanceof MasterDTO)) {
            return false;
        }		
		MasterDTO  other = (MasterDTO ) o;
		if (!Objects.equals(this.idKit, other.idKit)) { return false; }		
		if (!Objects.equals(this.nombreEs, other.nombreEs)) { return false; }		
		if (!Objects.equals(this.nombreEn, other.nombreEn)) { return false; }		
		if (!Objects.equals(this.urlMultimedia, other.urlMultimedia)) { return false; }		
		if (!Objects.equals(this.contenedor, other.contenedor)) { return false; }		
		if (!Objects.equals(this.idUnidadMedida, other.idUnidadMedida)) { return false; }		
		if (!Objects.equals(this.idInstruccionesNacionales, other.idInstruccionesNacionales)) { return false; }		
		if (!Objects.equals(this.idInstruccionesInternac, other.idInstruccionesInternac)) { return false; }		
		if (!Objects.equals(this.idTipoKit, other.idTipoKit)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idKit", this.idKit);
		jsonObj.put("nombreEs", this.nombreEs);
		jsonObj.put("nombreEn", this.nombreEn);
		jsonObj.put("urlMultimedia", this.urlMultimedia);
		jsonObj.put("contenedor", this.contenedor);
		jsonObj.put("idUnidadMedida", this.idUnidadMedida);
		jsonObj.put("idInstruccionesNacionales", this.idInstruccionesNacionales);
		jsonObj.put("idInstruccionesInternac", this.idInstruccionesInternac);
		jsonObj.put("idTipoKit", this.idTipoKit);
		return jsonObj.toString();
    }

	public static MasterDTO create(String json) throws IllegalArgumentException{
		MasterDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idKit = (jObj.getString("idKit"));
		x.nombreEs = (jObj.getString("nombreEs"));
		x.nombreEn = (jObj.getString("nombreEn"));
		x.urlMultimedia = (jObj.getString("urlMultimedia"));
		x.contenedor = (jObj.getString("contenedor"));
		x.idUnidadMedida = (jObj.getInt("idUnidadMedida"));
		x.idInstruccionesNacionales = (jObj.getInt("idInstruccionesNacionales"));
		x.idInstruccionesInternac = (jObj.getInt("idInstruccionesInternac"));
		x.idTipoKit = (jObj.getInt("idTipoKit"));
		
		return x;
	}

}
