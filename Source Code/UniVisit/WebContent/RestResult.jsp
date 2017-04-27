<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js">
	<%@ page import="java.util.*"%>
    <head>
        <!-- Basic Page Needs
        ================================================== -->
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="icon" type="image/png" href="images/logo.png">
        <title>UnivisiT</title>
        <meta name="description" content="University Surronding Search Page">
        <meta name="keywords" content="University resturants weather climate">
        <meta name="author" content="Team10 - WebSemantics">
        <!-- Mobile Specific Metas
        ================================================== -->
        <meta name="format-detection" content="telephone=no">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <!-- Template CSS Files
        ================================================== -->
        <!-- Twitter Bootstrs CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Ionicons Fonts Css -->
        <link rel="stylesheet" href="css/ionicons.min.css">
        <!-- animate css -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- Hero area slider css-->
        <link rel="stylesheet" href="css/slider.css">
        <!-- owl craousel css -->
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/owl.theme.css">
        <link rel="stylesheet" href="css/jquery.fancybox.css">a
        <!-- template main css file -->
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/test.css">
        <link rel="stylesheet" href="css/queryform.css">
        <!-- responsive css -->
        <link rel="stylesheet" href="css/responsive.css">

        <link rel="stylesheet" href="css/textsearch.css">
        
        <!-- Template Javascript Files
        ================================================== -->
        <!-- <!-- modernizr js -->
        <script src="js/vendor/modernizr-2.6.2.min.js"></script>
        jquery
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        owl carouserl js
        <script src="js/owl.carousel.min.js"></script>
        bootstrap js

        <script src="js/bootstrap.min.js"></script>
        wow js
        <script src="js/wow.min.js"></script>
        slider js
        <script src="js/slider.js"></script>
        <script src="js/jquery.fancybox.js"></script>
        template main js
        <script src="js/main.js"></script>

        <script src="js/textsearch.js"></script> -->
    </head>
    <body>
        <!--
        ==================================================
        Header Section Start
        ================================================== -->
        <header id="top-bar" class="navbar-fixed-top animated-header">
            <div class="container">
                <div class="navbar-header">
                    <!-- responsive nav button -->
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    </button>

                    
                    <!-- logo -->
                    <div class="navbar-brand">
                        <a href="index.jsp" >
                            <img src="images/logo.png" alt="">
                        </a>
                    </div>
                </div>
                <!-- main menu -->
                <nav class="collapse navbar-collapse navbar-right" role="navigation">
                    <div class="main-menu">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="index.jsp" >Home</a>
                            </li>
                           
                            <li>
                                <a href="sparqEndpoint.jsp">SPARQ Endpoint</a>

                            </li>
                            <li>
                                <a href="SourceCode.html">Source Code</a>
                           
                            </li>
                            
                             <li><a href="about.html">About</a></li>
                          
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
	<!--
        ==================================================
        Global Page Section Start
        ================================================== -->
	<%Map result = (Map)request.getAttribute("result");
					List<String> res1 = (List)result.get(1); 
					List<String> res2 = (List)result.get(2); 
					List<String> res3 = (List)result.get(3); 
					List<String> res4 = (List)result.get(4);
					List<String> res5 = (List)result.get(5);
					%>


	<!--/#Page header-->
	<section id="blog-full-width">
	
	<h2 class="wow fadeInUp animated cd-headline slide" data-wow-delay=".4s" >
                                <br>
                   <br>
                   <br>
                                </h2>
		<div class="container">
			<div class="row">
			
			
			<div class="col-xs-6 no-padding">
                                				<div class="features-table-free">
                                				<ul>
                                				<h1>Restaurant Name</h1>
                                				<li>
								<% out.println(res1.get(0)); %>
							</li>
							
							<li>
								<% out.println(res2.get(0) ); %>
							</li>
							
							<li>
										<% out.println(res3.get(0) ); %>							</li>
							
							<li>
											<% out.println(res4.get(0) ); %>							</li>
							
							<li>
												<% out.println(res5.get(0) ); %>							</li>
                                           		
                                           			</ul>	
                                				</div>
                                				</div>
                                				<div class="col-xs-6 no-padding">
                                				<div class="features-table-free">
                                				<ul>
                                				<h1>Details</h1>
                                				
                                				<li>
								<% out.println("\nRating:" + res1.get(1)  + "\nReviews:" + res1.get(2) + "\nPhone:" + res1.get(3) ); %>
							</li>
							
										<li>
								<% out.println("\nRating:" + res2.get(1)  + "\nReviews:" + res2.get(2) + "\nPhone:" + res2.get(3) ); %>
							</li>
							
										<li>
								<% out.println("\nRating:" + res3.get(1)  + "\nReviews:" + res3.get(2) + "\nPhone:" + res3.get(3) ); %>
							</li>
							
										<li>
								<% out.println("\nRating:" + res4.get(1)  + "\nReviews:" + res4.get(2) + "\nPhone:" + res4.get(3) ); %>
							</li>
							
										<li>
								<% out.println("\nRating:" + res5.get(1)  + "\nReviews:" + res5.get(2) + "\nPhone:" + res5.get(3) ); %>
							</li>
							
	
                                           		
                                           			</ul>
                                           				
                                				</div>
                                				</div>

			</div>
	</section>
	<!--
                    ==================================================
                    Call To Action Section Start
                    ================================================== -->
</body>
</html>
</html>