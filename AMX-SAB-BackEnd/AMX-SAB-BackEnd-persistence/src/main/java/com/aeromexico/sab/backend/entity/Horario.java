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
 * Class for mapping JPA Entity of Table horario.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

@Entity
@Table(name = "horario")
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")
    , @NamedQuery(name = "Horario.countAll", query = "SELECT COUNT(h) FROM Horario h")
    , @NamedQuery(name = "Horario.findByIdHorario", query = "SELECT h FROM Horario h WHERE h.idHorario = :idHorario")
    , @NamedQuery(name = "Horario.findByregion", query = "SELECT h FROM Horario h WHERE h.region = :region")
    , @NamedQuery(name = "Horario.findByHoraInicio", query = "SELECT h FROM Horario h WHERE h.horaInicio = :horaInicio")
    , @NamedQuery(name = "Horario.findByHoraFin", query = "SELECT h FROM Horario h WHERE h.horaFin = :horaFin")
    , @NamedQuery(name = "Horario.findByEstatus", query = "SELECT h FROM Horario h WHERE h.estatus = :estatus")
})
public class Horario implements java.io.Serializable {
    private static final long serialVersionUID = 1283928880;
    
    /**
    * The 'id horario' Maps to COLUMN 'id_horario'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_HORARIO" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idHorario;
    
    /**
    * The 'id region' Maps to COLUMN 'id_region'
    */
    
    @JoinColumn(name = "ID_REGION" , referencedColumnName = "ID_REGION")
    @ManyToOne(optional = false)
    private Region region;
    
    /**
    * The 'hora inicio' Maps to COLUMN 'hora_inicio'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "HORA_INICIO" , nullable=false)
    private java.sql.Time horaInicio;
    
    /**
    * The 'hora fin' Maps to COLUMN 'hora_fin'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "HORA_FIN" , nullable=false)
    private java.sql.Time horaFin;
    
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
    public Horario() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdHorario() { return this.idHorario;}
    public void setIdHorario(Integer v) { this.idHorario = v; }
    
    public Region getRegion(){ return this.region ; }
    public void setRegion(Region x){ this.region = x; }
    
    public java.sql.Time getHoraInicio() { return this.horaInicio;}
    public void setHoraInicio(java.sql.Time v) { this.horaInicio = v; }
    
    public java.sql.Time getHoraFin() { return this.horaFin;}
    public void setHoraFin(java.sql.Time v) { this.horaFin = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idHorario).hashCode();
		hash += String.valueOf(region).hashCode();
		hash += String.valueOf(horaInicio).hashCode();
		hash += String.valueOf(horaFin).hashCode();
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
        if (!(o instanceof Horario)) {
            return false;
        }		
		Horario other = (Horario ) o;
		if (!Objects.equals(this.idHorario, other.idHorario)) { return false; }		
		if (!Objects.equals(this.region, other.region)) { return false; }		
		if (!Objects.equals(this.horaInicio, other.horaInicio)) { return false; }		
		if (!Objects.equals(this.horaFin, other.horaFin)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Horario{");
		sb.append("idHorario" ).append("=").append(idHorario).append("|");
		sb.append("region" ).append("=").append(region).append("|");
		sb.append("horaInicio" ).append("=").append(horaInicio).append("|");
		sb.append("horaFin" ).append("=").append(horaFin).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
