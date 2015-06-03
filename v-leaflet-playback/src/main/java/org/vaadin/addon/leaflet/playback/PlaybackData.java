package org.vaadin.addon.leaflet.playback;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matti Tahvonen
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaybackData extends ArrayList<PlaybackRoute> {

    private static ObjectMapper om = new ObjectMapper();
    static {
        
    }

    @Override
    public String toString() {
        try {
            return om.writeValueAsString(this);
        } catch (Exception ex) {
            Logger.getLogger(PlaybackData.class.getName()).
                    log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
