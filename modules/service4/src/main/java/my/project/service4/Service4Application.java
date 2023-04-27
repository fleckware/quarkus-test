package my.project.service4;

import java.util.HashSet;
import java.util.Set;

import jakarta.annotation.ManagedBean;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("service4")
@ManagedBean
public class Service4Application extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(Service4Resource.class);
        return set;
    }
}
