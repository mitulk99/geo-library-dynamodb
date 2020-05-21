

package com.amazonaws.geo.model;

import java.util.HashMap;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;

/**
 * Delete point request. The request must specify a geo point and a range key value. You can modify DeleteItemRequest to
 * customize the underlining Amazon DynamoDB delete item request, but the table name, hash key, geohash, and geoJson
 * attribute will be overwritten by GeoDataManagerConfiguration.
 * 
 * */
public class DeletePointRequest extends GeoDataRequest {
	private DeleteItemRequest deleteItemRequest;
	private GeoPoint geoPoint;
	private AttributeValue rangeKeyValue;

	public DeletePointRequest(GeoPoint geoPoint, AttributeValue rangeKeyValue) {
		deleteItemRequest = new DeleteItemRequest();
		deleteItemRequest.setKey(new HashMap<String, AttributeValue>());

		this.geoPoint = geoPoint;
		this.rangeKeyValue = rangeKeyValue;
	}

	public DeleteItemRequest getDeleteItemRequest() {
		return deleteItemRequest;
	}

	public GeoPoint getGeoPoint() {
		return geoPoint;
	}

	public AttributeValue getRangeKeyValue() {
		return rangeKeyValue;
	}
}