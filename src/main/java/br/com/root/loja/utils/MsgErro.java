package br.com.root.loja.utils;

public enum MsgErro {

	USUARIO_CADASTRADO(1,"Aviso","Já existe um cadastro ativo"),
	CADASTRO_NAO_ENCONTRADO(2,"Aviso","Usuário ou senha inválidos"),
	USUARIO_NAO_ENCONTRADO(2,"Aviso","Usuário não encontrado");
	
	private final int cod;
    private final String msg;
    private final String msgdet;
    
    private MsgErro(int cod,String msg,String msgdet) {
		this.cod = cod;
		this.msg = msg;
        this.msgdet = msgdet;
    }
	
	public MsgRet getMsg(){
		return new MsgRet(this.cod, 1, this.msg, this.msgdet);
	}
	
}
