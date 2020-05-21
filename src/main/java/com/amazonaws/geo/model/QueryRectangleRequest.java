

package com.amazonaws.geo.model;

public class QueryRectangleRequest extends GeoQueryRequest {
	private GeoPoint minPoint;
	private GeoPoint maxPoint;

	public QueryRectangleRequest(GeoPoint minPoint, GeoPoint maxPoint) {
		this.minPoint = minPoint;
		this.maxPoint = maxPoint;
	}

	public GeoPoint getMinPoint() {
		return minPoint;
	}

	public GeoPoint getMaxPoint() {
		return maxPoint;
	}
}