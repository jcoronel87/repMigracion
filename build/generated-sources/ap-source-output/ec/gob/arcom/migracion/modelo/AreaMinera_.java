package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import ec.gob.arcom.migracion.modelo.ConcesionMinera;
import ec.gob.arcom.migracion.modelo.CoordenadaArea;
import ec.gob.arcom.migracion.modelo.Instrumento;
import ec.gob.arcom.migracion.modelo.Localidad;
import ec.gob.arcom.migracion.modelo.RegistroPagoObligaciones;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(AreaMinera.class)
public class AreaMinera_ { 

    public static volatile SingularAttribute<AreaMinera, BigDecimal> superficieAreaMinera;
    public static volatile SingularAttribute<AreaMinera, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<AreaMinera, Date> fechaInscribe;
    public static volatile SingularAttribute<AreaMinera, String> sectorReferencia;
    public static volatile ListAttribute<AreaMinera, CoordenadaArea> coordenadaAreaList;
    public static volatile ListAttribute<AreaMinera, RegistroPagoObligaciones> registroPagoObligacionesList;
    public static volatile ListAttribute<AreaMinera, Instrumento> instrumentoList;
    public static volatile SingularAttribute<AreaMinera, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<AreaMinera, Long> codigoAreaMinera;
    public static volatile SingularAttribute<AreaMinera, String> sistemaReferencia;
    public static volatile SingularAttribute<AreaMinera, String> nombreAreaMinera;
    public static volatile SingularAttribute<AreaMinera, ConcesionMinera> codigoConcesion;
    public static volatile SingularAttribute<AreaMinera, Date> fechaOtorga;
    public static volatile SingularAttribute<AreaMinera, Localidad> codigoLocalidad;
    public static volatile SingularAttribute<AreaMinera, Boolean> migrada;
    public static volatile SingularAttribute<AreaMinera, Date> fechaCreacion;
    public static volatile SingularAttribute<AreaMinera, String> nemonicoAreaMinera;
    public static volatile SingularAttribute<AreaMinera, Date> fechaModificacion;
    public static volatile SingularAttribute<AreaMinera, CatalogoDetalle> estadoArea;
    public static volatile SingularAttribute<AreaMinera, Boolean> estadoRegistro;

}