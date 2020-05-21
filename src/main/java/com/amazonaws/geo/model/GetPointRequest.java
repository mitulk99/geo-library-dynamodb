
package com.amazonaws.geo.model;

import java.util.HashMap;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;

/**
 * Get point request. The request must specify a geo point and a range key value. You can modify GetItemRequest to
 * customize the underlining Amazon DynamoDB get item request, but the table name, hash key, geohash, and geoJson
 * attribute will be overwritten by GeoDataManagerConfiguration.
 * */
public class GetPointRequest extends GeoDataRequest {
	private GetItemRequest getItemRequest;
	private GeoPoint geoPoint;
	private AttributeValue rangeKeyValue;

	public GetPointRequest(GeoPoint geoPoint, AttributeValue rangeKeyValue) {
		getItemRequest = new GetItemRequest();
		getItemRequest.setKey(new HashMap<String, AttributeValue>());

		this.geoPoint = geoPoint;
		this.rangeKeyValue = rangeKeyValue;
	}

	public GetItemRequest getGetItemRequest() {
		return getItemRequest;
	}

	public GeoPoint getGeoPoint() {
		return geoPoint;
	}

	public AttributeValue getRangeKeyValue() {
		return rangeKeyValue;
	}
}