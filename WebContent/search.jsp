   <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
    <!DOCTYPE html>
    <html lang="zxx" class="no-js">
    <head>
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
        <!-- Start post Area -->
        <section class="post-area">
        	
            <div class="container">
                <div class="row justify-content-center d-flex">
                    <div class="col-lg-8">
                        <div class="post-lists search-list" >
                        	<div class="single_widget search_widget"style="background-color:#007BFF;padding: 10px 10px 10px 10px;">
                            <div id="imaginary_container" >  
                                <div class="input-group stylish-input-group" >
                                    <input type="text" class="form-control" id="info" >
                                    <span class="input-group-addon">
                                        <button type="submit" id="search">
                                            <span class="lnr lnr-magnifier" ></span>
                                        </button>  
                                    </span>
                                </div>
                            </div> 
                        </div>        
                         <div id="result">
                         
                         </div>           

                                                    
                            <div class="justify-content-center d-flex" >
                                <a id="addNews" class="text-uppercase primary-btn loadmore-btn mt-40 mb-60"> 加载更多</a>
                            </div>                                                                     
                        </div>                          
                    </div>
                </div>
            </div>    
        </section>
        <!-- End post Area -->  
    </div>
    <!-- End post Area -->
     
    
            <!-- start footer Area -->      
            <footer class="footer-area section-gap" style="height:230px;" >
                <div class="container" style="height:150;">
                    <div class="row">
                        <div class="col-lg-3  col-md-12">
                            <div class="single-footer-widget">
                                <h6>Top Products</h6>
                                <ul class="footer-nav">
                                    <li><a href="#">Managed Website</a></li>
                                    <li><a href="#">Manage Reputation</a></li>
                                    <li><a href="#">Power Tools</a></li>
                                    <li><a href="#">Marketing Service</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-6  col-md-12">
                            <div class="single-footer-widget newsletter">
                                <h6>Newsletter</h6>
                                <p>You can trust us. we only send promo offers, not a single spam.</p>
                                <div id="mc_embed_signup">
                                    <form target="_blank" novalidate="true" action="#/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" method="get" class="form-inline">

                                        <div class="form-group row" style="width: 100%">
                                            <div class="col-lg-8 col-md-12">
                                                <input name="EMAIL" placeholder="Enter Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Email '" required="" type="email">
                                                <div style="position: absolute; left: -5000px;">
                                                    <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
                                                </div>
                                            </div> 
                                        
                                            <div class="col-lg-4 col-md-12">
                                                <button class="nw-btn primary-btn">Subscribe<span class="lnr lnr-arrow-right"></span></button>
                                            </div> 
                                        </div>      
                                        <div class="info"></div>
                                    </form>
                                </div>      
                            </div>
                        </div>                                          
                    </div>
                </div>
            </footer>
            <!-- End footer Area -->        
			<div id="searchtxt" style="display: none;">${searchtxt}</div>
            <script src="js/vendor/jquery-2.2.4.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
            <script src="js/vendor/bootstrap.min.js"></script>
            <script src="js/jquery.ajaxchimp.min.js"></script>
            <script src="js/parallax.min.js"></script>          
            <script src="js/owl.carousel.min.js"></script>      
            <script src="js/jquery.magnific-popup.min.js"></script>             
            <script src="js/jquery.sticky.js"></script>
            <script src="js/main.js"></script>  
        </body>
    </html>

