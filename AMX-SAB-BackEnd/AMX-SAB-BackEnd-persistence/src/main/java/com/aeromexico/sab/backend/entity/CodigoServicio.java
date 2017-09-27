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
 * Class for mapping JPA Entity of Table codigo_servicio.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

@Entity
@Table(name = "codigo_servicio")
@NamedQueries({
    @NamedQuery(name = "CodigoServicio.findAll", query = "SELECT c FROM CodigoServicio c")
    , @NamedQuery(name = "CodigoServicio.countAll", query = "SELECT COUNT(c) FROM CodigoServicio c")
    , @NamedQuery(name = "CodigoServicio.findByIdCodigoServicio", query = "SELECT c FROM CodigoServicio c WHERE c.idCodigoServicio = :idCodigoServicio")
    , @NamedQuery(name = "CodigoServicio.findByCveCodigoServicio", query = "SELECT c FROM CodigoServicio c WHERE c.cveCodigoServicio = :cveCodigoServicio")
    , @NamedQuery(name = "CodigoServicio.findByNombre", query = "SELECT c FROM CodigoServicio c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CodigoServicio.findByEstatus", query = "SELECT c FROM CodigoServicio c WHERE c.estatus = :estatus")
    , @NamedQuery(name = "CodigoServicio.findByParametros", query = "SELECT c FROM CodigoServicio c WHERE c.parametros = :parametros")
})
public class CodigoServicio implements java.io.Serializable {
    private static final long serialVersionUID = 1828972342;
    
    /**
    * The 'id codigo servicio' Maps to COLUMN 'id_codigo_servicio'
    */
    
    @Id
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "ID_CODIGO_SERVICIO" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idCodigoServicio;
    
    /**
    * The 'cve codigo servicio' Maps to COLUMN 'cve_codigo_servicio'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CVE_CODIGO_SERVICIO" , length=3, nullable=false)
    private String cveCodigoServicio;
    
    /**
    * The 'nombre' Maps to COLUMN 'nombre'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE" , length=100, nullable=false)
    private String nombre;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    
    /**
    * The 'tipo codigo servicio' Maps to COLUMN 'tipo_codigo_servicio'
    */
    
    @JoinColumn(name = "TIPO_CODIGO_SERVICIO" , referencedColumnName = "ID_PARAMETRO")
    @ManyToOne(optional = false)
    private Parametros parametros;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public CodigoServicio() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdCodigoServicio() { return this.idCodigoServicio;}
    public void setIdCodigoServicio(Integer v) { this.idCodigoServicio = v; }
    
    public String getCveCodigoServicio() { return this.cveCodigoServicio;}
    public void setCveCodigoServicio(String v) { this.cveCodigoServicio = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    public Parametros getParametros() { return this.parametros;}
    public void setParametros(Parametros v) { this.parametros = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idCodigoServicio).hashCode();
		hash += String.valueOf(cveCodigoServicio).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(estatus).hashCode();
		hash += String.valueOf(parametros).hashCode();
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
        if (!(o instanceof CodigoServicio)) {
            return false;
        }		
		CodigoServicio other = (CodigoServicio ) o;
		if (!Objects.equals(this.idCodigoServicio, other.idCodigoServicio)) { return false; }		
		if (!Objects.equals(this.cveCodigoServicio, other.cveCodigoServicio)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
		if (!Objects.equals(this.parametros, other.parametros)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("CodigoServicio{");
		sb.append("idCodigoServicio" ).append("=").append(idCodigoServicio).append("|");
		sb.append("cveCodigoServicio" ).append("=").append(cveCodigoServicio).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("parametros" ).append("=").append(parametros).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
