package org.semweb.finalproject;

import java.io.IOException;
import java.io.InputStream;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.ReasonerRegistry;
import com.hp.hpl.jena.reasoner.rulesys.GenericRuleReasoner;
import com.hp.hpl.jena.reasoner.rulesys.Rule;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;

public class FinalSemanticWebProject {
	static String defaultNameSpace = "http://www.semanticweb.org/navn/ontologies/2013/11/US_Transportation#";
			 Model _transporatation= null;
			Model schema = null;
	public static void main(String[] args) throws IOException
	{
		FinalSemanticWebProject transport = new FinalSemanticWebProject();
		transport.populateUSTransportationData();
		System.out.println("@@@@@@@@@@@@@@@@@@* Final Semantic Web Project *@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("");
		System.out.println("@@@@@@@@@@@@@@@@@@* Modelling US Transportation Data *@@@@@@@@@@@@@@@@");
		System.out.println("");
		ResultSet query1_response = transport.vehicleSales(transport._transporatation);
		System.out.println("=====================Query 1========================");
		System.out.println("****Vehicle Sales Per 1000 Units as of OCT-2013****");
		System.out.println("");
		System.out.println("Monthly_Sales" + " "+ "ForeignVehicle_Sales" + " " + "LightWV_Sales");
		while( query1_response.hasNext())
		{
			QuerySolution soln = query1_response.nextSolution();
			Literal Monthly_Sales = soln.getLiteral("?Monthly_Sales");
			Literal ForeignVehicle_Sales = soln.getLiteral("?ForeignVehicle_Sales");
			Literal LightWV_Sales= soln.getLiteral("?LightWV_Sales");
			if( (Monthly_Sales)  != null ){
				System.out.println("  " + 
						Monthly_Sales.getString() +  "	 " +
						ForeignVehicle_Sales.getString()+ "		   " +
						LightWV_Sales.getString() );
			}
			else
			System.out.println("Not found!");
		}
		System.out.println("");
		System.out.println("==================End of Query 1=====================");
		
		ResultSet query2_response = transport.fatalites(transport._transporatation);
		System.out.println("");
		System.out.println("=====================Query 2========================");
		System.out.println("****Fatalities Happened between 1994 - 2011 in USA****");
		System.out.println("");
		System.out.println("Bicyclists" + " "+ "Pedestrians" + " " + "Motorcyclists" + " " + "Total_Road_Fatalities");
		while( query2_response.hasNext())
		{
			QuerySolution soln = query2_response.nextSolution();
			Literal Bicyclists = soln.getLiteral("?Bicyclists");
			Literal Pedestrians = soln.getLiteral("?Pedestrians");
			Literal Motorcyclists= soln.getLiteral("?Motorcyclists");
			Literal Total_Road_Fatalities= soln.getLiteral("?Total_Road_Fatalities");
			if( Bicyclists != null )
			System.out.println("   " + Bicyclists.getString() +  "		" + 
								Pedestrians.getString() + "	  " + 
								Motorcyclists.getString() + "		" + 
								Total_Road_Fatalities.getString() );
			else
			System.out.println("Not found!");
		}
		System.out.println("");
		System.out.println("==================End of Query 2=====================");
		
		ResultSet query3_response = transport.Aviation_Records(transport._transporatation);
		System.out.println("");
		System.out.println("=====================Query 3========================");
		System.out.println("****Aviation Trafic statistics****");
		System.out.println("");
		System.out.println("MCancelled_Flights" + " "+ "MOnTime_Arrivals"
		+ " " + "NumberOf_Airports" + " " + "MLate_Arrivals" + " " + "MPassengers");
		while( query3_response.hasNext())
		{
			QuerySolution soln = query3_response.nextSolution();
			Literal MonthlyCancelled_Flights = soln.getLiteral("?MonthlyCancelled_Flights");
			Literal MonthlyOnTime_Arrivals = soln.getLiteral("?MonthlyOnTime_Arrivals");
			Literal NumberOf_Airports= soln.getLiteral("?NumberOf_Airports");
			Literal MonthlyLate_Arrivals= soln.getLiteral("?MonthlyLate_Arrivals");
			Literal Monthly_Passengers= soln.getLiteral("?Monthly_Passengers");
			if( MonthlyCancelled_Flights != null )
			System.out.println(" " + MonthlyCancelled_Flights.getString() +  " 			" + 
								MonthlyOnTime_Arrivals.getString() + "		" + 
								NumberOf_Airports.getString() + " 		" + 
								MonthlyLate_Arrivals.getString()+  " 		" + 
								Monthly_Passengers.getString() );
			else
			System.out.println("Not found!");
		}
		System.out.println("");
		System.out.println("==================End of Query 3=====================");
		
		ResultSet query4_response = transport.Airline_data(transport._transporatation);
		System.out.println("");
		System.out.println("=====================Query 4========================");
		System.out.println("****Miles Covered Using Airlines as mode of transport statistics****");
		System.out.println("");
		System.out.println("PassengerTravelled_Miles" + " "+ "Mon_Passengers" + " " + "Num_Airports");
		while( query4_response.hasNext())
		{ 
			QuerySolution soln = query4_response.nextSolution();
			Literal PassengerTravelled_Miles = soln.getLiteral("?PassengerTravelled_Miles");
			Literal Mon_Passengers = soln.getLiteral("?Mon_Passengers");
			Literal Num_Airports= soln.getLiteral("?Num_Airports");
			if( PassengerTravelled_Miles != null )
			System.out.println("  " + PassengerTravelled_Miles.getString() +  " 		   " + 
								Mon_Passengers.getString() + "  	 " + 
								Num_Airports.getString() );
			else
			System.out.println("Not found!");
		}
		System.out.println("");
		System.out.println("==================End of Query 4=====================");
		
		ResultSet query5_response = transport.Passenger_Travelled_Miles(transport._transporatation);
		System.out.println("");
		System.out.println("=====================Query 5========================");
		System.out.println("****Average Passenger Travelled Miles Using Bus and Motorcycles****");
		System.out.println("");
		System.out.println("Passengers_Using_Bus" + " "+ "Passengers_Using_Motorcycle");
		while( query5_response.hasNext())
		{ 
			QuerySolution soln = query5_response.nextSolution();
			Literal Passenger_Using_Bus = soln.getLiteral("?Passenger_Using_Bus");
			Literal Passenger_Using_Motorcycle = soln.getLiteral("?Passenger_Using_Motorcycle");
			if( Passenger_Using_Bus != null )
			System.out.println("  " + Passenger_Using_Bus.getString() +  " 		" + 
									  Passenger_Using_Motorcycle.getString()); 
			else
			System.out.println("Not found!");
		}
		System.out.println("");
		System.out.println("==================End of Query 5=====================");
		
		ResultSet query6_response = transport.MinMax_MonthlyVehicleSales(transport._transporatation);
		System.out.println("");
		System.out.println("=====================Query 6========================");
		System.out.println("****Maximum and Minimum number of vehicles sold****");
		System.out.println("");
		System.out.println("max_vehicle_sales" + " "+ "min_vehicle_sales");
		while( query6_response.hasNext())
		{ 
			QuerySolution soln = query6_response.nextSolution();
			Literal max_vehicle_sales = soln.getLiteral("?max_vehicle_sales");
			Literal min_vehicle_sales = soln.getLiteral("?min_vehicle_sales");
			if( max_vehicle_sales != null )
			System.out.println("  " + max_vehicle_sales.getString()+  "	 " +
									  min_vehicle_sales.getString());
			else
			System.out.println("Not found!");
		}
		System.out.println("");
		System.out.println("==================End of Query 6=====================");
		
		ResultSet query7_response = transport.Fuel_Price(transport._transporatation);
		System.out.println("");
		System.out.println("=====================Query 7========================");
		System.out.println("****Variation in Fuel Prices Per Gallon Ordered by Airline Fuel Price****");
		System.out.println("");
		System.out.println("Airline_Fuelprice" + " "+ "Diesel_Price" + " " + "Gas_Price");
		while( query7_response.hasNext())
		{ 
			QuerySolution soln = query7_response.nextSolution();
			Literal Airline_Fuelprice = soln.getLiteral("?Airline_Fuelprice");
			Literal Diesel_Price = soln.getLiteral("?Diesel_Price");
			Literal Gas_Price= soln.getLiteral("?Gas_Price");
			if( Airline_Fuelprice != null )
			System.out.println("  " + Airline_Fuelprice.getString()+  "		   " + 
									  Diesel_Price.getString() + "		 " + 
									  Gas_Price.getString() );
			else
			System.out.println("Not found!");
		}
		System.out.println("");
		System.out.println("==================End of Query 7=====================");
		System.out.println("");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@* End Of Queries *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
	
	private void populateUSTransportationData() {
		_transporatation = ModelFactory.createOntologyModel();
		InputStream inTransportInstance =
		FileManager.get().open("US_Transportation.owl");
		_transporatation.read(inTransportInstance,defaultNameSpace);
		try {
			inTransportInstance.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private ResultSet runQuery(String queryRequest, Model model)
	{
		StringBuffer queryStr = new StringBuffer();
		ResultSet response = null;
		// Establish Prefixes
		//Set default Name space first
		queryStr.append("PREFIX base" + ": <" + defaultNameSpace + "> ");
		queryStr.append("PREFIX rdForeignVehicle_Sales" + ": <" +
		"http://www.w3.org/2000/01/rdf-schema#" + "> ");
		queryStr.append("PREFIX rdf" + ": <" + "http://www.w3.org/1999/02/22-rdf-syntax-ns#" + "> ");

		//Now add query
		queryStr.append(queryRequest);
		Query query = QueryFactory.create(queryStr.toString());
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		try
		{
			response = qexec.execSelect();
		}
		finally { }
		return response;
	}
	
	private ResultSet vehicleSales(Model model)
	{
	return runQuery(" select DISTINCT ?Monthly_Sales ?ForeignVehicle_Sales ?LightWV_Sales where{" +
			"?VS rdf:type base:Vehicle_Sales." +
			"?VS base:Foreign_Vehicles_Sales ?ForeignVehicle_Sales." +
			"?VS base:Lightweight_Vehicles_Sales ?LightWV_Sales." +
			"?VS base:Monthly_Vehicle_Sales ?Monthly_Sales.}", model); 
	}
	
	private ResultSet fatalites(Model model)
	{
	return runQuery(" select DISTINCT ?Bicyclists ?Pedestrians ?Motorcyclists ?Total_Road_Fatalities where{" +
			"?FT rdf:type base:Fatalities." +
			"?FT base:Bicyclists ?Bicyclists." +
			"?FT base:Pedestrians ?Pedestrians." +
			"?FT base:Motorcyclists ?Motorcyclists."+
			"?FT base:Total_Road_Fatalities ?Total_Road_Fatalities.}", model); 
	}
	
	private ResultSet Aviation_Records(Model model)
	{
	return runQuery(" select DISTINCT ?MonthlyCancelled_Flights ?MonthlyOnTime_Arrivals " +
			"?NumberOf_Airports ?MonthlyLate_Arrivals ?Monthly_Passengers where{" +
			"?AR rdf:type base:Aviation_Records." +
			"?AR base:Monthly_Cancelled_Flights ?MonthlyCancelled_Flights." +
			"?AR base:Monthly_On_Time_Arrivals ?MonthlyOnTime_Arrivals." +
			"?AR base:Number_of_Airports ?NumberOf_Airports."+
			"?AR base:Monthly_Late_Arrivals ?MonthlyLate_Arrivals."+
			"?AR base:Monthly_Passangers ?Monthly_Passengers}", model); 
	}
	
	private ResultSet Airline_data(Model model)
	{
	return runQuery(" select DISTINCT ?PassengerTravelled_Miles ?Mon_Passengers ?Num_Airports where{" +
			"?ARD rdf:type base:Airlines." +
			"?ARD base:Passenger_Travelled_Miles ?PassengerTravelled_Miles." +
			"?ARD base:has ?AR." +
			"?AR base:Monthly_Passangers ?Mon_Passengers."+
			"?AR base:Number_of_Airports ?Num_Airports.}", model); 
	}
	
	private ResultSet Passenger_Travelled_Miles(Model model)
	{
	return runQuery(" select (AVG(?Passengers_Using_Bus) AS ?Passenger_Using_Bus) (AVG(?Passengers_Using_Motorcycle) AS ?Passenger_Using_Motorcycle)  where{" +
			"{?ARD rdf:type base:Bus." +
			"?ARD base:Passenger_Travelled_Miles ?Passengers_Using_Bus.}"+
			"{?AR rdf:type base:Motorcycle." +
			"?AR base:Passenger_Travelled_Miles ?Passengers_Using_Motorcycle.}}", model); 
	}
	
	private ResultSet MinMax_MonthlyVehicleSales(Model model)
	{
	return runQuery("select (MAX(?vehicle_sales) AS ?max_vehicle_sales) (MIN(?vehicle_sales) AS ?min_vehicle_sales)where{" +
			"?ARD rdf:type base:Vehicle_Sales." +
			"?ARD base:Monthly_Vehicle_Sales ?vehicle_sales.}", model); 
	}
	
	private ResultSet Fuel_Price(Model model)
	{
	return runQuery(" select ?Airline_Fuelprice ?Diesel_Price ?Gas_Price where{" +
			"?ARD rdf:type base:Fuel_Price." +
			"?ARD base:Airline_Fuel_Price ?Airline_Fuelprice." +
			"?ARD base:Retail_Diesel_Price ?Diesel_Price." +
			"?ARD base:Retail_Gas_Price ?Gas_Price.}" +
			"ORDER BY DESC(?Airline_Fuelprice)", model); 
	}
}
