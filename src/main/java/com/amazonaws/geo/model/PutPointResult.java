

package com.amazonaws.geo.model;

import com.amazonaws.services.dynamodbv2.model.PutItemResult;

public class PutPointResult extends GeoDataResult {
	private PutItemResult putItemResult;

	public PutPointResult(PutItemResult putItemResult) {
		this.putItemResult = putItemResult;
	}

	public PutItemResult getPutItemResult() {
		return putItemResult;
	}
}