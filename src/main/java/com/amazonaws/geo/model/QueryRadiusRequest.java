

package com.amazonaws.geo.model;

public class QueryRadiusRequest extends GeoQueryRequest {
	private GeoPoint centerPoint;
	private double radiusInMeter;

	public QueryRadiusRequest(GeoPoint centerPoint, double radiusInMeter) {
		this.centerPoint = centerPoint;
		this.radiusInMeter = radiusInMeter;
	}

	public GeoPoint getCenterPoint() {
		return centerPoint;
	}

	public double getRadiusInMeter() {
		return radiusInMeter;
	}
}