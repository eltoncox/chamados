package br.com.elton.jsm.chamados.types;


/**
 * @author Elton.Luiz
 * @since 12/11/2019
 *
 */
public enum StUsuarioType {
	SELECIONE(0), ATIVO(1), INATIVO(2), BLOQUEADO(3);
	
	private final int value;
	
	StUsuarioType(int value){
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
