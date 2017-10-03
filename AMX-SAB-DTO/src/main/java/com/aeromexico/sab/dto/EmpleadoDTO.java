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
 * @date 2017/10/03 13:52
 */

public class EmpleadoDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1555009629;

    
    /**
    * id empleado
    */
    private Integer idEmpleado;
    
    /**
    * nombre
    */
    private String nombre;
    
    /**
    * apellido paterno
    */
    private String apellidoPaterno;
    
    /**
    * apellido materno
    */
    private String apellidoMaterno;
    
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
    * id compania
    */
    private int idCompania;
    
    /**
    * id usuario
    */
    private int idUsuario;
    
    /**
    * id area
    */
    private Integer idArea;
    
    /**
    * id estacion
    */
    private int idEstacion;
    
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
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }
    public void setApellidoPaterno(String v) {
        this.apellidoPaterno = v;
    }
    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }
    public void setApellidoMaterno(String v) {
        this.apellidoMaterno = v;
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
    public int getIdCompania() {
        return this.idCompania;
    }
    public void setIdCompania(int v) {
        this.idCompania = v;
    }
    public int getIdUsuario() {
        return this.idUsuario;
    }
    public void setIdUsuario(int v) {
        this.idUsuario = v;
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
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(apellidoPaterno).hashCode();
		hash += String.valueOf(apellidoMaterno).hashCode();
		hash += String.valueOf(telefono).hashCode();
		hash += String.valueOf(extension).hashCode();
		hash += String.valueOf(directorioSab).hashCode();
		hash += String.valueOf(idCompania).hashCode();
		hash += String.valueOf(idUsuario).hashCode();
		hash += String.valueOf(idArea).hashCode();
		hash += String.valueOf(idEstacion).hashCode();
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
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) { return false; }		
		if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) { return false; }		
		if (!Objects.equals(this.telefono, other.telefono)) { return false; }		
		if (!Objects.equals(this.extension, other.extension)) { return false; }		
		if (!Objects.equals(this.directorioSab, other.directorioSab)) { return false; }		
		if (!Objects.equals(this.idCompania, other.idCompania)) { return false; }		
		if (!Objects.equals(this.idUsuario, other.idUsuario)) { return false; }		
		if (!Objects.equals(this.idArea, other.idArea)) { return false; }		
		if (!Objects.equals(this.idEstacion, other.idEstacion)) { return false; }		
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
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("apellidoPaterno", this.apellidoPaterno);
		jsonObj.put("apellidoMaterno", this.apellidoMaterno);
		jsonObj.put("telefono", this.telefono);
		jsonObj.put("extension", this.extension);
		jsonObj.put("directorioSab", this.directorioSab);
		jsonObj.put("idCompania", this.idCompania);
		jsonObj.put("idUsuario", this.idUsuario);
		jsonObj.put("idArea", this.idArea);
		jsonObj.put("idEstacion", this.idEstacion);
		jsonObj.put("esatus", this.esatus);
		return jsonObj.toString();
    }

	public static EmpleadoDTO create(String json) throws IllegalArgumentException{
		EmpleadoDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idEmpleado = (jObj.getInt("idEmpleado"));
		x.nombre = (jObj.getString("nombre"));
		x.apellidoPaterno = (jObj.getString("apellidoPaterno"));
		x.apellidoMaterno = (jObj.getString("apellidoMaterno"));
		x.telefono = (jObj.getString("telefono"));
		x.extension = (jObj.getString("extension"));
		x.directorioSab = (short)(jObj.getInt("directorioSab"));
		x.idCompania = (jObj.getInt("idCompania"));
		x.idUsuario = (jObj.getInt("idUsuario"));
		x.idArea = (jObj.getInt("idArea"));
		x.idEstacion = (jObj.getInt("idEstacion"));
		x.esatus = (short)(jObj.getInt("esatus"));
		
		return x;
	}

}
