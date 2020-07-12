package com.example.pma.denpendInjectEx;

public class Cars {
	
	Engine eng;
	Door door;
	Tire tire;
	
	public Cars(Engine eng, Door door, Tire tire) {
		this.eng = eng;
		this.door = door;
		this.tire = tire;
	}
	
	public void printCarFax() {
		System.out.print(this.eng+" "+this.door);
	}

}
