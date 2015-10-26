package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.Localidad;
import ec.gob.arcom.migracion.modelo.LocalidadRegionalPK;
import ec.gob.arcom.migracion.modelo.Regional;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(LocalidadRegional.class)
public class LocalidadRegional_ { 

    public static volatile SingularAttribute<LocalidadRegional, Localidad> localidad;
    public static volatile SingularAttribute<LocalidadRegional, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<LocalidadRegional, Regional> regional;
    public static volatile SingularAttribute<LocalidadRegional, LocalidadRegionalPK> localidadRegionalPK;
    public static volatile SingularAttribute<LocalidadRegional, Date> fechaCreacion;
    public static volatile SingularAttribute<LocalidadRegional, Date> fechaModificacion;
    public static volatile SingularAttribute<LocalidadRegional, Boolean> estadoRegistro;
    public static volatile SingularAttribute<LocalidadRegional, BigInteger> usuarioCreacion;

}