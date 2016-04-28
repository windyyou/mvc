<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%String path = request.getContextPath(); %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <script type="text/javascript" src="<%=path %>/js/jquery-1.7.1.min.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/themes/default/js/jquery-1.9.1.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/themes/default/js/jquery-ui-1.10.4.custom.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/* 	function del(id){
		$.get("${pageContext.request.contextPath}/user/delUser/" + id+"..action",function(data){
			if("success" == data.result){
				alert("删除成功");
				window.location.reload();
			}else{
				alert("删除失败");
			}
		});
	} */
	
	function deleteUser(url,id) {
        if(confirm('确定删除')){
       $.ajax({
           url : url,
           data : {id:id},
           type : 'POST',
           dataType : "json",
           cache : false,
           success : function(data) {
               alert("删除成功");
               document.location.reload();
           },
           error : function(data) {
               alert("删除失败");
           }
       });
        }
   }
</script>
</head>
<body>
	<h6><a href="${pageContext.request.contextPath}/user/toAddUser.action">添加用户</a></h6>
	<table border="1">
		<tbody>
			<tr>
			    <th>标号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th colspan="1">操作</th>
			</tr>
			<c:if test="${!empty userList}">
				<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.id }</td>
						<td>${user.username }</td>
						<td>${user.password }</td>
						<td>
							<a href="${pageContext.request.contextPath}/user/getUser/${user.id }.action">编辑</a>|
							<%-- <a href="javascript:del('${user.id }')">删除</a> --%>
							<a onclick="deleteUser('${pageContext.request.contextPath}/user/delUser.action',${user.id})" style="cursor: pointer;">删除</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>