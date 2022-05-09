package AimsProject;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 3; //so luong mat hang toi da
	
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];// mang luu tru danh sach DigitalVideoDisc
	public int qtyOrdered = 0; //theo doi co bao nhieu don DigitalVideoDiscs trong đon dat hang
	public float totalCost = 0;
	
	private MyDate dateOrdered = new MyDate();
	public static final int MAX_LIMITED_ORDERED = 2;
	private static int nbOrders = 0;
	public boolean check = true;
	
	public Order() {
		super();
		if(nbOrders < MAX_LIMITED_ORDERED) {
			nbOrders++;
		}else {
			System.out.println("Ban da dat so luong don hang toi da");
			check = false;
			return;
		}
	}
	public void printItem(){
		if(check) {
			System.out.println("***********************Order***********************");
			this.dateOrdered.print();
			float price = 0;
			for(int i = 0; i < qtyOrdered; i++) {
				System.out.println(i + 1 + ". DVD - " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() 
						+ " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost() + "$");
				price += itemsOrdered[i].getCost();
			}
			System.out.println("Total cost: " + price);
			System.out.println("***************************************************");
		}else {
			System.out.println("Khong the dat don hang nay!!");
		}
			
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("Don hang dat da day!");
		}else {
			itemsOrdered[qtyOrdered] = disc ;
			System.out.println("Dia da duoc them vao!");
			System.out.println(itemsOrdered[qtyOrdered].getCost());
			qtyOrdered++;
		}	
		//them muc vao danh sach
	}
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		if(qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("Don hang dat da day!");
		}else {
			for(DigitalVideoDisc dvd : dvdList) {
				itemsOrdered[qtyOrdered] = dvd ;
				qtyOrdered++;
			}
			System.out.println("Them vao thanh cong!");
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if(qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("Don hang dat da day!\nCac dvd khong the them vao la:"+dvd1.getTitle()+", "+dvd2.getTitle());
		}else {
			itemsOrdered[qtyOrdered] = dvd1 ;
			System.out.println("Dia " + dvd1.getTitle()+" da duoc them vao!");
			System.out.println(itemsOrdered[qtyOrdered].getCost());
			qtyOrdered++;
			if(qtyOrdered == MAX_NUMBERS_ORDERED) {
				System.out.println("Don hang dat da day!\nCac dvd khong the them vao la: "+dvd2.getTitle());
			}else {
				itemsOrdered[qtyOrdered] = dvd2 ;
				System.out.println("Dia " + dvd2.getTitle()+" da duoc them vao!");
				qtyOrdered++;
			}
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		//Xoa muc khoi danh sach
		for (int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i] == disc) {
				for (int j = i; j < qtyOrdered; j++)
					itemsOrdered[j] = itemsOrdered[j+1];
			    System.out.println("Xoa thanh cong!");
				qtyOrdered--;
			}
		}
	}
	public float totalCost() {
		for(int i = 0; i < qtyOrdered; i++) {
			totalCost+=itemsOrdered[i].getCost();
		}
		return totalCost;
	}
	public MyDate getDateOrdered() {
		return dateOrdered;
	}
	public void setDateOrdered(int i, int j, int k) {
		dateOrdered.setDay(i);
		dateOrdered.setMonth(j);
		dateOrdered.setYear(k);
	}
	public static int getNbOrders() {
		return nbOrders;
	}
	public static void setNbOrders(int nbOrders) {
		Order.nbOrders = nbOrders;
	}
}
