package Swing.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class KcalDBA {
	String url, user, pwd;

	// 디비셋팅
	public KcalDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "scott";
			pwd = "TIGER";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// 음식입력하기
	public void foodInsert(KcalFoodBean kf) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select foodname from kcalfood where foodname ='" + kf.getFoodname() + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String check = "";
			while (rs.next())
				check = rs.getString(1);

			if (check.isEmpty()) {
				sql = "insert into kcalfood values(?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, kf.getFoodname());
				ps.setString(2, kf.getFoodunit());
				ps.setDouble(3, kf.getFoodkcal());
				ps.setString(4, kf.getFoodetc());
				ps.executeUpdate();
			} else {
				JOptionPane.showMessageDialog(null, "이미 입력된 음식입니다.");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// 음식수정하기
	public void foodUpdate(KcalFoodBean kf) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "update kcalfood set foodunit=?, foodkcal=?, foodetc=? where foodname=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, kf.getFoodunit());
			ps.setDouble(2, kf.getFoodkcal());
			ps.setString(3, kf.getFoodetc());
			ps.setString(4, kf.getFoodname());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 음식검색하기
	public ArrayList<KcalFoodBean> foodSearch(String str) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<KcalFoodBean> arr1 = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from kcalfood where foodname like '%" + str + "%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				KcalFoodBean kf = new KcalFoodBean();
				kf.setFoodname(rs.getString("foodname"));
				kf.setFoodunit(rs.getString("foodunit"));
				kf.setFoodkcal(rs.getInt("foodkcal"));
				kf.setFoodetc(rs.getString("foodetc"));
				arr1.add(kf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr1;
	}

	// 활동입력하기
	public void actInsert(KcalActBean ka) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select actname from kcalact where actname ='" + ka.getActname() + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String check = "";
			while (rs.next())
				check = rs.getString(1);
			if (check.isEmpty()) {
				sql = "insert into kcalact values(?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, ka.getActname());
				ps.setString(2, ka.getActunit());
				ps.setDouble(3, ka.getActkcal());
				ps.setString(4, ka.getActetc());
				ps.executeUpdate();
			} else {
				JOptionPane.showMessageDialog(null, "이미 입력된 활동입니다.");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// 활동수정하기
	public void actUpdate(KcalActBean ka) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "update kcalact set actunit=?, actkcal=?, actetc=? where actname=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ka.getActunit());
			ps.setDouble(2, ka.getActkcal());
			ps.setString(3, ka.getActetc());
			ps.setString(4, ka.getActname());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 활동검색하기
	public ArrayList<KcalActBean> actSearch(String str) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<KcalActBean> arr2 = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from kcalact where actname like '%" + str + "%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				KcalActBean ka = new KcalActBean();
				ka.setActname(rs.getString("actname"));
				ka.setActunit(rs.getString("actunit"));
				ka.setActkcal(rs.getInt("actkcal"));
				ka.setActetc(rs.getString("actetc"));
				arr2.add(ka);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr2;
	}

	// 회원가입
	public void userInsert(KcalUserBean ku) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select userid from kcaluser where userid ='" + ku.getUserid() + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String check = "";
			while (rs.next())
				check = rs.getString(1);
			if (!check.isEmpty()) {
				JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
				return;
			}
			sql = "insert into kcaluser values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, ku.getUserid());
			ps.setString(2, ku.getPassword());
			ps.setString(3, ku.getUsername());
			ps.setString(4, ku.getBirth());
			ps.setString(5, ku.getGender());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 회원정보수정
	public void userUpdate(KcalUserBean ku) {
		Connection con = null;
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select userid from kcaluser where userid='" + ku.getUserid() + "' and password='"
					+ ku.getPassword() + "'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			String check = "";
			while (rs.next())
				check = rs.getString(1);
			if (check.isEmpty()) {
				JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
				return;
			}
			sql = "update kcaluser set username=?, birth=?, gender=? where userid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ku.getUsername());
			ps.setString(2, ku.getBirth());
			ps.setString(3, ku.getGender());
			ps.setString(4, ku.getUserid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 회원검색하기
	public ArrayList<KcalUserBean> userSearch(String str, int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<KcalUserBean> arr3 = new ArrayList<>();
		String key = null;
		if (num == 0)
			key = "userid";
		else if (num == 1)
			key = "username";
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from kcaluser where " + key + " like '%" + str + "%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				KcalUserBean ku = new KcalUserBean();
				ku.setUserid(rs.getString("userid"));
				ku.setPassword(rs.getString("password"));
				ku.setUsername(rs.getString("username"));
				ku.setBirth(rs.getString("birth"));
				ku.setGender(rs.getString("gender"));
				arr3.add(ku);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr3;
	}

	// 음식 날짜 저장
	public void foodSave(ArrayList<KcalInBean> arr4, String date) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			for (int i = 0; i < arr4.size(); i++) {
				String sql = "insert into kcalin values(?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, arr4.get(i).getUserid());
				ps.setString(2, date);
				ps.setString(3, arr4.get(i).getFoodname());
				ps.setInt(4, arr4.get(i).getFoodcnt());
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 날짜 음식 읽기
	public ArrayList<KcalInBean> foodLoad(String date, String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<KcalInBean> arr4 = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from kcalIn, kcalfood where kcalfood.foodname=kcalin.foodname and userid='" + userid
					+ "' and kcalin.fooddate= '" + date + "'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				KcalInBean ki = new KcalInBean();
				ki.setUserid(rs.getString("userid"));
				ki.setFoodname(rs.getString("foodname"));
				ki.setFoodcnt(rs.getInt("foodcnt"));
				ki.setFoodunit(rs.getString("foodunit"));
				ki.setFoodkcal(rs.getDouble("foodkcal"));
				arr4.add(ki);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr4;
	}

	// 활동 날짜 저장
	public void actSave(ArrayList<KcalOutBean> arr5, String date) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			for (int i = 0; i < arr5.size(); i++) {
				String sql = "insert into kcalout values(?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, arr5.get(i).getUserid());
				ps.setString(2, date);
				ps.setString(3, arr5.get(i).getActname());
				ps.setInt(4, arr5.get(i).getActcnt());
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 날짜 활동 읽기
	public ArrayList<KcalOutBean> actLoad(String date, String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<KcalOutBean> arr5 = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from kcalout, kcalact where kcalact.actname=kcalout.actname and userid='" + userid
					+ "' and kcalout.actdate= '" + date + "'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				KcalOutBean ko = new KcalOutBean();
				ko.setUserid(rs.getString("userid"));
				ko.setActname(rs.getString("actname"));
				ko.setActcnt(rs.getInt("actcnt"));
				ko.setActunit(rs.getString("actunit"));
				ko.setActkcal(rs.getDouble("actkcal"));
				arr5.add(ko);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr5;
	}

	// 저장 기록 날짜 조회
	public void userHistory(String userid, JTextArea tauserView) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select distinct(fooddate) from kcalin, kcalfood where kcalfood.foodname=kcalin.foodname and userid='"
					+ userid + "'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			tauserView.append("\n\n음식기록 저장날짜 목록");
			while (rs.next()) {
				tauserView.append("\n" + rs.getString("fooddate").replaceAll(" 00:00:00", ""));
			}

			sql = "select distinct(actdate) from kcalout, kcalact where kcalact.actname=kcalout.actname and userid='"
					+ userid + "'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			tauserView.append("\n\n활동기록 저장날짜 목록");
			while (rs.next()) {
				tauserView.append("\n" + rs.getString("actdate").replaceAll(" 00:00:00", ""));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 차트 데이터 불러오기
	public ArrayList<KcalChartBean> chartdataLoad(String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<KcalChartBean> arr6 = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from kcalhistory where userid='" + userid + "' order by kcaldate";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				KcalChartBean kc = new KcalChartBean();
				kc.setUserid(rs.getString("userid"));
				kc.setKcaldate(rs.getString("kcaldate").replaceAll(" 00:00:00", ""));
				kc.setKcalfianl(rs.getDouble("kcalfinal"));
				arr6.add(kc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr6;
	}

	// 차트 데이터 저장하기
	public void chartdataSave(String userid, String date, String kcal) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "insert into kcalhistory values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, date);
			ps.setDouble(3, Double.parseDouble(kcal));
			ps.executeUpdate();
		} catch (
		SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
