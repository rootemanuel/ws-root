package br.com.root.loja.service;

import br.com.root.loja.model.User;

public interface UserService {
	User findByCpf(String cpf);
	User findByEmail(String email);
	void resetPassword(User user);
	void addUser(User user);
}