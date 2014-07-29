package org.wso2.service;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;
import org.jboss.resteasy.util.Base64;
import org.wso2.DAO.RoleDAO;
import org.wso2.DAO.UserDAO;
import org.wso2.beans.Role;
import org.wso2.beans.User;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.*;

/**
 * This interceptor verify the access permissions for a user 
 * based on username and passowrd provided in request
 */
@Provider
@ServerInterceptor
public class SecurityInterceptor implements PreProcessInterceptor
{
	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";
	private static final ServerResponse ACCESS_DENIED = new ServerResponse("Access denied for this resource", 401, new Headers<Object>());;
	private static final ServerResponse ACCESS_FORBIDDEN = new ServerResponse("Nobody can access this resource", 403, new Headers<Object>());;
	private static final ServerResponse SERVER_ERROR = new ServerResponse("INTERNAL SERVER ERROR", 500, new Headers<Object>());;

	public ServerResponse preProcess(HttpRequest request, ResourceMethod methodInvoked) throws Failure, WebApplicationException
	{
		Method method = methodInvoked.getMethod();

		//Access allowed for all 
		if(method.isAnnotationPresent(PermitAll.class))
		{
			return null;
		}

		//Access denied for all 
		if(method.isAnnotationPresent(DenyAll.class))
		{
			return ACCESS_FORBIDDEN;
		}
		
		//Get request headers
		final HttpHeaders headers = request.getHttpHeaders();
		
		//Fetch authorization header
	    final List<String> authorization = headers.getRequestHeader(AUTHORIZATION_PROPERTY);
	    
	    //If no authorization information present; block access
	    if(authorization == null || authorization.isEmpty())
	    {
	    	return ACCESS_DENIED;
	    }
	    
	    //Get encoded username and password
	    final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");
        //Decode username and password
	    String usernameAndPassword;
		try {
			usernameAndPassword = new String(Base64.decode(encodedUserPassword));
        } catch (IOException e) {
			return SERVER_ERROR;
		}

		//Split username and password tokens
	    final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
	    final String username = tokenizer.nextToken();
	    final String password = tokenizer.nextToken();
	    
	    //Verifying Username and password
	    //Verify user access
		if(method.isAnnotationPresent(RolesAllowed.class)) {
            RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
            Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));
            //Is user valid?
            try {
                if (!isUserAllowed(username, password, rolesSet)) {
                    return ACCESS_DENIED;
                }
            }
            catch (SQLException e) {
            e.printStackTrace();
            }
        }
		//Return null to continue request processing
		return null;
	}

	private boolean isUserAllowed(final String username, final String password,	final Set<String> rolesSet) throws SQLException {
		boolean isAllowed = false;
		//Step 1. Fetch password from database and match with password in argument
		//If both match then get the defined role for user from database and continue; else return isAllowed [false]
		//Access the database and do this part yourself
		//String userRole = userMgr.getUserRole(username);
        List<User> user=new ArrayList<User>();
        List<Role> role=new ArrayList<Role>();
        user=UserDAO.getUser(username);
        role= RoleDAO.getRole(user.get(0).getRole_id());
        if (user.size()>0 && role.size()>0) {
            String DBuserame = user.get(0).getEmail();
            String userRole = role.get(0).getRole();
            String DBpassword = user.get(0).getPassword();
            //Step 2. Verify user role
            System.out.println(password+DBpassword);
            Iterator iterator = rolesSet.iterator();
            while(iterator.hasNext())
            {
                String DBuserRole= (String) iterator.next();
                System.out.println(username.matches(DBuserame)+"="+BCrypt.checkpw(password, DBpassword)+"="+userRole.matches(DBuserRole));
                if (username.matches(DBuserame) && BCrypt.checkpw(password, DBpassword) && userRole.matches(DBuserRole)) {
                    isAllowed = true;
                    break;
                }
            }
        }
		return isAllowed;
	}
}