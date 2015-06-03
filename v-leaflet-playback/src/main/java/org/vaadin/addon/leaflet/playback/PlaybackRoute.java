package org.vaadin.addon.leaflet.playback;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import org.vaadin.addon.leaflet.jsonmodels.PointArray;

/**
 *
 * @author Matti Tahvonen
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaybackRoute {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private Geometry geometry = new Geometry();
    private Properties properties = new Properties();

    public Geometry getGeometry() {
        return geometry;
    }

    public Properties getProperties() {
        return properties;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Geometry {

        private String type = "MultiPoint";
        private PointArray coordinates = new PointArray();

        public PointArray getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(PointArray coordinates) {
            this.coordinates = coordinates;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
        
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Properties {

        private List<Long> time = new ArrayList();

        public List<Long> getTime() {
            return time;
        }

        public void setTime(List<Long> time) {
            this.time = time;
        }

    }

}
