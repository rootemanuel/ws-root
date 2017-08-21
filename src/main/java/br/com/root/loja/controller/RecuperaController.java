package br.com.root.loja.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class RecuperaController {
	
final static Logger log = Logger.getLogger(RecuperaController.class);
	
	/*@Autowired
	TokenDao tokenModel;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailsService UserDetailsService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		 binder.addValidators(new UsuarioRecuperaValid());
	}
	
	@RequestMapping(value="/recupera", method=RequestMethod.GET)
	public String recupera(Model model){
		  model.addAttribute(new User());
		return "/recupera";
	}
	
	@RequestMapping(value="/recupera", method=RequestMethod.POST)
	public String recupera(@Valid User usr, BindingResult result, RedirectAttributes redirect){
		User recover;
		
		try {
			if(result.hasErrors())
				return "/recupera";
			
			String token = UUID.randomUUID().toString();
			recover = userService.findByCpf(usr.getCpf());
			if(recover == null) {
				result.addError(new ObjectError("errorne",Msgs.CPF_NAO_ENCONTRADO.getMsg()));
				return "/recupera";
			}
			
			//#R00T - Envia emails
			
			PasswordResetToken passr = new PasswordResetToken(token, recover);
			tokenModel.createToken(passr);
			
		} catch (Exception e) {
			result.addError(new ObjectError("error",Msgs.ERRO_APLICACAO.getMsg()));
			log.error(String.format("R00T-ERR0R - MESSAGE: %s", e.getMessage()));
			return "/recupera";
		}
		return "/recupera";
	}

	@RequestMapping(value="/recupera/novasenha/{token}", method=RequestMethod.GET)
	public String novaSenha(@PathVariable("token") String token){

		Calendar cal = Calendar.getInstance();
		PasswordResetToken recover;
		
		try {
			
			recover = tokenModel.findByToken(token);
			if((recover.getExpiryDate().getTime() - cal.getTime().getTime())  <= 0){
				return "redirect:/home"; 
			}
			
			Authentication auth = new UsernamePasswordAuthenticationToken(recover.getUser(), null, UserDetailsService.loadUserByUsername(recover.getUser().getEmail()).getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);
			
		} catch (Exception e) {
			log.error(String.format("R00T-ERR0R - MESSAGE: %s", e.getMessage()));
			return "redirect:/home";
		}
		return "/novasenha";
	}
	
	@RequestMapping(value="/recupera/novasenha/alterarsenha", method=RequestMethod.POST)
	public String novaSenha(@Valid User usr, BindingResult result){
	
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			String split[] = new String[2];
			split = usr.getSenha().split(",");
			if(!split[0].equals(split[1]))
				throw new NegocioException(Msgs.SENHA_DIFERENTE.getMsg());
			
			user.setSenha(split[0]);
			user.setDtalteracao(new Date());
			
			userService.resetPassword(user);
			tokenModel.updateToken(new PasswordResetToken(user));
			
		} catch (NegocioException ne) {
			result.addError(new ObjectError("errorne",ne.getMessage()));
			return "/novasenha";
		} catch (Exception e) {
			log.error(String.format("R00T-ERR0R - MESSAGE: %s", e.getMessage()));
			return "redirect:/home";
		}
		return "redirect:/home";
	}*/
}
