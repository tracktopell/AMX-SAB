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
 * Class for mapping JPA Entity of Table perfil.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */

@Entity
@Table(name = "perfil")
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
    , @NamedQuery(name = "Perfil.countAll", query = "SELECT COUNT(p) FROM Perfil p")
    , @NamedQuery(name = "Perfil.findByIdPerfil", query = "SELECT p FROM Perfil p WHERE p.idPerfil = :idPerfil")
    , @NamedQuery(name = "Perfil.findByNombre", query = "SELECT p FROM Perfil p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Perfil.findByEstatus", query = "SELECT p FROM Perfil p WHERE p.estatus = :estatus")
})
public class Perfil implements java.io.Serializable {
    private static final long serialVersionUID = 1198108795;
    
    /**
    * The 'id perfil' Maps to COLUMN 'id_perfil'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_PERFIL" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idPerfil;
    
    /**
    * The 'nombre' Maps to COLUMN 'nombre'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "NOMBRE" , length=50, nullable=false)
    private String nombre;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;

    
    @JoinTable(name               = "PERFIL_USUARIO",
               joinColumns        = {@JoinColumn(name = "PERFILID_PERFIL", referencedColumnName ="ID_PERFIL")},
               inverseJoinColumns = {@JoinColumn(name = "USUARIOID_USUARIO", referencedColumnName ="ID_USUARIO")}
               )
    @ManyToMany //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Usuario> usuarioList;
    
	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Perfil() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdPerfil() { return this.idPerfil;}
    public void setIdPerfil(Integer v) { this.idPerfil = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
	// M2M <*>
    public List<Usuario> getUsuarioList() { return this.usuarioList; }
    public void setUsuarioList(List<Usuario>  v) { this.usuarioList = v; }
    

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idPerfil).hashCode();
		hash += String.valueOf(nombre).hashCode();
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
        if (!(o instanceof Perfil)) {
            return false;
        }		
		Perfil other = (Perfil ) o;
		if (!Objects.equals(this.idPerfil, other.idPerfil)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Perfil{");
		sb.append("idPerfil" ).append("=").append(idPerfil).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
