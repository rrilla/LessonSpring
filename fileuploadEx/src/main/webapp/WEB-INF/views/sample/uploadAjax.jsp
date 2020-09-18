<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax 파일 업로드</title>
</head>
<body>
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
		
		$("#uploadBtn").on("click", function() {
			var formData = "";	//formData 객체 생성
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files;
			console.log(files);
			
			for(var i=0; i<files.length; i++){
				formData.append("uploadFile", files[i]);
			}
			
			$.ajax({
				url : "/sample/uploadAjaxAction",
				processData : false,	//파일 업로드시 반드시 입력
				contentType : false,	//파일 업로드시 반드시 입력
				data : formData,
				type : "post",
				success : function(result){
					alert("upload success");
				}
			});
		});
		
	});
</script>

</body>
</html>

