package br.com.root.loja.model;

public enum State {

	ATIVO(1,"Ativo"),
	INATIVO(2,"Inativo"),
	DELETADA(3,"Deletada"),
	BLOQUEADA(4,"Bloqueada");
	
	private int state;
	private String desc;
	
	State(int state, String desc){
		this.state = state;
		this.desc = desc;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
