package com.aeromexico.sab.backend.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Embeddable;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// Hibernate Validator 5x is not compatible with validation-api 1.0.x
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

/**
 * Class for mapping JPA Entity of Table modulo_perfil.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/03 13:52
 */

@Entity
@Table(name = "modulo_perfil")
@NamedQueries({
    @NamedQuery(name = "ModuloPerfil.findAll", query = "SELECT m FROM ModuloPerfil m")
    , @NamedQuery(name = "ModuloPerfil.countAll", query = "SELECT COUNT(m) FROM ModuloPerfil m")
    , @NamedQuery(name = "ModuloPerfil.findByPermisoRwd", query = "SELECT m FROM ModuloPerfil m WHERE m.permisoRwd = :permisoRwd")
    , @NamedQuery(name = "ModuloPerfil.findBymodulomodulo", query = "SELECT m FROM ModuloPerfil m WHERE m.modulomodulo = :modulomodulo")
    , @NamedQuery(name = "ModuloPerfil.findByperfilperfil", query = "SELECT m FROM ModuloPerfil m WHERE m.perfilperfil = :perfilperfil")
    , @NamedQuery(name = "ModuloPerfil.findByModuloPerfilPK", query = "SELECT m FROM ModuloPerfil m WHERE m.moduloPerfilPK = :moduloPerfilPK")
})
public class ModuloPerfil implements java.io.Serializable {
    private static final long serialVersionUID = 2093631819;
    
    /**
    * The 'permiso rwd' Maps to COLUMN 'permiso_rwd'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "PERMISO_RWD" , nullable=false)
    private Short permisoRwd;
    
    /**
    * The 'moduloid modulo' Maps to COLUMN 'moduloid_modulo'
    */
    
    @JoinColumn(name = "MODULOID_MODULO" , referencedColumnName = "ID_MODULO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Modulo modulomodulo;
    
    /**
    * The 'perfilid perfil' Maps to COLUMN 'perfilid_perfil'
    */
    
    @JoinColumn(name = "PERFILID_PERFIL" , referencedColumnName = "ID_PERFIL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfilperfil;
    
    /**
    * The 'modulo perfil P K' Maps to COLUMN 'modulo_perfil_P_K'
    */
    
    @EmbeddedId
    private ModuloPerfilPK moduloPerfilPK;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public ModuloPerfil() {
    }
    
    /**
     * Getters and Setters
     */
    public Short getPermisoRwd() { return this.permisoRwd;}
    public void setPermisoRwd(Short v) { this.permisoRwd = v; }
    
    public Modulo getModulomodulo(){ return this.modulomodulo ; }
    public void setModulomodulo(Modulo x){ this.modulomodulo = x; }
    
    public Perfil getPerfilperfil(){ return this.perfilperfil ; }
    public void setPerfilperfil(Perfil x){ this.perfilperfil = x; }
    
    public ModuloPerfilPK getModuloPerfilPK() { return this.moduloPerfilPK;}
    public void setModuloPerfilPK(ModuloPerfilPK v) { this.moduloPerfilPK = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(permisoRwd).hashCode();
		hash += String.valueOf(modulomodulo).hashCode();
		hash += String.valueOf(perfilperfil).hashCode();
		hash += String.valueOf(moduloPerfilPK).hashCode();
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
        if (!(o instanceof ModuloPerfil)) {
            return false;
        }		
		ModuloPerfil other = (ModuloPerfil ) o;
		if (!Objects.equals(this.permisoRwd, other.permisoRwd)) { return false; }		
		if (!Objects.equals(this.modulomodulo, other.modulomodulo)) { return false; }		
		if (!Objects.equals(this.perfilperfil, other.perfilperfil)) { return false; }		
		if (!Objects.equals(this.moduloPerfilPK, other.moduloPerfilPK)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("ModuloPerfil{");
		sb.append("permisoRwd" ).append("=").append(permisoRwd).append("|");
		sb.append("modulomodulo" ).append("=").append(modulomodulo).append("|");
		sb.append("perfilperfil" ).append("=").append(perfilperfil).append("|");
		sb.append("moduloPerfilPK" ).append("=").append(moduloPerfilPK).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
