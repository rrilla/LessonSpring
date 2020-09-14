<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Register
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <form action="/board/register" method="post">
                            	<div class="form-grop">
                            		<label for="title">Title</label>
                            		<input type="text" name="title" class="form-control" />
                            	</div>
                            	<div class="form-grop">
                            		<label for="content">Content</label>
                            		<textarea name="content" row="3" class="form-control" ></textarea>
                            	</div>
                            	<div class="form-grop">
                            		<label for="writer">Writer</label>
                            		<input type="text" name="writer" class="form-control" /><br>
                            	</div>
                            	<button type="submit" class="btn btn-default">Submit</button>
                            	<button type="reset" class="btn btn-default">Reset</button>
                            </form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
<%@ include file="../include/footer.jsp" %>        
