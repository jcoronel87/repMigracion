package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.ConcesionMinera;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(Regimen.class)
public class Regimen_ { 

    public static volatile SingularAttribute<Regimen, String> nombre;
    public static volatile SingularAttribute<Regimen, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<Regimen, String> nemonico;
    public static volatile SingularAttribute<Regimen, Long> codigoRegimen;
    public static volatile SingularAttribute<Regimen, String> descripcion;
    public static volatile SingularAttribute<Regimen, Date> fechaCreacion;
    public static volatile ListAttribute<Regimen, ConcesionMinera> concesionMineraList;
    public static volatile SingularAttribute<Regimen, Date> fechaModificacion;
    public static volatile SingularAttribute<Regimen, Boolean> estadoRegistro;
    public static volatile SingularAttribute<Regimen, BigInteger> usuarioCreacion;

}