package com.mmit;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Orderdetail
 *
 */
@Entity

public class Orderdetail implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderdetailPK id;
	private int subQty;
	private int subPrice;

	public Orderdetail() {
		super();
	}

	public OrderdetailPK getId() {
		return id;
	}

	public void setId(OrderdetailPK id) {
		this.id = id;
	}

	public int getSubQty() {
		return subQty;
	}

	public void setSubQty(int subQty) {
		this.subQty = subQty;
	}

	public int getSubPrice() {
		return subPrice;
	}

	public void setSubPrice(int subPrice) {
		this.subPrice = subPrice;
	}
   
}
