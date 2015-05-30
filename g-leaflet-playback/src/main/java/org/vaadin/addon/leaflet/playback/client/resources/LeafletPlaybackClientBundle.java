package org.vaadin.addon.leaflet.playback.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.TextResource;

public interface LeafletPlaybackClientBundle extends ClientBundle {

    @Source("jquery-1.11.0.min.js")
    TextResource jquery();

    @Source("LeafletPlayback.js")
    @DoNotEmbed
    TextResource script();

}
