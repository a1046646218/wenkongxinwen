  <!DOCTYPE html>
    <%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<!-- 我自己加的-->
		<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<!-- 我自己加的-->


        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
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
                <div id="type" style="display: none;">${type}</div>
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
                       

                        <div class="single_widget about_widget">
                            <img src="img/asset/s-img.jpg" alt="">
                            <h2 class="text-uppercase">${user.nickName}</h2>
                            <p>
                            ${user.introduction}
                            </p>
                        </div>
                                                                 
                    </div>
                    
                    <div class="col-lg-8">
                        <ul class="nav nav-tabs">
							
							<li><a href="#" id="guanzhu">关注</a></li>
							<li><a href="#" id="fans">粉丝</a></li>
						</ul>                 
                        <div class="post-lists" id="div1">                                                                  
                        </div>
                        <div class="justify-content-center d-flex">
								<a class="text-uppercase primary-btn loadmore-btn mt-40 mb-60"
									 id="load">加载</a>
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
                        <div class="col-lg-3  col-md-12">
                            <div class="single-footer-widget mail-chimp">
                                <h6 class="mb-20">Instragram Feed</h6>
                                <ul class="instafeed d-flex flex-wrap">
                                    <li><img src="img/i1.jpg" alt=""></li>
                                    <li><img src="img/i2.jpg" alt=""></li>
                                    <li><img src="img/i3.jpg" alt=""></li>
                                    <li><img src="img/i4.jpg" alt=""></li>
                                    <li><img src="img/i5.jpg" alt=""></li>
                                    <li><img src="img/i6.jpg" alt=""></li>
                                    <li><img src="img/i7.jpg" alt=""></li>
                                    <li><img src="img/i8.jpg" alt=""></li>
                                </ul>
                            </div>
                        </div>                      
                    </div>

                    <div class="row footer-bottom d-flex justify-content-between">
                        
                        <p class="col-lg-8 col-sm-12 footer-text">Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | made with Colorlib -  More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
                        
                        <div class="col-lg-4 col-sm-12 footer-social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-dribbble"></i></a>
                            <a href="#"><i class="fa fa-behance"></i></a>
                        </div>
                    </div>
                </div>
            </footer>
            <!-- End footer Area -->        
            <script type="text/javascript" src="js/template.js" ></script>
            <script src="js/vendor/jquery-2.2.4.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
            <script src="js/vendor/bootstrap.min.js"></script>
            <script src="js/jquery.ajaxchimp.min.js"></script>
            <script src="js/parallax.min.js"></script>          
            <script src="js/owl.carousel.min.js"></script>      
            <script src="js/jquery.magnific-popup.min.js"></script>             
            <script src="js/jquery.sticky.js"></script>
            <script src="js/main.js"></script>  
