<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0049)http://localhost:8080/news/newspages/news_add.jsp -->
<HEAD>
<META content="text/html; charset=utf-8" http-equiv="Content-Type">
<TITLE>添加主题--管理后台</TITLE><LINK rel="stylesheet" type="text/css" href="管理后台-添加新闻_files/admin.css">
<META name="GENERATOR" content="MSHTML 9.00.8112.16553"></HEAD>
<BODY>
<META content="no-cache" http-equiv="pragma">
<META content="no-cache" http-equiv="cache-control">
<META content="0" http-equiv="expires">
<META content="keyword1,keyword2,keyword3" http-equiv="keywords">
<META content="This is my page" http-equiv="description">
<TITLE>新闻发布系统管理后台</TITLE><LINK rel="stylesheet" type="text/css" href="管理后台-添加新闻_files/admin.css">
<DIV id="header">
<DIV id="welcome">欢迎使用新闻管理系统！</DIV>
<DIV id="nav">
<DIV id="logo"><IMG alt="新闻中国" src="管理后台-添加新闻_files/logo.jpg"></DIV>
<DIV id="a_b01"><IMG alt="" src="管理后台-添加新闻_files/a_b01.gif"></DIV></DIV></DIV>
<DIV id="admin_bar">
<DIV id="status">管理员： admin 登录  &nbsp;&nbsp;&nbsp;&nbsp; <A href="http://localhost:8080/news/util/do_logout.jsp">login 
out</A></DIV>
<DIV id="channel"> </DIV></DIV>
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
<H1 id="opt_type"> 添加新闻： </H1>
<FORM encType="multipart/form-data" method="post" action="../util/news_control.jsp?opr=addNews">
<P><LABEL> 主题 </LABEL><SELECT id="ntid" name="ntid"><OPTION 
  value="1">国内</OPTION><OPTION value="2">国际</OPTION><OPTION 
  value="3">军事</OPTION><OPTION value="4">体育</OPTION><OPTION 
  value="5">娱乐</OPTION><OPTION value="6">社会</OPTION><OPTION 
  value="7">财经</OPTION><OPTION value="8">科技</OPTION><OPTION 
  value="9">健康</OPTION><OPTION value="10">汽车</OPTION><OPTION 
  value="11">教育</OPTION><OPTION value="12">房产</OPTION><OPTION 
  value="13">家居</OPTION><OPTION value="14">旅游</OPTION><OPTION 
  value="15">文化</OPTION><OPTION value="16">其它</OPTION><OPTION 
  value="28">探索</OPTION><OPTION value="29">另类</OPTION><OPTION 
  value="68">xxoo</OPTION><OPTION value="69">ooxx</OPTION></SELECT></P>
<P><LABEL> 标题 </LABEL><INPUT id="ntitle" class="opt_input" name="ntitle" type="text"></P>
<P><LABEL> 作者 </LABEL><INPUT id='name="nauthor"' class="opt_input" name="nauthor" 
type="text"></P>
<P><LABEL> 摘要 </LABEL><TEXTAREA id="nsummary" cols="40" rows="3" name="nsummary"></TEXTAREA></P>
<P><LABEL> 内容 </LABEL><TEXTAREA id="ncontent" cols="70" rows="10" name="ncontent"></TEXTAREA></P>
<P><LABEL> 上传图片 </LABEL><INPUT name="nfile" type="file"></P><INPUT name="action" 
value="addnews" type="hidden"><INPUT class="opt_sub" value="提交" type="submit"><INPUT class="opt_sub" value="重置" type="reset"></FORM></DIV>
</DIV>
<DIV id="footer">
<DIV id="site_link"> <A href="http://localhost:8080/news/newspages/news_add.jsp#">关于我们</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/newspages/news_add.jsp#">Aboue 
Us</A><SPAN>|</SPAN> <A href="http://localhost:8080/news/newspages/news_add.jsp#">联系我们</A><SPAN>|</SPAN> 
<A 
href="http://localhost:8080/news/newspages/news_add.jsp#">广告服务</A><SPAN>|</SPAN> 
<A 
href="http://localhost:8080/news/newspages/news_add.jsp#">供稿服务</A><SPAN>|</SPAN> 
<A 
href="http://localhost:8080/news/newspages/news_add.jsp#">法律声明</A><SPAN>|</SPAN> 
<A 
href="http://localhost:8080/news/newspages/news_add.jsp#">招聘信息</A><SPAN>|</SPAN> 
<A 
href="http://localhost:8080/news/newspages/news_add.jsp#">网站地图</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/newspages/news_add.jsp#">留言反馈</A> </DIV>
<DIV id="footer">
<P>24小时客户服务热线：010-68988888  &nbsp;&nbsp;&nbsp;&nbsp; <A href="http://localhost:8080/news/newspages/news_add.jsp#">常见问题解答</A> 
&nbsp;&nbsp;&nbsp;&nbsp;  新闻热线：010-627488888<BR>文明办网文明上网举报电话：010-627488888  
&nbsp;&nbsp;&nbsp;&nbsp;  举报邮箱：<A href="http://localhost:8080/news/newspages/news_add.jsp#">jubao@jb-aptech.com.cn</A></P>
<P class="copyright">Copyright © 1999-2009 News China gov, All Right 
Reserver<BR>新闻中国   版权所有</P></DIV></DIV></BODY></HTML>
