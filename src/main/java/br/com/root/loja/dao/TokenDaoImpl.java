package br.com.root.loja.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import br.com.root.loja.model.PasswordResetToken;
import br.com.root.loja.model.State;

@Service("tokenDao")
public class TokenDaoImpl extends AbstractDao<Integer, PasswordResetToken> implements TokenDao {
	
	//#R00T - CLEAN TABLE
	/*public TokenDaoImpl(){
		Criteria crit = createEntityCriteria();
		Calendar cal = Calendar.getInstance();
		
		List<PasswordResetToken> tokens = crit.list()
		for (PasswordResetToken r : tokens) {
			if((r.getExpiryDate().getTime() - cal.getTime().getTime())  <= 0){
				delete(r);
			}
		}
	}*/

	@Override
	public void createToken(PasswordResetToken passr) {
		persist(passr);
	}

	@Override
	public PasswordResetToken findByToken(String token) {
		
		Criteria crit = createEntityCriteria();
		
		Criterion ctoken = Restrictions.eq("token",token);
		Criterion cativo = Restrictions.eq("active", State.ATIVO.getState());
		
		LogicalExpression orP = Restrictions.and(ctoken, cativo);
		
		crit.add(orP);
		return (PasswordResetToken) crit.uniqueResult();
	}

	@Override
	public void updateToken(PasswordResetToken passr) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("user", passr.getUser()));
		
		List<PasswordResetToken> tokens = crit.list();
		for (PasswordResetToken r : tokens) {
			r.setActive(State.INATIVO.getState());
			update(r);
		}
	}
}
