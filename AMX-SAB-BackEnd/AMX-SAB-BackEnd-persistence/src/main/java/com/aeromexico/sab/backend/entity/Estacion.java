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
 * Class for mapping JPA Entity of Table estacion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */

@Entity
@Table(name = "estacion")
@NamedQueries({
    @NamedQuery(name = "Estacion.findAll", query = "SELECT e FROM Estacion e")
    , @NamedQuery(name = "Estacion.countAll", query = "SELECT COUNT(e) FROM Estacion e")
    , @NamedQuery(name = "Estacion.findByIdEstacion", query = "SELECT e FROM Estacion e WHERE e.idEstacion = :idEstacion")
    , @NamedQuery(name = "Estacion.findByNombre", query = "SELECT e FROM Estacion e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estacion.findByClaveIata", query = "SELECT e FROM Estacion e WHERE e.claveIata = :claveIata")
    , @NamedQuery(name = "Estacion.findByciudad", query = "SELECT e FROM Estacion e WHERE e.ciudad = :ciudad")
    , @NamedQuery(name = "Estacion.findByObservaciones", query = "SELECT e FROM Estacion e WHERE e.observaciones = :observaciones")
    , @NamedQuery(name = "Estacion.findByEstatus", query = "SELECT e FROM Estacion e WHERE e.estatus = :estatus")
})
public class Estacion implements java.io.Serializable {
    private static final long serialVersionUID = 495053715;
    
    /**
    * The 'id estacion' Maps to COLUMN 'id_estacion'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_ESTACION" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idEstacion;
    
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
    * The 'clave iata' Maps to COLUMN 'clave_iata'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 3)
    @Column(name = "CLAVE_IATA" , length=3, nullable=false)
    private String claveIata;
    
    /**
    * The 'id ciudad' Maps to COLUMN 'id_ciudad'
    */
    
    @JoinColumn(name = "ID_CIUDAD" , referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad ciudad;
    
    /**
    * The 'observaciones' Maps to COLUMN 'observaciones'
    */
    
    @Basic(optional = true)
    //@Size(max = 150)
    @Column(name = "OBSERVACIONES" , length=150, nullable=true)
    private String observaciones;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    /** 
    * Map the relation to empleado table where has id_estacion object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estacion")
    // empleado Well know as Empleado
    private List<Empleado> empleadoThatHasThisEstacionList;
    
    /** 
    * Map the relation to vuelo table where has id_estacion_destino object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estacionDestino")
    // vuelo Well know as Vuelo
    private List<Vuelo> vueloThatHasThisEstacionDestinoList;
    
    /** 
    * Map the relation to vuelo table where has id_estacion_origen object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estacionOrigen")
    // vuelo Well know as Vuelo
    private List<Vuelo> vueloThatHasThisEstacionOrigenList;
    
    /** 
    * Map the relation to contacto_proveedor_estacion table where has id_estacion object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estacion")
    // contacto_proveedor_estacion Well know as ContactoProveedorEstacion
    private List<ContactoProveedorEstacion> contactoProveedorEstacionThatHasThisEstacionList;
    

    
    @JoinTable(name               = "PROVEEDOR_ESTACION",
               joinColumns        = {@JoinColumn(name = "ID_ESTACION", referencedColumnName ="ID_ESTACION")},
               inverseJoinColumns = {@JoinColumn(name = "ID_PROVEEDOR", referencedColumnName ="ID_PROVEEDOR")}
               )
    @ManyToMany //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Proveedor> proveedorList;
    
	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Estacion() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdEstacion() { return this.idEstacion;}
    public void setIdEstacion(Integer v) { this.idEstacion = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public String getClaveIata() { return this.claveIata;}
    public void setClaveIata(String v) { this.claveIata = v; }
    
    public Ciudad getCiudad(){ return this.ciudad ; }
    public void setCiudad(Ciudad x){ this.ciudad = x; }
    
    public String getObservaciones() { return this.observaciones;}
    public void setObservaciones(String v) { this.observaciones = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
    public List<Empleado> getEmpleadoThatHasThisEstacionList(){ return this.empleadoThatHasThisEstacionList; }
    public void setEmpleadoThatHasThisEstacionList(List<Empleado> v){ this.empleadoThatHasThisEstacionList = v; }
    
    public List<Vuelo> getVueloThatHasThisEstacionDestinoList(){ return this.vueloThatHasThisEstacionDestinoList; }
    public void setVueloThatHasThisEstacionDestinoList(List<Vuelo> v){ this.vueloThatHasThisEstacionDestinoList = v; }
    
    public List<Vuelo> getVueloThatHasThisEstacionOrigenList(){ return this.vueloThatHasThisEstacionOrigenList; }
    public void setVueloThatHasThisEstacionOrigenList(List<Vuelo> v){ this.vueloThatHasThisEstacionOrigenList = v; }
    
    public List<ContactoProveedorEstacion> getContactoProveedorEstacionThatHasThisEstacionList(){ return this.contactoProveedorEstacionThatHasThisEstacionList; }
    public void setContactoProveedorEstacionThatHasThisEstacionList(List<ContactoProveedorEstacion> v){ this.contactoProveedorEstacionThatHasThisEstacionList = v; }
    
	// M2M <*>
    public List<Proveedor> getProveedorList() { return this.proveedorList; }
    public void setProveedorList(List<Proveedor>  v) { this.proveedorList = v; }
    

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idEstacion).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(claveIata).hashCode();
		hash += String.valueOf(ciudad).hashCode();
		hash += String.valueOf(observaciones).hashCode();
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
        if (!(o instanceof Estacion)) {
            return false;
        }		
		Estacion other = (Estacion ) o;
		if (!Objects.equals(this.idEstacion, other.idEstacion)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.claveIata, other.claveIata)) { return false; }		
		if (!Objects.equals(this.ciudad, other.ciudad)) { return false; }		
		if (!Objects.equals(this.observaciones, other.observaciones)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Estacion{");
		sb.append("idEstacion" ).append("=").append(idEstacion).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("claveIata" ).append("=").append(claveIata).append("|");
		sb.append("ciudad" ).append("=").append(ciudad).append("|");
		sb.append("observaciones" ).append("=").append(observaciones).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
