package net.hackraft.api.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

/**
 * Hackraft.
 *
 * @author Maxim Kheilik
 */
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(new BridgeConfig());

        /* Bean validation feature */
        property(ServerProperties.BV_FEATURE_DISABLE, false);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        /* Allow Role-Based Security */
        ResourceConfig config = packages("net.hackraft.api.resourse");
        config.register(RolesAllowedDynamicFeature.class);
    }
}
