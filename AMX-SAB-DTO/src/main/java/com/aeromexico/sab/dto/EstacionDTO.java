package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table ESTACION.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

public class EstacionDTO implements java.io.Serializable {
    private static final long serialVersionUID = 495053715;

    
    /**
    * id estacion
    */
    private Integer idEstacion;
    
    /**
    * nombre
    */
    private String nombre;
    
    /**
    * clave iata
    */
    private String claveIata;
    
    /**
    * id ciudad
    */
    private int idCiudad;
    
    /**
    * observaciones
    */
    private String observaciones;
    
    /**
    * estatus
    */
    private Short estatus;

    /** 
     * Default Constructor
     */
    public EstacionDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdEstacion() {
        return this.idEstacion;
    }
    public void setIdEstacion(Integer v) {
        this.idEstacion = v;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public String getClaveIata() {
        return this.claveIata;
    }
    public void setClaveIata(String v) {
        this.claveIata = v;
    }
    public int getIdCiudad() {
        return this.idCiudad;
    }
    public void setIdCiudad(int v) {
        this.idCiudad = v;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    public void setObservaciones(String v) {
        this.observaciones = v;
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
		hash += String.valueOf(idEstacion).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(claveIata).hashCode();
		hash += String.valueOf(idCiudad).hashCode();
		hash += String.valueOf(observaciones).hashCode();
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
        if (!(o instanceof EstacionDTO)) {
            return false;
        }		
		EstacionDTO  other = (EstacionDTO ) o;
		if (!Objects.equals(this.idEstacion, other.idEstacion)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.claveIata, other.claveIata)) { return false; }		
		if (!Objects.equals(this.idCiudad, other.idCiudad)) { return false; }		
		if (!Objects.equals(this.observaciones, other.observaciones)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idEstacion", this.idEstacion);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("claveIata", this.claveIata);
		jsonObj.put("idCiudad", this.idCiudad);
		jsonObj.put("observaciones", this.observaciones);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static EstacionDTO create(String json) throws IllegalArgumentException{
		EstacionDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idEstacion = (jObj.getInt("idEstacion"));
		x.nombre = (jObj.getString("nombre"));
		x.claveIata = (jObj.getString("claveIata"));
		x.idCiudad = (jObj.getInt("idCiudad"));
		x.observaciones = (jObj.getString("observaciones"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
