package my.project.service3;

import java.util.HashSet;
import java.util.Set;

import jakarta.annotation.ManagedBean;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("service3")
@ManagedBean
public class Service3Application extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(Service3Resource.class);
        return set;
    }
}
