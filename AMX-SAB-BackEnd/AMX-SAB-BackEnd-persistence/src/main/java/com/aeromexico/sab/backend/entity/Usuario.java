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
 * Class for mapping JPA Entity of Table usuario.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.countAll", query = "SELECT COUNT(u) FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findByContraseña", query = "SELECT u FROM Usuario u WHERE u.contraseña = :contraseña")
    , @NamedQuery(name = "Usuario.findByEstatus", query = "SELECT u FROM Usuario u WHERE u.estatus = :estatus")
})
public class Usuario implements java.io.Serializable {
    private static final long serialVersionUID = 1989780873;
    
    /**
    * The 'id usuario' Maps to COLUMN 'id_usuario'
    */
    
    @Id
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "ID_USUARIO" , nullable=false  )
    private Integer idUsuario;
    
    /**
    * The 'email' Maps to COLUMN 'email'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL" , length=100, nullable=false)
    private String email;
    
    /**
    * The 'contraseña' Maps to COLUMN 'contraseña'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CONTRASEÑA" , length=255, nullable=false)
    private String contraseña;
    
    /**
    * The 'fecha creacion' Maps to COLUMN 'fecha_creacion'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION" , nullable=false)
    private java.sql.Date fechaCreacion;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    /** 
    * Map the relation to empleado table where has id_usuario object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    // empleado Well know as Empleado
    private List<Empleado> empleadoThatHasThisUsuarioList;
    
    /** 
    * Map the relation to contacto_proveedor_estacion table where has id_usuario object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    // contacto_proveedor_estacion Well know as ContactoProveedorEstacion
    private List<ContactoProveedorEstacion> contactoProveedorEstacionThatHasThisUsuarioList;
    

    
    @ManyToMany(mappedBy = "usuarioList")
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
    public Integer getIdUsuario() { return this.idUsuario;}
    public void setIdUsuario(Integer v) { this.idUsuario = v; }
    
    public String getEmail() { return this.email;}
    public void setEmail(String v) { this.email = v; }
    
    public String getContraseña() { return this.contraseña;}
    public void setContraseña(String v) { this.contraseña = v; }
    
    public java.sql.Date getFechaCreacion() { return this.fechaCreacion;}
    public void setFechaCreacion(java.sql.Date v) { this.fechaCreacion = v; }
    
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
		hash += String.valueOf(idUsuario).hashCode();
		hash += String.valueOf(email).hashCode();
		hash += String.valueOf(contraseña).hashCode();
		hash += String.valueOf(fechaCreacion).hashCode();
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
		if (!Objects.equals(this.idUsuario, other.idUsuario)) { return false; }		
		if (!Objects.equals(this.email, other.email)) { return false; }		
		if (!Objects.equals(this.contraseña, other.contraseña)) { return false; }		
		if (!Objects.equals(this.fechaCreacion, other.fechaCreacion)) { return false; }		
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
		sb.append("idUsuario" ).append("=").append(idUsuario).append("|");
		sb.append("email" ).append("=").append(email).append("|");
		sb.append("contraseña" ).append("=").append(contraseña).append("|");
		sb.append("fechaCreacion" ).append("=").append(fechaCreacion).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
