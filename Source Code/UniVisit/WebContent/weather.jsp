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
        <section class="global-page-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="block">
                        <h2>  Weather Details <h2>
                        </div>
                    </div>
                </div>
            </div>   
        </section>



        <!--/#Page header-->
        

        <center><H1>City with humidity</H1></center>
        <FORM ACTION="Home" METHOD="POST">
           <center>Less than</center>
           <center>
            <INPUT TYPE="TEXT" NAME="humidity_less">
            <BR>
            <INPUT TYPE="SUBMIT" name= "humidity_submit" value="Get University">
            </center>
        </FORM>

        <br>
        <br>
        <br>
        <br>


        <center><H1>City with Temperature</H1></center>
        <FORM ACTION="Home" METHOD="POST">
           <center> between</center>
           <center>
            <INPUT TYPE="TEXT" NAME="temp_less">
            <INPUT TYPE="TEXT" NAME="temp_more">
            <BR>
            <INPUT TYPE="SUBMIT" name= "temp_submit" value="Get University">
            </center>
        </FORM>

        <br>
        <br>
        <br>
        <br>

        <center><H1>City with Temperature </H1></center>
        <FORM ACTION="Home" METHOD="POST">
           <center>Less than</center>
           <center>
            <INPUT TYPE="TEXT" NAME="temp_single_less">
            <BR>
            <INPUT TYPE="SUBMIT" name= "temp_less_submit" value="Get University">
            </center>
        </FORM>

        <br>
        <br>
        <br>
        <br>

        <center><H1>City with Temperature</H1></center>
        <FORM ACTION="Home" METHOD="POST">
           <center>More than</center>
           <center>
            <INPUT TYPE="TEXT" NAME="temp_more_less">
            <BR>
            <INPUT TYPE="SUBMIT" name= "temp_more_submit" value="Get University">
            </center>
        </FORM>

        <br>
        <br>
        <br>
        <br>

                    </body>
                </html>
            </html>