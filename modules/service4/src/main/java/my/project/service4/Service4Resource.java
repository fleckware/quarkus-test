package my.project.service4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Multi;
import my.project.lib2.Handler1;
import my.project.lib2.dto.ResponseDTO;

import org.jboss.resteasy.reactive.common.util.RestMediaType;
import org.jboss.resteasy.reactive.RestStreamElementType;

@Path("test")
public class Service4Resource {

    @Inject
    Handler1 handler;

    @GET
    @Path("fast")
    @Produces(RestMediaType.APPLICATION_STREAM_JSON)
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    @Blocking
    public Multi<ResponseDTO> anotherValue() {

        return Multi.createFrom().emitter(em -> {

            for (int i = 0; i < 3600; i++) {
                final UUID id = UUID.randomUUID();

                final ResponseDTO response = handler.getAverageDTO(id);

                for (int j = 0; j < 5000; j++) {
                    em.emit(response);
                }
            }
        });
    }
}
