﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0070)http://localhost:8080/news/newspages/topic_modify.jsp -->
<HEAD>
<base href="<%=basePath%>">
<META content="no-cache" http-equiv="pragma">
<META content="text/html; charset=utf-8" http-equiv="Content-Type">
<META content="no-cache" http-equiv="cache-control">
<META content="0" http-equiv="expires">
<META content="keyword1,keyword2,keyword3" http-equiv="keywords">
<META content="This is my page" http-equiv="description">
<TITLE>新闻发布系统管理后台</TITLE><LINK rel="stylesheet" type="text/css" href="Ch07/sj/sj2/xwfbxt/admin.css">
<META name="GENERATOR" content="MSHTML 9.00.8112.16553"></HEAD>
<BODY>
<DIV id="header">
<DIV id="welcome">欢迎使用新闻管理系统！</DIV>
<DIV id="nav">
<DIV id="logo"><IMG alt="新闻中国" src="E:\Jsp素材\JSP素材\jsp工具以及素材\JSP所有素材\新闻发布系统静态页面原型\新闻发布系统\管理后台-修改主题_files/logo.jpg"></DIV>
<DIV id="a_b01"><IMG alt="" src="E:\Jsp素材\JSP素材\jsp工具以及素材\JSP所有素材\新闻发布系统静态页面原型\新闻发布系统\管理后台-修改主题_files/a_b01.gif"></DIV></DIV></DIV>
<DIV id="admin_bar">
<DIV id="status">管理员： admin 登录  &nbsp;&nbsp;&nbsp;&nbsp; <A href="http://localhost:8080/news/util/do_logout.jsp">login 
out</A></DIV>
<DIV id="channel"> </DIV></DIV>
<SCRIPT type="text/javascript">
	function check(){
		var tname = document.getElementById("tname");

		if(tname.value == ""){
			alert("请输入主题名称！！");
			tname.focus();
			return false;
		}		
		return true;
	}
</SCRIPT>

<DIV id="main">
<DIV id="opt_list">
<UL>
  <LI><A 
  href="http://localhost:8080/news/util/news_control.jsp?opr=findTopics">添加新闻</A></LI>
  <LI><A 
  href="http://localhost:8080/news/util/news_control.jsp?opr=list">编辑新闻</A></LI>
  <LI><A href="http://localhost:8080/news/newspages/topic_add.jsp">添加主题</A></LI>
  <LI><A 
href="http://localhost:8080/news/TopicServlet?opr=list">编辑主题</A></LI></UL></DIV>
<DIV id="opt_area">
<H1 id="opt_type"> 修改主题： </H1>
<FORM onsubmit="return check()" method="post" action="UPDATExgzt?opr=">
<P><LABEL> 主题名称 </LABEL><INPUT id="tname" class="opt_input" name="tname" value="" 
type="text"><INPUT name="tid" value="1" type="hidden"></P><INPUT name="action" 
value="addtopic" type="hidden"><INPUT class="opt_sub" value="提交" type=""><INPUT class="opt_sub" value="重置" type="reset"></FORM></DIV>
</DIV>
<DIV id="site_link"> <A href="http://localhost:8080/news/newspages/topic_modify.jsp?tid=1&amp;tname=国内#">关于我们</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/newspages/topic_modify.jsp?tid=1&amp;tname=国内#">Aboue 
Us</A><SPAN>|</SPAN> <A href="http://localhost:8080/news/newspages/topic_modify.jsp?tid=1&amp;tname=国内#">联系我们</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/newspages/topic_modify.jsp?tid=1&amp;tname=国内#">广告服务</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/newspages/topic_modify.jsp?tid=1&amp;tname=国内#">供稿服务</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/newspages/topic_modify.jsp?tid=1&amp;tname=国内#">法律声明</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/newspages/topic_modify.jsp?tid=1&amp;tname=国内#">招聘信息</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/newspages/topic_modify.jsp?tid=1&amp;tname=国内#">网站地图</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/newspages/topic_modify.jsp?tid=1&amp;tname=国内#">留言反馈</A> 
</DIV>
<DIV id="footer">
<P>24小时客户服务热线：010-68988888  &nbsp;&nbsp;&nbsp;&nbsp; <A href="http://localhost:8080/news/newspages/topic_modify.jsp?tid=1&amp;tname=国内#">常见问题解答</A> 
&nbsp;&nbsp;&nbsp;&nbsp;  新闻热线：010-627488888<BR>文明办网文明上网举报电话：010-627488888  
&nbsp;&nbsp;&nbsp;&nbsp;  举报邮箱：<A href="http://localhost:8080/news/newspages/topic_modify.jsp?tid=1&amp;tname=国内#">jubao@jb-aptech.com.cn</A></P>
<P class="copyright">Copyright © 1999-2009 News China gov, All Right 
Reserver<BR>新闻中国   版权所有</P></DIV></BODY></HTML>
