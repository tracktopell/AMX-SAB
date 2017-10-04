package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table AVION.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

public class AvionDTO implements java.io.Serializable {
    private static final long serialVersionUID = 664223387;

    
    /**
    * id avion
    */
    private Integer idAvion;
    
    /**
    * id tipo equipo avion
    */
    private int idTipoEquipoAvion;
    
    /**
    * matricula
    */
    private String matricula;
    
    /**
    * matricula corta
    */
    private String matriculaCorta;
    
    /**
    * estatus
    */
    private Short estatus;
    
    /**
    * id conectividad
    */
    private int idConectividad;

    /** 
     * Default Constructor
     */
    public AvionDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdAvion() {
        return this.idAvion;
    }
    public void setIdAvion(Integer v) {
        this.idAvion = v;
    }
    public int getIdTipoEquipoAvion() {
        return this.idTipoEquipoAvion;
    }
    public void setIdTipoEquipoAvion(int v) {
        this.idTipoEquipoAvion = v;
    }
    public String getMatricula() {
        return this.matricula;
    }
    public void setMatricula(String v) {
        this.matricula = v;
    }
    public String getMatriculaCorta() {
        return this.matriculaCorta;
    }
    public void setMatriculaCorta(String v) {
        this.matriculaCorta = v;
    }
    public Short getEstatus() {
        return this.estatus;
    }
    public void setEstatus(Short v) {
        this.estatus = v;
    }
    public int getIdConectividad() {
        return this.idConectividad;
    }
    public void setIdConectividad(int v) {
        this.idConectividad = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idAvion).hashCode();
		hash += String.valueOf(idTipoEquipoAvion).hashCode();
		hash += String.valueOf(matricula).hashCode();
		hash += String.valueOf(matriculaCorta).hashCode();
		hash += String.valueOf(estatus).hashCode();
		hash += String.valueOf(idConectividad).hashCode();
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
        if (!(o instanceof AvionDTO)) {
            return false;
        }		
		AvionDTO  other = (AvionDTO ) o;
		if (!Objects.equals(this.idAvion, other.idAvion)) { return false; }		
		if (!Objects.equals(this.idTipoEquipoAvion, other.idTipoEquipoAvion)) { return false; }		
		if (!Objects.equals(this.matricula, other.matricula)) { return false; }		
		if (!Objects.equals(this.matriculaCorta, other.matriculaCorta)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
		if (!Objects.equals(this.idConectividad, other.idConectividad)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idAvion", this.idAvion);
		jsonObj.put("idTipoEquipoAvion", this.idTipoEquipoAvion);
		jsonObj.put("matricula", this.matricula);
		jsonObj.put("matriculaCorta", this.matriculaCorta);
		jsonObj.put("estatus", this.estatus);
		jsonObj.put("idConectividad", this.idConectividad);
		return jsonObj.toString();
    }

	public static AvionDTO create(String json) throws IllegalArgumentException{
		AvionDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idAvion = (jObj.getInt("idAvion"));
		x.idTipoEquipoAvion = (jObj.getInt("idTipoEquipoAvion"));
		x.matricula = (jObj.getString("matricula"));
		x.matriculaCorta = (jObj.getString("matriculaCorta"));
		x.estatus = (short)(jObj.getInt("estatus"));
		x.idConectividad = (jObj.getInt("idConectividad"));
		
		return x;
	}

}
