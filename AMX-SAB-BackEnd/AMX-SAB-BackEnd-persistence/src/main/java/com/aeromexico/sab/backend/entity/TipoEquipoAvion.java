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
 * Class for mapping JPA Entity of Table tipo_equipo_avion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

@Entity
@Table(name = "tipo_equipo_avion")
@NamedQueries({
    @NamedQuery(name = "TipoEquipoAvion.findAll", query = "SELECT t FROM TipoEquipoAvion t")
    , @NamedQuery(name = "TipoEquipoAvion.countAll", query = "SELECT COUNT(t) FROM TipoEquipoAvion t")
    , @NamedQuery(name = "TipoEquipoAvion.findByIdTipoEquipoAvion", query = "SELECT t FROM TipoEquipoAvion t WHERE t.idTipoEquipoAvion = :idTipoEquipoAvion")
    , @NamedQuery(name = "TipoEquipoAvion.findBymodeloAvion", query = "SELECT t FROM TipoEquipoAvion t WHERE t.modeloAvion = :modeloAvion")
    , @NamedQuery(name = "TipoEquipoAvion.findByTotalAviones", query = "SELECT t FROM TipoEquipoAvion t WHERE t.totalAviones = :totalAviones")
    , @NamedQuery(name = "TipoEquipoAvion.findByTipoEquipo", query = "SELECT t FROM TipoEquipoAvion t WHERE t.tipoEquipo = :tipoEquipo")
    , @NamedQuery(name = "TipoEquipoAvion.findByEstatus", query = "SELECT t FROM TipoEquipoAvion t WHERE t.estatus = :estatus")
})
public class TipoEquipoAvion implements java.io.Serializable {
    private static final long serialVersionUID = 664740647;
    
    /**
    * The 'id tipo equipo avion' Maps to COLUMN 'id_tipo_equipo_avion'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_TIPO_EQUIPO_AVION" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idTipoEquipoAvion;
    
    /**
    * The 'id modelo avion' Maps to COLUMN 'id_modelo_avion'
    */
    
    @JoinColumn(name = "ID_MODELO_AVION" , referencedColumnName = "ID_MODELO_AVION")
    @ManyToOne(optional = false)
    private ModeloAvion modeloAvion;
    
    /**
    * The 'total aviones' Maps to COLUMN 'total_aviones'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "TOTAL_AVIONES" , nullable=false)
    private Short totalAviones;
    
    /**
    * The 'tipo equipo' Maps to COLUMN 'tipo_equipo'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 6)
    @Column(name = "TIPO_EQUIPO" , length=6, nullable=false)
    private String tipoEquipo;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    /** 
    * Map the relation to avion table where has id_tipo_equipo_avion object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEquipoAvion")
    // avion Well know as Avion
    private List<Avion> avionThatHasThisTipoEquipoAvionList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public TipoEquipoAvion() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdTipoEquipoAvion() { return this.idTipoEquipoAvion;}
    public void setIdTipoEquipoAvion(Integer v) { this.idTipoEquipoAvion = v; }
    
    public ModeloAvion getModeloAvion(){ return this.modeloAvion ; }
    public void setModeloAvion(ModeloAvion x){ this.modeloAvion = x; }
    
    public Short getTotalAviones() { return this.totalAviones;}
    public void setTotalAviones(Short v) { this.totalAviones = v; }
    
    public String getTipoEquipo() { return this.tipoEquipo;}
    public void setTipoEquipo(String v) { this.tipoEquipo = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
    public List<Avion> getAvionThatHasThisTipoEquipoAvionList(){ return this.avionThatHasThisTipoEquipoAvionList; }
    public void setAvionThatHasThisTipoEquipoAvionList(List<Avion> v){ this.avionThatHasThisTipoEquipoAvionList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idTipoEquipoAvion).hashCode();
		hash += String.valueOf(modeloAvion).hashCode();
		hash += String.valueOf(totalAviones).hashCode();
		hash += String.valueOf(tipoEquipo).hashCode();
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
        if (!(o instanceof TipoEquipoAvion)) {
            return false;
        }		
		TipoEquipoAvion other = (TipoEquipoAvion ) o;
		if (!Objects.equals(this.idTipoEquipoAvion, other.idTipoEquipoAvion)) { return false; }		
		if (!Objects.equals(this.modeloAvion, other.modeloAvion)) { return false; }		
		if (!Objects.equals(this.totalAviones, other.totalAviones)) { return false; }		
		if (!Objects.equals(this.tipoEquipo, other.tipoEquipo)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("TipoEquipoAvion{");
		sb.append("idTipoEquipoAvion" ).append("=").append(idTipoEquipoAvion).append("|");
		sb.append("modeloAvion" ).append("=").append(modeloAvion).append("|");
		sb.append("totalAviones" ).append("=").append(totalAviones).append("|");
		sb.append("tipoEquipo" ).append("=").append(tipoEquipo).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
