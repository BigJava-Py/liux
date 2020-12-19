function changePassword() {
    $.ajax({
        type: "post",
        url: "changePassword.do",
        data: { oldpassword: $("#oldpassword").val(), password: $("#password").val(), password1: $("#password1").val() },
        dataType: "json",
        success: function(response) {
            
            if (response.code == 0) {
            	alert(response.info);
            }
            if(response.code==1){
            	alert("修改成功!");
            	window.location.href = "main.jsp";
            }
        }
    });
};