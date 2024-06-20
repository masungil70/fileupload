<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<html>
<head>
	<title>Home</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<script>
function fn_addFile(){
	$("#d_file").append("<br>"+"<input  type='file' name='file' />");
}
</script>

<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<form id="mForm">
	<label>아이디:</label>
    <input type="text" name="id" id="id" value="aaa"><br>
	<label>이름:</label>
    <input type="text" name="name" id="name" value="bbb"><br>
	<input type="button"  value="파일추가" onClick="fn_addFile()"/><br>
	<div id="d_file">
		<input  type='file' name='file' />
	 </div>
	<input type="button" id="uploadButton" value="업로드"/>
</form>
<script>
document.querySelector("#uploadButton").addEventListener("click", e => {
	const mForm = document.querySelector("#mForm");
	const formData = new FormData(mForm);

 	console.log(formData);
    const option = {
        method : 'POST',
        body: formData
    };

    fetch("<c:url value='/uploadFile'/>", option)
    .then(response => response.json())
    .then(json => {
    	console.log("step4");
    	if (json.status) {
    		alert("성공");
    	} else {
    		alert("실패");
    	}
    });
});
</script>
</body>
</html>
