package pe.com.whnm.holamundojsf.managebean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import pe.com.whnm.holamundojsf.bean.Persona;

@ManagedBean
@RequestScoped
public class PersonaBean {
	
	private Persona persona = new Persona();
	private static List<Persona> lstPersonas = new ArrayList<Persona>();
	
	
	public PersonaBean() {
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getLstPersonas() {
		return PersonaBean.lstPersonas;
	}

	public void setLstPersonas(List<Persona> lstPersonas) {
		PersonaBean.lstPersonas = lstPersonas;
	}
	
	public void registrar() {
		PersonaBean.lstPersonas.add(persona);
	}
	
	public void eliminarPersona(Persona per) {
		PersonaBean.lstPersonas.remove(per);
	}
	
	public void validar(FacesContext context, UIComponent componente, Object value) {
		
		context = FacesContext.getCurrentInstance();
		
		String texto = (String) value;
		
		if(!texto.equalsIgnoreCase("M") && !texto.equalsIgnoreCase("F")) {
			((UIInput) componente).setValid(false);
			context.addMessage(componente.getClientId(context), new FacesMessage("SEXO no Permitido"));
		}
		
	}
}
