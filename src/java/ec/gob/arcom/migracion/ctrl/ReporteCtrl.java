/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.ctrl;

import ec.gob.arcom.migracion.constantes.ConstantesEnum;
import ec.gob.arcom.migracion.ctrl.base.BaseCtrl;
import ec.gob.arcom.migracion.servicio.RecursoServicio;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

/**
 *
 * @author CoronelJa
 */
@ManagedBean
@ViewScoped
public class ReporteCtrl extends BaseCtrl {

    @EJB
    private RecursoServicio recursoServicio;

    @ManagedProperty(value = "#{loginCtrl}")
    private LoginCtrl login;

    private JasperPrint jasperPrint;
    private Long codigoTipoMineria;
    private List<SelectItem> tipoSolicitudesPrincipales;
    private List<SelectItem> tipoSolicitudesDeConcesionMinera;
    private Long codigoSubtipoMineria;
    private boolean concesionMinera;
    private List<SelectItem> tipoSolicitudes;

    public void generarReporteConcesionMineraXls() {
        System.out.println("entra generarReporteConcesionMineraXls");
        String nombreReporte = null;
        if (codigoTipoMineria.equals(ConstantesEnum.TIPO_SOLICITUD_CONS_MIN.getCodigo())) {
            nombreReporte = "Concesiones_Mineras.xlsx";
            //codigoTipoMineria = Long.valueOf("11L");
        } else if (codigoTipoMineria.equals(ConstantesEnum.TIPO_SOLICITUD_LIB_APR.getCodigo())) {
            nombreReporte = "Libres_Aprovechamientos.xlsx";
        } else if (codigoTipoMineria.equals(ConstantesEnum.TIPO_SOLICITUD_MIN_ART.getCodigo())) {
            nombreReporte = "Mineria_Artesanal.xlsx";
        }
        System.out.println("codigoTipoMineria: " + codigoTipoMineria);
        try {
            String pathReporte = "/reportes/concesionMinera2.jasper";
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(pathReporte);
            System.out.println("recursoServicio: " + recursoServicio);
            System.out.println("reportPath: " + reportPath);
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("usuario", login.getUserName());
            parameters.put("codigoTipoMineria", codigoTipoMineria);
            jasperPrint = JasperFillManager.fillReport(reportPath, parameters, recursoServicio.obtenerConnection());
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + nombreReporte);
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            JRXlsxExporter docxExporter = new JRXlsxExporter();
            docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
            docxExporter.exportReport();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (SQLException | JRException | IOException sqlEx) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error al generar el reporte", sqlEx.getMessage()));
        }
    }

    public void generarReporteLicenciaComercializacion() {
        String nombreReporte = "Licencia_Comercializacion.xlsx";
        try {
            String pathReporte = "/reportes/licenciaComercializacion.jasper";
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(pathReporte);
            System.out.println("recursoServicio: " + recursoServicio);
            System.out.println("reportPath: " + reportPath);
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("usuario", login.getUserName());
            jasperPrint = JasperFillManager.fillReport(reportPath, parameters, recursoServicio.obtenerConnection());
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + nombreReporte);
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            JRXlsxExporter docxExporter = new JRXlsxExporter();
            docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
            docxExporter.exportReport();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (SQLException | JRException | IOException sqlEx) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error al generar el reporte", sqlEx.getMessage()));
        }
    }

    public void generarReportePlantaBeneficio() {
        String nombreReporte = "Planta_Beneficio.xlsx";
        try {
            String pathReporte = "/reportes/plantaBeneficio.jasper";
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(pathReporte);
            System.out.println("recursoServicio: " + recursoServicio);
            System.out.println("reportPath: " + reportPath);
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("usuario", login.getUserName());
            jasperPrint = JasperFillManager.fillReport(reportPath, parameters, recursoServicio.obtenerConnection());
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + nombreReporte);
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            JRXlsxExporter docxExporter = new JRXlsxExporter();
            docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
            docxExporter.exportReport();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (SQLException | JRException | IOException sqlEx) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error al generar el reporte", sqlEx.getMessage()));
        }
    }

    public LoginCtrl getLogin() {
        return login;
    }

    public void setLogin(LoginCtrl login) {
        this.login = login;
    }

    public Long getCodigoTipoMineria() {
        return codigoTipoMineria;
    }

    public void setCodigoTipoMineria(Long codigoTipoMineria) {
        this.codigoTipoMineria = codigoTipoMineria;
    }

    public List<SelectItem> getTipoSolicitudesPrincipales() {
        if (tipoSolicitudesPrincipales == null) {
            tipoSolicitudesPrincipales = new ArrayList<>();
            for (ConstantesEnum ce : ConstantesEnum.tipoSolicitudesPrincipales()) {
                tipoSolicitudesPrincipales.add(new SelectItem(ce.getCodigo(), ce.getDescripcion()));
            }
        }
        return tipoSolicitudesPrincipales;
    }

    public void setTipoSolicitudesPrincipales(List<SelectItem> tipoSolicitudesPrincipales) {
        this.tipoSolicitudesPrincipales = tipoSolicitudesPrincipales;
    }

    public List<SelectItem> getTipoSolicitudesDeConcesionMinera() {
        if (tipoSolicitudesDeConcesionMinera == null) {
            tipoSolicitudesDeConcesionMinera = new ArrayList<>();
            for (ConstantesEnum ce : ConstantesEnum.tipoSolicitudesDeConcesionMinera()) {
                tipoSolicitudesDeConcesionMinera.add(new SelectItem(ce.getCodigo(), ce.getDescripcion()));
            }
        }
        return tipoSolicitudesDeConcesionMinera;
    }

    public void setTipoSolicitudesDeConcesionMinera(List<SelectItem> tipoSolicitudesDeConcesionMinera) {
        this.tipoSolicitudesDeConcesionMinera = tipoSolicitudesDeConcesionMinera;
    }

    public Long getCodigoSubtipoMineria() {
        return codigoSubtipoMineria;
    }

    public void setCodigoSubtipoMineria(Long codigoSubtipoMineria) {
        this.codigoSubtipoMineria = codigoSubtipoMineria;
    }

    public boolean isConcesionMinera() {
        return concesionMinera;
    }

    public void setConcesionMinera(boolean concesionMinera) {
        this.concesionMinera = concesionMinera;
    }

    public void generarReporte() {
        if (codigoTipoMineria.equals(ConstantesEnum.TIPO_SOLICITUD_CONS_MIN.getCodigo())
                || codigoTipoMineria.equals(ConstantesEnum.TIPO_SOLICITUD_LIB_APR.getCodigo())
                || codigoTipoMineria.equals(ConstantesEnum.TIPO_SOLICITUD_MIN_ART.getCodigo())) {
            generarReporteConcesionMineraXls();
        } else if (codigoTipoMineria.equals(ConstantesEnum.TIPO_SOLICITUD_LIC_COM.getCodigo())) {
            generarReporteLicenciaComercializacion();
        } else if (codigoTipoMineria.equals(ConstantesEnum.TIPO_SOLICITUD_PLAN_BEN.getCodigo())) {
            generarReportePlantaBeneficio();
        }
    }

    public void habilitarSubTipoReporte() {
        if (codigoTipoMineria.equals(ConstantesEnum.TIPO_SOLICITUD_CONS_MIN.getCodigo())
                || codigoTipoMineria.equals(ConstantesEnum.TIPO_SOLICITUD_LIB_APR.getCodigo())
                || codigoTipoMineria.equals(ConstantesEnum.TIPO_SOLICITUD_MIN_ART.getCodigo())) {
            concesionMinera = true;
        } else {
            concesionMinera = false;
        }
    }

    public List<SelectItem> getTipoSolicitudes() {
        if (tipoSolicitudes == null) {
            tipoSolicitudes = new ArrayList<>();
            for (ConstantesEnum ce : ConstantesEnum.tipoSolicitudes()) {
                tipoSolicitudes.add(new SelectItem(ce.getCodigo(), ce.getDescripcion()));
            }
        }
        return tipoSolicitudes;
    }

    public void setTipoSolicitudes(List<SelectItem> tipoSolicitudes) {
        this.tipoSolicitudes = tipoSolicitudes;
    }

}
