
package com.amazonaws.geo.model;

import com.amazonaws.services.dynamodbv2.model.GetItemResult;

public class GetPointResult extends GeoDataResult {
	private GetItemResult getItemResult;

	public GetPointResult(GetItemResult getItemResult) {
		this.getItemResult = getItemResult;
	}

	public GetItemResult getGetItemResult() {
		return getItemResult;
	}
}