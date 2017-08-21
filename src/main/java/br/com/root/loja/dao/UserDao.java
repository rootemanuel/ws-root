package br.com.root.loja.dao;

import java.util.List;

import br.com.root.loja.model.User;

public interface UserDao {
	List<User> findAll();
	List<User> findEnd(String endereco);
	User findByCpf(String cpf);
	User findByEmail(String email);
	void resetPassword(User usr);
	boolean findByEmailCpf(User usr);
	void addUser(User usr);
}

