package my.project.service1;

import java.util.HashSet;
import java.util.Set;

import jakarta.annotation.ManagedBean;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("service1")
@ManagedBean
public class Service1Application extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(PluginResource.class);
        return set;
    }
}
