<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/lee" prefix="lee"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/pages/css/pintuer.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/pages/css/admin.css">
		<script src="${pageContext.request.contextPath}/pages/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/pages/js/pintuer.js"></script>
	</head>
	<script type="text/javascript">
		//权限列表参数
		function authorityChgecked(remark){
			
			if($('#'+remark).prop('checked')==true){
				$("[id^='"+remark+"_']").prop('checked',true);
			}else{
				$("[id^='"+remark+"_']").prop('checked',false);
			}
			
			//反选回去
			var strAuthority4=remark;
			if(remark.lastIndexOf("_")>0){
				//判断哪些 应该选中 
				strAuthority4 = remark.substr(0, remark.lastIndexOf("_"));
				i
				if($("[id^='"+strAuthority4+"_']:checked").size()<1){
					$("#"+strAuthority4).prop('checked',false);
				}else{
					$("#"+strAuthority4).prop('checked',true);
				}
			}
			
			//当前 层级菜单 的上一级id 值：strAuthority4= chk2_1   chk2_1_2
			if(strAuthority4.lastIndexOf("_")>0){
				var strAuthority3 = strAuthority4.substr(0, strAuthority4.lastIndexOf("_"));
				
				if($("[id^='"+strAuthority3+"_']:checked").size()<1){
					$("#"+strAuthority3).prop('checked',false);
				}else{
					$("#"+strAuthority3).prop('checked',true);
				}
			}
		
		
		}
		
	
	</script>
	
<body>
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong><span class="icon-key"></span>权限列表</strong>
			</div>

			<form method="post" action="${pageContext.request.contextPath}/funcAdmin?method=updateRole" id="listform">
				<!-- 隐藏 当前角色的Id -->
				<input type="hidden" name="roleId" value="${roleId }">
				<input type="hidden" name="list" value="" id="list">
				<div id="box">
					<c:forEach items="${sessionScope.menuList }" var="ite" varStatus="stus2">
						<div class="s${ite.menu2.id}">
							<input  type="checkbox" name="authorityIds" id="chk${stus2.index+1}"
									onclick="authority('chk${stus2.index+1}')"
								<%--${lee:checked(userMenu,ite.menu2.id)}--%>

									value="${ite.menu2.id}"/>

							<span style="font-size:18px;">${ite.menu2.name }</span>

							<c:forEach items="${ite.menu2val }" var="im" varStatus="stus3" >
								<div class="s${im.menu3.id }">
									<div style="margin-left: 30px">
										<input type="checkbox"  name="authorityIds" id="chk${stus2.index+1}_${stus3.index+1}"
											   onclick="authority('chk${stus2.index+1}_${stus3.index+1}')"
											<%--${lee:checked(userMenu,im.menu3.id)}--%>
											   value="${im.menu3.id }" />
										<span style="font-size:16px;">${im.menu3.name }</span>
									</div>

									<c:forEach items="${im.menu3Val }" var="ia" varStatus="stus4">
										<div style="margin-left: 30px" >
												<%--<c:if test="${stus4.index%5==0 }"><br/></c:if>--%>&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="checkbox"  name="authorityIds"
												   id="chk${stus2.index+1}_${stus3.index+1}_${stus4.index+1}"
											<%--	${lee:checked(userMenu,ia.id )}--%>
												   onclick="authority('chk${stus2.index+1}_${stus3.index+1}_${stus4.index+1}')"
												   value="${ia.id}" />
											<span style="font-size:14px;">${ia.name }</span>
										</div>
									</c:forEach>
								</div>
							</c:forEach>
						</div>
					</c:forEach>
				</div>
				<hr />
				<button type="submit" id="btn" onclick="getlist()">提 交</button>
				<button type="reset">重 置</button>
			</form>
		</div>
	</body>
	
</html>
<script >
	function authority(remark) {
		//全选
		if($('#'+remark).prop("checked")){
			$("[id^='"+remark+"_']").prop("checked",true)
		}else {
			$("[id^='"+remark+"_']").prop("checked",false)
		}
		//反选
		while (remark.lastIndexOf("_")>0){
			if(remark.lastIndexOf("_")>0){
				remark=remark.substr(0,remark.lastIndexOf("_"));
				//console.log(remark)
				if($("[id^='"+remark+"']:checked").size()<1){

					$("#"+remark).prop("checked",false);
				}else {
					$("#"+remark).prop("checked",true);
				}
			}
		}
	}

	function getlist(){
		var list= [];
		$("input").each(function () {
			if ($(this).is(":checked")){
				list.push($(this).val())
			}
		})
		$("#list").val(list)
	}
	/*$("#btn").click(function () {

		/!*$.ajax({
			url:<%=basePath%>+"funcAdmin/method=updateRole ",
			type:"post",
			data:{"list":list},
			dataType:"json",
			success:function (res) {
				console.log(res)
			}
		})*!/
	})*/

	function change() {
		$.ajax({
			url:"${pageContext.request.contextPath}/funcAdmin?method=roleAuthority",
			type:"post",
			data:{"roleId":$('select option:selected').eq(0).val()},
			dataType:"json",
			success:function (resp) {
				//清楚当前 所有 勾选框
				$(':checkbox').each(function () {
					this.checked = false;
				});
				//根据参数  确定哪些勾选 哪些不勾选【拆分数据 绑定到 对应的复选框中】
				console.log(resp);
				/*
                            var js_fy =	JSON.parse(data1);*/

				//找到需要被比对的元素
				var opElement = document.forms["form_1"].elements['authorityIds'];

				console.log(opElement);

				$.each(resp, function (i, dent) {
					console.log(i);
					console.log(dent);
					console.log(dent.id);
					//遍历 确定 哪些可以被勾选上
					for (var j = 0; j < opElement.length; j++) {
						if (opElement[j].value == dent.id) {
							opElement[j].checked = true;
						}
					}
				})

			}
		})

	}
</script>