

package com.amazonaws.geo.dynamodb.internal;

import com.amazonaws.services.dynamodbv2.model.QueryRequest;

public class DynamoDBUtil {
	public static QueryRequest copyQueryRequest(QueryRequest queryRequest) {
		QueryRequest copiedQueryRequest = new QueryRequest().withAttributesToGet(queryRequest.getAttributesToGet())
				.withConsistentRead(queryRequest.getConsistentRead())
				.withExclusiveStartKey(queryRequest.getExclusiveStartKey()).withIndexName(queryRequest.getIndexName())
				.withKeyConditions(queryRequest.getKeyConditions()).withLimit(queryRequest.getLimit())
				.withReturnConsumedCapacity(queryRequest.getReturnConsumedCapacity())
				.withScanIndexForward(queryRequest.getScanIndexForward()).withSelect(queryRequest.getSelect())
				.withTableName(queryRequest.getTableName());

		return copiedQueryRequest;
	}
}