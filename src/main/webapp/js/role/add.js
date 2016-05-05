$(function() {
	$("#input1").blur(function() {
		var roleName = $("#input1").val();
		$.ajax({
			type : "post",
			url : $(".ctx").val() + '/role/isexist.do',
			data : {
				roleName : roleName
			},
			dataType : "json",
			success : function(data) {
				if (data.flag == 'exist') {
					alert(data.message);
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert('检测失败!');
			}
		});
	})

	$("#input1").focus(function() {

	})
});