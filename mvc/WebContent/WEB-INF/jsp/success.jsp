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
$(document).ready(function(){
    
    $(".checkwow").attr("disabled","disabled");
    $(".checkwow").attr("checked",false);
    $('#1-1').removeAttr("disabled");
    $('#1-2').removeAttr("disabled");
    $('#1-3').removeAttr("disabled");
    

	$(".checkwow").click(function(id){
		var id = $(this).attr("id");
		var row = id.substr(0,1);
	    var cloumn = id.substr(2,1);
	    //alert(row);
	    //alert(cloumn);
	    //判断上一行
	    var rowcheckFlg = true;
	    //取消相同行
	    for(var i=1;i<4;i++){
	        //alert(i);
	        if(i != cloumn){
	            $("#"+row+"-"+i).attr("checked",false);
	        }else{
	            if($("#"+row+"-"+i).is(':checked')==false){
	                rowcheckFlg = false;
	            }
	        }
	    }
	    //当前行取消的话，下面全部取消
	    var rowcount = 0;
	    for(var i=1;i<4;i++){
	        if($("#"+row+"-"+i).is(':checked')==false){
	            //alert("#"+row+"-"+i+":"+rowcount);
	            rowcount = eval(rowcount)+eval(1);
	        }
	    }
	    //alert(rowcheckFlg);
	    //alert(rowcount);
	    if(rowcount ==3 && !rowcheckFlg){
	        for(var j=eval(row)+eval(1);j<10;j++){
	            for(var i=1;i<4;i++){
	                $("#"+j+"-"+i).attr("disabled","disabled");
	                $("#"+j+"-"+i).attr("checked",false);
	            }
	        }
	    }
	    
	    //显示下一行
	    if(rowcount ==2 && rowcheckFlg){
	        var rowNext= eval(row) +eval(1);
	        //alert(rowNext);
	        for(var i=1;i<4;i++){
	            $("#"+rowNext+"-"+i).removeAttr("disabled");
	        }   
	    }
	})
    
});


/* function check(id){
	var row = id.substr(0,1);
	var cloumn = id.substr(2,1);
	//alert(row);
	//alert(cloumn);
	//判断上一行
	var rowcheckFlg = true;
	//取消相同行
	for(var i=1;i<4;i++){
		//alert(i);
		if(i != cloumn){
			$("#"+row+"-"+i).attr("checked",false);
		}else{
			if($("#"+row+"-"+i).is(':checked')==false){
				rowcheckFlg = false;
			}
		}
	}
	//当前行取消的话，下面全部取消
	var rowcount = 0;
	for(var i=1;i<4;i++){
		if($("#"+row+"-"+i).is(':checked')==false){
			//alert("#"+row+"-"+i+":"+rowcount);
			rowcount = eval(rowcount)+eval(1);
		}
	}
	//alert(rowcheckFlg);
	//alert(rowcount);
	if(rowcount ==3 && !rowcheckFlg){
		for(var j=eval(row)+eval(1);j<10;j++){
			for(var i=1;i<4;i++){
				$("#"+j+"-"+i).attr("disabled","disabled");
				$("#"+j+"-"+i).attr("checked",false);
			}
		}
	}
	
	//显示下一行
	if(rowcount ==2 && rowcheckFlg){
		var rowNext= eval(row) +eval(1);
		//alert(rowNext);
		for(var i=1;i<4;i++){
	        $("#"+rowNext+"-"+i).removeAttr("disabled");
	    }	
	}
} */


</script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/first/next.action" id="tfsForm" method="post" >
    <% String name = (String)request.getAttribute("name"); %>
    <%=name %>
    <br/>
    ${name }
    <br/>
    <input name="name" value="${name}" />
    <br/>
    ${user.name }
    ${user.pwd }
    <br/>
    
    <table>
    <%
    for(int i =1;i <10 ;i++){
        %>
        <tr>
        <td><%=i %>-1<input name="tfs" type="checkbox" id="<%=i %>-1" value="<%=i %>-1" class="checkwow" ></td>
        <td><%=i %>-2<input name="tfs" type="checkbox" id="<%=i %>-2" value="<%=i %>-2" class="checkwow" ></td>
        <td><%=i %>-3<input name="tfs" type="checkbox" id="<%=i %>-3" value="<%=i %>-3" class="checkwow" ></td>
        </tr>
    <%    
    }
    %>
    <tr><td><input type="submit" value="submit"></input></td></tr>
    </table>
    </form>
    
</body>
</html>