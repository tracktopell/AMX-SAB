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
 * Class for mapping JPA Entity of Table usuario.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.countAll", query = "SELECT COUNT(u) FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByEmailUsuario", query = "SELECT u FROM Usuario u WHERE u.emailUsuario = :emailUsuario")
    , @NamedQuery(name = "Usuario.findByContrasenia", query = "SELECT u FROM Usuario u WHERE u.contrasenia = :contrasenia")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApellidoPaterno", query = "SELECT u FROM Usuario u WHERE u.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "Usuario.findByApellidoMaterno", query = "SELECT u FROM Usuario u WHERE u.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "Usuario.findByEstatus", query = "SELECT u FROM Usuario u WHERE u.estatus = :estatus")
})
public class Usuario implements java.io.Serializable {
    private static final long serialVersionUID = 1989780873;
    
    /**
    * The 'email usuario' Maps to COLUMN 'email_usuario'
    */
    
    @Id
    //@Basic(optional = false)
    //@Size(min = 1, max = 100)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "EMAIL_USUARIO" , length=100, nullable=false  )
    private String emailUsuario;
    
    /**
    * The 'contrasenia' Maps to COLUMN 'contrasenia'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 255)
    @Column(name = "CONTRASENIA" , length=255, nullable=false)
    private String contrasenia;
    
    /**
    * The 'fecha creacion' Maps to COLUMN 'fecha_creacion'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "FECHA_CREACION" , nullable=false)
    private java.sql.Timestamp fechaCreacion;
    
    /**
    * The 'nombre' Maps to COLUMN 'nombre'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "NOMBRE" , length=50, nullable=false)
    private String nombre;
    
    /**
    * The 'apellido paterno' Maps to COLUMN 'apellido_paterno'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "APELLIDO_PATERNO" , length=50, nullable=false)
    private String apellidoPaterno;
    
    /**
    * The 'apellido materno' Maps to COLUMN 'apellido_materno'
    */
    
    @Basic(optional = true)
    //@Size(max = 50)
    @Column(name = "APELLIDO_MATERNO" , length=50, nullable=true)
    private String apellidoMaterno;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    /** 
    * Map the relation to empleado table where has email_usuario object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    // empleado Well know as Empleado
    private List<Empleado> empleadoThatHasThisUsuarioList;
    
    /** 
    * Map the relation to contacto_proveedor_estacion table where has email_usuario object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    // contacto_proveedor_estacion Well know as ContactoProveedorEstacion
    private List<ContactoProveedorEstacion> contactoProveedorEstacionThatHasThisUsuarioList;
    

    
    @JoinTable(name               = "PERFIL_USUARIO",
               joinColumns        = {@JoinColumn(name = "EMAIL_USUARIO", referencedColumnName ="EMAIL_USUARIO")},
               inverseJoinColumns = {@JoinColumn(name = "PERFIL", referencedColumnName ="PERFIL")}
               )
    @ManyToMany //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Perfil> perfilList;
    
	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Usuario() {
    }
    
    /**
     * Getters and Setters
     */
    public String getEmailUsuario() { return this.emailUsuario;}
    public void setEmailUsuario(String v) { this.emailUsuario = v; }
    
    public String getContrasenia() { return this.contrasenia;}
    public void setContrasenia(String v) { this.contrasenia = v; }
    
    public java.sql.Timestamp getFechaCreacion() { return this.fechaCreacion;}
    public void setFechaCreacion(java.sql.Timestamp v) { this.fechaCreacion = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public String getApellidoPaterno() { return this.apellidoPaterno;}
    public void setApellidoPaterno(String v) { this.apellidoPaterno = v; }
    
    public String getApellidoMaterno() { return this.apellidoMaterno;}
    public void setApellidoMaterno(String v) { this.apellidoMaterno = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
    public List<Empleado> getEmpleadoThatHasThisUsuarioList(){ return this.empleadoThatHasThisUsuarioList; }
    public void setEmpleadoThatHasThisUsuarioList(List<Empleado> v){ this.empleadoThatHasThisUsuarioList = v; }
    
    public List<ContactoProveedorEstacion> getContactoProveedorEstacionThatHasThisUsuarioList(){ return this.contactoProveedorEstacionThatHasThisUsuarioList; }
    public void setContactoProveedorEstacionThatHasThisUsuarioList(List<ContactoProveedorEstacion> v){ this.contactoProveedorEstacionThatHasThisUsuarioList = v; }
    
	// M2M <*>
    public List<Perfil> getPerfilList() { return this.perfilList; }
    public void setPerfilList(List<Perfil>  v) { this.perfilList = v; }
    

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(emailUsuario).hashCode();
		hash += String.valueOf(contrasenia).hashCode();
		hash += String.valueOf(fechaCreacion).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(apellidoPaterno).hashCode();
		hash += String.valueOf(apellidoMaterno).hashCode();
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
        if (!(o instanceof Usuario)) {
            return false;
        }		
		Usuario other = (Usuario ) o;
		if (!Objects.equals(this.emailUsuario, other.emailUsuario)) { return false; }		
		if (!Objects.equals(this.contrasenia, other.contrasenia)) { return false; }		
		if (!Objects.equals(this.fechaCreacion, other.fechaCreacion)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) { return false; }		
		if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Usuario{");
		sb.append("emailUsuario" ).append("=").append(emailUsuario).append("|");
		sb.append("contrasenia" ).append("=").append(contrasenia).append("|");
		sb.append("fechaCreacion" ).append("=").append(fechaCreacion).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("apellidoPaterno" ).append("=").append(apellidoPaterno).append("|");
		sb.append("apellidoMaterno" ).append("=").append(apellidoMaterno).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
