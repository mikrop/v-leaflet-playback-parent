package org.vaadin.addon.leaflet.demoandtestapp;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.vaadin.ui.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LOpenStreetMapLayer;
import org.vaadin.addon.leaflet.playback.LPlayback;
import org.vaadin.addon.leaflet.playback.PlaybackData;
import org.vaadin.addon.leaflet.shared.Point;
import org.vaadin.addonhelpers.AbstractTest;

public class PlaybackTest extends AbstractTest {

    @Override
    public String getDescription() {
        return "Test playback control";
    }

    private LMap leafletMap;

    public static class PointDeserializer extends JsonDeserializer<Point> {

        @Override
        public Point deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
            JsonNode node = jp.getCodec().readTree(jp);
            JsonNode lon = node.get(1);
            JsonNode lat = node.get(0);
            return new Point(lat.asDouble(), lon.asDouble());
        }

    }

    @Override
    public Component getTestComponent() {

        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            SimpleModule simpleModule = new SimpleModule();
            simpleModule.addDeserializer(Point.class, new PointDeserializer());
            objectMapper.registerModule(simpleModule);
            PlaybackData data = objectMapper.readValue(getClass().
                    getResource("demo-tracks.js"), PlaybackData.class);
            
            System.out.println(data.toString());

            leafletMap = new LMap();
            leafletMap.setCenter(44.37857221,-123.77252789);
            leafletMap.setZoomLevel(15);
            leafletMap.addBaseLayer(new LOpenStreetMapLayer(), "OSM");

            LPlayback playback = new LPlayback();
            playback.setPlaybackData(data);
            playback.addTo(leafletMap);

            return leafletMap;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void setup() {
        super.setup();
    }

}
