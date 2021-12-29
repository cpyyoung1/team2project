function checkSignin(){
    if(document.getElementById("memberId").value.length == 0){
        alert('아이디를 입력해주세요.');
        document.getElementById("memberId").focus();
        return false;
    }

    if(document.getElementById("memberPw").value.length == 0){
        alert('비밀번호를 입력해주세요.');
        document.getElementById("memberPw").focus();
        return false;
    }

    return true;
}

function checkFindId(){
    if(document.getElementById("memberName").value.length == 0){
        alert('이름을 입력해주세요.');
        document.getElementById("memberName").focus();
        return false;
    }

    if(document.getElementById("memberTel").value.length == 0){
        alert('전화번호를 입력해주세요.');
        document.getElementById("memberTel").focus();
        return false;
    }

    return true;
}

function  checkFindPw(){
    if(document.getElementById("memberName").value.length == 0){
        alert('이름을 입력해주세요.');
        document.getElementById("memberName").focus();
        return false;
    }

    
    if(document.getElementById("memberId").value.length == 0){
        alert('아이디를 입력해주세요.');
        document.getElementById("memberId").focus();
        return false;
    }


    if(document.getElementById("memberTel").value.length == 0){
        alert('전화번호를 입력해주세요.');
        document.getElementById("memberTel").focus();
        return false;
    }

    return true;

}