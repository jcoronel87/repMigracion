package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.AreaMinera;
import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import ec.gob.arcom.migracion.modelo.ConcesionPlantaBeneficio;
import ec.gob.arcom.migracion.modelo.Fase;
import ec.gob.arcom.migracion.modelo.Instrumento;
import ec.gob.arcom.migracion.modelo.Localidad;
import ec.gob.arcom.migracion.modelo.MaquinariaConcesion;
import ec.gob.arcom.migracion.modelo.Regimen;
import ec.gob.arcom.migracion.modelo.Regional;
import ec.gob.arcom.migracion.modelo.RegistroPagoObligaciones;
import ec.gob.arcom.migracion.modelo.TipoMineria;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(ConcesionMinera.class)
public class ConcesionMinera_ { 

    public static volatile SingularAttribute<ConcesionMinera, String> sector;
    public static volatile SingularAttribute<ConcesionMinera, Double> numeroHectareasConcesion;
    public static volatile SingularAttribute<ConcesionMinera, BigInteger> codigoParroquia;
    public static volatile SingularAttribute<ConcesionMinera, String> materialInteres;
    public static volatile SingularAttribute<ConcesionMinera, String> campoReservado10;
    public static volatile SingularAttribute<ConcesionMinera, Regional> codigoRegional;
    public static volatile SingularAttribute<ConcesionMinera, CatalogoDetalle> estadoConcesion;
    public static volatile SingularAttribute<ConcesionMinera, String> codigoCensal;
    public static volatile SingularAttribute<ConcesionMinera, BigInteger> codigoProvincia;
    public static volatile SingularAttribute<ConcesionMinera, Fase> codigoFase;
    public static volatile SingularAttribute<ConcesionMinera, Date> fechaFinConcesion;
    public static volatile SingularAttribute<ConcesionMinera, Date> fechaCreacion;
    public static volatile SingularAttribute<ConcesionMinera, String> obsActosAdmPrevios;
    public static volatile SingularAttribute<ConcesionMinera, Boolean> senagua;
    public static volatile ListAttribute<ConcesionMinera, ConcesionPlantaBeneficio> concesionPlantaBeneficioList;
    public static volatile SingularAttribute<ConcesionMinera, String> tipoMaterial;
    public static volatile SingularAttribute<ConcesionMinera, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<ConcesionMinera, String> nombreConcesionarioPrincipal;
    public static volatile SingularAttribute<ConcesionMinera, String> modalidad;
    public static volatile SingularAttribute<ConcesionMinera, String> campoReservado01;
    public static volatile SingularAttribute<ConcesionMinera, String> campoReservado02;
    public static volatile SingularAttribute<ConcesionMinera, String> campoReservado03;
    public static volatile SingularAttribute<ConcesionMinera, String> campoReservado04;
    public static volatile SingularAttribute<ConcesionMinera, String> campoReservado05;
    public static volatile SingularAttribute<ConcesionMinera, String> campoReservado06;
    public static volatile ListAttribute<ConcesionMinera, RegistroPagoObligaciones> registroPagoObligacionesList;
    public static volatile SingularAttribute<ConcesionMinera, String> campoReservado07;
    public static volatile SingularAttribute<ConcesionMinera, String> campoReservado08;
    public static volatile ListAttribute<ConcesionMinera, Instrumento> instrumentoList;
    public static volatile SingularAttribute<ConcesionMinera, String> campoReservado09;
    public static volatile SingularAttribute<ConcesionMinera, String> documentoConcesionarioPrincipal;
    public static volatile SingularAttribute<ConcesionMinera, String> casilleroJudicial;
    public static volatile SingularAttribute<ConcesionMinera, BigInteger> plazoConcesion;
    public static volatile SingularAttribute<ConcesionMinera, Boolean> aceptaCondiciones;
    public static volatile SingularAttribute<ConcesionMinera, Boolean> estadoRegistro;
    public static volatile SingularAttribute<ConcesionMinera, BigInteger> codigoCanton;
    public static volatile ListAttribute<ConcesionMinera, AreaMinera> areaMineraList;
    public static volatile SingularAttribute<ConcesionMinera, String> nombreConcesion;
    public static volatile SingularAttribute<ConcesionMinera, Date> fechaInicioConcesion;
    public static volatile SingularAttribute<ConcesionMinera, Long> codigoConcesion;
    public static volatile SingularAttribute<ConcesionMinera, Boolean> mae;
    public static volatile SingularAttribute<ConcesionMinera, Date> fechaOtorga;
    public static volatile SingularAttribute<ConcesionMinera, Date> fechaInforme;
    public static volatile SingularAttribute<ConcesionMinera, Boolean> migrada;
    public static volatile SingularAttribute<ConcesionMinera, Double> volumenDiarioExplotacion;
    public static volatile SingularAttribute<ConcesionMinera, TipoMineria> codigoTipoMineria;
    public static volatile SingularAttribute<ConcesionMinera, Date> fechaModificacion;
    public static volatile SingularAttribute<ConcesionMinera, CatalogoDetalle> codigoFormaExplotacion;
    public static volatile SingularAttribute<ConcesionMinera, String> apellidoConcesionarioPrincipal;
    public static volatile SingularAttribute<ConcesionMinera, Localidad> codigoCasilleroLocalidad;
    public static volatile SingularAttribute<ConcesionMinera, Date> fechaInscribe;
    public static volatile SingularAttribute<ConcesionMinera, CatalogoDetalle> codigoModalidadTrabajo;
    public static volatile SingularAttribute<ConcesionMinera, String> codigoArcom;
    public static volatile SingularAttribute<ConcesionMinera, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<ConcesionMinera, CatalogoDetalle> codigoZona;
    public static volatile SingularAttribute<ConcesionMinera, String> formaExplotacion;
    public static volatile CollectionAttribute<ConcesionMinera, MaquinariaConcesion> maquinariaConcesionCollection;
    public static volatile SingularAttribute<ConcesionMinera, Regimen> codigoRegimen;
    public static volatile SingularAttribute<ConcesionMinera, Double> volumenTotalExplotacion;

}