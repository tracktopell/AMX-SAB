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
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */

@Embeddable

@XmlRootElement
public class ModuloPerfilPK implements java.io.Serializable {
    private static final long serialVersionUID = 99550389;
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "MODULOID_MODULO", nullable= false)
    private Integer moduloidModulo;
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "PERFILID_PERFIL", nullable= false)
    private Integer perfilidPerfil;

    /** 
     * Default Constructor
     */
    public ModuloPerfilPK() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getModuloidModulo() { return this.moduloidModulo;}
    public void setModuloidModulo(Integer v) { this.moduloidModulo = v; }
    
    public Integer getPerfilidPerfil() { return this.perfilidPerfil;}
    public void setPerfilidPerfil(Integer v) { this.perfilidPerfil = v; }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(moduloidModulo).hashCode();
		hash += String.valueOf(perfilidPerfil).hashCode();
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
		if (!Objects.equals(this.moduloidModulo, other.moduloidModulo)) { return false; }		
		if (!Objects.equals(this.perfilidPerfil, other.perfilidPerfil)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("ModuloPerfilPK{");
		sb.append("moduloidModulo" ).append("=").append(moduloidModulo).append("|");
		sb.append("perfilidPerfil" ).append("=").append(perfilidPerfil).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
