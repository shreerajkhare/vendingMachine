package com.deloitte.vm.service;

import java.util.Map;


public interface VendingMachineService {

	public Double insertCoin(Map<String,Double> coinMap,String coin);

	public Map<String, Double> selectItem(Map<String,Double> itemMap,String item);

	public Double shopItem(Map<String,Double> item,Double balance);

}
