<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- Mobile Specific Meta -->
<!--        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">-->
    <!-- Favicon-->
    <link rel="shortcut icon" href="img/fav.png">
    <!-- Author Meta -->
    <meta name="author" content="colorlib">
    <!-- Meta Description -->
    <meta name="description" content="">
    <!-- Meta Keyword -->
    <meta name="keywords" content="">
    <!-- meta character set -->
    <meta charset="UTF-8">
    <!-- Site Title -->
    <title>Blogger</title>

    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
        <!--
        CSS
        ============================================= -->
        <link rel="stylesheet" href="css/linearicons.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>

        <!-- Start Header Area -->
        <header class="default-header">
            <nav class="navbar navbar-expand-lg navbar-light">
                <div class="container">
                      <a class="navbar-brand" href="index.html">
                        <img src="img/logo.png" alt="">
                      </a>
                      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                      </button>

                      <div class="collapse navbar-collapse justify-content-end align-items-center" id="navbarSupportedContent">
                         <ul class="navbar-nav scrollable-menu">
                            <li><a href="main.jsp">首页</a></li>
                            <c:if test="${(!empty user)&&(user.type==1)}">
                            	<li><a href="upload.jsp">发布新闻</a></li>
                            </c:if>
                        	<c:if test="${!empty user}">
				           <!-- Dropdown -->
				                <li class="dropdown">
				                  <a class="dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
				                    ${user.nickName}
				                  </a>
				                  <div class="dropdown-menu">
				                    <a class="dropdown-item" href="home.jsp">个人中心</a>
				                    <a class="dropdown-item" href="closeSessionServlet">登出</a>
				                  </div>
				                </li>                              		
                        	</c:if>
                        	<c:if  test="${empty user}">
                        		<li>
                        			<div id="User-Login"><a href="login.jsp">登录</a><a href="register.jsp">注册</a></div> 
                        		</li> 
                        	</c:if>
                        </ul>
                      </div>                        
                </div>
            </nav>
        </header>
        <!-- End Header Area -->

        <!-- Start top-section Area -->
       


<!-- Start post Area -->
<div class="post-wrapper pt-100">
    <!-- 左侧个人介绍 -->
     <section class="post-area"> 
            <div class="container">
                <div class="row justify-content-center">
                <div id="ohteruser" class="col-lg-3 sidebar-area ">
                        <div class="single_widget about_widget">
                            <img src="img/asset/s-img.jpg" alt="">
                            <h2 class="text-uppercase" tohome="${news.userId}">${user.nickName}</h2>
                            <p>
                              ${user.introduction}
                            </p>
                        </div>                                                                    
                    </div>
               <!-- end -->     
                    
                    <!--  右侧主体-->
                 <div class="col-lg-9 "> 
                 
                 <div  style="height:45px;border-radius:25px;background-image: -webkit-linear-gradient(45deg, #62bdfc 0%, #8490ff 100%);">
                 <div style="padding-top:10px;padding-left:20px;font-size:24px;font-weight:bold;color:white">
                 <span class="glyphicon glyphicon-edit"> 发布新闻</span></div>             
                 </div>     
                               
				<div class="single-page-post mt-0 pt-3" style="padding: 50px 20px 10px;">
	  		    <form action="PublicNewsServlet" method="post" enctype="multipart/form-data" >
	  		    <!-- 输入部分 -->
	  		     <div class="input-group-icon mt-25">	
	  		 	 <span class="glyphicon glyphicon-list-alt mb-20" style="font-size:20px;font-weight:bold;color:#5bc0de"> 新闻标题</span>
			     <input  class="form-control" style="background-color:#f9f9ff;border-left: 5px solid #c43afe;" type="text" name="title" 
			     placeholder="取个吸引眼球的标题吧......" onfocus="this.placeholder = ''" onblur="this.placeholder = '取个引人注目的标题吧......'" required="" >
		        </div>	
	  			<div class=" input-group-icon mt-30">
	  		     <span class="glyphicon glyphicon-list mb-20" style="font-size:20px;font-weight:bold;color:#5bc0de"> 新闻内容</span>
				<textarea class="form-control" style="background-color:#f9f9ff;border-left: 5px solid #c43afe;" rows="20"  name="content"
				placeholder="快点写下你想要分享的新闻吧！！！" onfocus="this.placeholder = ''" onblur="this.placeholder = '快点写下你想要分享的新闻吧！！！'" required=""></textarea>
				</div>
				<!--新闻类型  -->			
				<div class="row mt-20">
				         <div class="col-lg-3"><a href="#" class="genric-btn default-border radius">新闻类型：</a> </div>
	  		        	<div class="col-lg-2 ">
	  		        	<div style="height:42px;width:90px;color: #69B4FD;
	  		        	border: 1px solid #69B4FD;background: #fff;padding: 0 30px;font-size: .8em;text-align: center;">
	  		        	 娱乐<input type="radio" name="type" value="娱乐"/ ></div>
	  		        	</div>
	  		        	<div class="col-lg-2">
	  		        	<div style="height:42px;width:90px;color: #4cd3e3;
                         border: 1px solid #4cd3e3;background: #fff;padding: 0 30px;font-size: .8em;text-align: center;">
	  		        	 体育<input type="radio" name="type" value="娱乐"/ >
	  		        	</div></div>
	  		        	<div class="col-lg-2">
	  		        	<div style="height:42px;width:90px;color: #f4e700;
                         border: 1px solid #f4e700;background: #fff;padding: 0 30px;font-size: .8em;text-align: center;">
	  		        	 教育<input type="radio" name="type" value="娱乐"/ >
	  		        	</div></div>
	  		        	<div class="col-lg-2">
	  		        	<div style="height:42px;width:90px;color:#f44a40;;
                         border: 1px solid #f44a40;;background: #fff;padding: 0 30px;font-size: .8em;text-align: center;">
	  		        	 军事<input type="radio" name="type" value="娱乐"/ >
	  		        	</div></div>	
	  		        	</div> 	
	  		    <!-- 上传图片 -->		        				
				<div class="row mt-20">
		     	<input style="font-size:16px;color:#5bc0de" type="file" name="file"/>				
				<input type="submit" style="height:42px;width:90px;color:white;font-size:18px;font-weight:bold;
                 border: 1px solid #4cd3e3;border-radius:25px;background-image: -webkit-linear-gradient(45deg, #62bdfc 0%, #8490ff 100%);" value="上传" />
                 </div>
				</form></div>
	  	</div>          
  		<img alt="" src="${filename }">
  		</div></div>
    </section>
    <!-- End post Area -->  
</div>
<!-- End post Area -->

        <!-- start footer Area -->      
        <!-- End footer Area -->        
        <script src="js/vendor/jquery-2.2.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="js/vendor/bootstrap.min.js"></script> 
        <script src="js/jquery.ajaxchimp.min.js"></script> 
        <script src="js/parallax.min.js"></script>          
        <script src="js/owl.carousel.min.js"></script>      
        <script src="js/jquery.magnific-popup.min.js"></script>             
        <script src="js/jquery.sticky.js"></script>
        <script src="js/main.js"></script>  
        <script src="js/template.js"></script>
    </body>
</html>