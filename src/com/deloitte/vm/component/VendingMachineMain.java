package com.deloitte.vm.component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import com.deloitte.vm.service.VendingMachineService;
import com.deloitte.vm.service.impl.VendingMachineServiceImpl;

public class VendingMachineMain {
	
	static Map<String,Double> itemMap=new HashMap<String,Double>();
	static Map<String,Double> coinMap=new HashMap<String,Double>();
	
	static {
		itemMap.put("CHOCOLATES", 100.00);
		itemMap.put("CANDY", 50.00);
		itemMap.put("COLDDRINK", 30.00);

		coinMap.put("NICKLE", 5.00);
		coinMap.put("DIME", 10.00);
		coinMap.put("QUARTER", 25.00);
		coinMap.put("CENT", 50.00);
	}

	//public VendingMachineService objVendingMachineService;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(itemMap);
		System.out.println(coinMap);
		
		System.out.println("Insert Coin");

		Scanner in=new Scanner(System.in);
		
		VendingMachineService objVendingMachineService=new VendingMachineServiceImpl();
		
		Double bal=objVendingMachineService.insertCoin(coinMap,in.next());
		
		if(bal==0) { System.out.println("Invalid Currency!"); System.exit(0);}
		System.out.println("Enter Item to purchase");
		
		Map<String, Double> item=objVendingMachineService.selectItem(itemMap, in.next());
		if(item.isEmpty()) { System.out.println("Invalid Item Entered!"); System.exit(0);}

		System.out.println("Item="+item+" Bal="+bal);
		
		bal=objVendingMachineService.shopItem(item, bal);
		
		System.out.println("Your change is: "+bal);


	}
	
	VendingMachineService objVendingMachineService=new VendingMachineServiceImpl();

	public Double testCoin(String coin) {
		Double bal= objVendingMachineService.insertCoin(coinMap,coin);
		System.out.println("Balance is="+bal);
		return bal;
	}

	public Double testShop(String item,Double balance) {
		Map<String, Double> iMap=objVendingMachineService.selectItem(itemMap,item);
		
		System.out.println("Item="+item+" Bal="+balance);
		
		Double bal= objVendingMachineService.shopItem(iMap, balance);
		
		System.out.println("Your change is: "+bal);

		
		return bal;
	}

}
