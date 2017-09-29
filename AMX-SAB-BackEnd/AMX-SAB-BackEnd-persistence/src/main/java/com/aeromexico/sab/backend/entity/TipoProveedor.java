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
 * Class for mapping JPA Entity of Table tipo_proveedor.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */

@Entity
@Table(name = "tipo_proveedor")
@NamedQueries({
    @NamedQuery(name = "TipoProveedor.findAll", query = "SELECT t FROM TipoProveedor t")
    , @NamedQuery(name = "TipoProveedor.countAll", query = "SELECT COUNT(t) FROM TipoProveedor t")
    , @NamedQuery(name = "TipoProveedor.findByIdTipoProveedor", query = "SELECT t FROM TipoProveedor t WHERE t.idTipoProveedor = :idTipoProveedor")
    , @NamedQuery(name = "TipoProveedor.findByNombreEs", query = "SELECT t FROM TipoProveedor t WHERE t.nombreEs = :nombreEs")
    , @NamedQuery(name = "TipoProveedor.findByNombreEn", query = "SELECT t FROM TipoProveedor t WHERE t.nombreEn = :nombreEn")
    , @NamedQuery(name = "TipoProveedor.findByDescripcion", query = "SELECT t FROM TipoProveedor t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TipoProveedor.findByEstatus", query = "SELECT t FROM TipoProveedor t WHERE t.estatus = :estatus")
})
public class TipoProveedor implements java.io.Serializable {
    private static final long serialVersionUID = 245257410;
    
    /**
    * The 'id tipo proveedor' Maps to COLUMN 'id_tipo_proveedor'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_TIPO_PROVEEDOR" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idTipoProveedor;
    
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
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "NOMBRE_EN" , length=50, nullable=false)
    private String nombreEn;
    
    /**
    * The 'descripcion' Maps to COLUMN 'descripcion'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION" , length=100, nullable=false)
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
    * Map the relation to proveedor table where has id_tipo_proveedor object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoProveedor")
    // proveedor Well know as Proveedor
    private List<Proveedor> proveedorThatHasThisTipoProveedorList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public TipoProveedor() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdTipoProveedor() { return this.idTipoProveedor;}
    public void setIdTipoProveedor(Integer v) { this.idTipoProveedor = v; }
    
    public String getNombreEs() { return this.nombreEs;}
    public void setNombreEs(String v) { this.nombreEs = v; }
    
    public String getNombreEn() { return this.nombreEn;}
    public void setNombreEn(String v) { this.nombreEn = v; }
    
    public String getDescripcion() { return this.descripcion;}
    public void setDescripcion(String v) { this.descripcion = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
    public List<Proveedor> getProveedorThatHasThisTipoProveedorList(){ return this.proveedorThatHasThisTipoProveedorList; }
    public void setProveedorThatHasThisTipoProveedorList(List<Proveedor> v){ this.proveedorThatHasThisTipoProveedorList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idTipoProveedor).hashCode();
		hash += String.valueOf(nombreEs).hashCode();
		hash += String.valueOf(nombreEn).hashCode();
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
        if (!(o instanceof TipoProveedor)) {
            return false;
        }		
		TipoProveedor other = (TipoProveedor ) o;
		if (!Objects.equals(this.idTipoProveedor, other.idTipoProveedor)) { return false; }		
		if (!Objects.equals(this.nombreEs, other.nombreEs)) { return false; }		
		if (!Objects.equals(this.nombreEn, other.nombreEn)) { return false; }		
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
		sb.append("TipoProveedor{");
		sb.append("idTipoProveedor" ).append("=").append(idTipoProveedor).append("|");
		sb.append("nombreEs" ).append("=").append(nombreEs).append("|");
		sb.append("nombreEn" ).append("=").append(nombreEn).append("|");
		sb.append("descripcion" ).append("=").append(descripcion).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
