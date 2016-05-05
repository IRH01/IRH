package com.everich.irh.controller.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.everich.irh.entity.role.Role;
import com.everich.irh.service.role.RoleService;
import com.everich.irh.util.JsonUtil;

@Controller
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addRole(Model model) {
		model.addAttribute("role", new Role());
		return "/role/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addRole(Model model, @ModelAttribute Role role) {
		this.roleService.saveRole(role);
		List<Role> roles = this.roleService.getAllRoles();
		model.addAttribute("roles", roles);
		return "/role/list";
	}

	@RequestMapping(value = "isexist", method = RequestMethod.POST)
	@ResponseBody
	public String isExistRole(@RequestParam(required = true) String roleName) {
		boolean flag = this.roleService.isExistRole(roleName);
		if (flag) {
			return "{\"flag\":\"exist\",\"message\":\"the role existed\"}";
		}
		return "{\"flag\":\"noexist\",\"message\":\"the role not existed\"}";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String search(Model model) {
		List<Role> roles = this.roleService.getAllRoles();
		model.addAttribute("roles", roles);
		return "/role/list";
	}

	@RequestMapping(value = "ajaxstr", method = RequestMethod.GET)
	@ResponseBody
	public String ajaxstr() {
		return "{\"flag\":\"noexist\",\"message\":\"the role not existed\"}";
	}

	@RequestMapping(value = "ajaxlist", method = RequestMethod.GET)
	@ResponseBody
	public List<String> ajaxlist() {
		List<String> list = new ArrayList<String>();
		list.add("aaaaaaaa");
		list.add("bbbbbbbb");
		list.add("cccccccc");
		return list;
	}

	@RequestMapping(value = "ajaxlistrole", method = RequestMethod.GET)
	@ResponseBody
	public String ajaxlistrole() {
		List<Role> list = new ArrayList<Role>();
		Role role1 = new Role(10010, "roleName1");
		Role role2 = new Role(10011, "roleName2");
		list.add(role1);
		list.add(role2);
		String jsonString = JsonUtil.writeValueAsString(list);
		return jsonString;
	}

	@RequestMapping(value = "ajaxrole", method = RequestMethod.GET)
	@ResponseBody
	public Role ajaxrole() {
		Role role = new Role(10010, "roleName1");
		return role;
	}
}
