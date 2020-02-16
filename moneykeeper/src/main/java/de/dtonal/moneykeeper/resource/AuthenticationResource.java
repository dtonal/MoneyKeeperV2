package de.dtonal.moneykeeper.resource;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.dtonal.moneykeeper.model.UserCredential;
import de.dtonal.moneykeeper.security.JwtService;

@Path("/authentication")
public class AuthenticationResource {

	@Inject
	private JwtService jwtService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authenticateUser(UserCredential credentials) {

		try {

			// Authenticate the user using the credentials provided
			authenticate(credentials.getUsername(), credentials.getPassword());

			// Issue a token for the user
			String token = issueToken(credentials.getUsername());

			// Return the token on the response
			return Response.ok(token).build();

		} catch (Exception e) {
			return Response.status(Response.Status.FORBIDDEN).build();
		}
	}

	private void authenticate(String username, String password) throws Exception {
		// Authenticate against a database, LDAP, file or whatever
		// Throw an Exception if the credentials are invalid
	}

	private String issueToken(String username) throws IOException {
		return jwtService.createJws(username);
	}

}
