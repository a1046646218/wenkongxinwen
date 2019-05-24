<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
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
                            <li><a href="main.html">首页</a></li>
                            <c:if test="${(!empty user)&&(user.type==1)}">
                            	<li><a href="#news">发布新闻</a></li>
                            </c:if>
                        	<c:if test="${!empty user}">
				           <!-- Dropdown -->
				                <li class="dropdown">
				                  <a class="dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
				                    Ruojichong
				                  </a>
				                  <div class="dropdown-menu">
				                    <a class="dropdown-item" href="single.html">个人中心</a>
				                    <a class="dropdown-item" href="closeSessionServlet">登出</a>
				                  </div>
				                </li>                              		
                        	</c:if>
                        	<c:if  test="${empty user}">
                        		<li>
                        			<div id="User-Login"><a href="TestMain2">登录</a><a href="#fashion">注册</a></div> 
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
    <!-- Start post Area -->
    <section class="post-area">
    	<div class="container">
	  		<form action="PublicNewsServlet" method="post" enctype="multipart/form-data">
	  			标题:<input type="text" value=""  name="title"/><br />
	  			内容:<textarea class="form-control" id="textarea" name="content" rows="10"></textarea><br />
	  			新闻类型: 娱乐<input type="radio" name="type" value="娱乐"/>
	  					 直播<input type="radio" name="type" value="直播" />
	  			<br />
	  			图片:<input type="file" name="file"/><br />
	  			<input type="submit" value="上传" />
	  		</form>
	  	</div>
  		<img alt="" src="${filename }">
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
        <script type="text/javascript" >
	        var textarea = document.getElementById('textarea');
	        function makeExpandingArea(el){
	            var setStyle = function(el){
	                el.style.height = 'auto';
	                el.style.height = el.scrollHeight + 'px';
	                // console.log(el.scrollHeight);
	            }
	            var delayedResize = function(el) {
	                window.setTimeout(function(){
	                    setStyle(el);
	                }, 0);
	            }
	            if(el.addEventListener){
	                el.addEventListener('input',function(){
	                    setStyle(el)
	                },false);
	                setStyle(el)
	            }else if(el.attachEvent){
	                el.attachEvent('onpropertychange',function(){
	                    setStyle(el)
	                })
	                setStyle(el)
	            }
	            if(window.VBArray && window.addEventListener) { //IE9
	                 el.attachEvent("onkeydown", function() {
	                var key = window.event.keyCode;
	                if(key == 8 || key == 46) delayedResize(el);
	             
	              });
	              el.attachEvent("oncut", function(){
	                delayedResize(el);
	              });//处理粘贴
	            }
	        }
	        makeExpandingArea(textarea);
   		 </script>
    </body>
</html>