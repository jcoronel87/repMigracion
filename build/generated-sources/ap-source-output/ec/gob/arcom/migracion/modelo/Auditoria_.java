package ec.gob.arcom.migracion.modelo;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(Auditoria.class)
public class Auditoria_ { 

    public static volatile SingularAttribute<Auditoria, String> detalleAnterior;
    public static volatile SingularAttribute<Auditoria, Long> codigoAuditoria;
    public static volatile SingularAttribute<Auditoria, Date> fecha;
    public static volatile SingularAttribute<Auditoria, String> detalleCambios;
    public static volatile SingularAttribute<Auditoria, BigInteger> usuario;
    public static volatile SingularAttribute<Auditoria, String> accion;

}