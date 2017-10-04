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
 * Class for mapping JPA Entity of Table sistema_entretenimiento.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

@Entity
@Table(name = "sistema_entretenimiento")
@NamedQueries({
    @NamedQuery(name = "SistemaEntretenimiento.findAll", query = "SELECT s FROM SistemaEntretenimiento s")
    , @NamedQuery(name = "SistemaEntretenimiento.countAll", query = "SELECT COUNT(s) FROM SistemaEntretenimiento s")
    , @NamedQuery(name = "SistemaEntretenimiento.findByIdSistemaEntretenimiento", query = "SELECT s FROM SistemaEntretenimiento s WHERE s.idSistemaEntretenimiento = :idSistemaEntretenimiento")
    , @NamedQuery(name = "SistemaEntretenimiento.findByTipo", query = "SELECT s FROM SistemaEntretenimiento s WHERE s.tipo = :tipo")
    , @NamedQuery(name = "SistemaEntretenimiento.findByVersion", query = "SELECT s FROM SistemaEntretenimiento s WHERE s.version = :version")
    , @NamedQuery(name = "SistemaEntretenimiento.findByDescripcion", query = "SELECT s FROM SistemaEntretenimiento s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "SistemaEntretenimiento.findByEstatus", query = "SELECT s FROM SistemaEntretenimiento s WHERE s.estatus = :estatus")
})
public class SistemaEntretenimiento implements java.io.Serializable {
    private static final long serialVersionUID = 2129789493;
    
    /**
    * The 'id sistema entretenimiento' Maps to COLUMN 'id_sistema_entretenimiento'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_SISTEMA_ENTRETENIMIENTO" , nullable=false  )
    private Integer idSistemaEntretenimiento;
    
    /**
    * The 'tipo' Maps to COLUMN 'tipo'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "TIPO" , length=50, nullable=false)
    private String tipo;
    
    /**
    * The 'version' Maps to COLUMN 'version'
    */
    
    @Basic(optional = true)
    //@Size(max = 15)
    @Column(name = "VERSION" , length=15, nullable=true)
    private String version;
    
    /**
    * The 'descripcion' Maps to COLUMN 'descripcion'
    */
    
    @Basic(optional = true)
    //@Size(max = 200)
    @Column(name = "DESCRIPCION" , length=200, nullable=true)
    private String descripcion;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    /** 
    * Map the relation to avion_sistema_entretenimiento table where has id_sistema_entretenimiento object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sistemaEntretenimiento")
    // avion_sistema_entretenimiento Well know as AvionSistemaEntretenimiento
    private List<AvionSistemaEntretenimiento> avionSistemaEntretenimientoThatHasThisSistemaEntretenimientoList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public SistemaEntretenimiento() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdSistemaEntretenimiento() { return this.idSistemaEntretenimiento;}
    public void setIdSistemaEntretenimiento(Integer v) { this.idSistemaEntretenimiento = v; }
    
    public String getTipo() { return this.tipo;}
    public void setTipo(String v) { this.tipo = v; }
    
    public String getVersion() { return this.version;}
    public void setVersion(String v) { this.version = v; }
    
    public String getDescripcion() { return this.descripcion;}
    public void setDescripcion(String v) { this.descripcion = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
    public List<AvionSistemaEntretenimiento> getAvionSistemaEntretenimientoThatHasThisSistemaEntretenimientoList(){ return this.avionSistemaEntretenimientoThatHasThisSistemaEntretenimientoList; }
    public void setAvionSistemaEntretenimientoThatHasThisSistemaEntretenimientoList(List<AvionSistemaEntretenimiento> v){ this.avionSistemaEntretenimientoThatHasThisSistemaEntretenimientoList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idSistemaEntretenimiento).hashCode();
		hash += String.valueOf(tipo).hashCode();
		hash += String.valueOf(version).hashCode();
		hash += String.valueOf(descripcion).hashCode();
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
        if (!(o instanceof SistemaEntretenimiento)) {
            return false;
        }		
		SistemaEntretenimiento other = (SistemaEntretenimiento ) o;
		if (!Objects.equals(this.idSistemaEntretenimiento, other.idSistemaEntretenimiento)) { return false; }		
		if (!Objects.equals(this.tipo, other.tipo)) { return false; }		
		if (!Objects.equals(this.version, other.version)) { return false; }		
		if (!Objects.equals(this.descripcion, other.descripcion)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("SistemaEntretenimiento{");
		sb.append("idSistemaEntretenimiento" ).append("=").append(idSistemaEntretenimiento).append("|");
		sb.append("tipo" ).append("=").append(tipo).append("|");
		sb.append("version" ).append("=").append(version).append("|");
		sb.append("descripcion" ).append("=").append(descripcion).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
