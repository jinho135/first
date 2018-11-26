package Swing.model;

public class KcalOutBean {
	String userid, actdate, actname, actunit;
	double actkcal;
	int actcnt;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getActdate() {
		return actdate;
	}

	public void setActdate(String actdate) {
		this.actdate = actdate;
	}

	public String getActname() {
		return actname;
	}

	public void setActname(String actname) {
		this.actname = actname;
	}

	public String getActunit() {
		return actunit;
	}

	public void setActunit(String actunit) {
		this.actunit = actunit;
	}

	public double getActkcal() {
		return actkcal;
	}

	public void setActkcal(double actkcal) {
		this.actkcal = actkcal;
	}

	public int getActcnt() {
		return actcnt;
	}

	public void setActcnt(int actcnt) {
		this.actcnt = actcnt;
	}
}
