package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.ContactoProveedorEstacion;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table contacto_proveedor_estacion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/28 19:09
 */

public class ContactoProveedorEstacionAssembler {    
    
    /** 
     * Private Constructor
     */
    private ContactoProveedorEstacionAssembler() {
    }

    public static ContactoProveedorEstacion buildJpaEntity(ContactoProveedorEstacionDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		ContactoProveedorEstacion jpaEntity = new ContactoProveedorEstacion();

        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setIdProveedor( dtoEntity.getIdProveedor());
        jpaEntity.setProveedor( ProveedorAssembler.buildJpaEntity( proveedorDTO ));
        EstacionDTO estacionDTO = new EstacionDTO();
        estacionDTO.setIdEstacion( dtoEntity.getIdEstacion());
        jpaEntity.setEstacion( EstacionAssembler.buildJpaEntity( estacionDTO ));
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        jpaEntity.setEmail( dtoEntity.getEmail()); // normal
        jpaEntity.setTelefono( dtoEntity.getTelefono()); // normal
        jpaEntity.setExtencion( dtoEntity.getExtencion()); // normal
        jpaEntity.setPuestoAreaEn( dtoEntity.getPuestoAreaEn()); // normal
        jpaEntity.setPuestoAreaEs( dtoEntity.getPuestoAreaEs()); // normal
        jpaEntity.setId( dtoEntity.getId()); // normal
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario( dtoEntity.getIdUsuario());
        jpaEntity.setUsuario( UsuarioAssembler.buildJpaEntity( usuarioDTO ));
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<ContactoProveedorEstacion> buildJpaEntityList(List<ContactoProveedorEstacionDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<ContactoProveedorEstacion> jpaEntityList = new ArrayList<>();
		ContactoProveedorEstacion jpaEntity = null;
		for(ContactoProveedorEstacionDTO dtoEntity: dtoEntityList){
			jpaEntity = new ContactoProveedorEstacion();
            ProveedorDTO proveedorDTO = new ProveedorDTO();
            proveedorDTO.setIdProveedor( dtoEntity.getIdProveedor());
            jpaEntity.setProveedor( ProveedorAssembler.buildJpaEntity( proveedorDTO ));
            EstacionDTO estacionDTO = new EstacionDTO();
            estacionDTO.setIdEstacion( dtoEntity.getIdEstacion());
            jpaEntity.setEstacion( EstacionAssembler.buildJpaEntity( estacionDTO ));
            jpaEntity.setNombre( dtoEntity.getNombre());
            jpaEntity.setEmail( dtoEntity.getEmail());
            jpaEntity.setTelefono( dtoEntity.getTelefono());
            jpaEntity.setExtencion( dtoEntity.getExtencion());
            jpaEntity.setPuestoAreaEn( dtoEntity.getPuestoAreaEn());
            jpaEntity.setPuestoAreaEs( dtoEntity.getPuestoAreaEs());
            jpaEntity.setId( dtoEntity.getId());
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setIdUsuario( dtoEntity.getIdUsuario());
            jpaEntity.setUsuario( UsuarioAssembler.buildJpaEntity( usuarioDTO ));
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static ContactoProveedorEstacionDTO buildDTOEntity(ContactoProveedorEstacion jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        ContactoProveedorEstacionDTO dtoEntity =  new ContactoProveedorEstacionDTO();		

        //Not Embedable: IdProveedor -> Proveedor, FTable: proveedor, HyperName:proveedor
        dtoEntity.setIdProveedor( jpaEntity.getProveedor()!=null?jpaEntity.getProveedor().getIdProveedor():null);
        //Not Embedable: IdEstacion -> Estacion, FTable: estacion, HyperName:estacion
        dtoEntity.setIdEstacion( jpaEntity.getEstacion()!=null?jpaEntity.getEstacion().getIdEstacion():null);
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        dtoEntity.setEmail( jpaEntity.getEmail() ); // primitive
        dtoEntity.setTelefono( jpaEntity.getTelefono() ); // primitive
        dtoEntity.setExtencion( jpaEntity.getExtencion() ); // primitive
        dtoEntity.setPuestoAreaEn( jpaEntity.getPuestoAreaEn() ); // primitive
        dtoEntity.setPuestoAreaEs( jpaEntity.getPuestoAreaEs() ); // primitive
        dtoEntity.setId( jpaEntity.getId() ); // primitive
        //Not Embedable: IdUsuario -> Usuario, FTable: usuario, HyperName:usuario
        dtoEntity.setIdUsuario( jpaEntity.getUsuario()!=null?jpaEntity.getUsuario().getIdUsuario():null);
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<ContactoProveedorEstacionDTO> buildDTOEntityList(List<ContactoProveedorEstacion> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<ContactoProveedorEstacionDTO> dtoEntityList = new ArrayList<>();
        ContactoProveedorEstacionDTO dtoEntity =  null;
		for(ContactoProveedorEstacion jpaEntity: jpaEntityList){
			dtoEntity =  new ContactoProveedorEstacionDTO();
            //Not Embedable: IdProveedor -> Proveedor, FTable: proveedor, HyperName:proveedor
            dtoEntity.setIdProveedor( jpaEntity.getProveedor()!=null?jpaEntity.getProveedor().getIdProveedor():null);
            //Not Embedable: IdEstacion -> Estacion, FTable: estacion, HyperName:estacion
            dtoEntity.setIdEstacion( jpaEntity.getEstacion()!=null?jpaEntity.getEstacion().getIdEstacion():null);
            dtoEntity.setNombre( jpaEntity.getNombre() );
            dtoEntity.setEmail( jpaEntity.getEmail() );
            dtoEntity.setTelefono( jpaEntity.getTelefono() );
            dtoEntity.setExtencion( jpaEntity.getExtencion() );
            dtoEntity.setPuestoAreaEn( jpaEntity.getPuestoAreaEn() );
            dtoEntity.setPuestoAreaEs( jpaEntity.getPuestoAreaEs() );
            dtoEntity.setId( jpaEntity.getId() );
            //Not Embedable: IdUsuario -> Usuario, FTable: usuario, HyperName:usuario
            dtoEntity.setIdUsuario( jpaEntity.getUsuario()!=null?jpaEntity.getUsuario().getIdUsuario():null);
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
