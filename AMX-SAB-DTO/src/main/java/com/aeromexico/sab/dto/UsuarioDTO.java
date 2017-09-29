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
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */

public class UsuarioDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1922154895;

    
    /**
    * id usuario
    */
    private Integer idUsuario;
    
    /**
    * email
    */
    private String email;
    
    /**
    * contrasenia
    */
    private String contrasenia;
    
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
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    public void setIdUsuario(Integer v) {
        this.idUsuario = v;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String v) {
        this.email = v;
    }
    public String getContrasenia() {
        return this.contrasenia;
    }
    public void setContrasenia(String v) {
        this.contrasenia = v;
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
		hash += String.valueOf(idUsuario).hashCode();
		hash += String.valueOf(email).hashCode();
		hash += String.valueOf(contrasenia).hashCode();
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
		if (!Objects.equals(this.idUsuario, other.idUsuario)) { return false; }		
		if (!Objects.equals(this.email, other.email)) { return false; }		
		if (!Objects.equals(this.contrasenia, other.contrasenia)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idUsuario", this.idUsuario);
		jsonObj.put("email", this.email);
		jsonObj.put("contrasenia", this.contrasenia);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static UsuarioDTO create(String json) throws IllegalArgumentException{
		UsuarioDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idUsuario = (jObj.getInt("idUsuario"));
		x.email = (jObj.getString("email"));
		x.contrasenia = (jObj.getString("contrasenia"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
