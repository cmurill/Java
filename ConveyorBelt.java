import java.math.BigDecimal; 
import java.math.RoundingMode; 

/** 
 * Encapsulates the basic information needed to configure and price a conveyor belt. 
 */ 
public class ConveyorBelt {

	// Add your three instance variables here. 
	
	private double length;
	private double width;
	private boolean hasDiscount;
	
	// Add additional methods you require here. 
	
	public void setLength(double length) {
		this.length = length;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHasDiscount(boolean hasDiscount) {
		this.hasDiscount = hasDiscount;
	}

	public double getArea() {
		return this.length * this.width;
	}

	public double getBasePrice() {
		return this.length * this.width * 55.83;
	}

	public double getShippingAndHandling() {
		double area = this.length * this.width;
		double floorBeltArea = Math.floor(area);
		double areaNotIncluded = floorBeltArea - 50.0;
		double shippingCost = 0.0;
		if (areaNotIncluded > 0.0) {
			double additionalBoxes = areaNotIncluded / 50.0;
			double ceilAdditionalBoxes = Math.ceil(additionalBoxes);
			shippingCost = ceilAdditionalBoxes * 75.0;
		}
		if (floorBeltArea > 250.0) {
			shippingCost += 150.0;
		}
		return shippingCost;
	}

	public double getCustomerDiscount() {
		if (this.hasDiscount == true) {
			return this.length * this.width * 55.83 * 0.1;
		} else {
			return 0.0;
		}
	}

	public String toString() {
		double totalPrice = (getBasePrice() + getShippingAndHandling() - getCustomerDiscount());
		String grandTotal = convertDoubleToMonetaryString(totalPrice);
		String basePrice = convertDoubleToMonetaryString(getBasePrice());
		String shippingAndHandling = convertDoubleToMonetaryString(getShippingAndHandling());
		String customerDiscount = convertDoubleToMonetaryString(getCustomerDiscount());
		String beltConfig = "Belt is " + this.length + " m long and " + this.width + " m wide" + "\n" + "Belt area is " + (this.length * this.width) + " sq m" + "\n"
			+ "Base belt price is $" + basePrice + "\n" + "Shipping and handling based on belt size is $" + shippingAndHandling + "\n" + "Customer discount is $" + 
			customerDiscount + "\n" +  "Total price is $" + grandTotal;
		return beltConfig;
	}

	/**
	 * Given a double value, rounds the value up to two decimal places and converts 
	 * it to a String so it can be suitable for use as a monetary value. 
	 * 
	 * @param 	value 	a floating point value to be converted 
	 * @return	a String representation of the floating point value suitably rounded for use as a monetary value 
	 */ 
	private String convertDoubleToMonetaryString(double value) {
		return new BigDecimal(value).setScale(2, RoundingMode.CEILING).toPlainString(); 
	} 

} 