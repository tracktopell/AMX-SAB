package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table USUARIO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

public class UsuarioDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1989780873;

    
    /**
    * email usuario
    */
    private String emailUsuario;
    
    /**
    * contrasenia
    */
    private String contrasenia;
    
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
    * estatus
    */
    private Short estatus;

    /** 
     * Default Constructor
     */
    public UsuarioDTO() {
    }

    /**
     * Getters and Setters
     */
    public String getEmailUsuario() {
        return this.emailUsuario;
    }
    public void setEmailUsuario(String v) {
        this.emailUsuario = v;
    }
    public String getContrasenia() {
        return this.contrasenia;
    }
    public void setContrasenia(String v) {
        this.contrasenia = v;
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
    public Short getEstatus() {
        return this.estatus;
    }
    public void setEstatus(Short v) {
        this.estatus = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(emailUsuario).hashCode();
		hash += String.valueOf(contrasenia).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(apellidoPaterno).hashCode();
		hash += String.valueOf(apellidoMaterno).hashCode();
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
        if (!(o instanceof UsuarioDTO)) {
            return false;
        }		
		UsuarioDTO  other = (UsuarioDTO ) o;
		if (!Objects.equals(this.emailUsuario, other.emailUsuario)) { return false; }		
		if (!Objects.equals(this.contrasenia, other.contrasenia)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) { return false; }		
		if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("emailUsuario", this.emailUsuario);
		jsonObj.put("contrasenia", this.contrasenia);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("apellidoPaterno", this.apellidoPaterno);
		jsonObj.put("apellidoMaterno", this.apellidoMaterno);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static UsuarioDTO create(String json) throws IllegalArgumentException{
		UsuarioDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.emailUsuario = (jObj.getString("emailUsuario"));
		x.contrasenia = (jObj.getString("contrasenia"));
		x.nombre = (jObj.getString("nombre"));
		x.apellidoPaterno = (jObj.getString("apellidoPaterno"));
		x.apellidoMaterno = (jObj.getString("apellidoMaterno"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
