package com.asiertutorial.liferay.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(	name = "SAMPLE_SHOP")
public class Shop extends Base {


	private static final long serialVersionUID = 5598927160885635644L;
	
	@Id
	@Column(name = "shop_id")
	@SequenceGenerator(name = "seq_shop", sequenceName = "SEQ_SHOP", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_shop")
	private long shopId;
	
//	@Column(name = "name", length = 200)
//	@NotEmpty
//	@Length(max = 200)
	private String name;
	
	@Column(name= "billing")
	@NotNull
	private Long billing;
	
	@Column(name= "workers")
	@NotNull
	private Long workers;
	
	
	public long getShopId() {
		return shopId;
	}
	
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	
	@Column(name = "name", length = 200)
	@NotEmpty
	@Length(max = 200)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getBilling() {
		return billing;
	}
	
	public void setBilling(Long billing) {
		this.billing = billing;
	}
	
	public Long getWorkers() {
		return workers;
	}
	
	public void setWorkers(Long workers) {
		this.workers = workers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billing == null) ? 0 : billing.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (shopId ^ (shopId >>> 32));
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
		Shop other = (Shop) obj;
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
		if (shopId != other.shopId)
			return false;
		if (workers == null) {
			if (other.workers != null)
				return false;
		} else if (!workers.equals(other.workers))
			return false;
		return true;
	}
	

}
