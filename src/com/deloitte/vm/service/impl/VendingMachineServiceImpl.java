package com.deloitte.vm.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.deloitte.vm.service.VendingMachineService;

public class VendingMachineServiceImpl implements VendingMachineService{


	@Override
	public Double insertCoin(Map<String, Double> coinMap,String coin) {
		// TODO Auto-generated method stub
		OptionalDouble bal=null;
		
		for(String curr : coinMap.keySet()) {
			if(curr.equalsIgnoreCase(coin)) {
				bal=OptionalDouble.of(coinMap.get(curr));
				break;
			}
			else
				bal=OptionalDouble.empty();
		}

		return bal.orElse(0);
	}

	@Override
	public Map<String, Double> selectItem(Map<String, Double> itemMap, String item) {
		// TODO Auto-generated method stub
		
		Map<String, Double> itemMaps = itemMap.keySet().stream().filter(i->i.equalsIgnoreCase(item)).limit(1).collect(Collectors.toMap(Function.identity(),itemMap::get));
		
		return itemMaps;
	}

	@Override
	public Double shopItem(Map<String, Double> item, Double balance) {
		// TODO Auto-generated method stub
		for(String it : item.keySet()) {
			
			Double price=item.get(it);
			
			if(price>balance)
				System.out.println("Insufficient Funds");
			else {
				balance=balance-price;
				System.out.println("Thanks for your purchase of: "+it);
			}
			
		}

return balance;
	}

}
