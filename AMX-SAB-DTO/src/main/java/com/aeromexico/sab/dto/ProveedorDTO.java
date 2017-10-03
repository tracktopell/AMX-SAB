package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table PROVEEDOR.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/03 13:52
 */

public class ProveedorDTO implements java.io.Serializable {
    private static final long serialVersionUID = 713338599;

    
    /**
    * id proveedor
    */
    private Integer idProveedor;
    
    /**
    * id tipo proveedor
    */
    private int idTipoProveedor;
    
    /**
    * id estacion
    */
    private int idEstacion;
    
    /**
    * nombre
    */
    private String nombre;
    
    /**
    * cve proveedor
    */
    private String cveProveedor;
    
    /**
    * razon social
    */
    private String razonSocial;
    
    /**
    * estatus
    */
    private Short estatus;

    /** 
     * Default Constructor
     */
    public ProveedorDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdProveedor() {
        return this.idProveedor;
    }
    public void setIdProveedor(Integer v) {
        this.idProveedor = v;
    }
    public int getIdTipoProveedor() {
        return this.idTipoProveedor;
    }
    public void setIdTipoProveedor(int v) {
        this.idTipoProveedor = v;
    }
    public int getIdEstacion() {
        return this.idEstacion;
    }
    public void setIdEstacion(int v) {
        this.idEstacion = v;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public String getCveProveedor() {
        return this.cveProveedor;
    }
    public void setCveProveedor(String v) {
        this.cveProveedor = v;
    }
    public String getRazonSocial() {
        return this.razonSocial;
    }
    public void setRazonSocial(String v) {
        this.razonSocial = v;
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
		hash += String.valueOf(idProveedor).hashCode();
		hash += String.valueOf(idTipoProveedor).hashCode();
		hash += String.valueOf(idEstacion).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(cveProveedor).hashCode();
		hash += String.valueOf(razonSocial).hashCode();
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
        if (!(o instanceof ProveedorDTO)) {
            return false;
        }		
		ProveedorDTO  other = (ProveedorDTO ) o;
		if (!Objects.equals(this.idProveedor, other.idProveedor)) { return false; }		
		if (!Objects.equals(this.idTipoProveedor, other.idTipoProveedor)) { return false; }		
		if (!Objects.equals(this.idEstacion, other.idEstacion)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.cveProveedor, other.cveProveedor)) { return false; }		
		if (!Objects.equals(this.razonSocial, other.razonSocial)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idProveedor", this.idProveedor);
		jsonObj.put("idTipoProveedor", this.idTipoProveedor);
		jsonObj.put("idEstacion", this.idEstacion);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("cveProveedor", this.cveProveedor);
		jsonObj.put("razonSocial", this.razonSocial);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static ProveedorDTO create(String json) throws IllegalArgumentException{
		ProveedorDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idProveedor = (jObj.getInt("idProveedor"));
		x.idTipoProveedor = (jObj.getInt("idTipoProveedor"));
		x.idEstacion = (jObj.getInt("idEstacion"));
		x.nombre = (jObj.getString("nombre"));
		x.cveProveedor = (jObj.getString("cveProveedor"));
		x.razonSocial = (jObj.getString("razonSocial"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