<script>
$(function(){
	var type=$("#type").html();
    if(type=="guanzhu")
		{
    	$("#guanzhu").parent('li').addClass("active");
    	$.ajax({
    		type:'post',
    		url:'adduserlist',
    		data:{type:type,num:0},
    		dataType:'json',
    		success:function(e){
    			console.log(JSON.stringify(e));
    			var new_html= template("test2",e);
    			$('#div1').html(new_html);
    		}
    	});
		}
	else
	{
		$("#fans").parent('li').addClass("active");
		$.ajax({
			type:'post',
			url:'adduserlist',
			data:{type:type,num:0},
			dataType:'json',
			success:function(e){
				console.log(JSON.stringify(e));
				var new_html= template("test1",e);
				$('#div1').html(new_html);
			}
		});
	}
	
$('body').on('click',"#guanzhu",function(){
	var type=$("#table").attr("value");
	if(type=="fans")
	{
		$("#guanzhu").parent('li').addClass("active");
		$("#fans").parent('li').removeClass("active");
	$.ajax({
		type:'post',
		url:'adduserlist',
		data:{type:"guanzhu",num:0},
		dataType:'json',
		success:function(e){
			console.log(JSON.stringify(e));
			var new_html= template("test2",e);
			$('#div1').html(new_html);
		}
	});
	}
});


$('body').on('click',"#fans",function(){
	var type=$("#table").attr("value");
	if(type=="guanzhu")
		{	
		$("#fans").parent('li').addClass("active");
		$("#guanzhu").parent('li').removeClass("active");
		$.ajax({
			type:'post',
			url:'adduserlist',
			data:{type:"fans",num:0},
			dataType:'json',
			success:function(e){
				console.log(JSON.stringify(e));
				var new_html= template("test1",e);
				$('#div1').html(new_html);
			}
		});
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


$('body').on('click','[name=otherId]',function(){
	var otherId = $(this).attr("value");
	$(location).attr("href","clickHeadToHomeServlet?"+"otheruserId="+otherId);
	});
$('body').on('click','#load',function(){
	var num=$("#div1").find(".single-list").length;
	var type=$("#table").attr("value");
	if(type=="fans")
	{
	$.ajax({
		type:'post',
		url:'adduserlist',
		data:{type:"fans",num:num},
		dataType:'json',
		success:function(e){
			console.log(JSON.stringify(e));
			var new_html= template("test4",e);
			$('#div1').append(new_html);
		}
	});
	}
	if(type=="guanzhu")
	{	
	$.ajax({
		type:'post',
		url:'adduserlist',
		data:{type:"guanzhu",num:num},
		dataType:'json',
		success:function(e){
			console.log(JSON.stringify(e));
			var new_html= template("test3",e);
			$('#div1').append(new_html);
		}
	});
	}
    });
});
</script>
<script type="text/html" id="test1">
    <div id="table" value="fans"></div>
    {{each fansliebiao as value index}}
    <div class="single-list flex-row d-flex">
    <div class="thumb">
    <div class="date">
    <span>20</span><br>Dec
    </div>
    <img src="img/asset/l1.jpg" alt="">
    </div>
    <div class="detail">
    <a href="#"><h4 class="pb-20" name="otherId" value="{{value.userId}}">{{value.nickName}} <br>
    </h4></a>
    <p>
    {{value.introduction}}
    </p>
    </div>
    </div>
    {{/each}}
</script>
<script type="text/html" id="test2">
    <div id="table" value="guanzhu"></div>
    {{each guanzhuliebiao as value index}}
    <div class="single-list flex-row d-flex">
    <div class="thumb">
    <div class="date">
    <span>20</span><br>Dec
    </div>
    <img src="img/asset/l1.jpg" alt="">
    </div>
    <div class="detail">
    <a href="#"><h4 class="pb-20" name="otherId" value="{{value.userId}}">{{value.nickName}} <br>
    </h4></a>
    <p>
    {{value.introduction}}
    </p>
    <div class="about_widget">
    <a href="#" ><button class="btn" name="guanzhu" value="{{value.userId}}">取消关注</button></a>
    </div>    
    <div class="social-link">
    </div> 
    
 
    </p>
    </div>
    </div>
    {{/each}}
</script>
<script type="text/html" id="test3">
    {{each guanzhuliebiao as value index}}
    <div class="single-list flex-row d-flex">
    <div class="thumb">
    <div class="date">
    <span>20</span><br>Dec
    </div>
    <img src="img/asset/l1.jpg" alt="">
    </div>
    <div class="detail">
    <a href="#"><h4 class="pb-20" name="otherId" value="{{value.userId}}">{{value.nickName}} <br>
    </h4></a>
    <p>
    {{value.introduction}}
    </p>
    <div class="about_widget">
    <a href="#" ><button class="btn" name="guanzhu" value="{{value.userId}}">取消关注</button></a>
    </div>    
    <div class="social-link">
    </div> 
    
 
    </p>
    </div>
    </div>
    {{/each}}
</script>
<script type="text/html" id="test4">
    {{each fansliebiao as value index}}
    <div class="single-list flex-row d-flex">
    <div class="thumb">
    <div class="date">
    <span>20</span><br>Dec
    </div>
    <img src="img/asset/l1.jpg" alt="">
    </div>
    <div class="detail">
    <a href="#"><h4 class="pb-20" name="otherId" value="{{value.userId}}">{{value.nickName}} <br>
    </h4></a>
    <p>
    {{value.introduction}}
    </p>
    </div>
    </div>
    {{/each}}
</script>
</body>
</html>