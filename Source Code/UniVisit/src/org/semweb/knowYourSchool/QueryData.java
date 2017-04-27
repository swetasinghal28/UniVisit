
package org.semweb.knowYourSchool;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jena.util.FileManager;
import java.io.IOException;
import java.io.InputStream;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.query.Query;  
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class QueryData {
	Model model = (Model) ModelFactory.createDefaultModel();
	Model modelRes = (Model) ModelFactory.createDefaultModel();
	Model modelCri = (Model) ModelFactory.createDefaultModel();
	Model modelWea = (Model) ModelFactory.createDefaultModel();
	
	Map<Integer, List<String>> result = new HashMap<Integer, List<String>>();
	//    Model modelRes = (Model) ModelFactory.createDefaultModel();
	//    Model modelCri = (Model) ModelFactory.createDefaultModel();
	//    Model modelWea = (Model) ModelFactory.createDefaultModel();

	public QueryData() {
		// TODO Auto-generated constructor stub
		try {
			//model.read(new FileInputStream("know-your-school.ttl"),null,"TTL");
			model.read(new FileInputStream("/Users/swetasinghal28/Documents/ASU/Fall2016/Semantic Web/Assignment/Assignment5/UniVisit/src/UnversityFinal.ttl"),null,"TTL");
			modelRes.read(new FileInputStream("/Users/swetasinghal28/Documents/ASU/Fall2016/Semantic Web/Assignment/Assignment5/UniVisit/src/Restaurant.ttl"),null,"TTL");
			modelCri.read(new FileInputStream("/Users/swetasinghal28/Documents/ASU/Fall2016/Semantic Web/Assignment/Assignment5/UniVisit/src/crimedatasetrdf.ttl"),null,"TTL");
			modelWea.read(new FileInputStream("/Users/swetasinghal28/Documents/ASU/Fall2016/Semantic Web/Assignment/Assignment5/UniVisit/src/Weather.ttl"),null,"TTL");
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		}
	}

	//	public void readModel(){
	//    	try {
	//    		model.read(new FileInputStream("/know-your-school.ttl"),null,"TTL");
	//            //model.read(new FileInputStream("Ontologies/University.ttl"),null,"TTL");
	////            modelRes.read(new FileInputStream("Ontologies/Restaurant.ttl"),null,"TTL");
	////            modelCri.read(new FileInputStream("Ontologies/Crime.ttl"),null,"TTL");
	////            modelWea.read(new FileInputStream("Ontologies/Weather.ttl"),null,"TTL");
	//        } catch (FileNotFoundException e) { 
	//            e.printStackTrace();
	//        }
	//    }
	
	public Map<Integer, List<String>> demoQuery(String s){
		result.clear();
		int count = 1;
		String queryString = "PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#> PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#> SELECT * WHERE {?university uni:hasPlace ?City.  ?university uni:hasName ?Name.  OPTIONAL {    ?university               uni:hasId ?id }.OPTIONAL {                ?university              uni:hasAddress ?instAddress}.OPTIONAL {       ?university             uni:hasHead ?head }.OPTIONAL {          ?university            uni:hasLongitude ?longitude }.OPTIONAL {                ?university           uni:hasLatitude ?latitude }.OPTIONAL {                   ?university         uni:hasContact ?contact}.OPTIONAL { ?contact uni:hasApplicationURL ?applicationURL}.OPTIONAL { ?contact         uni:hasFax ?fax}.OPTIONAL { ?contact       uni:hasWebsite ?website}.OPTIONAL { ?contact       uni:hasPhone ?phone}.OPTIONAL { ?head uni:hasPerson ?person}.OPTIONAL { ?head uni:hasTitle ?title}.OPTIONAL {  ?instAddress uni:hasStateCode ?statecode}.OPTIONAL {  ?instAddress uni:hasZip ?zip}.OPTIONAL {  ?instAddress uni:hasStreetAddress ?streetaddress}.FILTER(?Name = '"
				+ s + "') }";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);

		//System.out.println("query executed  ");
		try
		{


			List<String> uniName = new ArrayList<String>();
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				List<String> resDetails = new ArrayList<String>();

				String city = soln.get("?City").toString();
				String university = soln.get("?university").toString();
				String phone = soln.get("?phone").toString();
				String fax = soln.get("?fax").toString();
				String website = soln.get("?website").toString();
				String streetaddress = soln.get("?streetaddress").toString();
				String zip = soln.get("?zip").toString();
				String statecode = soln.get("?statecode").toString();
				String title = soln.get("?title").toString();
				String person = soln.get("?person").toString();
				//String applicationURL = soln.get("?applicationURL").toString();

				System.out.println("city uri" + city);
				QueryData q = new QueryData();
				result = q.resQuery(city);
				result = q.weatherQuery(city);
				result = q.crimeQuery(university);
				uniName.add(s);
				uniName.add("phone: " + phone);
				uniName.add("fax: " + fax);
				uniName.add("website: " + website);
				uniName.add("Address: " + streetaddress + statecode + zip);
				uniName.add("Head of university: " + title + person);
				//uniName.add("Application URL: " + applicationURL);
				
				result.put(8, uniName);

				System.out.println("back in demo query" );

			}
			System.out.println("testing result inside demo query"+ result.get(1) );
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	
	public Map<Integer, List<String>> restaurantQuery(String s){
		result.clear();
		int count = 1;
		String queryString = "PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#> PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#> SELECT * WHERE {?university uni:hasPlace ?City.  ?university uni:hasName ?Name.  OPTIONAL {    ?university               uni:hasId ?id }.OPTIONAL {                ?university              uni:hasAddress ?instAddress}.OPTIONAL {       ?university             uni:hasHead ?head }.OPTIONAL {          ?university            uni:hasLongitude ?longitude }.OPTIONAL {                ?university           uni:hasLatitude ?latitude }.OPTIONAL {                   ?university         uni:hasContact ?contact}.OPTIONAL { ?contact uni:hasApplicationURL ?applicationURL}.OPTIONAL { ?contact         uni:hasFax ?fax}.OPTIONAL { ?contact       uni:hasWebsite ?website}.OPTIONAL { ?contact       uni:hasPhone ?phone}.OPTIONAL { ?head uni:hasPerson ?person}.OPTIONAL { ?head uni:hasTitle ?title}.OPTIONAL {  ?instAddress uni:hasStateCode ?statecode}.OPTIONAL {  ?instAddress uni:hasZip ?zip}.OPTIONAL {  ?instAddress uni:hasStreetAddress ?streetaddress}.FILTER(?Name = '"
				+ s + "') }";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);

		//System.out.println("query executed  ");
		try
		{


			List<String> uniName = new ArrayList<String>();
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();

				String city = soln.get("?City").toString();

				System.out.println("city uri" + city);
				QueryData q = new QueryData();
				result = q.resQuery(city);
				//uniName.add("Application URL: " + applicationURL);
				

				System.out.println("back in demo query" );

			}
			System.out.println("testing result inside demo query"+ result.get(1) );
			return result;
		}
		finally {
			qexec.close();
		} 
	}


	

	public Map<Integer, List<String>> resQuery(String s){
		//result.clear();
		int count = 1;
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#> PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#> SELECT ?resName ?rating ?rcount ?phone WHERE { " + " <" + s + "> "+ " uni:hasRestaurants ?Res. ?Res uni:hasName ?resName. ?Res uni:hasRating ?rating. ?Res uni:hasReviewCount ?rcount. ?Res uni:hasPhone ?phone.  }";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelRes);

		//System.out.println("query executed  ");
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				System.out.println("Inside while of resQuery");
				QuerySolution soln = results.nextSolution();
				List<String> resDetails = new ArrayList<String>();

				String resName = soln.get("?resName").toString();
				String rating = soln.get("?rating").toString();
				String rcount = soln.get("?rcount").toString();
				String phone = soln.get("?phone").toString();

				System.out.println("ResQuery Count" + count + " "+resName + " "+ rating + " "+ rcount + " "+ phone);

				//?resName ?rating ?rcount ?phone
				resDetails.add(resName);
				resDetails.add(rating);
				resDetails.add(rcount);
				resDetails.add(phone);
				result.put(count, resDetails);
				count ++;

			}
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	
	public Map<Integer, List<String>> weatherQuery(String s){
		//result.clear();
		//int count = 1;
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#> PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#> SELECT * WHERE { " + " <" + s + "> "+ " uni:hasWeather ?weather.?weather uni:hasPressure ?pressure.?weather uni:hasRain ?rain.?weather uni:hasClouds ?clouds.?weather uni:hasHumidity ?humidity.?weather uni:hasTemp ?temp.?temp uni:hasMinTemp ?mintemp.?temp uni:hasAvgTemp ?avgtemp.?temp uni:hasMaxTemp ?maxtemp. }";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelWea);

		//System.out.println("query executed  ");
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				System.out.println("Inside weather");
				QuerySolution soln = results.nextSolution();
				List<String> resDetails = new ArrayList<String>();

				String pressure = soln.get("?pressure").toString();
				String rain = soln.get("?rain").toString();
				String clouds = soln.get("?clouds").toString();
				String humidity = soln.get("?humidity").toString();
				String mintemp = soln.get("?mintemp").toString();
				String maxtemp = soln.get("?maxtemp").toString();
				String avgtemp = soln.get("?avgtemp").toString();

				System.out.println("Average Temperature" + avgtemp);
				resDetails.add("Average Temp: " + avgtemp);
				resDetails.add("Maximum Temp: " + maxtemp);
				resDetails.add("Minimum Temp: " + mintemp);
				resDetails.add("Pressure: " + pressure);
				resDetails.add("Rain: " + rain);
				resDetails.add("Clouds: " + clouds);
				resDetails.add("Humidity: " + humidity);
				
				result.put(6, resDetails);

			}
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	
	public Map<Integer, List<String>> crimeQuery(String s){
		//result.clear();
		//int count = 1;
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#> PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#> SELECT * { " + " <" + s + "> "+ " uni:hasBranch ?branch. ?branch  uni:hasName  ?branchname.?branch  uni:hasOnCampusCrime  ?oncampuscrime.?branch  uni:hasCrimeReports  ?crimereports.?branch  uni:hasResiHallCrime  ?resihall.?branch  uni:hasOnCampusHate  ?oncampushate.?branch  uni:hasPublic_PropCrime  ?publicpropertycrime. }";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelCri);

		//System.out.println("query executed  ");
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				System.out.println("Inside crime");
				QuerySolution soln = results.nextSolution();
				List<String> resDetails = new ArrayList<String>();

				String oncampuscrime = soln.get("?oncampuscrime").toString();
				String crimereports = soln.get("?crimereports").toString();
				String resihall = soln.get("?resihall").toString();
				String oncampushate = soln.get("?oncampushate").toString();
				String publicpropertycrime = soln.get("?publicpropertycrime").toString();

				System.out.println("Crime Data" + publicpropertycrime);
				resDetails.add("On campus crime: " + oncampuscrime);
				resDetails.add("Crime Reports: " + crimereports);
				resDetails.add("Resi hall: " + resihall);
				resDetails.add("On campus hate: " + oncampushate);
				resDetails.add("Public Property crime: " + publicpropertycrime);
				result.put(7, resDetails);

			}
			return result;
		}
		finally {
			qexec.close();
		} 

	}

	public List<String> uniTest(String s)
	{
		String queryString2 = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#> PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>SELECT * WHERE {?place uni:hasName ?city.OPTIONAL  {?university uni:hasPlace ?place}.OPTIONAL  {?university uni:hasName ?name}.OPTIONAL   {?university uni:hasContact ?contact}.OPTIONAL   {?contact uni:hasWebsite ?web}.FILTER(?city = '"+ s +"') }";
		System.out.println("\nInstitutes in "+s);


		Query query = QueryFactory.create(queryString2);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		try
		{
			System.out.println("Inside");
			System.out.println("Query string: " + s);
			ResultSet results = qexec.execSelect();
			List<String> myList = new ArrayList<String>();
			while (results.hasNext()) {

				System.out.println("Inside while");
				QuerySolution soln = results.nextSolution();

				String cityName = soln.get("city").toString();
				System.out.println(cityName);

				String uniName = soln.get("name").toString();
				System.out.println(uniName);

				String uniContact = soln.get("contact").toString();
				System.out.println(uniContact);


				String uniWebURL = soln.get("web").toString();
				System.out.println(uniWebURL);

				myList.add(cityName);
				myList.add(uniName);
				myList.add(uniContact);
				myList.add(uniWebURL);
			}
			System.out.println("returning");
			return myList;
		}
		finally {

			System.out.println("Outside");

			qexec.close();
		}
	}
	
	public String customQuery(String s){
		//result.clear();
		//int count = 1;
		String queryString = s;
				
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		QuerySolution soln = null;

		//System.out.println("query executed  ");
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				System.out.println("Inside custom query");
				soln = results.nextSolution();
				System.out.println("results: " + results);
				System.out.println("Soln: " + soln.toString());
				System.out.println("qexec: " + qexec);
				

			}
			return soln.toString();
		}
		catch (Exception ex){
			
			String message = ex.getMessage();
			System.out.println("Exception " + message);
			return message;
		}
		finally {
			qexec.close();
		} 

	}
	
	/**
	 * 10 universities with least public property crime
	 * */
	public Map<Integer, List<String>> leastPublicProp(){
		result.clear();
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
				"PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
				"SELECT DISTINCT ?university ?branchName WHERE {?branch uni:hasPublic_PropCrime ?publicPropCrime."+
				"?branch uni:hasName ?branchName."+
				"?university uni:hasBranch ?branch.}"+
				"ORDERBY ASC(?publicPropCrime)"+
				"LIMIT 10";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelCri);

		//System.out.println("query executed  ");
		List<String> branchName = new ArrayList<String>();
		List<String> uniUri = new ArrayList<String>();
		List<String> uniName = new ArrayList<String>();
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String branch = soln.get("?branchName").toString();
				String university = soln.get("?university").toString();

				uniUri.add(university);
				branchName.add(branch);
		}
			
			QueryData q = new QueryData();
			uniName = q.getUniName(uniUri);
	        //System.out.println("in querydata" + uniName.size());
			result.put(1, uniName);
			result.put(2, branchName);
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	
	/**
	 * 10 universities with most public property crime
	 * */
	
	public Map<Integer, List<String>> mostPublicProp(){
		result.clear();
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
				"PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
				"SELECT DISTINCT ?university ?branchName WHERE {?branch uni:hasPublic_PropCrime ?publicPropCrime."+
				"?branch uni:hasName ?branchName."+
				"?university uni:hasBranch ?branch.}"+
				"ORDERBY DESC(?publicPropCrime)"+
				"LIMIT 10";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelCri);

		//System.out.println("query executed  ");
		List<String> branchName = new ArrayList<String>();
		List<String> uniUri = new ArrayList<String>();
		List<String> uniName = new ArrayList<String>();
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String branch = soln.get("?branchName").toString();
				String university = soln.get("?university").toString();

				uniUri.add(university);
				branchName.add(branch);
		}
			
			QueryData q = new QueryData();
			uniName = q.getUniName(uniUri);
	        //System.out.println("in querydata" + uniName.size());
			result.put(1, uniName);
			result.put(2, branchName);
			return result;
		}
		finally {
			qexec.close();
		} 
	}
	
	/**
	 * 10 universities with least campus hate
	 * */
	
	public Map<Integer, List<String>> leastCampusHate(){
		result.clear();
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
				"PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
				"SELECT DISTINCT ?university ?branchName WHERE {?branch uni:hasOnCampusHate ?hate."+
				"?branch uni:hasName ?branchName."+
				"?university uni:hasBranch ?branch.}"+
				"ORDERBY ASC(?hate)"+
				"LIMIT 10";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelCri);

		//System.out.println("query executed  ");
		List<String> branchName = new ArrayList<String>();
		List<String> uniUri = new ArrayList<String>();
		List<String> uniName = new ArrayList<String>();
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String branch = soln.get("?branchName").toString();
				String university = soln.get("?university").toString();

				uniUri.add(university);
				branchName.add(branch);
		}
			
			QueryData q = new QueryData();
			uniName = q.getUniName(uniUri);
	        //System.out.println("in querydata" + uniName.size());
			result.put(1, uniName);
			result.put(2, branchName);
			return result;
		}
		finally {
			qexec.close();
		} 
	}
	
	/**
	 * 10 universities with highest campus hate
	 * */
	
	public Map<Integer, List<String>> mostCampusHate(){
		result.clear();
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
				"PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
				"SELECT DISTINCT ?university ?branchName WHERE {?branch uni:hasOnCampusHate ?hate."+
				"?branch uni:hasName ?branchName."+
				"?university uni:hasBranch ?branch.}"+
				"ORDERBY DESC(?hate)"+
				"LIMIT 10";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelCri);

		//System.out.println("query executed  ");
		List<String> branchName = new ArrayList<String>();
		List<String> uniUri = new ArrayList<String>();
		List<String> uniName = new ArrayList<String>();
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String branch = soln.get("?branchName").toString();
				String university = soln.get("?university").toString();

				uniUri.add(university);
				branchName.add(branch);
		}
			
			QueryData q = new QueryData();
			uniName = q.getUniName(uniUri);
	        //System.out.println("in querydata" + uniName.size());
			result.put(1, uniName);
			result.put(2, branchName);
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	
	/**
	 * 10 universities with most Residence hall crime
	 * */
	
	public Map<Integer, List<String>> mostResiHall(){
		result.clear();
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
				"PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
				"SELECT DISTINCT ?university ?branchName WHERE {?branch uni:hasResiHallCrime ?resi."+
				"?branch uni:hasName ?branchName."+
				"?university uni:hasBranch ?branch.}"+
				"ORDERBY DESC(?resi)"+
				"LIMIT 10";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelCri);

		//System.out.println("query executed  ");
		List<String> branchName = new ArrayList<String>();
		List<String> uniUri = new ArrayList<String>();
		List<String> uniName = new ArrayList<String>();
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String branch = soln.get("?branchName").toString();
				String university = soln.get("?university").toString();

				uniUri.add(university);
				branchName.add(branch);
		}
			
			QueryData q = new QueryData();
			uniName = q.getUniName(uniUri);
	        //System.out.println("in querydata" + uniName.size());
			result.put(1, uniName);
			result.put(2, branchName);
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	
	/**
	 * 10 universities with least Residence Hall Crime
	 * */
	
	public Map<Integer, List<String>> leastResiHall(){
		result.clear();
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
				"PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
				"SELECT DISTINCT ?university ?branchName WHERE {?branch uni:hasResiHallCrime ?resi."+
				"?branch uni:hasName ?branchName."+
				"?university uni:hasBranch ?branch.}"+
				"ORDERBY ASC(?resi)"+
				"LIMIT 10";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelCri);

		//System.out.println("query executed  ");
		List<String> branchName = new ArrayList<String>();
		List<String> uniUri = new ArrayList<String>();
		List<String> uniName = new ArrayList<String>();
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String branch = soln.get("?branchName").toString();
				String university = soln.get("?university").toString();

				uniUri.add(university);
				branchName.add(branch);
		}
			
			QueryData q = new QueryData();
			uniName = q.getUniName(uniUri);
	        //System.out.println("in querydata" + uniName.size());
			result.put(1, uniName);
			result.put(2, branchName);
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	
	/**
	 * 10 universities with most On campus crime
	 * */
	
	public Map<Integer, List<String>> mostCampusCrime(){
		result.clear();
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
				"PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
				"SELECT DISTINCT ?university ?branchName WHERE {?branch uni:hasOnCampusCrime ?crime."+
				"?branch uni:hasName ?branchName."+
				"?university uni:hasBranch ?branch.}"+
				"ORDERBY DESC(?crime)"+
				"LIMIT 10";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelCri);

		//System.out.println("query executed  ");
		List<String> branchName = new ArrayList<String>();
		List<String> uniUri = new ArrayList<String>();
		List<String> uniName = new ArrayList<String>();
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String branch = soln.get("?branchName").toString();
				String university = soln.get("?university").toString();

				uniUri.add(university);
				branchName.add(branch);
		}
			
			QueryData q = new QueryData();
			uniName = q.getUniName(uniUri);
	        //System.out.println("in querydata" + uniName.size());
			result.put(1, uniName);
			result.put(2, branchName);
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	
	/**
	 * 10 universities with least On campus crime
	 * */
	
	public Map<Integer, List<String>> leastCampusCrime(){
		result.clear();
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
				"PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
				"SELECT DISTINCT ?university ?branchName WHERE {?branch  uni:hasOnCampusCrime ?crime."+
				"?branch uni:hasName ?branchName."+
				"?university uni:hasBranch ?branch.}"+
				"ORDERBY ASC(?crime)"+
				"LIMIT 10";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelCri);

		//System.out.println("query executed  ");
		List<String> branchName = new ArrayList<String>();
		List<String> uniUri = new ArrayList<String>();
		List<String> uniName = new ArrayList<String>();
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String branch = soln.get("?branchName").toString();
				String university = soln.get("?university").toString();

				uniUri.add(university);
				branchName.add(branch);
		}
			
			QueryData q = new QueryData();
			uniName = q.getUniName(uniUri);
	        //System.out.println("in querydata" + uniName.size());
			result.put(1, uniName);
			result.put(2, branchName);
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	
	/**
	 * 10 universities with least On campus crime reports
	 * */
	
	public Map<Integer, List<String>> leastCrimeReports(){
		result.clear();
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
				"PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
				"SELECT DISTINCT ?university ?branchName WHERE {?branch uni:hasCrimeReports ?reports."+
				"?branch uni:hasName ?branchName."+
				"?university uni:hasBranch ?branch.}"+
				"ORDERBY ASC(?reports)"+
				"LIMIT 10";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelCri);

		//System.out.println("query executed  ");
		List<String> branchName = new ArrayList<String>();
		List<String> uniUri = new ArrayList<String>();
		List<String> uniName = new ArrayList<String>();
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String branch = soln.get("?branchName").toString();
				String university = soln.get("?university").toString();

				uniUri.add(university);
				branchName.add(branch);
		}
			
			QueryData q = new QueryData();
			uniName = q.getUniName(uniUri);
	        //System.out.println("in querydata" + uniName.size());
			result.put(1, uniName);
			result.put(2, branchName);
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	
	/**
	 * 10 universities with most On campus crime reports
	 * */
	
	public Map<Integer, List<String>> mostCrimeReports(){
		result.clear();
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
				"PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
				"SELECT DISTINCT ?university ?branchName WHERE {?branch uni:hasCrimeReports ?reports."+
				"?branch uni:hasName ?branchName."+
				"?university uni:hasBranch ?branch.}"+
				"ORDERBY DESC(?reports)"+
				"LIMIT 10";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelCri);

		//System.out.println("query executed  ");
		List<String> branchName = new ArrayList<String>();
		List<String> uniUri = new ArrayList<String>();
		List<String> uniName = new ArrayList<String>();
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String branch = soln.get("?branchName").toString();
				String university = soln.get("?university").toString();

				uniUri.add(university);
				branchName.add(branch);
		}
			
			QueryData q = new QueryData();
			uniName = q.getUniName(uniUri);
	        //System.out.println("in querydata" + uniName.size());
			result.put(1, uniName);
			result.put(2, branchName);
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	
	/**
	 * returns name of university given university uri
	 * */
	
	public List<String> getUniName(List<String> uniUri){
		//System.out.println("inside getuniname");

		List<String> uniName = new ArrayList<String>();
		String s;
		for(int i = 0; i < uniUri.size(); ++i){
			s = uniUri.get(i);
			System.out.println(s);
			String queryString = 
					"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
					"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
					"PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
					"SELECT ?uniName WHERE { "+" <" + s + "> "+" uni:hasName ?uniName.}";
	
			Query query = QueryFactory.create(queryString);
			QueryExecution qexec = QueryExecutionFactory.create(query, model);
			//System.out.println("query executed uni ");
			try
			{
				ResultSet results = qexec.execSelect();
				if (results.hasNext()) {
					QuerySolution soln = results.nextSolution();
					String uni = soln.get("?uniName").toString();
					uniName.add(uni);
				}
				else{
					uniName.add(s.substring(32));
				}
			}
			finally {
				qexec.close();
			} 
		}
		//System.out.println("testing result inside demo query" + uniName.size() + j);
		return uniName;
	}
	
	
	/**
	 * returns university with humidity less than h
	 * */
	
	public Map<Integer, List<String>> humidity(String h){
		result.clear();
		String queryString = 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#> SELECT ?city ?humid WHERE {?weather uni:hasHumidity ?humid. ?city uni:hasWeather ?weather. FILTER(?humid < '"+ h + "')} LIMIT 10";
						
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelWea);

		//System.out.println("query executed  ");
		List<String> humid = new ArrayList<String>();
		List<String> cityUri = new ArrayList<String>();
		List<List<String>> cityName = new ArrayList<List<String>>();
		List<String> uniName = new ArrayList<String>();
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String humidity = soln.get("?humid").toString();
				String city = soln.get("?city").toString();
				cityUri.add(city);
				humid.add(humidity);
		}
			
			QueryData q = new QueryData();
			cityName = q.getCityName(cityUri);
			uniName = q.getUniName(cityName.get(1));
	        //System.out.println("in querydata" + uniName.size());
			result.put(1, uniName);
			result.put(2, cityName.get(0));
			result.put(3, humid);
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	
	
	/**
	 * returns universities with city = s 
	 * */
	
	public Map<Integer, List<String>> cityQuery(String s){
		result.clear();
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
				"PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>"
				+ "SELECT * WHERE { ?university uni:hasPlace ?place."
				+ "?place uni:hasName ?city."
				+ "?university uni:hasName ?name."
				+ "OPTIONAL   {?university uni:hasContact ?contact}."
				+ "OPTIONAL   {?contact uni:hasWebsite ?web}."
				+ "OPTIONAL   {?contact uni:hasPhone ?phone}."
				+ "FILTER(?city = \""+ s + "\")}";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		
		List<String> uniName = new ArrayList<String>();
		List<String> web = new ArrayList<String>();
		List<String> phone = new ArrayList<String>();

		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String uni = soln.get("?name").toString();
				//String website = soln.get("?web").toString();
				//String num = soln.get("?phone").toString();
				uniName.add(uni);
				//web.add("Website: " + website);
				//phone.add("Phone: " + num);
			}
			
			result.put(1, uniName);
			//result.put(2, web);
			//result.put(3, phone);
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	
	/**
	 * returns universities with state = s
	 * */
	
	public Map<Integer, List<String>> stateQuery(String s){
		result.clear();
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
				"PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>"
				+ "SELECT * WHERE {?instAddress uni:hasStateCode ?state."
				+ "OPTIONAL  {?university uni:hasAddress ?instAddress}."
				+ "OPTIONAL  {?university uni:hasName ?name}."
				+ "OPTIONAL  {?university uni:hasContact ?contact}."
				+ "OPTIONAL  {?contact uni:hasWebsite ?web}."
				+ "OPTIONAL  {?contact uni:hasPhone ?phone}."
				+ "FILTER(?state = \""+ s + "\") }";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);

		//System.out.println("query executed  ");
		List<String> uniName = new ArrayList<String>();
		List<String> web = new ArrayList<String>();
		List<String> phone = new ArrayList<String>();

		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String uni = soln.get("?name").toString();
				//String website = soln.get("?web").toString();
				//String num = soln.get("?phone").toString();
				uniName.add(uni);
				//web.add("Website: " + website);
				//phone.add("Phone: " + num);
			}
			
			result.put(1, uniName);
			//result.put(2, web);
			//result.put(3, phone);
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	public float[] getUniLocation(String s){
        float [] ll = new float[2];
        
        String queryString = 
                "PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
                "PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
                "SELECT ?lat ?long WHERE {?university uni:hasName ?name."
                + "?university uni:hasLatitude ?lat."
                + "?university uni:hasLongitude ?long."
                + "FILTER(?name = \"" + s + "\") } LIMIT 1";
        
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        //System.out.println("query executed  ");
        try
        {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                //System.out.println("Demo query function");
                QuerySolution soln = results.nextSolution();
                ll[1] = Float.parseFloat(soln.get("?lat").toString());
                ll[0] = Float.parseFloat(soln.get("?long").toString());
            }
        }
        finally {
            qexec.close();
        } 
        return ll;
    }
    
    /**
     * returns universities in the vicinity of lat and long
     * */
    public Map<Integer, List<String>> vicinity(String s){
        result.clear();    
        QueryData q = new QueryData();
        float []ll = q.getUniLocation(s);
        float lon = ll[0];
        float lat = ll[1];
            
        String queryString = 
                "PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +
                "PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
                "SELECT ?name WHERE {?university uni:hasLongitude ?long."
                + "?university uni:hasLatitude ?lat."
                + "?university uni:hasName ?name."
                + "FILTER((xsd:float(?long) < "+(lon+2.0)+" && xsd:float(?long) > "+(lon-2.0)+") && (xsd:float(?lat) < "+(lat+2.0)+" && xsd:float(?lat) > "+(lat-2.0)+")) }";
        
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        //System.out.println("query executed  ");
        List<String> uniName = new ArrayList<String>();
        try
        {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                //System.out.println("Demo query function");
                QuerySolution soln = results.nextSolution();
                String uni = soln.get("?name").toString();
                uniName.add(uni);
            }
            
            result.put(1, uniName);
            return result;
        }
        finally {
            qexec.close();
        } 
    }
    
    /**
	 * returns universities given within temperature range
	 * */
	
	public Map<Integer, List<String>> tempRange(String min, String max){
		result.clear();
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#> "
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ "PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>"
				+ "SELECT ?city ?mintemp ?maxtemp WHERE {?weather uni:hasTemp ?temp."
				+ "?temp uni:hasMinTemp ?mintemp."
				+ "?temp uni:hasMaxTemp ?maxtemp."
				+ "?city uni:hasWeather ?weather."
				+ "FILTER(?mintemp > \""+min+"\" && ?maxtemp < \""+max+"\")}";

						
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelWea);

		//System.out.println("query executed  ");
		List<String> minTemp = new ArrayList<String>();
		List<String> maxTemp = new ArrayList<String>();
		List<String> cityUri = new ArrayList<String>();
		List<List<String>> cityName = new ArrayList<List<String>>();
		List<String> uniName = new ArrayList<String>();
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String minT = soln.get("?mintemp").toString();
				String maxT = soln.get("?maxtemp").toString();
				String city = soln.get("?city").toString();
				cityUri.add(city);
				minTemp.add(minT);
				maxTemp.add(maxT);
			}
			
			QueryData q = new QueryData();
			cityName = q.getCityName(cityUri);
			uniName = q.getUniName(cityName.get(1));
	        //System.out.println("in querydata" + uniName.size());
			result.put(1, uniName);
			result.put(2, cityName.get(0));
			result.put(3, minTemp);
			result.put(4, maxTemp);
			return result;
		}
		finally {
			qexec.close();
		} 
	}
	
	/**
	 * returns universities with average temp less than t 
	 * */
	
	public Map<Integer, List<String>> leastTemp(String t){
		result.clear();
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
				"PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
				"SELECT ?avgtemp ?city WHERE {?temp uni:hasAvgTemp ?avgtemp." +
						"?weather uni:hasTemp ?temp."+
						"?city uni:hasWeather ?weather."+
						"FILTER(?avgtemp < \""+t+"\")}"+
						"ORDERBY ASC(?avgtemp)";
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelWea);

		//System.out.println("query executed  ");
		List<String> avgTemp = new ArrayList<String>();
		List<String> cityUri = new ArrayList<String>();
		List<List<String>> cityName = new ArrayList<List<String>>();
		List<String> uniName = new ArrayList<String>();
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String avgT = soln.get("?avgtemp").toString();
				String city = soln.get("?city").toString();
				cityUri.add(city);
				avgTemp.add(avgT);
			}
			
			QueryData q = new QueryData();
			cityName = q.getCityName(cityUri);
			uniName = q.getUniName(cityName.get(1));
	        //System.out.println("in querydata" + uniName.size());
			result.put(1, uniName);
			result.put(2, cityName.get(0));
			result.put(3, avgTemp);
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	
	/**
	 * returns universities with average temp greater than t 
	 * */
	
	public Map<Integer, List<String>> mostTemp(String t){
		result.clear();
		String queryString = 
				"PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
				"PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
				"SELECT ?avgtemp ?city WHERE {?temp uni:hasAvgTemp ?avgtemp." +
						"?weather uni:hasTemp ?temp."+
						"?city uni:hasWeather ?weather."+
						"FILTER(?avgtemp > \"" + t + "\")}"+
						"ORDERBY DESC(?avgtemp)";
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, modelWea);

		//System.out.println("query executed  ");
		List<String> avgTemp = new ArrayList<String>();
		List<String> cityUri = new ArrayList<String>();
		List<List<String>> cityName = new ArrayList<List<String>>();
		List<String> uniName = new ArrayList<String>();
		try
		{
			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				//System.out.println("Demo query function");
				QuerySolution soln = results.nextSolution();
				String avgT = soln.get("?avgtemp").toString();
				String city = soln.get("?city").toString();
				cityUri.add(city);
				avgTemp.add(avgT);
			}
			
			QueryData q = new QueryData();
			cityName = q.getCityName(cityUri);
			uniName = q.getUniName(cityName.get(1));
	        //System.out.println("in querydata" + uniName.size());
			result.put(1, uniName);
			result.put(2, cityName.get(0));
			result.put(3, avgTemp);
			return result;
		}
		finally {
			qexec.close();
		} 

	}
	
	public List<List<String>> getCityName(List<String> cityUri){
        //System.out.println("inside getuniname");
        List<List<String>> cityName = new ArrayList<List<String>>();
        List<String> uniUri = new ArrayList<String>();
        List<String> cityn = new ArrayList<String>();
        String s;
        for(int i = 0; i < cityUri.size(); ++i){
            s = cityUri.get(i);
            System.out.println(s);
            String queryString = 
                    "PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#>"+ 
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
                    "PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#>" +
                    "SELECT ?cityName ?uni WHERE { ?uni uni:hasPlace <" + s + ">." +
                    " <" + s + "> uni:hasName ?cityName.}LIMIT 1";
    
            Query query = QueryFactory.create(queryString);
            QueryExecution qexec = QueryExecutionFactory.create(query, model);
            //System.out.println("query executed uni ");
            try
            {
                ResultSet results = qexec.execSelect();
                if (results.hasNext()) {
                    QuerySolution soln = results.nextSolution();
                    String city = soln.get("?cityName").toString();
                    String uni = soln.get("?uni").toString();
                    cityn.add(city);
                    uniUri.add(uni);
                }
            }
            finally {
                qexec.close();
            }
        }
        cityName.add(cityn);
        cityName.add(uniUri);
        //System.out.println("testing result inside demo query" + uniName.size() + j);
        return cityName;
    }


}