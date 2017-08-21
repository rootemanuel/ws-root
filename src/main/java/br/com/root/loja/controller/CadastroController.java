package br.com.root.loja.controller;

import org.apache.log4j.Logger;

/*@RestController*/
public class CadastroController {
	
	final static Logger log = Logger.getLogger(CadastroController.class);
	
	/*@Autowired
	UserService userService;
	
	@Autowired
	ObjectMapper map;
	
	@Autowired
	UserDao modelUser;
	
	@RequestMapping(value="/usuario/cadastro", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> cadastrar(@RequestBody User usr) throws JsonProcessingException {
		
		try {
	
			if(!modelUser.findByEmailCpf(usr))
				throw new NegocioException(MsgErro.USUARIO_CADASTRADO.getCod(),MsgErro.USUARIO_CADASTRADO.getMsg(),MsgErro.USUARIO_CADASTRADO.getMsgdet());
			
			userService.addUser(usr);
			
		} catch (NegocioException ne) {
			return new ResponseEntity<String>(map.writeValueAsString(ne), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(map.writeValueAsString(e), HttpStatus.OK);
		}
		return new ResponseEntity<String>("saaaaa" , HttpStatus.OK);
	}*/
}
