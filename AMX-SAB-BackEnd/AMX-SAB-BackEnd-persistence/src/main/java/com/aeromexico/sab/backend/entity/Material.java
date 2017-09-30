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
 * Class for mapping JPA Entity of Table material.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */

@Entity
@Table(name = "material")
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m")
    , @NamedQuery(name = "Material.countAll", query = "SELECT COUNT(m) FROM Material m")
    , @NamedQuery(name = "Material.findByNumeroParte", query = "SELECT m FROM Material m WHERE m.numeroParte = :numeroParte")
    , @NamedQuery(name = "Material.findBycategoria", query = "SELECT m FROM Material m WHERE m.categoria = :categoria")
    , @NamedQuery(name = "Material.findByDescripcionEs", query = "SELECT m FROM Material m WHERE m.descripcionEs = :descripcionEs")
    , @NamedQuery(name = "Material.findByDescripcionEn", query = "SELECT m FROM Material m WHERE m.descripcionEn = :descripcionEn")
    , @NamedQuery(name = "Material.findBytipoAbastecimiento", query = "SELECT m FROM Material m WHERE m.tipoAbastecimiento = :tipoAbastecimiento")
    , @NamedQuery(name = "Material.findByUrlMultimedia", query = "SELECT m FROM Material m WHERE m.urlMultimedia = :urlMultimedia")
    , @NamedQuery(name = "Material.findBycategoriaMaterial", query = "SELECT m FROM Material m WHERE m.categoriaMaterial = :categoriaMaterial")
    , @NamedQuery(name = "Material.findByEstatus", query = "SELECT m FROM Material m WHERE m.estatus = :estatus")
})
public class Material implements java.io.Serializable {
    private static final long serialVersionUID = 424058530;
    
    /**
    * The 'numero parte' Maps to COLUMN 'numero_parte'
    */
    
    @Id
    //@Basic(optional = false)
    //@Size(min = 1, max = 50)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "NUMERO_PARTE" , length=50, nullable=false  )
    private String numeroParte;
    
    /**
    * The 'categoria' Maps to COLUMN 'categoria'
    */
    
    @JoinColumn(name = "CATEGORIA" , referencedColumnName = "ID_PARAMETRO")
    @ManyToOne(optional = false)
    private Parametros categoria;
    
    /**
    * The 'descripcion es' Maps to COLUMN 'descripcion_es'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 120)
    @Column(name = "DESCRIPCION_ES" , length=120, nullable=false)
    private String descripcionEs;
    
    /**
    * The 'descripcion en' Maps to COLUMN 'descripcion_en'
    */
    
    @Basic(optional = true)
    //@Size(max = 120)
    @Column(name = "DESCRIPCION_EN" , length=120, nullable=true)
    private String descripcionEn;
    
    /**
    * The 'tipo abastecimiento' Maps to COLUMN 'tipo_abastecimiento'
    */
    
    @JoinColumn(name = "TIPO_ABASTECIMIENTO" , referencedColumnName = "ID_PARAMETRO")
    @ManyToOne(optional = false)
    private Parametros tipoAbastecimiento;
    
    /**
    * The 'url multimedia' Maps to COLUMN 'url_multimedia'
    */
    
    @Basic(optional = true)
    //@Size(max = 255)
    @Column(name = "URL_MULTIMEDIA" , length=255, nullable=true)
    private String urlMultimedia;
    
    /**
    * The 'id categoria material' Maps to COLUMN 'id_categoria_material'
    */
    
    @JoinColumn(name = "ID_CATEGORIA_MATERIAL" , referencedColumnName = "ID_CATEGORIA_MATERIAL")
    @ManyToOne(optional = false)
    private CategoriaMaterial categoriaMaterial;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    /** 
    * Map the relation to equipamiento_comisariato table where has numero_parte object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "material")
    // equipamiento_comisariato Well know as EquipamientoComisariato
    private List<EquipamientoComisariato> equipamientoComisariatoThatHasThisMaterialList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Material() {
    }
    
    /**
     * Getters and Setters
     */
    public String getNumeroParte() { return this.numeroParte;}
    public void setNumeroParte(String v) { this.numeroParte = v; }
    
    public Parametros getCategoria(){ return this.categoria ; }
    public void setCategoria(Parametros x){ this.categoria = x; }
    
    public String getDescripcionEs() { return this.descripcionEs;}
    public void setDescripcionEs(String v) { this.descripcionEs = v; }
    
    public String getDescripcionEn() { return this.descripcionEn;}
    public void setDescripcionEn(String v) { this.descripcionEn = v; }
    
    public Parametros getTipoAbastecimiento(){ return this.tipoAbastecimiento ; }
    public void setTipoAbastecimiento(Parametros x){ this.tipoAbastecimiento = x; }
    
    public String getUrlMultimedia() { return this.urlMultimedia;}
    public void setUrlMultimedia(String v) { this.urlMultimedia = v; }
    
    public CategoriaMaterial getCategoriaMaterial(){ return this.categoriaMaterial ; }
    public void setCategoriaMaterial(CategoriaMaterial x){ this.categoriaMaterial = x; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
    public List<EquipamientoComisariato> getEquipamientoComisariatoThatHasThisMaterialList(){ return this.equipamientoComisariatoThatHasThisMaterialList; }
    public void setEquipamientoComisariatoThatHasThisMaterialList(List<EquipamientoComisariato> v){ this.equipamientoComisariatoThatHasThisMaterialList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(numeroParte).hashCode();
		hash += String.valueOf(categoria).hashCode();
		hash += String.valueOf(descripcionEs).hashCode();
		hash += String.valueOf(descripcionEn).hashCode();
		hash += String.valueOf(tipoAbastecimiento).hashCode();
		hash += String.valueOf(urlMultimedia).hashCode();
		hash += String.valueOf(categoriaMaterial).hashCode();
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
        if (!(o instanceof Material)) {
            return false;
        }		
		Material other = (Material ) o;
		if (!Objects.equals(this.numeroParte, other.numeroParte)) { return false; }		
		if (!Objects.equals(this.categoria, other.categoria)) { return false; }		
		if (!Objects.equals(this.descripcionEs, other.descripcionEs)) { return false; }		
		if (!Objects.equals(this.descripcionEn, other.descripcionEn)) { return false; }		
		if (!Objects.equals(this.tipoAbastecimiento, other.tipoAbastecimiento)) { return false; }		
		if (!Objects.equals(this.urlMultimedia, other.urlMultimedia)) { return false; }		
		if (!Objects.equals(this.categoriaMaterial, other.categoriaMaterial)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Material{");
		sb.append("numeroParte" ).append("=").append(numeroParte).append("|");
		sb.append("categoria" ).append("=").append(categoria).append("|");
		sb.append("descripcionEs" ).append("=").append(descripcionEs).append("|");
		sb.append("descripcionEn" ).append("=").append(descripcionEn).append("|");
		sb.append("tipoAbastecimiento" ).append("=").append(tipoAbastecimiento).append("|");
		sb.append("urlMultimedia" ).append("=").append(urlMultimedia).append("|");
		sb.append("categoriaMaterial" ).append("=").append(categoriaMaterial).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
