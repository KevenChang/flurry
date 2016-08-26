package com.plans.configure.jersey;

import com.plans.rest.JourneyResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Jersey注册REST类
 */
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(JourneyResource.class);
    }
}
