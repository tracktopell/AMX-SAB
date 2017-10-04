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
 * Class for mapping JPA Entity of Table avion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

@Entity
@Table(name = "avion")
@NamedQueries({
    @NamedQuery(name = "Avion.findAll", query = "SELECT a FROM Avion a")
    , @NamedQuery(name = "Avion.countAll", query = "SELECT COUNT(a) FROM Avion a")
    , @NamedQuery(name = "Avion.findByIdAvion", query = "SELECT a FROM Avion a WHERE a.idAvion = :idAvion")
    , @NamedQuery(name = "Avion.findBytipoEquipoAvion", query = "SELECT a FROM Avion a WHERE a.tipoEquipoAvion = :tipoEquipoAvion")
    , @NamedQuery(name = "Avion.findByMatricula", query = "SELECT a FROM Avion a WHERE a.matricula = :matricula")
    , @NamedQuery(name = "Avion.findByMatriculaCorta", query = "SELECT a FROM Avion a WHERE a.matriculaCorta = :matriculaCorta")
    , @NamedQuery(name = "Avion.findByEstatus", query = "SELECT a FROM Avion a WHERE a.estatus = :estatus")
    , @NamedQuery(name = "Avion.findByidConectividad", query = "SELECT a FROM Avion a WHERE a.idConectividad = :idConectividad")
})
public class Avion implements java.io.Serializable {
    private static final long serialVersionUID = 664223387;
    
    /**
    * The 'id avion' Maps to COLUMN 'id_avion'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_AVION" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idAvion;
    
    /**
    * The 'id tipo equipo avion' Maps to COLUMN 'id_tipo_equipo_avion'
    */
    
    @JoinColumn(name = "ID_TIPO_EQUIPO_AVION" , referencedColumnName = "ID_TIPO_EQUIPO_AVION")
    @ManyToOne(optional = false)
    private TipoEquipoAvion tipoEquipoAvion;
    
    /**
    * The 'matricula' Maps to COLUMN 'matricula'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "MATRICULA" , length=50, nullable=false)
    private String matricula;
    
    /**
    * The 'matricula corta' Maps to COLUMN 'matricula_corta'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 10)
    @Column(name = "MATRICULA_CORTA" , length=10, nullable=false)
    private String matriculaCorta;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    
    /**
    * The 'id conectividad' Maps to COLUMN 'id_conectividad'
    */
    
    @JoinColumn(name = "ID_CONECTIVIDAD" , referencedColumnName = "ID_PARAMETRO")
    @ManyToOne(optional = false)
    private Parametros idConectividad;
    /** 
    * Map the relation to equipamiento_comisariato table where has id_avion object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avion")
    // equipamiento_comisariato Well know as EquipamientoComisariato
    private List<EquipamientoComisariato> equipamientoComisariatoThatHasThisAvionList;
    
    /** 
    * Map the relation to avion_sistema_entretenimiento table where has id_avion object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avion")
    // avion_sistema_entretenimiento Well know as AvionSistemaEntretenimiento
    private List<AvionSistemaEntretenimiento> avionSistemaEntretenimientoThatHasThisAvionList;
    
    /** 
    * Map the relation to avion_capacidad table where has id_avion object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avion")
    // avion_capacidad Well know as AvionCapacidad
    private List<AvionCapacidad> avionCapacidadThatHasThisAvionList;
    
    /** 
    * Map the relation to avion_audifono table where has id_avion object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avion")
    // avion_audifono Well know as AvionAudifono
    private List<AvionAudifono> avionAudifonoThatHasThisAvionList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Avion() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdAvion() { return this.idAvion;}
    public void setIdAvion(Integer v) { this.idAvion = v; }
    
    public TipoEquipoAvion getTipoEquipoAvion(){ return this.tipoEquipoAvion ; }
    public void setTipoEquipoAvion(TipoEquipoAvion x){ this.tipoEquipoAvion = x; }
    
    public String getMatricula() { return this.matricula;}
    public void setMatricula(String v) { this.matricula = v; }
    
    public String getMatriculaCorta() { return this.matriculaCorta;}
    public void setMatriculaCorta(String v) { this.matriculaCorta = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    public Parametros getIdConectividad(){ return this.idConectividad ; }
    public void setIdConectividad(Parametros x){ this.idConectividad = x; }
    
    // O2M <*>    
    public List<EquipamientoComisariato> getEquipamientoComisariatoThatHasThisAvionList(){ return this.equipamientoComisariatoThatHasThisAvionList; }
    public void setEquipamientoComisariatoThatHasThisAvionList(List<EquipamientoComisariato> v){ this.equipamientoComisariatoThatHasThisAvionList = v; }
    
    public List<AvionSistemaEntretenimiento> getAvionSistemaEntretenimientoThatHasThisAvionList(){ return this.avionSistemaEntretenimientoThatHasThisAvionList; }
    public void setAvionSistemaEntretenimientoThatHasThisAvionList(List<AvionSistemaEntretenimiento> v){ this.avionSistemaEntretenimientoThatHasThisAvionList = v; }
    
    public List<AvionCapacidad> getAvionCapacidadThatHasThisAvionList(){ return this.avionCapacidadThatHasThisAvionList; }
    public void setAvionCapacidadThatHasThisAvionList(List<AvionCapacidad> v){ this.avionCapacidadThatHasThisAvionList = v; }
    
    public List<AvionAudifono> getAvionAudifonoThatHasThisAvionList(){ return this.avionAudifonoThatHasThisAvionList; }
    public void setAvionAudifonoThatHasThisAvionList(List<AvionAudifono> v){ this.avionAudifonoThatHasThisAvionList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idAvion).hashCode();
		hash += String.valueOf(tipoEquipoAvion).hashCode();
		hash += String.valueOf(matricula).hashCode();
		hash += String.valueOf(matriculaCorta).hashCode();
		hash += String.valueOf(estatus).hashCode();
		hash += String.valueOf(idConectividad).hashCode();
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
        if (!(o instanceof Avion)) {
            return false;
        }		
		Avion other = (Avion ) o;
		if (!Objects.equals(this.idAvion, other.idAvion)) { return false; }		
		if (!Objects.equals(this.tipoEquipoAvion, other.tipoEquipoAvion)) { return false; }		
		if (!Objects.equals(this.matricula, other.matricula)) { return false; }		
		if (!Objects.equals(this.matriculaCorta, other.matriculaCorta)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
		if (!Objects.equals(this.idConectividad, other.idConectividad)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Avion{");
		sb.append("idAvion" ).append("=").append(idAvion).append("|");
		sb.append("tipoEquipoAvion" ).append("=").append(tipoEquipoAvion).append("|");
		sb.append("matricula" ).append("=").append(matricula).append("|");
		sb.append("matriculaCorta" ).append("=").append(matriculaCorta).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("idConectividad" ).append("=").append(idConectividad).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
