 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<!--  <link rel="shortcut icon" href="img/fav.png"> -->
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
<!-- 我自己加的-->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 我自己加的-->


<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">
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



	<!-- Start post Area -->
	<div class="post-wrapper pt-100">
		<!-- Start post Area -->
		<section class="post-area">
			<div class="container">
				<div class="row justify-content-center d-flex">

					<div class="col-lg-4 sidebar-area">


						<div class="single_widget about_widget" id="myuserdata"
							user_id="${userother.userId}">
							<img src="img/asset/s-img.jpg" alt="">
							<h2 class="text-uppercase">${userother.nickName}</h2>
							<span id="myusertype">${userother.type}</span> <br>
							<p>${userother.introduction}</p>
							<div class="social-link">
								<a href="#"><button class="btn" name="guanzhu" value="${userother.userId}">
									<!-- 	<i class="fa fa-facebook" aria-hidden="true"></i> -->
										取消关注
									</button></a> 
									<%-- <a href="#"><button class="btn">
										<i class="fa fa-twitter" aria-hidden="true"></i>${userother.followers}
										follow
									</button></a> --%>
							</div>
						</div>
					</div>

					<div class="col-lg-8">
						<ul class="nav nav-tabs" id="choose">
							<li class="active"><a href="#" id="showinfo">个人介绍</a></li>
							<li><a href="#" id="showxin">动态</a></li>
							<li><a href="#" id="showfavorite">收藏</a></li>							
						</ul>
						<div class="post-lists mt-0 pt-3" id="div1">
							<div id="div2">
						<div id="personinfo" style="padding: 48px 48px 96px;background:#f9f9ff;height:400px;">
						<div style="height:45px;border-radius:25px;background-image: -webkit-linear-gradient(45deg, #62bdfc 0%, #8490ff 100%);">
                        <div style="padding-top:10px;padding-left:20px;font-size:24px;font-weight:bold;color:white">
                        <span class="glyphicon glyphicon-user">个人信息</span></div>             
                        </div>
						<div class="detail"style="font-size:20px;font-weight:bold;color:#5bc0de">
							<div class="name-wrapper mt-10 pt-5 " >
								<span >用户名:</span>
								<span style="color: #777;font-size: 18px;font-weight: 400;line-height: 1.625em;">${userother.nickName}</span> 
								<!--<span class="glyphicon glyphicon-pencil" style="color: #007BFF;">编辑</span>-->
							</div>
							<div class="name-wrapper mt-10 pt-5 " >
								<span >用户类型：</span>
								<span style="color: #777;font-size: 18px;font-weight: 400;line-height: 1.625em;" id="myusertypehl">${userother.type}</span>
								<!--<span class="glyphicon glyphicon-pencil" style="color: #007BFF;">编辑</span>-->
							</div>
						    <div class="introduce-wrapper mt-10 pt-5 ">
						    	<span >个人介绍:</span>
								<span style="color: #777;font-size: 18px;font-weight: 400;line-height: 1.625em;">${userother.introduction}</span> 
								<!--<span class="glyphicon glyphicon-plus" style="color: #007BFF;">添加一句话介绍自己</span>-->				
								</div>
						</div></div></div>
							
							<div id="listcontent"></div>
							 <div id="loadmore"  class="justify-content-center d-flex">
								<a id="hl" class="text-uppercase primary-btn loadmore-btn mt-40 mb-60"
									>加载更多</a>
							</div> 
						

					</div>
				</div>
			</div>
		</section>
		<!-- End post Area -->
	</div>
	<!-- End post Area -->

	<!-- start footer Area -->
	<footer class="footer-area section-gap">
		<div class="container">
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
						<p>You can trust us. we only send promo offers, not a single
							spam.</p>
						<div id="mc_embed_signup">
							<form target="_blank" novalidate="true"
								action="#/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
								method="get" class="form-inline">

								<div class="form-group row" style="width: 100%">
									<div class="col-lg-8 col-md-12">
										<input name="EMAIL" placeholder="Enter Email"
											onfocus="this.placeholder = ''"
											onblur="this.placeholder = 'Enter Email '" required=""
											type="email">
										<div style="position: absolute; left: -5000px;">
											<input name="b_36c4fd991d266f23781ded980_aefe40901a"
												tabindex="-1" value="" type="text">
										</div>
									</div>

									<div class="col-lg-4 col-md-12">
										<button class="nw-btn primary-btn">
											Subscribe<span class="lnr lnr-arrow-right"></span>
										</button>
									</div>
								</div>
								<div class="info"></div>
							</form>
						</div>
					</div>
				</div>
			</div>

			<div class="row footer-bottom d-flex justify-content-between">
				<div class="col-lg-4 col-sm-12 footer-social">
					<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
						class="fa fa-twitter"></i></a> <a href="#"><i
						class="fa fa-dribbble"></i></a> <a href="#"><i
						class="fa fa-behance"></i></a>
				</div>
			</div>
		</div>
	</footer>
	<!-- End footer Area -->
	<!--    <script type="text/javascript" src="/NEUNews/js/template.js" ></script> -->
	<script src="js/vendor/jquery-2.2.4.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/parallax.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/main.js"></script>
	<!--   <script type="text/javascript" src="/NEUNews/js/jquery-1.8.3.min.js" ></script> -->
