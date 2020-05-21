package com.amazonaws.geo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.geo.model.GeoPoint;
import com.amazonaws.geo.model.PutPointRequest;
import com.amazonaws.geo.model.PutPointResult;
import com.amazonaws.geo.model.QueryRadiusRequest;
import com.amazonaws.geo.model.QueryRadiusResult;
import com.amazonaws.geo.util.GeoTableUtil;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;


public class App 
{
	private AmazonDynamoDBClient ddb=null;
	// setting up credentials ,whenever instance is called.
	// No need to provide region, as by default it takes US-EAST-1, if needed use comment part.
	public App() throws IOException 
	{
	AWSCredentials credentials = new BasicAWSCredentials("ACCESS_KEY", "SECRET_ACCESS_KEY");
	 ddb = new AmazonDynamoDBClient(credentials);
	//Region usEast1 = Region.getRegion(Regions.US_EAST_1);
	}
	
	
	// For creating a table with name "geo-test".
	public void CreateTable()
	{
	GeoDataManagerConfiguration config = new GeoDataManagerConfiguration(ddb, "geo-test");
	CreateTableRequest createTableRequest = GeoTableUtil.getCreateTableRequest(config);
		try{
			CreateTableResult createTableResult = ddb.createTable(createTableRequest);
		}catch(NullPointerException e)
		{
			System.out.println("Thrown");
		}
	}
	
	// inserting items into "geo-test" table, with the data stored in the "Stores" table.
	public void putItems()
	{
		GeoDataManagerConfiguration config = new GeoDataManagerConfiguration(ddb, "geo-test");
		GeoDataManager geoDataManager = new GeoDataManager(config);
		
		// getting "Stores" table
		ScanRequest scanRequest = new ScanRequest().withTableName("Stores");

		ScanResult result = ddb.scan(scanRequest);
		
		// iterate through all items of table "Stores" and store Geo-hash accordingly in table "geo-test"
		for (Map<String, AttributeValue> item : result.getItems()) {
			
			double latitude = Double.valueOf(item.get("Lat").getS());
			double longitude = Double.valueOf(item.get("Lon").getS());
			GeoPoint geoPoint = new GeoPoint(latitude, longitude);
			String s=item.get("Id").getN();
			AttributeValue rangeKeyValue = new AttributeValue().withS(s);
			PutPointRequest putPointRequest = new PutPointRequest(geoPoint, rangeKeyValue);
			AttributeValue address = new AttributeValue().withS(item.get("address").getS());
			AttributeValue type = new AttributeValue().withS(item.get("type").getS());
			PutItemRequest putItemRequest = putPointRequest.getPutItemRequest();
			putItemRequest.addItemEntry("address", address);
			putItemRequest.addItemEntry("type", type);
			PutPointResult putPointResult = geoDataManager.putPoint(putPointRequest);
		}
	}
	
	// this method retrieves information of all stores near by "centerPoint" within "radius" (in metres).
	public void getRadiusquery()
	{
		GeoDataManagerConfiguration config = new GeoDataManagerConfiguration(ddb, "geo-test");
		GeoDataManager geoDataManager = new GeoDataManager(config);
		double latitude = 23.8458771;
		double longitude =72.1291516;
		Double radius=14000.0; // in metres
		GeoPoint centerPoint = new GeoPoint(latitude, longitude);
		QueryRadiusRequest queryRadiusRequest = new QueryRadiusRequest(centerPoint, radius);
        QueryRadiusResult queryRadiusResult = geoDataManager.queryRadius(queryRadiusRequest);
        List<Map<String, AttributeValue>> queryResults = queryRadiusResult.getItem();
        for(Map<String, AttributeValue> item : queryResults)
        {	System.out.println(item.get("address").getS());
        	System.out.println(item.get("type").getS());
        }
	}
	
	// for deleting table "geo-test"
	public void deleteTable() {
		DeleteTableRequest deleteTableRequest = new DeleteTableRequest()
				.withTableName("geo-test");
		DeleteTableResult result = ddb.deleteTable(deleteTableRequest);
	}
	
	
    public static void main( String[] args )
    {
    	try{
        System.out.println( "Hello World!" );
        App maa=new App();
        //maa.CreateTable();
        //maa.putItems();
       // maa.deleteTable();
        maa.getRadiusquery();
        System.out.println("Done");}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}
