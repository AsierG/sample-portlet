package com.asiertutorial.liferay.sample.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.asiertutorial.liferay.core.hibernate.BaseDaoImpl;
import com.asiertutorial.liferay.sample.annotations.LogSampleMethod;
import com.asiertutorial.liferay.sample.dao.ShopDao;
import com.asiertutorial.liferay.sample.forms.ShopCriteriaSearchForm;
import com.asiertutorial.liferay.sample.model.Shop;

@Repository
public class ShopDaoImpl extends BaseDaoImpl<Shop> implements ShopDao {

	@Override
	protected Class<? extends Shop> getEntityClass() {
		return Shop.class;
	}

	@Override
	protected Order getDefaultOrder() {
		return Order.asc("name");
	}
	
	@Override
	@LogSampleMethod(action = LogSampleMethod.Action.SAVE)
	public Shop save(Shop object) {
//		getSession().getCurrentSession().save(object);
		getSession().save(object);
		return object;
	}

	@Override
	@LogSampleMethod(action = LogSampleMethod.Action.UPDATE)
	public Shop update(Shop object) {
		getSession().update(object);
		return object;
	}
	
	@Override
	@LogSampleMethod(action = LogSampleMethod.Action.UPDATE)
	public Shop merge(Shop object) {
		getSession().merge(object);
		return object;
	}

	@Override
	@LogSampleMethod(action = LogSampleMethod.Action.DELETE)
	public void delete(Shop object) {
		getSession().delete(object);
	}

	@Override
	public List<Shop> search(ShopCriteriaSearchForm shopCriteriaSearchForm) {
		Criteria criteria = getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.eq("active", Boolean.TRUE));
		if (!StringUtils.isEmpty(shopCriteriaSearchForm.getName())) {
			criteria.add(Restrictions.like("name",
					shopCriteriaSearchForm.getName()));
		}
		if (shopCriteriaSearchForm.getBilling() != null) {
			criteria.add(Restrictions.eq("billing",
					shopCriteriaSearchForm.getBilling()));
		}
		if (shopCriteriaSearchForm.getWorkers() != null) {
			criteria.add(Restrictions.eq("workers",
					shopCriteriaSearchForm.getWorkers()));
		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(getDefaultOrder());
		return (List<Shop>) criteria.list();
	}

}
