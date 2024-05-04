package com.niharku.daoFactory;

import com.niharku.dao.DaoImpl;
import com.niharku.dao.IDao;

public class DaoFactory {
	
	static IDao idao = null;
	
	
	public static IDao daoFactory() {
		
		if(idao == null) {
			idao = new DaoImpl();
		}
		return idao;
		
	}
	
}
