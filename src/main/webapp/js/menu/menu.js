// JavaScript Document

var setting = {
	data : {
		simpleData : {
			enable : true
		}
	},
	callback : {
		onClick : onClick
	}
};

var zNodes = [ {
	id : 1,
	pId : 0,
	name : "角色管理",
	open : true
}, {
	id : 111,
	pId : 1,
	name : "增加角色",
	url : "jsp/role/search.jsp",
	target : "mainFrame"
}, {
	id : 112,
	pId : 1,
	name : "叶子节点112",
	url : "jsp/base/test.jsp",
	target : "mainFrame"
}, {
	id : 113,
	pId : 1,
	name : "叶子节点113",
	url : "jsp/base/right.jsp",
	target : "mainFrame"
}, {
	id : 114,
	pId : 1,
	name : "叶子节点114"
}, {
	id : 2,
	pId : 0,
	name : "关务管理"
}, {
	id : 21,
	pId : 2,
	name : "父节点21 - 展开",
	open : true
}, {
	id : 211,
	pId : 21,
	name : "叶子节点211"
}, {
	id : 212,
	pId : 21,
	name : "叶子节点212"
}, {
	id : 213,
	pId : 21,
	name : "叶子节点213"
}, {
	id : 214,
	pId : 21,
	name : "叶子节点214"
}, {
	id : 22,
	pId : 2,
	name : "父节点22 - 折叠"
}, {
	id : 221,
	pId : 22,
	name : "叶子节点221"
}, {
	id : 222,
	pId : 22,
	name : "叶子节点222",
	url : "http://www.baby666.cn",
	target : "mainFrame"
}, {
	id : 223,
	pId : 22,
	name : "叶子节点223"
}, {
	id : 224,
	pId : 22,
	name : "叶子节点224"
}, {
	id : 23,
	pId : 2,
	name : "风控管理"
}, {
	id : 231,
	pId : 23,
	name : "叶子节点231"
}, {
	id : 232,
	pId : 23,
	name : "叶子节点232"
}, {
	id : 233,
	pId : 23,
	name : "叶子节点233"
}, {
	id : 234,
	pId : 23,
	name : "叶子节点234"
}, {
	id : 3,
	pId : 0,
	name : "系统设置",
	isParent : true
}, {
	id : 280,
	pId : 3,
	name : "菜单管理",
	isParent : false,
	url : "jsp/base/menuManage.jsp",
	target : "mainFrame"
}, {
	id : 281,
	pId : 3,
	name : "组织架构管理",
	isParent : false,
	url : "jsp/base/structureManage.jsp",
	target : "mainFrame"
} ];
function onClick(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("menuTree");
	zTree.expandNode(treeNode);
}

$(document).ready(function() {
	$.fn.zTree.init($("#menuTree"), setting, zNodes);
});
