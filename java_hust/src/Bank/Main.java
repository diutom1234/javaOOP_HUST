package Bank;

public class Main {
	public static void main(String[] args) {
		ManageAccount manageAccount = new ManageAccount();
		
		Account acc1 = new Account();
		acc1.setName("Ngo Thi Huyen Dieu");
		acc1.setMoney(20194506);
		manageAccount.addAccount(acc1);
		
		manageAccount.plusMoney(acc1, 1000);
		System.out.println("Da chuyen vao tai khoan.\nSo du:" + acc1.getMoney());
		
		if(manageAccount.minusMoney(acc1, 20000000)) {
			System.out.println("Da rut thanh cong.\nSo du: " + acc1.getMoney());
		}else {
			System.out.println("Khong du so du trong tai khoan.");
		}
	}
}
