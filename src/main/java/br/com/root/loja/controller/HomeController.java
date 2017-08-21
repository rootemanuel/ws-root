package br.com.root.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.root.loja.dao.UserDao;
import br.com.root.loja.model.User;

@RestController
public class HomeController {
	
	@Autowired
	UserDao modelUser;
	
	@RequestMapping(value="/", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> indexOf(){
		return new ResponseEntity<List<User>>(modelUser.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> index(){
		return new ResponseEntity<List<User>>(modelUser.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/home", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> indexPost(@RequestBody User usr){
		return new ResponseEntity<User>(modelUser.findByCpf(usr.getCpf()), HttpStatus.OK);
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> indexOfPost(@RequestBody User usr){
		return new ResponseEntity<User>(modelUser.findByCpf(usr.getCpf()), HttpStatus.OK);
	}
}
