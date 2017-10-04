package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Empleado;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table empleado.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/04 07:27
 */

public class EmpleadoAssembler {    
    
    /** 
     * Private Constructor
     */
    private EmpleadoAssembler() {
    }

    public static Empleado buildJpaEntity(EmpleadoDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Empleado jpaEntity = new Empleado();

        jpaEntity.setIdEmpleado( dtoEntity.getIdEmpleado()); // normal
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setEmailUsuario( dtoEntity.getEmailUsuario());
        jpaEntity.setUsuario( UsuarioAssembler.buildJpaEntity( usuarioDTO ));
        CompaniaDTO companiaDTO = new CompaniaDTO();
        companiaDTO.setIdCompania( dtoEntity.getIdCompania());
        jpaEntity.setCompania( CompaniaAssembler.buildJpaEntity( companiaDTO ));
        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setIdArea( dtoEntity.getIdArea());
        jpaEntity.setArea( AreaAssembler.buildJpaEntity( areaDTO ));
        EstacionDTO estacionDTO = new EstacionDTO();
        estacionDTO.setIdEstacion( dtoEntity.getIdEstacion());
        jpaEntity.setEstacion( EstacionAssembler.buildJpaEntity( estacionDTO ));
        jpaEntity.setTelefono( dtoEntity.getTelefono()); // normal
        jpaEntity.setExtension( dtoEntity.getExtension()); // normal
        jpaEntity.setDirectorioSab( dtoEntity.getDirectorioSab()); // normal
        jpaEntity.setEsatus( dtoEntity.getEsatus()); // normal

        return jpaEntity;
    }

    public static List<Empleado> buildJpaEntityList(List<EmpleadoDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Empleado> jpaEntityList = new ArrayList<>();
		Empleado jpaEntity = null;
		for(EmpleadoDTO dtoEntity: dtoEntityList){
			jpaEntity = new Empleado();
            jpaEntity.setIdEmpleado( dtoEntity.getIdEmpleado());
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setEmailUsuario( dtoEntity.getEmailUsuario());
            jpaEntity.setUsuario( UsuarioAssembler.buildJpaEntity( usuarioDTO ));
            CompaniaDTO companiaDTO = new CompaniaDTO();
            companiaDTO.setIdCompania( dtoEntity.getIdCompania());
            jpaEntity.setCompania( CompaniaAssembler.buildJpaEntity( companiaDTO ));
            AreaDTO areaDTO = new AreaDTO();
            areaDTO.setIdArea( dtoEntity.getIdArea());
            jpaEntity.setArea( AreaAssembler.buildJpaEntity( areaDTO ));
            EstacionDTO estacionDTO = new EstacionDTO();
            estacionDTO.setIdEstacion( dtoEntity.getIdEstacion());
            jpaEntity.setEstacion( EstacionAssembler.buildJpaEntity( estacionDTO ));
            jpaEntity.setTelefono( dtoEntity.getTelefono());
            jpaEntity.setExtension( dtoEntity.getExtension());
            jpaEntity.setDirectorioSab( dtoEntity.getDirectorioSab());
            jpaEntity.setEsatus( dtoEntity.getEsatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static EmpleadoDTO buildDTOEntity(Empleado jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        EmpleadoDTO dtoEntity =  new EmpleadoDTO();		

        dtoEntity.setIdEmpleado( jpaEntity.getIdEmpleado() ); // primitive
        //Not Embedable: EmailUsuario -> Usuario, FTable: usuario, HyperName:usuario
        dtoEntity.setEmailUsuario( jpaEntity.getUsuario()!=null?jpaEntity.getUsuario().getEmailUsuario():null);
        //Not Embedable: IdCompania -> Compania, FTable: compania, HyperName:compania
        dtoEntity.setIdCompania( jpaEntity.getCompania()!=null?jpaEntity.getCompania().getIdCompania():null);
        //Not Embedable: IdArea -> Area, FTable: area, HyperName:area
        dtoEntity.setIdArea( jpaEntity.getArea()!=null?jpaEntity.getArea().getIdArea():null);
        //Not Embedable: IdEstacion -> Estacion, FTable: estacion, HyperName:estacion
        dtoEntity.setIdEstacion( jpaEntity.getEstacion()!=null?jpaEntity.getEstacion().getIdEstacion():null);
        dtoEntity.setTelefono( jpaEntity.getTelefono() ); // primitive
        dtoEntity.setExtension( jpaEntity.getExtension() ); // primitive
        dtoEntity.setDirectorioSab( jpaEntity.getDirectorioSab() ); // primitive
        dtoEntity.setEsatus( jpaEntity.getEsatus() ); // primitive

        return dtoEntity;
    }

	public static List<EmpleadoDTO> buildDTOEntityList(List<Empleado> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<EmpleadoDTO> dtoEntityList = new ArrayList<>();
        EmpleadoDTO dtoEntity =  null;
		for(Empleado jpaEntity: jpaEntityList){
			dtoEntity =  new EmpleadoDTO();
            dtoEntity.setIdEmpleado( jpaEntity.getIdEmpleado() );
            //Not Embedable: EmailUsuario -> Usuario, FTable: usuario, HyperName:usuario
            dtoEntity.setEmailUsuario( jpaEntity.getUsuario()!=null?jpaEntity.getUsuario().getEmailUsuario():null);
            //Not Embedable: IdCompania -> Compania, FTable: compania, HyperName:compania
            dtoEntity.setIdCompania( jpaEntity.getCompania()!=null?jpaEntity.getCompania().getIdCompania():null);
            //Not Embedable: IdArea -> Area, FTable: area, HyperName:area
            dtoEntity.setIdArea( jpaEntity.getArea()!=null?jpaEntity.getArea().getIdArea():null);
            //Not Embedable: IdEstacion -> Estacion, FTable: estacion, HyperName:estacion
            dtoEntity.setIdEstacion( jpaEntity.getEstacion()!=null?jpaEntity.getEstacion().getIdEstacion():null);
            dtoEntity.setTelefono( jpaEntity.getTelefono() );
            dtoEntity.setExtension( jpaEntity.getExtension() );
            dtoEntity.setDirectorioSab( jpaEntity.getDirectorioSab() );
            dtoEntity.setEsatus( jpaEntity.getEsatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
