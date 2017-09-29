package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table HORARIO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */

public class HorarioDTO implements java.io.Serializable {
    private static final long serialVersionUID = 668386784;

    
    /**
    * id horario
    */
    private Integer idHorario;
    
    /**
    * id region
    */
    private int idRegion;
    
    /**
    * hora inicio
    */
    private java.sql.Time horaInicio;
    
    /**
    * hora fin
    */
    private java.sql.Time horaFin;
    
    /**
    * estatus
    */
    private Short estatus;

    /** 
     * Default Constructor
     */
    public HorarioDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdHorario() {
        return this.idHorario;
    }
    public void setIdHorario(Integer v) {
        this.idHorario = v;
    }
    public int getIdRegion() {
        return this.idRegion;
    }
    public void setIdRegion(int v) {
        this.idRegion = v;
    }
    public java.sql.Time getHoraInicio() {
        return this.horaInicio;
    }
    public void setHoraInicio(java.sql.Time v) {
        this.horaInicio = v;
    }
    public java.sql.Time getHoraFin() {
        return this.horaFin;
    }
    public void setHoraFin(java.sql.Time v) {
        this.horaFin = v;
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
		hash += String.valueOf(idHorario).hashCode();
		hash += String.valueOf(idRegion).hashCode();
		hash += String.valueOf(horaInicio).hashCode();
		hash += String.valueOf(horaFin).hashCode();
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
        if (!(o instanceof HorarioDTO)) {
            return false;
        }		
		HorarioDTO  other = (HorarioDTO ) o;
		if (!Objects.equals(this.idHorario, other.idHorario)) { return false; }		
		if (!Objects.equals(this.idRegion, other.idRegion)) { return false; }		
		if (!Objects.equals(this.horaInicio, other.horaInicio)) { return false; }		
		if (!Objects.equals(this.horaFin, other.horaFin)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idHorario", this.idHorario);
		jsonObj.put("idRegion", this.idRegion);
		jsonObj.put("horaInicio", this.horaInicio);
		jsonObj.put("horaFin", this.horaFin);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static HorarioDTO create(String json) throws IllegalArgumentException{
		HorarioDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idHorario = (jObj.getInt("idHorario"));
		x.idRegion = (jObj.getInt("idRegion"));
		x.horaInicio = new java.sql.Time(jObj.getLong("horaInicio"));
		x.horaFin = new java.sql.Time(jObj.getLong("horaFin"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
