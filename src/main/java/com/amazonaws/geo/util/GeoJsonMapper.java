

package com.amazonaws.geo.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.amazonaws.geo.model.GeoObject;
import com.amazonaws.geo.model.GeoPoint;

public class GeoJsonMapper {
	private static ObjectMapper mapper = new ObjectMapper();

	public static GeoPoint geoPointFromString(String jsonString) {
		try {
			return mapper.readValue(jsonString, GeoPoint.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String stringFromGeoObject(GeoObject geoObject) {
		try {
			return mapper.writeValueAsString(geoObject);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}