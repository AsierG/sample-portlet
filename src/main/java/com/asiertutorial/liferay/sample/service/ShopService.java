package com.asiertutorial.liferay.sample.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asiertutorial.liferay.sample.annotations.LogSampleMethod;
import com.asiertutorial.liferay.sample.dao.ShopDao;
import com.asiertutorial.liferay.sample.forms.ShopCriteriaSearchForm;
import com.asiertutorial.liferay.sample.model.Shop;

@Service
public class ShopService {

	private static final Logger LOG = Logger.getLogger(ShopService.class);

	@Autowired
	private ShopDao shopDao;

	@Transactional(readOnly = true)
	public List<Shop> getShops() {
		return shopDao.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<Shop> search(ShopCriteriaSearchForm shopCriteriaSearchForm,
			long userId, long groupId) {

		if (LOG.isDebugEnabled()) {
			LOG.debug("Looking for shops with values "
					+ shopCriteriaSearchForm.toString());
		}

		return shopDao.search(shopCriteriaSearchForm);

	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Shop getShop(long shopId) {
		return shopDao.get(shopId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@LogSampleMethod(action = LogSampleMethod.Action.UPDATE)
	public Shop save(long userId, long companyId, long scopeGroupId,
			Shop shopDTO) {

		Date now = new Date();
		shopDTO.setActive(Boolean.TRUE);
		shopDTO.setUserCreatorId(userId);
		shopDTO.setUserModifierId(userId);
		shopDTO.setCreationDate(now);

		return shopDao.save(shopDTO);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@LogSampleMethod(action = LogSampleMethod.Action.UPDATE)
	public Shop update(long userId, long companyId, long scopeGroupId,
			Shop shopDTO) {
		Date now = new Date();
		Shop shop = getShop(shopDTO.getShopId());
		shop.setName(shopDTO.getName());
		shop.setBilling(shopDTO.getBilling());
		shop.setWorkers(shopDTO.getWorkers());
		shop.setUserModifierId(userId);
		shop.setModifiedDate(now);
		return shopDao.merge(shop);
	}

}
