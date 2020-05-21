

package com.amazonaws.geo.model;

import com.amazonaws.services.dynamodbv2.model.DeleteItemResult;

public class DeletePointResult extends GeoDataResult {
	private DeleteItemResult deleteItemResult;

	public DeletePointResult(DeleteItemResult deleteItemResult) {
		this.deleteItemResult = deleteItemResult;
	}

	public DeleteItemResult getDeleteItemResult() {
		return deleteItemResult;
	}
}