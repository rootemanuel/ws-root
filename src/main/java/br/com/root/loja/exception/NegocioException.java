package br.com.root.loja.exception;

public class NegocioException extends Exception {

	private static final long serialVersionUID = 5125469090715122453L;
	
	private int cod;
	private String msg;
	private String msgdet;
	
	public NegocioException(int cod, String msg, String msgdet ){
		this.cod = cod;
		this.msg = msg;
		this.msgdet = msgdet;
	}

	public NegocioException(String msg){
		super(msg);
	}
	
	public NegocioException(String msg, Throwable cause){
		super(msg, cause);
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
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
