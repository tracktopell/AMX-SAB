package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Material;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table material.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/30 07:39
 */

public class MaterialAssembler {    
    
    /** 
     * Private Constructor
     */
    private MaterialAssembler() {
    }

    public static Material buildJpaEntity(MaterialDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Material jpaEntity = new Material();

        jpaEntity.setNumeroParte( dtoEntity.getNumeroParte()); // normal
        ParametrosDTO categoriaDTO = new ParametrosDTO();
        categoriaDTO.setIdParametro( dtoEntity.getCategoria());
        jpaEntity.setCategoria( ParametrosAssembler.buildJpaEntity( categoriaDTO ));
        jpaEntity.setDescripcionEs( dtoEntity.getDescripcionEs()); // normal
        jpaEntity.setDescripcionEn( dtoEntity.getDescripcionEn()); // normal
        ParametrosDTO tipoAbastecimientoDTO = new ParametrosDTO();
        tipoAbastecimientoDTO.setIdParametro( dtoEntity.getTipoAbastecimiento());
        jpaEntity.setTipoAbastecimiento( ParametrosAssembler.buildJpaEntity( tipoAbastecimientoDTO ));
        jpaEntity.setUrlMultimedia( dtoEntity.getUrlMultimedia()); // normal
        CategoriaMaterialDTO categoriaMaterialDTO = new CategoriaMaterialDTO();
        categoriaMaterialDTO.setIdCategoriaMaterial( dtoEntity.getIdCategoriaMaterial());
        jpaEntity.setCategoriaMaterial( CategoriaMaterialAssembler.buildJpaEntity( categoriaMaterialDTO ));
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<Material> buildJpaEntityList(List<MaterialDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Material> jpaEntityList = new ArrayList<>();
		Material jpaEntity = null;
		for(MaterialDTO dtoEntity: dtoEntityList){
			jpaEntity = new Material();
            jpaEntity.setNumeroParte( dtoEntity.getNumeroParte());
            ParametrosDTO categoriaDTO = new ParametrosDTO();
            categoriaDTO.setIdParametro( dtoEntity.getCategoria());
            jpaEntity.setCategoria( ParametrosAssembler.buildJpaEntity( categoriaDTO ));
            jpaEntity.setDescripcionEs( dtoEntity.getDescripcionEs());
            jpaEntity.setDescripcionEn( dtoEntity.getDescripcionEn());
            ParametrosDTO tipoAbastecimientoDTO = new ParametrosDTO();
            tipoAbastecimientoDTO.setIdParametro( dtoEntity.getTipoAbastecimiento());
            jpaEntity.setTipoAbastecimiento( ParametrosAssembler.buildJpaEntity( tipoAbastecimientoDTO ));
            jpaEntity.setUrlMultimedia( dtoEntity.getUrlMultimedia());
            CategoriaMaterialDTO categoriaMaterialDTO = new CategoriaMaterialDTO();
            categoriaMaterialDTO.setIdCategoriaMaterial( dtoEntity.getIdCategoriaMaterial());
            jpaEntity.setCategoriaMaterial( CategoriaMaterialAssembler.buildJpaEntity( categoriaMaterialDTO ));
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static MaterialDTO buildDTOEntity(Material jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        MaterialDTO dtoEntity =  new MaterialDTO();		

        dtoEntity.setNumeroParte( jpaEntity.getNumeroParte() ); // primitive
        //Not Embedable: Categoria -> Parametros, FTable: parametros, HyperName:CATEGORIA
        dtoEntity.setCategoria( jpaEntity.getCategoria()!=null?jpaEntity.getCategoria().getIdParametro():null);
        dtoEntity.setDescripcionEs( jpaEntity.getDescripcionEs() ); // primitive
        dtoEntity.setDescripcionEn( jpaEntity.getDescripcionEn() ); // primitive
        //Not Embedable: TipoAbastecimiento -> Parametros, FTable: parametros, HyperName:TIPO_ABASTECIMIENTO
        dtoEntity.setTipoAbastecimiento( jpaEntity.getTipoAbastecimiento()!=null?jpaEntity.getTipoAbastecimiento().getIdParametro():null);
        dtoEntity.setUrlMultimedia( jpaEntity.getUrlMultimedia() ); // primitive
        //Not Embedable: IdCategoriaMaterial -> CategoriaMaterial, FTable: categoria_material, HyperName:categoria_material
        dtoEntity.setIdCategoriaMaterial( jpaEntity.getCategoriaMaterial()!=null?jpaEntity.getCategoriaMaterial().getIdCategoriaMaterial():null);
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<MaterialDTO> buildDTOEntityList(List<Material> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<MaterialDTO> dtoEntityList = new ArrayList<>();
        MaterialDTO dtoEntity =  null;
		for(Material jpaEntity: jpaEntityList){
			dtoEntity =  new MaterialDTO();
            dtoEntity.setNumeroParte( jpaEntity.getNumeroParte() );
            //Not Embedable: Categoria -> Parametros, FTable: parametros, HyperName:CATEGORIA
            dtoEntity.setCategoria( jpaEntity.getCategoria()!=null?jpaEntity.getCategoria().getIdParametro():null);
            dtoEntity.setDescripcionEs( jpaEntity.getDescripcionEs() );
            dtoEntity.setDescripcionEn( jpaEntity.getDescripcionEn() );
            //Not Embedable: TipoAbastecimiento -> Parametros, FTable: parametros, HyperName:TIPO_ABASTECIMIENTO
            dtoEntity.setTipoAbastecimiento( jpaEntity.getTipoAbastecimiento()!=null?jpaEntity.getTipoAbastecimiento().getIdParametro():null);
            dtoEntity.setUrlMultimedia( jpaEntity.getUrlMultimedia() );
            //Not Embedable: IdCategoriaMaterial -> CategoriaMaterial, FTable: categoria_material, HyperName:categoria_material
            dtoEntity.setIdCategoriaMaterial( jpaEntity.getCategoriaMaterial()!=null?jpaEntity.getCategoriaMaterial().getIdCategoriaMaterial():null);
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
