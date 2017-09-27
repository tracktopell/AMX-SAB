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
 * Class for mapping JPA Entity of Table empleado.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

@Entity
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.countAll", query = "SELECT COUNT(e) FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empleado.findByApellidoPaterno", query = "SELECT e FROM Empleado e WHERE e.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "Empleado.findByApellidoMaterno", query = "SELECT e FROM Empleado e WHERE e.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT e FROM Empleado e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Empleado.findByExtension", query = "SELECT e FROM Empleado e WHERE e.extension = :extension")
    , @NamedQuery(name = "Empleado.findByDirectorioSab", query = "SELECT e FROM Empleado e WHERE e.directorioSab = :directorioSab")
    , @NamedQuery(name = "Empleado.findBycompania", query = "SELECT e FROM Empleado e WHERE e.compania = :compania")
    , @NamedQuery(name = "Empleado.findByusuario", query = "SELECT e FROM Empleado e WHERE e.usuario = :usuario")
    , @NamedQuery(name = "Empleado.findByarea", query = "SELECT e FROM Empleado e WHERE e.area = :area")
    , @NamedQuery(name = "Empleado.findByestacion", query = "SELECT e FROM Empleado e WHERE e.estacion = :estacion")
    , @NamedQuery(name = "Empleado.findByEsatus", query = "SELECT e FROM Empleado e WHERE e.esatus = :esatus")
})
public class Empleado implements java.io.Serializable {
    private static final long serialVersionUID = 1555009629;
    
    /**
    * The 'id empleado' Maps to COLUMN 'id_empleado'
    */
    
    @Id
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "ID_EMPLEADO" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idEmpleado;
    
    /**
    * The 'nombre' Maps to COLUMN 'nombre'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE" , length=50, nullable=false)
    private String nombre;
    
    /**
    * The 'apellido paterno' Maps to COLUMN 'apellido_paterno'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APELLIDO_PATERNO" , length=50, nullable=false)
    private String apellidoPaterno;
    
    /**
    * The 'apellido materno' Maps to COLUMN 'apellido_materno'
    */
    
    @Basic(optional = true)
    @Size(max = 50)
    @Column(name = "APELLIDO_MATERNO" , length=50, nullable=true)
    private String apellidoMaterno;
    
    /**
    * The 'telefono' Maps to COLUMN 'telefono'
    */
    
    @Basic(optional = true)
    @Size(max = 25)
    @Column(name = "TELEFONO" , length=25, nullable=true)
    private String telefono;
    
    /**
    * The 'extension' Maps to COLUMN 'extension'
    */
    
    @Basic(optional = true)
    @Size(max = 10)
    @Column(name = "EXTENSION" , length=10, nullable=true)
    private String extension;
    
    /**
    * The 'directorio sab' Maps to COLUMN 'directorio_sab'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIRECTORIO_SAB" , nullable=false)
    private Short directorioSab;
    
    /**
    * The 'id compania' Maps to COLUMN 'id_compania'
    */
    
    @JoinColumn(name = "ID_COMPANIA" , referencedColumnName = "ID_COMPANIA")
    @ManyToOne(optional = false)
    private Compania compania;
    
    /**
    * The 'id usuario' Maps to COLUMN 'id_usuario'
    */
    
    @JoinColumn(name = "ID_USUARIO" , referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario usuario;
    
    /**
    * The 'id area' Maps to COLUMN 'id_area'
    */
    
    @JoinColumn(name = "ID_AREA" , referencedColumnName = "ID_AREA")
    @ManyToOne(optional = true)
    private Area area;
    
    /**
    * The 'id estacion' Maps to COLUMN 'id_estacion'
    */
    
    @JoinColumn(name = "ID_ESTACION" , referencedColumnName = "ID_ESTACION")
    @ManyToOne(optional = false)
    private Estacion estacion;
    
    /**
    * The 'esatus' Maps to COLUMN 'esatus'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESATUS" , nullable=false)
    private Short esatus;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Empleado() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdEmpleado() { return this.idEmpleado;}
    public void setIdEmpleado(Integer v) { this.idEmpleado = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public String getApellidoPaterno() { return this.apellidoPaterno;}
    public void setApellidoPaterno(String v) { this.apellidoPaterno = v; }
    
    public String getApellidoMaterno() { return this.apellidoMaterno;}
    public void setApellidoMaterno(String v) { this.apellidoMaterno = v; }
    
    public String getTelefono() { return this.telefono;}
    public void setTelefono(String v) { this.telefono = v; }
    
    public String getExtension() { return this.extension;}
    public void setExtension(String v) { this.extension = v; }
    
    public Short getDirectorioSab() { return this.directorioSab;}
    public void setDirectorioSab(Short v) { this.directorioSab = v; }
    
    public Compania getCompania(){ return this.compania ; }
    public void setCompania(Compania x){ this.compania = x; }
    
    public Usuario getUsuario(){ return this.usuario ; }
    public void setUsuario(Usuario x){ this.usuario = x; }
    
    public Area getArea(){ return this.area ; }
    public void setArea(Area x){ this.area = x; }
    
    public Estacion getEstacion(){ return this.estacion ; }
    public void setEstacion(Estacion x){ this.estacion = x; }
    
    public Short getEsatus() { return this.esatus;}
    public void setEsatus(Short v) { this.esatus = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idEmpleado).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(apellidoPaterno).hashCode();
		hash += String.valueOf(apellidoMaterno).hashCode();
		hash += String.valueOf(telefono).hashCode();
		hash += String.valueOf(extension).hashCode();
		hash += String.valueOf(directorioSab).hashCode();
		hash += String.valueOf(compania).hashCode();
		hash += String.valueOf(usuario).hashCode();
		hash += String.valueOf(area).hashCode();
		hash += String.valueOf(estacion).hashCode();
		hash += String.valueOf(esatus).hashCode();
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
        if (!(o instanceof Empleado)) {
            return false;
        }		
		Empleado other = (Empleado ) o;
		if (!Objects.equals(this.idEmpleado, other.idEmpleado)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) { return false; }		
		if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) { return false; }		
		if (!Objects.equals(this.telefono, other.telefono)) { return false; }		
		if (!Objects.equals(this.extension, other.extension)) { return false; }		
		if (!Objects.equals(this.directorioSab, other.directorioSab)) { return false; }		
		if (!Objects.equals(this.compania, other.compania)) { return false; }		
		if (!Objects.equals(this.usuario, other.usuario)) { return false; }		
		if (!Objects.equals(this.area, other.area)) { return false; }		
		if (!Objects.equals(this.estacion, other.estacion)) { return false; }		
		if (!Objects.equals(this.esatus, other.esatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Empleado{");
		sb.append("idEmpleado" ).append("=").append(idEmpleado).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("apellidoPaterno" ).append("=").append(apellidoPaterno).append("|");
		sb.append("apellidoMaterno" ).append("=").append(apellidoMaterno).append("|");
		sb.append("telefono" ).append("=").append(telefono).append("|");
		sb.append("extension" ).append("=").append(extension).append("|");
		sb.append("directorioSab" ).append("=").append(directorioSab).append("|");
		sb.append("compania" ).append("=").append(compania).append("|");
		sb.append("usuario" ).append("=").append(usuario).append("|");
		sb.append("area" ).append("=").append(area).append("|");
		sb.append("estacion" ).append("=").append(estacion).append("|");
		sb.append("esatus" ).append("=").append(esatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
