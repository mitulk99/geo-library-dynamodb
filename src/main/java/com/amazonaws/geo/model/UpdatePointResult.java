

package com.amazonaws.geo.model;

import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;

public class UpdatePointResult extends GeoDataResult {
	private UpdateItemResult updateItemResult;

	public UpdatePointResult(UpdateItemResult updateItemResult) {
		this.updateItemResult = updateItemResult;
	}

	public UpdateItemResult getUpdateItemResult() {
		return updateItemResult;
	}
}