<script>	
	
	
	$(document).ready(function(){
		var searchtxt = $('#searchtxt').text();
		//alert(searchtxt);
        $.ajax({
            type: 'post', 
            url: "searchservlet",
            data:{"newsinfo": searchtxt,"newsIndex":0}, 
            dataType:'text', 
            success: function(result){ 	
            	 			$("#result").empty();
							var jsonnews = JSON.parse(result);
							for(var i=jsonnews.length-1;i>=0;i--){
							var str="<div class=\"single-list flex-row d-flex\" id=\"firstnewslist\">"+
                               " <div class=\"thumb\">"+
                                    "<div class=\"date\">"+
                                       "<span>20</span><br>Dec"+
                                    "</div>"+
                                    "<img src=\"img/asset/l4.jpg\" alt=\"\">"+
                               "</div>"+
                               "<div class=\"detail\">"+
                                    "<a href=\"#\"><h4 class=\"pb-20\" name=\""+jsonnews[i].newsId+"\" id=\"enternewsdetail\">"+jsonnews[i].titile +"<br>"+
                                    jsonnews[i].nickname+"</h4></a>"+
                                    "<p>"+ jsonnews[i].content+"</p>"+
                                    "<p class=\"footer pt-20\">"+
                                    "<i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i>"+
                                    "<a href=\"#\">"+jsonnews[i].like+" Likes</a>"+   
                                    "<i class=\"ml-20 fa fa-comment-o\" aria-hidden=\"true\"></i>"+
                                    "<a href=\"#\">"+jsonnews[i].comments+" Comments</a>"+
                                    "</p>"+
                                "</div>"+
                            "</div>";    
							$("#result").append($(str));
            				}
            },
            error:function(result){
				alert("错误");
			}
        });
      });	

	
	$("#search").click(function() {
		$('#searchtxt').text($("#info").val());
        var info = $("#info").val();
        //alert(info);
        info = info.trim().replace(/\s/g,"");
        if(info.length>=10){
        	info = info.substring(0,5);
        }
       if(info.length>0){
        $.ajax({
            type: 'post', 
            url: "searchservlet",
            data:{"newsinfo": info,"newsIndex":$("div[uid]").length}, 
             dataType:'text', 
            success: function(result){
						 $("#result").empty();	 	
							var jsonnews = JSON.parse(result);
							for(var i=jsonnews.length-1;i>=0;i--){
							var str="<div class=\"single-list flex-row d-flex\" id=\"firstnewslist\">"+
                               " <div class=\"thumb\">"+
                                    "<div class=\"date\">"+
                                       "<span>20</span><br>Dec"+
                                    "</div>"+
                                    "<img src=\"img/asset/l4.jpg\" alt=\"\">"+
                               "</div>"+
                               "<div class=\"detail\">"+
                                    "<a href=\"#xxx\"><h4 class=\"pb-20\" name=\""+jsonnews[i].newsId+"\" id=\"enternewsdetail\">"+jsonnews[i].titile +"<br>"+
                                    jsonnews[i].nickname+"</h4></a>"+
                                    "<p>"+ jsonnews[i].content+"</p>"+
                                    "<p class=\"footer pt-20\">"+
                                    "<i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i>"+
                                    "<a href=\"#\">"+jsonnews[i].like+" Likes</a>"+   
                                    "<i class=\"ml-20 fa fa-comment-o\" aria-hidden=\"true\"></i>"+
                                    "<a href=\"#\">"+jsonnews[i].comments+" Comments</a>"+
                                    "</p>"+
                                "</div>"+
                            "</div>";    
		$("#result").append($(str));
            }
            },
            error:function(result){
				alert("错误");
			}
        })
       }
       else{
    	   alert("空");
       }
    });
    $('body').on('click','#enternewsdetail',function(){
    	var searchnew_id = $(this).attr("name");
    	//alert(searchnew_id);
    	$(location).attr("href","EnterNewdetailServlet?"+"searchnew_id="+searchnew_id); 
    	
    });
	</script>
	<!--
    	作者：HXB
    	时间：2019-05-24
    	描述：
    -->
	<script>
		$("#addNews").click(function(){
		//alert("ds");
	        var info = $('#searchtxt').text();
	        var listnum = $('[id=firstnewslist]').length;
	       // alert(listnum);
	       if(info.length>0){
	        $.ajax({
	            type: 'post', 
	            url: "searchservlet",
	            data:{"newsinfo": info,"newsIndex":listnum}, 
	             dataType:'text', 
	            success: function(result){ 	
						var jsonnews = JSON.parse(result);
						for(var i=jsonnews.length-1;i>=0;i--){
							var str="<div class=\"single-list flex-row d-flex\" id=\"firstnewslist\">"+
	                           " <div class=\"thumb\">"+
	                                "<div class=\"date\">"+
	                                   "<span>20</span><br>Dec"+
	                                "</div>"+
	                                "<img src=\"img/asset/l4.jpg\" alt=\"\">"+
	                           "</div>"+
	                           "<div class=\"detail\">"+
	                                "<a href=\"#xxx\"><h4 class=\"pb-20\" name=\""+jsonnews[i].newsId+"\" id=\"enternewsdetail\">"+jsonnews[i].titile +"<br>"+
	                                jsonnews[i].nickname+"</h4></a>"+
	                                "<p>"+ jsonnews[i].content+"</p>"+
	                                "<p class=\"footer pt-20\">"+
	                                "<i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i>"+
	                                "<a href=\"#\">"+jsonnews[i].like+" Likes</a>"+   
	                                "<i class=\"ml-20 fa fa-comment-o\" aria-hidden=\"true\"></i>"+
	                                "<a href=\"#\">"+jsonnews[i].comments+" Comments</a>"+
	                                "</p>"+
	                            "</div>"+
	                        "</div>";    
							$("#result").append($(str));
           				 }
		            },
	            error:function(result){
					alert("错误");
				}
	        })
	       }
	       else{
	    	   alert("空");
	       }
		});
	</script>
	<!--
    	作者：HXB
    	时间：2019-05-24
    	描述：artTemplate模板
    -->
	<script type="text/html" id="module">
		{{each list as value}}
	    <div class="single-list flex-row d-flex" id="firstnewslist">
	        <div class="thumb">
	            <div class="date">
	                <span>20</span><br>Dec
	            </div>
	            <img src="img/asset/l4.jpg" alt="">
	        </div>
	        <div class="detail">
	            <a href="#"><h4 class="pb-20" name={{value.newsId}} id='enternewsdetail'>{{value.titile}} <br>
	            value.nickname</h4></a>
	            <p>
	               {{value.content}}
	            </p>
	            <p class="footer pt-20">
	            <i class="fa fa-heart-o" aria-hidden="true"></i>
	            <a href="#">{{value.like}} Likes</a>  <i class="ml-20 fa fa-comment-o" aria-hidden="true"></i> <a href="#">{{value.comments}} Comments</a>
	            </p>
	        </div>
	    </div>
	    {{/each}}
	</script>
	
