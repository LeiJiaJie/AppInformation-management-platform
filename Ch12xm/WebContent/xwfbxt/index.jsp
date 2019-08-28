<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0027)http://localhost:8080/news/ -->
<HEAD>
<META content="text/html; charset=utf-8" http-equiv="Content-Type">
<TITLE>新闻中国</TITLE><LINK rel="stylesheet" type="text/css" href="index_files/main.css">
<script type="text/javascript" src="jquery-1.12.4.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var currPageNo=1;
	var totalPageCount=1;
	var currPageNo = 1;
	var comment = 0;
function name() {
	$.ajax({
		"url":"../NewSelectServlet",
		"type":"post",
		"data":"org=showNews&currPageNo="+currPageNo+"&comment="+comment,
		"dataType":"json",
		"success":NewSelect
	});
}

function selectComment() {
	$.ajax({
		"url":"../NewSelectServlet",
		"type":"post",
		"data":"org=showcomment",
		"datatype":"json",
		"success":CommentSelect
	});
}
function CommentSelect(data) {
	$("#class_month").children().remove();
	var json = JSON.parse(data);
	for (var i = 0; i < json.length; i++) {
		$("#class_month").append("<a href='javascript:void(0)' id='"+json[i].tid+"'>"+json[i].tname+"<a>");
	}
	$("#class_month a").click(function() {
		comment = $(this).attr('id');
		name();
	});
}
function NewSelect(data) {
	$("#xw").children().remove();
	$("#fenye").children().remove();
	currPageNo = data.currPageNo;
	totalPageCount = data.totalPageCount;
	for (var i = 0; i < data.newsList.length; i++) {
		$("#xw").append("<LI><A href=http://localhost:8080/news/util/news_control.jsp?opr=readNew&amp;nid="+data.newsList[i].nid+">"+data.newsList[i].ntitle+"</A><SPAN>"+data.newsList[i].time+"</SPAN></LI>")
	}
	$("#fenye").append("<P align=right id='pname'> 当前页数:["+data.currPageNo+"/"+data.totalPageCount+"]"
			  +"<a href='javascript:void(0)'>首页</a>&nbsp;"
			  +"<a href='javascript:void(0)'>上一页</a>"
			  +"<a href='javascript:void(0)'>下一页</a>"
			  +"<a href='javascript:void(0)'>末页</a>"
			  +"</P>");
	$("#pname a").click(function(){
		var str = $(this).text();
		switch(str){
		case "首页":
			currPageNo = 1;
			break;
		case "上一页":
			currPageNo = currPageNo-1;
			if(currPageNo<1){
				currPageNo = 1;
			}
			break;
		case "下一页":
			currPageNo = currPageNo+1;
			if(currPageNo>totalPageCount){
				currPageNo = totalPageCount;
			}
			break;
		case "末页":
			currPageNo = totalPageCount;
			break;
		}
		name();
	});
}
function check(){
	var login_username = document.getElementById("uname");
	var login_password = document.getElementById("upwd");
	if(login_username.value == ""){
		alert("用户名不能为空！请重新填入！");
		login_username.focus();	
		return false;
	}else if(login_password.value == ""){
		alert("密码不能为空！请重新填入！");
		login_password.focus();
		return false;
	}
		return true;
	}
		name();	
		selectComment();
	});
</script>
<META name="GENERATOR" content="MSHTML 9.00.8112.16553"></HEAD>
<BODY>
<DIV id="header">
<DIV id="top_login">
<FORM onsubmit="return check()" method="post" action="glht.jsp"><LABEL> 
登录名 </LABEL><INPUT id="uname" class="login_input" name="uname" 
type="text"><LABEL> 密&nbsp;&nbsp;码 </LABEL><INPUT id="upwd" class="login_input" 
name="upwd" 
type="password"><INPUT class="login_sub" value="登录" type="submit"><LABEL id="error"> 
</LABEL><IMG id="friend_logo" alt="Google" 
src="index_files/friend_logo.gif"></FORM></DIV>
<DIV id="nav">
<DIV id="logo"> <IMG alt="新闻中国" src="index_files/logo.jpg"> </DIV>
<DIV id="a_b01"> <IMG alt="" src="index_files/a_b01.gif"> </DIV><!--mainnav end--></DIV>
</DIV>
<DIV id="container">
<DIV class="sidebar">
<H1> <IMG alt="国内新闻" src="index_files/title_1.gif"> </H1>
<DIV class="side_list">
<UL id="ul">
  
</UL></DIV></DIV>
<DIV class="main">
<DIV class="class_type"> <IMG alt="新闻中心" src="index_files/class_type.gif"> 
</DIV>
<DIV class="content">
<UL class="class_date">
  <LI id="class_month"></LI></UL>
<UL class="classlist" id="xw">
  
</UL>
<UL class="classlist" id="fenye">
  
</UL>
</DIV></DIV></DIV>
<DIV id="friend">
<H1 class="friend_t"> <IMG alt="合作伙伴" src="index_files/friend_ico.gif"> </H1>
<DIV class="friend_list">
<UL>
  <LI> <A href="http://localhost:8080/news/#">百度</A> </LI>
  <LI> <A href="http://localhost:8080/news/#">谷歌</A> </LI>
  <LI> <A href="http://localhost:8080/news/#">新浪</A> </LI>
  <LI> <A href="http://localhost:8080/news/#">网易</A> </LI>
  <LI> <A href="http://localhost:8080/news/#">搜狐</A> </LI>
  <LI> <A href="http://localhost:8080/news/#">人人</A> </LI>
  <LI> <A href="http://localhost:8080/news/#">中国政府网</A> </LI></UL></DIV></DIV>
<DIV id="footer">
<P> 24小时客户服务热线：010-68988888 &nbsp;&nbsp;&nbsp;&nbsp; <A href="http://localhost:8080/news/#">常见问题解答</A> 
&nbsp;&nbsp;&nbsp;&nbsp; 新闻热线：010-627488888 <BR>文明办网文明上网举报电话：010-627488888 
&nbsp;&nbsp;&nbsp;&nbsp; 举报邮箱： <A 
href="http://localhost:8080/news/#">jubao@jb-aptech.com.cn</A> </P>
<P class="copyright"> Copyright © 1999-2009 News China gov, All Right Reserver 
<BR>新闻中国 版权所有 </P></DIV></BODY></HTML>
