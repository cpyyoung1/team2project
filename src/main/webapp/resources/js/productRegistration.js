/**
 * 
 */
function checkForm(){
	if(document.getElementById("productTitle").value.length == 0){
        alert('판매글 제목을 입력해주세요.');
        document.getElementById("productTitle").focus();
        return false;
    }
	
	if(document.getElementById("productPrice").value.length == 0){
        alert('상품 금액을 입력해주세요.');
        document.getElementById("productPrice").focus();
        return false;
    }
	
	if(document.getElementById("productName").value.length == 0){
        alert('상품 이름을 입력해주세요.');
        document.getElementById("productName").focus();
        return false;
    }
	
	if(document.getElementById("productText").value.length == 0){
        alert('상품 설명글을 작성해주세요.');
        document.getElementById("productText").focus();
        return false;
    }
	
	if(document.getElementById("productPictureNameURL").value.length == 0){
        alert('사진을 첨부 해주세요.');
        document.getElementById("productPictureNameURL").focus();
        return false;
    }
    
    return true;
}