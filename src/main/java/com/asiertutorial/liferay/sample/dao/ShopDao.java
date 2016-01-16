package com.asiertutorial.liferay.sample.dao;

import java.util.List;

import com.asiertutorial.liferay.core.hibernate.BaseDao;
import com.asiertutorial.liferay.sample.forms.ShopCriteriaSearchForm;
import com.asiertutorial.liferay.sample.model.Shop;

public interface ShopDao extends BaseDao<Shop> {

	List<Shop> search(ShopCriteriaSearchForm shopCriteriaSearchForm);

}
