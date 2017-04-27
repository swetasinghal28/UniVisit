
package org.semweb.knowYourSchool;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {


	public static void main(String[] args) {
		//System.out.println("running  ");
		String uni = "";
		QueryData obj = new QueryData();
		Map result = null;
		//obj.readModel();
		//obj.qAll(uni);
		//List<String> result1 = obj.uniTest("Tempe");
		//obj.demoQuery("American Institute of Technology");
		//String result = obj.customQuery("PREFIX rdf: <http://w3.org/1999/02/22-rdf-syntax-ns#> PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> PREFIX uni: <http://www.knowYourSchool.org/ontology/SchoolBio#> SELECT * WHERE {?university uni:hasPlace ?City.  ?university uni:hasName ?Name.  OPTIONAL {    ?university               uni:hasId ?id }.OPTIONAL {                ?university              uni:hasAddress ?instAddress}.OPTIONAL {       ?university             uni:hasHead ?head }.OPTIONAL {          ?university            uni:hasLongitude ?longitude }.OPTIONAL {                ?university           uni:hasLatitude ?latitude }.OPTIONAL {                   ?university         uni:hasContact ?contact}.OPTIONAL { ?contact uni:hasApplicationURL ?applicationURL}.OPTIONAL { ?contact         uni:hasFax ?fax}.OPTIONAL { ?contact       uni:hasWebsite ?website}.OPTIONAL { ?contact       uni:hasPhone ?phone}.OPTIONAL { ?head uni:hasPerson ?person}.OPTIONAL { ?head uni:hasTitle ?title}.OPTIONAL {  ?instAddress uni:hasStateCode ?statecode}.OPTIONAL {  ?instAddress uni:hasZip ?zip}.OPTIONAL {  ?instAddress uni:hasStreetAddress ?streetaddress}.FILTER(?Name = \"American Institute of Technology\") }");
		//result = obj.leastPublicProp();
		//result = obj.mostPublicProp();
		//result = obj.leastCampusHate();
		//result = obj.mostCampusHate();
		//result = obj.mostResiHall();
		//result = obj.leastResiHall();
		//result = obj.mostCampusCrime();
		//result = obj.leastCampusCrime();
		//result = obj.vicinity("American Institute of Technology");
		

		result = obj.tempRange("290", "300");
		

		//result = obj.stateQuery("AZ");

		
		
		
		System.out.println("Result :" + result );


		//System.out.println(result1[0].hasValue);


		System.out.println("end");	

	}

}