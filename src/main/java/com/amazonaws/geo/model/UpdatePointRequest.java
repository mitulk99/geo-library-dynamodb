
package com.amazonaws.geo.model;

import java.util.HashMap;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;

/**
 * Update point request. The request must specify a geo point and a range key value. You can modify UpdateItemRequest to
 * customize the underlining Amazon DynamoDB update item request, but the table name, hash key, geohash, and geoJson
 * attribute will be overwritten by GeoDataManagerConfiguration.
 * 
 * */
public class UpdatePointRequest extends GeoDataRequest {
	private UpdateItemRequest updateItemRequest;
	private GeoPoint geoPoint;
	private AttributeValue rangeKeyValue;

	public UpdatePointRequest(GeoPoint geoPoint, AttributeValue rangeKeyValue) {
		updateItemRequest = new UpdateItemRequest();
		updateItemRequest.setKey(new HashMap<String, AttributeValue>());
		updateItemRequest.setAttributeUpdates(new HashMap<String, AttributeValueUpdate>());

		this.geoPoint = geoPoint;
		this.rangeKeyValue = rangeKeyValue;
	}

	public UpdateItemRequest getUpdateItemRequest() {
		return updateItemRequest;
	}

	public GeoPoint getGeoPoint() {
		return geoPoint;
	}

	public AttributeValue getRangeKeyValue() {
		return rangeKeyValue;
	}
}