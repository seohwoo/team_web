function writeSave(){
	
	if(document.writeform.writer.value=="") {
	  alert("작성자를 입력하십시요.");
	  document.writeform.writer.focus();
	  return false;
	}
	if(document.writeform.subject.value=="") {
	  alert("제목을 입력하십시요.");
	  document.writeform.subject.focus();
	  return false;
	}
	
	if(document.writeform.content.value=="") {
	  alert("내용을 입력하십시요.");
	  document.writeform.content.focus();
	  return false;
	}
        
	if(document.writeform.passwd.value=="") {
	  alert(" 비밀번호를 입력하십시요.");
	  document.writeform.passwd.focus();
	  return false;
	}
 } 
 
function out() {
		alert("작성자만 읽을 수 있습니다!!");
  		history.go(-1);
}

function deleteSave(){	
	if(document.delForm.passwd.value=='') {
		alert("비밀번호를 입력하십시요.");
		document.delForm.passwd.focus();
		return false;
	}
}   

function fileAdd() {
	document.getElementById("files").innerHTML+='<br /><input type="file" size="40" maxlength="30" name="files" />';
	
}


