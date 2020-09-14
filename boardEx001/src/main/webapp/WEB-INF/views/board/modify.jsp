<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

			<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Modify</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Modify
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <form action="/board/modify" method="post">
                            
                            	<div class="form-grop">
                            		<label for="">Bno</label>
                            		<input value="${board.bno }" name="bno" class="form-control" readonly="readonly"/>
                            	</div>
                            	<div class="form-grop">
                            		<label for="">Title</label>
                            		<input value="${board.title }" name="title" class="form-control" />
                            	</div>
                            	<div class="form-grop">
                            		<label for="">Content</label>
                            		<textarea name="content" row="3" class="form-control" >${board.content }</textarea>
                            	</div>
                            	<div class="form-grop">
                            		<label for="">Writer</label>
                            		<input value="${board.writer }" name="writer" class="form-control" /><br>
                            	</div>
                            	
                            	<button type="submit" data-oper="modify" class="btn btn-primary">Modify</button>
                            	<button type="button" data-oper="list" class="btn btn-default">List</button>
                            </form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form");
		$("button[data-oper='list']").on("click", function(){
			formObj.attr("method", "get")
			formObj.attr("action", "/board/list");
			formObj.submit();
		});
	});
</script>            
            
<%@ include file="../include/footer.jsp" %>        
