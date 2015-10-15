/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.ctrl;

import ec.gob.arcom.migracion.ctrl.base.BaseCtrl;
import ec.gob.arcom.migracion.dao.UsuarioDao;
import ec.gob.arcom.migracion.modelo.Usuario;
import ec.gob.arcom.migracion.servicio.RegionalServicio;
import ec.gob.arcom.migracionsadmin.utils.Crypt;
import ec.gob.arcom.migracionsadmin.utils.FacesUtil;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author coronelja
 */
@ManagedBean(name = "loginCtrl")
@SessionScoped
public class LoginCtrl extends BaseCtrl {

    @EJB
    private UsuarioDao usuarioDao;
    @EJB
    private RegionalServicio regionalServicio;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginCtrl() {
    }

    private String userName;
    private String userPassword;
    private boolean logged = false;
    private boolean admin = false;
    private String regional;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isLogged() {
        return logged;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String loginAction() {
        boolean result;

        if (userName == null || userName.isEmpty() || userPassword == null || userPassword.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "¡ERROR!", "Ingrese usuario y clave"));
            return null;
        }

        result = this.obtenerUsuario(userName, userPassword);
        if (result) {
            HttpSession session = FacesUtil.getSession();
            session.setAttribute("username", userName);
            session.setAttribute("logged", logged);
            session.setAttribute("admin", admin);
            session.setAttribute("regional", regional);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", userName));
            return "index.xhtml?faces-redirect=true";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "¡ERROR!", "Usuario o clave incorrectos"));
        return null;
    }

    public String logoutAction() {
        HttpSession session = FacesUtil.getSession();
        session.invalidate();
        return "login.xhtml?faces-redirect=true";
    }

    @SuppressWarnings("null")
    private boolean obtenerUsuario(String userName, String userPassword) {
        System.out.println("username: " + userName);
        System.out.println("userpwd: " + userPassword);
        Usuario usr = this.usuarioDao.obtenerPorLogin(userName);
        //System.out.println("usr: " + usr.getApellido() + " " + usr.getNombre());

        if (usr != null && usr.getCampoReservado05() != null) {
            if (usr.getCampoReservado05().equals(Crypt.cryptMD5(userPassword))) {
                this.logged = true;
                this.admin = true;
                this.regional = regionalServicio.findByCedulaRucUsuario(userName);
                //this.rgl= usr.;
                return true;
            }
        }
        return false;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

}
