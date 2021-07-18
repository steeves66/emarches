package com.sndi.security;

//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TMotdepasse;
import com.sndi.model.TOperateur;
import com.sndi.service.Iservice;

@Transactional
//@Scope(value="session")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    Iservice iservice;
	@Autowired
	UserService userService;

    public UserDetails loadUserByUsername(String userName)
            {
    	System.out.println("User login: "+userName);
    	//String passcrip = "";
    	TOperateur domainUser = iservice.getUser(userName);
    	
    	if(domainUser==null){
    		System.out.println("Utilisateur introuvable ");
    		throw new UsernameNotFoundException(userName);
    	}else{
    	System.out.println("Login de connexion Opérateur : Login "+domainUser.getOpeLogin()+" Nom "+domainUser.getOpeNom());
    	userService.setTOperateur(domainUser);
    	userService.getListeAssignations(domainUser);
    	userService.getMotPasse(domainUser);
    	//userService.setPrivileges(domainUser);
    	userService.setDateCons(Calendar.getInstance().getTime());
    	//recuperer les menus de la base
//    	userService.setModules(iservice.getObjects("SysModule", new ArrayList<String>(Arrays.asList("symCode","symLibelle"))));
    	//userService.setMenus(iservice.getObjectsByColumn("SysTraitement", new ArrayList<String>(Arrays.asList("sytSequence")),  new WhereClause("sysTraitementBySytPere",Comparateur.IS_NULL)));

    	System.out.println("Utilisateur Trouvé ");
    	

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new User(userService.getTOperateur().getOpeLogin(),
        		userService.getTMotdepasses().getMdpMotdepasse(), enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked,
                getAuthorities("USER"));
    	}
    	
    	/*if(domainUser==null){
    		System.out.println("Utilisateur introuvable ");
    		throw new UsernameNotFoundException(userName);
    	}else{
    		System.out.println("Login de connexion Opérateur : Login "+domainUser.getOpeLogin()+" Nom "+domainUser.getOpeNom());
    		//chck du mdp s'il est nom cripté
    		 userService.getMotPasse(domainUser);
        	//Ici cryptage de password
    		passcrip = userService.getTMotdepasses().getMdpMotdepasse();
 
    		for(TMotdepasse pwd: domainUser.getTMotdepasses()){
    			if(pwd.getMdpStatut()) {
				if(!(pwd.getMdpMotdepasse().startsWith("$") || pwd.getMdpMotdepasse().length()==60)) {
					CustomPasswordEncoder cp = new CustomPasswordEncoder();
		    		passcrip=cp.encode(pwd.getMdpMotdepasse());
					pwd.setMdpMotdepasse(passcrip);
					pwd.setMdpMotdepasseInit("");
				iservice.updateObject(pwd);
				System.out.println("Cryptage du mot de passe ");
				}
    			}
				
			}
		
        	userService.setTOperateur(domainUser);
        	userService.getListeAssignations(domainUser);
        	userService.getMotPasse(domainUser);
    
        	//userService.setPrivileges(domainUser);
        	userService.setDateCons(Calendar.getInstance().getTime());
        
        	System.out.println("Utilisateur Trouvé ");
    	}*/
    	
    	
   
        /*boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        
        //Bloc pour crypter password
        userService.getTMotdepasses().getMdpMotdepasse()

        return new User(userService.getTOperateur().getOpeLogin(),
        		passcrip, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked,
                getAuthorities("USER"));
        
        
        return new User(userService.getTOperateur().getOpeLogin(),
        		userService.getTMotdepasses().getMdpMotdepasse(), enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked,
                getAuthorities("USER"));*/
    }

    public Collection<? extends GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }

    public List<String> getRoles(String role) {

        List<String> roles = new ArrayList<String>();
        if ("ROLE_ADM".equals(role)) {
            roles.add("ROLE_ADM");
        } 
        else if ("ROLE_USER".equals(role)) {
            roles.add("ROLE_USER");
        }
        /*else if ("ROLE_CAB".equals(role)) {
            roles.add("ROLE_CAB");
        }
        else if ("ROLE_CPT".equals(role)) {
            roles.add("ROLE_CPT");
        }*/
        return roles;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(
            List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}