package br.com.root.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.root.loja.dao.UserDao;
import br.com.root.loja.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void addUser(User usr){
		usr.setSenha(passwordEncoder.encode(usr.getSenha()));
		dao.addUser(usr);
	}

	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}
	
	public User findByCpf(String email) {
		return dao.findByCpf(email);
	}
	
	public void resetPassword(User usr) {
		usr.setSenha(passwordEncoder.encode(usr.getSenha()));
		dao.resetPassword(usr);
	}
}
