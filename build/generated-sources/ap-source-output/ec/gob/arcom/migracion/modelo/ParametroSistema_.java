package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import ec.gob.arcom.migracion.modelo.RegistroPagoObligaciones;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(ParametroSistema.class)
public class ParametroSistema_ { 

    public static volatile SingularAttribute<ParametroSistema, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<ParametroSistema, CatalogoDetalle> tipoParametro;
    public static volatile SingularAttribute<ParametroSistema, String> valorParametro;
    public static volatile ListAttribute<ParametroSistema, RegistroPagoObligaciones> registroPagoObligacionesList;
    public static volatile SingularAttribute<ParametroSistema, String> descripcionParametro;
    public static volatile SingularAttribute<ParametroSistema, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<ParametroSistema, String> nombreParametro;
    public static volatile SingularAttribute<ParametroSistema, CatalogoDetalle> tipoDato;
    public static volatile SingularAttribute<ParametroSistema, String> nemonicoParametro;
    public static volatile SingularAttribute<ParametroSistema, Date> fechaCreacion;
    public static volatile SingularAttribute<ParametroSistema, Date> fechaModificacion;
    public static volatile SingularAttribute<ParametroSistema, Long> codigoParametro;
    public static volatile SingularAttribute<ParametroSistema, Boolean> estadoRegistro;

}