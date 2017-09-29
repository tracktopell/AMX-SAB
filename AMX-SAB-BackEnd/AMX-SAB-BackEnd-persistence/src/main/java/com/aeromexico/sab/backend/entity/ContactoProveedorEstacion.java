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
 * Class for mapping JPA Entity of Table contacto_proveedor_estacion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */

@Entity
@Table(name = "contacto_proveedor_estacion")
@NamedQueries({
    @NamedQuery(name = "ContactoProveedorEstacion.findAll", query = "SELECT c FROM ContactoProveedorEstacion c")
    , @NamedQuery(name = "ContactoProveedorEstacion.countAll", query = "SELECT COUNT(c) FROM ContactoProveedorEstacion c")
    , @NamedQuery(name = "ContactoProveedorEstacion.findByproveedor", query = "SELECT c FROM ContactoProveedorEstacion c WHERE c.proveedor = :proveedor")
    , @NamedQuery(name = "ContactoProveedorEstacion.findByestacion", query = "SELECT c FROM ContactoProveedorEstacion c WHERE c.estacion = :estacion")
    , @NamedQuery(name = "ContactoProveedorEstacion.findByNombre", query = "SELECT c FROM ContactoProveedorEstacion c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "ContactoProveedorEstacion.findByEmail", query = "SELECT c FROM ContactoProveedorEstacion c WHERE c.email = :email")
    , @NamedQuery(name = "ContactoProveedorEstacion.findByTelefono", query = "SELECT c FROM ContactoProveedorEstacion c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "ContactoProveedorEstacion.findByExtencion", query = "SELECT c FROM ContactoProveedorEstacion c WHERE c.extencion = :extencion")
    , @NamedQuery(name = "ContactoProveedorEstacion.findByPuestoAreaEn", query = "SELECT c FROM ContactoProveedorEstacion c WHERE c.puestoAreaEn = :puestoAreaEn")
    , @NamedQuery(name = "ContactoProveedorEstacion.findByPuestoAreaEs", query = "SELECT c FROM ContactoProveedorEstacion c WHERE c.puestoAreaEs = :puestoAreaEs")
    , @NamedQuery(name = "ContactoProveedorEstacion.findById", query = "SELECT c FROM ContactoProveedorEstacion c WHERE c.id = :id")
    , @NamedQuery(name = "ContactoProveedorEstacion.findByusuario", query = "SELECT c FROM ContactoProveedorEstacion c WHERE c.usuario = :usuario")
    , @NamedQuery(name = "ContactoProveedorEstacion.findByEstatus", query = "SELECT c FROM ContactoProveedorEstacion c WHERE c.estatus = :estatus")
})
public class ContactoProveedorEstacion implements java.io.Serializable {
    private static final long serialVersionUID = 1706234378;
    
    /**
    * The 'id proveedor' Maps to COLUMN 'id_proveedor'
    */
    
    @JoinColumn(name = "ID_PROVEEDOR" , referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne(optional = false)
    private Proveedor proveedor;
    
    /**
    * The 'id estacion' Maps to COLUMN 'id_estacion'
    */
    
    @JoinColumn(name = "ID_ESTACION" , referencedColumnName = "ID_ESTACION")
    @ManyToOne(optional = false)
    private Estacion estacion;
    
    /**
    * The 'nombre' Maps to COLUMN 'nombre'
    */
    
    @Basic(optional = true)
    //@Size(max = 100)
    @Column(name = "NOMBRE" , length=100, nullable=true)
    private String nombre;
    
    /**
    * The 'email' Maps to COLUMN 'email'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 150)
    @Column(name = "EMAIL" , length=150, nullable=false)
    private String email;
    
    /**
    * The 'telefono' Maps to COLUMN 'telefono'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 15)
    @Column(name = "TELEFONO" , length=15, nullable=false)
    private String telefono;
    
    /**
    * The 'extencion' Maps to COLUMN 'extencion'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 5)
    @Column(name = "EXTENCION" , length=5, nullable=false)
    private String extencion;
    
    /**
    * The 'puesto area en' Maps to COLUMN 'puesto_area_en'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 150)
    @Column(name = "PUESTO_AREA_EN" , length=150, nullable=false)
    private String puestoAreaEn;
    
    /**
    * The 'puesto area es' Maps to COLUMN 'puesto_area_es'
    */
    
    @Basic(optional = true)
    //@Size(max = 150)
    @Column(name = "PUESTO_AREA_ES" , length=150, nullable=true)
    private String puestoAreaEs;
    
    /**
    * The 'id' Maps to COLUMN 'id'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID" , nullable=false  )
    private Integer id;
    
    /**
    * The 'id usuario' Maps to COLUMN 'id_usuario'
    */
    
    @JoinColumn(name = "ID_USUARIO" , referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario usuario;
    
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
    public ContactoProveedorEstacion() {
    }
    
    /**
     * Getters and Setters
     */
    public Proveedor getProveedor(){ return this.proveedor ; }
    public void setProveedor(Proveedor x){ this.proveedor = x; }
    
    public Estacion getEstacion(){ return this.estacion ; }
    public void setEstacion(Estacion x){ this.estacion = x; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public String getEmail() { return this.email;}
    public void setEmail(String v) { this.email = v; }
    
    public String getTelefono() { return this.telefono;}
    public void setTelefono(String v) { this.telefono = v; }
    
    public String getExtencion() { return this.extencion;}
    public void setExtencion(String v) { this.extencion = v; }
    
    public String getPuestoAreaEn() { return this.puestoAreaEn;}
    public void setPuestoAreaEn(String v) { this.puestoAreaEn = v; }
    
    public String getPuestoAreaEs() { return this.puestoAreaEs;}
    public void setPuestoAreaEs(String v) { this.puestoAreaEs = v; }
    
    public Integer getId() { return this.id;}
    public void setId(Integer v) { this.id = v; }
    
    public Usuario getUsuario(){ return this.usuario ; }
    public void setUsuario(Usuario x){ this.usuario = x; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(proveedor).hashCode();
		hash += String.valueOf(estacion).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(email).hashCode();
		hash += String.valueOf(telefono).hashCode();
		hash += String.valueOf(extencion).hashCode();
		hash += String.valueOf(puestoAreaEn).hashCode();
		hash += String.valueOf(puestoAreaEs).hashCode();
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(usuario).hashCode();
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
        if (!(o instanceof ContactoProveedorEstacion)) {
            return false;
        }		
		ContactoProveedorEstacion other = (ContactoProveedorEstacion ) o;
		if (!Objects.equals(this.proveedor, other.proveedor)) { return false; }		
		if (!Objects.equals(this.estacion, other.estacion)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.email, other.email)) { return false; }		
		if (!Objects.equals(this.telefono, other.telefono)) { return false; }		
		if (!Objects.equals(this.extencion, other.extencion)) { return false; }		
		if (!Objects.equals(this.puestoAreaEn, other.puestoAreaEn)) { return false; }		
		if (!Objects.equals(this.puestoAreaEs, other.puestoAreaEs)) { return false; }		
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.usuario, other.usuario)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("ContactoProveedorEstacion{");
		sb.append("proveedor" ).append("=").append(proveedor).append("|");
		sb.append("estacion" ).append("=").append(estacion).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("email" ).append("=").append(email).append("|");
		sb.append("telefono" ).append("=").append(telefono).append("|");
		sb.append("extencion" ).append("=").append(extencion).append("|");
		sb.append("puestoAreaEn" ).append("=").append(puestoAreaEn).append("|");
		sb.append("puestoAreaEs" ).append("=").append(puestoAreaEs).append("|");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("usuario" ).append("=").append(usuario).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
