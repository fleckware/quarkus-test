package my.project.service3;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.common.util.RestMediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestStreamElementType;

import io.smallrye.mutiny.Multi;
import my.project.lib2.dto.ResponseDTO;

@Path("test")
@RegisterRestClient(configKey = "streamer")
public interface TalkToService4 {
    
    @GET
    @Path("large")
    @Produces(RestMediaType.APPLICATION_STREAM_JSON)
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    Multi<ResponseDTO> largeStream();

    @GET
    @Path("fast")
    @Produces(RestMediaType.APPLICATION_STREAM_JSON)
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    Multi<ResponseDTO> fastStream();

}
