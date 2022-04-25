package AimsProject;
import java.util.ArrayList;
public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10; //so luong mat hang toi da
	
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];// mang luu tru danh sach DigitalVideoDisc
	public int qtyOrdered = 0; //theo doi co bao nhieu don DigitalVideoDiscs trong đon dat hang
	public float totalCost = 0;
	
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
}