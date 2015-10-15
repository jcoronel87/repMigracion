package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.ConcesionMinera;
import ec.gob.arcom.migracion.modelo.Informe;
import ec.gob.arcom.migracion.modelo.TipoMaquinaria;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-15T09:46:38")
@StaticMetamodel(MaquinariaConcesion.class)
public class MaquinariaConcesion_ { 

    public static volatile SingularAttribute<MaquinariaConcesion, String> descripcionMaquinaria;
    public static volatile SingularAttribute<MaquinariaConcesion, String> numeroChip;
    public static volatile SingularAttribute<MaquinariaConcesion, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<MaquinariaConcesion, BigDecimal> capacidadCarga;
    public static volatile SingularAttribute<MaquinariaConcesion, String> numeroSerie;
    public static volatile SingularAttribute<MaquinariaConcesion, Informe> codigoInforme;
    public static volatile SingularAttribute<MaquinariaConcesion, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<MaquinariaConcesion, Long> codigoMaquinaria;
    public static volatile SingularAttribute<MaquinariaConcesion, String> matricula;
    public static volatile SingularAttribute<MaquinariaConcesion, TipoMaquinaria> codigoTipoMaquinaria;
    public static volatile SingularAttribute<MaquinariaConcesion, ConcesionMinera> codigoConcesion;
    public static volatile SingularAttribute<MaquinariaConcesion, String> observacionMaquinaria;
    public static volatile SingularAttribute<MaquinariaConcesion, String> motor;
    public static volatile SingularAttribute<MaquinariaConcesion, String> marcaMaquinaria;
    public static volatile SingularAttribute<MaquinariaConcesion, String> placa;
    public static volatile SingularAttribute<MaquinariaConcesion, BigInteger> estadoMaquinaria;
    public static volatile SingularAttribute<MaquinariaConcesion, Date> fechaCreacion;
    public static volatile SingularAttribute<MaquinariaConcesion, Date> fechaModificacion;
    public static volatile SingularAttribute<MaquinariaConcesion, String> modelo;
    public static volatile SingularAttribute<MaquinariaConcesion, Boolean> estadoRegistro;

}