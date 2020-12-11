package br.com.elton.jsm.chamados.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.elton.jsm.chamados.models.UsuarioModel;

@Named
@SessionScoped
public class AuxSession implements Serializable{

	private static final long serialVersionUID = 4275506505544572660L;
	
	private UsuarioModel usuario;

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void endSession() {
		this.usuario = null;
	}

	public boolean isLogado() {
		if (usuario == null)
			return false;
		return true;
	}
}
