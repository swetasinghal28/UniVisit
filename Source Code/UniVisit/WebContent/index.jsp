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
        Slider Section Start
        ================================================== -->
        <section id="hero-area" >
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <div class="block wow fadeInUp" data-wow-delay=".3s">
                            
                            <!-- Slider -->
                            <section class="cd-intro">
                                <h1 class="wow fadeInUp animated cd-headline slide" data-wow-delay=".4s" >
                                <br>
                                <span class="cd-words-wrapper">
                                    <b class="is-visible">UnivisiT</b>
                                </span>
                                </h1>
                                </section> <!-- cd-intro -->
                                <!-- /.slider -->
                                <h2 class="wow fadeInUp animated" data-wow-delay=".6s" >
                                    This is project is intended to assist users who are visiting the college town. Researchers attending conference, enthusiasts attending game events , recruiters visiting for job fairs and of course students planning to know more about college town. The user can type in the name of the university and based on that will get information about the university, itâs website, contact information, crime statistics in that area, the weather conditions and the restaurants near by all at one place. Instead of searching separately, this website will give consolidated data about the college surrounding.
                                </h2>
                                <a class="btn-lines dark light wow fadeInUp animated smooth-scroll btn btn-default btn-green" data-wow-delay=".9s" href="#about" data-section="#about" >LET'S SEARCH</a>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </section><!--/#main-slider-->
            <!--
            ==================================================
            Slider Section Start
            ================================================== -->
            <section id="about" class ="about">
                <div class="container" style="min-height: 520px;">
                    <div class="wrapper">
                            <section class="cd-intro">
                                <h1 class="wow fadeInUp animated cd-headline slide" data-wow-delay=".4s" >
                                <br>
                                <span class="cd-words-wrapper">
                                    <b class="is-visible">LETS PLAN</b>
                                </span>
                                </h1>
                                <form class="searchForm" id="searchForm" method="post" action="Home">  
                      
                                         <input id="city" type="radio" name="uni" value="city">
                                         <label for="city">Search By City</label> <p> </p>
                                         <input id="state" type="radio" name="uni" value="state">
                                         <label for="state">Search By State</label><p> </p>
                                         <input id="university" type="radio" name="uni" value="university">
                                         <label for="university">Search By College</label><p> </p>
                                         <input id="vicinity" type="radio" name="uni" value="vicinity">
                                         <label for="vicinity">Search By Vicinity</label><p> </p>
                          
                          

                                <br>
                                <br>
                                <br>
                                <br>
              
                                    <input class="searchTerm"  type="text" id="search" name="search" placeholder="Search University" autocomplete="off"/>
                                    <input type="submit" class="searchBtn" id="submit" value="GO"/>
                                </form>
                                
                                  </section>
                                <br>
                                <br>
                    </div>
                </div>
            </section> <!-- /#about -->
            <!--
            ==================================================
            Portfolio Section Start
            ================================================== -->
            <section id="works" class="works">
                <div class="container">
                    <div class="section-heading">
                        <h1 class="title wow fadeInDown" data-wow-delay=".3s">You can also</h1>
                        <p class="wow fadeInDown" data-wow-delay=".5s">
                            Check Weather, Search Resturant and Check Crime Stats,
                        </p>
                    </div>
                        <div class="col-sm-4 col-xs-12">
                            <figure class="wow fadeInLeft animated" data-wow-duration="500ms" data-wow-delay="600ms">
                                <div class="img-wrapper">
                                    <img src="images/portfolio/climateimage.png" class="img-responsive" alt="" >
                                </div>
                                <figcaption>
                                <h4>
                                <a href="weather.jsp">
                                    Get Weather Stats
                                </a>
                                </h4>
                                </figcaption>
                            </figure>
                        </div>
                        <div class="col-sm-4 col-xs-12">
                            <figure class="wow fadeInLeft animated" data-wow-duration="500ms" data-wow-delay="900ms">
                                <div class="img-wrapper">
                                    <img src="images/portfolio/resturant.jpg" class="img-responsive" alt="" >
                                </div>
                                <figcaption>
                                <h4>
                                <a href="Rest.jsp">
                                    Search Resturant
                                </a>
                                </h4>
                                </figcaption>
                            </figure>
                        </div>

                        <div class="col-sm-4 col-xs-12">
                            <figure class="wow fadeInLeft animated" data-wow-duration="500ms" data-wow-delay="1200ms">
                                <div class="img-wrapper">
                                    <img src="images/portfolio/policecar.jpg" class="img-responsive" alt="" >
                                </div>
                                <figcaption>
                                <h4>
                                <a href="Crime.jsp">
                                    Get Crime Stats
                                </a>
                                </h4>
                                </figcaption>
                            </figure>
                        </div>
                    </div>
                </div>
            </section> <!-- #works -->
            <!--
            ==================================================
            Portfolio Section Start
            ================================================== -->
            <section id="feature">
                <div class="container">
                    <div class="section-heading">
                        <h1 class="title wow fadeInDown" data-wow-delay=".3s">Utilities</h1>
                        <p class="wow fadeInDown" data-wow-delay=".5s">
                            Reuse the application framework                        </p>
                    </div>
                    <div class="row">
                        <div class="col-md-4 col-lg-4 col-xs-12">
                            <div class="media wow fadeInUp animated" data-wow-duration="500ms" data-wow-delay="300ms">
                                <div class="media-left">
                                    <div class="icon">
                                        <i class="ion-ios-flask-outline"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    <h4 class="media-heading">   <a href="sparqEndpoint.jsp">SPARQ Endpoints</a></h4>
                                    <p>Use SPARQ endpoints in your application</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xs-12">
                            <div class="media wow fadeInDown animated" data-wow-duration="500ms" data-wow-delay="600ms">
                                <div class="media-left">
                                    <div class="icon">
                                        <i class="ion-ios-lightbulb-outline"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    <h4 class="media-heading">   <a href="SourceCode.html">Source Code</a></h4>
                                    <p>Complete source code for Data query , Scrapper and Application</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xs-12">
                            <div class="media wow fadeInDown animated" data-wow-duration="500ms" data-wow-delay="900ms">
                                <div class="media-left">
                                    <div class="icon">
                                        <i class="ion-ios-barcode-outline"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    <h4 class="media-heading">   <a href="https://www.w3.org/standards/semanticweb/">Learn About Semantic</a></h4>
                                    <p>Tutorial links to work with Semantic data</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section> <!-- /#feature -->    
        </body>
    </html>