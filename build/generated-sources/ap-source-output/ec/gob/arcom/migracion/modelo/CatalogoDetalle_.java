package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.AreaMinera;
import ec.gob.arcom.migracion.modelo.Catalogo;
import ec.gob.arcom.migracion.modelo.ConcesionMinera;
import ec.gob.arcom.migracion.modelo.CoordenadaArea;
import ec.gob.arcom.migracion.modelo.Informe;
import ec.gob.arcom.migracion.modelo.Instrumento;
import ec.gob.arcom.migracion.modelo.LicenciaComercializacion;
import ec.gob.arcom.migracion.modelo.Localidad;
import ec.gob.arcom.migracion.modelo.ParametroSistema;
import ec.gob.arcom.migracion.modelo.Periodo;
import ec.gob.arcom.migracion.modelo.PersonaJuridica;
import ec.gob.arcom.migracion.modelo.PersonaNatural;
import ec.gob.arcom.migracion.modelo.PlantaBeneficio;
import ec.gob.arcom.migracion.modelo.RegistroPagoObligaciones;
import ec.gob.arcom.migracion.modelo.SujetoMinero;
import ec.gob.arcom.migracion.modelo.TipoMaquinaria;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-15T09:46:38")
@StaticMetamodel(CatalogoDetalle.class)
public class CatalogoDetalle_ { 

    public static volatile CollectionAttribute<CatalogoDetalle, PlantaBeneficio> plantaBeneficioCollection2;
    public static volatile CollectionAttribute<CatalogoDetalle, TipoMaquinaria> tipoMaquinariaCollection2;
    public static volatile CollectionAttribute<CatalogoDetalle, TipoMaquinaria> tipoMaquinariaCollection1;
    public static volatile CollectionAttribute<CatalogoDetalle, PlantaBeneficio> plantaBeneficioCollection1;
    public static volatile CollectionAttribute<CatalogoDetalle, PlantaBeneficio> plantaBeneficioCollection;
    public static volatile ListAttribute<CatalogoDetalle, SujetoMinero> sujetoMineroList;
    public static volatile ListAttribute<CatalogoDetalle, SujetoMinero> sujetoMineroList1;
    public static volatile ListAttribute<CatalogoDetalle, CoordenadaArea> coordenadaAreaList;
    public static volatile SingularAttribute<CatalogoDetalle, String> nombre;
    public static volatile CollectionAttribute<CatalogoDetalle, LicenciaComercializacion> licenciaComercializacionCollection;
    public static volatile SingularAttribute<CatalogoDetalle, Date> fechaCreacion;
    public static volatile SingularAttribute<CatalogoDetalle, Date> fechaModificacion;
    public static volatile ListAttribute<CatalogoDetalle, ConcesionMinera> concesionMineraList2;
    public static volatile ListAttribute<CatalogoDetalle, ConcesionMinera> concesionMineraList1;
    public static volatile SingularAttribute<CatalogoDetalle, Catalogo> codigoCatalogo;
    public static volatile ListAttribute<CatalogoDetalle, ConcesionMinera> concesionMineraList3;
    public static volatile CollectionAttribute<CatalogoDetalle, LicenciaComercializacion> licenciaComercializacionCollection1;
    public static volatile ListAttribute<CatalogoDetalle, PersonaNatural> personaNaturalList;
    public static volatile CollectionAttribute<CatalogoDetalle, Periodo> periodoCollection;
    public static volatile SingularAttribute<CatalogoDetalle, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<CatalogoDetalle, String> descripcion;
    public static volatile CollectionAttribute<CatalogoDetalle, Periodo> periodoCollection1;
    public static volatile SingularAttribute<CatalogoDetalle, Long> codigoCatalogoDetalle;
    public static volatile ListAttribute<CatalogoDetalle, RegistroPagoObligaciones> registroPagoObligacionesList;
    public static volatile ListAttribute<CatalogoDetalle, PersonaJuridica> personaJuridicaList;
    public static volatile ListAttribute<CatalogoDetalle, Instrumento> instrumentoList;
    public static volatile SingularAttribute<CatalogoDetalle, BigInteger> usuarioCreacion;
    public static volatile ListAttribute<CatalogoDetalle, ParametroSistema> parametroSistemaList1;
    public static volatile CollectionAttribute<CatalogoDetalle, Informe> informeCollection;
    public static volatile SingularAttribute<CatalogoDetalle, String> valor;
    public static volatile SingularAttribute<CatalogoDetalle, String> nemonico;
    public static volatile CollectionAttribute<CatalogoDetalle, TipoMaquinaria> tipoMaquinariaCollection;
    public static volatile ListAttribute<CatalogoDetalle, ParametroSistema> parametroSistemaList;
    public static volatile ListAttribute<CatalogoDetalle, ConcesionMinera> concesionMineraList;
    public static volatile ListAttribute<CatalogoDetalle, RegistroPagoObligaciones> registroPagoObligacionesList2;
    public static volatile ListAttribute<CatalogoDetalle, RegistroPagoObligaciones> registroPagoObligacionesList1;
    public static volatile ListAttribute<CatalogoDetalle, Instrumento> instrumentoList2;
    public static volatile ListAttribute<CatalogoDetalle, Instrumento> instrumentoList1;
    public static volatile ListAttribute<CatalogoDetalle, RegistroPagoObligaciones> registroPagoObligacionesList3;
    public static volatile CollectionAttribute<CatalogoDetalle, Localidad> localidadCollection;
    public static volatile SingularAttribute<CatalogoDetalle, Boolean> estadoRegistro;
    public static volatile ListAttribute<CatalogoDetalle, AreaMinera> areaMineraList;

}