package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(Catalogo.class)
public class Catalogo_ { 

    public static volatile SingularAttribute<Catalogo, String> nombre;
    public static volatile SingularAttribute<Catalogo, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<Catalogo, String> nemonico;
    public static volatile CollectionAttribute<Catalogo, CatalogoDetalle> catalogoDetalleCollection;
    public static volatile SingularAttribute<Catalogo, BigInteger> catalogoPadre;
    public static volatile SingularAttribute<Catalogo, String> descripcion;
    public static volatile SingularAttribute<Catalogo, Date> fechaCreacion;
    public static volatile SingularAttribute<Catalogo, Date> fechaModificacion;
    public static volatile SingularAttribute<Catalogo, Boolean> estadoRegistro;
    public static volatile SingularAttribute<Catalogo, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<Catalogo, Long> codigoCatalogo;

}