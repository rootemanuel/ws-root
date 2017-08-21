package br.com.root.loja.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.root.loja.model.User;
import br.com.root.loja.model.UserProfile;
import br.com.root.loja.model.UserProfileType;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
	
	public void addUser(User usr){
		Set<UserProfile> lstUp = new HashSet<UserProfile>();
		UserProfile up = new UserProfile();
		
		up.setType(UserProfileType.USER.getUserProfileType());
		
		lstUp.add(up);
		
		usr.setDtcriacao(new Date());
		usr.setUserProfiles(lstUp);
		
		persist(usr);
	}

	public boolean findByEmailCpf(User usr) {
		Criteria crit = createEntityCriteria();
		
		Criterion email = Restrictions.eq("email", usr.getEmail());
		Criterion cpf = Restrictions.eq("cpf", usr.getCpf());
		
		LogicalExpression orP = Restrictions.or(email, cpf);
		
		crit.add(orP);
		
		List users = crit.list();
	        
	        if(users.isEmpty())
	        	return true;
	        
	        return false;
	}

	public User findByEmail(String email) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("email", email));
		return (User) crit.uniqueResult();
	}
	
	public User findByCpf(String cpf) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("cpf", cpf));
		return (User) crit.uniqueResult();
	}
	
	public void resetPassword(User usr) {
		update(usr);
	}

	@Override
	public List<User> findAll() {
		Criteria crit = createEntityCriteria();
		
		return crit.list();
	}

	@Override
	public List<User> findEnd(String endereco) {
		Criteria crit = createEntityCriteria();
		
		Criterion end = Restrictions.like("endereco", endereco, MatchMode.ANYWHERE);

		crit.add(end);
		
		return crit.list();
	}
}
