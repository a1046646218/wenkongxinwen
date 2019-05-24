<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
                            	<li><a href="#news">发布新闻</a></li>
                            </c:if>
                        	<c:if test="${!empty user}">
				           <!-- Dropdown -->
				                <li class="dropdown">
				                  <a class="dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
				                    Ruojichong
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
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <div class="single-page-post">
                            <img class="img-fluid" src="img/single.jpg" alt="" >
                            <div class="top-wrapper " id="mynews" name="${news.newsId}">
                                                      <!--
                                                      	作者：offline
                                                      	时间：2019-05-20
                                                      	标题  作者
                                                      -->
                                <div class="row d-flex justify-content-between">
                                    <h2 class="col-lg-8 col-md-12 text-uppercase" id="title">
                                       ${news.titile}
                                    </h2>
                                    <div class="col-lg-4 col-md-12 right-side d-flex justify-content-end">
                                        <div class="desc">
                                           <h2 id="nickname" tohome="${news.userId}" >${news.nickname}</h2>
                                        </div>
                                        <div class="user-img">
                                            <img src="img/user.jpg" alt="">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tags" id="type">          <!--
                                                      	作者：offline
                                                      	时间：2019-05-20
                                                      	类型
                                                      -->
                                <ul>
                                    <li><a href="#">${news.type}</a></li>
                                    
                                </ul>
                            </div>
                            <div class="single-post-content"  id="content">
                            	 <!--
                                                      	作者：offline
                                                      	时间：2019-05-20
                                                      	正文
                                                      -->
                                <p>
                                   ${news.content}
                                </p>
                                <p>
                                    MCSE boot camps have its supporters and its detractors. Some people do not understand why you should have to spend money on boot camp when you can get the MCSE study materials yourself at a fraction of the camp price. However, who has the willpower to actually sit through a self-imposed MCSE training. who has the willpower to actually sit through a self-imposed MCSE training.
                                </p>

                                <blockquote>Ea possunt paria non esse. Pudebit te, inquam, illius tabulae, quam Cleanthes sane commode verbis depingere solebat. Urgent tamen et nihil remittunt. An vero displicuit ea, quae tributa est animi virtutibus tanta praestantia? Sint ista Graecorum; Cur igitur, cum de re conveniat, non malumus usitate loqui? Huius ego nunc auctoritatem sequens idem faciam.
                                <cite>Wise Man</cite></blockquote>

                                <p>
                                    MCSE boot camps have its supporters and its detractors. Some people do not understand why you should have to spend money on boot camp when you can get the MCSE study materials yourself at a fraction of the camp price. However, who has the willpower to actually sit through a self-imposed MCSE training.
                                </p>
                                <p>
                                    MCSE boot camps have its supporters and its detractors. Some people do not understand why you should have to spend money on boot camp when you can get the MCSE study materials yourself at a fraction of the camp price. However, who has the willpower to actually sit through a self-imposed MCSE training. who has the willpower to actually sit through a self-imposed MCSE training.
                                </p>
                            </div>
                            <div class="bottom-wrapper">
                                <div class="row">
                                    <div class="col-lg-3 single-b-wrap col-md-12">
                                        <i class="fa fa-thumbs-o-up" aria-hidden="true"></i>
                                        <span id="zan">${news.like}</span>人点赞
                                        <!-- fa-thumbs-up   点赞了
                                        	fa-thumbs-o-up 没点赞
                                                      	作者：offline
                                                      	时间：2019-05-20
                                                      	喜欢人
                                                      -->
                                    </div>
                                    <div class="col-lg-3 single-b-wrap col-md-12">
                                        <i class="fa fa-star-o" aria-hidden="true"></i>
                                        <span id="isfavorite">${news.favorites}</span>人收藏
                                        <!--fa-star-o 没收藏
                                            fa fa-star  点收藏
                                                      	作者：offline
                                                      	时间：2019-05-20
                                                      	喜欢人
                                                      -->
                                    </div>
                                    <div class="col-lg-3 single-b-wrap col-md-12">
                                        <i class="fa fa-comment-o" aria-hidden="true"></i> 
                                        <span id="cha">${news.comments}</span>人评论
                                        <!--
                                                      	作者：offline
                                                      	时间：2019-05-20
                                                      	评论人
                                                      -->
                                    </div>
                                    <div class="col-lg-3 single-b-wrap col-md-12">
                                        <ul class="social-icons">
                                            <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                                            <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                                            <li><a href="#"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
                                            <li><a href="#"><i class="fa fa-behance" aria-hidden="true"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
 							<!-- Start commentform Area -->
                            <!--
                            	作者：offline
                            	时间：2019-05-20
                            	描述：提交表单
                            -->
                            <section class="commentform-area  pb-120 pt-40 mb-10">
                                <div class="container">
                                    <h5 class="text-uppercas pb-50">留 下 你 的 评 论</h5>
                                    <div class="row flex-row d-flex">
                                        <div class="col-lg-12">
                                            <textarea id="textareas" class="form-control mb-10" name="message" placeholder="评论一些想法吧..." onfocus="this.placeholder = ''" onblur="this.placeholder = '评论一些想法吧...'" required=""></textarea>
                                            <a class="primary-btn mt-20" id="makecomment" style="float:right;">Comment</a>
                                        </div>
                                    </div>
                                </div>    
                            </section>
                            
                            <!-- Start comment-sec Area -->
                            <section class="comment-sec-area pt-30 pb-80">
                                <div class="container">
                                    <div class="row flex-column" id="firstcommentlist">
                                        
                                         <!--
                            				作者：offline
                            				时间：2019-05-20
                            				描述：评论
                            			-->
                                       
                                         <!--
                            				作者：offline
                            				时间：2019-05-20
                            				描述：二级评论
                            			-->
                                                                                                                                                                                                       
                                    </div>
                                </div>    
                            </section>
                            <!-- End comment-sec Area -->
                           
                           
                           
                            <!-- End commentform Area -->
                            
                        </div>
                    </div>
                    <div id="ohteruser" class="col-lg-4 sidebar-area ">
                        <div class="single_widget about_widget">
                            <img src="img/asset/s-img.jpg" alt="">
                            <h2 class="text-uppercase" tohome="${news.userId}">Adele Gonzalez</h2>
                            <p>
                                MCSE boot camps have its supporters and
                                its detractors. Some people do not understand why you should have to spend money
                            </p>
                            <div class="social-link">
                                <button class="btn" id="otherguanzhu">关注</button>                         
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
<script type="text/javascript">
$(document).ready(function(){

		var new_id = $('#mynews').attr("name");
		$.ajax({
			type:"get",
			url:"checkLikeAndFarvoriteServlet",
			context:document.body,
			dataType:"text",
			data:"new_id="+new_id,
			success: function(result){
				var jsoncomment = JSON.parse(result);
				if(jsoncomment[0]=="1"){
					$('#zan').prev().attr("class","fa fa-thumbs-up");
				}
				if(jsoncomment[1]=="1"){
					$('#isfavorite').prev().attr("class","fa fa-star");
				}
				
			}
		});
		
		$.ajax({
			type:"get",
			url:"GetUserByNewsIdAjaxServlet",
			context:document.body,
			dataType:"text",
			data:"new_id="+new_id,
			success: function(result){
				var jsoncomment = JSON.parse(result);
				$('#ohteruser').find('h2').text(jsoncomment.nickName);
				$('#ohteruser').find('p').text(jsoncomment.introduction);
				$('#ohteruser').attr("name",jsoncomment.userId);
				$.ajax({
					type:"get",
					url:"checkUserFollowing",
					context:document.body,
					dataType:"text",
					data:"userid="+jsoncomment.userId,
					success: function(result){
						if(result=="0"){
							$('#otherguanzhu').html("关注");
						}
						if(result=="1"){
							$('#otherguanzhu').html("取消关注");
						}
						if(result=="error"){
							alert("sdasd");
							$('#otherguanzhu').remove();
						}
					}
				});
			}
		});
		$.ajax({
			type:"get",
			url:"getCommentsListServlet",
			context:document.body,
			dataType:"text",
			data:"new_id="+new_id,
			success: function(result){
				var jsoncomment = JSON.parse(result);			
				for(var i=jsoncomment.length-1;i>=0;i--){
				//fa fa-heart 黑心
				//fa fa-heart-o 百心
				var liketype ="fa fa-heart-o";
				if(jsoncomment[i].flag=="1"){
					liketype = "fa fa-heart";
				}
				var str = "<div class=\"comment-list\" id=\"itisfirst\"  name=\""+jsoncomment[i].com.commentId+"\">"+
                                            "<div class=\"single-comment justify-content-between d-flex\">"+
                                                "<div class=\"user justify-content-between d-flex col-lg-10\">"+
                                                    "<div class=\"thumb col-lg-2\">"+
                                                        "<img src=\"img/asset/c1.jpg\" alt=\"\">"+
                                                    "</div>"+
                                                   " <div class=\"desc col-lg-10\">"+
                                                        "<h5><a href=\"#\" tohome=\""+jsoncomment[i].com.userId+"\">"+jsoncomment[i].com.nickName+"</a></h5>"+
                                                        "<br>"+
                                                        "<p class=\"comment\">"+
                                                            jsoncomment[i].com.content+
                                                        "</p>"+
                                                       " <i class=\""+liketype+"\" aria-hidden=\"true\" id=\"bt_zan\"></i>"+
                                                        		"&nbsp;&nbsp;&nbsp;<span>"+jsoncomment[i].com.likes+"</span>喜欢&nbsp;&nbsp;&nbsp;&nbsp;"+
                                                        "<i class=\"fa fa-comment-o\" aria-hidden=\"true\"></i>" +
                                                        	"&nbsp;&nbsp; <span id=\"bt_chaer\">查看评论</span>&nbsp;(<span>"+jsoncomment[i].com.reviews+"</span>) "+
                                                    "</div>"+
                                                "</div>"+
                                                "<div class=\"reply-btn col-lg-2\" >"+
                                                       "<span id=\"yijihuifu\" class=\"btn-reply text-uppercase\">回复</span>" +
                                                "</div>"+
                                            "</div>"+
                                        "</div>";
										
					
					
					$('#firstcommentlist').append($(str));
					
				}
			}			
		});
	$('body').on('click','#otherguanzhu',function(){
		var guanId = $('#ohteruser').attr("name");
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
	$('#zan').prev().click(function(){	
		$.ajax({
			type:"get",
			url:"addLikeNewsAjaxServlet",
			context:document.body,
			dataType:"text",
			data:"new_id="+new_id,
			success: function(result){
				if(result=="1"){
					$('#zan').prev().attr("class","fa fa-thumbs-up");
					$('#zan').text(parseInt($('#zan').text())+1);
				}
			}
		});
	
	});
	$('#isfavorite').prev().click(function(){
		$.ajax({
			type:"get",
			url:"addFavoriteNewAjaxServlet",
			context:document.body,
			dataType:"text",
			data:"new_id="+new_id,
			success: function(result){
				if(result=="1"){
					$('#isfavorite').prev().attr("class","fa fa-star");
					$('#isfavorite').text(parseInt($('#isfavorite').text())+1);
				}
				
			}
		});
	
	});
	$('body').on("click","#bt_zan",function(){
		var $zan_num = $(this).next();
		var commentId = $(this).parent().parent().parent().parent().attr("name");
		var bts = $(this);
		//alert(commentId);
		$.ajax({
			type:"post",
			url:"dianzanpinglunServlet",
			context:document.body,
			dataType:"text",
			data:"commentId="+commentId,
			success:function(result){
				if(result==1){
					$zan_num.text(parseInt($zan_num.text())+1);
					bts.attr("class","fa fa-heart");
				}
								
			}
		});
		
	});
	$('body').on("click",'#bt_chaer',function(){
		var $bter = $(this);
		
		var $fathercomment =$(this).parent().parent().parent().parent();
		var commentId = $fathercomment.attr("name");
		//alert($re);
		//alert(commentId);
		if($bter.text()=="查看评论"){
				$.ajax({
						type:"post",
						url:"getReviewListServlet",
						context:document.body,
						dataType:"text",
						data:"commentId="+commentId,
						success:function(result){
						var jsoncomment = JSON.parse(result);
			
							while($fathercomment.next().attr("id")=="itissecond"){
									$fathercomment.next().remove();
							}
							$bter.text("收起评论");
				
						if(jsoncomment.length>0){
								for(var i=0;i<jsoncomment.length;i++){
										var str = "<div class=\"comment-list \" id=\"itissecond\" name=\""+jsoncomment[i].reviewId+"\">"+
                                            //在这里哦
                                            "<div class=\"single-comment justify-content-between d-flex\">"+
                                                "<div class=\"user justify-content-between d-flex col-lg-8 ml-50\">"+
                                                    "<div class=\"thumb col-lg-2\">"+
                                                        "<img src=\"img/asset/c2.jpg\">"+
                                                    "</div>"+
                                                    "<div class=\"desc col-lg-10\">"+
                                                        "<h5><a href=\"#\" tohome=\""+jsoncomment[i].userId+"\">"+jsoncomment[i].nickName+"</a></h5>"+
                                                        "<p class=\"date\">"+jsoncomment[i].remarkstr+"</p>"+
                                                        "<p class=\"comment\">"+
                                                            jsoncomment[i].content+
                                                        "</p>"+
                                                    "</div>"+
                                                "</div>"+
                                                "<div class=\"reply-btn col-lg-2\" >"+
                                                       "<span  id=\"erjihuifu\" class=\"btn-reply text-uppercase\">回复</span>" +
                                                "</div>"+
                                            "</div>"+
                                        "</div>";
								$fathercomment.after($(str));
								}	
						}
						}
					});
			}
			else{
				$bter.text("查看评论");
				while($fathercomment.next().attr("id")=="itissecond"){
				$fathercomment.next().remove();
				}
			}	
			
		
		
	});
	$('#makecomment').click(function(){
		var new_id = $('#mynews').attr("name");
		var strr = $('#textareas').val();
		if(strr==""||strr=="评论一些想法吧..."){
		}
		else{
			$.ajax({
			type:"post",
			url:"addcommentServlet",
			context:document.body,
			dataType:"text",
			data:{"context":strr,"new_id":new_id},
			success:function(result){
				if(result!=""){
					var jsoncomment = JSON.parse(result);
				var str = "<div class=\"comment-list\" id=\"itisfirst\" name=\""+jsoncomment.commentId+"\">"+
                                            "<div class=\"single-comment justify-content-between d-flex\">"+
                                                "<div class=\"user justify-content-between d-flex col-lg-10\" >"+
                                                    "<div class=\"thumb col-lg-2\">"+
                                                        "<img src=\"img/asset/c2.jpg\" alt=\"\">"+
                                                    "</div>"+
                                                   " <div class=\"desc col-lg-10\">"+
                                                        "<h5><a href=\"#\" tohome=\""+jsoncomment.userId+"\">"+jsoncomment.nickName+"</a></h5>"+
                                                        "<br>"+
                                                        "<p class=\"comment\">"+
                                                            jsoncomment.content+
                                                        "</p>"+
                                                       " <i class=\"fa fa-heart-o\" aria-hidden=\"true\" id=\"bt_zan\"></i>"+
                                                        		"&nbsp;&nbsp;&nbsp;<span>"+jsoncomment.likes+"</span>喜欢&nbsp;&nbsp;&nbsp;&nbsp;"+
                                                        "<i class=\"fa fa-comment-o\" aria-hidden=\"true\"></i>" +
                                                        	"&nbsp;&nbsp; <span id=\"bt_chaer\">查看评论</span>&nbsp;(<span>"+jsoncomment.reviews+"</span>) "+
                                                    "</div>"+
                                                "</div>"+
                                                 "<div class=\"reply-btn col-lg-2\">"+
                                                       "<span id=\"yijihuifu\" class=\"btn-reply text-uppercase\">回复</span>" +
                                                "</div>"+
                                            "</div>"+
                                        "</div>";
					$('#firstcommentlist').prepend($(str));
					$('#textareas').val('');
					$('#cha').text(parseInt($('#cha').text())+1);
				}	
			}
		});
		}
	
	});
	$('body').on('click','#yijihuifu',function(){
		var $huifu = $(this);
		var $fathercomment = $(this).parent().parent();
		if($huifu.text()=="回复"){
			$huifu.text("取消");
			var str = "<div class=\"row flex-row d-flex\">"+
                                        "<div class=\"col-lg-12 mt-20\">"+
                                            "<textarea style=\"height:90px\" class=\"form-control\" name=\"message\" placeholder=\"评论一些想法吧...\" onfocus=\"this.placeholder = ''\" onblur=\"this.placeholder = '评论一些想法吧...'\" required=\"\"></textarea>"+
                                           "<div class=\"reply-btn\" style=\"border:solid 1px  #D8D8D8;height:41px;\">"+
                                                "<span  style=\"width:90px;height:40px;float:right;\"id=\"tijiaoyijihuifu\" class=\"btn-reply text-uppercase\">评论</span>" +
                                           "</div>"+
                                        "</div>"+
                                    "</div>";
			$fathercomment.after($(str));
			$fathercomment.next().find('#tijiaoyijihuifu').click(function(){
				var reviewtextarea = $(this).parent().prev();
				var reviewcotent = $(this).parent().prev().val();
				var commentelement = $(this).parent().parent().parent().parent();
				var commentId = $(this).parent().parent().parent().parent().attr("name");
				//alert(reviewcotent);
				//alert(commentId);
				if(reviewcotent==""||reviewcotent=="评论一些想法吧..."){
				}else{
							$.ajax({
									type:"post",
									url:"makereviewServlet",
									context:document.body,
									dataType:"text",
									data:{"commentId":commentId,"reviewcotent":reviewcotent},
									success:function(result){
										if(result!=""){
											//alert(jsoncomment);
											var jsoncomment = JSON.parse(result);
											reviewtextarea.val('');
											var review_num = commentelement.find('#bt_chaer').next().text();	
											commentelement.find('#bt_chaer').next().text(parseInt(review_num)+1);
											$huifu.text("回复");
											$fathercomment.next().remove();
											
											
											var str = "<div class=\"comment-list \" id=\"itissecond\" name=\""+jsoncomment.reviewId+"\">"+
                                            //在这里哦
                                            "<div class=\"single-comment justify-content-between d-flex\">"+
                                                "<div class=\"user justify-content-between d-flex col-lg-8 ml-50\">"+
                                                    "<div class=\"thumb col-lg-2\">"+
                                                        "<img src=\"img/asset/c2.jpg\">"+
                                                    "</div>"+
                                                    "<div class=\"desc col-lg-10\">"+
                                                        "<h5><a href=\"#\" tohome=\""+jsoncomment.userId+"\">"+jsoncomment.nickName+"</a></h5>"+
                                                        "<p class=\"date\">"+jsoncomment.remarkstr+"</p>"+
                                                        "<p class=\"comment\">"+
                                                            jsoncomment.content+
                                                        "</p>"+
                                                    "</div>"+
                                                "</div>"+
                                                "<div class=\"reply-btn col-lg-2\" >"+
                                                       "<span  id=\"erjihuifu\" class=\"btn-reply text-uppercase\">回复</span>" +
                                                "</div>"+
                                            "</div>"+
                                        "</div>";
											
										commentelement.after($(str));
										}else{
											
										}
									}
							});
				
				}
			
			});
		}else{
			$huifu.text("回复");
			$fathercomment.next().remove();
		}		
	});
	$('body').on('click','#erjihuifu',function(){
		var $huifu = $(this);
		var $fatherreview = $(this).parent().parent();
		if($huifu.text()=="回复"){
			$huifu.text("取消");
			var str = "<div class=\"row flex-row d-flex\">"+
                                        "<div class=\"col-lg-12 mt-20\">"+
                                            "<textarea style=\"height:90px\" class=\"form-control\" name=\"message\" placeholder=\"评论一些想法吧...\" onfocus=\"this.placeholder = ''\" onblur=\"this.placeholder = '评论一些想法吧...'\" required=\"\"></textarea>"+
                                           "<div class=\"reply-btn\" style=\"border:solid 1px  #D8D8D8;height:41px;\">"+
                                                "<span  style=\"width:90px;height:40px;float:right;\"id=\"tijiaoerjihuifu\" class=\"btn-reply text-uppercase\">评论</span>" +
                                           "</div>"+
                                        "</div>"+
                                    "</div>";
			//farherreview是小的子评论
			$fatherreview.after($(str));
			$fatherreview.next().find('#tijiaoerjihuifu').click(function(){
				var reviewtextarea = $(this).parent().prev();
				var reviewcotent = reviewtextarea.val();	
				//整个的包括review和输入框的
				var reviewelement = $(this).parent().parent().parent().parent();
				var reviewId = $(this).parent().parent().parent().parent().attr("name");
				//alert(reviewcotent);
				//alert(commentId);
				
				if(reviewcotent==""||reviewcotent=="评论一些想法吧..."){
				}else{
							$.ajax({
									type:"post",
									url:"addReviewtoReviewServlet",
									context:document.body,
									dataType:"text",
									data:{"reviewId":reviewId,"reviewcotent":reviewcotent},
									success:function(result){
										if(result!=""){
											//alert(result);
											var jsoncomment = JSON.parse(result);
											reviewtextarea.val('');
											$huifu.text("回复");
											
//											while($fathercomment.next().attr("id")=="itissecond"){
//													$fathercomment.next().remove();
//											}
											while(reviewelement.attr("id")!="itisfirst"){
												reviewelement = reviewelement.prev();
											}
											var huifunum = reviewelement.find('#bt_chaer').next().text();
											alert(huifunum);
											reviewelement.find('#bt_chaer').next().text(parseInt(huifunum)+1);
											$fatherreview.next().remove();
											
											
											var str = "<div class=\"comment-list \" id=\"itissecond\" name=\""+jsoncomment.reviewId+"\">"+
                                            //在这里哦
                                            "<div class=\"single-comment justify-content-between d-flex\">"+
                                                "<div class=\"user justify-content-between d-flex col-lg-8 ml-50\">"+
                                                    "<div class=\"thumb col-lg-2 \">"+
                                                        "<img src=\"img/asset/c2.jpg\">"+
                                                    "</div>"+
                                                    "<div class=\"desc col-lg-10\">"+
                                                        "<h5><a href=\"#\" tohome=\""+jsoncomment.userId+"\">"+jsoncomment.nickName+"</a></h5>"+
                                                        "<p class=\"date\">"+jsoncomment.remarkstr+"</p>"+
                                                        "<p class=\"comment\">"+
                                                            jsoncomment.content+
                                                        "</p>"+
                                                    "</div>"+
                                                "</div>"+
                                                "<div class=\"reply-btn col-lg-2\" >"+
                                                       "<span  id=\"erjihuifu\" class=\"btn-reply text-uppercase\">回复</span>" +
                                                "</div>"+
                                            "</div>"+
                                        "</div>";
											
										reviewelement.after($(str));
										}else{
											
										}
									}
							});
				
				}
			
			});
		}else{
			$huifu.text("回复");
			$fatherreview.next().remove();
			
		}
	});
	
	 $('body').on('click','[tohome]',function(){
    		var otheruserId = $(this).attr("tohome");
    		alert(otheruserId);
    		$(location).attr("href","clickHeadToHomeServlet?"+"otheruserId="+otheruserId); 
    	
    });
	
	
	
});
</script>
    </html>