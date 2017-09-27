package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table TRADUCCION.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

public class TraduccionDTO implements java.io.Serializable {
    private static final long serialVersionUID = 2001049719;

    
    /**
    * id traduccion
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=idTraduccion
    private Integer idTraduccion;
    
    /**
    * nombre entidad
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=nombreEntidad
    private String nombreEntidad;
    
    /**
    * id entidad
    */
    // Simple: PK?false, FK?false, class=int, o=idEntidad
    private int idEntidad;
    
    /**
    * campo
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=campo
    private String campo;
    
    /**
    * valor
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=valor
    private String valor;
    
    /**
    * estatus
    */
    // Simple: PK?false, FK?false, class=java.lang.Short, o=estatus
    private Short estatus;

    /** 
     * Default Constructor
     */
    public TraduccionDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdTraduccion() {
        return this.idTraduccion;
    }
    public void setIdTraduccion(Integer v) {
        this.idTraduccion = v;
    }
    public String getNombreEntidad() {
        return this.nombreEntidad;
    }
    public void setNombreEntidad(String v) {
        this.nombreEntidad = v;
    }
    public int getIdEntidad() {
        return this.idEntidad;
    }
    public void setIdEntidad(int v) {
        this.idEntidad = v;
    }
    public String getCampo() {
        return this.campo;
    }
    public void setCampo(String v) {
        this.campo = v;
    }
    public String getValor() {
        return this.valor;
    }
    public void setValor(String v) {
        this.valor = v;
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
		hash += String.valueOf(idTraduccion).hashCode();
		hash += String.valueOf(nombreEntidad).hashCode();
		hash += String.valueOf(idEntidad).hashCode();
		hash += String.valueOf(campo).hashCode();
		hash += String.valueOf(valor).hashCode();
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
        if (!(o instanceof TraduccionDTO)) {
            return false;
        }		
		TraduccionDTO  other = (TraduccionDTO ) o;
		if (!Objects.equals(this.idTraduccion, other.idTraduccion)) { return false; }		
		if (!Objects.equals(this.nombreEntidad, other.nombreEntidad)) { return false; }		
		if (!Objects.equals(this.idEntidad, other.idEntidad)) { return false; }		
		if (!Objects.equals(this.campo, other.campo)) { return false; }		
		if (!Objects.equals(this.valor, other.valor)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idTraduccion", this.idTraduccion);
		jsonObj.put("nombreEntidad", this.nombreEntidad);
		jsonObj.put("idEntidad", this.idEntidad);
		jsonObj.put("campo", this.campo);
		jsonObj.put("valor", this.valor);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static TraduccionDTO create(String json) throws IllegalArgumentException{
		TraduccionDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idTraduccion = (jObj.getInt("idTraduccion"));
		x.nombreEntidad = (jObj.getString("nombreEntidad"));
		x.idEntidad = (jObj.getInt("idEntidad"));
		x.campo = (jObj.getString("campo"));
		x.valor = (jObj.getString("valor"));
		x.estatus = (jObj.getShort("estatus"));
		
		return x;
	}

}
