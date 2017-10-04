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
 * Class for mapping JPA Entity of Table parametros.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

@Entity
@Table(name = "parametros")
@NamedQueries({
    @NamedQuery(name = "Parametros.findAll", query = "SELECT p FROM Parametros p")
    , @NamedQuery(name = "Parametros.countAll", query = "SELECT COUNT(p) FROM Parametros p")
    , @NamedQuery(name = "Parametros.findByIdParametro", query = "SELECT p FROM Parametros p WHERE p.idParametro = :idParametro")
    , @NamedQuery(name = "Parametros.findByClave", query = "SELECT p FROM Parametros p WHERE p.clave = :clave")
    , @NamedQuery(name = "Parametros.findByValor", query = "SELECT p FROM Parametros p WHERE p.valor = :valor")
    , @NamedQuery(name = "Parametros.findByEstatus", query = "SELECT p FROM Parametros p WHERE p.estatus = :estatus")
})
public class Parametros implements java.io.Serializable {
    private static final long serialVersionUID = 868693306;
    
    /**
    * The 'id parametro' Maps to COLUMN 'id_parametro'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_PARAMETRO" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idParametro;
    
    /**
    * The 'clave' Maps to COLUMN 'clave'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "CLAVE" , length=50, nullable=false)
    private String clave;
    
    /**
    * The 'valor' Maps to COLUMN 'valor'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "VALOR" , nullable=false)
    private int valor;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    /** 
    * Map the relation to material_master table where has id_unidad_medida object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadMedida")
    // material_master Well know as MaterialMaster
    private List<MaterialMaster> materialMasterThatHasThisIdUnidadMedidaList;
    
    /** 
    * Map the relation to master table where has id_unidad_medida object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadMedida")
    // master Well know as Master
    private List<Master> masterThatHasThisIdUnidadMedidaList;
    
    /** 
    * Map the relation to master table where has id_instrucciones_nacionales object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstruccionesNacionales")
    // master Well know as Master
    private List<Master> masterThatHasThisIdInstruccionesNacionalesList;
    
    /** 
    * Map the relation to master table where has id_tipo_kit object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoKit")
    // master Well know as Master
    private List<Master> masterThatHasThisIdTipoKitList;
    
    /** 
    * Map the relation to master table where has id_instrucciones_internac object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstruccionesInternac")
    // master Well know as Master
    private List<Master> masterThatHasThisIdInstruccionesInternacList;
    
    /** 
    * Map the relation to material table where has tipo_abastecimiento object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAbastecimiento")
    // material Well know as Material
    private List<Material> materialThatHasThisTipoAbastecimientoList;
    
    /** 
    * Map the relation to material table where has categoria object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    // material Well know as Material
    private List<Material> materialThatHasThisCategoriaList;
    
    /** 
    * Map the relation to vuelo table where has tipo_vuelo object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoVuelo")
    // vuelo Well know as Vuelo
    private List<Vuelo> vueloThatHasThisTipoVueloList;
    
    /** 
    * Map the relation to vuelo table where has tipo_cabina object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCabina")
    // vuelo Well know as Vuelo
    private List<Vuelo> vueloThatHasThisTipoCabinaList;
    
    /** 
    * Map the relation to codigo_servicio table where has tipo_codigo_servicio object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCodigoServicio")
    // codigo_servicio Well know as CodigoServicio
    private List<CodigoServicio> codigoServicioThatHasThisTipoCodigoServicioList;
    
    /** 
    * Map the relation to avion_audifono table where has tipo_audifono object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAudifono")
    // avion_audifono Well know as AvionAudifono
    private List<AvionAudifono> avionAudifonoThatHasThisTipoAudifonoList;
    
    /** 
    * Map the relation to modelo_avion table where has tipo_cabina object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCabina")
    // modelo_avion Well know as ModeloAvion
    private List<ModeloAvion> modeloAvionThatHasThisTipoCabinaList;
    
    /** 
    * Map the relation to modelo_avion table where has id_fabricante object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFabricante")
    // modelo_avion Well know as ModeloAvion
    private List<ModeloAvion> modeloAvionThatHasThisIdFabricanteList;
    
    /** 
    * Map the relation to avion table where has id_conectividad object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConectividad")
    // avion Well know as Avion
    private List<Avion> avionThatHasThisIdConectividadList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Parametros() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdParametro() { return this.idParametro;}
    public void setIdParametro(Integer v) { this.idParametro = v; }
    
    public String getClave() { return this.clave;}
    public void setClave(String v) { this.clave = v; }
    
    public int getValor() { return this.valor;}
    public void setValor(int v) { this.valor = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
    public List<MaterialMaster> getMaterialMasterThatHasThisIdUnidadMedidaList(){ return this.materialMasterThatHasThisIdUnidadMedidaList; }
    public void setMaterialMasterThatHasThisIdUnidadMedidaList(List<MaterialMaster> v){ this.materialMasterThatHasThisIdUnidadMedidaList = v; }
    
    public List<Master> getMasterThatHasThisIdUnidadMedidaList(){ return this.masterThatHasThisIdUnidadMedidaList; }
    public void setMasterThatHasThisIdUnidadMedidaList(List<Master> v){ this.masterThatHasThisIdUnidadMedidaList = v; }
    
    public List<Master> getMasterThatHasThisIdInstruccionesNacionalesList(){ return this.masterThatHasThisIdInstruccionesNacionalesList; }
    public void setMasterThatHasThisIdInstruccionesNacionalesList(List<Master> v){ this.masterThatHasThisIdInstruccionesNacionalesList = v; }
    
    public List<Master> getMasterThatHasThisIdTipoKitList(){ return this.masterThatHasThisIdTipoKitList; }
    public void setMasterThatHasThisIdTipoKitList(List<Master> v){ this.masterThatHasThisIdTipoKitList = v; }
    
    public List<Master> getMasterThatHasThisIdInstruccionesInternacList(){ return this.masterThatHasThisIdInstruccionesInternacList; }
    public void setMasterThatHasThisIdInstruccionesInternacList(List<Master> v){ this.masterThatHasThisIdInstruccionesInternacList = v; }
    
    public List<Material> getMaterialThatHasThisTipoAbastecimientoList(){ return this.materialThatHasThisTipoAbastecimientoList; }
    public void setMaterialThatHasThisTipoAbastecimientoList(List<Material> v){ this.materialThatHasThisTipoAbastecimientoList = v; }
    
    public List<Material> getMaterialThatHasThisCategoriaList(){ return this.materialThatHasThisCategoriaList; }
    public void setMaterialThatHasThisCategoriaList(List<Material> v){ this.materialThatHasThisCategoriaList = v; }
    
    public List<Vuelo> getVueloThatHasThisTipoVueloList(){ return this.vueloThatHasThisTipoVueloList; }
    public void setVueloThatHasThisTipoVueloList(List<Vuelo> v){ this.vueloThatHasThisTipoVueloList = v; }
    
    public List<Vuelo> getVueloThatHasThisTipoCabinaList(){ return this.vueloThatHasThisTipoCabinaList; }
    public void setVueloThatHasThisTipoCabinaList(List<Vuelo> v){ this.vueloThatHasThisTipoCabinaList = v; }
    
    public List<CodigoServicio> getCodigoServicioThatHasThisTipoCodigoServicioList(){ return this.codigoServicioThatHasThisTipoCodigoServicioList; }
    public void setCodigoServicioThatHasThisTipoCodigoServicioList(List<CodigoServicio> v){ this.codigoServicioThatHasThisTipoCodigoServicioList = v; }
    
    public List<AvionAudifono> getAvionAudifonoThatHasThisTipoAudifonoList(){ return this.avionAudifonoThatHasThisTipoAudifonoList; }
    public void setAvionAudifonoThatHasThisTipoAudifonoList(List<AvionAudifono> v){ this.avionAudifonoThatHasThisTipoAudifonoList = v; }
    
    public List<ModeloAvion> getModeloAvionThatHasThisTipoCabinaList(){ return this.modeloAvionThatHasThisTipoCabinaList; }
    public void setModeloAvionThatHasThisTipoCabinaList(List<ModeloAvion> v){ this.modeloAvionThatHasThisTipoCabinaList = v; }
    
    public List<ModeloAvion> getModeloAvionThatHasThisIdFabricanteList(){ return this.modeloAvionThatHasThisIdFabricanteList; }
    public void setModeloAvionThatHasThisIdFabricanteList(List<ModeloAvion> v){ this.modeloAvionThatHasThisIdFabricanteList = v; }
    
    public List<Avion> getAvionThatHasThisIdConectividadList(){ return this.avionThatHasThisIdConectividadList; }
    public void setAvionThatHasThisIdConectividadList(List<Avion> v){ this.avionThatHasThisIdConectividadList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idParametro).hashCode();
		hash += String.valueOf(clave).hashCode();
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
        if (!(o instanceof Parametros)) {
            return false;
        }		
		Parametros other = (Parametros ) o;
		if (!Objects.equals(this.idParametro, other.idParametro)) { return false; }		
		if (!Objects.equals(this.clave, other.clave)) { return false; }		
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
		sb.append("Parametros{");
		sb.append("idParametro" ).append("=").append(idParametro).append("|");
		sb.append("clave" ).append("=").append(clave).append("|");
		sb.append("valor" ).append("=").append(valor).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
