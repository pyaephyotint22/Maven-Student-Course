package com.mmit.pos.model.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mmit.pos.model.entity.Sale;

public class SaleService {

	private EntityManager em;
	
	public SaleService(EntityManager em) {
		this.em=em;
	}

	public void save(Sale salerecord) {
		em.getTransaction().begin();
		salerecord.setSaleDate(LocalDate.now());
		em.persist(salerecord);
		em.getTransaction().commit();
	}

	public  List<Sale> findAll() {
		return em.createNamedQuery("Sale.getAll",Sale.class).getResultList();
	}

	public List<Sale> search(String from, String to) {
		StringBuffer sb=new StringBuffer("SELECt s FROM Sale s WHERE 9=9");
		Map<String, Object> params=new HashMap<String, Object>();
		
		if(from!=null && !from.isEmpty()) {
			sb.append(" AND s.saleDate >= :f");
			params.put("f", LocalDate.parse(from));
		}
		if(to!=null && !to.isEmpty()) {
			sb.append(" AND s.saleDate >= :s");
			params.put("s", LocalDate.parse(to));
		}
		//System.out.println(sb.toString());
		TypedQuery<Sale> query=em.createQuery(sb.toString(), Sale.class);
		for(Entry<String, Object> entry: params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

	public Sale findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Sale.class, id);
	}
}
