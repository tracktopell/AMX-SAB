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
 * Class for mapping JPA Entity of Table avion_sistema_entretenimiento.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/03 13:52
 */

@Entity
@Table(name = "avion_sistema_entretenimiento")
@NamedQueries({
    @NamedQuery(name = "AvionSistemaEntretenimiento.findAll", query = "SELECT a FROM AvionSistemaEntretenimiento a")
    , @NamedQuery(name = "AvionSistemaEntretenimiento.countAll", query = "SELECT COUNT(a) FROM AvionSistemaEntretenimiento a")
    , @NamedQuery(name = "AvionSistemaEntretenimiento.findByIdAvionSistemaEntretenimiento", query = "SELECT a FROM AvionSistemaEntretenimiento a WHERE a.idAvionSistemaEntretenimiento = :idAvionSistemaEntretenimiento")
    , @NamedQuery(name = "AvionSistemaEntretenimiento.findByavion", query = "SELECT a FROM AvionSistemaEntretenimiento a WHERE a.avion = :avion")
    , @NamedQuery(name = "AvionSistemaEntretenimiento.findBysistemaEntretenimiento", query = "SELECT a FROM AvionSistemaEntretenimiento a WHERE a.sistemaEntretenimiento = :sistemaEntretenimiento")
})
public class AvionSistemaEntretenimiento implements java.io.Serializable {
    private static final long serialVersionUID = 455659002;
    
    /**
    * The 'id avion sistema entretenimiento' Maps to COLUMN 'id_avion_sistema_entretenimiento'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_AVION_SISTEMA_ENTRETENIMIENTO" , nullable=false  )
    private Integer idAvionSistemaEntretenimiento;
    
    /**
    * The 'id avion' Maps to COLUMN 'id_avion'
    */
    
    @JoinColumn(name = "ID_AVION" , referencedColumnName = "ID_AVION")
    @ManyToOne(optional = false)
    private Avion avion;
    
    /**
    * The 'id sistema entretenimiento' Maps to COLUMN 'id_sistema_entretenimiento'
    */
    
    @JoinColumn(name = "ID_SISTEMA_ENTRETENIMIENTO" , referencedColumnName = "ID_SISTEMA_ENTRETENIMIENTO")
    @ManyToOne(optional = false)
    private SistemaEntretenimiento sistemaEntretenimiento;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public AvionSistemaEntretenimiento() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdAvionSistemaEntretenimiento() { return this.idAvionSistemaEntretenimiento;}
    public void setIdAvionSistemaEntretenimiento(Integer v) { this.idAvionSistemaEntretenimiento = v; }
    
    public Avion getAvion(){ return this.avion ; }
    public void setAvion(Avion x){ this.avion = x; }
    
    public SistemaEntretenimiento getSistemaEntretenimiento(){ return this.sistemaEntretenimiento ; }
    public void setSistemaEntretenimiento(SistemaEntretenimiento x){ this.sistemaEntretenimiento = x; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idAvionSistemaEntretenimiento).hashCode();
		hash += String.valueOf(avion).hashCode();
		hash += String.valueOf(sistemaEntretenimiento).hashCode();
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
        if (!(o instanceof AvionSistemaEntretenimiento)) {
            return false;
        }		
		AvionSistemaEntretenimiento other = (AvionSistemaEntretenimiento ) o;
		if (!Objects.equals(this.idAvionSistemaEntretenimiento, other.idAvionSistemaEntretenimiento)) { return false; }		
		if (!Objects.equals(this.avion, other.avion)) { return false; }		
		if (!Objects.equals(this.sistemaEntretenimiento, other.sistemaEntretenimiento)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("AvionSistemaEntretenimiento{");
		sb.append("idAvionSistemaEntretenimiento" ).append("=").append(idAvionSistemaEntretenimiento).append("|");
		sb.append("avion" ).append("=").append(avion).append("|");
		sb.append("sistemaEntretenimiento" ).append("=").append(sistemaEntretenimiento).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
