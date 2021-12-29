function chkReciver(){
    if(document.getElementById("reciver").value.length == 0){
        alert("받는 사람을 확인해주세요");
        document.getElementById("reciver").focus();
        return false;
    }
	 if(document.getElementById("content").value.length == 0){
        alert("내용을 입력해주세요");
        document.getElementById("content").focus();
        return false;
	}
return true;
}



function checkBox(){
	    if(document.getElementById("faqTitle").value.length == 0){
        alert("제목을 입력해주세요");
        document.getElementById("faqTitle").focus();
        return false;
    }
	 if(document.getElementById("faqContent").value.length == 0){
        alert("내용을 입력해주세요");
        document.getElementById("faqContent").focus();
        return false;
	}
	return true;
}