</body>
</html>
<script type="text/javascript">
	var usertype = $('#myusertype').text();
	var userid = $('#myuserdata').attr("user_id");
	var num = $('#listcontent').children().length;
	//alert(num);
	if (usertype == "1") {
		$('#myusertype').text("官方验证");
		$('#myusertypehl').text("官方验证");
	} else {
		$('#myusertype').text("普通用户");
		$('#myusertypehl').text("普通用户");
		$('#showxin').hide();
		$('#showxin').next().hide();
	}
	$.ajax({
		type:"get",
		url:"checkUserFollowing",
		context:document.body,
		dataType:"text",
		data:"userid="+userid,
		success: function(result){
			if(result=="0"){
				var $a=$('[name=guanzhu]').html("关注");
			}
			if(result=="1"){
				var $a=$('[name=guanzhu]').html("取消关注");
			}
			
		}
	});
	function showxinya(num){
		$.ajax({
					type : "post",
					url : "fornewsListByUserIDServlet",
					context : document.body,
					dataType : "text",
					async : false,
					data : {"user_id" : userid,"num" : num},
					success : function(result) {
					var jsonnews = JSON.parse(result);
					for (var i = jsonnews.length - 1; i >= 0; i--) {
					var str = "<div class=\"single-list flex-row d-flex\" id=\"firstnewslist\">"
							+ " <div class=\"thumb\">"
					    	+ "<div class=\"date\">"
							+ "<span>20</span><br>Dec"
							+ "</div>"
							+ "<img src=\"img/asset/l4.jpg\" alt=\"\">"
							+ "</div>"
							+ "<div class=\"detail\">"
							+ "<a href=\"#\"><h4 class=\"pb-20\" name=\""+jsonnews[i].newsId+" \"id=\"enternewsdetail\">"
							+ jsonnews[i].titile
							+ "<br>"
				    		+ jsonnews[i].nickname
							+ "</h4></a>"
					    	+ "<p>"
							+ jsonnews[i].nickname
							+ "</p>"
							+ "<p class=\"footer pt-20\">"
							+ "<i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i>"
							+ "<a href=\"#\">"
							+ jsonnews[i].like
							+ " Likes</a>"
							+ "<i class=\"ml-20 fa fa-comment-o\" aria-hidden=\"true\"></i>"
							+ "<a href=\"#\">"
							+ jsonnews[i].comments
							+ " Comments</a>"
							+ "</p>"
							+ "</div>" + "</div>";
							$('#listcontent').append($(str));
										}
									}
			});
	}
	function favoriteya(num){
		$.ajax({
		      type : "post",
			  url : "forfavoriteListByUserIDServlet",
			  context : document.body,
			  dataType : "text",
			  async : false,
			  data : {"user_id" : userid,"num" : num},
			  success : function(result) {var jsonnews = JSON.parse(result);
			  for (var i = jsonnews.length - 1; i >= 0; i--) {
					var str = "<div class=\"single-list flex-row d-flex\" id=\"firstnewslist\">"
							+ " <div class=\"thumb\">"
					    	+ "<div class=\"date\">"
							+ "<span>20</span><br>Dec"
							+ "</div>"
							+ "<img src=\"img/asset/l4.jpg\" alt=\"\">"
							+ "</div>"
							+ "<div class=\"detail\">"
							+ "<a href=\"#\"><h4 class=\"pb-20\" name=\""+jsonnews[i].newsId+"\"id=\"enternewsdetail\">"
							+ jsonnews[i].titile
							+ "<br>"
				    		+ jsonnews[i].nickname
							+ "</h4></a>"
					    	+ "<p>"
							+ jsonnews[i].nickname
							+ "</p>"
							+ "<p class=\"footer pt-20\">"
							+ "<i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i>"
							+ "<a href=\"#\">"
							+ jsonnews[i].like
							+ " Likes</a>"
							+ "<i class=\"ml-20 fa fa-comment-o\" aria-hidden=\"true\"></i>"
							+ "<a href=\"#\">"
							+ jsonnews[i].comments
							+ " Comments</a>"
							+ "</p>"
							+ "</div>" + "</div>";
							$('#listcontent').append($(str));
										}
									}
								});
	}
	
	$(document).ready(function(){
		$("#hl").hide();
	});
	
	
	$('body').on("click","#showxin",function() {
			$(this).parent().addClass("active");
			$(this).parent().siblings().removeClass("active");
			$("#div2").hide();
			$("#hl").show();
			$('#listcontent').empty();
			showxinya(0);
	});
	$('#showfavorite').click(function() {
		$(this).parent().addClass("active");
		$(this).parent().siblings().removeClass("active");
		
		$("#div2").hide();
		$("#hl").show();
		$('#listcontent').empty();
		favoriteya(0);
	});

	$('#showinfo').click(function() {
	$(this).parent().addClass("active");
	$(this).parent().siblings().removeClass("active");
	$('#div2').show();	
	$("#hl").hide();
	$('#listcontent').empty();
	});
	
	$('body').on('click','#enternewsdetail',function(){
    		var searchnew_id = $(this).attr("name");
    		alert(searchnew_id);
    		$(location).attr("href","EnterNewdetailServlet?"+"searchnew_id="+searchnew_id); 
    	
    });
	
	$('#loadmore').click(function(){
		var text = $('.active').text();
		//alert(text);
		var num = $('#listcontent').children().length;
		//alert(num);
		if(text=="动态"){
			showxinya(num);
		}else if(text=="收藏"){
			favoriteya(num);
		}
	});
	
	$('body').on('click','[name=guanzhu]',function(){
		var guanId = $(this).val();
		var relation = $(this).html();
		var $a=$(this);
		if(relation=="取消关注"){
			$.ajax({
				type:'post',
				url:'quguan',
				data:{guanId:guanId},
				dataType:'text',
				success:function(){
					$a.html("关注");				
				}
			});
			//return false;//  js方法如果想终止, 写return  false;
		}
		else{
			$.ajax({
				type:'post',
				url:'guanzhu',
				data:{guanId:guanId},
				dataType:'text',
				success:function(){			
					$a.html("取消关注");
				}
			});		
		}
	});
</script>

