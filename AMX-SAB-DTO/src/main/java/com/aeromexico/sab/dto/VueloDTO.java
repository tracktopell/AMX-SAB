package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table VUELO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

public class VueloDTO implements java.io.Serializable {
    private static final long serialVersionUID = 834600351;

    
    /**
    * id vuelo
    */
    private Integer idVuelo;
    
    /**
    * numero vuelo
    */
    private int numeroVuelo;
    
    /**
    * tipo vuelo
    */
    private int tipoVuelo;
    
    /**
    * id estacion origen
    */
    private int idEstacionOrigen;
    
    /**
    * id estacion destino
    */
    private int idEstacionDestino;
    
    /**
    * tipo cabina
    */
    private int tipoCabina;
    
    /**
    * id compania
    */
    private int idCompania;
    
    /**
    * id clase
    */
    private int idClase;
    
    /**
    * estatus
    */
    private Short estatus;

    /** 
     * Default Constructor
     */
    public VueloDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdVuelo() {
        return this.idVuelo;
    }
    public void setIdVuelo(Integer v) {
        this.idVuelo = v;
    }
    public int getNumeroVuelo() {
        return this.numeroVuelo;
    }
    public void setNumeroVuelo(int v) {
        this.numeroVuelo = v;
    }
    public int getTipoVuelo() {
        return this.tipoVuelo;
    }
    public void setTipoVuelo(int v) {
        this.tipoVuelo = v;
    }
    public int getIdEstacionOrigen() {
        return this.idEstacionOrigen;
    }
    public void setIdEstacionOrigen(int v) {
        this.idEstacionOrigen = v;
    }
    public int getIdEstacionDestino() {
        return this.idEstacionDestino;
    }
    public void setIdEstacionDestino(int v) {
        this.idEstacionDestino = v;
    }
    public int getTipoCabina() {
        return this.tipoCabina;
    }
    public void setTipoCabina(int v) {
        this.tipoCabina = v;
    }
    public int getIdCompania() {
        return this.idCompania;
    }
    public void setIdCompania(int v) {
        this.idCompania = v;
    }
    public int getIdClase() {
        return this.idClase;
    }
    public void setIdClase(int v) {
        this.idClase = v;
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
		hash += String.valueOf(idVuelo).hashCode();
		hash += String.valueOf(numeroVuelo).hashCode();
		hash += String.valueOf(tipoVuelo).hashCode();
		hash += String.valueOf(idEstacionOrigen).hashCode();
		hash += String.valueOf(idEstacionDestino).hashCode();
		hash += String.valueOf(tipoCabina).hashCode();
		hash += String.valueOf(idCompania).hashCode();
		hash += String.valueOf(idClase).hashCode();
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
        if (!(o instanceof VueloDTO)) {
            return false;
        }		
		VueloDTO  other = (VueloDTO ) o;
		if (!Objects.equals(this.idVuelo, other.idVuelo)) { return false; }		
		if (!Objects.equals(this.numeroVuelo, other.numeroVuelo)) { return false; }		
		if (!Objects.equals(this.tipoVuelo, other.tipoVuelo)) { return false; }		
		if (!Objects.equals(this.idEstacionOrigen, other.idEstacionOrigen)) { return false; }		
		if (!Objects.equals(this.idEstacionDestino, other.idEstacionDestino)) { return false; }		
		if (!Objects.equals(this.tipoCabina, other.tipoCabina)) { return false; }		
		if (!Objects.equals(this.idCompania, other.idCompania)) { return false; }		
		if (!Objects.equals(this.idClase, other.idClase)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idVuelo", this.idVuelo);
		jsonObj.put("numeroVuelo", this.numeroVuelo);
		jsonObj.put("tipoVuelo", this.tipoVuelo);
		jsonObj.put("idEstacionOrigen", this.idEstacionOrigen);
		jsonObj.put("idEstacionDestino", this.idEstacionDestino);
		jsonObj.put("tipoCabina", this.tipoCabina);
		jsonObj.put("idCompania", this.idCompania);
		jsonObj.put("idClase", this.idClase);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static VueloDTO create(String json) throws IllegalArgumentException{
		VueloDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idVuelo = (jObj.getInt("idVuelo"));
		x.numeroVuelo = (jObj.getInt("numeroVuelo"));
		x.tipoVuelo = (jObj.getInt("tipoVuelo"));
		x.idEstacionOrigen = (jObj.getInt("idEstacionOrigen"));
		x.idEstacionDestino = (jObj.getInt("idEstacionDestino"));
		x.tipoCabina = (jObj.getInt("tipoCabina"));
		x.idCompania = (jObj.getInt("idCompania"));
		x.idClase = (jObj.getInt("idClase"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
