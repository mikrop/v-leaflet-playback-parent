package org.vaadin.addon.leaflet.playback.client;

import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.leaflet.playback.LPlayback;

@Connect(LPlayback.class)
public class LeafletPlaybackConnector extends AbstractComponentConnector {

    @Override
    public LPlaybackState getState() {
        return (LPlaybackState) super.getState();
    }

//    @Override
//    protected void update() {
//        JavaScriptObject tracks = JavaScriptObject.createArray();
//        PlaybackOptions options = PlaybackOptions.create();
//        Playback playback = Playback.create(getMap(), tracks, options);
//        addToParent(playback);
//    }

}