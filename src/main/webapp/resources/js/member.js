function focusIt()
{      
   document.inform.id.focus();
}
 
function checkIt()
 {
   inputForm=eval("document.inform");
   if(!inputForm.id.value){
     alert("아이디를 입력하세요..");
	 inputForm.id.focus();
	 return false;
   }
   if(!inputForm.passwd.value){
     alert("비밀번호를 입력하세요..");
	 inputForm.passwd.focus();
	 return false;
   }
 }
 
 function modifyCheckIt() {
        var userinput = eval("document.userinput");
               
        if(!userinput.passwd.value ) {
            alert("비밀번호를 입력하세요");
            return false;
        }
        if(userinput.passwd.value != userinput.passwd2.value)
        {
            alert("비밀번호를 동일하게 입력하세요");
            return false;
        }
       
        if(!userinput.username.value) {
            alert("사용자 이름을 입력하세요");
            return false;
        }
        if(!userinput.jumin1.value  || !userinput.jumin2.value )
        {
            alert("주민등록번호를 입력하세요");
            return false;
        }
}
function begin(){
	document.myform.passwd.focus();
}

function deleteCheckIt(){
	if(!document.myform.passwd.value){
    alert("비밀번호를 입력하지 않으셨습니다.");
    document.myform.passwd.focus();
    return false;
  }
} 

function inputCheckIt() {
        var userinput = eval("document.userinput");
        if(!userinput.id.value) {
            alert("ID를 입력하세요");
            return false;
        }
        
        if(!userinput.passwd.value ) {
            alert("비밀번호를 입력하세요");
            return false;
        }
        if(userinput.passwd.value != userinput.passwd2.value)
        {
            alert("비밀번호를 동일하게 입력하세요");
            return false;
        }
       
        if(!userinput.username.value) {
            alert("사용자 이름을 입력하세요");
            return false;
        }
        if(!userinput.jumin1.value  || !userinput.jumin2.value )
        {
            alert("주민등록번호를 입력하세요");
            return false;
        }
}

// 아이디 중복 여부를 판단
function openConfirmid(userinput) {
    // 아이디를 입력했는지 검사
    if (userinput.id.value == "") {
        alert("아이디를 입력하세요");
        return;
    }
    // url과 사용자 입력 id를 조합합니다.
    url = "/user/confirmId.me?id="+userinput.id.value ;
    
    // 새로운 윈도우를 엽니다.
    open(url, "confirm",  "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300, height=200");
}

