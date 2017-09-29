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
 * Class for mapping JPA Entity of Table compania.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */

@Entity
@Table(name = "compania")
@NamedQueries({
    @NamedQuery(name = "Compania.findAll", query = "SELECT c FROM Compania c")
    , @NamedQuery(name = "Compania.countAll", query = "SELECT COUNT(c) FROM Compania c")
    , @NamedQuery(name = "Compania.findByIdCompania", query = "SELECT c FROM Compania c WHERE c.idCompania = :idCompania")
    , @NamedQuery(name = "Compania.findByCveCompania", query = "SELECT c FROM Compania c WHERE c.cveCompania = :cveCompania")
    , @NamedQuery(name = "Compania.findByNombre", query = "SELECT c FROM Compania c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Compania.findByEstatus", query = "SELECT c FROM Compania c WHERE c.estatus = :estatus")
})
public class Compania implements java.io.Serializable {
    private static final long serialVersionUID = 1044036744;
    
    /**
    * The 'id compania' Maps to COLUMN 'id_compania'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_COMPANIA" , nullable=false  )
    private Integer idCompania;
    
    /**
    * The 'cve compania' Maps to COLUMN 'cve_compania'
    */
    
    @Basic(optional = true)
    //@Size(max = 3)
    @Column(name = "CVE_COMPANIA" , length=3, nullable=true)
    private String cveCompania;
    
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
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    /** 
    * Map the relation to empleado table where has id_compania object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    // empleado Well know as Empleado
    private List<Empleado> empleadoThatHasThisCompaniaList;
    
    /** 
    * Map the relation to vuelo table where has id_compania object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    // vuelo Well know as Vuelo
    private List<Vuelo> vueloThatHasThisCompaniaList;
    
    /** 
    * Map the relation to modelo_avion table where has id_compania object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    // modelo_avion Well know as ModeloAvion
    private List<ModeloAvion> modeloAvionThatHasThisCompaniaList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Compania() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdCompania() { return this.idCompania;}
    public void setIdCompania(Integer v) { this.idCompania = v; }
    
    public String getCveCompania() { return this.cveCompania;}
    public void setCveCompania(String v) { this.cveCompania = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
    public List<Empleado> getEmpleadoThatHasThisCompaniaList(){ return this.empleadoThatHasThisCompaniaList; }
    public void setEmpleadoThatHasThisCompaniaList(List<Empleado> v){ this.empleadoThatHasThisCompaniaList = v; }
    
    public List<Vuelo> getVueloThatHasThisCompaniaList(){ return this.vueloThatHasThisCompaniaList; }
    public void setVueloThatHasThisCompaniaList(List<Vuelo> v){ this.vueloThatHasThisCompaniaList = v; }
    
    public List<ModeloAvion> getModeloAvionThatHasThisCompaniaList(){ return this.modeloAvionThatHasThisCompaniaList; }
    public void setModeloAvionThatHasThisCompaniaList(List<ModeloAvion> v){ this.modeloAvionThatHasThisCompaniaList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idCompania).hashCode();
		hash += String.valueOf(cveCompania).hashCode();
		hash += String.valueOf(nombre).hashCode();
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
        if (!(o instanceof Compania)) {
            return false;
        }		
		Compania other = (Compania ) o;
		if (!Objects.equals(this.idCompania, other.idCompania)) { return false; }		
		if (!Objects.equals(this.cveCompania, other.cveCompania)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Compania{");
		sb.append("idCompania" ).append("=").append(idCompania).append("|");
		sb.append("cveCompania" ).append("=").append(cveCompania).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
