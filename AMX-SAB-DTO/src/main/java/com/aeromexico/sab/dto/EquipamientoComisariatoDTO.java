package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table EQUIPAMIENTO_COMISARIATO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

public class EquipamientoComisariatoDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1406718218;

    
    /**
    * id equipamiento comisariato
    */
    private Integer idEquipamientoComisariato;
    
    /**
    * id avion
    */
    private int idAvion;
    
    /**
    * nombre es
    */
    private String nombreEs;
    
    /**
    * nombre en
    */
    private String nombreEn;
    
    /**
    * cantidad
    */
    private int cantidad;
    
    /**
    * peso
    */
    private double peso;
    
    /**
    * observaciones
    */
    private String observaciones;
    
    /**
    * numero parte
    */
    private String numeroParte;
    
    /**
    * estatus
    */
    private Short estatus;

    /** 
     * Default Constructor
     */
    public EquipamientoComisariatoDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdEquipamientoComisariato() {
        return this.idEquipamientoComisariato;
    }
    public void setIdEquipamientoComisariato(Integer v) {
        this.idEquipamientoComisariato = v;
    }
    public int getIdAvion() {
        return this.idAvion;
    }
    public void setIdAvion(int v) {
        this.idAvion = v;
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
    public int getCantidad() {
        return this.cantidad;
    }
    public void setCantidad(int v) {
        this.cantidad = v;
    }
    public double getPeso() {
        return this.peso;
    }
    public void setPeso(double v) {
        this.peso = v;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    public void setObservaciones(String v) {
        this.observaciones = v;
    }
    public String getNumeroParte() {
        return this.numeroParte;
    }
    public void setNumeroParte(String v) {
        this.numeroParte = v;
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
		hash += String.valueOf(idEquipamientoComisariato).hashCode();
		hash += String.valueOf(idAvion).hashCode();
		hash += String.valueOf(nombreEs).hashCode();
		hash += String.valueOf(nombreEn).hashCode();
		hash += String.valueOf(cantidad).hashCode();
		hash += String.valueOf(peso).hashCode();
		hash += String.valueOf(observaciones).hashCode();
		hash += String.valueOf(numeroParte).hashCode();
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
        if (!(o instanceof EquipamientoComisariatoDTO)) {
            return false;
        }		
		EquipamientoComisariatoDTO  other = (EquipamientoComisariatoDTO ) o;
		if (!Objects.equals(this.idEquipamientoComisariato, other.idEquipamientoComisariato)) { return false; }		
		if (!Objects.equals(this.idAvion, other.idAvion)) { return false; }		
		if (!Objects.equals(this.nombreEs, other.nombreEs)) { return false; }		
		if (!Objects.equals(this.nombreEn, other.nombreEn)) { return false; }		
		if (!Objects.equals(this.cantidad, other.cantidad)) { return false; }		
		if (!Objects.equals(this.peso, other.peso)) { return false; }		
		if (!Objects.equals(this.observaciones, other.observaciones)) { return false; }		
		if (!Objects.equals(this.numeroParte, other.numeroParte)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idEquipamientoComisariato", this.idEquipamientoComisariato);
		jsonObj.put("idAvion", this.idAvion);
		jsonObj.put("nombreEs", this.nombreEs);
		jsonObj.put("nombreEn", this.nombreEn);
		jsonObj.put("cantidad", this.cantidad);
		jsonObj.put("peso", this.peso);
		jsonObj.put("observaciones", this.observaciones);
		jsonObj.put("numeroParte", this.numeroParte);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static EquipamientoComisariatoDTO create(String json) throws IllegalArgumentException{
		EquipamientoComisariatoDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idEquipamientoComisariato = (jObj.getInt("idEquipamientoComisariato"));
		x.idAvion = (jObj.getInt("idAvion"));
		x.nombreEs = (jObj.getString("nombreEs"));
		x.nombreEn = (jObj.getString("nombreEn"));
		x.cantidad = (jObj.getInt("cantidad"));
		x.peso = (jObj.getDouble("peso"));
		x.observaciones = (jObj.getString("observaciones"));
		x.numeroParte = (jObj.getString("numeroParte"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
