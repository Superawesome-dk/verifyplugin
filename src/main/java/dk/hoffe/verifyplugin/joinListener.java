package dk.hoffe.verifyplugin;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.ServerPreConnectEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class joinListener {
    @Subscribe
    public void onPlayerjoin(ServerPreConnectEvent event) {
        Number code = verifyData.opretKode(event.getPlayer().getUniqueId());
        Component message = Component.text("Kode: " + code, NamedTextColor.AQUA);
        event.getPlayer().disconnect(message);
        // do stuff
    }
}
