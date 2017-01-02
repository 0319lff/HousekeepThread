package net.sppan.base.controller.admin;

import java.util.List;

import net.sppan.base.controller.BaseController;
import net.sppan.base.entity.Resource;
import net.sppan.base.service.IResourceService;
import net.sppan.base.vo.Navs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;

@Controller
@RequestMapping("/admin/resource")
public class ResourceController extends BaseController{
	
	@Autowired
	private IResourceService resourceService;
	
	@RequestMapping(value = {"/index","/"})
	public String index(
			@RequestParam(required=false) Integer pn,
			ModelMap map){
		Page<Resource> page = getPage(pn);
		resourceService.selectPage(page);
		map.put("paging", page);
		return "admin/resource/index";
	}
	
	@RequestMapping("/menu")
	@ResponseBody
	public List<Navs> menu(){
		List<Navs> list = resourceService.selectTree(1);
		return list;
	}
	

}
