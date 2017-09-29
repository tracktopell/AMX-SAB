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
 * Class for mapping JPA Entity of Table modulo.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */

@Entity
@Table(name = "modulo")
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m")
    , @NamedQuery(name = "Modulo.countAll", query = "SELECT COUNT(m) FROM Modulo m")
    , @NamedQuery(name = "Modulo.findByIdModulo", query = "SELECT m FROM Modulo m WHERE m.idModulo = :idModulo")
    , @NamedQuery(name = "Modulo.findBymoduloPadre", query = "SELECT m FROM Modulo m WHERE m.moduloPadre = :moduloPadre")
    , @NamedQuery(name = "Modulo.findByNombre", query = "SELECT m FROM Modulo m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Modulo.findByUri", query = "SELECT m FROM Modulo m WHERE m.uri = :uri")
})
public class Modulo implements java.io.Serializable {
    private static final long serialVersionUID = 51228289;
    
    /**
    * The 'id modulo' Maps to COLUMN 'id_modulo'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_MODULO" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idModulo;
    
    /**
    * The 'id modulo padre' Maps to COLUMN 'id_modulo_padre'
    */
    
    @JoinColumn(name = "ID_MODULO_PADRE" , referencedColumnName = "ID_MODULO")
    @ManyToOne(optional = false)
    private Modulo moduloPadre;
    
    /**
    * The 'nombre' Maps to COLUMN 'nombre'
    */
    
    @Basic(optional = true)
    //@Size(max = 100)
    @Column(name = "NOMBRE" , length=100, nullable=true)
    private String nombre;
    
    /**
    * The 'uri' Maps to COLUMN 'uri'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 255)
    @Column(name = "URI" , length=255, nullable=false)
    private String uri;
    /** 
    * Map the relation to modulo table where has id_modulo_padre object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduloPadre")
    // modulo Well know as Modulo
    private List<Modulo> moduloThatHasThisModuloPadreList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Modulo() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdModulo() { return this.idModulo;}
    public void setIdModulo(Integer v) { this.idModulo = v; }
    
    public Modulo getModuloPadre(){ return this.moduloPadre ; }
    public void setModuloPadre(Modulo x){ this.moduloPadre = x; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public String getUri() { return this.uri;}
    public void setUri(String v) { this.uri = v; }
    
    // O2M <*>    
    public List<Modulo> getModuloThatHasThisModuloPadreList(){ return this.moduloThatHasThisModuloPadreList; }
    public void setModuloThatHasThisModuloPadreList(List<Modulo> v){ this.moduloThatHasThisModuloPadreList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idModulo).hashCode();
		hash += String.valueOf(moduloPadre).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(uri).hashCode();
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
        if (!(o instanceof Modulo)) {
            return false;
        }		
		Modulo other = (Modulo ) o;
		if (!Objects.equals(this.idModulo, other.idModulo)) { return false; }		
		if (!Objects.equals(this.moduloPadre, other.moduloPadre)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.uri, other.uri)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Modulo{");
		sb.append("idModulo" ).append("=").append(idModulo).append("|");
		sb.append("moduloPadre" ).append("=").append(moduloPadre).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("uri" ).append("=").append(uri).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
