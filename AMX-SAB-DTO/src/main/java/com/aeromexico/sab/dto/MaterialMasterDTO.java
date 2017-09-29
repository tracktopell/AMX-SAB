package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table MATERIAL_MASTER.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */

public class MaterialMasterDTO implements java.io.Serializable {
    private static final long serialVersionUID = 303563356;

    
    /**
    * material master p k
    */
    // materialMasterPK EmbedableColumn ID References: FKs {[[lnumero_parte] varchar(50,0), [id_kit] varchar(10,0)]}
    
    /**
    * cantidad
    */
    private int cantidad;
    
    /**
    * peso
    */
    private float peso;
    
    /**
    * id unidad medida
    */
    private int idUnidadMedida;
    
    /**
    * observaciones
    */
    private String observaciones;
    
    /**
    * lnumero parte
    */
    private String lnumeroParte;
    
    /**
    * id kit
    */
    private String idKit;

    /** 
     * Default Constructor
     */
    public MaterialMasterDTO() {
    }

    /**
     * Getters and Setters
     */
    // materialMasterPK EmbedableColumn ID References: FKs {[[lnumero_parte] varchar(50,0), [id_kit] varchar(10,0)]}
    // materialMasterPK EmbedableColumn ID References: FKs {[[lnumero_parte] varchar(50,0), [id_kit] varchar(10,0)]}
    public int getCantidad() {
        return this.cantidad;
    }
    public void setCantidad(int v) {
        this.cantidad = v;
    }
    public float getPeso() {
        return this.peso;
    }
    public void setPeso(float v) {
        this.peso = v;
    }
    public int getIdUnidadMedida() {
        return this.idUnidadMedida;
    }
    public void setIdUnidadMedida(int v) {
        this.idUnidadMedida = v;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    public void setObservaciones(String v) {
        this.observaciones = v;
    }
    public String getLnumeroParte() {
        return this.lnumeroParte;
    }
    public void setLnumeroParte(String v) {
        this.lnumeroParte = v;
    }
    public String getIdKit() {
        return this.idKit;
    }
    public void setIdKit(String v) {
        this.idKit = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(cantidad).hashCode();
		hash += String.valueOf(peso).hashCode();
		hash += String.valueOf(idUnidadMedida).hashCode();
		hash += String.valueOf(observaciones).hashCode();
		hash += String.valueOf(lnumeroParte).hashCode();
		hash += String.valueOf(idKit).hashCode();
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
        if (!(o instanceof MaterialMasterDTO)) {
            return false;
        }		
		MaterialMasterDTO  other = (MaterialMasterDTO ) o;
		if (!Objects.equals(this.cantidad, other.cantidad)) { return false; }		
		if (!Objects.equals(this.peso, other.peso)) { return false; }		
		if (!Objects.equals(this.idUnidadMedida, other.idUnidadMedida)) { return false; }		
		if (!Objects.equals(this.observaciones, other.observaciones)) { return false; }		
		if (!Objects.equals(this.lnumeroParte, other.lnumeroParte)) { return false; }		
		if (!Objects.equals(this.idKit, other.idKit)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("cantidad", this.cantidad);
		jsonObj.put("peso", this.peso);
		jsonObj.put("idUnidadMedida", this.idUnidadMedida);
		jsonObj.put("observaciones", this.observaciones);
		jsonObj.put("lnumeroParte", this.lnumeroParte);
		jsonObj.put("idKit", this.idKit);
		return jsonObj.toString();
    }

	public static MaterialMasterDTO create(String json) throws IllegalArgumentException{
		MaterialMasterDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.cantidad = (jObj.getInt("cantidad"));
		x.peso = (float)(jObj.getDouble("peso"));
		x.idUnidadMedida = (jObj.getInt("idUnidadMedida"));
		x.observaciones = (jObj.getString("observaciones"));
		x.lnumeroParte = (jObj.getString("lnumeroParte"));
		x.idKit = (jObj.getString("idKit"));
		
		return x;
	}

}
