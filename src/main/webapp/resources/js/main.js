function check(){
    if(document.getElementById("memberName").value.length == 0){
        alert("이름은 필수입력 조건입니다.");
        return false;
    }

    if(document.getElementById("memberId").value.length == 0){
        alert("아이디는 필수입력 조건입니다.");
        return false;
    }

    if(document.getElementById("memberPw").value.length == 0){
        alert("비밀번호는 필수입력 조건입니다.");
        return false;
    }

    if(document.getElementById("memberTel").value.length == 0){
        alert("전화번호는 필수입력 조건입니다.");
        return false;
    }

    if(document.getElementById("memberAddress").value.length == 0){
        alert("주소는 필수입력 조건입니다.");
        return false;
    }

    if(document.getElementById("memberNickname").value.length == 0){
        alert("닉네임은 필수입력 조건입니다.");
        return false;
    }

    if(document.getElementById("memberPw").value != document.getElementById("chkPw").value){
        alert("확인 비밀번호가 일치하지 않습니다.");
        return false;
    }
    return true;
}