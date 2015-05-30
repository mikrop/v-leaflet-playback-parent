package org.vaadin.addon.leaflet.demoandtestapp;

import com.vaadin.ui.Component;
import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LOpenStreetMapLayer;
import org.vaadin.addon.leaflet.playback.LPlayback;
import org.vaadin.addonhelpers.AbstractTest;

public class PlaybackTest extends AbstractTest {

    @Override
    public String getDescription() {
        return "Test playback control";
    }

    private LMap leafletMap;

    @Override
    public Component getTestComponent() {
        leafletMap = new LMap();
        leafletMap.setCenter(60.4525, 22.301);
        leafletMap.setZoomLevel(15);
        leafletMap.addBaseLayer(new LOpenStreetMapLayer(), "OSM");

        LPlayback playback = new LPlayback();

        return leafletMap;
    }

    @Override
    protected void setup() {
        super.setup();
    }

}
