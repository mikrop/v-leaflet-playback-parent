package org.vaadin.addon.leaflet.playback.client;

import com.google.gwt.core.client.JavaScriptObject;
import org.peimari.gleaflet.client.AbstractVector;
import org.peimari.gleaflet.client.Map;
import org.vaadin.addon.leaflet.playback.client.resources.LeafletPlaybackResourceInjector;

public class Playback extends AbstractVector {

	static {
        LeafletPlaybackResourceInjector.ensureInjected();
	}

	protected Playback() {}
	
	public static native Playback create(Map map, JavaScriptObject tracks, PlaybackOptions options)
	/*-{
        return new $wnd.L.Playback(map, tracks, null, options);
	}-*/;

}
