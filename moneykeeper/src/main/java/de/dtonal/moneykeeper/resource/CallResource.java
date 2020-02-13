package de.dtonal.moneykeeper.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/callservice")
public class CallResource {

	@GET
	@Path("/calls")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Call> getCalls() {
		List<Call> calls = new ArrayList<>();
		var call = new Call();
		call.setCallId("callid");
		call.setCallName("name");
		call.setTimestamp("now");
		calls.add(call);
		return calls;
	}
}
