package my.project.service4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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

        List<UUID> ids = new ArrayList<>(5000);
        for (int i = 0; i < 100; i++) {
            ids.add(UUID.randomUUID());
        }

        // Send a DTO every second
        final Multi<Long> ticks = Multi.createFrom().ticks().every(Duration.ofMillis(1000)).onOverflow().drop();
        final Multi<ResponseDTO> multi = Multi.createFrom().items(ids.stream()).onItem().transform(id -> handler.getAverageDTO(id));
        return Multi.createBy().combining().streams(ticks, multi).using((x, item) -> item);
    }
}
