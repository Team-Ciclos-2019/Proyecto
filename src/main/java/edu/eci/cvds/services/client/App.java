package edu.eci.cvds.samples.services.client;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import javax.faces.bean.ManagedBean;

@Named
@Stateless
@ViewScoped
@ManagedBean(name="InicioBean",eager =true)
public class App implements Serializable{
        private static final Logger log = LoggerFactory.getLogger(App.class);
	private String correo;
	private String contrasena;
	
	public App(){
	}
	public String getCorreo(){
		return correo;
	}
	public String getContrasena(){
		return contrasena;
	}
	public void setCorreo(String correo){
		this.correo = correo;
	}
	public void setContrasena(String contrasena){
		this.contrasena = contrasena;
	}	
	
	public void iniciar(){
            Subject subject = SecurityUtils.getSubject();

            UsernamePasswordToken token = new UsernamePasswordToken(correo,contrasena);

            try {
                subject.login(token);
                FacesContext.getCurrentInstance().getExternalContext().redirect("inicio.xhtml");
                
            }
            catch (UnknownAccountException ex) {
               System.out.println(ex.getMessage());
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}