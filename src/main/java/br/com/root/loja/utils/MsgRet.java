package br.com.root.loja.utils;

public class MsgRet {

	private int cod;
	private int erro;	//NERRO = 0, ERRO = 1
	private String msg;
	private String msgdet;
	
	public MsgRet(int cod,int erro, String msg, String msgdet ){
		this.cod = cod;
		this.erro = erro;
		this.msg = msg;
		this.msgdet = msgdet;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getErro() {
		return erro;
	}

	public void setErro(int erro) {
		this.erro = erro;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsgdet() {
		return msgdet;
	}

	public void setMsgdet(String msgdet) {
		this.msgdet = msgdet;
	}
	
}
