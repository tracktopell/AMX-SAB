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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class for mapping JPA Entity of Table relacion_flota.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

@Entity
@Table(name = "relacion_flota")
@NamedQueries({
    @NamedQuery(name = "RelacionFlota.findAll", query = "SELECT r FROM RelacionFlota r")
    , @NamedQuery(name = "RelacionFlota.countAll", query = "SELECT COUNT(r) FROM RelacionFlota r")
    , @NamedQuery(name = "RelacionFlota.findByIdRelacionFlota", query = "SELECT r FROM RelacionFlota r WHERE r.idRelacionFlota = :idRelacionFlota")
    , @NamedQuery(name = "RelacionFlota.findByRevision", query = "SELECT r FROM RelacionFlota r WHERE r.revision = :revision")
    , @NamedQuery(name = "RelacionFlota.findByFecha", query = "SELECT r FROM RelacionFlota r WHERE r.fecha = :fecha")
})
public class RelacionFlota implements java.io.Serializable {
    private static final long serialVersionUID = 1078694789;
    
    /**
    * The 'id relacion flota' Maps to COLUMN 'id_relacion_flota'
    */
    
    @Id
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "ID_RELACION_FLOTA" , nullable=false  )
    private Integer idRelacionFlota;
    
    /**
    * The 'revision' Maps to COLUMN 'revision'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "REVISION" , nullable=false)
    private int revision;
    
    /**
    * The 'fecha' Maps to COLUMN 'fecha'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA" , nullable=false)
    private java.sql.Date fecha;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public RelacionFlota() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdRelacionFlota() { return this.idRelacionFlota;}
    public void setIdRelacionFlota(Integer v) { this.idRelacionFlota = v; }
    
    public int getRevision() { return this.revision;}
    public void setRevision(int v) { this.revision = v; }
    
    public java.sql.Date getFecha() { return this.fecha;}
    public void setFecha(java.sql.Date v) { this.fecha = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idRelacionFlota).hashCode();
		hash += String.valueOf(revision).hashCode();
		hash += String.valueOf(fecha).hashCode();
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
        if (!(o instanceof RelacionFlota)) {
            return false;
        }		
		RelacionFlota other = (RelacionFlota ) o;
		if (!Objects.equals(this.idRelacionFlota, other.idRelacionFlota)) { return false; }		
		if (!Objects.equals(this.revision, other.revision)) { return false; }		
		if (!Objects.equals(this.fecha, other.fecha)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("RelacionFlota{");
		sb.append("idRelacionFlota" ).append("=").append(idRelacionFlota).append("|");
		sb.append("revision" ).append("=").append(revision).append("|");
		sb.append("fecha" ).append("=").append(fecha).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
