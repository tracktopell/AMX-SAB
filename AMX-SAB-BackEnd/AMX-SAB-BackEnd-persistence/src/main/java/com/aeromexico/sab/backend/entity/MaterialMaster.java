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
 * Class for mapping JPA Entity of Table material_master.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

@Entity
@Table(name = "material_master")
@NamedQueries({
    @NamedQuery(name = "MaterialMaster.findAll", query = "SELECT m FROM MaterialMaster m")
    , @NamedQuery(name = "MaterialMaster.countAll", query = "SELECT COUNT(m) FROM MaterialMaster m")
    , @NamedQuery(name = "MaterialMaster.findByCantidad", query = "SELECT m FROM MaterialMaster m WHERE m.cantidad = :cantidad")
    , @NamedQuery(name = "MaterialMaster.findByPeso", query = "SELECT m FROM MaterialMaster m WHERE m.peso = :peso")
    , @NamedQuery(name = "MaterialMaster.findByParametros", query = "SELECT m FROM MaterialMaster m WHERE m.parametros = :parametros")
    , @NamedQuery(name = "MaterialMaster.findByObservaciones", query = "SELECT m FROM MaterialMaster m WHERE m.observaciones = :observaciones")
    , @NamedQuery(name = "MaterialMaster.findBymateriall", query = "SELECT m FROM MaterialMaster m WHERE m.materiall = :materiall")
    , @NamedQuery(name = "MaterialMaster.findBymaster", query = "SELECT m FROM MaterialMaster m WHERE m.master = :master")
    , @NamedQuery(name = "MaterialMaster.findByMaterialMasterPK", query = "SELECT m FROM MaterialMaster m WHERE m.materialMasterPK = :materialMasterPK")
})
public class MaterialMaster implements java.io.Serializable {
    private static final long serialVersionUID = 603742814;
    
    /**
    * The 'cantidad' Maps to COLUMN 'cantidad'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD" , nullable=false)
    private int cantidad;
    
    /**
    * The 'peso' Maps to COLUMN 'peso'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "PESO" , nullable=false)
    private float peso;
    
    /**
    * The 'id unidad medida' Maps to COLUMN 'id_unidad_medida'
    */
    
    @JoinColumn(name = "ID_UNIDAD_MEDIDA" , referencedColumnName = "ID_PARAMETRO")
    @ManyToOne(optional = false)
    private Parametros parametros;
    
    /**
    * The 'observaciones' Maps to COLUMN 'observaciones'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OBSERVACIONES" , length=255, nullable=false)
    private String observaciones;
    
    /**
    * The 'lnumero parte' Maps to COLUMN 'lnumero_parte'
    */
    
    @JoinColumn(name = "LNUMERO_PARTE" , referencedColumnName = "NUMERO_PARTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Material materiall;
    
    /**
    * The 'id kit' Maps to COLUMN 'id_kit'
    */
    
    @JoinColumn(name = "ID_KIT" , referencedColumnName = "ID_KIT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Master master;
    
    /**
    * The 'material master P K' Maps to COLUMN 'material_master_P_K'
    */
    
    @EmbeddedId
    private MaterialMasterPK materialMasterPK;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public MaterialMaster() {
    }
    
    /**
     * Getters and Setters
     */
    public int getCantidad() { return this.cantidad;}
    public void setCantidad(int v) { this.cantidad = v; }
    
    public float getPeso() { return this.peso;}
    public void setPeso(float v) { this.peso = v; }
    
    public Parametros getParametros() { return this.parametros;}
    public void setParametros(Parametros v) { this.parametros = v; }
    
    public String getObservaciones() { return this.observaciones;}
    public void setObservaciones(String v) { this.observaciones = v; }
    
    public Material getMateriall(){ return this.materiall ; }
    public void setMateriall(Material x){ this.materiall = x; }
    
    public Master getMaster(){ return this.master ; }
    public void setMaster(Master x){ this.master = x; }
    
    public MaterialMasterPK getMaterialMasterPK() { return this.materialMasterPK;}
    public void setMaterialMasterPK(MaterialMasterPK v) { this.materialMasterPK = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(cantidad).hashCode();
		hash += String.valueOf(peso).hashCode();
		hash += String.valueOf(parametros).hashCode();
		hash += String.valueOf(observaciones).hashCode();
		hash += String.valueOf(materiall).hashCode();
		hash += String.valueOf(master).hashCode();
		hash += String.valueOf(materialMasterPK).hashCode();
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
        if (!(o instanceof MaterialMaster)) {
            return false;
        }		
		MaterialMaster other = (MaterialMaster ) o;
		if (!Objects.equals(this.cantidad, other.cantidad)) { return false; }		
		if (!Objects.equals(this.peso, other.peso)) { return false; }		
		if (!Objects.equals(this.parametros, other.parametros)) { return false; }		
		if (!Objects.equals(this.observaciones, other.observaciones)) { return false; }		
		if (!Objects.equals(this.materiall, other.materiall)) { return false; }		
		if (!Objects.equals(this.master, other.master)) { return false; }		
		if (!Objects.equals(this.materialMasterPK, other.materialMasterPK)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("MaterialMaster{");
		sb.append("cantidad" ).append("=").append(cantidad).append("|");
		sb.append("peso" ).append("=").append(peso).append("|");
		sb.append("parametros" ).append("=").append(parametros).append("|");
		sb.append("observaciones" ).append("=").append(observaciones).append("|");
		sb.append("materiall" ).append("=").append(materiall).append("|");
		sb.append("master" ).append("=").append(master).append("|");
		sb.append("materialMasterPK" ).append("=").append(materialMasterPK).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
