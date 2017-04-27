package org.semweb.knowYourSchool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {

		super();
		/*_food = ModelFactory.createOntologyModel();
		_twitter = ModelFactory.createOntologyModel();*/
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (request.getParameter("search") != null) {
			if(request.getParameter("uni").equals("university")){
				String element = request.getParameter("search") ;
				element = element.trim();
				Map<Integer, List<String>> result = null;
				if (!element.isEmpty()){
					System.out.println("Inside Home, Query string: " + !element.isEmpty());
					ServletContext context = request.getSession().getServletContext();


					QueryData queryData = new QueryData();
					TweetsFeed tweets = new TweetsFeed();



					String tweetResult = null;
					try {
						result = queryData.demoQuery(element);
						result.putAll(tweets.getTwitterFeed(element));


						System.out.println("Back in Home class");
						System.out.println("testing" + result.get(7));
						request.setAttribute("result",result);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
				if (result != null){

					System.out.println("Result is null " + result.isEmpty());
					dispatcher = request.getServletContext().getRequestDispatcher("/data.jsp");

				}
				dispatcher.forward(request,response); 
			}
			else if (request.getParameter("uni").equals("city")){

				String element = request.getParameter("search") ;

				Map<Integer, List<String>> result = null;
				element = element.trim();
				if (!element.isEmpty()){
					System.out.println("Inside Home, Query string: " + element);
					ServletContext context = request.getSession().getServletContext();


					QueryData queryData = new QueryData();
					TweetsFeed tweets = new TweetsFeed();


					String tweetResult = null;
					try {
						result = queryData.cityQuery(element);
						result.putAll(tweets.getTwitterFeed(element));


						System.out.println("Back in Home class");
						System.out.println("testing city query " + result.get(7));
						request.setAttribute("result",result);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
				if (result != null){
					dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

				}
				dispatcher.forward(request,response); 
			}
			else if (request.getParameter("uni").equals("state")){
				String element = request.getParameter("search") ;
				Map<Integer, List<String>> result = null;
				element = element.trim();
				if (!element.isEmpty()){
					System.out.println("Inside Home, Query string: " + element);
					ServletContext context = request.getSession().getServletContext();


					QueryData queryData = new QueryData();
					TweetsFeed tweets = new TweetsFeed();


					String tweetResult = null;
					try {
						result = queryData.stateQuery(element);
						result.putAll(tweets.getTwitterFeed(element));


						System.out.println("Back in Home class");
						System.out.println("testing state query" + result.get(7));
						request.setAttribute("result",result);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
				if (result != null){
					dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

				}
				dispatcher.forward(request,response); 
			}

			else if (request.getParameter("uni").equals("vicinity")){
				String element = request.getParameter("search") ;
				Map<Integer, List<String>> result = null;
				element = element.trim();
				if (!element.isEmpty()){
					System.out.println("Inside Home, Query string: " + element);
					ServletContext context = request.getSession().getServletContext();


					QueryData queryData = new QueryData();
					TweetsFeed tweets = new TweetsFeed();


					String tweetResult = null;
					try {
						result = queryData.vicinity(element);
						result.putAll(tweets.getTwitterFeed(element));


						System.out.println("Back in Home class");
						System.out.println("testing state query" + result.get(7));
						request.setAttribute("result",result);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
				if (result != null){
					dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

				}
				dispatcher.forward(request,response); 
			}

		}


		else if (request.getParameter("querytext") != null) {
			String element = request.getParameter("querytext") ;
			String result = null;
			element = element.trim();
			if (!element.isEmpty()){
				System.out.println("Inside Home- Custom Query, Query string: " + element);
				ServletContext context = request.getSession().getServletContext();


				QueryData queryData = new QueryData();

				try {
					result = queryData.customQuery(element);

					System.out.println("Back in Home class");
					System.out.println("testing crime" + result);
					request.setAttribute("result",result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/sparqQueryResult.jsp");

			}
			dispatcher.forward(request,response);
		}
		else if (request.getParameter("high1") != null) {
			//String element = request.getParameter("querytext") ;

			System.out.println("Inside Home- Crime Query, Query string: ");
			ServletContext context = request.getSession().getServletContext();


			QueryData queryData = new QueryData();


			Map<Integer, List<String>> result = null;
			try {
				result = queryData.mostPublicProp();

				System.out.println("Back in Home class");
				System.out.println("testing" + result);
				request.setAttribute("result",result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

			}
			dispatcher.forward(request,response);
		}
		else if (request.getParameter("high2") != null) {
			//String element = request.getParameter("querytext") ;
			System.out.println("Inside Home- Crime Query, Query string: ");
			ServletContext context = request.getSession().getServletContext();


			QueryData queryData = new QueryData();


			Map<Integer, List<String>> result = null;
			try {
				result = queryData.mostResiHall();

				System.out.println("Back in Home class");
				System.out.println("testing" + result);
				request.setAttribute("result",result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

			}
			dispatcher.forward(request,response);
		}
		else if (request.getParameter("high3") != null) {
			//String element = request.getParameter("querytext") ;
			System.out.println("Inside Home- Crime Query, Query string: ");
			ServletContext context = request.getSession().getServletContext();


			QueryData queryData = new QueryData();


			Map<Integer, List<String>> result = null;
			try {
				result = queryData.mostCampusCrime();

				System.out.println("Back in Home class");
				System.out.println("testing" + result);
				request.setAttribute("result",result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

			}
			dispatcher.forward(request,response);
		}
		else if (request.getParameter("high4") != null) {
			//String element = request.getParameter("querytext") ;
			System.out.println("Inside Home- Crime Query, Query string: ");
			ServletContext context = request.getSession().getServletContext();


			QueryData queryData = new QueryData();


			Map<Integer, List<String>> result = null;
			try {
				result = queryData.mostCrimeReports();

				System.out.println("Back in Home class");
				System.out.println("testing" + result);
				request.setAttribute("result",result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

			}
			dispatcher.forward(request,response);
		}
		else if (request.getParameter("high5") != null) {
			//String element = request.getParameter("querytext") ;
			System.out.println("Inside Home- Crime Query, Query string: ");
			ServletContext context = request.getSession().getServletContext();


			QueryData queryData = new QueryData();


			Map<Integer, List<String>> result = null;
			try {
				result = queryData.mostCampusHate();

				System.out.println("Back in Home class");
				System.out.println("testing" + result);
				request.setAttribute("result",result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

			}
			dispatcher.forward(request,response);
		}

		else if (request.getParameter("low1") != null) {
			//String element = request.getParameter("querytext") ;
			System.out.println("Inside Home- Crime Query, Query string: ");
			ServletContext context = request.getSession().getServletContext();


			QueryData queryData = new QueryData();


			Map<Integer, List<String>> result = null;
			try {
				result = queryData.leastPublicProp();

				System.out.println("Back in Home class");
				System.out.println("testing" + result);
				request.setAttribute("result",result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

			}
			dispatcher.forward(request,response);
		}
		else if (request.getParameter("low2") != null) {
			//String element = request.getParameter("querytext") ;
			System.out.println("Inside Home- Crime Query, Query string: ");
			ServletContext context = request.getSession().getServletContext();


			QueryData queryData = new QueryData();


			Map<Integer, List<String>> result = null;
			try {
				result = queryData.leastResiHall();

				System.out.println("Back in Home class");
				System.out.println("testing" + result);
				request.setAttribute("result",result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

			}
			dispatcher.forward(request,response);
		}
		else if (request.getParameter("low3") != null) {
			//String element = request.getParameter("querytext") ;
			System.out.println("Inside Home- Crime Query, Query string: ");
			ServletContext context = request.getSession().getServletContext();


			QueryData queryData = new QueryData();


			Map<Integer, List<String>> result = null;
			try {
				result = queryData.leastCampusCrime();

				System.out.println("Back in Home class");
				System.out.println("testing" + result);
				request.setAttribute("result",result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

			}
			dispatcher.forward(request,response);
		}
		else if (request.getParameter("low4") != null) {
			//String element = request.getParameter("querytext") ;
			System.out.println("Inside Home- Crime Query, Query string: ");
			ServletContext context = request.getSession().getServletContext();


			QueryData queryData = new QueryData();


			Map<Integer, List<String>> result = null;
			try {
				result = queryData.leastCrimeReports();

				System.out.println("Back in Home class");
				System.out.println("testing" + result);
				request.setAttribute("result",result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

			}
			dispatcher.forward(request,response);
		}
		else if (request.getParameter("low5") != null) {
			//String element = request.getParameter("querytext") ;
			System.out.println("Inside Home- Crime Query, Query string: ");
			ServletContext context = request.getSession().getServletContext();


			QueryData queryData = new QueryData();


			Map<Integer, List<String>> result = null;
			try {
				result = queryData.leastCampusHate();

				System.out.println("Back in Home class");
				System.out.println("testing" + result);
				request.setAttribute("result",result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

			}
			else{
				dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");
			}
			dispatcher.forward(request,response);
		}

		else if (request.getParameter("ressearch") != null) {

			String element = request.getParameter("ressearch") ;
			Map<Integer, List<String>> result = null;
			element = element.trim();
			if (!element.isEmpty()){
				System.out.println("Inside Home, res Query string: " + element);
				ServletContext context = request.getSession().getServletContext();


				QueryData queryData = new QueryData();
				//TweetsFeed tweets = new TweetsFeed();


				//String tweetResult = null;
				try {
					result = queryData.restaurantQuery(element);
					//result.putAll(tweets.getTwitterFeed(element));


					System.out.println("Back in Home class");
					System.out.println("testing" + result.get(7));
					request.setAttribute("result",result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/RestResult.jsp");

			}
			dispatcher.forward(request,response); 
		}

		else if (request.getParameter("humidity_less") != null) {
			String element = request.getParameter("humidity_less") ;
			Map<Integer, List<String>> result = null;
			element = element.trim();
			if (!element.isEmpty()){
				System.out.println("Inside Home, Query string: " + element);
				ServletContext context = request.getSession().getServletContext();


				QueryData queryData = new QueryData();
				//TweetsFeed tweets = new TweetsFeed();


				//String tweetResult = null;
				try {
					result = queryData.humidity(element);
					//result.putAll(tweets.getTwitterFeed(element));


					System.out.println("Back in Home class");
					System.out.println("testing" + result.get(7));
					request.setAttribute("result",result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

			}
			dispatcher.forward(request,response); 
		}
		else if (request.getParameter("temp_less") != null && request.getParameter("temp_more") != null) {
			String element1 = request.getParameter("temp_less") ;
			String element2 = request.getParameter("temp_more") ;
			Map<Integer, List<String>> result = null;
			element1 = element1.trim();
			element2 = element2.trim();
			if (!element1.isEmpty() && !element2.isEmpty()){
				System.out.println("Inside Home, Query string: " + element2);
				ServletContext context = request.getSession().getServletContext();


				QueryData queryData = new QueryData();
				//TweetsFeed tweets = new TweetsFeed();


				//String tweetResult = null;
				try {
					result = queryData.tempRange(element1, element2);
					//result.putAll(tweets.getTwitterFeed(element));


					System.out.println("Back in Home class");
					System.out.println("testing" + result.get(7));
					request.setAttribute("result",result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

			}
			dispatcher.forward(request,response); 
		}
		else if (request.getParameter("temp_single_less") != null) {
			String element = request.getParameter("temp_single_less") ;
			Map<Integer, List<String>> result = null;
			element = element.trim();
			if (!element.isEmpty()){
				System.out.println("Inside Home, Query string: " + element);
				ServletContext context = request.getSession().getServletContext();


				QueryData queryData = new QueryData();
				//TweetsFeed tweets = new TweetsFeed();


				//String tweetResult = null;
				try {
					result = queryData.leastTemp(element);
					//result.putAll(tweets.getTwitterFeed(element));


					System.out.println("Back in Home class");
					System.out.println("testing" + result.get(7));
					request.setAttribute("result",result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

			}
			dispatcher.forward(request,response); 
		}

		else if (request.getParameter("temp_more_less") != null) {
			String element = request.getParameter("temp_more_less") ;
			Map<Integer, List<String>> result = null;
			element = element.trim();
			if (!element.isEmpty()){
				System.out.println("Inside Home, Query string: " + element);
				ServletContext context = request.getSession().getServletContext();


				QueryData queryData = new QueryData();
				//TweetsFeed tweets = new TweetsFeed();


				//String tweetResult = null;
				try {
					result = queryData.mostTemp(element);
					//result.putAll(tweets.getTwitterFeed(element));


					System.out.println("Back in Home class");
					System.out.println("testing" + result.get(7));
					request.setAttribute("result",result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			if (result != null){
				dispatcher = request.getServletContext().getRequestDispatcher("/crimeResult.jsp");

			}
			dispatcher.forward(request,response); 
		}
		else
		{
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/404.html");
			dispatcher.forward(request,response); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
