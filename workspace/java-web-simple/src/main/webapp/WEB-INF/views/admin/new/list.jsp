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
	<div class="container" style="width: 100%; padding-left: 0px; padding-right: 0px">
		<div class="row" style="margin-left: 0px; margin-right: 0px; margin-top: 30px">
			
			<c:if test="${not empty message}">
            	<div class="alert alert-${alert}" style="width: 98%; margin-left: 1%">
                	${message}
            	</div>
            </c:if>
			<div class="col-md-10 col-md-offset-1" style="width: 98%; margin-left: 1%">
				
				<div class="panel panel-default panel-table">
					<div class="panel-heading">
						<div class="row">
							<div class="col col-xs-6">
								<h3 class="panel-title">Panel Heading</h3>
							</div>
							<div class="col col-xs-6 text-right">
								<button type="button" id="btnCreate" class="btn btn-sm btn-primary btn-create"
								onclick="window.location.href='<c:url value="/admin-news/update"/>'">Create New</button>
								<button type="button" id="btnDelete" class="btn btn-sm btn-primary btn-danger"
								onclick="warningBeforeDelete()">Delete</button>
							</div>
						</div>
					</div>
					<div class="panel-body">
					<form action="<c:url value='/admin-news'/>" id="submitForm" method="get">
						<table class="table table-striped table-bordered table-list">
							<thead>
								<tr>
									<td style="text-align: center; width: 40px"><input type="checkbox" id="checkAll"/></td>
									<th style="text-align: left; width: 50px">ID</th>
									<th>Title</th>
									<th>Thumbnail</th>
									<th>Short Description</th>
									<th>Content</th>
									<th>Category</th>
									<th style="text-align: center; width: 80px"><em
										class="fa fa-cog"></em></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${newDTO.list}" var="element">
									<tr>
										<td style="text-align: center"><input type="checkbox" name="ids" value="${element.id}"></input></td>
										<td>${element.id}</td>
										<td>${element.title}</td>
										<td>${element.thumbnail}</td>
										<td>${element.shortDescription}</td>
										<td>${element.content}</td>
										<td>${element.categoryName}</td>
										
										<!-- editURL -->
										<c:url var="editURL" value="/admin-news/update">
											<c:param name="id" value="${element.id}"/>
										</c:url>
										<!-- /editURL -->
										
										<td style="text-align: center"><a class="btn btn-default" href="${editURL}"><em class="fa fa-pencil"></em></a>
											<!--  <a class="btn btn-danger" href="<c:url value='/admin-news?action=delete&id=${element.id}'/>"><em class="fa fa-trash"></em></a> -->
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<input type="hidden" value="" id="page" name="page"/>
						<input type="hidden" value="" id="limit" name="limit"/>
						<!-- <input type="hidden" value="" id="sortName" name="sortName"/>
						<input type="hidden" value="" id="sortBy" name="sortBy"/> -->
					</form>	
					</div>
					<div class="panel-footer">
						<div class="row">
							<div class="col col-xs-4">Page ${newDTO.startPage} of ${newDTO.totalPage}</div>

							<!-- paging -->
							<div style="position: absolute; right: 15px; padding-right: 15px">
							    <nav aria-label="Page navigation">
							        <ul class="pagination" id="pagination"></ul>
							    </nav>
							</div>
							<c:url var="newAPI" value="/api/new"/>
							<script type="text/javascript">
								var totalPages = ${newDTO.totalPage};
								var startPage = ${newDTO.startPage};
								var limit = 5;
								$(function() {
									window.pagObj = $('#pagination').twbsPagination({
										totalPages : totalPages,
										visiblePages : 3,
										startPage: startPage,
										onPageClick : function(event, page) {
											//console.info(page + ' (from options)');
										}
									}).on('page', function (event, page) {
										console.info(page + ' (from options)');
										$('#page').val(page);
										$('#limit').val(limit);
										//$('#sortName').val('title');
										//$('#sortBy').val('desc');
										$('#submitForm').submit();
							        });
								});
								
							</script>
							
							<!-- /paging -->
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script>
		$("#checkAll").click(function () {
	    	$('tbody input:checkbox').not(this).prop('checked', this.checked);
	 	});
		function warningBeforeDelete() {
			var ids = $('tbody input[type=checkbox]:checked').map(
						function () {
	            			return $(this).val();
	        			}).get();
			if(ids.length <= 0){
				return;
			}
			swal({
			  text: "Delete "+ids.length+" items?",
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonClass: "btn-danger",
			  confirmButtonText: "Yes",
			  cancelButtonText: "No",
			}).then(function(isConfirm) {
			  if (isConfirm.value) {
					deleteNew(ids);
			  }
			});
		}
		
		function deleteNew(data) {
	        $.ajax({
	            url: '${newAPI}',
	            type: 'DELETE',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            success: function (result) {
	            	window.location.href = "${newListUrl}?page=1&limit=5&message=delete_success"
	            },
	            error: function (error) {
	            	window.location.href = "${newListURL}?page=1&limit=5&message=error";
	            }
	        });
	    }
	</script>
</body>
</html>