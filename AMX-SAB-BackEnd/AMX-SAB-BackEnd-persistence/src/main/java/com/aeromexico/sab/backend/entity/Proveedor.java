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
 * Class for mapping JPA Entity of Table proveedor.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */

@Entity
@Table(name = "proveedor")
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.countAll", query = "SELECT COUNT(p) FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByIdProveedor", query = "SELECT p FROM Proveedor p WHERE p.idProveedor = :idProveedor")
    , @NamedQuery(name = "Proveedor.findBytipoProveedor", query = "SELECT p FROM Proveedor p WHERE p.tipoProveedor = :tipoProveedor")
    , @NamedQuery(name = "Proveedor.findByIdEstacion", query = "SELECT p FROM Proveedor p WHERE p.idEstacion = :idEstacion")
    , @NamedQuery(name = "Proveedor.findByNombre", query = "SELECT p FROM Proveedor p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proveedor.findByCveProveedor", query = "SELECT p FROM Proveedor p WHERE p.cveProveedor = :cveProveedor")
    , @NamedQuery(name = "Proveedor.findByRazonSocial", query = "SELECT p FROM Proveedor p WHERE p.razonSocial = :razonSocial")
    , @NamedQuery(name = "Proveedor.findByEstatus", query = "SELECT p FROM Proveedor p WHERE p.estatus = :estatus")
})
public class Proveedor implements java.io.Serializable {
    private static final long serialVersionUID = 321001045;
    
    /**
    * The 'id proveedor' Maps to COLUMN 'id_proveedor'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_PROVEEDOR" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idProveedor;
    
    /**
    * The 'id tipo proveedor' Maps to COLUMN 'id_tipo_proveedor'
    */
    
    @JoinColumn(name = "ID_TIPO_PROVEEDOR" , referencedColumnName = "ID_TIPO_PROVEEDOR")
    @ManyToOne(optional = false)
    private TipoProveedor tipoProveedor;
    
    /**
    * The 'id estacion' Maps to COLUMN 'id_estacion'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_ESTACION" , nullable=false)
    private int idEstacion;
    
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
    * The 'cve proveedor' Maps to COLUMN 'cve_proveedor'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 3)
    @Column(name = "CVE_PROVEEDOR" , length=3, nullable=false)
    private String cveProveedor;
    
    /**
    * The 'razon social' Maps to COLUMN 'razon_social'
    */
    
    @Basic(optional = true)
    //@Size(max = 150)
    @Column(name = "RAZON_SOCIAL" , length=150, nullable=true)
    private String razonSocial;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    /** 
    * Map the relation to contacto_proveedor_estacion table where has id_proveedor object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
    // contacto_proveedor_estacion Well know as ContactoProveedorEstacion
    private List<ContactoProveedorEstacion> contactoProveedorEstacionThatHasThisProveedorList;
    

    
    @ManyToMany(mappedBy = "proveedorList")
    private List<Estacion> estacionList;
    
	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Proveedor() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdProveedor() { return this.idProveedor;}
    public void setIdProveedor(Integer v) { this.idProveedor = v; }
    
    public TipoProveedor getTipoProveedor(){ return this.tipoProveedor ; }
    public void setTipoProveedor(TipoProveedor x){ this.tipoProveedor = x; }
    
    public int getIdEstacion() { return this.idEstacion;}
    public void setIdEstacion(int v) { this.idEstacion = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public String getCveProveedor() { return this.cveProveedor;}
    public void setCveProveedor(String v) { this.cveProveedor = v; }
    
    public String getRazonSocial() { return this.razonSocial;}
    public void setRazonSocial(String v) { this.razonSocial = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
    public List<ContactoProveedorEstacion> getContactoProveedorEstacionThatHasThisProveedorList(){ return this.contactoProveedorEstacionThatHasThisProveedorList; }
    public void setContactoProveedorEstacionThatHasThisProveedorList(List<ContactoProveedorEstacion> v){ this.contactoProveedorEstacionThatHasThisProveedorList = v; }
    
	// M2M <*>
    public List<Estacion> getEstacionList() { return this.estacionList; }
    public void setEstacionList(List<Estacion>  v) { this.estacionList = v; }
    

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idProveedor).hashCode();
		hash += String.valueOf(tipoProveedor).hashCode();
		hash += String.valueOf(idEstacion).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(cveProveedor).hashCode();
		hash += String.valueOf(razonSocial).hashCode();
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
        if (!(o instanceof Proveedor)) {
            return false;
        }		
		Proveedor other = (Proveedor ) o;
		if (!Objects.equals(this.idProveedor, other.idProveedor)) { return false; }		
		if (!Objects.equals(this.tipoProveedor, other.tipoProveedor)) { return false; }		
		if (!Objects.equals(this.idEstacion, other.idEstacion)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.cveProveedor, other.cveProveedor)) { return false; }		
		if (!Objects.equals(this.razonSocial, other.razonSocial)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Proveedor{");
		sb.append("idProveedor" ).append("=").append(idProveedor).append("|");
		sb.append("tipoProveedor" ).append("=").append(tipoProveedor).append("|");
		sb.append("idEstacion" ).append("=").append(idEstacion).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("cveProveedor" ).append("=").append(cveProveedor).append("|");
		sb.append("razonSocial" ).append("=").append(razonSocial).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
