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
 * Class for mapping JPA Entity of Table categoria_material.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

@Entity
@Table(name = "categoria_material")
@NamedQueries({
    @NamedQuery(name = "CategoriaMaterial.findAll", query = "SELECT c FROM CategoriaMaterial c")
    , @NamedQuery(name = "CategoriaMaterial.countAll", query = "SELECT COUNT(c) FROM CategoriaMaterial c")
    , @NamedQuery(name = "CategoriaMaterial.findByIdCategoriaMaterial", query = "SELECT c FROM CategoriaMaterial c WHERE c.idCategoriaMaterial = :idCategoriaMaterial")
    , @NamedQuery(name = "CategoriaMaterial.findByNombreEs", query = "SELECT c FROM CategoriaMaterial c WHERE c.nombreEs = :nombreEs")
    , @NamedQuery(name = "CategoriaMaterial.findByNombreEn", query = "SELECT c FROM CategoriaMaterial c WHERE c.nombreEn = :nombreEn")
    , @NamedQuery(name = "CategoriaMaterial.findByDescripcion", query = "SELECT c FROM CategoriaMaterial c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "CategoriaMaterial.findByEstatus", query = "SELECT c FROM CategoriaMaterial c WHERE c.estatus = :estatus")
})
public class CategoriaMaterial implements java.io.Serializable {
    private static final long serialVersionUID = 142257191;
    
    /**
    * The 'id categoria material' Maps to COLUMN 'id_categoria_material'
    */
    
    @Id
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "ID_CATEGORIA_MATERIAL" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idCategoriaMaterial;
    
    /**
    * The 'nombre es' Maps to COLUMN 'nombre_es'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_ES" , length=50, nullable=false)
    private String nombreEs;
    
    /**
    * The 'nombre en' Maps to COLUMN 'nombre_en'
    */
    
    @Basic(optional = true)
    @Size(max = 50)
    @Column(name = "NOMBRE_EN" , length=50, nullable=true)
    private String nombreEn;
    
    /**
    * The 'descripcion' Maps to COLUMN 'descripcion'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPCION" , length=50, nullable=false)
    private String descripcion;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    /** 
    * Map the relation to material table where has id_categoria_material object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaMaterial")
    // material Well know as Material
    private List<Material> materialThatHasThisCategoriaMaterialList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public CategoriaMaterial() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdCategoriaMaterial() { return this.idCategoriaMaterial;}
    public void setIdCategoriaMaterial(Integer v) { this.idCategoriaMaterial = v; }
    
    public String getNombreEs() { return this.nombreEs;}
    public void setNombreEs(String v) { this.nombreEs = v; }
    
    public String getNombreEn() { return this.nombreEn;}
    public void setNombreEn(String v) { this.nombreEn = v; }
    
    public String getDescripcion() { return this.descripcion;}
    public void setDescripcion(String v) { this.descripcion = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
    public List<Material> getMaterialThatHasThisCategoriaMaterialList(){ return this.materialThatHasThisCategoriaMaterialList; }
    public void setMaterialThatHasThisCategoriaMaterialList(List<Material> v){ this.materialThatHasThisCategoriaMaterialList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idCategoriaMaterial).hashCode();
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
        if (!(o instanceof CategoriaMaterial)) {
            return false;
        }		
		CategoriaMaterial other = (CategoriaMaterial ) o;
		if (!Objects.equals(this.idCategoriaMaterial, other.idCategoriaMaterial)) { return false; }		
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
		sb.append("CategoriaMaterial{");
		sb.append("idCategoriaMaterial" ).append("=").append(idCategoriaMaterial).append("|");
		sb.append("nombreEs" ).append("=").append(nombreEs).append("|");
		sb.append("nombreEn" ).append("=").append(nombreEn).append("|");
		sb.append("descripcion" ).append("=").append(descripcion).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
