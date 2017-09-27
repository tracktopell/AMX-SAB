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
 * Class for mapping JPA Entity of Table master.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

@Entity
@Table(name = "master")
@NamedQueries({
    @NamedQuery(name = "Master.findAll", query = "SELECT m FROM Master m")
    , @NamedQuery(name = "Master.countAll", query = "SELECT COUNT(m) FROM Master m")
    , @NamedQuery(name = "Master.findByIdKit", query = "SELECT m FROM Master m WHERE m.idKit = :idKit")
    , @NamedQuery(name = "Master.findByNombreEs", query = "SELECT m FROM Master m WHERE m.nombreEs = :nombreEs")
    , @NamedQuery(name = "Master.findByNombreEn", query = "SELECT m FROM Master m WHERE m.nombreEn = :nombreEn")
    , @NamedQuery(name = "Master.findByUrlMultimedia", query = "SELECT m FROM Master m WHERE m.urlMultimedia = :urlMultimedia")
    , @NamedQuery(name = "Master.findByContenedor", query = "SELECT m FROM Master m WHERE m.contenedor = :contenedor")
    , @NamedQuery(name = "Master.findByParametros", query = "SELECT m FROM Master m WHERE m.parametros = :parametros")
    , @NamedQuery(name = "Master.findByParametros", query = "SELECT m FROM Master m WHERE m.parametros = :parametros")
    , @NamedQuery(name = "Master.findByParametros", query = "SELECT m FROM Master m WHERE m.parametros = :parametros")
    , @NamedQuery(name = "Master.findByParametros", query = "SELECT m FROM Master m WHERE m.parametros = :parametros")
})
public class Master implements java.io.Serializable {
    private static final long serialVersionUID = 468121027;
    
    /**
    * The 'id kit' Maps to COLUMN 'id_kit'
    */
    
    @Id
    //@Basic(optional = false)
    @Size(min = 1, max = 10)
    //@NotNull
    @Column(name = "ID_KIT" , length=10, nullable=false  )
    private String idKit;
    
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
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_EN" , length=50, nullable=false)
    private String nombreEn;
    
    /**
    * The 'url multimedia' Maps to COLUMN 'url_multimedia'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "URL_MULTIMEDIA" , length=255, nullable=false)
    private String urlMultimedia;
    
    /**
    * The 'contenedor' Maps to COLUMN 'contenedor'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CONTENEDOR" , length=50, nullable=false)
    private String contenedor;
    
    /**
    * The 'id unidad medida' Maps to COLUMN 'id_unidad_medida'
    */
    
    @JoinColumn(name = "ID_UNIDAD_MEDIDA" , referencedColumnName = "ID_PARAMETRO")
    @ManyToOne(optional = false)
    private Parametros parametros;
    
    /**
    * The 'id instrucciones nacionales' Maps to COLUMN 'id_instrucciones_nacionales'
    */
    
    @JoinColumn(name = "ID_INSTRUCCIONES_NACIONALES" , referencedColumnName = "ID_PARAMETRO")
    @ManyToOne(optional = false)
    private Parametros parametros;
    
    /**
    * The 'id instrucciones internac' Maps to COLUMN 'id_instrucciones_internac'
    */
    
    @JoinColumn(name = "ID_INSTRUCCIONES_INTERNAC" , referencedColumnName = "ID_PARAMETRO")
    @ManyToOne(optional = false)
    private Parametros parametros;
    
    /**
    * The 'id tipo kit' Maps to COLUMN 'id_tipo_kit'
    */
    
    @JoinColumn(name = "ID_TIPO_KIT" , referencedColumnName = "ID_PARAMETRO")
    @ManyToOne(optional = false)
    private Parametros parametros;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Master() {
    }
    
    /**
     * Getters and Setters
     */
    public String getIdKit() { return this.idKit;}
    public void setIdKit(String v) { this.idKit = v; }
    
    public String getNombreEs() { return this.nombreEs;}
    public void setNombreEs(String v) { this.nombreEs = v; }
    
    public String getNombreEn() { return this.nombreEn;}
    public void setNombreEn(String v) { this.nombreEn = v; }
    
    public String getUrlMultimedia() { return this.urlMultimedia;}
    public void setUrlMultimedia(String v) { this.urlMultimedia = v; }
    
    public String getContenedor() { return this.contenedor;}
    public void setContenedor(String v) { this.contenedor = v; }
    
    public Parametros getParametros() { return this.parametros;}
    public void setParametros(Parametros v) { this.parametros = v; }
    
    public Parametros getParametros() { return this.parametros;}
    public void setParametros(Parametros v) { this.parametros = v; }
    
    public Parametros getParametros() { return this.parametros;}
    public void setParametros(Parametros v) { this.parametros = v; }
    
    public Parametros getParametros() { return this.parametros;}
    public void setParametros(Parametros v) { this.parametros = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idKit).hashCode();
		hash += String.valueOf(nombreEs).hashCode();
		hash += String.valueOf(nombreEn).hashCode();
		hash += String.valueOf(urlMultimedia).hashCode();
		hash += String.valueOf(contenedor).hashCode();
		hash += String.valueOf(parametros).hashCode();
		hash += String.valueOf(parametros).hashCode();
		hash += String.valueOf(parametros).hashCode();
		hash += String.valueOf(parametros).hashCode();
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
        if (!(o instanceof Master)) {
            return false;
        }		
		Master other = (Master ) o;
		if (!Objects.equals(this.idKit, other.idKit)) { return false; }		
		if (!Objects.equals(this.nombreEs, other.nombreEs)) { return false; }		
		if (!Objects.equals(this.nombreEn, other.nombreEn)) { return false; }		
		if (!Objects.equals(this.urlMultimedia, other.urlMultimedia)) { return false; }		
		if (!Objects.equals(this.contenedor, other.contenedor)) { return false; }		
		if (!Objects.equals(this.parametros, other.parametros)) { return false; }		
		if (!Objects.equals(this.parametros, other.parametros)) { return false; }		
		if (!Objects.equals(this.parametros, other.parametros)) { return false; }		
		if (!Objects.equals(this.parametros, other.parametros)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Master{");
		sb.append("idKit" ).append("=").append(idKit).append("|");
		sb.append("nombreEs" ).append("=").append(nombreEs).append("|");
		sb.append("nombreEn" ).append("=").append(nombreEn).append("|");
		sb.append("urlMultimedia" ).append("=").append(urlMultimedia).append("|");
		sb.append("contenedor" ).append("=").append(contenedor).append("|");
		sb.append("parametros" ).append("=").append(parametros).append("|");
		sb.append("parametros" ).append("=").append(parametros).append("|");
		sb.append("parametros" ).append("=").append(parametros).append("|");
		sb.append("parametros" ).append("=").append(parametros).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
