<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0068)http://localhost:8080/news/util/news_control.jsp -->
<HEAD>
<META content="no-cache" http-equiv="pragma">
<META content="text/html; charset=utf-8" http-equiv="Content-Type">
<META content="no-cache" http-equiv="cache-control">
<META content="0" http-equiv="expires">
<META content="keyword1,keyword2,keyword3" http-equiv="keywords">
<META content="This is my page" http-equiv="description">
<TITLE>新闻发布系统管理后台</TITLE><LINK rel="stylesheet" type="text/css" href="管理后台-修改新闻_files/admin.css">
<META name="GENERATOR" content="MSHTML 9.00.8112.16553"></HEAD>
<BODY>
<DIV id="header">
<DIV id="welcome">欢迎使用新闻管理系统！</DIV>
<DIV id="nav">
<DIV id="logo"><IMG alt="新闻中国" src="管理后台-修改新闻_files/logo.jpg"></DIV>
<DIV id="a_b01"><IMG alt="" src="管理后台-修改新闻_files/a_b01.gif"></DIV></DIV></DIV>
<DIV id="admin_bar">
<DIV id="status">管理员： admin 登录  &nbsp;&nbsp;&nbsp;&nbsp; <A href="http://localhost:8080/news/util/do_logout.jsp">login 
out</A></DIV>
<DIV id="channel"> </DIV></DIV>
<SCRIPT type="text/javascript">
	function check(){
		var ntitle = document.getElementById("ntitle");
		var nauthor = document.getElementById("nauthor");
		var nsummary = document.getElementById("nsummary");
		var ncontent = document.getElementById("ncontent");
		
		if(ntitle.value == ""){
			alert("标题不能为空！！");
			ntitle.focus();
			return false;
		}else if(nauthor.value == ""){
			alert("作者不能为空！！");
			nauthor.focus();
			return false;
		}else if(nsummary.value == ""){
			alert("摘要不能为空！！");
			nsummary.focus();
			return false;
		}else if(ncontent.value == ""){
			alert("内容不能为空！！");
			ncontent.focus();
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
  <LI><A href="http://localhost:8080/news/util/topic_add.jsp">添加主题</A></LI>
  <LI><A 
href="http://localhost:8080/news/TopicServlet?opr=list">编辑主题</A></LI></UL></DIV>
<DIV id="opt_area">
<H1 id="opt_type"> 编辑新闻： </H1>
<FORM onsubmit="return check()" encType="multipart/form-data" method="post" 
action="../util/news_control.jsp?opr=updateNews">
<P><LABEL> 主题 </LABEL><SELECT name="ntid"><OPTION value="1">国内</OPTION><OPTION 
  value="2">国际</OPTION><OPTION value="3">军事</OPTION><OPTION 
  value="4">体育</OPTION><OPTION value="5">娱乐</OPTION><OPTION 
  value="6">社会</OPTION><OPTION value="7">财经</OPTION><OPTION 
  value="8">科技</OPTION><OPTION value="9">健康</OPTION><OPTION 
  value="10">汽车</OPTION><OPTION value="11">教育</OPTION><OPTION 
  value="12">房产</OPTION><OPTION value="13">家居</OPTION><OPTION 
  value="14">旅游</OPTION><OPTION value="15">文化</OPTION><OPTION 
  value="16">其它</OPTION><OPTION value="28">探索</OPTION><OPTION 
  value="29">另类</OPTION><OPTION value="68">xxoo</OPTION><OPTION 
  value="69">ooxx</OPTION></SELECT><INPUT name="nid" value="197" 
type="hidden"></P>
<P><LABEL> 标题 </LABEL><INPUT id="ntitle" class="opt_input" name="ntitle" value="一个女的和一个男的不得不讲的故事" 
type="text"></P>
<P><LABEL> 作者 </LABEL><INPUT id="nauthor" class="opt_input" name="nauthor" 
value="无名" type="text"></P>
<P><LABEL> 摘要 </LABEL><TEXTAREA id="nsummary" cols="40" rows="3" name="nsummary">一个女的跟一个男的不得不讲的故事</TEXTAREA></P>
<P><LABEL> 内容 </LABEL><TEXTAREA id="ncontent" cols="70" rows="10" name="ncontent">一个女的跟一个男的不得不讲的故事</TEXTAREA></P>
<P><LABEL> 上传图片 </LABEL><INPUT id="file" class="opt_input" name="file" type="file"></P><INPUT class="opt_sub" value="提交" type="submit"><INPUT class="opt_sub" value="重置" type="reset"></FORM>
<H1 id="opt_type">修改新闻评论：	</H1>
<TABLE width="80%" align="left">
  <TBODY>
  <TR>
    <TD colSpan="6"> 暂无评论！ </TD>
  <TR>
    <TD colSpan="6">
      <HR>
    </TD></TR></TBODY></TABLE></DIV></DIV>
<DIV id="site_link"> <A href="http://localhost:8080/news/util/news_control.jsp?opr=findNew&amp;nid=197#">关于我们</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/util/news_control.jsp?opr=findNew&amp;nid=197#">Aboue 
Us</A><SPAN>|</SPAN> <A href="http://localhost:8080/news/util/news_control.jsp?opr=findNew&amp;nid=197#">联系我们</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/util/news_control.jsp?opr=findNew&amp;nid=197#">广告服务</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/util/news_control.jsp?opr=findNew&amp;nid=197#">供稿服务</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/util/news_control.jsp?opr=findNew&amp;nid=197#">法律声明</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/util/news_control.jsp?opr=findNew&amp;nid=197#">招聘信息</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/util/news_control.jsp?opr=findNew&amp;nid=197#">网站地图</A><SPAN>|</SPAN> 
<A href="http://localhost:8080/news/util/news_control.jsp?opr=findNew&amp;nid=197#">留言反馈</A> 
</DIV>
<DIV id="footer">
<P>24小时客户服务热线：010-68988888  &nbsp;&nbsp;&nbsp;&nbsp; <A href="http://localhost:8080/news/util/news_control.jsp?opr=findNew&amp;nid=197#">常见问题解答</A> 
&nbsp;&nbsp;&nbsp;&nbsp;  新闻热线：010-627488888<BR>文明办网文明上网举报电话：010-627488888  
&nbsp;&nbsp;&nbsp;&nbsp;  举报邮箱：<A href="http://localhost:8080/news/util/news_control.jsp?opr=findNew&amp;nid=197#">jubao@jb-aptech.com.cn</A></P>
<P class="copyright">Copyright © 1999-2009 News China gov, All Right 
Reserver<BR>新闻中国   版权所有</P></DIV></BODY></HTML>
