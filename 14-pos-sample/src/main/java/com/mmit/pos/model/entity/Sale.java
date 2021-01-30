package com.mmit.pos.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.PERSIST;
/**
 * Entity implementation class for Entity: Orders
 *
 */
@Entity
@Table(name="sale")
@NamedQuery(name="Sale.getAll",query="SELECT s FROM Sale s ORDER BY s.saleDate DESC")
public class Sale implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate saleDate;
	
	
	@OneToMany(mappedBy = "sale", cascade = PERSIST)
	private List<SaleDetail> detailList=new ArrayList<>();
	
	public void addSaleItem(SaleDetail s) {
		s.setSale(this);
		detailList.add(s);
	}
	public int getTotalSaleQty() {
		return detailList.stream().mapToInt(sd->sd.getSubQty()).sum();
	}
	public int getSubTotal() {
		return detailList.stream().mapToInt(sd->sd.getSubQty()*sd.getItem().getPrice()).sum();
	}
	public double getTax() {
		return getSubTotal()*0.05;
	}
	public double getTotal () {
		return getSubTotal()+getTax();
	}
	public Sale() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	public List<SaleDetail> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<SaleDetail> detailList) {
		this.detailList = detailList;
	}
   
}
