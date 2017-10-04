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
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

@Entity
@Table(name = "perfil")
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
    , @NamedQuery(name = "Perfil.countAll", query = "SELECT COUNT(p) FROM Perfil p")
    , @NamedQuery(name = "Perfil.findByPerfil", query = "SELECT p FROM Perfil p WHERE p.perfil = :perfil")
    , @NamedQuery(name = "Perfil.findByDescripcion", query = "SELECT p FROM Perfil p WHERE p.descripcion = :descripcion")
})
public class Perfil implements java.io.Serializable {
    private static final long serialVersionUID = 2093176254;
    
    /**
    * The 'perfil' Maps to COLUMN 'perfil'
    */
    
    @Id
    //@Basic(optional = false)
    //@Size(min = 1, max = 50)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "PERFIL" , length=50, nullable=false  )
    private String perfil;
    
    /**
    * The 'descripcion' Maps to COLUMN 'descripcion'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 255)
    @Column(name = "DESCRIPCION" , length=255, nullable=false)
    private String descripcion;

    
    @ManyToMany(mappedBy = "perfilList")
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
    public String getPerfil() { return this.perfil;}
    public void setPerfil(String v) { this.perfil = v; }
    
    public String getDescripcion() { return this.descripcion;}
    public void setDescripcion(String v) { this.descripcion = v; }
    
    // O2M <*>    
	// M2M <*>
    public List<Usuario> getUsuarioList() { return this.usuarioList; }
    public void setUsuarioList(List<Usuario>  v) { this.usuarioList = v; }
    

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(perfil).hashCode();
		hash += String.valueOf(descripcion).hashCode();
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
		if (!Objects.equals(this.perfil, other.perfil)) { return false; }		
		if (!Objects.equals(this.descripcion, other.descripcion)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Perfil{");
		sb.append("perfil" ).append("=").append(perfil).append("|");
		sb.append("descripcion" ).append("=").append(descripcion).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
