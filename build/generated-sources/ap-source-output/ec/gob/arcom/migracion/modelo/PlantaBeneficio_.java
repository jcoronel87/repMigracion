package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import ec.gob.arcom.migracion.modelo.ConcesionPlantaBeneficio;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(PlantaBeneficio.class)
public class PlantaBeneficio_ { 

    public static volatile SingularAttribute<PlantaBeneficio, String> apellidoRepresentanteLegal;
    public static volatile SingularAttribute<PlantaBeneficio, BigDecimal> recuperacion;
    public static volatile SingularAttribute<PlantaBeneficio, BigDecimal> capacidadInstalada;
    public static volatile SingularAttribute<PlantaBeneficio, String> campoReservado10;
    public static volatile SingularAttribute<PlantaBeneficio, BigDecimal> tonelajeColas;
    public static volatile SingularAttribute<PlantaBeneficio, BigDecimal> tonelajeTratamiento;
    public static volatile SingularAttribute<PlantaBeneficio, String> tipoPlanta;
    public static volatile SingularAttribute<PlantaBeneficio, BigInteger> codigoProvincia;
    public static volatile SingularAttribute<PlantaBeneficio, BigDecimal> tonelajeConcentrado;
    public static volatile SingularAttribute<PlantaBeneficio, Date> fechaCreacion;
    public static volatile SingularAttribute<PlantaBeneficio, String> direccionPlanta;
    public static volatile SingularAttribute<PlantaBeneficio, Boolean> senagua;
    public static volatile SingularAttribute<PlantaBeneficio, BigDecimal> longitudRelavera;
    public static volatile ListAttribute<PlantaBeneficio, ConcesionPlantaBeneficio> concesionPlantaBeneficioList;
    public static volatile SingularAttribute<PlantaBeneficio, BigInteger> codigoParroquida;
    public static volatile SingularAttribute<PlantaBeneficio, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<PlantaBeneficio, String> relavera;
    public static volatile SingularAttribute<PlantaBeneficio, String> campoReservado01;
    public static volatile SingularAttribute<PlantaBeneficio, String> campoReservado02;
    public static volatile SingularAttribute<PlantaBeneficio, String> campoReservado03;
    public static volatile SingularAttribute<PlantaBeneficio, String> campoReservado04;
    public static volatile SingularAttribute<PlantaBeneficio, String> campoReservado05;
    public static volatile SingularAttribute<PlantaBeneficio, String> campoReservado06;
    public static volatile SingularAttribute<PlantaBeneficio, String> campoReservado07;
    public static volatile SingularAttribute<PlantaBeneficio, BigDecimal> pesoProductoFinal;
    public static volatile SingularAttribute<PlantaBeneficio, String> campoReservado08;
    public static volatile SingularAttribute<PlantaBeneficio, String> campoReservado09;
    public static volatile SingularAttribute<PlantaBeneficio, String> telefonoPlanta;
    public static volatile SingularAttribute<PlantaBeneficio, String> nombrePlantaBeneficio;
    public static volatile SingularAttribute<PlantaBeneficio, BigDecimal> anchoRelavera;
    public static volatile SingularAttribute<PlantaBeneficio, String> casilleroJudicial;
    public static volatile SingularAttribute<PlantaBeneficio, Boolean> estadoRegistro;
    public static volatile SingularAttribute<PlantaBeneficio, BigInteger> codigoCanton;
    public static volatile SingularAttribute<PlantaBeneficio, String> leyCabeza;
    public static volatile SingularAttribute<PlantaBeneficio, Long> codigoPlantaBeneficio;
    public static volatile SingularAttribute<PlantaBeneficio, String> tipoProductoFinal;
    public static volatile SingularAttribute<PlantaBeneficio, Boolean> mae;
    public static volatile SingularAttribute<PlantaBeneficio, Date> fechaOtorga;
    public static volatile SingularAttribute<PlantaBeneficio, Boolean> migrada;
    public static volatile SingularAttribute<PlantaBeneficio, String> leyConcentrado;
    public static volatile SingularAttribute<PlantaBeneficio, Date> fechaModificacion;
    public static volatile SingularAttribute<PlantaBeneficio, CatalogoDetalle> unidadPeso;
    public static volatile SingularAttribute<PlantaBeneficio, String> numeroDocumentoRepresentanteLegal;
    public static volatile SingularAttribute<PlantaBeneficio, String> nombreRepresentanteLegal;
    public static volatile SingularAttribute<PlantaBeneficio, BigDecimal> capacidadOperativa;
    public static volatile SingularAttribute<PlantaBeneficio, String> materialAExplotar;
    public static volatile SingularAttribute<PlantaBeneficio, CatalogoDetalle> codigoProcedenciaMaterial;
    public static volatile SingularAttribute<PlantaBeneficio, String> tipoPersona;
    public static volatile SingularAttribute<PlantaBeneficio, BigDecimal> volumenAExplotar;
    public static volatile SingularAttribute<PlantaBeneficio, Date> fechaInscribe;
    public static volatile SingularAttribute<PlantaBeneficio, BigInteger> plazo;
    public static volatile SingularAttribute<PlantaBeneficio, String> codigoArcom;
    public static volatile SingularAttribute<PlantaBeneficio, CatalogoDetalle> categoriaPlanta;
    public static volatile SingularAttribute<PlantaBeneficio, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<PlantaBeneficio, String> correoElectronico;
    public static volatile SingularAttribute<PlantaBeneficio, String> obsActoAdministrativo;
    public static volatile SingularAttribute<PlantaBeneficio, String> balanceMetalurgico;
    public static volatile SingularAttribute<PlantaBeneficio, String> zona;
    public static volatile SingularAttribute<PlantaBeneficio, CatalogoDetalle> estadoPlanta;

}