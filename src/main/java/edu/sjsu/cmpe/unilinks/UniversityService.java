package edu.sjsu.cmpe.unilinks;

//import edu.sjsu.cmpe.unilinks.resources.*;

import java.io.File;
//import java.io.FileWriter;
//import java.io.FileWriter;
//import java.io.OutputStreamWriter;
import java.io.StringWriter;
//import java.io.Writer;
import java.util.ArrayList;

import static spark.Spark.*;
import spark.*;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.List;
import java.util.Map;

import edu.sjsu.cmpe.unilinks.resources.UniversityObject;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class UniversityService
{
	public static void main(String[] args) 
	    {
		try{
			
			get(new Route("/unilinks") {
				Configuration cfg = new Configuration();
		          @Override
		          public Object handle(Request request, Response response){
		        	  
		        	  StringWriter file = null;
		        	  String queryParam = request.queryString();
		        	  String uname;
		        	  try{
		        		  file = new StringWriter();
		            	  cfg.setDirectoryForTemplateLoading(new File("templates"));
		                  // load template
		                  Template template = cfg.getTemplate("tables.ftl");    
		                  // data-model
		                  Map<String, Object> input = new HashMap<String, Object>(); 		
		                  // create list
		                  List<UniversityObject> universityObject = new ArrayList<UniversityObject>();
		                  input.put("Hello","Welcome to Unilinks");
		                  template.process(input,file);
		                  if(queryParam == null)
		            	  {        	  
		            	  System.out.println("null");
		            	  }
		            	 else
		            	 {
		            		 System.out.println(queryParam.substring((queryParam.indexOf("=")+1),queryParam.indexOf("&")));
		            		 uname = queryParam.substring((queryParam.indexOf("=")+1),queryParam.indexOf("&"));
		            		 String name = uname;
		            		 if(queryParam.contains("submit"))
		            		 {
		            			 if(name.toUpperCase().equals("SJSU"))
		            			 {
		            				 UniversityObject uo = new UniversityObject();
		            				 uo.setSchoolName("San Jose State University");
		            				 uo.setDepartment("Computer Science");
		            				 uo.setLocation("San Jose");
		            				 uo.setContact("Mr. ABCD");
		            				 uo.setGreScore(94);
		            				 uo.setIeltsScore(6.5);
		            				 uo.setToeflScore(110);	
		            				 uo.setTuitionFees("$12500");
		            				 uo.setFallApplnDate("12August2013");
		            				 uo.setSpringApplnDate("12Jan2013");
		            				 		            				 
		            				 universityObject.add(uo);
		            				 
		            			 }
		            			 if(name.toUpperCase().equals("ASU"))
		            			 {
		            				 UniversityObject uoone = new UniversityObject();
		            				 uoone.setSchoolName("Arizona State University");
		            				 uoone.setDepartment("Computer Science");
		            				 uoone.setLocation("Tempe, Arizona");
		            				 uoone.setContact("Mr. DEFG");
		            				 uoone.setGreScore(94);
		            				 uoone.setIeltsScore(6.5);
		            				 uoone.setToeflScore(110);	
		            				 uoone.setTuitionFees("$23000");
		            				 uoone.setFallApplnDate("13Aug2014");
		            				 uoone.setSpringApplnDate("12Jan2014");
		            				 
		            				 universityObject.add(uoone);
		            				 
		            			 }
		            			 
		            			 input.put("universityObject",universityObject );
		                         template.process(input, file);
		            		 }
		            	 }
		                  
		                  
		        	  }catch(Exception e){System.out.print(e.getMessage());}
		        	  
		        	  return file;
		          }
				
			});
			
		}catch(Exception e){System.out.println(e.getMessage());}
           
	    }
	
}


