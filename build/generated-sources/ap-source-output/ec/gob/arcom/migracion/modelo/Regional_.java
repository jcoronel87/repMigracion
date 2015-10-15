package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.ConcesionMinera;
import ec.gob.arcom.migracion.modelo.LocalidadRegional;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-15T09:46:38")
@StaticMetamodel(Regional.class)
public class Regional_ { 

    public static volatile SingularAttribute<Regional, String> direccionRegional;
    public static volatile SingularAttribute<Regional, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<Regional, String> prefijoCodigo;
    public static volatile CollectionAttribute<Regional, LocalidadRegional> localidadRegionalCollection;
    public static volatile SingularAttribute<Regional, String> nemonicoRegional;
    public static volatile SingularAttribute<Regional, Long> codigoRegional;
    public static volatile SingularAttribute<Regional, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<Regional, String> descripcionRegional;
    public static volatile SingularAttribute<Regional, BigInteger> zonaArcom;
    public static volatile SingularAttribute<Regional, String> realm;
    public static volatile SingularAttribute<Regional, String> ciudadRegional;
    public static volatile SingularAttribute<Regional, Date> fechaCreacion;
    public static volatile ListAttribute<Regional, ConcesionMinera> concesionMineraList;
    public static volatile SingularAttribute<Regional, Date> fechaModificacion;
    public static volatile SingularAttribute<Regional, String> nombreRegional;
    public static volatile SingularAttribute<Regional, Boolean> estadoRegistro;

}