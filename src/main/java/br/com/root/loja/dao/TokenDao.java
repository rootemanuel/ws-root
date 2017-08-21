package br.com.root.loja.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.root.loja.model.PasswordResetToken;

@Repository("tokenDao")
@Transactional
public interface TokenDao {
	void createToken(PasswordResetToken passr);
	void updateToken(PasswordResetToken passr);
	PasswordResetToken findByToken(String token);
}
