package br.com.root.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.root.loja.dao.UserDao;
import br.com.root.loja.model.User;
import br.com.root.loja.service.UserService;
import br.com.root.loja.utils.MsgErro;
import br.com.root.loja.utils.MsgRet;
import br.com.root.loja.utils.MsgSucesso;
import br.com.root.loja.utils.Utils;

@RestController
public class UsuarioController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ObjectMapper map;
	
	@Autowired
	UserDao modelUser;
	
	@Autowired
	UserDetailsService customUserDetailsService;
	
	@Autowired
    AuthenticationManager authenticationManager;
	
	@RequestMapping(value="/usuario/cadastro", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,headers=Utils.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<?> cadastrar(@ModelAttribute User usr) {
		
		try {
	
			if(!modelUser.findByEmailCpf(usr))
				return new ResponseEntity<MsgRet>(MsgErro.USUARIO_CADASTRADO.getMsg(), HttpStatus.OK);

			userService.addUser(usr);
			
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.OK);
		}
		return new ResponseEntity<MsgRet>(MsgSucesso.USUARIO_CADASTRADO_SUCESSO.getMsg(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/usuario/login", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,headers=Utils.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<?> login(@RequestBody User usr) {
		Authentication auth;
		try {
			
			auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usr.getEmail(),  usr.getSenha() , customUserDetailsService.loadUserByUsername(usr.getEmail()).getAuthorities()));
			
		} catch (BadCredentialsException bd) {
			return new ResponseEntity<MsgRet>(MsgErro.CADASTRO_NAO_ENCONTRADO.getMsg(), HttpStatus.OK);
		} catch (UsernameNotFoundException un) {
			return new ResponseEntity<MsgRet>(MsgErro.USUARIO_NAO_ENCONTRADO.getMsg(), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.OK);
		}
		return new ResponseEntity<User>(modelUser.findByEmail(usr.getEmail()), HttpStatus.OK);
	}
}
