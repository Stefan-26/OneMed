import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner input = new Scanner(System.in);
	public void mainMenu() {
		System.out.println("1. Add drug to data");
		System.out.println("2. View drug in data");
		System.out.println("3. Update price drug in data");
		System.out.println("4. Customer buying drug");
		System.out.println("5. View Customer Data");
		System.out.println("5. Remove drug in data");
		System.out.println("6. Exit");
		System.out.print("Choice : ");
	}
	
	public Drug newDrug() {
		String drugName = "";
		int drugTotal = 0;
		int drugPrice = 0;
		System.out.print("Input Drug Name : ");
		drugName = input.nextLine();
		do {
			System.out.print("Input Total Drug : ");
			try {
				drugTotal = input.nextInt(); input.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Input must numeric!!!");
				input.nextLine();
				drugTotal = -1;
			}
		} while (drugTotal < 0);
		do {
			drugPrice = 0;
			System.out.print("Input Drug Price : ");
			try {
				drugPrice = input.nextInt(); input.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Input must numeric!!!");
				input.nextLine();
				drugPrice = -1;
			}
		} while (drugPrice < 0);
		return new Drug(drugName, drugTotal, drugPrice);
	}
	
	public void viewDrug(Vector<Drug> drug) {
		if(drug.isEmpty()) {
			System.out.println("No available drug in data !!!");
		} else {
			System.out.println("==========================================================");
			System.out.printf("| %-5s | %-20s | %-10s | %-10s |\n","No", "Drug Name", "Total", "Price");
			System.out.println("==========================================================");
			for(int i=0;i<drug.size();i++) {
				Drug view = drug.get(i);
				System.out.printf("| %-5d | %-20s | %-10d | %-10s |\n", i+1, view.getDrugName(), view.getDrugTotal(), view.getDrugPrice());
			}
			System.out.println("==========================================================");
			System.out.println("");
			System.out.println("Press Enter to continue!!!!");
			input.nextLine();
		}
	}
	
	public void updateDrug(Vector<Drug> drug) {
		if(drug.isEmpty()) {
			System.out.println("No available drug in data to update!!!");
		} else {
			int option = 0;
			int newPrice = 0;
			viewDrug(drug);
			do {
				System.out.print("Select index drug you want update : ");
				try {
					option = input.nextInt(); input.nextLine();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("input must be numeric");
					input.nextLine();
					option = -1;
				}
				option-=1;
			} while (option < 0 || option > drug.size());
			do {
				System.out.print("Input new price for drug "+drug.get(option).getDrugName()+" : ");
				try {
					newPrice = input.nextInt(); input.nextLine();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Input must be numeric !!!!!");
					newPrice = -1;
				}
			}while(newPrice < 1);
			drug.get(option).setDrugPrice(newPrice);
			System.out.println("Price sucessfully update in drug "+drug.get(option).getDrugName()+"!!!");
			System.out.println("Press Enter to continue");
			input.nextLine();
			viewDrug(drug);
		}
	}
	
	public Customer newCustomer(Vector<Drug> drug) {
		String customerName = "";
		int pcs = 0;
		int brand = 0;
		Vector<Buying> listBuying = new Vector();
		if(drug.isEmpty()) {
			System.out.println("No drug for selling !!!!");
		} else {
			viewDrug(drug);
			System.out.print("Input customer name : ");
			customerName = input.nextLine();
			do {
				String name = "";
				int tot;
				System.out.print("Input shoping list [0 for end buying]: ");
				brand = input.nextInt();
				brand-=1;
				if(brand < 0) {
					break;
				}
				System.out.print("Input total pcs drug : ");
				pcs = input.nextInt();
				name = drug.get(brand).getDrugName();
				tot = drug.get(brand).getDrugPrice() * pcs;
				listBuying.add(new Buying(name, pcs, tot));
			} while (brand > -1);
			System.out.println("data sucessfully added");
		}
		return new Customer(customerName, listBuying);
	}
	
	public void viewCustomer(Vector<Customer> customer) {
		if(customer.isEmpty()) {
			System.out.println("No one customer !!!!");
		} else {
			for(int i = 0;i<customer.size();i++) {
				System.out.println("Customer Name : "+customer.get(i).getCustomerName());
				for(int j=0;j<customer.get(i).getListBuying().size();j++) {
					System.out.println((j+1)+". Drug name : "+customer.get(i).getListBuying().get(j).getDrugBrand()+
										" total pcs : "+customer.get(i).getListBuying().get(j).getTotalBuying()+
										" total price : "+customer.get(i).getListBuying().get(j).getTotalPrice());
				}
				System.out.println("");
			}
			System.out.println("Press Enter to continue!!!!");
			input.nextLine();
		}
	}
	
	public void delete(Vector<Drug> drug) {
		viewDrug(drug);
		int option;
		do {
			System.out.print("Select drug to be removed [1 - "+drug.size()+"] : ");
			option = input.nextInt();
		} while (option < 1 || option > drug.size());
		option -= 1;
		System.out.println(drug.get(option).getDrugName()+" has been removed from drug list. \n");
		drug.remove(option);
		viewDrug(drug);
		input.nextLine();
	}
	
	public Main() {
		// TODO Auto-generated constructor stub
		int option;
		boolean running = true;
		Vector<Drug> drug = new Vector<>();
		Vector<Customer> customer = new Vector();
		do {
			mainMenu();
			do {
				try {
					option = input.nextInt(); input.nextLine();
				} catch(Exception e){
					option = -1;
				}
			} while (option < 1 || option > 5);
			switch(option) {
			case 1:
				drug.add(newDrug());
				System.out.println("Data succesfull added !!!!!");
				input.nextLine();
				break;
			case 2:
				viewDrug(drug);
				break;
			case 3:
				updateDrug(drug);
				break;
			case 4:
				customer.add(newCustomer(drug));
				break;
			case 5:
				viewCustomer(customer);
				break;
			case 6:
				delete(drug);
				break;
			case 7:
				running = !running;
				break;
			}
		} while (running);
	}

	public static void main(String[] args) {
		new Main();

	}

}
