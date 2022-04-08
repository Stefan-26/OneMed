
public class Drug {
	private String drugName;
	private int drugTotal;
	private int drugPrice;
	
	public Drug(String drugName, int drugTotal, int drugPrice) {
		// TODO Auto-generated constructor stub
		this.drugName = drugName;
		this.drugTotal = drugTotal;
		this.drugPrice = drugPrice;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public int getDrugTotal() {
		return drugTotal;
	}

	public void setDrugTotal(int drugTotal) {
		this.drugTotal = drugTotal;
	}

	public int getDrugPrice() {
		return drugPrice;
	}

	public void setDrugPrice(int drugPrice) {
		this.drugPrice = drugPrice;
	}

	

}
