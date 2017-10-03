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
 * Class for mapping JPA Entity of Table area.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/03 13:52
 */

@Entity
@Table(name = "area")
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a")
    , @NamedQuery(name = "Area.countAll", query = "SELECT COUNT(a) FROM Area a")
    , @NamedQuery(name = "Area.findByIdArea", query = "SELECT a FROM Area a WHERE a.idArea = :idArea")
    , @NamedQuery(name = "Area.findByNombre", query = "SELECT a FROM Area a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Area.findByClave", query = "SELECT a FROM Area a WHERE a.clave = :clave")
    , @NamedQuery(name = "Area.findByEstatus", query = "SELECT a FROM Area a WHERE a.estatus = :estatus")
})
public class Area implements java.io.Serializable {
    private static final long serialVersionUID = 1867083167;
    
    /**
    * The 'id area' Maps to COLUMN 'id_area'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_AREA" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idArea;
    
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
    * The 'clave' Maps to COLUMN 'clave'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 6)
    @Column(name = "CLAVE" , length=6, nullable=false)
    private String clave;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    /** 
    * Map the relation to empleado table where has id_area object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    // empleado Well know as Empleado
    private List<Empleado> empleadoThatHasThisAreaList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Area() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdArea() { return this.idArea;}
    public void setIdArea(Integer v) { this.idArea = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public String getClave() { return this.clave;}
    public void setClave(String v) { this.clave = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
    public List<Empleado> getEmpleadoThatHasThisAreaList(){ return this.empleadoThatHasThisAreaList; }
    public void setEmpleadoThatHasThisAreaList(List<Empleado> v){ this.empleadoThatHasThisAreaList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idArea).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(clave).hashCode();
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
        if (!(o instanceof Area)) {
            return false;
        }		
		Area other = (Area ) o;
		if (!Objects.equals(this.idArea, other.idArea)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.clave, other.clave)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Area{");
		sb.append("idArea" ).append("=").append(idArea).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("clave" ).append("=").append(clave).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
