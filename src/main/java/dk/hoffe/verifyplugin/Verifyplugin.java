package dk.hoffe.verifyplugin;

import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

@Plugin(
        id = "verifyplugin",
        name = "Verifyplugin",
        version = "1.0-SNAPSHOT",
        description = "verify"
)
public class Verifyplugin {

    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public Verifyplugin(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        server.getEventManager().register(this, new joinListener());
    }
}
