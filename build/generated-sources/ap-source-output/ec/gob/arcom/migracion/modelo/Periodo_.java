package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import ec.gob.arcom.migracion.modelo.Informe;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(Periodo.class)
public class Periodo_ { 

    public static volatile SingularAttribute<Periodo, String> descripcionPeriodo;
    public static volatile SingularAttribute<Periodo, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<Periodo, String> campoReservado01;
    public static volatile SingularAttribute<Periodo, String> campoReservado02;
    public static volatile SingularAttribute<Periodo, String> campoReservado03;
    public static volatile SingularAttribute<Periodo, String> campoReservado04;
    public static volatile SingularAttribute<Periodo, String> campoReservado05;
    public static volatile SingularAttribute<Periodo, CatalogoDetalle> frecuenciaPeriodo;
    public static volatile SingularAttribute<Periodo, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<Periodo, Date> fechaFinPeriodo;
    public static volatile CollectionAttribute<Periodo, Informe> informeCollection;
    public static volatile SingularAttribute<Periodo, Date> fechaCreacion;
    public static volatile SingularAttribute<Periodo, Long> codigoPeriodo;
    public static volatile SingularAttribute<Periodo, Date> fechaInicioPeriodo;
    public static volatile SingularAttribute<Periodo, Date> fechaModificacion;
    public static volatile SingularAttribute<Periodo, CatalogoDetalle> estadoPeriodo;
    public static volatile SingularAttribute<Periodo, Boolean> estadoRegistro;

}