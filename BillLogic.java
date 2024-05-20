//this is java class which contain the logic or main code of the application .it contain the 3 method
package appcode;

public class BillLogic {

	public long calculateUnitCnsume(long current, long previous) {
		long unitConsume = current - previous;
		return unitConsume;
	}

	public float domesticBillAmount(long units)
	/* we use if and method for calculated the sum(amount)of unit in Rupee(Rs).
	 * its is the calculation of domestic unit.
	 */ {
		float totalAmount = 0;
		if (units <= 100) {
			//if unit is 100 or in between 100 then the per unit is multiply by 1 Rs.
			totalAmount = units * 1;
		} else if (units > 100 && units <= 200) {
			//if unit is 100 to 200 then the per unit is multiply by 5/2(2.5 rs) Rs.
			totalAmount = (units - 100) * 5 / 2 + (100 * 1);
		} else if (units > 200 && units <= 500) {
			//if unit is 200 to 500 then the per unit is multiply by 4 Rs.
			totalAmount = (units - 200) * 4 + (100 * 5 / 2) + (100 * 1);
		} else if (units > 500) {
			//if unit is above 500 then the per unit is multiply by 6 Rs.
			totalAmount = (units - 500) * 6 + (300 * 4) + (100 * 5 / 2) + (100 * 1);
		}
		return totalAmount;
	}

	public float commercialBillAmount(long units)
	/* we use if and method for calculated the sum(amount)of unit in Rupee(Rs).
     * its is the calculation of commercial  unit.
     */{
		float totalAmount = 0;
		if (units <= 100) {
			// For first 100 units the charge is rupees 2 per unit.
			totalAmount = units * 2;
		} else if (units > 100 && units <= 200) {
			// For 101 to 200 units the charge is 9/2 i.e 4.5 rupees per unit.
			totalAmount = (units - 100) * 9 / 2 + (100 * 2);
		} else if (units > 200 && units <= 500) {
			// For 201 to 500 units the charge is 6 rupees per unit.
			totalAmount = (units - 200) * 6 + (100 * 9 / 2) + (100 * 2);
		} else if (units > 500) {
			// For above 500 units the charge is 7 rupees per unit.
			totalAmount = (units - 500) * 7 + (300 * 6) + (100 * 9 / 2) + (100 * 2);
		}
		return totalAmount;
	}

}
