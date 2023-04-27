package my.project.service3;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.mutiny.subscription.Cancellable;

import my.project.lib2.dto.ResponseDTO;

@Path("test")
public class Service3Resource {

    @RestClient
    TalkToService4 streamer;

    @GET
    @Path("cancel")
    @Produces(MediaType.TEXT_PLAIN)
    public String streamFast() throws InterruptedException {

        final CopyOnWriteArrayList<ResponseDTO> collected = new CopyOnWriteArrayList<>();
        final CountDownLatch completionLatch = new CountDownLatch(1);
        
        Cancellable cancellable = streamer.fastStream().onOverflow().buffer()
            .onCompletion().invoke(completionLatch::countDown)
            .onCancellation().invoke(completionLatch::countDown)
            .subscribe().with(collected::add);

        // sleep 10 seconds before cancelling
        Thread.sleep(10000);
        cancellable.cancel();

        completionLatch.await();
        
        return "The stream cancelled successfully";
    }

}
