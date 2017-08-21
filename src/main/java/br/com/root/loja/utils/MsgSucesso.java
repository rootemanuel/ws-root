package br.com.root.loja.utils;

public enum MsgSucesso {
	
	SENHA_DIFERENTE(1,"Aviso","A confirmação da senha não confere"),
	USUARIO_CADASTRADO_SUCESSO(2,"Aviso","Usuário cadastro efetuado com sucesso"),
    USUARIO_SENHA_INVALIDO(3,"Aviso","Usuário ou senha inválido"),
    USUARIO_CADASTRADO(4,"Aviso","Você já possui cadastro, recupere sua senha"),
    CPF_NAO_ENCONTRADO(5,"Aviso","O CPF informado não foi encontrado"),
	ERRO_APLICACAO(6,"Aviso","Erro de aplicação, estamos trabalhando para resolver isso");

	private final int cod;
    private final String msg;
    private final String msgdet;
    
    private MsgSucesso(int cod,String msg,String msgdet) {
		this.cod = cod;
		this.msg = msg;
        this.msgdet = msgdet;
    }
    
	public MsgRet getMsg(){
		return new MsgRet(this.cod, 0, this.msg, this.msgdet);
	}

}
