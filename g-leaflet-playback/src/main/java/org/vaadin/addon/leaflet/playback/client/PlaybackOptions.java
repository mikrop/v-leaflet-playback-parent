package org.vaadin.addon.leaflet.playback.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * options: {
     playControl: true,
     dateControl: true,
     sliderControl: true
 * }
 */
public class PlaybackOptions extends JavaScriptObject {

    protected PlaybackOptions() {}

    public static native PlaybackOptions create() /*-{
        return {     
            playControl: true,
            dateControl: true,
            sliderControl: true
        };
    }-*/;

    public native final void setPlayControl(Boolean playControl) /*-{
        this.playControl = playControl;
    }-*/;

    public native final void setDateControl(Boolean dateControl) /*-{
        this.dateControl = dateControl;
    }-*/;

    public native final void setSliderControl(Boolean sliderControl) /*-{
        this.sliderControl = sliderControl;
    }-*/;

}
