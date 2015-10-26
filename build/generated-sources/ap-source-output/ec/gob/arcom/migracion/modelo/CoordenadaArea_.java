package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.AreaMinera;
import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(CoordenadaArea.class)
public class CoordenadaArea_ { 

    public static volatile SingularAttribute<CoordenadaArea, Long> codigoCoordenada;
    public static volatile SingularAttribute<CoordenadaArea, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<CoordenadaArea, String> utmEste;
    public static volatile SingularAttribute<CoordenadaArea, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<CoordenadaArea, AreaMinera> codigoArea;
    public static volatile SingularAttribute<CoordenadaArea, CatalogoDetalle> sistemaReferencia;
    public static volatile SingularAttribute<CoordenadaArea, String> ejeX;
    public static volatile SingularAttribute<CoordenadaArea, String> ejeY;
    public static volatile SingularAttribute<CoordenadaArea, String> distancia;
    public static volatile SingularAttribute<CoordenadaArea, String> ejeZ;
    public static volatile SingularAttribute<CoordenadaArea, String> latitud;
    public static volatile SingularAttribute<CoordenadaArea, Boolean> migrada;
    public static volatile SingularAttribute<CoordenadaArea, Date> fechaCreacion;
    public static volatile SingularAttribute<CoordenadaArea, Boolean> inicial;
    public static volatile SingularAttribute<CoordenadaArea, String> utmNorte;
    public static volatile SingularAttribute<CoordenadaArea, String> longitud;
    public static volatile SingularAttribute<CoordenadaArea, Date> fechaModificacion;
    public static volatile SingularAttribute<CoordenadaArea, Boolean> estadoRegistro;
    public static volatile SingularAttribute<CoordenadaArea, BigInteger> numeroCoordenada;

}