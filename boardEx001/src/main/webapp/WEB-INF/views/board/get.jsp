<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../include/header.jsp" %>
<script type="text/javascript" src="/resources/js/reply.js"></script>

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
	<input type="hidden" id="pageNum" name="pageNum" value="${cri.pageNum }"/>
	<input type="hidden" id="amount" name="amount" value="${cri.amount }"/>
	<input type="hidden" id="type" name="type" value="${cri.type }"/>
	<input type="hidden" id="keyword" name="keyword" value="${cri.keyword }"/>
</form>  

			<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-comments fa-fw"></i>Reply <span class="replyCnt">[${board.replycount }]</span>
                            <button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">New Reply</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <ul class="chat">
                            	댓글 뿔리거임
                            </ul>
                        </div>
                        <!-- /.panel-body -->
                        <div class="panel-footer"></div>
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">Reply Modal</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                            	<label>Reply</label>
                            	<input class="form-control" name="reply" value="reply" />
                            </div>
                            <div class="form-group">
                            	<label>Replyer</label>
                            	<input class="form-control" name="replyer" value="replyer" />
                            </div>
                            <div class="form-group">
                            	<label>ReplyDate</label>
                            	<input class="form-control" name="replyDate" value="2020-01-01" />
                            </div>
                        </div>
                        <div class="modal-footer">
	                        <button id="modalModBtn" type="button" class="btn btn-warning">Modify</button>
	                        <button id="modalRemoveBtn" type="button" class="btn btn-danger">Remove</button>
                            <button id="modalRegisterBtn" type="button" class="btn btn-primary">Register</button>
                            <button id="modalCloseBtn" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.modal -->
            
<script type="text/javascript">
	console.log("================================");
	console.log("JS TEST");
	var bnoValue = '<c:out value="${board.bno}"/>';
	var replyUL = $(".chat");
	
	var modal = $(".modal");
	var modalInputReply = modal.find("input[name='reply']");
	var modalInputReplyer = modal.find("input[name='replyer']");
	var modalInputReplyDate = modal.find("input[name='replyDate']");
	
	var modalModBtn = $("#modalModBtn");
	var modalRemoveBtn = $("#modalRemoveBtn");
	var modalRegisterBtn = $("#modalRegisterBtn");
	//var modalCloseBtn = $("#modalCloseBtn");
	
	showList(1);
	
	$("#modalCloseBtn").on("click", function(){
		modal.modal("hide");
	});
	
	$("#addReplyBtn").on("click", function(){
		modal.find("input").val("");
		modalInputReplyDate.closest("div").hide();
		modal.find("button[id!='modalCloseBtn']").hide();
		modalRegisterBtn.show();
		$(".modal").modal("show");
	});
	
	$(".chat").on("click", "li", function(e){
		var rno = $(this).data("rno");
		
		replyService.get(rno, function(reply){
			modalInputReply.val(reply.reply);
			modalInputReplyer.val(reply.replyer);
			modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).
				attr("readonly", "readonly");
			modal.data("rno", reply.rno);
			modal.find("button[id != 'modalCloseBtn']").hide();
			modalModBtn.show();
			modalRemoveBtn.show();
			$(".modal").modal("show");
		});
	});
	
	modalRegisterBtn.on("click", function(){
		var reply = {
				reply : modalInputReply.val(),
				replyer : modalInputReplyer.val(),
				bno : bnoValue
		};
	
		replyService.add(reply, function(result){
			if(result=="success")
				alert("등록 성공.");
			else
				alert("등록 실패.");
			modal.find("input").val("");
			modal.modal("hide");
			showList(1);
		});
	});
	
	modalModBtn.on("click", function() {
		var reply = {
				rno : modal.data("rno"),
				reply : modalInputReply.val(),
				replyer : modalInputReplyer.val()
		};
		
		replyService.update(reply, function(result){
			if(result=="success")
				alert("수정 성공.");
			else
				alert("수정 실패.");
			modal.modal("hide");
			showList(1);
		});
	});
	
	modalRemoveBtn.on("click", function(e) {
		var rno = modal.data("rno");
		
		replyService.remove(rno, function(result){
			if(result=="success")
				alert("삭제 성공.");
			else
				alert("삭제 실패.");
			modal.modal("hide");
			showList(1);
		});
	});
	
	function showList(page){
		replyService.getList({bno:bnoValue, page:page || 1}, function(list){
			var str="";
			if(list == null || list.length == 0){
				replyUL.html("");
				return;
			}
			for(var i=0, len=list.length || 0; i<len; i++){
				str +="<li class='left clearfix' data-rno='"+list[i].rno+"'>";
				str +="<div><div class='header'><strong class='primary-font'>"+
					list[i].replyer+"</strong>";
				str +="<small class='pull-right text-muted'>"+
					replyService.displayTime(list[i].replyDate)+"</small></div>";
				str +="<p>"+list[i].reply+"</p></div></li>";
			}
			$(".replyCnt").html("[" + list.length + "]");
			replyUL.html(str);
		});
	}
	
	/* replyService.add({reply:"JS Test", replyer:"tester", bno:bnoValue},
					function(result){
						alert("RESULT : " + result);
					}
	); */
	
	/* replyService.getList({bno:bnoValue, page:1}, function(list){
		var len = list.length || 0;
		for(var i=0; i<len; i++){
		//for(var i=0, len=list.length || 0; i<len; i++){
			console.log(list[i]);
		}
	}) */
	
	/* replyService.remove(7, function(count){
		console.log(count);
		if(count=="success"){
			alert("삭제 성공");
		}
	}, function(err){
			alert("error");
	}); */
	
	/* replyService.update({rno:5, bno:bnoValue, reply:"Modified reply", replyer:"medol2"},
			function(result){
		alert("수정 성공");
	}); */
	
	/* replyService.get(5, function(data){
		console.log(data);
	}); */
	
	
</script>            
            
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
