<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<style>
.uploadResult {
	width: 100%;
	background-color: gray;
}

.uploadResult ul {
	display: flex;
	flex-flow: row;
	justify-content: center;
	align-items: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
}

.uploadResult ul li img {
	width: 100px;
}
</style>

<style>
.bigPictureWrapper {
  position: absolute;
  display: none;
  justify-content: center;
  align-items: center;
  top:0%;
  width:100%;
  height:100%;
  background-color: gray; 
  z-index: 100;
}

.bigPicture {
  position: relative;
  display:flex;
  justify-content: center;
  align-items: center;
}
</style>

			<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Register</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Register
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <form id="registerForm" role="form" action="/board/register" method="post">
                            	<div class="form-grop">
                            		<label for="">Title</label>
                            		<input type="text" name="title" class="form-control" />
                            	</div>
                            	<div class="form-grop">
                            		<label for="">Content</label>
                            		<textarea name="content" row="3" class="form-control" ></textarea>
                            	</div>
                            	<div class="form-grop">
                            		<label for="">Writer</label>
                            		<input type="text" name="writer" class="form-control" /><br>
                            	</div>
                            	<button id="registerBtn" type="submit" class="btn btn-primary">Submit</button>
                            	<button type="button" onclick="pageList()" class="btn btn-primary">List</button>
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
            
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            File Attach
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="form-group uploadDiv">
                            	<input type="file" name="uploadFile" multiple />
                            </div>
                            
                            <div class="uploadResult">
                            	<ul>
                            		<!-- 업로드 파일 출력 -->
                            		<li></li>
                            	</ul>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
<script type="text/javascript">

	function pageList(){
		location.href="list";
	};

$(document).ready(function(e){
	
	//var uploadUL=$("uploadDiv ul");
	
	var formObj=$("#registerForm");
	$("#registerBtn").on("click",function(e){
		e.preventDefault();
		console.log("submit click");
		
		var str="";
		
		$(".uploadResult ul li").each(function(i, obj){
			var jobj=$(obj);
			console.dir(jobj);
			console.log("==================");
			console.log(jobj.data("fileName"));
			
			str+="<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
			str+="<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
			str+="<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
			str+="<input type='hidden' name='attachList["+i+"].fileType' value='"+jobj.data("type")+"'>";
			
		});
		console.log(str);
		formObj.append(str).submit();
	});
	
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	var maxSize = 5242880; //5MB
	  
	function checkExtension(fileName, fileSize){
	    if(fileSize >= maxSize){
	      alert("파일 사이즈 초과");
	      return false;
	    }
	    
	    if(regex.test(fileName)){
	      alert("해당 종류의 파일은 업로드할 수 없습니다.");
	      return false;
	    }
	    return true;
	}
	
	$("input[type='file']").change(function(e){
		var formData=new FormData();
		var inputFile = $("input[name='uploadFile']");
	    var files = inputFile[0].files;
	    
	    for(var i = 0; i < files.length; i++){
	      if(!checkExtension(files[i].name, files[i].size) ){
	        return false;
	      }
	      formData.append("uploadFile", files[i]);
	    }
	    
	    $.ajax({
	        url: '/uploadAjaxAction',
	        processData: false, 
	        contentType: false,
	        data:formData,
	        type: 'POST',
	        dataType:'json',
	        success: function(result) {
	        	console.log(result); 
	  			showUploadResult(result); //업로드 결과 처리 함수 
	        }
	     }); //$.ajax
	});
	
	function showUploadResult(uploadResultArr){
		
		if(!uploadResultArr || uploadResultArr.length == 0){ return; }
	    var uploadUL = $(".uploadResult ul");
	    
	    var str ="";
	    $(uploadResultArr).each(function(i,obj){
	    	
	    	if(obj.fileType){
				var fileCallPath =  encodeURIComponent( obj.uploadPath+ "/s_"+obj.uuid +"_"+obj.fileName);
				str += "<li data-path='"+obj.uploadPath+"'";
				str +=" data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.fileType+"'"
				str +=" ><div>";
				str += "<span> "+ obj.fileName+"</span>";
				str += "<button type='button' data-file=\'"+fileCallPath+"\' "
				str += "data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
				str += "<img src='/display?fileName="+fileCallPath+"'>";
				str += "</div>";
				str +"</li>";
			}else{
				var fileCallPath =  encodeURIComponent( obj.uploadPath+"/"+ obj.uuid +"_"+obj.fileName);			      
			    var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
			      
				str += "<li "
				str += "data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.fileType+"' ><div>";
				str += "<span> "+ obj.fileName+"</span>";
				str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='file' " 
				str += "class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
				str += "<img src='/resources/img/attach.png'></a>";
				str += "</div>";
				str +="</li>";
			}
	    });
	    uploadUL.append(str);
	}
	
	$(".uploadResult").on("click", "button", function(e){
	    console.log("delete file"); 
	    var targetFile = $(this).data("file");
	    var type = $(this).data("type");
	    var targetLi = $(this).closest("li");
	    
	    $.ajax({
	      url: '/deleteFile',
	      data: {fileName: targetFile, type:type},
	      dataType:'text',
	      type: 'POST',
	      success : function(result){
	      	alert(result);
	      	targetLi.remove();
	      }
	    }); //$.ajax
	   });
});

</script>         
            
<%@ include file="../include/footer.jsp" %>        
