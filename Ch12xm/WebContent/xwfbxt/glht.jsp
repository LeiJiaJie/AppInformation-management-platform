<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0046)http://localhost:8080/news/newspages/admin.jsp -->
<HEAD>
<META content="no-cache" http-equiv="pragma">
<META content="text/html; charset=utf-8" http-equiv="Content-Type">
<META content="no-cache" http-equiv="cache-control">
<META content="0" http-equiv="expires">
<META content="keyword1,keyword2,keyword3" http-equiv="keywords">
<META content="This is my page" http-equiv="description">
<TITLE>添加主题--管理后台</TITLE><LINK rel="stylesheet" type="text/css" href="admin.css">
<META name="GENERATOR" content="MSHTML 9.00.8112.16553">
<script type="text/javascript" src="jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var org = "showNews";
		function selectNews() {
			org = "showNews";
			$.ajax({
				"url":"../glhtSelectSerlet",
				"datatype":"JSON",
				"type":"post",
				"data":"org="+org,
				"success":NewSelect
			});
		}
		function NewSelect(date) {
			$(".classlist").children().remove();
			var data = JSON.parse(date);
			for (var i = 0; i < data.length; i++) {
				$(".classlist").append("<LI>"+data[i].ntitle+"<SPAN> 作者："+data[i].nauthor+
				"&nbsp;&nbsp;&nbsp;&nbsp; <A href='javascript:void(0)' id="+data[i].nid+">修改</A>"+
				"&nbsp;&nbsp;&nbsp;&nbsp; <A onclick='return clickdel()' href='javascript:void(0)'id="+data[i].nid+">删除</A>"+
				"</SPAN> </LI>");
			if(i%5==0){
				$(".classlist").append("<p></p>");
			}
		}
			
			$("#opt_list ul li a").click(function() {
				var id = $(this).attr('id');
				switch (id) {
				case "bjxw":
					selectNews();
					break;
				case "bjzt":
					selectTopic();
					break;
				case "tjzt":
					insertTopic();
					break;
				default:
					alert("出错了");
					break;
				}
			});
	}
		function insertTopic() {
			org = "insertTopic";
			$(".classlist").children().remove();
			$(".classlist").append("<DIV id='opt_area'><H1 id='opt_type'> 添加主题： </H1>"+
					"<FORM method='post'>"+
					"<P><LABEL> 主题名称 </LABEL><INPUT class='opt_input' name='tname' value=''"+
					"type='text'><INPUT name='tid' value='1' type='hidden'></P><INPUT name='action'"+
					"value='addtopic' type='hidden'><INPUT class='opt_sub' value='提交' type='button' name='submit'><INPUT class='opt_sub' value='重置' type='reset'></FORM></DIV>");
			$(".opt_sub").click(function() {
				$.ajax({
					"url"	:	"../glhtSelectSerlet",
					"type"	:	"post",
					"data"	:	"org="+org+"&name="+$(".opt_input").val(),
					"datatype" :"text",
					"success"  :Topicinsert
				});
				function Topicinsert(data) {
					if(data == "已成功添加主题"){
						alert("添加主题成功");
						selectTopic();
					}else if(data == "已有该主题"){
						alert(data);
					}else{
						alert("出错了");
					}
				}
			})		
		}
		function selectTopic() {
			org = "selectTopic";
			$.ajax({
				"url":"../glhtSelectSerlet",
				"datatype":"JSON",
				"type":"post",
				"data":"org="+org,
				"success":TopicSelect
			});
		}
		function TopicSelect(data) {
			$(".classlist").children().remove();
			var date = JSON.parse(data);
			for (var i = 0; i < date.length; i++) {
				$(".classlist").append("<li>"+date[i].tname+"&nbsp&nbsp&nbsp&nbsp<a href='javascript:void(0)' id="+date[i].tid  + ":"+ date[i].tname+">修改</a>&nbsp&nbsp&nbsp&nbsp<a href='javascript:void(0)' id="+date[i].tid+" >删除</a></li>");
			}
			$(".classlist li a").click(function() {
				var params = this.id.split(":");
				if($(this).text()=="修改"){
					$(".classlist").children().remove();
					$(".classlist").append("<DIV id='opt_area'><H1 id='opt_type'> 修改主题： </H1>"+
					"<FORM method='post'>"+
					"<P><LABEL> 主题名称 </LABEL><INPUT id='"+params[0]+"' class='opt_input' name='tname' value='"+params[1]+"'"+
					"type='text'><INPUT name='tid' value='1' type='hidden'></P><INPUT name='action'"+
					"value='addtopic' type='hidden'><INPUT class='opt_sub' value='提交' type='button' name='submit'><INPUT class='opt_sub' value='重置' type='reset'></FORM></DIV>");
					$(".opt_sub").click(function() {
						org = "xgzt";
						$.ajax({
							"url"			:"../glhtSelectSerlet",
							"type"			:"post",
							"datatype"		:"text",
							"data"			:"org="+org+"&id="+params[0]+"&name="+$(".opt_input").val(),
							"success"		:tjzt
						});
						function tjzt(data) {
							if(data == "已成功更新主题"){
								alert("修改主题成功");
								selectTopic();
							}else if(data == "已有相同主题"){
								alert(data);
							}
						}
					});
				}else{
					if(confirm("确认删除?")){
						org = "sczt";
						$.ajax({
							"url"			:"../glhtSelectSerlet",
							"type"			:"post",
							"datatype"		:"text",
							"data"			:"org="+org+"&id="+$(this).attr('id'),
							"success"		:sczt
						});
						function sczt(data) {
							if(data == "已成功删除主题"){
								alert("删除主题成功");
								selectTopic();
							}else if(data == "该主题下还有文章"){
								alert(data);
							}
						}
					}
				}
			})
		}
		selectNews();
	});  
