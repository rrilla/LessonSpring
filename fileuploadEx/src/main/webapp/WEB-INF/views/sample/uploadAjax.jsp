<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax 파일 업로드</title>
</head>
<body>

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

<div class='bigPictureWrapper'>
  <div class='bigPicture'>
  </div>
</div>

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
		var uploadResult = $(".uploadResult ul");
		var imgList = null;
		
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
				if(!obj.image){
					 var fileCallPath=encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
					 
					 str += "<li><div><a href='download?fileName="+fileCallPath+"'>"+
			           "<img src='/resources/img/icon.png'>"+obj.fileName+"</a>"+
			           "<span data-file=\'"+fileCallPath+"\' data-type='file'> x </span>"+
			           "<div></li>"
					
				}else{
					var fileCallPath=encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
					 var originPath=obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName;
					 originPath=originPath.replace(new RegExp(/\\/g),"/");
					 
					 str += "<li><a href=\"javascript:showImage(\'"+originPath+"\')\">"+
		              "<img src='display?fileName="+fileCallPath+"'></a>"+
		              "<span data-file=\'"+fileCallPath+"\' data-type='image'> x </span>"+
		              "</li>";
				}
				str += "<li>" + obj.fileName + "</li>";
			}); 
			
			uploadResult.append(str); 
		}
		
		var cloneObj = $(".uploadDiv").clone();
		
		$(".uploadResult").on("click","span", function(e){
			  var targetFile = $(this).data("file");
			  var type = $(this).data("type");
			  console.log(targetFile);
			  $.ajax({
			    url: 'deleteFile',
			    data: {fileName: targetFile, type:type},
			    dataType:'text',
			    type: 'POST',
			      success: function(result){
			    	 showUploadedFile(result);
			         alert("삭제 성공.");
			       }
			  }); //$.ajax
			});
		
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
					$(".uploadDiv").html(result);
				},
				error : function(){
					alert("error");
				}
			});
		});
		
	});
	
	function showImage(fileCallPath){
		  //alert(fileCallPath);
		  $(".bigPictureWrapper").css("display","flex").show();
		  
		  $(".bigPicture")
		  .html("<img src='display?fileName="+fileCallPath+"'>")
		  .animate({width:'100%', height: '100%'}, 1000);
		}
		$(".bigPictureWrapper").on("click", function(e){
		  $(".bigPicture").animate({width:'0%', height: '0%'}, 1000);
		  setTimeout(() => {
		    $(this).hide();
		  }, 1000);
		});
	
	
</script>

</body>
</html>

