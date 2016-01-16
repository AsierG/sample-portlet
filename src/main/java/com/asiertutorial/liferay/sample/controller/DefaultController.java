package com.asiertutorial.liferay.sample.controller;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.asiertutorial.liferay.sample.forms.ShopCriteriaSearchForm;
import com.asiertutorial.liferay.sample.model.Shop;
import com.asiertutorial.liferay.sample.service.ShopService;

@Controller
@RequestMapping(value = "VIEW")
public class DefaultController {

	private static final Logger LOG = Logger.getLogger(DefaultController.class);

	@Autowired
	private ShopService shopService;

	// @Autowired
	// private ProjectService projectService;

	// @InitBinder
	// public void registerCustomEditors(WebDataBinder binder, WebRequest
	// request) {
	//
	// DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	// dateFormat.setLenient(false);
	// binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,
	// true));
	// }

	@RenderMapping
	public String home(RenderRequest request, RenderResponse response,
			Model model) {

		model.addAttribute("shops", shopService.getShops());
		model.addAttribute("shopCriteriaSearchForm",
				new ShopCriteriaSearchForm());
		List<Shop> results = shopService.getShops();
		model.addAttribute("results", results);
		return "sample/shop-list";
	}

}
