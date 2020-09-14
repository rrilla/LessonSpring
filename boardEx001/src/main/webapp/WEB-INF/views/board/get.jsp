<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

			<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Get</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Get
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
                        		<div class="form-grop">
                            		<label for="">Bno</label>
                            		<input value="${board.bno }" type="text" name="bno" class="form-control" readonly="readonly"/>
                            	</div>
                            	<div class="form-grop">
                            		<label for="">Title</label>
                            		<input value="${board.title }" type="text" name="title" class="form-control" readonly="readonly"/>
                            	</div>
                            	<div class="form-grop">
                            		<label for="">Content</label>
                            		<textarea name="content" row="3" class="form-control" readonly="readonly">${board.content }
                            		</textarea>
                            	</div>
                            	<div class="form-grop">
                            		<label for="">Writer</label>
                            		<input value="${board.writer }" type="text" name="writer" class="form-control" readonly="readonly"/><br>
                            	</div>
                            	<div class="form-grop">
                            		<label for="">Reg Date</label>
                            		<input value="${board.regdate }" type="text" name="writer" class="form-control" readonly="readonly"/><br>
                            	</div>
                            	<div class="form-grop">
                            		<label for="">Update Date</label>
                            		<input value="${board.updatedate }" type="text" name="writer" class="form-control" readonly="readonly"/><br>
                            	</div>
                            	
                            	<button data-oper="modify" class="btn btn-primary">Modify</button>
                            	<button data-oper="remove" class="btn btn-danger">Remove</button>
                            	<button data-oper="list" class="btn btn-default">List</button>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
<form id="operForm">
	<input type="hidden" id="bno" name="bno" value="${board.bno }" />
</form>            
            
<script type="text/javascript">
	$(document).ready(function (){
		var operForm=$("#operForm");
		
		$("button[data-oper='modify']").on("click", function (){
			operForm.attr("action", "/board/modify");	
			operForm.attr("method", "get");
			operForm.submit();
		});
		$("button[data-oper='remove']").on("click", function (){
			operForm.attr("action", "/board/remove");	
			operForm.attr("method", "get");
			operForm.submit();
		});
		$("button[data-oper='list']").on("click", function (){
			operForm.find("#bno").remove();	/* 아이디bno지우고 리스트가라 */
			operForm.attr("action", "/board/list");	
			operForm.attr("method", "get");
			operForm.submit();
		});
	});
</script>
            
<%@ include file="../include/footer.jsp" %>        
