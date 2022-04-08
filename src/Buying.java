
public class Buying {
	
	private String drugBrand;
	private int totalBuying;
	private int totalPrice;

	public Buying(String drugBrand, int totalBuying, int totalPrice) {
		// TODO Auto-generated constructor stub
		this.drugBrand = drugBrand;
		this.totalBuying = totalBuying;
		this.totalPrice = totalPrice;
	}

	public final String getDrugBrand() {
		return drugBrand;
	}

	public final void setDrugBrand(String drugBrand) {
		this.drugBrand = drugBrand;
	}

	public final int getTotalBuying() {
		return totalBuying;
	}

	public final void setTotalBuying(int totalBuying) {
		this.totalBuying = totalBuying;
	}

	public final int getTotalPrice() {
		return totalPrice;
	}

	public final void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	

}
