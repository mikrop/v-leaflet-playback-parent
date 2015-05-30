package org.vaadin.addon.leaflet.playback.client.resources;

import com.google.gwt.core.client.GWT;
import org.peimari.gleaflet.client.resources.LeafletResourceInjector;

public class LeafletPlaybackResourceInjector {

	protected static LeafletPlaybackClientBundle bundle;

	public static void ensureInjected() {
		if (bundle == null) {
			LeafletResourceInjector.ensureInjected();
			bundle = GWT.create(LeafletPlaybackClientBundle.class);
			LeafletPlaybackResourceInjector injector = GWT.create(LeafletPlaybackResourceInjector.class);
			injector.injectResources();
		}
	}
	
	/**
	 * Override this with deferred binding to customize injected stuff
	 */
	protected void injectResources() {
		injectScript(bundle.jquery().getText());
		injectScript(bundle.script().getText());
	}

	private static native void injectScript(String script)
	/*-{
	    $wnd.eval(script);
	}-*/;

}
