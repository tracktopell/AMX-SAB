package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table MATERIAL.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/03 13:52
 */

public class MaterialDTO implements java.io.Serializable {
    private static final long serialVersionUID = 424058530;

    
    /**
    * numero parte
    */
    private String numeroParte;
    
    /**
    * categoria
    */
    private int categoria;
    
    /**
    * descripcion es
    */
    private String descripcionEs;
    
    /**
    * descripcion en
    */
    private String descripcionEn;
    
    /**
    * tipo abastecimiento
    */
    private int tipoAbastecimiento;
    
    /**
    * url multimedia
    */
    private String urlMultimedia;
    
    /**
    * id categoria material
    */
    private int idCategoriaMaterial;
    
    /**
    * estatus
    */
    private Short estatus;

    /** 
     * Default Constructor
     */
    public MaterialDTO() {
    }

    /**
     * Getters and Setters
     */
    public String getNumeroParte() {
        return this.numeroParte;
    }
    public void setNumeroParte(String v) {
        this.numeroParte = v;
    }
    public int getCategoria() {
        return this.categoria;
    }
    public void setCategoria(int v) {
        this.categoria = v;
    }
    public String getDescripcionEs() {
        return this.descripcionEs;
    }
    public void setDescripcionEs(String v) {
        this.descripcionEs = v;
    }
    public String getDescripcionEn() {
        return this.descripcionEn;
    }
    public void setDescripcionEn(String v) {
        this.descripcionEn = v;
    }
    public int getTipoAbastecimiento() {
        return this.tipoAbastecimiento;
    }
    public void setTipoAbastecimiento(int v) {
        this.tipoAbastecimiento = v;
    }
    public String getUrlMultimedia() {
        return this.urlMultimedia;
    }
    public void setUrlMultimedia(String v) {
        this.urlMultimedia = v;
    }
    public int getIdCategoriaMaterial() {
        return this.idCategoriaMaterial;
    }
    public void setIdCategoriaMaterial(int v) {
        this.idCategoriaMaterial = v;
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
		hash += String.valueOf(numeroParte).hashCode();
		hash += String.valueOf(categoria).hashCode();
		hash += String.valueOf(descripcionEs).hashCode();
		hash += String.valueOf(descripcionEn).hashCode();
		hash += String.valueOf(tipoAbastecimiento).hashCode();
		hash += String.valueOf(urlMultimedia).hashCode();
		hash += String.valueOf(idCategoriaMaterial).hashCode();
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
        if (!(o instanceof MaterialDTO)) {
            return false;
        }		
		MaterialDTO  other = (MaterialDTO ) o;
		if (!Objects.equals(this.numeroParte, other.numeroParte)) { return false; }		
		if (!Objects.equals(this.categoria, other.categoria)) { return false; }		
		if (!Objects.equals(this.descripcionEs, other.descripcionEs)) { return false; }		
		if (!Objects.equals(this.descripcionEn, other.descripcionEn)) { return false; }		
		if (!Objects.equals(this.tipoAbastecimiento, other.tipoAbastecimiento)) { return false; }		
		if (!Objects.equals(this.urlMultimedia, other.urlMultimedia)) { return false; }		
		if (!Objects.equals(this.idCategoriaMaterial, other.idCategoriaMaterial)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("numeroParte", this.numeroParte);
		jsonObj.put("categoria", this.categoria);
		jsonObj.put("descripcionEs", this.descripcionEs);
		jsonObj.put("descripcionEn", this.descripcionEn);
		jsonObj.put("tipoAbastecimiento", this.tipoAbastecimiento);
		jsonObj.put("urlMultimedia", this.urlMultimedia);
		jsonObj.put("idCategoriaMaterial", this.idCategoriaMaterial);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static MaterialDTO create(String json) throws IllegalArgumentException{
		MaterialDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.numeroParte = (jObj.getString("numeroParte"));
		x.categoria = (jObj.getInt("categoria"));
		x.descripcionEs = (jObj.getString("descripcionEs"));
		x.descripcionEn = (jObj.getString("descripcionEn"));
		x.tipoAbastecimiento = (jObj.getInt("tipoAbastecimiento"));
		x.urlMultimedia = (jObj.getString("urlMultimedia"));
		x.idCategoriaMaterial = (jObj.getInt("idCategoriaMaterial"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
