
(function ($) {
	$.fn.myPagination = function (param) {
		if (param && param instanceof Object) {
			var options;
			var currPage;
			var pageCount;
			var pageSize;
			var pageNum;
			var recordCount;
			var tempPage;
			var obj = $(this);
			var defaults = new Object({currPage:1, pageCount:1,pageNum:10, pageSize:1,recordCount:0, cssStyle:"badoo", ajax:{on:false, hiddenId:"pageCount", param:{on:false, page:1}}, info:{first:"\xe9\xa6\x96\xe9\xa1\xb5", last:"\xe5\xb0\xbe\xe9\xa1\xb5", next:"\xe4\xb8\x8b\xe4\xb8\x80\xe9\xa1\xb5", prev:"\xe4\xb8\x8a\xe4\xb8\x80\xe9\xa1\xb5", first_on:true, last_on:true, next_on:true, prev_on:true, msg_on:true, link:"#", msg:"<span>&nbsp;&nbsp;\xe8\xb7\xb3{curr}/{sum}\xe9\xa1\xb5</span>", text:{width:"22px"}}});
			function getCurrPage() {
				if (options.currPage) {
					return options.currPage;
				} else {
					return defaults.currPage;
				}
			}
			function getPageNum() {
				if (options.pageNum) {
					return options.pageNum;
				} else {
					return defaults.pageNum;
				}
			}
			function getRecordCount() {
				if (options.recordCount) {
					return options.recordCount;
				} else {
					return defaults.recordCount;
				}
			}
			function getPageCount() {
				if (options.pageCount) {
					return options.pageCount;
				} else {
					return defaults.pageCount;
				}
			}
			function getPageSize() {
				if (options.pageSize) {
					if(getPageCount()<options.pageSize)
					{
						return 	getPageCount();
					}
					return options.pageSize;
				} else {
					return defaults.pageSize;
				}
			}
			function getCssStyle() {
				if (options.cssStyle) {
					return options.cssStyle;
				} else {
					return defaults.cssStyle;
				}
			}
			function getAjax() {
				if (options.ajax && options.ajax.on) {
					return options.ajax;
				} else {
					return defaults.ajax;
				}
			}
			function getParam() {
				if (options.ajax.param && options.ajax.param.on) {
					options.ajax.param.page = currPage;
					return options.ajax.param;
				} else {
					defaults.ajax.param.page = currPage;
					return defaults.ajax.param;
				}
			}
			function getFirst() {
				if (options.info && options.info.first_on == false) {
					return "";
				}
				if (options.info && options.info.first_on && options.info.first) {
					if(currPage==1)
					{
						return "<span class=\"disabled\" title='1'>" +  options.info.first + " </span>";
					}
					var str = "<a href='" + getLink() + "' title='1'>" + options.info.first + "</a>";
					return str;
				} else {
					var str = "<a href='" + getLink() + "' title='1'>" + defaults.info.first + "</a>";
					return str;
				}
			}
			function getLast(pageCount) {
				if (options.info && options.info.last_on == false) {
					return "";
				}
				if (options.info && options.info.last_on && options.info.last) {
					if(currPage==pageCount)
					{
						return "<span class=\"disabled\" title='"+pageCount+"'>" +  options.info.last + " </span>";
					}
					return "<a href='" + getLink() + "' title='" + pageCount + "'>" + options.info.last + "</a>";
				} else {
					return "<a href='" + getLink() + "' title='" + pageCount + "'>" + defaults.info.last + "</a>";
				}
			}
			function getPrev() {
				if (options.info && options.info.prev_on == false) {
					return "";
				}
				if (options.info && options.info.prev) {
					return options.info.prev;
				} else {
					return defaults.info.prev;
				}
			}
			function getNext() {
				if (options.info && options.info.next_on == false) {
					return "";
				}
				if (options.info && options.info.next) {
					return options.info.next;
				} else {
					return defaults.info.next;
				}
			}
			function getLink() {
				if (options.info && options.info.link) {
					return options.info.link;
				} else {
					return defaults.info.link;
				}
			}
			function getMsg() {
				var input = "<input id='fypage' type='text' value='" + currPage + "' >";
				var pagenuminput = "<input id='fyNum' type='text' value='" + pageNum + "' >";
				if (options.info && options.info.msg_on == false) {
					return false;
				}
				if (options.info && options.info.msg) {
					var str = options.info.msg;
					str = str.replace("{curr}", input);
					str = str.replace("{sum}", pageCount);
					str = str.replace("{pageNum}",pagenuminput);
					str = str.replace("{recordCount}",recordCount);
					return str;
				} else {
					var str = defaults.info.msg;
					str = str.replace("{curr}", input);
					str = str.replace("{sum}", pageCount);
					str = str.replace("{pageNum}",pagenuminput);
					str = str.replace("{recordCount}",recordCount);
					return str;
				}
			}
			function getText() {
				var msg = getMsg();
				if (msg) {
					msg = $(msg);
				} else {
					return "";
				}
				var input = msg.children(":text");
				if (options.info && options.info.text) {
					var css = options.info.text;
					for (temp in css) {
						var val = eval("css." + temp);
						input.css(temp, val);
					}
					return msg.html();
				} else {
					var css = defaults.info.text;
					for (temp in css) {
						var val = eval("css." + temp);
						input.css(temp, val);
					}
					return msg.html();
				}
			}
			function getHiddendId() {
				if (options.ajax && options.ajax.hiddendId) {
					return options.ajax.hiddendId;
				} else {
					return defaults.ajax.hiddendId;
				}
			}
			function getInt(val) {
				return parseInt(val);
			}
			function isCode(val) {
				if (val < 1) {
					alert("跳转页数不能小于1");
					return false;
				}
				var patrn = /^[0-9]{1,8}$/;
				if (!patrn.exec(val)) {
					alert("请输入数字");
					return false;
				}
				if (val > pageCount) {
					alert("当前页数不能大于总页数");
					return false;
				}
				return true;
			}
			function isPageNum(val) {
				if (val < 10) {
					alert("每页显示不能小于10");
					return false;
				}
				var patrn = /^[0-9]{1,8}$/;
				if (!patrn.exec(val)) {
					alert("请输入数字");
					return false;
				}
				if (val > 100) {
					alert("每页显示不能大于100");
					return false;
				}
				return true;
			}
			function updateView() {
				currPage = getInt(currPage);
				pageCount = getInt(pageCount);
				var link = getLink();
				var firstPage = lastPage = 1;
				if (currPage - tempPage > 0) {
					firstPage = currPage - tempPage;
				} else {
					firstPage = 1;
				}
				if (firstPage + pageSize > pageCount) {
					lastPage = pageCount + 1;
					firstPage = lastPage - pageSize;
				} else {
					lastPage = firstPage + pageSize;
				}
				var content = "";
				content += getFirst();
				if (currPage == 1) {
					content += "<span class=\"disabled\" title=\"" + getPrev() + "\">" + getPrev() + " </span>";
				} else {
					content += "<a href='" + link + "' title='" + (currPage - 1) + "'>" + getPrev() + " </a>";
				}
				for (firstPage; firstPage < lastPage; firstPage++) {
					if (firstPage == currPage) {
						content += "<span class=\"current\" title=\"" + firstPage + "\">" + firstPage + "</span>";
					} else {
						content += "<a href='" + link + "' title='" + firstPage + "'>" + firstPage + "</a>";
					}
				}
				if (currPage == pageCount) {
					content += "<span class=\"disabled\" title=\"" + getNext() + "\">" + getNext() + " </span>";
				} else {
					content += "<a href='" + link + "' title='" + (currPage + 1) + "'>" + getNext() + " </a>";
				}
				content += getLast(pageCount);
				content += getText();
				obj.html(content);
				//文本框输入键盘释放事件
				jQuery("#fypage").keypress(function (event) {
					var keycode = event.which;
					if (keycode == 13) {
						var page = $(this).val();
						if (isCode(page)) {
							obj.children("a").unbind("click");
							createView(page);
							options.onchange(page);
						}
					}
				});
				jQuery("#fyNum").keypress(function (event) {
					var keycode = event.which;
					if (keycode == 13) {
						var fyPageNum = $(this).val();
						if (isPageNum(fyPageNum)) {
							jQuery("#pageSize").val(fyPageNum);
							jQuery("#currPage").val(1);
							jQuery("#btnQuery").click();
						}
					}
				});
				obj.children("a").each(function (i) {
					var page = this.title;
					$(this).click(function () {
						obj.children("a").unbind("click");
						createView(page);
						$(this).focus();
						options.onchange(page);
						return false;
					});
				});
			}
			function createView(page) {
				currPage = page;
				var ajax = getAjax();
				if (ajax.on) {
					var varUrl = ajax.url;
					var param = getParam();
					$.ajax({url:varUrl, type:"GET", data:param, contentType:"application/x-www-form-urlencoded;utf-8", async:true, cache:false, timeout:60000, error:function () {
						alert("444");
					}, success:function (data) {
						loadPageCount({dataType:ajax.dataType, callback:ajax.callback, data:data});
						updateView();
					}});
				} else {
					updateView();
				}
			}
			function checkParam() {
				if (currPage < 1) {
					alert("当前页不能小于1");
					return false;
				}
				if (currPage > pageCount) {
					alert("当前页不能大于页总数");
					return false;
				}
				if (pageSize < 1) {
					alert("页数不能小于1");
					return false;
				}
				return true;
			}
			function loadPageCount(options) {
				if (options.dataType) {
					var data = options.data;
					var resultPageCount = false;
					var isB = true;
					switch (options.dataType) {
					  case "json":
						data = eval("(" + data + ")");
						resultPageCount = data.pageCount;
						break;
					  case "xml":
						resultPageCount = $(data).find("pageCount").text();
						break;
					  default:
						isB = false;
						var callback = options.callback + "(data)";
						eval(callback);
						resultPageCount = $("#pageCount").val();
						break;
					}
					if (resultPageCount) {
						pageCount = resultPageCount;
					}
					if (isB) {
						var callback = options.callback + "(data)";
						eval(callback);
					}
				}
			}
			options = param;
			currPage = getCurrPage();
			pageNum = getPageNum();
			pageCount = getPageCount();
			pageSize = getPageSize();
			recordCount = getRecordCount();
			tempPage = getInt(pageSize / 2);
			var cssStyle = getCssStyle();
			obj.addClass(cssStyle);
			if (checkParam()) {
				updateView();
				createView(currPage);
			}
		}
		return $(this);
	};
})(jQuery);

