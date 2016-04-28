<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/themes/default/js/jquery-1.9.1.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/themes/default/js/jquery-ui-1.10.4.custom.js"></script>

<script>
        
        /* $.ajax({
            url : '${pageContext.request.contextPath}/entry/getCertTypeCode.action',
            dataType : 'json',
            success : function(data) {
                specialCetTypeCode = data;
            }

        }); */
        
        
        function checkPwd(form) {
            var $form = $(form);
          $.ajax({
              //url: $form.attr("action"),
              url:"${pageContext.request.contextPath}/first/ajaxLogin.action",
              data: $form.serializeArray(),
              type: form.method,
              dataType:"json",
              cache: false,
              success: function(data) {
                  alert(data.msg);
                  //alert(data.status);
                  if(data.status==1){
                      form.submit();
                  }
              },
              error: function() {
                  //window.location.href='http://127.0.0.1:8080/1.1/';
                  alert("执行失败");
              }
          });
          return false;
      }
</script>
</head>
<body>
    
    <form action="${pageContext.request.contextPath}/first/login.action" id="firstForm" method="post" >
       <table>
        <tr>
            <td>name:</td>
            <td><input name="name" id="name" type="text" value="${name }"/></td>
        </tr>
        <tr>
            <td>pass:</td>
            <td><input name="pwd" id="pwd" type="password"/></td>
        </tr>
        <tr>
          <td>
            <input type="button" value="ajax" onclick="return checkPwd(firstForm)"></input>
            
            <input type="submit" value="submit"></input>
         </td>
        </tr>
       </table>
    </form>
</body>
</html>