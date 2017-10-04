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
 * Class for mapping JPA Entity of Table modelo_avion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

@Entity
@Table(name = "modelo_avion")
@NamedQueries({
    @NamedQuery(name = "ModeloAvion.findAll", query = "SELECT m FROM ModeloAvion m")
    , @NamedQuery(name = "ModeloAvion.countAll", query = "SELECT COUNT(m) FROM ModeloAvion m")
    , @NamedQuery(name = "ModeloAvion.findByIdModeloAvion", query = "SELECT m FROM ModeloAvion m WHERE m.idModeloAvion = :idModeloAvion")
    , @NamedQuery(name = "ModeloAvion.findByModelo", query = "SELECT m FROM ModeloAvion m WHERE m.modelo = :modelo")
    , @NamedQuery(name = "ModeloAvion.findByDescripcion", query = "SELECT m FROM ModeloAvion m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "ModeloAvion.findBytipoCabina", query = "SELECT m FROM ModeloAvion m WHERE m.tipoCabina = :tipoCabina")
    , @NamedQuery(name = "ModeloAvion.findBycompania", query = "SELECT m FROM ModeloAvion m WHERE m.compania = :compania")
    , @NamedQuery(name = "ModeloAvion.findByidFabricante", query = "SELECT m FROM ModeloAvion m WHERE m.idFabricante = :idFabricante")
    , @NamedQuery(name = "ModeloAvion.findByEstaus", query = "SELECT m FROM ModeloAvion m WHERE m.estaus = :estaus")
})
public class ModeloAvion implements java.io.Serializable {
    private static final long serialVersionUID = 363771819;
    
    /**
    * The 'id modelo avion' Maps to COLUMN 'id_modelo_avion'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_MODELO_AVION" , nullable=false  )
    private Integer idModeloAvion;
    
    /**
    * The 'modelo' Maps to COLUMN 'modelo'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "MODELO" , length=50, nullable=false)
    private String modelo;
    
    /**
    * The 'descripcion' Maps to COLUMN 'descripcion'
    */
    
    @Basic(optional = true)
    //@Size(max = 200)
    @Column(name = "DESCRIPCION" , length=200, nullable=true)
    private String descripcion;
    
    /**
    * The 'tipo cabina' Maps to COLUMN 'tipo_cabina'
    */
    
    @JoinColumn(name = "TIPO_CABINA" , referencedColumnName = "ID_PARAMETRO")
    @ManyToOne(optional = false)
    private Parametros tipoCabina;
    
    /**
    * The 'id compania' Maps to COLUMN 'id_compania'
    */
    
    @JoinColumn(name = "ID_COMPANIA" , referencedColumnName = "ID_COMPANIA")
    @ManyToOne(optional = false)
    private Compania compania;
    
    /**
    * The 'id fabricante' Maps to COLUMN 'id_fabricante'
    */
    
    @JoinColumn(name = "ID_FABRICANTE" , referencedColumnName = "ID_PARAMETRO")
    @ManyToOne(optional = false)
    private Parametros idFabricante;
    
    /**
    * The 'estaus' Maps to COLUMN 'estaus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTAUS" , nullable=false)
    private Short estaus;
    /** 
    * Map the relation to tipo_equipo_avion table where has id_modelo_avion object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modeloAvion")
    // tipo_equipo_avion Well know as TipoEquipoAvion
    private List<TipoEquipoAvion> tipoEquipoAvionThatHasThisModeloAvionList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public ModeloAvion() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdModeloAvion() { return this.idModeloAvion;}
    public void setIdModeloAvion(Integer v) { this.idModeloAvion = v; }
    
    public String getModelo() { return this.modelo;}
    public void setModelo(String v) { this.modelo = v; }
    
    public String getDescripcion() { return this.descripcion;}
    public void setDescripcion(String v) { this.descripcion = v; }
    
    public Parametros getTipoCabina(){ return this.tipoCabina ; }
    public void setTipoCabina(Parametros x){ this.tipoCabina = x; }
    
    public Compania getCompania(){ return this.compania ; }
    public void setCompania(Compania x){ this.compania = x; }
    
    public Parametros getIdFabricante(){ return this.idFabricante ; }
    public void setIdFabricante(Parametros x){ this.idFabricante = x; }
    
    public Short getEstaus() { return this.estaus;}
    public void setEstaus(Short v) { this.estaus = v; }
    
    // O2M <*>    
    public List<TipoEquipoAvion> getTipoEquipoAvionThatHasThisModeloAvionList(){ return this.tipoEquipoAvionThatHasThisModeloAvionList; }
    public void setTipoEquipoAvionThatHasThisModeloAvionList(List<TipoEquipoAvion> v){ this.tipoEquipoAvionThatHasThisModeloAvionList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idModeloAvion).hashCode();
		hash += String.valueOf(modelo).hashCode();
		hash += String.valueOf(descripcion).hashCode();
		hash += String.valueOf(tipoCabina).hashCode();
		hash += String.valueOf(compania).hashCode();
		hash += String.valueOf(idFabricante).hashCode();
		hash += String.valueOf(estaus).hashCode();
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
        if (!(o instanceof ModeloAvion)) {
            return false;
        }		
		ModeloAvion other = (ModeloAvion ) o;
		if (!Objects.equals(this.idModeloAvion, other.idModeloAvion)) { return false; }		
		if (!Objects.equals(this.modelo, other.modelo)) { return false; }		
		if (!Objects.equals(this.descripcion, other.descripcion)) { return false; }		
		if (!Objects.equals(this.tipoCabina, other.tipoCabina)) { return false; }		
		if (!Objects.equals(this.compania, other.compania)) { return false; }		
		if (!Objects.equals(this.idFabricante, other.idFabricante)) { return false; }		
		if (!Objects.equals(this.estaus, other.estaus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("ModeloAvion{");
		sb.append("idModeloAvion" ).append("=").append(idModeloAvion).append("|");
		sb.append("modelo" ).append("=").append(modelo).append("|");
		sb.append("descripcion" ).append("=").append(descripcion).append("|");
		sb.append("tipoCabina" ).append("=").append(tipoCabina).append("|");
		sb.append("compania" ).append("=").append(compania).append("|");
		sb.append("idFabricante" ).append("=").append(idFabricante).append("|");
		sb.append("estaus" ).append("=").append(estaus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
