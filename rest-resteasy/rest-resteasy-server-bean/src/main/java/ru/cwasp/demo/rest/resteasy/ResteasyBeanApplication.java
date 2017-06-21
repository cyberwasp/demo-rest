package ru.cwasp.demo.rest.resteasy;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("resteasy")
public class ResteasyBeanApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> r = new HashSet<>();
        r.add(ResteasyBeanService.class);
        r.add(ResteasyJSONProvider.class);
        return r;
    }
}
