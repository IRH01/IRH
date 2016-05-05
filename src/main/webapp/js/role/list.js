function listDelete(obj) {
	var $this = $(obj);
	$("#_DELETE_DIALOG").dialog(
			{
				title : '警告!',
				dialogClass : 'alert',
				modal : true,
				close : function(event, ui) {
					$(this).dialog("close");
				},
				open : function() {
					$(this).html("确定删除吗？");
				},
				buttons : [
						{
							text : "确定",
							click : function() {
								$(this).dialog("close");
								var id = $this.parents("tr").find("td:eq(0)")
										.find('.id').val();
								var url = $("#_DELETE_DIALOG").attr(
										"data-delete-url")
										+ "?id=" + id;
								$.ajax({
									type : "post",
									url : url,
									data : {
										'id' : id
									},
									dataType : "html",
									success : function(data, textStatus) {
										var resData = $.parseJSON(data);
										if (resData.result == 'Y') {
											$this.parents("tr").remove();
										} else {
											alert('删除失败!');
										}
									},
									error : function(XMLHttpRequest,
											textStatus, errorThrown) {
										alert('删除失败!');
									}
								});
							}
						}, {
							text : "取消",
							click : function() {
								$(this).dialog("close");
							}
						} ]
			});
}