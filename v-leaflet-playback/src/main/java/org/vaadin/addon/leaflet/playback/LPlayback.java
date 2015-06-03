package org.vaadin.addon.leaflet.playback;

import com.vaadin.server.AbstractExtension;
import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.playback.client.LPlaybackState;

public class LPlayback extends AbstractExtension {
    
    private PlaybackData data;

    public void setPlaybackData(PlaybackData data) {
        this.data = data;
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        getState().geojsondata = data.toString();
        super.beforeClientResponse(initial);
    }

    @Override
    protected LPlaybackState getState() {
        return (LPlaybackState) super.getState();
    }
    
    public void addTo(LMap map) {
        extend(map);
    }

}
