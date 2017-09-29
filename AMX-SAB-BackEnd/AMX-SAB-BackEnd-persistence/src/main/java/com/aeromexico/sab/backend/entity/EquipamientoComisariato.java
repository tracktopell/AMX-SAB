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
 * Class for mapping JPA Entity of Table equipamiento_comisariato.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */

@Entity
@Table(name = "equipamiento_comisariato")
@NamedQueries({
    @NamedQuery(name = "EquipamientoComisariato.findAll", query = "SELECT e FROM EquipamientoComisariato e")
    , @NamedQuery(name = "EquipamientoComisariato.countAll", query = "SELECT COUNT(e) FROM EquipamientoComisariato e")
    , @NamedQuery(name = "EquipamientoComisariato.findByIdEquipamientoComisariato", query = "SELECT e FROM EquipamientoComisariato e WHERE e.idEquipamientoComisariato = :idEquipamientoComisariato")
    , @NamedQuery(name = "EquipamientoComisariato.findByavion", query = "SELECT e FROM EquipamientoComisariato e WHERE e.avion = :avion")
    , @NamedQuery(name = "EquipamientoComisariato.findByNombreEs", query = "SELECT e FROM EquipamientoComisariato e WHERE e.nombreEs = :nombreEs")
    , @NamedQuery(name = "EquipamientoComisariato.findByNombreEn", query = "SELECT e FROM EquipamientoComisariato e WHERE e.nombreEn = :nombreEn")
    , @NamedQuery(name = "EquipamientoComisariato.findByCantidad", query = "SELECT e FROM EquipamientoComisariato e WHERE e.cantidad = :cantidad")
    , @NamedQuery(name = "EquipamientoComisariato.findByPeso", query = "SELECT e FROM EquipamientoComisariato e WHERE e.peso = :peso")
    , @NamedQuery(name = "EquipamientoComisariato.findByObservaciones", query = "SELECT e FROM EquipamientoComisariato e WHERE e.observaciones = :observaciones")
    , @NamedQuery(name = "EquipamientoComisariato.findBymaterial", query = "SELECT e FROM EquipamientoComisariato e WHERE e.material = :material")
    , @NamedQuery(name = "EquipamientoComisariato.findByEstatus", query = "SELECT e FROM EquipamientoComisariato e WHERE e.estatus = :estatus")
})
public class EquipamientoComisariato implements java.io.Serializable {
    private static final long serialVersionUID = 1452126962;
    
    /**
    * The 'id equipamiento comisariato' Maps to COLUMN 'id_equipamiento_comisariato'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_EQUIPAMIENTO_COMISARIATO" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idEquipamientoComisariato;
    
    /**
    * The 'id avion' Maps to COLUMN 'id_avion'
    */
    
    @JoinColumn(name = "ID_AVION" , referencedColumnName = "ID_AVION")
    @ManyToOne(optional = false)
    private Avion avion;
    
    /**
    * The 'nombre es' Maps to COLUMN 'nombre_es'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "NOMBRE_ES" , length=50, nullable=false)
    private String nombreEs;
    
    /**
    * The 'nombre en' Maps to COLUMN 'nombre_en'
    */
    
    @Basic(optional = true)
    //@Size(max = 50)
    @Column(name = "NOMBRE_EN" , length=50, nullable=true)
    private String nombreEn;
    
    /**
    * The 'cantidad' Maps to COLUMN 'cantidad'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "CANTIDAD" , nullable=false)
    private int cantidad;
    
    /**
    * The 'peso' Maps to COLUMN 'peso'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "PESO" , nullable=false)
    private double peso;
    
    /**
    * The 'observaciones' Maps to COLUMN 'observaciones'
    */
    
    @Basic(optional = true)
    //@Size(max = 250)
    @Column(name = "OBSERVACIONES" , length=250, nullable=true)
    private String observaciones;
    
    /**
    * The 'numero parte' Maps to COLUMN 'numero_parte'
    */
    
    @JoinColumn(name = "NUMERO_PARTE" , referencedColumnName = "NUMERO_PARTE")
    @ManyToOne(optional = true)
    private Material material;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public EquipamientoComisariato() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdEquipamientoComisariato() { return this.idEquipamientoComisariato;}
    public void setIdEquipamientoComisariato(Integer v) { this.idEquipamientoComisariato = v; }
    
    public Avion getAvion(){ return this.avion ; }
    public void setAvion(Avion x){ this.avion = x; }
    
    public String getNombreEs() { return this.nombreEs;}
    public void setNombreEs(String v) { this.nombreEs = v; }
    
    public String getNombreEn() { return this.nombreEn;}
    public void setNombreEn(String v) { this.nombreEn = v; }
    
    public int getCantidad() { return this.cantidad;}
    public void setCantidad(int v) { this.cantidad = v; }
    
    public double getPeso() { return this.peso;}
    public void setPeso(double v) { this.peso = v; }
    
    public String getObservaciones() { return this.observaciones;}
    public void setObservaciones(String v) { this.observaciones = v; }
    
    public Material getMaterial(){ return this.material ; }
    public void setMaterial(Material x){ this.material = x; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idEquipamientoComisariato).hashCode();
		hash += String.valueOf(avion).hashCode();
		hash += String.valueOf(nombreEs).hashCode();
		hash += String.valueOf(nombreEn).hashCode();
		hash += String.valueOf(cantidad).hashCode();
		hash += String.valueOf(peso).hashCode();
		hash += String.valueOf(observaciones).hashCode();
		hash += String.valueOf(material).hashCode();
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
        if (!(o instanceof EquipamientoComisariato)) {
            return false;
        }		
		EquipamientoComisariato other = (EquipamientoComisariato ) o;
		if (!Objects.equals(this.idEquipamientoComisariato, other.idEquipamientoComisariato)) { return false; }		
		if (!Objects.equals(this.avion, other.avion)) { return false; }		
		if (!Objects.equals(this.nombreEs, other.nombreEs)) { return false; }		
		if (!Objects.equals(this.nombreEn, other.nombreEn)) { return false; }		
		if (!Objects.equals(this.cantidad, other.cantidad)) { return false; }		
		if (!Objects.equals(this.peso, other.peso)) { return false; }		
		if (!Objects.equals(this.observaciones, other.observaciones)) { return false; }		
		if (!Objects.equals(this.material, other.material)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("EquipamientoComisariato{");
		sb.append("idEquipamientoComisariato" ).append("=").append(idEquipamientoComisariato).append("|");
		sb.append("avion" ).append("=").append(avion).append("|");
		sb.append("nombreEs" ).append("=").append(nombreEs).append("|");
		sb.append("nombreEn" ).append("=").append(nombreEn).append("|");
		sb.append("cantidad" ).append("=").append(cantidad).append("|");
		sb.append("peso" ).append("=").append(peso).append("|");
		sb.append("observaciones" ).append("=").append(observaciones).append("|");
		sb.append("material" ).append("=").append(material).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
