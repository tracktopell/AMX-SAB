package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table MODELO_AVION.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

public class ModeloAvionDTO implements java.io.Serializable {
    private static final long serialVersionUID = 363771819;

    
    /**
    * id modelo avion
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=idModeloAvion
    private Integer idModeloAvion;
    
    /**
    * modelo
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=modelo
    private String modelo;
    
    /**
    * descripcion
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=descripcion
    private String descripcion;
    
    /**
    * tipo cabina
    */
    // Simple: PK?false, FK?true, class=int, o=tipoCabina
    private int tipoCabina;
    
    /**
    * id compania
    */
    // Simple: PK?false, FK?true, class=int, o=idCompania
    private int idCompania;
    
    /**
    * id fabricante
    */
    // Simple: PK?false, FK?true, class=int, o=idFabricante
    private int idFabricante;
    
    /**
    * estaus
    */
    // Simple: PK?false, FK?false, class=java.lang.Short, o=estaus
    private Short estaus;

    /** 
     * Default Constructor
     */
    public ModeloAvionDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdModeloAvion() {
        return this.idModeloAvion;
    }
    public void setIdModeloAvion(Integer v) {
        this.idModeloAvion = v;
    }
    public String getModelo() {
        return this.modelo;
    }
    public void setModelo(String v) {
        this.modelo = v;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String v) {
        this.descripcion = v;
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
    public int getIdFabricante() {
        return this.idFabricante;
    }
    public void setIdFabricante(int v) {
        this.idFabricante = v;
    }
    public Short getEstaus() {
        return this.estaus;
    }
    public void setEstaus(Short v) {
        this.estaus = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idModeloAvion).hashCode();
		hash += String.valueOf(modelo).hashCode();
		hash += String.valueOf(descripcion).hashCode();
		hash += String.valueOf(tipoCabina).hashCode();
		hash += String.valueOf(idCompania).hashCode();
		hash += String.valueOf(idFabricante).hashCode();
		hash += String.valueOf(estaus).hashCode();
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
        if (!(o instanceof ModeloAvionDTO)) {
            return false;
        }		
		ModeloAvionDTO  other = (ModeloAvionDTO ) o;
		if (!Objects.equals(this.idModeloAvion, other.idModeloAvion)) { return false; }		
		if (!Objects.equals(this.modelo, other.modelo)) { return false; }		
		if (!Objects.equals(this.descripcion, other.descripcion)) { return false; }		
		if (!Objects.equals(this.tipoCabina, other.tipoCabina)) { return false; }		
		if (!Objects.equals(this.idCompania, other.idCompania)) { return false; }		
		if (!Objects.equals(this.idFabricante, other.idFabricante)) { return false; }		
		if (!Objects.equals(this.estaus, other.estaus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idModeloAvion", this.idModeloAvion);
		jsonObj.put("modelo", this.modelo);
		jsonObj.put("descripcion", this.descripcion);
		jsonObj.put("tipoCabina", this.tipoCabina);
		jsonObj.put("idCompania", this.idCompania);
		jsonObj.put("idFabricante", this.idFabricante);
		jsonObj.put("estaus", this.estaus);
		return jsonObj.toString();
    }

	public static ModeloAvionDTO create(String json) throws IllegalArgumentException{
		ModeloAvionDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idModeloAvion = (jObj.getInt("idModeloAvion"));
		x.modelo = (jObj.getString("modelo"));
		x.descripcion = (jObj.getString("descripcion"));
		x.tipoCabina = (jObj.getInt("tipoCabina"));
		x.idCompania = (jObj.getInt("idCompania"));
		x.idFabricante = (jObj.getInt("idFabricante"));
		x.estaus = (jObj.getShort("estaus"));
		
		return x;
	}

}
