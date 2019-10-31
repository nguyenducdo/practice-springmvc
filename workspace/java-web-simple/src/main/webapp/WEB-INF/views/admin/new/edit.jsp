<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Dashboard</a>
                </li>
                <c:if test="${not empty newDTO.id}">
                	<li class="active">Edit news</li>
                </c:if>
                <c:if test="${empty newDTO.id}">
                	<li class="active">Create news</li>
                </c:if>
                
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                        <c:if test="${not empty message}">
                            <div class="alert alert-${alert}">
                                    ${message}
                            </div>
                        </c:if>
                        <form:form id="submitForm" modelAttribute="newDTO">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Category</label>
                                <div class="col-sm-9">
                                    <form:select path="categoryCode" class="form-control" id="categoryCode">
                                       <option disabled selected>-- Select a category --</option>
                                       <form:options items="${categories}"/>
                                    </form:select>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Title</label>
                                <div class="col-sm-9">
                                    <form:input type="text" class="form-control" id="title" path="title"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Thumbnail</label>
                                <div class="col-sm-9">
                                    <form:input type="text" class="form-control" id="thumbnail" path="thumbnail"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Short description</label>
                                <div class="col-sm-9">
                                    <form:input type="text" class="form-control" id="shortDescription" path="shortDescription"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Content</label>
                                <div class="col-sm-9">                                 
                                    <form:textarea rows="" cols="" id="content" path="content" style="width: 820px;height: 175px"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <div class="col-sm-12" style="text-align: center; margin-top: 15px; margin-bottom: 15px">
                                    <c:if test="${not empty newDTO.id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Save" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                    <c:if test="${empty newDTO.id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Create" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                </div>
                            </div>
                            <form:hidden id="newId" path="id"/>
                        </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<c:url var="newAPI" value="/api/new"/>
<c:url var="newListUrl" value="/admin-news/list"/>
<c:url var="newUpdateUrl" value="/admin-news/update"/>

<script type="text/javascript">
	$("#btnAddOrUpdateNew").click(function(e){
		e.preventDefault();
		var data = {};
        var formData = $('#submitForm').serializeArray();
        $.each(formData,function(i,v){
            data[v.name+""] = v.value;
        });
        var id = $("#newId").val();
        if(id==""){
            createNew(data); 
        }else{
            updateNew(data);
        }
	});

    function createNew(data){
        $.ajax({
            url : '${newAPI}',
            type : 'POST',
            contentType : 'application/json',
            data : JSON.stringify(data),
            dataType : 'json',
            success : function(result){
            	window.location.href = "${newListUrl}?page=1&limit=5&message=create_success"
            	/* console.log(result); */
            },
            error : function(error){
                window.location.href = "${newUpdateUrl}?message=error"
            	/* console.log(error); */
                
            }
        });
    }

    function updateNew(data){
        $.ajax({
            url : '${newAPI}',
            type : 'PUT',
            contentType : 'application/json',
            data : JSON.stringify(data),
            dataType : 'json',
            success : function(result){
            	window.location.href = "${newListUrl}?message=edit_success"
            	/* window.location.href = "${newUpdateUrl}?id="+$("#newId").val()+"&message=error" */
                /* console.log(result); */
            },
            error : function(error){
            	window.location.href = "${newUpdateUrl}?id="+$("#newId").val()+"&message=error"
                /* console.log(error); */
            }
        });
    }

</script>
</body>
</html>