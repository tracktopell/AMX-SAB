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
 * Class for mapping JPA Entity of Table traduccion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

@Entity
@Table(name = "traduccion")
@NamedQueries({
    @NamedQuery(name = "Traduccion.findAll", query = "SELECT t FROM Traduccion t")
    , @NamedQuery(name = "Traduccion.countAll", query = "SELECT COUNT(t) FROM Traduccion t")
    , @NamedQuery(name = "Traduccion.findByIdTraduccion", query = "SELECT t FROM Traduccion t WHERE t.idTraduccion = :idTraduccion")
    , @NamedQuery(name = "Traduccion.findByNombreEntidad", query = "SELECT t FROM Traduccion t WHERE t.nombreEntidad = :nombreEntidad")
    , @NamedQuery(name = "Traduccion.findByIdEntidad", query = "SELECT t FROM Traduccion t WHERE t.idEntidad = :idEntidad")
    , @NamedQuery(name = "Traduccion.findByCampo", query = "SELECT t FROM Traduccion t WHERE t.campo = :campo")
    , @NamedQuery(name = "Traduccion.findByValor", query = "SELECT t FROM Traduccion t WHERE t.valor = :valor")
    , @NamedQuery(name = "Traduccion.findByEstatus", query = "SELECT t FROM Traduccion t WHERE t.estatus = :estatus")
})
public class Traduccion implements java.io.Serializable {
    private static final long serialVersionUID = 2001049719;
    
    /**
    * The 'id traduccion' Maps to COLUMN 'id_traduccion'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_TRADUCCION" , nullable=false  )
    private Integer idTraduccion;
    
    /**
    * The 'nombre entidad' Maps to COLUMN 'nombre_entidad'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "NOMBRE_ENTIDAD" , length=50, nullable=false)
    private String nombreEntidad;
    
    /**
    * The 'id entidad' Maps to COLUMN 'id_entidad'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_ENTIDAD" , nullable=false)
    private int idEntidad;
    
    /**
    * The 'campo' Maps to COLUMN 'campo'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "CAMPO" , length=50, nullable=false)
    private String campo;
    
    /**
    * The 'valor' Maps to COLUMN 'valor'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 100)
    @Column(name = "VALOR" , length=100, nullable=false)
    private String valor;
    
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
    public Traduccion() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdTraduccion() { return this.idTraduccion;}
    public void setIdTraduccion(Integer v) { this.idTraduccion = v; }
    
    public String getNombreEntidad() { return this.nombreEntidad;}
    public void setNombreEntidad(String v) { this.nombreEntidad = v; }
    
    public int getIdEntidad() { return this.idEntidad;}
    public void setIdEntidad(int v) { this.idEntidad = v; }
    
    public String getCampo() { return this.campo;}
    public void setCampo(String v) { this.campo = v; }
    
    public String getValor() { return this.valor;}
    public void setValor(String v) { this.valor = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idTraduccion).hashCode();
		hash += String.valueOf(nombreEntidad).hashCode();
		hash += String.valueOf(idEntidad).hashCode();
		hash += String.valueOf(campo).hashCode();
		hash += String.valueOf(valor).hashCode();
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
        if (!(o instanceof Traduccion)) {
            return false;
        }		
		Traduccion other = (Traduccion ) o;
		if (!Objects.equals(this.idTraduccion, other.idTraduccion)) { return false; }		
		if (!Objects.equals(this.nombreEntidad, other.nombreEntidad)) { return false; }		
		if (!Objects.equals(this.idEntidad, other.idEntidad)) { return false; }		
		if (!Objects.equals(this.campo, other.campo)) { return false; }		
		if (!Objects.equals(this.valor, other.valor)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Traduccion{");
		sb.append("idTraduccion" ).append("=").append(idTraduccion).append("|");
		sb.append("nombreEntidad" ).append("=").append(nombreEntidad).append("|");
		sb.append("idEntidad" ).append("=").append(idEntidad).append("|");
		sb.append("campo" ).append("=").append(campo).append("|");
		sb.append("valor" ).append("=").append(valor).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
