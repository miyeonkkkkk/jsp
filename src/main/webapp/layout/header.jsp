<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<% //MemberVO memberVo = (MemberVO) session.getAttribute("S_MEMBER");
// 			   String userId = "";
// 			   if(memberVo == null){
// 				   userId = "";
// 			   }else{
// 				   userId = memberVo.getUserid();
// 			   }
			%>
			<%--<a class="navbar-brand" href="#">JSP/SPRING[<%=userId%>]</a>--%>
			접속을 안했을 때 : 		 ==> []
			접속을 했을 때 : [brown] ==> [brown]
			<a class="navbar-brand" href="#">
			<c:choose>
				<c:when test="${S_MEMBER.userid == null}">
					JSP/SPRING
				</c:when>
				<c:otherwise>
					JSP/SPRING[${S_MEMBER.userid}]
				</c:otherwise>
			</c:choose>
			</a>
<%-- 			<a class="navbar-brand" href="#">JSP/SPRING[<%=memberVo == null ? "" : memberVo.getUserId()%>]</a> --%>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Help</a></li>
				<li><a href="${cp}/logout">LogOut</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>