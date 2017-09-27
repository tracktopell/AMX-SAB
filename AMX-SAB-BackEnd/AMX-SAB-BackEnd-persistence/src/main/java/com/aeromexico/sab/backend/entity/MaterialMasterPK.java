package com.aeromexico.sab.backend.entity;

import java.util.Set;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Class for mapping JPA Embedable PK of Table material_master_P_K.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

@Embeddable

@XmlRootElement
public class MaterialMasterPK implements java.io.Serializable {
    private static final long serialVersionUID = 812265671;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LNUMERO_PARTE", nullable= false)
    private String lnumeroParte;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ID_KIT", nullable= false)
    private String idKit;

    /** 
     * Default Constructor
     */
    public MaterialMasterPK() {
    }
    
    /**
     * Getters and Setters
     */
    public String getLnumeroParte() { return this.lnumeroParte;}
    public void setLnumeroParte(String v) { this.lnumeroParte = v; }
    
    public String getIdKit() { return this.idKit;}
    public void setIdKit(String v) { this.idKit = v; }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(lnumeroParte).hashCode();
		hash += String.valueOf(idKit).hashCode();
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
        if (!(o instanceof MaterialMasterPK)) {
            return false;
        }		
		MaterialMasterPK other = (MaterialMasterPK ) o;
		if (!Objects.equals(this.lnumeroParte, other.lnumeroParte)) { return false; }		
		if (!Objects.equals(this.idKit, other.idKit)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("MaterialMasterPK{");
		sb.append("lnumeroParte" ).append("=").append(lnumeroParte).append("|");
		sb.append("idKit" ).append("=").append(idKit).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
