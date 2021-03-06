-- ============================= CREACION DEL ESQUEMA DE LA BASE DE DATOS ====================
-- ============================= TABLES (41) =======================
CREATE TABLE PARAMETROS (
	ID_PARAMETRO		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	CLAVE		VARCHAR (50)	 NOT NULL ,
	VALOR		VARCHAR (100)	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_PARAMETRO)
);
-- ===============================================================================
CREATE TABLE COMPANIA (
	ID_COMPANIA		INTEGER	 NOT NULL ,
	CVE_COMPANIA		CHAR	 ,
	NOMBRE		VARCHAR (50)	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_COMPANIA)
);
-- ===============================================================================
CREATE TABLE MODELO_AVION (
	ID_MODELO_AVION		INTEGER	 NOT NULL ,
	MODELO		VARCHAR (50)	 NOT NULL ,
	DESCRIPCION		VARCHAR (200)	 ,
	TIPO_CABINA		INTEGER	 NOT NULL ,
	ID_COMPANIA		INTEGER	 NOT NULL ,
	ID_FABRICANTE		INTEGER	 NOT NULL ,
	ESTAUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_MODELO_AVION)
);
-- ===============================================================================
CREATE TABLE TIPO_EQUIPO_AVION (
	ID_TIPO_EQUIPO_AVION		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	ID_MODELO_AVION		INTEGER	 NOT NULL ,
	TOTAL_AVIONES		INTEGER	 NOT NULL ,
	TIPO_EQUIPO		VARCHAR (6)	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_TIPO_EQUIPO_AVION)
);
-- ===============================================================================
CREATE TABLE REGION (
	ID_REGION		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	CVE_REGION		VARCHAR (3)	 NOT NULL ,
	NOMBRE		VARCHAR (50)	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_REGION)
);
-- ===============================================================================
CREATE TABLE PAIS (
	ID_PAIS		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	CVE_PAIS		VARCHAR (3)	 ,
	NOMBRE		VARCHAR (50)	 NOT NULL ,
	ID_REGION		INTEGER	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_PAIS)
);
-- ===============================================================================
CREATE TABLE CIUDAD (
	ID_CIUDAD		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	NOMBRE		VARCHAR (50)	 NOT NULL ,
	ID_PAIS		INTEGER	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_CIUDAD)
);
-- ===============================================================================
CREATE TABLE ESTACION (
	ID_ESTACION		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	NOMBRE		VARCHAR (50)	 NOT NULL ,
	CLAVE_IATA		CHAR	 NOT NULL ,
	ID_CIUDAD		INTEGER	 NOT NULL ,
	OBSERVACIONES		VARCHAR (150)	 ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_ESTACION)
);
-- ===============================================================================
CREATE TABLE PRODUCTO (
	ID_PRODUCTO		INTEGER	 NOT NULL ,
	NOMBRE_PRODUCTO		CHAR	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_PRODUCTO)
);
-- ===============================================================================
CREATE TABLE CATEGORIA_MATERIAL (
	ID_CATEGORIA_MATERIAL		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	NOMBRE_ES		VARCHAR (50)	 NOT NULL ,
	NOMBRE_EN		VARCHAR (50)	 ,
	DESCRIPCION		VARCHAR (50)	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_CATEGORIA_MATERIAL)
);
-- ===============================================================================
CREATE TABLE KIT_MASTER (
	ID_KIT_MASTER		VARCHAR (10)	 NOT NULL ,
	NOMBRE_ES		VARCHAR (50)	 NOT NULL ,
	NOMBRE_EN		VARCHAR (50)	 NOT NULL ,
	URL_MULTIMEDIA		VARCHAR (255)	 NOT NULL ,
	CONTENEDOR		VARCHAR (50)	 NOT NULL ,
	ID_UNIDAD_MEDIDA		INTEGER	 NOT NULL ,
	ID_INSTRUCCIONES_NACIONALES		INTEGER	 NOT NULL ,
	ID_INSTRUCCIONES_INTERNAC		INTEGER	 NOT NULL ,
	ID_TIPO_KIT		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_KIT_MASTER)
);
-- ===============================================================================
CREATE TABLE AVION (
	ID_AVION		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	ID_TIPO_EQUIPO_AVION		INTEGER	 NOT NULL ,
	MATRICULA		VARCHAR (50)	 NOT NULL ,
	MATRICULA_CORTA		VARCHAR (10)	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	ID_CONECTIVIDAD		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_AVION)
);
-- ===============================================================================
CREATE TABLE MATERIAL (
	NUMERO_PARTE		VARCHAR (50)	 NOT NULL ,
	CATEGORIA		INTEGER	 NOT NULL ,
	DESCRIPCION_ES		VARCHAR (120)	 NOT NULL ,
	DESCRIPCION_EN		VARCHAR (120)	 ,
	TIPO_ABASTECIMIENTO		INTEGER	 NOT NULL ,
	URL_MULTIMEDIA		VARCHAR (255)	 ,
	MIME_TYPE		VARCHAR (64)	 NOT NULL ,
	ID_CATEGORIA_MATERIAL		INTEGER	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (NUMERO_PARTE)
);
-- ===============================================================================
CREATE TABLE USUARIO (
	EMAIL_USUARIO		VARCHAR (100)	 NOT NULL ,
	CONTRASENIA		VARCHAR (255)	 NOT NULL ,
	FECHA_CREACION		TIMESTAMP	 NOT NULL ,
	NOMBRE		VARCHAR (50)	 NOT NULL ,
	APELLIDO_PATERNO		VARCHAR (50)	 NOT NULL ,
	APELLIDO_MATERNO		VARCHAR (50)	 ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (EMAIL_USUARIO)
);
-- ===============================================================================
CREATE TABLE CLASE (
	ID_CLASE		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	NOMBRE		VARCHAR (50)	 NOT NULL ,
	CLAVE		VARCHAR (10)	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_CLASE)
);
-- ===============================================================================
CREATE TABLE TIPO_PROVEEDOR (
	ID_TIPO_PROVEEDOR		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	NOMBRE_ES		VARCHAR (50)	 NOT NULL ,
	NOMBRE_EN		VARCHAR (50)	 NOT NULL ,
	DESCRIPCION		VARCHAR (100)	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_TIPO_PROVEEDOR)
);
-- ===============================================================================
CREATE TABLE PERFIL (
	PERFIL		VARCHAR (50)	 NOT NULL ,
	DESCRIPCION		VARCHAR (255)	 NOT NULL ,
	PRIMARY KEY (PERFIL)
);
-- ===============================================================================
CREATE TABLE PROVEEDOR (
	ID_PROVEEDOR		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	ID_TIPO_PROVEEDOR		INTEGER	 NOT NULL ,
	ID_ESTACION		INTEGER	 NOT NULL ,
	NOMBRE		VARCHAR (50)	 NOT NULL ,
	CVE_PROVEEDOR		CHAR	 NOT NULL ,
	RAZON_SOCIAL		VARCHAR (150)	 ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_PROVEEDOR)
);
-- ===============================================================================
CREATE TABLE SISTEMA_ENTRETENIMIENTO (
	ID_SISTEMA_ENTRETENIMIENTO		INTEGER	 NOT NULL ,
	TIPO		VARCHAR (50)	 NOT NULL ,
	VERSION		VARCHAR (15)	 ,
	DESCRIPCION		VARCHAR (200)	 ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_SISTEMA_ENTRETENIMIENTO)
);
-- ===============================================================================
CREATE TABLE GRAFICO (
	ID_GRAFICO		INTEGER	 NOT NULL ,
	ID_PRODUCTO		INTEGER	 NOT NULL ,
	ID_TIPO_EQUIPO_AVION		INTEGER	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_GRAFICO)
);
-- ===============================================================================
CREATE TABLE ACOMODO_DETALLE (
	ID_ACOMODO_DETALLE		INTEGER	 NOT NULL ,
	NO_REV		INTEGER	 NOT NULL ,
	ANIO_REV		INTEGER	 NOT NULL ,
	URL_ACOMODO		VARCHAR (255)	 NOT NULL ,
	MIME_TYPE		VARCHAR (64)	 NOT NULL ,
	PRIMARY KEY (ID_ACOMODO_DETALLE)
);
-- ===============================================================================
CREATE TABLE AREA (
	ID_AREA		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	NOMBRE		VARCHAR (50)	 NOT NULL ,
	CLAVE		CHAR	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_AREA)
);
-- ===============================================================================
CREATE TABLE MATRIZ (
	ID_MATRIZ		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	ID_PRODUCTO		INTEGER	 NOT NULL ,
	ID_KIT_MASTER		VARCHAR (10)	 NOT NULL ,
	ID_TIPO_EQUIPO_AVION		INTEGER	 NOT NULL ,
	CANTIDAD_CJ		INTEGER	 NOT NULL ,
	CANTIDAD_CY		INTEGER	 NOT NULL ,
	TOTAL_MATRIZ		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_MATRIZ)
);
-- ===============================================================================
CREATE TABLE TRADUCCION (
	ID_TRADUCCION		INTEGER	 NOT NULL ,
	NOMBRE_ENTIDAD		VARCHAR (50)	 NOT NULL ,
	ID_ENTIDAD		INTEGER	 NOT NULL ,
	CAMPO		VARCHAR (50)	 NOT NULL ,
	VALOR		VARCHAR (100)	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_TRADUCCION)
);
-- ===============================================================================
CREATE TABLE MODULO_PERFIL (
	ID_MODULO		INTEGER	 NOT NULL ,
	PERFIL		VARCHAR (50)	 NOT NULL ,
	PERMISO_RWD		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_MODULO, PERFIL)
);
-- ===============================================================================
CREATE TABLE GRAFICO_DETALLE (
	ID_GRAFICO_DETALLE		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	ID_GRAFICO		INTEGER	 NOT NULL ,
	NO_REV		INTEGER	 NOT NULL ,
	ANIO_REV		INTEGER	 NOT NULL ,
	URL_GRAFICO		VARCHAR (255)	 NOT NULL ,
	MIME_TYPE		VARCHAR (64)	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_GRAFICO_DETALLE)
);
-- ===============================================================================
CREATE TABLE EMPLEADO (
	ID_EMPLEADO		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	EMAIL_USUARIO		VARCHAR (100)	 ,
	ID_COMPANIA		INTEGER	 NOT NULL ,
	ID_AREA		INTEGER	 ,
	ID_ESTACION		INTEGER	 NOT NULL ,
	TELEFONO		VARCHAR (25)	 ,
	EXTENSION		VARCHAR (10)	 ,
	DIRECTORIO_SAB		INTEGER	 NOT NULL ,
	ESATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_EMPLEADO)
);
-- ===============================================================================
CREATE TABLE CODIGO_SERVICIO (
	ID_CODIGO_SERVICIO		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	CVE_CODIGO_SERVICIO		CHAR	 NOT NULL ,
	NOMBRE		VARCHAR (100)	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	TIPO_CODIGO_SERVICIO		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_CODIGO_SERVICIO)
);
-- ===============================================================================
CREATE TABLE CONTACTO_PROVEEDOR_ESTACION (
	ID		INTEGER	 NOT NULL ,
	EMAIL_USUARIO		VARCHAR (100)	 ,
	ID_PROVEEDOR		INTEGER	 NOT NULL ,
	ID_ESTACION		INTEGER	 NOT NULL ,
	TELEFONO		VARCHAR (15)	 NOT NULL ,
	EXTENCION		VARCHAR (5)	 NOT NULL ,
	PUESTO_AREA_EN		VARCHAR (150)	 NOT NULL ,
	PUESTO_AREA_ES		VARCHAR (150)	 ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID)
);
-- ===============================================================================
CREATE TABLE MATRIZ_DETALLE (
	ID_MATRIZ_DETALLE		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	ID_MATRIZ		INTEGER	 NOT NULL ,
	ID_KIT_MASTER		VARCHAR (10)	 NOT NULL ,
	NUMERO_PARTE		VARCHAR (50)	 NOT NULL ,
	TOTAL_CY		INTEGER	 NOT NULL ,
	TOTAL_CJ		INTEGER	 NOT NULL ,
	TOTAL_DETALLE_MATRIZ		INTEGER	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_MATRIZ_DETALLE)
);
-- ===============================================================================
CREATE TABLE VUELO (
	ID_VUELO		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	NUMERO_VUELO		INTEGER	 NOT NULL ,
	TIPO_VUELO		INTEGER	 NOT NULL ,
	ID_ESTACION_ORIGEN		INTEGER	 NOT NULL ,
	ID_ESTACION_DESTINO		INTEGER	 NOT NULL ,
	TIPO_CABINA		INTEGER	 NOT NULL ,
	ID_COMPANIA		INTEGER	 NOT NULL ,
	ID_CLASE		INTEGER	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_VUELO)
);
-- ===============================================================================
CREATE TABLE HORARIO (
	ID_HORARIO		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	ID_REGION		INTEGER	 NOT NULL ,
	HORA_INICIO		TIME	 NOT NULL ,
	HORA_FIN		TIME	 NOT NULL ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_HORARIO)
);
-- ===============================================================================
CREATE TABLE AVION_AUDIFONO (
	ID_AVION_AUDIFONO		INTEGER	 NOT NULL ,
	ID_AVION		INTEGER	 NOT NULL ,
	ID_CLASE		INTEGER	 NOT NULL ,
	TIPO_AUDIFONO		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_AVION_AUDIFONO)
);
-- ===============================================================================
CREATE TABLE PERFIL_USUARIO (
	PERFIL		VARCHAR (50)	 NOT NULL ,
	EMAIL_USUARIO		VARCHAR (100)	 NOT NULL ,
	PRIMARY KEY (PERFIL, EMAIL_USUARIO)
);
-- ===============================================================================
CREATE TABLE EQUIPAMIENTO_COMISARIATO (
	ID_EQUIPAMIENTO_COMISARIATO		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	ID_AVION		INTEGER	 NOT NULL ,
	NOMBRE_ES		VARCHAR (50)	 NOT NULL ,
	NOMBRE_EN		VARCHAR (50)	 ,
	CANTIDAD		INTEGER	 NOT NULL ,
	PESO		DECIMAL	 NOT NULL ,
	OBSERVACIONES		VARCHAR (250)	 ,
	NUMERO_PARTE		VARCHAR (50)	 ,
	ESTATUS		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_EQUIPAMIENTO_COMISARIATO)
);
-- ===============================================================================
CREATE TABLE RELACION_FLOTA (
	ID_RELACION_FLOTA		INTEGER	 NOT NULL ,
	REVISION		INTEGER	 NOT NULL ,
	FECHA		DATE	 NOT NULL ,
	PRIMARY KEY (ID_RELACION_FLOTA)
);
-- ===============================================================================
CREATE TABLE AVION_CAPACIDAD (
	ID_AVION_CAPACIDAD		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	ID_AVION		INTEGER	 NOT NULL ,
	ID_CLASE		INTEGER	 NOT NULL ,
	CAPACIDAD		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_AVION_CAPACIDAD)
);
-- ===============================================================================
CREATE TABLE PROVEEDOR_ESTACION (
	ID_PROVEEDOR		INTEGER	 NOT NULL ,
	ID_ESTACION		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_PROVEEDOR, ID_ESTACION)
);
-- ===============================================================================
CREATE TABLE AVION_SISTEMA_ENTRETENIMIENTO (
	ID_AVION_SISTEMA_ENTRETENIMIENTO		INTEGER	 NOT NULL ,
	ID_AVION		INTEGER	 NOT NULL ,
	ID_SISTEMA_ENTRETENIMIENTO		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_AVION_SISTEMA_ENTRETENIMIENTO)
);
-- ===============================================================================
CREATE TABLE MATERIAL_MASTER (
	ID_KIT_MASTER		VARCHAR (10)	 NOT NULL ,
	NUMERO_PARTE		VARCHAR (50)	 NOT NULL ,
	CANTIDAD		INTEGER	 NOT NULL ,
	PESO		DOUBLE	 NOT NULL ,
	ID_UNIDAD_MEDIDA		INTEGER	 NOT NULL ,
	OBSERVACIONES		VARCHAR (255)	 NOT NULL ,
	PRIMARY KEY (ID_KIT_MASTER, NUMERO_PARTE)
);
-- ===============================================================================
CREATE TABLE ACOMODO (
	ID_ACOMODO		INTEGER	 NOT NULL GENERATED BY DEFAULT AS IDENTITY ,
	ID_ESTACION		INTEGER	 NOT NULL ,
	ID_TIPO_EQUIPO_AVION		INTEGER	 NOT NULL ,
	ID_PRODUCTO		INTEGER	 NOT NULL ,
	ID_ACOMODO_DETALLE		INTEGER	 NOT NULL ,
	PRIMARY KEY (ID_ACOMODO)
);
-- ===============================================================================
-- =================================== CONSTRAINTS ==============================
ALTER TABLE MODELO_AVION ADD FOREIGN KEY (TIPO_CABINA)	REFERENCES PARAMETROS(ID_PARAMETRO);
ALTER TABLE MODELO_AVION ADD FOREIGN KEY (ID_COMPANIA)	REFERENCES COMPANIA(ID_COMPANIA);
ALTER TABLE MODELO_AVION ADD FOREIGN KEY (ID_FABRICANTE)	REFERENCES PARAMETROS(ID_PARAMETRO);
ALTER TABLE TIPO_EQUIPO_AVION ADD FOREIGN KEY (ID_MODELO_AVION)	REFERENCES MODELO_AVION(ID_MODELO_AVION);
ALTER TABLE PAIS ADD FOREIGN KEY (ID_REGION)	REFERENCES REGION(ID_REGION);
ALTER TABLE CIUDAD ADD FOREIGN KEY (ID_PAIS)	REFERENCES PAIS(ID_PAIS);
ALTER TABLE ESTACION ADD FOREIGN KEY (ID_CIUDAD)	REFERENCES CIUDAD(ID_CIUDAD);
ALTER TABLE KIT_MASTER ADD FOREIGN KEY (ID_UNIDAD_MEDIDA)	REFERENCES PARAMETROS(ID_PARAMETRO);
ALTER TABLE KIT_MASTER ADD FOREIGN KEY (ID_INSTRUCCIONES_NACIONALES)	REFERENCES PARAMETROS(ID_PARAMETRO);
ALTER TABLE KIT_MASTER ADD FOREIGN KEY (ID_INSTRUCCIONES_INTERNAC)	REFERENCES PARAMETROS(ID_PARAMETRO);
ALTER TABLE KIT_MASTER ADD FOREIGN KEY (ID_TIPO_KIT)	REFERENCES PARAMETROS(ID_PARAMETRO);
ALTER TABLE AVION ADD FOREIGN KEY (ID_TIPO_EQUIPO_AVION)	REFERENCES TIPO_EQUIPO_AVION(ID_TIPO_EQUIPO_AVION);
ALTER TABLE AVION ADD FOREIGN KEY (ID_CONECTIVIDAD)	REFERENCES PARAMETROS(ID_PARAMETRO);
ALTER TABLE MATERIAL ADD FOREIGN KEY (CATEGORIA)	REFERENCES PARAMETROS(ID_PARAMETRO);
ALTER TABLE MATERIAL ADD FOREIGN KEY (TIPO_ABASTECIMIENTO)	REFERENCES PARAMETROS(ID_PARAMETRO);
ALTER TABLE MATERIAL ADD FOREIGN KEY (ID_CATEGORIA_MATERIAL)	REFERENCES CATEGORIA_MATERIAL(ID_CATEGORIA_MATERIAL);
ALTER TABLE PROVEEDOR ADD FOREIGN KEY (ID_TIPO_PROVEEDOR)	REFERENCES TIPO_PROVEEDOR(ID_TIPO_PROVEEDOR);
ALTER TABLE GRAFICO ADD FOREIGN KEY (ID_PRODUCTO)	REFERENCES PRODUCTO(ID_PRODUCTO);
ALTER TABLE GRAFICO ADD FOREIGN KEY (ID_TIPO_EQUIPO_AVION)	REFERENCES TIPO_EQUIPO_AVION(ID_TIPO_EQUIPO_AVION);
ALTER TABLE MATRIZ ADD FOREIGN KEY (ID_PRODUCTO)	REFERENCES PRODUCTO(ID_PRODUCTO);
ALTER TABLE MATRIZ ADD FOREIGN KEY (ID_KIT_MASTER)	REFERENCES KIT_MASTER(ID_KIT_MASTER);
ALTER TABLE MATRIZ ADD FOREIGN KEY (ID_TIPO_EQUIPO_AVION)	REFERENCES TIPO_EQUIPO_AVION(ID_TIPO_EQUIPO_AVION);
ALTER TABLE MODULO_PERFIL ADD FOREIGN KEY (PERFIL)	REFERENCES PERFIL(PERFIL);
ALTER TABLE GRAFICO_DETALLE ADD FOREIGN KEY (ID_GRAFICO)	REFERENCES GRAFICO(ID_GRAFICO);
ALTER TABLE EMPLEADO ADD FOREIGN KEY (EMAIL_USUARIO)	REFERENCES USUARIO(EMAIL_USUARIO);
ALTER TABLE EMPLEADO ADD FOREIGN KEY (ID_COMPANIA)	REFERENCES COMPANIA(ID_COMPANIA);
ALTER TABLE EMPLEADO ADD FOREIGN KEY (ID_AREA)	REFERENCES AREA(ID_AREA);
ALTER TABLE EMPLEADO ADD FOREIGN KEY (ID_ESTACION)	REFERENCES ESTACION(ID_ESTACION);
ALTER TABLE CODIGO_SERVICIO ADD FOREIGN KEY (TIPO_CODIGO_SERVICIO)	REFERENCES PARAMETROS(ID_PARAMETRO);
ALTER TABLE CONTACTO_PROVEEDOR_ESTACION ADD FOREIGN KEY (EMAIL_USUARIO)	REFERENCES USUARIO(EMAIL_USUARIO);
ALTER TABLE CONTACTO_PROVEEDOR_ESTACION ADD FOREIGN KEY (ID_PROVEEDOR)	REFERENCES PROVEEDOR(ID_PROVEEDOR);
ALTER TABLE CONTACTO_PROVEEDOR_ESTACION ADD FOREIGN KEY (ID_ESTACION)	REFERENCES ESTACION(ID_ESTACION);
ALTER TABLE MATRIZ_DETALLE ADD FOREIGN KEY (ID_MATRIZ)	REFERENCES MATRIZ(ID_MATRIZ);
ALTER TABLE MATRIZ_DETALLE ADD FOREIGN KEY (ID_KIT_MASTER)	REFERENCES KIT_MASTER(ID_KIT_MASTER);
ALTER TABLE MATRIZ_DETALLE ADD FOREIGN KEY (NUMERO_PARTE)	REFERENCES MATERIAL(NUMERO_PARTE);
ALTER TABLE VUELO ADD FOREIGN KEY (TIPO_VUELO)	REFERENCES PARAMETROS(ID_PARAMETRO);
ALTER TABLE VUELO ADD FOREIGN KEY (ID_ESTACION_ORIGEN)	REFERENCES ESTACION(ID_ESTACION);
ALTER TABLE VUELO ADD FOREIGN KEY (ID_ESTACION_DESTINO)	REFERENCES ESTACION(ID_ESTACION);
ALTER TABLE VUELO ADD FOREIGN KEY (TIPO_CABINA)	REFERENCES PARAMETROS(ID_PARAMETRO);
ALTER TABLE VUELO ADD FOREIGN KEY (ID_COMPANIA)	REFERENCES COMPANIA(ID_COMPANIA);
ALTER TABLE VUELO ADD FOREIGN KEY (ID_CLASE)	REFERENCES CLASE(ID_CLASE);
ALTER TABLE HORARIO ADD FOREIGN KEY (ID_REGION)	REFERENCES REGION(ID_REGION);
ALTER TABLE AVION_AUDIFONO ADD FOREIGN KEY (ID_AVION)	REFERENCES AVION(ID_AVION);
ALTER TABLE AVION_AUDIFONO ADD FOREIGN KEY (ID_CLASE)	REFERENCES CLASE(ID_CLASE);
ALTER TABLE AVION_AUDIFONO ADD FOREIGN KEY (TIPO_AUDIFONO)	REFERENCES PARAMETROS(ID_PARAMETRO);
ALTER TABLE PERFIL_USUARIO ADD FOREIGN KEY (PERFIL)	REFERENCES PERFIL(PERFIL);
ALTER TABLE PERFIL_USUARIO ADD FOREIGN KEY (EMAIL_USUARIO)	REFERENCES USUARIO(EMAIL_USUARIO);
ALTER TABLE EQUIPAMIENTO_COMISARIATO ADD FOREIGN KEY (ID_AVION)	REFERENCES AVION(ID_AVION);
ALTER TABLE EQUIPAMIENTO_COMISARIATO ADD FOREIGN KEY (NUMERO_PARTE)	REFERENCES MATERIAL(NUMERO_PARTE);
ALTER TABLE AVION_CAPACIDAD ADD FOREIGN KEY (ID_AVION)	REFERENCES AVION(ID_AVION);
ALTER TABLE AVION_CAPACIDAD ADD FOREIGN KEY (ID_CLASE)	REFERENCES CLASE(ID_CLASE);
ALTER TABLE PROVEEDOR_ESTACION ADD FOREIGN KEY (ID_PROVEEDOR)	REFERENCES PROVEEDOR(ID_PROVEEDOR);
ALTER TABLE PROVEEDOR_ESTACION ADD FOREIGN KEY (ID_ESTACION)	REFERENCES ESTACION(ID_ESTACION);
ALTER TABLE AVION_SISTEMA_ENTRETENIMIENTO ADD FOREIGN KEY (ID_AVION)	REFERENCES AVION(ID_AVION);
ALTER TABLE AVION_SISTEMA_ENTRETENIMIENTO ADD FOREIGN KEY (ID_SISTEMA_ENTRETENIMIENTO)	REFERENCES SISTEMA_ENTRETENIMIENTO(ID_SISTEMA_ENTRETENIMIENTO);
ALTER TABLE MATERIAL_MASTER ADD FOREIGN KEY (ID_KIT_MASTER)	REFERENCES KIT_MASTER(ID_KIT_MASTER);
ALTER TABLE MATERIAL_MASTER ADD FOREIGN KEY (NUMERO_PARTE)	REFERENCES MATERIAL(NUMERO_PARTE);
ALTER TABLE MATERIAL_MASTER ADD FOREIGN KEY (ID_UNIDAD_MEDIDA)	REFERENCES PARAMETROS(ID_PARAMETRO);
ALTER TABLE ACOMODO ADD FOREIGN KEY (ID_ESTACION)	REFERENCES ESTACION(ID_ESTACION);
ALTER TABLE ACOMODO ADD FOREIGN KEY (ID_TIPO_EQUIPO_AVION)	REFERENCES TIPO_EQUIPO_AVION(ID_TIPO_EQUIPO_AVION);
ALTER TABLE ACOMODO ADD FOREIGN KEY (ID_PRODUCTO)	REFERENCES PRODUCTO(ID_PRODUCTO);
ALTER TABLE ACOMODO ADD FOREIGN KEY (ID_ACOMODO_DETALLE)	REFERENCES ACOMODO_DETALLE(ID_ACOMODO_DETALLE);
