package boot.dubbo.api;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class MyExceptionMapper implements ExceptionMapper<Exception> {

	public Response toResponse(Exception e) {
		return Response.status(Response.Status.OK)
				.entity("{ex:'" + e.getMessage() + "'}")
				.type(MediaType.APPLICATION_JSON).build();
	}
}
