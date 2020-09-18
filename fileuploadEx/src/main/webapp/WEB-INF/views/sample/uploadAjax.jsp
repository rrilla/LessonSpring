<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax 파일 업로드</title>
</head>
<body>
	<h1>Ajax 파일 업로드</h1>
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple />
	</div>
	<div class="uploadResult">
		<ul>
			
		</ul>
	</div>
	<button id="uploadBtn">upload</button>
	
<script
	src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous">
</script>

<script type="text/javascript">
	$(document).ready(function() {
		
		var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
		var maxSize = 5242880;
		var uploadResult = $(".uploadResult ul")
		
		function checkExtension(fileName, fileSize){
			if(fileSize >= maxSize){
				alert("파일 사이즈 초과");
				return false;
			}
			
			if(regex.test(fileName)){
				alert("해당 종류의 파일 업로드 x");
				return false;
			}
			return true;
		}
		
		function showUploadedFile(uploadResultArr) {
			var str = ""; 
			$(uploadResultArr).each(function(i, obj) { 
				str += "<li>" + obj.fileName + "</li>";
			}); 
			
			uploadResult.append(str); 
		}
		
		var cloneObj = $(".uploadDiv").clone();
		
		$("#uploadBtn").on("click", function() {
			var formData = new FormData();	//formData 객체 생성
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files;
			console.log(files);
			
			for(var i=0; i<files.length; i++){
				if(!checkExtension(files[i].name, files[i].size))
					return false;
				formData.append("uploadFile", files[i]);
			}
			
			$.ajax({
				url : "uploadAjaxAction",
				processData : false,	//파일 업로드시 반드시 입력
				contentType : false,	//파일 업로드시 반드시 입력
				data : formData,
				type : "POST",
				dataType : "json",	//return data 타입
				success : function(result){
					alert("success");
					console.log(result);
					showUploadedFile(result);
					$(".uploadDiv").html(cloneObj.html());
				},
				error : function(){
					alert("error");
				}
			});
		});
		
	});
	
	
</script>

</body>
</html>

