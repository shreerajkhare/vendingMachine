package com.deloitte.vm.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.deloitte.vm.component.VendingMachineMain;


public class VendingMachineTest {

	@Test
	public void testCoin() {
		VendingMachineMain vm = new VendingMachineMain();
		assertEquals(50.0,vm.testCoin("CENT"),0);
		assertEquals(25.0,vm.testCoin("QUARTER"),0);
		assertEquals(0.0,vm.testCoin("NONE"),0);
		assertEquals(10.0,vm.testCoin("DIME"),0);

		
		}
	
	
	@Test
	public void testShop() {
		VendingMachineMain vm = new VendingMachineMain();
		Double balance=125.0;
		
		assertEquals(50.0,vm.testShop("CANDY", balance),0);
		assertEquals(25.0,vm.testShop("CHOCOLATES", balance),0);
		assertEquals(95.0,vm.testShop("COLDDRINK", balance),0);
		assertEquals(0.0,vm.testShop("DAIRY MILK", balance),0);

		
		}
	
	

}
