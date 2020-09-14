<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board List</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board List
                            <button id="regBtn" type="button" class="btn btn-xs pull-right">
                            	New Board
                            </button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table class="table table-striped table-bordered table-hover">
                            	<theady>
                            		<tr>
                            			<th>#번호</th>
                            			<th>제목</th>
                            			<th>작성자</th>
                            			<th>작성일</th>
                            			<th>수정일</th>
                            		</tr>
                            	</theady>
                            	<c:forEach items="${list }" var="board">
                            		<tr>
                            			<td>${board.bno } </td>
                            			<td><a href="get?bno=${board.bno }">${board.title } </a></td>
                            			<td>${board.writer } </td>
                            			<td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd hh:mm:ss"/> </td>
                            			<td><fmt:formatDate value="${board.updatedate }" pattern="yyyy-MM-dd hh:mm:ss"/> </td>
                            		</tr>
                            	</c:forEach>
                            </table>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <!-- Modal -->
              <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              	<div class="modal-dialog">
                	<div class="modal-content">
                       <div class="modal-header">
                       	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                       </div>
                       <div class="modal-body">
							처리완료 되었습니다.
                       </div>
                       <div class="modal-footer">
                         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                         <button type="button" class="btn btn-primary">Save changes</button>
                       </div>
                       </div>
                                    <!-- /.modal-content -->
                       </div>
                                <!-- /.modal-dialog -->
                       	</div>
                            <!-- /.modal -->
            
<script type="text/javascript">
	$(document).ready(function() {
		var result = '<c:out value="${result}"/>'
		checkModal(result);
		
		history.replaceState({}, null, null);	//히스토리를 비운다.
		function checkModal(result){
			if(result == "" || history.state){
				return;
			}else{
				$(".modal-body").html('게시글' + result);
			}
			/* if(parseInt(result) > 0){
				$(".modal-body").html("게시글 " + parseInt(result) + "번이 등록되었습니다.");
			} */
			$("#myModal").modal("show");
		}
		
		$("#regBtn").on("click", function() {
			self.location="/board/register";
		});
	});
</script>
            
<%@ include file="../include/footer.jsp" %>        