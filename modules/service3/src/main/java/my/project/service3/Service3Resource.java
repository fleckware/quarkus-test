package my.project.service3;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import my.project.lib2.dto.ResponseDTO;

@Path("test")
public class Service3Resource {

    @RestClient
    TalkToService4 streamer;

    @GET
    @Path("fast")
    @Produces(MediaType.TEXT_PLAIN)
    public String streamFast() throws InterruptedException {

        final CopyOnWriteArrayList<ResponseDTO> collected = new CopyOnWriteArrayList<>();
        final CountDownLatch completionLatch = new CountDownLatch(1);
        
        streamer.fastStream().onOverflow().buffer().onCompletion().invoke(completionLatch::countDown).subscribe().with(collected::add);

        completionLatch.await();
        
        return "The fast stream completed successfully";
    }

}
