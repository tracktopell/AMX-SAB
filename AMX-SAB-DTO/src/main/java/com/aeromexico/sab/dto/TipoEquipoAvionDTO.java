package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table TIPO_EQUIPO_AVION.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */

public class TipoEquipoAvionDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1528902577;

    
    /**
    * id tipo equipo avion
    */
    private Integer idTipoEquipoAvion;
    
    /**
    * id modelo avion
    */
    private int idModeloAvion;
    
    /**
    * total aviones
    */
    private Short totalAviones;
    
    /**
    * tipo equipo
    */
    private String tipoEquipo;
    
    /**
    * estatus
    */
    private Short estatus;

    /** 
     * Default Constructor
     */
    public TipoEquipoAvionDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdTipoEquipoAvion() {
        return this.idTipoEquipoAvion;
    }
    public void setIdTipoEquipoAvion(Integer v) {
        this.idTipoEquipoAvion = v;
    }
    public int getIdModeloAvion() {
        return this.idModeloAvion;
    }
    public void setIdModeloAvion(int v) {
        this.idModeloAvion = v;
    }
    public Short getTotalAviones() {
        return this.totalAviones;
    }
    public void setTotalAviones(Short v) {
        this.totalAviones = v;
    }
    public String getTipoEquipo() {
        return this.tipoEquipo;
    }
    public void setTipoEquipo(String v) {
        this.tipoEquipo = v;
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
		hash += String.valueOf(idTipoEquipoAvion).hashCode();
		hash += String.valueOf(idModeloAvion).hashCode();
		hash += String.valueOf(totalAviones).hashCode();
		hash += String.valueOf(tipoEquipo).hashCode();
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
        if (!(o instanceof TipoEquipoAvionDTO)) {
            return false;
        }		
		TipoEquipoAvionDTO  other = (TipoEquipoAvionDTO ) o;
		if (!Objects.equals(this.idTipoEquipoAvion, other.idTipoEquipoAvion)) { return false; }		
		if (!Objects.equals(this.idModeloAvion, other.idModeloAvion)) { return false; }		
		if (!Objects.equals(this.totalAviones, other.totalAviones)) { return false; }		
		if (!Objects.equals(this.tipoEquipo, other.tipoEquipo)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idTipoEquipoAvion", this.idTipoEquipoAvion);
		jsonObj.put("idModeloAvion", this.idModeloAvion);
		jsonObj.put("totalAviones", this.totalAviones);
		jsonObj.put("tipoEquipo", this.tipoEquipo);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static TipoEquipoAvionDTO create(String json) throws IllegalArgumentException{
		TipoEquipoAvionDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idTipoEquipoAvion = (jObj.getInt("idTipoEquipoAvion"));
		x.idModeloAvion = (jObj.getInt("idModeloAvion"));
		x.totalAviones = (short)(jObj.getInt("totalAviones"));
		x.tipoEquipo = (jObj.getString("tipoEquipo"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
