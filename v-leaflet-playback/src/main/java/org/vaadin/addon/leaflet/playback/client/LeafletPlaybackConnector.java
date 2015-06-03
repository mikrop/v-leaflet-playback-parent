package org.vaadin.addon.leaflet.playback.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.json.client.JSONParser;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;
import org.peimari.gleaflet.client.Map;
import org.vaadin.addon.leaflet.client.LeafletMapConnector;
import org.vaadin.addon.leaflet.playback.LPlayback;

@Connect(LPlayback.class)
public class LeafletPlaybackConnector extends AbstractExtensionConnector {

    private Playback playback;

    @Override
    public LPlaybackState getState() {
        return (LPlaybackState) super.getState();
    }

    @Override
    protected void extend(ServerConnector target) {
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {

            @Override
            public void execute() {

                LeafletMapConnector parent = (LeafletMapConnector) getParent();
                Map map = parent.getMap();

                PlaybackOptions options = PlaybackOptions.create();

                JavaScriptObject geodata = JSONParser.parseStrict(
                        getState().geojsondata)
                        // Looks like LPlayback makes the infamous JS array check that don't work across iframes :-( 
                        // Just get the first one
                        .isArray().get(0).isObject().getJavaScriptObject().
                        cast();

                playback = Playback.create(map, geodata, options);

            }
        });
    }

}