</script>
</HEAD>
<BODY>
<META content="no-cache" http-equiv="pragma">
<META content="no-cache" http-equiv="cache-control">
<META content="0" http-equiv="expires">
<META content="keyword1,keyword2,keyword3" http-equiv="keywords">
<META content="This is my page" http-equiv="description">
<TITLE>新闻发布系统管理后台</TITLE><LINK rel="stylesheet" type="text/css" href="E:\Jsp素材\JSP素材\jsp工具以及素材\JSP所有素材\新闻发布系统静态页面原型\新闻发布系统\管理后台_files/admin.css">
<DIV id="header">
<DIV id="welcome">欢迎使用新闻管理系统！</DIV>
<DIV id="nav">
<DIV id="logo"><IMG alt="新闻中国" src="E:\Jsp素材\JSP素材\jsp工具以及素材\JSP所有素材\新闻发布系统静态页面原型\新闻发布系统\管理后台_files/logo.jpg"></DIV>
<DIV id="a_b01"><IMG alt="" src="E:\Jsp素材\JSP素材\jsp工具以及素材\JSP所有素材\新闻发布系统静态页面原型\新闻发布系统\管理后台_files/a_b01.gif"></DIV></DIV></DIV>
<DIV id="admin_bar">
<DIV id="status">管理员： admin 登录  &nbsp;&nbsp;&nbsp;&nbsp; <A href="http://localhost:8080/news/util/do_logout.jsp">login 
out</A></DIV>
<DIV id="channel"> </DIV></DIV>
<DIV id="main">
<DIV id="opt_list">
<UL>
  <LI><A href="javascript:void(0)" id='tjxw'>添加新闻</A></LI>
  <LI><A href="javascript:void(0)" id='bjxw'>编辑新闻</A></LI>
  <LI><A href="javascript:void(0)" id='tjzt'>添加主题</A></LI>
  <LI><A href="javascript:void(0)" id='bjzt'>编辑主题</A></LI>
</UL></DIV>
<DIV id="opt_area">
<SCRIPT language="javascript">function clickdel(){
		return confirm("删除请点击确认");
	}
	
</SCRIPT>

<UL class="classlist">
  <LI class="space"></LI>
</UL></DIV></DIV>
<DIV id="footer">
<DIV id="site_link"> <A 
href="http://localhost:8080/news/newspages/admin.jsp#">关于我们</A><SPAN>|</SPAN> <A 
href="http://localhost:8080/news/newspages/admin.jsp#">Aboue Us</A><SPAN>|</SPAN> <A 
href="http://localhost:8080/news/newspages/admin.jsp#">联系我们</A><SPAN>|</SPAN> <A 
href="http://localhost:8080/news/newspages/admin.jsp#">广告服务</A><SPAN>|</SPAN> <A 
href="http://localhost:8080/news/newspages/admin.jsp#">供稿服务</A><SPAN>|</SPAN> <A 
href="http://localhost:8080/news/newspages/admin.jsp#">法律声明</A><SPAN>|</SPAN> <A 
href="http://localhost:8080/news/newspages/admin.jsp#">招聘信息</A><SPAN>|</SPAN> <A 
href="http://localhost:8080/news/newspages/admin.jsp#">网站地图</A><SPAN>|</SPAN> <A 
href="http://localhost:8080/news/newspages/admin.jsp#">留言反馈</A> </DIV>
<DIV id="footer">
<P>24小时客户服务热线：010-68988888  &nbsp;&nbsp;&nbsp;&nbsp; <A href="http://localhost:8080/news/newspages/admin.jsp#">常见问题解答</A> 
&nbsp;&nbsp;&nbsp;&nbsp;  新闻热线：010-627488888<BR>文明办网文明上网举报电话：010-627488888  
&nbsp;&nbsp;&nbsp;&nbsp;  举报邮箱：<A href="http://localhost:8080/news/newspages/admin.jsp#">jubao@jb-aptech.com.cn</A></P>
<P class="copyright">Copyright © 1999-2009 News China gov, All Right 
Reserver<BR>新闻中国   版权所有</P></DIV></DIV></BODY></HTML>
