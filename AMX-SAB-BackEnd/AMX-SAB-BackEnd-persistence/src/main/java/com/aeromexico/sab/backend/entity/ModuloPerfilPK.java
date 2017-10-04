package com.aeromexico.sab.backend.entity;

import java.util.Set;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

// Hibernate Validator 5x is not compatible with validation-api 1.0.x
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Class for mapping JPA Embedable PK of Table modulo_perfil_P_K.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

@Embeddable

@XmlRootElement
public class ModuloPerfilPK implements java.io.Serializable {
    private static final long serialVersionUID = 99550389;
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_MODULO", nullable= false)
    private Integer idModulo;
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "PERFIL", nullable= false)
    private String perfil;

    /** 
     * Default Constructor
     */
    public ModuloPerfilPK() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdModulo() { return this.idModulo;}
    public void setIdModulo(Integer v) { this.idModulo = v; }
    
    public String getPerfil() { return this.perfil;}
    public void setPerfil(String v) { this.perfil = v; }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idModulo).hashCode();
		hash += String.valueOf(perfil).hashCode();
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
        if (!(o instanceof ModuloPerfilPK)) {
            return false;
        }		
		ModuloPerfilPK other = (ModuloPerfilPK ) o;
		if (!Objects.equals(this.idModulo, other.idModulo)) { return false; }		
		if (!Objects.equals(this.perfil, other.perfil)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("ModuloPerfilPK{");
		sb.append("idModulo" ).append("=").append(idModulo).append("|");
		sb.append("perfil" ).append("=").append(perfil).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
