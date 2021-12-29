function check(){
    if(document.getElementById("memberName").value.length == 0){
        alert("이름은 필수입력 조건입니다.");
        document.getElementById("memberName").focus();
        return false;
    }

    if(document.getElementById("memberId").value.length == 0){
        alert("아이디는 필수입력 조건입니다.");
        document.getElementById("memberId").focus();
        return false;
    }

    
    if(document.getElementById("memberId").value.length < 5){
        alert("아이디가 너무 짧습니다. (5-15자로 입력해주세요.)");
        document.getElementById("memberId").value = "";
        document.getElementById("memberId").focus();
        return false;
    }

    
    if(document.getElementById("memberId").value.length > 15){
        alert("아이디는 15자 이상을 사용할 수 없습니다.");
        document.getElementById("memberId").value = "";
        document.getElementById("memberId").focus();
        return false;
    }

    if(document.getElementById("memberPw").value.length == 0){
        alert("비밀번호는 필수입력 조건입니다.");
        document.getElementById("memberPw").focus();
        return false;
    }

    if(document.getElementById("chkPw").value.length == 0){
        alert("비밀번호를 확인해주세요.");
        document.getElementById("chkPw").focus();
        return false;
    }

    if(document.getElementById("memberTel").value.length == 0){
        alert("전화번호는 필수입력 조건입니다.");
        document.getElementById("memberTel").focus();
        return false;
    }

    if(document.getElementById("memberAddress").value.length == 0){
        alert("주소는 필수입력 조건입니다.");
        document.getElementById("memberAddress").focus();
        return false;
    }

    if(document.getElementById("memberNickname").value.length == 0){
        alert("닉네임은 필수입력 조건입니다.");
        document.getElementById("memberNickname").focus();
        return false;
    }

    if(document.getElementById("memberPw").value != document.getElementById("chkPw").value){
        alert("확인 비밀번호가 일치하지 않습니다.");
        document.getElementById("memberPw").value = "";
        document.getElementById("chkPw").value = "";
        document.getElementById("memberPw").focus();
        return false;
    }
    return true;
}