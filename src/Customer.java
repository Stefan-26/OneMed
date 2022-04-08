import java.util.Vector;

public class Customer {
	private String customerName;
	private Vector<Buying> listBuying;
	
	public Customer(String customerName, Vector<Buying> listBuying) {
		// TODO Auto-generated constructor stub
		this.customerName = customerName;
		this.listBuying = listBuying;
	}
	
	public final Vector<Buying> getListBuying() {
		return listBuying;
	}

	public final void setListBuying(Vector<Buying> listBuying) {
		this.listBuying = listBuying;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
