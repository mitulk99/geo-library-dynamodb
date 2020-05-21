
package com.amazonaws.geo.model;

import com.amazonaws.services.dynamodbv2.model.QueryRequest;

public class GeoQueryRequest extends GeoDataRequest {
	private QueryRequest queryRequest;

	public GeoQueryRequest() {
		queryRequest = new QueryRequest();
	}

	public QueryRequest getQueryRequest() {
		return queryRequest;
	}
}