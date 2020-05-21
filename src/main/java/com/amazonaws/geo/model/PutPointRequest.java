

package com.amazonaws.geo.model;

import java.util.HashMap;

import com.amazonaws.geo.GeoDataManagerConfiguration;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutRequest;

/**
 * Put point request. The request must specify a geo point and a range key value. You can modify PutItemRequest to
 * customize the underlining Amazon DynamoDB put item request, but the table name, hash key, geohash, and geoJson
 * attribute will be overwritten by GeoDataManagerConfiguration.
 * 
 * @see GeoDataManagerConfiguration
 * 
 * */
public class PutPointRequest extends GeoDataRequest {
	private PutItemRequest putItemRequest;
	private PutRequest putRequest;
	private GeoPoint geoPoint;
	private AttributeValue rangeKeyValue;

	public PutPointRequest(GeoPoint geoPoint, AttributeValue rangeKeyValue) {
		putItemRequest = new PutItemRequest();
		putItemRequest.setItem(new HashMap<String, AttributeValue>());
		putRequest = new PutRequest();
		putRequest.setItem(new HashMap<String, AttributeValue>());
		
		this.geoPoint = geoPoint;
		this.rangeKeyValue = rangeKeyValue;
	}

	public PutItemRequest getPutItemRequest() {
		return putItemRequest;
	}

	public GeoPoint getGeoPoint() {
		return geoPoint;
	}

	public AttributeValue getRangeKeyValue() {
		return rangeKeyValue;
	}
	
	public PutRequest getPutRequest() {
		return putRequest;
	}
}