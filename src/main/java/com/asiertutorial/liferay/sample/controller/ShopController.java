package com.asiertutorial.liferay.sample.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.asiertutorial.liferay.sample.forms.ShopCriteriaSearchForm;
import com.asiertutorial.liferay.sample.model.Project;
import com.asiertutorial.liferay.sample.model.Shop;
import com.asiertutorial.liferay.sample.service.ShopService;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

@Controller
@RequestMapping(value = "VIEW", params = "entity=shopEntity")
public class ShopController {

	private static final Logger LOG = Logger.getLogger(ShopController.class);

	@Autowired
	private ShopService shopService;

	@InitBinder
	public void registerCustomEditors(WebDataBinder binder, WebRequest request) {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RenderMapping
	public String home(RenderRequest request, RenderResponse response,
			Model model) {

		if (LOG.isDebugEnabled()) {
			LOG.debug("home ");
		}
		model.addAttribute("shops", shopService.getShops());
		model.addAttribute("shopCriteriaSearchForm",
				new ShopCriteriaSearchForm());
		List<Shop> results = shopService.getShops();
		model.addAttribute("results", results);
		return "sample/shop-list";
	}

	@RenderMapping(params = { "action=addProject" })
	public String add(@ModelAttribute(value = "project") Project project,
			RenderRequest request, RenderResponse response, Model model) {

		return "edit";
	}

	@ActionMapping(params = { "action=addProject" })
	public void addProject(@ModelAttribute("project") Project project,
			BindingResult bindingResult, ActionRequest request,
			ActionResponse response, Model model) {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		if (!bindingResult.hasErrors()) {
			// projectService.save(themeDisplay.getUserId(),
			// themeDisplay.getCompanyId(),
			// themeDisplay.getScopeGroupId(), project);
		}

	}

	@ResourceMapping("searchShopAjax")
	public ModelAndView searchShopAjax(
			@ModelAttribute(value = "shopCriteriaSearchForm") ShopCriteriaSearchForm shopCriteriaSearchForm,
			ResourceRequest request, ResourceResponse response, Model model) {

		if (LOG.isDebugEnabled())
			LOG.debug("Getting shops with values "
					+ shopCriteriaSearchForm.toString());

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		List<Shop> results = shopService.search(shopCriteriaSearchForm,
				themeDisplay.getUserId(), themeDisplay.getScopeGroupId());
		model.addAttribute("results", results);

		return new ModelAndView("sample/shop-search-results", model.asMap());

	}

	@RenderMapping(params = { "action=newShop" })
	public String newShop(RenderRequest request,
			RenderResponse response, Model model, PortletPreferences prefs) {

		if (LOG.isDebugEnabled()) {
			LOG.debug("newShop ");
		}
		// ThemeDisplay themeDisplay = (ThemeDisplay) request
		// .getAttribute(WebKeys.THEME_DISPLAY);
		model.addAttribute("entity", "shopEntity");
		model.addAttribute("shop", new Shop());

		return "sample/edit-shop";

	}

	@ActionMapping(params = { "action=saveShop" })
	public void saveShop(@Valid @ModelAttribute("shop") Shop shopDTO,
			BindingResult bindingResult, ActionRequest request,
			ActionResponse response, Model model) {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		response.setRenderParameter("entity", "shopEntity");
		
		if (bindingResult.hasErrors()) {
			// projectService.save(themeDisplay.getUserId(),
			// themeDisplay.getCompanyId(),
			// themeDisplay.getScopeGroupId(), project);
			model.addAttribute("errors", bindingResult);
			response.setRenderParameter("action", "editShopError");
			return;
		} else {
			Shop shop;
			if (shopDTO == null || shopDTO.getShopId() == 0) {
				shop = shopService.save(themeDisplay.getUserId(),
						themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(), shopDTO);
				model.addAttribute("successSave", Boolean.TRUE);
			} else {
				shop = shopService.update(themeDisplay.getUserId(),
						themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(), shopDTO);
				model.addAttribute("successUpdate", Boolean.TRUE);
			}
			model.addAttribute("shop", shop);

		}
		response.setRenderParameter("action", "editShop");

	}

	@RenderMapping(params = { "action=editShop" })
	public String editShop(
			@RequestParam(value = "fromList", required = false, defaultValue = "false") boolean fromList,
			@ModelAttribute(value = "shop") Shop shop,
			BindingResult bindingResult, RenderRequest request,
			RenderResponse response, Model model, PortletPreferences prefs) {

		if (shop != null && shop.getShopId() > 0) {
			shop = shopService.getShop(shop.getShopId());
		}
		model.addAttribute("shop", shop);

		return "sample/edit-shop";

	}

	@RenderMapping(params = { "action=editShopError" })
	public String editShopError(@ModelAttribute(value = "shop") Shop shop,
			BindingResult bindingResult, RenderRequest request,
			RenderResponse response, Model model, PortletPreferences prefs) {

		Errors errors = (Errors) model.asMap().get("errors");
		if (errors != null) {
			model.addAttribute("errors", errors);
			model.addAttribute(
					"org.springframework.validation.BindingResult.shop", errors);
		}

		return "sample/edit-shop";
	}

}
