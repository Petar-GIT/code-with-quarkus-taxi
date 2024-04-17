package rest.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import rest.server.IpLog;


@Path("/data")
@RegisterRestClient(configKey = "ip-client")
public interface IpClient {

    @GET
    @Path("/client-ip")
    IpLog getIp();
}
