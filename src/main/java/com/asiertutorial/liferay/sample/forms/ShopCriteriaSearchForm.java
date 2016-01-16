package com.asiertutorial.liferay.sample.forms;

import java.io.Serializable;

public class ShopCriteriaSearchForm implements Serializable {

	private static final long serialVersionUID = 2000776037875471799L;

	private String name;
	private Long workers;
	private Long billing;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getWorkers() {
		return workers;
	}

	public void setWorkers(Long workers) {
		this.workers = workers;
	}

	public Long getBilling() {
		return billing;
	}

	public void setBilling(Long billing) {
		this.billing = billing;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billing == null) ? 0 : billing.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((workers == null) ? 0 : workers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopCriteriaSearchForm other = (ShopCriteriaSearchForm) obj;
		if (billing == null) {
			if (other.billing != null)
				return false;
		} else if (!billing.equals(other.billing))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (workers == null) {
			if (other.workers != null)
				return false;
		} else if (!workers.equals(other.workers))
			return false;
		return true;
	}

}
