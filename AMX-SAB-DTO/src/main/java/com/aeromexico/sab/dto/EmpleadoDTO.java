package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table EMPLEADO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

public class EmpleadoDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1555009629;

    
    /**
    * id empleado
    */
    private Integer idEmpleado;
    
    /**
    * email usuario
    */
    private String emailUsuario;
    
    /**
    * id compania
    */
    private int idCompania;
    
    /**
    * id area
    */
    private Integer idArea;
    
    /**
    * id estacion
    */
    private int idEstacion;
    
    /**
    * telefono
    */
    private String telefono;
    
    /**
    * extension
    */
    private String extension;
    
    /**
    * directorio sab
    */
    private Short directorioSab;
    
    /**
    * esatus
    */
    private Short esatus;

    /** 
     * Default Constructor
     */
    public EmpleadoDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdEmpleado() {
        return this.idEmpleado;
    }
    public void setIdEmpleado(Integer v) {
        this.idEmpleado = v;
    }
    public String getEmailUsuario() {
        return this.emailUsuario;
    }
    public void setEmailUsuario(String v) {
        this.emailUsuario = v;
    }
    public int getIdCompania() {
        return this.idCompania;
    }
    public void setIdCompania(int v) {
        this.idCompania = v;
    }
    public Integer getIdArea() {
        return this.idArea;
    }
    public void setIdArea(Integer v) {
        this.idArea = v;
    }
    public int getIdEstacion() {
        return this.idEstacion;
    }
    public void setIdEstacion(int v) {
        this.idEstacion = v;
    }
    public String getTelefono() {
        return this.telefono;
    }
    public void setTelefono(String v) {
        this.telefono = v;
    }
    public String getExtension() {
        return this.extension;
    }
    public void setExtension(String v) {
        this.extension = v;
    }
    public Short getDirectorioSab() {
        return this.directorioSab;
    }
    public void setDirectorioSab(Short v) {
        this.directorioSab = v;
    }
    public Short getEsatus() {
        return this.esatus;
    }
    public void setEsatus(Short v) {
        this.esatus = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idEmpleado).hashCode();
		hash += String.valueOf(emailUsuario).hashCode();
		hash += String.valueOf(idCompania).hashCode();
		hash += String.valueOf(idArea).hashCode();
		hash += String.valueOf(idEstacion).hashCode();
		hash += String.valueOf(telefono).hashCode();
		hash += String.valueOf(extension).hashCode();
		hash += String.valueOf(directorioSab).hashCode();
		hash += String.valueOf(esatus).hashCode();
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
        if (!(o instanceof EmpleadoDTO)) {
            return false;
        }		
		EmpleadoDTO  other = (EmpleadoDTO ) o;
		if (!Objects.equals(this.idEmpleado, other.idEmpleado)) { return false; }		
		if (!Objects.equals(this.emailUsuario, other.emailUsuario)) { return false; }		
		if (!Objects.equals(this.idCompania, other.idCompania)) { return false; }		
		if (!Objects.equals(this.idArea, other.idArea)) { return false; }		
		if (!Objects.equals(this.idEstacion, other.idEstacion)) { return false; }		
		if (!Objects.equals(this.telefono, other.telefono)) { return false; }		
		if (!Objects.equals(this.extension, other.extension)) { return false; }		
		if (!Objects.equals(this.directorioSab, other.directorioSab)) { return false; }		
		if (!Objects.equals(this.esatus, other.esatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idEmpleado", this.idEmpleado);
		jsonObj.put("emailUsuario", this.emailUsuario);
		jsonObj.put("idCompania", this.idCompania);
		jsonObj.put("idArea", this.idArea);
		jsonObj.put("idEstacion", this.idEstacion);
		jsonObj.put("telefono", this.telefono);
		jsonObj.put("extension", this.extension);
		jsonObj.put("directorioSab", this.directorioSab);
		jsonObj.put("esatus", this.esatus);
		return jsonObj.toString();
    }

	public static EmpleadoDTO create(String json) throws IllegalArgumentException{
		EmpleadoDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idEmpleado = (jObj.getInt("idEmpleado"));
		x.emailUsuario = (jObj.getString("emailUsuario"));
		x.idCompania = (jObj.getInt("idCompania"));
		x.idArea = (jObj.getInt("idArea"));
		x.idEstacion = (jObj.getInt("idEstacion"));
		x.telefono = (jObj.getString("telefono"));
		x.extension = (jObj.getString("extension"));
		x.directorioSab = (short)(jObj.getInt("directorioSab"));
		x.esatus = (short)(jObj.getInt("esatus"));
		
		return x;
	}

}
