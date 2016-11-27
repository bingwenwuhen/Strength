package cn.com.jersey.kryo;

import cn.com.jersey.kryo.resources.PersonResource;
import org.glassfish.jersey.filter.LoggingFilter;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaxuan on 16/11/25.
 */
public class JaxRsApplication extends Application {

    static final Set<Class<?>> APP_CLASSES = new HashSet<Class<?>>() {
        {
            add(PersonResource.class);
            add(LoggingFilter.class);
        }
    };

    @Override
    public Set<Class<?>> getClasses() {
        return APP_CLASSES;
    }
}
