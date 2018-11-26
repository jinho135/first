package Swing.model;

public class KcalInBean {
	String userid, fooddate, foodname, foodunit;
	double foodkcal;
	int foodcnt;

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFooddate() {
		return fooddate;
	}

	public void setFooddate(String fooddate) {
		this.fooddate = fooddate;
	}

	public int getFoodcnt() {
		return foodcnt;
	}

	public void setFoodcnt(int foodcnt) {
		this.foodcnt = foodcnt;
	}

	public String getFoodunit() {
		return foodunit;
	}

	public void setFoodunit(String foodunit) {
		this.foodunit = foodunit;
	}

	public double getFoodkcal() {
		return foodkcal;
	}

	public void setFoodkcal(double foodkcal) {
		this.foodkcal = foodkcal;
	}

}
