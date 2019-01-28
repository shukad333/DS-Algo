package com.designpatterns.dp.proxy;

public class WizardTowerProxy implements WizardTower{
	
	private int count = 0;
	
	private WizardTower tower;
	
	public WizardTowerProxy(WizardTower tower) {
		
		this.tower = tower;
	}
	
	@Override
	public void enter(Wizard wizard) {
		
		if(count<2) {
			
			tower.enter(wizard);
			count++;
			
		}
		
		else {
			System.out.println(wizard +" not allowerd to enter");
		}
		
	}
	
	
	public static void main(String[] args) {
		
		WizardTowerProxy proxy = new WizardTowerProxy(new IvoryTower());
		proxy.enter(new Wizard("shu"));
		proxy.enter(new Wizard("Nooru"));
		proxy.enter(new Wizard("Aaro"));
		
	}

}
