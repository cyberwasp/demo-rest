package ru.cwasp.demo.rest.resteasy;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("resteasy")
public class ResteasyExceptionApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<>();
        set.add(ResteasyExceptionMapperImpl.class);
        set.add(ResteasyExceptionService.class);
        return set;
    }
}
