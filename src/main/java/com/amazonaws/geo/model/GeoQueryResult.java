

package com.amazonaws.geo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.QueryResult;

public class GeoQueryResult extends GeoDataResult {
	private List<Map<String, AttributeValue>> item;
	private List<QueryResult> queryResults;

	public GeoQueryResult() {
		item = Collections.synchronizedList(new ArrayList<Map<String, AttributeValue>>());
		queryResults = Collections.synchronizedList(new ArrayList<QueryResult>());
	}

	public GeoQueryResult(GeoQueryResult geoQueryResult) {
		this();

		item = geoQueryResult.getItem();
		queryResults = geoQueryResult.getQueryResults();
	}

	public List<Map<String, AttributeValue>> getItem() {
		return item;
	}

	public List<QueryResult> getQueryResults() {
		return queryResults;
	}
}