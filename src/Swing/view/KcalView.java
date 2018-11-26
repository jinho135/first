package Swing.view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import Swing.model.KcalActBean;
import Swing.model.KcalChart;
import Swing.model.KcalChartBean;
import Swing.model.KcalDBA;
import Swing.model.KcalFoodBean;
import Swing.model.KcalInBean;
import Swing.model.KcalOutBean;
import Swing.model.KcalUserBean;
import javax.swing.SpinnerModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class KcalView extends JFrame {

	KcalDBA dba = new KcalDBA();
	ArrayList<KcalFoodBean> arr1;
	ArrayList<KcalActBean> arr2;
	ArrayList<KcalUserBean> arr3;
	ArrayList<KcalInBean> arr4 = new ArrayList<>();
	ArrayList<KcalOutBean> arr5 = new ArrayList<>();
	ArrayList<KcalChartBean> arr6;

	double kcalIn, kcalOut;
	DecimalFormat df = new DecimalFormat("#.##");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	Calendar c1 = Calendar.getInstance();
	int nowYear = Integer.parseInt(sdf.format(c1.getTime()));
	ButtonGroup bg = new ButtonGroup();
	String userID;
	String gender;
	int age;

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JTextField tfuserSearch;
	private JButton btnuserLogin;
	private JScrollPane scrollPane;
	private JTable usertable;
	private JComboBox cbuserSearch;
	private JPanel p4;
	private JScrollPane scrollPane_1;
	private JTable foodTable;
	private JTextField tffoodSearch;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JTextField tffoodName;
	private JLabel lblNewLabel_1;
	private JTextField tffoodUnit;
	private JButton btnfoodInsert;
	private JScrollPane scrollPane_2;
	private JTextArea tafoodView;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField tffoodCount;
	private JLabel label_2;
	private JButton btnfoodAdd;
	private JLabel label_3;
	private JTextField tffoodEtc;
	private JButton btnfoodCal;
	private JButton btnfoodReset;
	private JLabel lblNewLabel_6;
	private JTextField tffoodCal;
	private JSpinner spnfoodDate;
	private JLabel label;
	private JButton btnfoodSave;
	private JButton btnfoodLoad;
	private JButton btnfoodUpdate;
	private JTextField tffoodKcal;
	private JLabel label_4;
	private JButton btnNewButton_1;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField tfuserID;
	private JLabel label_7;
	private JLabel label_8;
	private JTextField tfuserName;
	private JLabel label_9;
	private JButton btnuserUpdate;
	private JButton btnuserInsert;
	private JPanel panel;
	private JScrollPane scrollPane_3;
	private JTextField tfactSearch;
	private JLabel label_10;
	private JLabel label_11;
	private JTextField tfactName;
	private JLabel label_12;
	private JTextField tfactUnit;
	private JButton btnactInsert;
	private JScrollPane scrollPane_4;
	private JLabel label_13;
	private JLabel label_14;
	private JTextField tfactCount;
	private JLabel label_15;
	private JButton btnactAdd;
	private JLabel label_16;
	private JTextField tfactEtc;
	private JButton btnactCal;
	private JButton btnactReset;
	private JLabel label_17;
	private JTextField tfactCal;
	private JSpinner spnactDate;
	private JLabel label_18;
	private JButton btnactSave;
	private JButton btnactLoad;
	private JButton btnactUpdate;
	private JTextField tfactKcal;
	private JLabel label_19;
	private JButton btnactSearch;
	private JRadioButton rbMan;
	private JRadioButton rbWoman;
	private JTextArea taactView;
	private JTable actTable;
	private JPasswordField pfuserPW;
	private JPasswordField pfpasswordLogin;
	private JScrollPane scrollPane_5;
	private JTextArea tauserView;
	private JSpinner spnbirth;
	private JLabel label_20;
	private JTextField tfkcalName;
	private JLabel label_21;
	private JTextField tfkcalAge;
	private JLabel lblNewLabel_2;
	private JTextField tfkcalWeight;
	private JLabel label_22;
	private JLabel lblxxx;
	private JTextField tfkcalHeight;
	private JLabel lblNewLabel_3;
	private JLabel lblKg;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton;
	private JTextField tfkcalCal;
	private JTextField tfkcalGender;
	private JLabel lblKcal;
	private JLabel lblNewLabel_8;
	private JLabel label_23;
	private JLabel lblNewLabel_9;
	private JScrollPane scrollPane_6;
	private JTextField tfkcalFood;
	private JLabel label_24;
	private JTextField tfkcalAct;
	private JLabel label_25;
	private JTextField tfkcalKCAL;
	private JLabel label_26;
	private JTextField tfkcalFinal;
	private JLabel lblKcal_1;
	private JLabel label_27;
	private JButton button_1;
	private JSpinner spnkcalDate;
	private JButton btnOut;
	private JButton btnLogout;
	private JLabel lblBetaVersion;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KcalView frame = new KcalView();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KcalView() {
		setResizable(false);
		setTitle("칼로리컨트롤");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTabbedPane());

	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(5, 5, 774, 551);
			tabbedPane.addTab("회원정보", null, getP1(), null);
			tabbedPane.addTab("음식기록", null, getP2(), null);
			tabbedPane.addTab("활동기록", null, getP3(), null);
			tabbedPane.addTab("열량차트", null, getP4(), null);
		}
		return tabbedPane;
	}

	private JPanel getP1() {
		if (p1 == null) {
			p1 = new JPanel();
			p1.setLayout(null);
			p1.add(getTfuserSearch());
			p1.add(getBtnuserLogin());
			p1.add(getScrollPane());
			p1.add(getCbuserSearch());
			p1.add(getLabel_5());
			p1.add(getLabel_6());
			p1.add(getTfuserID());
			p1.add(getLabel_7());
			p1.add(getLabel_8());
			p1.add(getTfuserName());
			p1.add(getLabel_9());
			p1.add(getBtnuserUpdate());
			p1.add(getBtnuserInsert());
			p1.add(getRbMan());
			p1.add(getRbWoman());
			p1.add(getPfuserPW());
			p1.add(getPfpasswordLogin());
			p1.add(getScrollPane_5());
			p1.add(getSpnbirth());
			p1.add(getLabel_20());
			p1.add(getButton_2());
			p1.add(getLblBetaVersion());
		}
		return p1;
	}

	private JPanel getP2() {
		if (p2 == null) {
			p2 = new JPanel();
			p2.setLayout(null);
			p2.add(getScrollPane_1());
			p2.add(getTffoodSearch());
			p2.add(getLabel_1_1());
			p2.add(getLblNewLabel());
			p2.add(getTffoodName());
			p2.add(getLblNewLabel_1());
			p2.add(getTffoodUnit());
			p2.add(getBtnfoodInsert());
			p2.add(getScrollPane_2());
			p2.add(getLblNewLabel_4());
			p2.add(getLblNewLabel_5());
			p2.add(getTffoodCount());
			p2.add(getLabel_2());
			p2.add(getBtnfoodAdd());
			p2.add(getLabel_3());
			p2.add(getTffoodEtc());
			p2.add(getBtnfoodCal());
			p2.add(getBtnfoodReset());
			p2.add(getLblNewLabel_6());
			p2.add(getTffoodCal());
			p2.add(getSpnfoodDate());
			p2.add(getLabel());
			p2.add(getBtnfoodSave());
			p2.add(getBtnfoodLoad());
			p2.add(getBtnfoodUpdate());
			p2.add(getTffoodKcal());
			p2.add(getLabel_4());
			p2.add(getBtnNewButton_1());
		}
		return p2;
	}

	private JPanel getP3() {
		if (p3 == null) {
			p3 = new JPanel();
			p3.setLayout(null);
			p3.add(getPanel());
		}
		return p3;
	}

	// 로그인 검색
	private JTextField getTfuserSearch() {
		if (tfuserSearch == null) {
			tfuserSearch = new JTextField();
			tfuserSearch.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tfuserSearch.setText("");
				}
			});
			tfuserSearch.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
//					if (tfuserSearch.getText().isEmpty())
//						return;
					arr3 = dba.userSearch(tfuserSearch.getText(), cbuserSearch.getSelectedIndex());
					String[] cols = { "아이디", "이름", "생년월일", "연령" };
					DefaultTableModel dt = new DefaultTableModel(cols, arr3.size());
					usertable.setModel(dt);
					for (int i = 0; i < arr3.size(); i++) {
						dt.setValueAt(arr3.get(i).getUserid(), i, 0);
						dt.setValueAt(arr3.get(i).getUsername(), i, 1);
						dt.setValueAt(arr3.get(i).getBirth().replaceAll(" 00:00:00", ""), i, 2);
						age = nowYear
								- Integer.parseInt(arr3.get(i).getBirth().replaceAll(" 00:00:00", "").substring(0, 4))
								+ 1;
						dt.setValueAt(age, i, 3);
					}
				}
			});
			tfuserSearch.setText("검색");
			tfuserSearch.setBounds(92, 171, 79, 21);
			tfuserSearch.setColumns(10);
		}
		return tfuserSearch;
	}

	// 로그인
	private JButton getBtnuserLogin() {
		if (btnuserLogin == null) {
			btnuserLogin = new JButton("로그인");
			btnuserLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = usertable.getSelectedRow();
					if (i == -1) {
						JOptionPane.showMessageDialog(null, "계정을 선택해주세요");
						return;
					}
					if (String.valueOf(pfpasswordLogin.getPassword()).equals(arr3.get(i).getPassword())) {
						setUserID(arr3.get(i).getUserid());
						gender = arr3.get(i).getGender();
						tauserView.setText("");
						tauserView.append(getUserID() + "(" + arr3.get(i).getUsername() + ")" + "님이 로그인하셨습니다.");
						kcalIn = 0;
						kcalOut = 0;
						arr4.clear();
						arr5.clear();
						tafoodView.setText("");
						taactView.setText("");
						tfkcalName.setText(getUserID());
						tfkcalGender.setText(gender + "자");
						tfkcalAge.setText(String.valueOf(age));
						dba.userHistory(getUserID(), tauserView);
						arr6 = dba.chartdataLoad(userID);
						KcalChart chart = new KcalChart(arr6);
						scrollPane_6.setViewportView(chart);
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
						return;
					}
					pfpasswordLogin.setText("");
				}
			});

			btnuserLogin.setBounds(274, 170, 88, 23);
		}
		return btnuserLogin;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			scrollPane.setBounds(12, 10, 350, 150);
			scrollPane.setViewportView(getUsertable());
		}
		return scrollPane;
	}

	private JTable getUsertable() {
		if (usertable == null) {
			usertable = new JTable();
			usertable.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			usertable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int i = usertable.getSelectedRow();
					tfuserID.setText(arr3.get(i).getUserid());
					pfuserPW.setText("");
					tfuserName.setText(arr3.get(i).getUsername());
					cbuserSearch.setSelectedIndex(0);
					tfuserSearch.setText(arr3.get(i).getUserid());
					btnuserUpdate.setEnabled(true);
					tfuserID.setEditable(false);
				}
			});
			String[] cols = { "아이디", "이름", "생년월일", "연령" };
			DefaultTableModel dt1 = new DefaultTableModel(cols, 0);
			usertable.setModel(dt1);
		}
		return usertable;
	}

	private JComboBox getCbuserSearch() {
		if (cbuserSearch == null) {
			cbuserSearch = new JComboBox();
			cbuserSearch.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					tfuserSearch.setText("");
				}
			});
			cbuserSearch.setModel(new DefaultComboBoxModel(new String[] { "아이디", "이름" }));
			cbuserSearch.setBounds(12, 171, 68, 21);
		}
		return cbuserSearch;
	}

	private JPanel getP4() {
		if (p4 == null) {
			p4 = new JPanel();
			p4.setLayout(null);
			p4.add(getTfkcalName());
			p4.add(getLabel_21());
			p4.add(getTfkcalAge());
			p4.add(getLblNewLabel_2());
			p4.add(getTfkcalWeight());
			p4.add(getLabel_22());
			p4.add(getLblxxx());
			p4.add(getTfkcalHeight());
			p4.add(getLblNewLabel_3());
			p4.add(getLblKg());
			p4.add(getLblNewLabel_7());
			p4.add(getBtnNewButton());
			p4.add(getTfkcalCal());
			p4.add(getTfkcalGender());
			p4.add(getLblKcal());
			p4.add(getLblNewLabel_8());
			p4.add(getLabel_23());
			p4.add(getLblNewLabel_9());
			p4.add(getScrollPane_6_1());
			p4.add(getTfkcalFood());
			p4.add(getLabel_24());
			p4.add(getTfkcalAct());
			p4.add(getLabel_25());
			p4.add(getTfkcalKCAL());
			p4.add(getLabel_26());
			p4.add(getTfkcalFinal());
			p4.add(getLblKcal_1());
			p4.add(getLabel_27());
			p4.add(getButton_1());
			p4.add(getSpnkcalDate());
			p4.add(getBtnOut());
		}
		return p4;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			scrollPane_1.setBounds(12, 10, 350, 150);
			scrollPane_1.setViewportView(getFoodTable());
		}
		return scrollPane_1;
	}

	private JTable getFoodTable() {
		if (foodTable == null) {
			foodTable = new JTable();
			foodTable.addMouseListener(new MouseAdapter() {
				// 푸드테이블클릭
				@Override
				public void mouseClicked(MouseEvent e) {
					int i = foodTable.getSelectedRow();
					tffoodName.setText(arr1.get(i).getFoodname());
					tffoodUnit.setText("한" + arr1.get(i).getFoodunit());
					tffoodKcal.setText(String.valueOf(arr1.get(i).getFoodkcal() + "kcal"));
					tffoodEtc.setText(arr1.get(i).getFoodetc());
					btnfoodUpdate.setEnabled(true);
				}
			});
			foodTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "음식이름", "단위", "열량", "특이사항" }));

		}
		return foodTable;
	}

	// 음식검색
	private JTextField getTffoodSearch() {
		if (tffoodSearch == null) {
			tffoodSearch = new JTextField();
			tffoodSearch.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (tffoodSearch.getText().isEmpty())
						return;
					arr1 = dba.foodSearch(tffoodSearch.getText());
					String[] cols = { "음식이름", "단위", "열량", "특이사항" };
					DefaultTableModel dt = new DefaultTableModel(cols, arr1.size());
					foodTable.setModel(dt);
					for (int i = 0; i < arr1.size(); i++) {
						dt.setValueAt(arr1.get(i).getFoodname(), i, 0);
						dt.setValueAt("한" + arr1.get(i).getFoodunit(), i, 1);
						dt.setValueAt(df.format(arr1.get(i).getFoodkcal()) + "kcal", i, 2);
						dt.setValueAt(arr1.get(i).getFoodetc(), i, 3);
					}
				}
			});
			tffoodSearch.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tffoodSearch.setText("");
				}
			});
			tffoodSearch.setText("음식이름");
			tffoodSearch.setBounds(12, 171, 97, 21);
			tffoodSearch.setColumns(10);
		}
		return tffoodSearch;
	}

	private JLabel getLabel_1_1() {
		if (label_1 == null) {
			label_1 = new JLabel("새음식등록/수정");
			label_1.setBounds(87, 242, 97, 15);
		}
		return label_1;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("음식이름");
			lblNewLabel.setBounds(87, 267, 57, 15);
		}
		return lblNewLabel;
	}

	private JTextField getTffoodName() {
		if (tffoodName == null) {
			tffoodName = new JTextField();
			tffoodName.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tffoodName.setText("");
					btnfoodUpdate.setEnabled(false);
				}
			});
			tffoodName.setBounds(146, 264, 116, 21);
			tffoodName.setColumns(10);
		}
		return tffoodName;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("단위");
			lblNewLabel_1.setBounds(87, 292, 57, 15);
		}
		return lblNewLabel_1;
	}

	private JTextField getTffoodUnit() {
		if (tffoodUnit == null) {
			tffoodUnit = new JTextField();
			tffoodUnit.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tffoodUnit.setText("한");
				}
			});
			tffoodUnit.setBounds(146, 289, 116, 21);
			tffoodUnit.setColumns(10);
		}
		return tffoodUnit;
	}

	// 음식추가
	private JButton getBtnfoodInsert() {
		if (btnfoodInsert == null) {
			btnfoodInsert = new JButton("등록");
			btnfoodInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tffoodName.getText().isEmpty() || tffoodUnit.getText().isEmpty()
							|| tffoodKcal.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "음식이름, 단위, 열량은 필수항목입니다.");
						return;
					}
					KcalFoodBean kf = new KcalFoodBean();
					kf.setFoodname(tffoodName.getText());
					kf.setFoodunit(tffoodUnit.getText().replaceAll("한", ""));
					try {
						kf.setFoodkcal(Double.parseDouble(tffoodKcal.getText().replaceAll("kcal", "")));
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "열량에는 숫자만 입력하세요.");
					}
					kf.setFoodetc(tffoodEtc.getText());
					dba.foodInsert(kf);
				}
			});
			btnfoodInsert.setBounds(169, 376, 93, 23);
		}
		return btnfoodInsert;

	}

	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(374, 10, 383, 243);
			scrollPane_2.setViewportView(getTafoodView());
		}
		return scrollPane_2;
	}

	private JTextArea getTafoodView() {
		if (tafoodView == null) {
			tafoodView = new JTextArea();
			tafoodView.setEditable(false);
		}
		return tafoodView;
	}

	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("* 음식정보는 모든 회원이 공유");
			lblNewLabel_4.setBounds(87, 409, 175, 15);
		}
		return lblNewLabel_4;
	}

	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("- 하는 자료입니다.");
			lblNewLabel_5.setBounds(87, 423, 175, 15);
		}
		return lblNewLabel_5;
	}

	private JTextField getTffoodCount() {
		if (tffoodCount == null) {
			tffoodCount = new JTextField();
			tffoodCount.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tffoodCount.setText("");
				}
			});
			tffoodCount.setText("1");
			tffoodCount.setBounds(226, 171, 36, 21);
			tffoodCount.setColumns(10);
		}
		return tffoodCount;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("개");
			label_2.setBounds(263, 174, 28, 15);
		}
		return label_2;
	}

	// 음식선택
	private JButton getBtnfoodAdd() {
		if (btnfoodAdd == null) {
			btnfoodAdd = new JButton("추가");
			btnfoodAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double foodcount = Double.parseDouble(tffoodCount.getText());
					int i = foodTable.getSelectedRow();
					if (i == -1) {
						JOptionPane.showMessageDialog(null, "음식을 선택해주세요");
						return;
					}
					tafoodView.append(arr1.get(i).getFoodname() + " " + df.format(foodcount) + arr1.get(i).getFoodunit()
							+ " " + arr1.get(i).getFoodkcal() * foodcount + "kcal" + "\n");
					kcalIn += arr1.get(i).getFoodkcal() * foodcount;
					KcalInBean ki = new KcalInBean();
					ki.setUserid(getUserID());
					ki.setFoodname(arr1.get(i).getFoodname());
					ki.setFoodcnt(Integer.parseInt(tffoodCount.getText()));
					arr4.add(ki);
					tffoodCount.setText("1");
				}
			});
			btnfoodAdd.setBounds(281, 170, 81, 23);
		}
		return btnfoodAdd;
	}

	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("열량");
			label_3.setBounds(87, 317, 57, 15);
		}
		return label_3;
	}

	private JTextField getTffoodEtc() {
		if (tffoodEtc == null) {
			tffoodEtc = new JTextField();
			tffoodEtc.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tffoodEtc.setText("");
				}
			});
			tffoodEtc.setBounds(146, 339, 116, 21);
			tffoodEtc.setColumns(10);
		}
		return tffoodEtc;
	}

	// 음식열량출력
	private JButton getBtnfoodCal() {
		if (btnfoodCal == null) {
			btnfoodCal = new JButton("열량계산");
			btnfoodCal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tffoodCal.setText(String.valueOf(kcalIn + "kcal"));
					tfkcalFood.setText(String.valueOf(kcalIn));
					tfkcalFinal.setText(String.valueOf(Double.parseDouble(tfkcalFood.getText())
							- Double.parseDouble(tfkcalAct.getText()) - Double.parseDouble(tfkcalKCAL.getText())));
				}
			});
			btnfoodCal.setBounds(660, 259, 97, 23);
		}
		return btnfoodCal;
	}

	private JButton getBtnfoodReset() {
		if (btnfoodReset == null) {
			btnfoodReset = new JButton("초기화");
			btnfoodReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kcalIn = 0;
					tafoodView.setText("");
					tffoodCal.setText("");

				}
			});
			btnfoodReset.setBounds(551, 259, 97, 23);
		}
		return btnfoodReset;
	}

	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("입력된 음식의 총열량");
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_6.setBounds(515, 292, 133, 15);
		}
		return lblNewLabel_6;
	}

	private JTextField getTffoodCal() {
		if (tffoodCal == null) {
			tffoodCal = new JTextField();
			tffoodCal.setEditable(false);
			tffoodCal.setBounds(660, 288, 97, 21);
			tffoodCal.setColumns(10);
		}
		return tffoodCal;
	}

	// 음식날짜
	private JSpinner getSpnfoodDate() {
		if (spnfoodDate == null) {
			Date now = new Date();
			SpinnerDateModel model = new SpinnerDateModel(now, null, now, Calendar.DAY_OF_WEEK);
			spnfoodDate = new JSpinner(model);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			JSpinner.DateEditor spDate = new JSpinner.DateEditor(spnfoodDate, "yyyy-MM-dd");
			JFormattedTextField ftf = spDate.getTextField();
			ftf.setHorizontalAlignment(JTextField.CENTER);
			spnfoodDate.setEditor(spDate);
			spnfoodDate.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					Date value = (Date) model.getValue();
					Date next = (Date) model.getNextValue();
					if (value != null && next != null) {
						df.format(value);
						df.format(next);
					}
				}
			});
			spnfoodDate.setBounds(374, 416, 97, 22);
		}
		return spnfoodDate;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("의 데이터");
			label.setBounds(472, 419, 81, 15);
		}
		return label;
	}

	private JButton getBtnfoodSave() {
		if (btnfoodSave == null) {
			btnfoodSave = new JButton("저장하기");
			btnfoodSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getUserID() == null) {
						JOptionPane.showMessageDialog(null, "로그인이 필요한 기능입니다.");
						return;
					}
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					dba.foodSave(arr4, df.format(spnfoodDate.getValue()));
				}
			});
			btnfoodSave.setBounds(660, 415, 97, 23);
		}
		return btnfoodSave;
	}

	private JButton getBtnfoodLoad() {
		if (btnfoodLoad == null) {
			btnfoodLoad = new JButton("불러오기");
			btnfoodLoad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getUserID() == null) {
						JOptionPane.showMessageDialog(null, "로그인이 필요한 기능입니다.");
						return;
					}
					kcalIn = 0;
					arr4.clear();
					tafoodView.setText("");
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					arr4 = dba.foodLoad(df.format(spnfoodDate.getValue()), getUserID());
					for (int i = 0; i < arr4.size(); i++) {
						tafoodView.append(arr4.get(i).getFoodname() + " ");
						tafoodView.append(arr4.get(i).getFoodcnt() + arr4.get(i).getFoodunit() + " ");
						tafoodView.append(arr4.get(i).getFoodkcal() * arr4.get(i).getFoodcnt() + "kcal\n");
						kcalIn += arr4.get(i).getFoodkcal() * arr4.get(i).getFoodcnt();
					}
					arr4.clear();
				}
			});
			btnfoodLoad.setBounds(551, 415, 97, 23);
		}
		return btnfoodLoad;
	}

	// 음식수정
	private JButton getBtnfoodUpdate() {
		if (btnfoodUpdate == null) {
			btnfoodUpdate = new JButton("수정");
			btnfoodUpdate.setEnabled(false);
			btnfoodUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "정말로 수정하시겠습니까?", "수정확인", JOptionPane.YES_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						KcalFoodBean kf = new KcalFoodBean();
						kf.setFoodname(tffoodName.getText());
						kf.setFoodunit(tffoodUnit.getText().replaceAll("한", ""));
						try {
							kf.setFoodkcal(Double.parseDouble(tffoodKcal.getText().replaceAll("kcal", "")));

						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "열량에는 숫자만 입력하세요.");
						}
						kf.setFoodetc(tffoodEtc.getText());
						dba.foodUpdate(kf);
					} else
						return;
				}
			});
			btnfoodUpdate.setBounds(87, 376, 81, 23);
		}
		return btnfoodUpdate;
	}

	private JTextField getTffoodKcal() {
		if (tffoodKcal == null) {
			tffoodKcal = new JTextField();
			tffoodKcal.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tffoodKcal.setText("");
				}
			});
			tffoodKcal.setColumns(10);
			tffoodKcal.setBounds(146, 314, 116, 21);
		}
		return tffoodKcal;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("특이사항");
			label_4.setBounds(87, 342, 57, 15);
		}
		return label_4;
	}

	// 음식전체보기
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("음식전체보기");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tffoodSearch.setText("");
					arr1 = dba.foodSearch("");
					String[] cols = { "음식이름", "단위", "열량", "특이사항" };
					DefaultTableModel dt = new DefaultTableModel(cols, arr1.size());
					foodTable.setModel(dt);
					for (int i = 0; i < arr1.size(); i++) {
						dt.setValueAt(arr1.get(i).getFoodname(), i, 0);
						dt.setValueAt("한" + arr1.get(i).getFoodunit(), i, 1);
						dt.setValueAt(df.format(arr1.get(i).getFoodkcal()) + "kcal", i, 2);
						dt.setValueAt(arr1.get(i).getFoodetc(), i, 3);
					}
				}
			});
			btnNewButton_1.setBounds(109, 170, 116, 23);
		}
		return btnNewButton_1;
	}

	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("회원가입/정보수정");
			label_5.setBounds(87, 242, 121, 15);
		}
		return label_5;
	}

	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("아이디");
			label_6.setBounds(87, 267, 57, 15);
		}
		return label_6;
	}

	private JTextField getTfuserID() {
		if (tfuserID == null) {
			tfuserID = new JTextField();
			tfuserID.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tfuserID.setText("");
					btnuserUpdate.setEnabled(false);
				}
			});
			tfuserID.setColumns(10);
			tfuserID.setBounds(146, 264, 116, 21);
		}
		return tfuserID;
	}

	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("비밀번호");
			label_7.setBounds(87, 292, 57, 15);
		}
		return label_7;
	}

	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("이름");
			label_8.setBounds(87, 317, 57, 15);
		}
		return label_8;
	}

	private JTextField getTfuserName() {
		if (tfuserName == null) {
			tfuserName = new JTextField();
			tfuserName.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tfuserName.setText("");
				}
			});
			tfuserName.setColumns(10);
			tfuserName.setBounds(146, 314, 116, 21);
		}
		return tfuserName;
	}

	private JLabel getLabel_9() {
		if (label_9 == null) {
			label_9 = new JLabel("생년월일");
			label_9.setBounds(87, 342, 57, 15);
		}
		return label_9;
	}

	private JButton getBtnuserUpdate() {
		if (btnuserUpdate == null) {
			btnuserUpdate = new JButton("회원정보수정");
			btnuserUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "정말로 수정하시겠습니까?", "수정확인", JOptionPane.YES_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						KcalUserBean ku = new KcalUserBean();
						ku.setUserid(tfuserID.getText());
						ku.setPassword(String.valueOf(pfuserPW.getPassword()));
						ku.setUsername(tfuserName.getText());
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						ku.setBirth(df.format(spnbirth.getValue()));
						String gender;
						if (rbMan.isSelected())
							gender = rbMan.getText();
						else
							gender = rbWoman.getText();
						ku.setGender(gender);
						dba.userUpdate(ku);
					} else
						return;
					tfuserID.setText("");
					pfuserPW.setText("");
					tfuserName.setText("");
					tfuserID.setEditable(true);
					btnuserUpdate.setEnabled(false);
				}
			});
			btnuserUpdate.setEnabled(false);
			btnuserUpdate.setBounds(92, 370, 116, 23);
		}
		return btnuserUpdate;
	}

	private JButton getBtnuserInsert() {
		if (btnuserInsert == null) {
			btnuserInsert = new JButton("회원가입");
			btnuserInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tfuserID.getText().isEmpty() || tfuserName.getText().isEmpty()
							|| String.valueOf(pfuserPW.getPassword()).isEmpty()) {
						JOptionPane.showMessageDialog(null, "가입정보를 모두 입력하세요");
						return;
					}
					KcalUserBean ku = new KcalUserBean();
					ku.setUserid(tfuserID.getText());
					ku.setPassword(String.valueOf(pfuserPW.getPassword()));
					ku.setUsername(tfuserName.getText());
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					ku.setBirth(df.format(spnbirth.getValue()));
					String gender;
					if (rbMan.isSelected())
						gender = rbMan.getText();
					else
						gender = rbWoman.getText();
					ku.setGender(gender);
					dba.userInsert(ku);
					tfuserID.setText("");
					pfuserPW.setText("");
					tfuserName.setText("");
				}
			});
			btnuserInsert.setBounds(209, 370, 116, 23);
		}
		return btnuserInsert;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(0, 0, 769, 522);
			panel.add(getScrollPane_3());
			panel.add(getTfactSearch());
			panel.add(getLabel_10());
			panel.add(getLabel_11());
			panel.add(getTextField_1_1());
			panel.add(getLabel_12());
			panel.add(getTextField_2_1());
			panel.add(getBtnactInsert());
			panel.add(getScrollPane_4());
			panel.add(getLabel_13());
			panel.add(getLabel_14());
			panel.add(getTextField_5_1());
			panel.add(getLabel_15());
			panel.add(getBtnactAdd());
			panel.add(getLabel_16());
			panel.add(getTfactEtc());
			panel.add(getBtnactCal());
			panel.add(getBtnactReset());
			panel.add(getLabel_17());
			panel.add(getTfactCal());
			panel.add(getSpnactDate());
			panel.add(getLabel_18());
			panel.add(getBtnactSave());
			panel.add(getBtnactLoad());
			panel.add(getBtnactUpdate());
			panel.add(getTfactKcal());
			panel.add(getLabel_19());
			panel.add(getBtnactSearch());
		}
		return panel;
	}

	private JScrollPane getScrollPane_3() {
		if (scrollPane_3 == null) {
			scrollPane_3 = new JScrollPane();
			scrollPane_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			scrollPane_3.setBounds(12, 10, 350, 150);
			scrollPane_3.setViewportView(getActTable());
		}
		return scrollPane_3;
	}

	// 활동검색
	private JTextField getTfactSearch() {
		if (tfactSearch == null) {
			tfactSearch = new JTextField();
			tfactSearch.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tfactSearch.setText("");
				}
			});
			tfactSearch.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (tfactSearch.getText().isEmpty())
						return;
					arr2 = dba.actSearch(tfactSearch.getText());
					String[] cols = { "활동이름", "단위", "열량", "특이사항" };
					DefaultTableModel dt = new DefaultTableModel(cols, arr2.size());
					actTable.setModel(dt);
					for (int i = 0; i < arr2.size(); i++) {
						dt.setValueAt(arr2.get(i).getActname(), i, 0);
						dt.setValueAt(arr2.get(i).getActunit(), i, 1);
						dt.setValueAt(df.format(arr2.get(i).getActkcal()) + "kcal", i, 2);
						dt.setValueAt(arr2.get(i).getActetc(), i, 3);
					}
				}
			});
			tfactSearch.setText("활동이름");
			tfactSearch.setColumns(10);
			tfactSearch.setBounds(12, 171, 97, 21);
		}
		return tfactSearch;
	}

	private JLabel getLabel_10() {
		if (label_10 == null) {
			label_10 = new JLabel("새활동등록/수정");
			label_10.setBounds(87, 242, 97, 15);
		}
		return label_10;
	}

	private JLabel getLabel_11() {
		if (label_11 == null) {
			label_11 = new JLabel("활동이름");
			label_11.setBounds(87, 267, 57, 15);
		}
		return label_11;
	}

	private JTextField getTextField_1_1() {
		if (tfactName == null) {
			tfactName = new JTextField();
			tfactName.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tfactName.setText("");
					btnactUpdate.setEnabled(false);
				}
			});
			tfactName.setColumns(10);
			tfactName.setBounds(146, 264, 116, 21);
		}
		return tfactName;
	}

	private JLabel getLabel_12() {
		if (label_12 == null) {
			label_12 = new JLabel("단위");
			label_12.setBounds(87, 292, 57, 15);
		}
		return label_12;
	}

	private JTextField getTextField_2_1() {
		if (tfactUnit == null) {
			tfactUnit = new JTextField();
			tfactUnit.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tfactUnit.setText("");
				}
			});
			tfactUnit.setText("1시간, 30분, 3회 등");
			tfactUnit.setColumns(10);
			tfactUnit.setBounds(146, 289, 116, 21);
		}
		return tfactUnit;
	}

	// 활동추가
	private JButton getBtnactInsert() {
		if (btnactInsert == null) {
			btnactInsert = new JButton("등록");
			btnactInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tfactName.getText().isEmpty() || tfactUnit.getText().isEmpty()
							|| tfactKcal.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "활동이름, 단위, 열량은 필수항목입니다.");
						return;
					}
					KcalActBean ka = new KcalActBean();
					ka.setActname(tfactName.getText());
					ka.setActunit(tfactUnit.getText());
					try {
						ka.setActkcal(Double.parseDouble(tfactKcal.getText().replaceAll("kcal", "")));
						ka.setActetc(tfactEtc.getText());
						dba.actInsert(ka);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "열량에는 숫자만 입력하세요.");
					}
				}
			});
			btnactInsert.setBounds(169, 376, 93, 23);
		}
		return btnactInsert;
	}

	private JScrollPane getScrollPane_4() {
		if (scrollPane_4 == null) {
			scrollPane_4 = new JScrollPane();
			scrollPane_4.setBounds(374, 10, 383, 243);
			scrollPane_4.setViewportView(getTaactView());
		}
		return scrollPane_4;
	}

	private JLabel getLabel_13() {
		if (label_13 == null) {
			label_13 = new JLabel("* 활동정보는 모든 회원이 공유");
			label_13.setBounds(87, 409, 175, 15);
		}
		return label_13;
	}

	private JLabel getLabel_14() {
		if (label_14 == null) {
			label_14 = new JLabel("- 하는 자료입니다.");
			label_14.setBounds(87, 423, 175, 15);
		}
		return label_14;
	}

	private JTextField getTextField_5_1() {
		if (tfactCount == null) {
			tfactCount = new JTextField();
			tfactCount.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tfactCount.setText("");
				}
			});
			tfactCount.setText("1");
			tfactCount.setColumns(10);
			tfactCount.setBounds(226, 171, 36, 21);
		}
		return tfactCount;
	}

	private JLabel getLabel_15() {
		if (label_15 == null) {
			label_15 = new JLabel("회");
			label_15.setBounds(263, 174, 28, 15);
		}
		return label_15;
	}

	// 활동선택
	private JButton getBtnactAdd() {
		if (btnactAdd == null) {
			btnactAdd = new JButton("추가");
			btnactAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double actcount = Double.parseDouble(tfactCount.getText());
					int i = actTable.getSelectedRow();
					if (i == -1) {
						JOptionPane.showMessageDialog(null, "활동을 선택해주세요");
						return;
					}
					taactView.append(arr2.get(i).getActname() + " " + arr2.get(i).getActunit() + " "
							+ df.format(actcount) + "회 " + arr2.get(i).getActkcal() * actcount + "kcal" + "\n");
					kcalOut += arr2.get(i).getActkcal() * actcount;
					KcalOutBean ko = new KcalOutBean();
					ko.setUserid(getUserID());
					ko.setActname(arr2.get(i).getActname());
					ko.setActcnt(Integer.parseInt(tfactCount.getText()));
					arr5.add(ko);
					tfactCount.setText("1");
				}
			});
			btnactAdd.setBounds(281, 170, 81, 23);
		}
		return btnactAdd;
	}

	private JLabel getLabel_16() {
		if (label_16 == null) {
			label_16 = new JLabel("열량");
			label_16.setBounds(87, 317, 57, 15);
		}
		return label_16;
	}

	private JTextField getTfactEtc() {
		if (tfactEtc == null) {
			tfactEtc = new JTextField();
			tfactEtc.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tfactEtc.setText("");
				}
			});
			tfactEtc.setColumns(10);
			tfactEtc.setBounds(146, 339, 116, 21);
		}
		return tfactEtc;
	}

	private JButton getBtnactCal() {
		if (btnactCal == null) {
			btnactCal = new JButton("열량계산");
			btnactCal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfactCal.setText(String.valueOf(kcalOut) + "kcal");
					tfkcalAct.setText(String.valueOf(kcalOut));
					tfkcalFinal.setText(String.valueOf(Double.parseDouble(tfkcalFood.getText())
							- Double.parseDouble(tfkcalAct.getText()) - Double.parseDouble(tfkcalKCAL.getText())));
				}
			});
			btnactCal.setBounds(660, 259, 97, 23);
		}
		return btnactCal;
	}

	private JButton getBtnactReset() {
		if (btnactReset == null) {
			btnactReset = new JButton("초기화");
			btnactReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kcalOut = 0;
					taactView.setText("");
					tfactCal.setText("");
				}
			});
			btnactReset.setBounds(551, 259, 97, 23);
		}
		return btnactReset;
	}

	private JLabel getLabel_17() {
		if (label_17 == null) {
			label_17 = new JLabel("입력된 활동의 총열량");
			label_17.setHorizontalAlignment(SwingConstants.RIGHT);
			label_17.setBounds(515, 292, 133, 15);
		}
		return label_17;
	}

	private JTextField getTfactCal() {
		if (tfactCal == null) {
			tfactCal = new JTextField();
			tfactCal.setEditable(false);
			tfactCal.setColumns(10);
			tfactCal.setBounds(660, 288, 97, 21);
		}
		return tfactCal;
	}

	private JSpinner getSpnactDate() {
		if (spnactDate == null) {
			Date now = new Date();
			final SpinnerDateModel model = new SpinnerDateModel(now, null, now, Calendar.DAY_OF_WEEK);
			spnactDate = new JSpinner(model);
			final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			JSpinner.DateEditor spDate = new JSpinner.DateEditor(spnactDate, "yyyy-MM-dd");
			JFormattedTextField ftf = spDate.getTextField();
			ftf.setHorizontalAlignment(JTextField.CENTER);
			spnactDate.setEditor(spDate);
			spnactDate.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					Date value = (Date) model.getValue();
					Date next = (Date) model.getNextValue();
					if (value != null && next != null) {
						df.format(value);
						df.format(next);
					}
				}
			});
			spnactDate.setBounds(374, 416, 97, 22);
		}
		return spnactDate;
	}

	private JLabel getLabel_18() {
		if (label_18 == null) {
			label_18 = new JLabel("의 데이터");
			label_18.setBounds(472, 419, 63, 15);
		}
		return label_18;
	}

	private JButton getBtnactSave() {
		if (btnactSave == null) {
			btnactSave = new JButton("저장하기");
			btnactSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getUserID() == null) {
						JOptionPane.showMessageDialog(null, "로그인이 필요한 기능입니다.");
						return;
					}
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					dba.actSave(arr5, df.format(spnactDate.getValue()));
				}
			});
			btnactSave.setBounds(660, 415, 97, 23);
		}
		return btnactSave;
	}

	private JButton getBtnactLoad() {
		if (btnactLoad == null) {
			btnactLoad = new JButton("불러오기");
			btnactLoad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getUserID() == null) {
						JOptionPane.showMessageDialog(null, "로그인이 필요한 기능입니다.");
						return;
					}
					kcalOut = 0;
					arr5.clear();
					taactView.setText("");
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					arr5 = dba.actLoad(df.format(spnactDate.getValue()), getUserID());
					for (int i = 0; i < arr5.size(); i++) {
						taactView.append(arr5.get(i).getActname() + " ");
						taactView.append(arr5.get(i).getActunit() + " " + arr5.get(i).getActcnt() + "회 ");
						taactView.append(arr5.get(i).getActkcal() * arr5.get(i).getActcnt() + "kcal\n");
						kcalOut += arr5.get(i).getActkcal() * arr5.get(i).getActcnt();
					}
					arr4.clear();
				}
			});
			btnactLoad.setBounds(551, 415, 97, 23);
		}
		return btnactLoad;
	}

	// 활동수정
	private JButton getBtnactUpdate() {
		if (btnactUpdate == null) {
			btnactUpdate = new JButton("수정");
			btnactUpdate.setEnabled(false);
			btnactUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "정말로 수정하시겠습니까?", "수정확인", JOptionPane.YES_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						KcalActBean ka = new KcalActBean();
						ka.setActname(tfactName.getText());
						ka.setActunit(tfactUnit.getText());
						try {
							ka.setActkcal(Double.parseDouble(tfactKcal.getText().replaceAll("kcal", "")));
							ka.setActetc(tfactEtc.getText());
							dba.actUpdate(ka);
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "열량에는 숫자만 입력하세요.");
						}
					} else
						return;
				}
			});
			btnactUpdate.setBounds(87, 376, 81, 23);
		}
		return btnactUpdate;
	}

	private JTextField getTfactKcal() {
		if (tfactKcal == null) {
			tfactKcal = new JTextField();
			tfactKcal.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tfactKcal.setText("");
				}
			});
			tfactKcal.setColumns(10);
			tfactKcal.setBounds(146, 314, 116, 21);
		}
		return tfactKcal;
	}

	private JLabel getLabel_19() {
		if (label_19 == null) {
			label_19 = new JLabel("특이사항");
			label_19.setBounds(87, 342, 57, 15);
		}
		return label_19;
	}

	// 활동전체보기
	private JButton getBtnactSearch() {
		if (btnactSearch == null) {
			btnactSearch = new JButton("활동전체보기");
			btnactSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfactSearch.setText("");
					arr2 = dba.actSearch("");
					String[] cols = { "활동이름", "단위", "열량", "특이사항" };
					DefaultTableModel dt = new DefaultTableModel(cols, arr2.size());
					actTable.setModel(dt);
					for (int i = 0; i < arr2.size(); i++) {
						dt.setValueAt(arr2.get(i).getActname(), i, 0);
						dt.setValueAt(arr2.get(i).getActunit(), i, 1);
						dt.setValueAt(df.format(arr2.get(i).getActkcal()) + "kcal", i, 2);
						dt.setValueAt(arr2.get(i).getActetc(), i, 3);
					}
				}
			});
			btnactSearch.setBounds(109, 170, 116, 23);
		}
		return btnactSearch;
	}

	private JRadioButton getRbMan() {
		if (rbMan == null) {
			rbMan = new JRadioButton("남");
			rbMan.setSelected(true);
			bg.add(rbMan);
			rbMan.setBounds(274, 338, 51, 23);
		}
		return rbMan;
	}

	private JRadioButton getRbWoman() {
		if (rbWoman == null) {
			rbWoman = new JRadioButton("여");
			bg.add(rbWoman);
			rbWoman.setBounds(321, 338, 51, 23);
		}
		return rbWoman;
	}

	private JTextArea getTaactView() {
		if (taactView == null) {
			taactView = new JTextArea();
			taactView.setEditable(false);
		}
		return taactView;
	}

	private JTable getActTable() {
		if (actTable == null) {
			actTable = new JTable();
			actTable.addMouseListener(new MouseAdapter() {
				// 활동테이블클릭
				@Override
				public void mouseClicked(MouseEvent e) {
					int i = actTable.getSelectedRow();
					tfactName.setText(arr2.get(i).getActname());
					tfactUnit.setText(arr2.get(i).getActunit());
					tfactKcal.setText(String.valueOf(arr2.get(i).getActkcal() + "kcal"));
					tfactEtc.setText(arr2.get(i).getActetc());
					btnactUpdate.setEnabled(true);
				}
			});
			actTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "활동이름", "단위", "열량", "특이사항" }));
		}
		return actTable;
	}

	private JPasswordField getPfuserPW() {
		if (pfuserPW == null) {
			pfuserPW = new JPasswordField();
			pfuserPW.setEchoChar('?');
			pfuserPW.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					pfuserPW.setText("");
				}
			});
			pfuserPW.setBounds(146, 289, 116, 21);
		}
		return pfuserPW;
	}

	private JPasswordField getPfpasswordLogin() {
		if (pfpasswordLogin == null) {
			pfpasswordLogin = new JPasswordField();
			pfpasswordLogin.setEchoChar('*');
			pfpasswordLogin.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					pfpasswordLogin.setText("");
				}
			});
			pfpasswordLogin.setText("비밀번호");
			pfpasswordLogin.setBounds(183, 171, 79, 21);
		}
		return pfpasswordLogin;
	}

	private JScrollPane getScrollPane_5() {
		if (scrollPane_5 == null) {
			scrollPane_5 = new JScrollPane();
			scrollPane_5.setBounds(374, 10, 383, 502);
			scrollPane_5.setViewportView(getTauserView());
		}
		return scrollPane_5;
	}

	private JTextArea getTauserView() {
		if (tauserView == null) {
			tauserView = new JTextArea();
			tauserView.setEditable(false);
		}
		return tauserView;
	}

	private JSpinner getSpnbirth() {
		if (spnbirth == null) {
			Date now = new Date();
			SpinnerDateModel model = new SpinnerDateModel(now, null, now, Calendar.DAY_OF_WEEK);
			spnbirth = new JSpinner(model);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			JSpinner.DateEditor spDate = new JSpinner.DateEditor(spnbirth, "yyyy-MM-dd");
			JFormattedTextField ftf = spDate.getTextField();
			ftf.setHorizontalAlignment(JTextField.CENTER);
			spnbirth.setEditor(spDate);
			spnbirth.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					Date value = (Date) model.getValue();
					Date next = (Date) model.getNextValue();
					if (value != null && next != null) {
						df.format(value);
						df.format(next);
					}
				}
			});
			spnbirth.setBounds(146, 339, 116, 22);
		}
		return spnbirth;

	}

	private JLabel getLabel_20() {
		if (label_20 == null) {
			label_20 = new JLabel("* 상단의 표에서 로그인할 계정을 선택한 후 로그인 해주세요.");
			label_20.setBounds(12, 202, 350, 15);
		}
		return label_20;
	}

	private JTextField getTfkcalName() {
		if (tfkcalName == null) {
			tfkcalName = new JTextField();
			tfkcalName.setBounds(12, 10, 116, 21);
			tfkcalName.setHorizontalAlignment(SwingConstants.CENTER);
			tfkcalName.setEditable(false);
			tfkcalName.setColumns(10);
		}
		return tfkcalName;
	}

	private JLabel getLabel_21() {
		if (label_21 == null) {
			label_21 = new JLabel("님의 연령은");
			label_21.setBounds(129, 13, 77, 15);
		}
		return label_21;
	}

	private JTextField getTfkcalAge() {
		if (tfkcalAge == null) {
			tfkcalAge = new JTextField();
			tfkcalAge.setBounds(198, 10, 57, 21);
			tfkcalAge.setHorizontalAlignment(SwingConstants.CENTER);
			tfkcalAge.setEditable(false);
			tfkcalAge.setColumns(10);
		}
		return tfkcalAge;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("세 이고 성별은");
			lblNewLabel_2.setBounds(258, 13, 96, 15);
		}
		return lblNewLabel_2;
	}

	private JTextField getTfkcalWeight() {
		if (tfkcalWeight == null) {
			tfkcalWeight = new JTextField();
			tfkcalWeight.setBounds(12, 116, 116, 21);
			tfkcalWeight.setHorizontalAlignment(SwingConstants.RIGHT);
			tfkcalWeight.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tfkcalWeight.setText("");
				}
			});
			tfkcalWeight.setText("체중을 입력하세요\r\n");
			tfkcalWeight.setColumns(10);
		}
		return tfkcalWeight;
	}

	private JLabel getLabel_22() {
		if (label_22 == null) {
			label_22 = new JLabel("기초대사량 산출방법");
			label_22.setBounds(12, 41, 127, 15);
		}
		return label_22;
	}

	private JLabel getLblxxx() {
		if (lblxxx == null) {
			lblxxx = new JLabel("남자 : 66.47 + (13.75 X 몸무게) + (5 X 키) - (6.76 X 나이)");
			lblxxx.setBounds(12, 66, 342, 15);
		}
		return lblxxx;
	}

	private JTextField getTfkcalHeight() {
		if (tfkcalHeight == null) {
			tfkcalHeight = new JTextField();
			tfkcalHeight.setBounds(156, 116, 116, 21);
			tfkcalHeight.setHorizontalAlignment(SwingConstants.RIGHT);
			tfkcalHeight.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tfkcalHeight.setText("");
				}
			});
			tfkcalHeight.setText("신장을 입력하세요\r\n");
			tfkcalHeight.setColumns(10);
		}
		return tfkcalHeight;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("여자 : 655.1 + (9.56 X 몸무게) + (1.85 X 키) - (4.68 X 나이)");
			lblNewLabel_3.setBounds(12, 91, 342, 15);
		}
		return lblNewLabel_3;
	}

	private JLabel getLblKg() {
		if (lblKg == null) {
			lblKg = new JLabel("kg");
			lblKg.setBounds(129, 119, 29, 15);
		}
		return lblKg;
	}

	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("cm");
			lblNewLabel_7.setBounds(273, 119, 57, 15);
		}
		return lblNewLabel_7;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("기초대사량계산");
			btnNewButton.setBounds(12, 150, 127, 23);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getUserID() == null) {
						JOptionPane.showMessageDialog(null, "로그인이 필요한 기능입니다.");
						return;
					}
					try {
						if (gender.equals("남")) {
							String kcal = String
									.valueOf(df.format(66.47 + (13.75 * Double.parseDouble(tfkcalWeight.getText()))
											+ (5 * Double.parseDouble(tfkcalHeight.getText())) - (6.76 * age)));
							tfkcalCal.setText(kcal);
							tfkcalKCAL.setText(kcal);
						} else if (gender.equals("여")) {
							String kcal = String
									.valueOf(df.format(655.1 + (9.56 * Double.parseDouble(tfkcalWeight.getText()))
											+ (1.85 * Double.parseDouble(tfkcalHeight.getText())) - (4.68 * age)));
							tfkcalCal.setText(kcal);
							tfkcalKCAL.setText(kcal);
						}
						tfkcalFinal.setText(String.valueOf(df.format(Double.parseDouble(tfkcalFood.getText())
								- Double.parseDouble(tfkcalAct.getText()) - Double.parseDouble(tfkcalKCAL.getText()))));
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "숫자를 입력하세요.");
					}

				}
			});
		}
		return btnNewButton;
	}

	private JTextField getTfkcalCal() {
		if (tfkcalCal == null) {
			tfkcalCal = new JTextField();
			tfkcalCal.setBounds(156, 151, 116, 21);
			tfkcalCal.setHorizontalAlignment(SwingConstants.RIGHT);
			tfkcalCal.setColumns(10);
		}
		return tfkcalCal;
	}

	private JTextField getTfkcalGender() {
		if (tfkcalGender == null) {
			tfkcalGender = new JTextField();
			tfkcalGender.setBounds(342, 10, 57, 21);
			tfkcalGender.setHorizontalAlignment(SwingConstants.CENTER);
			tfkcalGender.setEditable(false);
			tfkcalGender.setColumns(10);
		}
		return tfkcalGender;
	}

	private JLabel getLblKcal() {
		if (lblKcal == null) {
			lblKcal = new JLabel("kcal");
			lblKcal.setBounds(273, 154, 57, 15);
		}
		return lblKcal;
	}

	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("입니다.");
			lblNewLabel_8.setBounds(403, 13, 57, 15);
		}
		return lblNewLabel_8;
	}

	private JLabel getLabel_23() {
		if (label_23 == null) {
			label_23 = new JLabel("남는 열량 산출방법");
			label_23.setBounds(403, 66, 127, 15);
		}
		return label_23;
	}

	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("음식섭취열량 - 활동소모열량 - 기초대사량   = 일일잔여열량");
			lblNewLabel_9.setBounds(403, 91, 342, 15);
		}
		return lblNewLabel_9;
	}

	private JScrollPane getScrollPane_6_1() {
		if (scrollPane_6 == null) {
			scrollPane_6 = new JScrollPane();

			scrollPane_6.setBounds(12, 183, 745, 329);
		}
		return scrollPane_6;
	}

	private JTextField getTfkcalFood() {
		if (tfkcalFood == null) {
			tfkcalFood = new JTextField();
			tfkcalFood.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tfkcalFood.setText("");
				}
			});
			tfkcalFood.setHorizontalAlignment(SwingConstants.RIGHT);
			tfkcalFood.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					tfkcalFinal.setText(String.valueOf(Double.parseDouble(tfkcalFood.getText())
							- Double.parseDouble(tfkcalAct.getText()) - Double.parseDouble(tfkcalKCAL.getText())));
				}
			});
			tfkcalFood.setText("0");
			tfkcalFood.setBounds(403, 116, 71, 21);
			tfkcalFood.setColumns(10);
		}
		return tfkcalFood;
	}

	private JLabel getLabel_24() {
		if (label_24 == null) {
			label_24 = new JLabel("-");
			label_24.setBounds(479, 119, 15, 15);
		}
		return label_24;
	}

	private JTextField getTfkcalAct() {
		if (tfkcalAct == null) {
			tfkcalAct = new JTextField();
			tfkcalAct.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tfkcalAct.setText("");
				}
			});
			tfkcalAct.setHorizontalAlignment(SwingConstants.RIGHT);
			tfkcalAct.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					tfkcalFinal.setText(String.valueOf(Double.parseDouble(tfkcalFood.getText())
							- Double.parseDouble(tfkcalAct.getText()) - Double.parseDouble(tfkcalKCAL.getText())));
				}
			});

			tfkcalAct.setText("0");
			tfkcalAct.setColumns(10);
			tfkcalAct.setBounds(490, 116, 71, 21);
		}
		return tfkcalAct;
	}

	private JLabel getLabel_25() {
		if (label_25 == null) {
			label_25 = new JLabel("-");
			label_25.setBounds(565, 119, 15, 15);
		}
		return label_25;
	}

	private JTextField getTfkcalKCAL() {
		if (tfkcalKCAL == null) {
			tfkcalKCAL = new JTextField();
			tfkcalKCAL.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tfkcalKCAL.setText("");
				}
			});
			tfkcalKCAL.setHorizontalAlignment(SwingConstants.RIGHT);
			tfkcalKCAL.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					tfkcalFinal.setText(String.valueOf(Double.parseDouble(tfkcalFood.getText())
							- Double.parseDouble(tfkcalAct.getText()) - Double.parseDouble(tfkcalKCAL.getText())));
				}
			});
			tfkcalKCAL.setText("0");
			tfkcalKCAL.setColumns(10);
			tfkcalKCAL.setBounds(573, 116, 71, 21);
		}
		return tfkcalKCAL;
	}

	private JLabel getLabel_26() {
		if (label_26 == null) {
			label_26 = new JLabel("=");
			label_26.setBounds(646, 119, 15, 15);
		}
		return label_26;
	}

	private JTextField getTfkcalFinal() {
		if (tfkcalFinal == null) {
			tfkcalFinal = new JTextField();
			tfkcalFinal.setHorizontalAlignment(SwingConstants.RIGHT);
			tfkcalFinal.setEditable(false);
			tfkcalFinal.setText("0");
			tfkcalFinal.setColumns(10);
			tfkcalFinal.setBounds(656, 116, 71, 21);
		}
		return tfkcalFinal;
	}

	private JLabel getLblKcal_1() {
		if (lblKcal_1 == null) {
			lblKcal_1 = new JLabel("kcal");
			lblKcal_1.setBounds(729, 119, 40, 15);
		}
		return lblKcal_1;
	}

	private JLabel getLabel_27() {
		if (label_27 == null) {
			label_27 = new JLabel("의 일일잔여열량");
			label_27.setBounds(500, 154, 96, 15);
		}
		return label_27;
	}

	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("저장하기");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getUserID() == null) {
						JOptionPane.showMessageDialog(null, "로그인이 필요한 기능입니다.");
						return;
					}
					if (tfkcalFood.getText().equals("0") && tfkcalAct.getText().equals("0")
							&& tfkcalKCAL.getText().equals("0") && tfkcalFinal.getText().equals("0")) {
						JOptionPane.showMessageDialog(null, "값을 입력해주세요.");
						return;
					}
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					dba.chartdataSave(userID, df.format(spnkcalDate.getValue()), tfkcalFinal.getText());
					arr6 = dba.chartdataLoad(userID);
					KcalChart chart = new KcalChart(arr6);
					scrollPane_6.setViewportView(chart);
				}
			});
			button_1.setBounds(630, 150, 97, 23);
		}
		return button_1;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	private JSpinner getSpnkcalDate() {
		if (spnkcalDate == null) {
			Date now = new Date();
			final SpinnerDateModel model = new SpinnerDateModel(now, null, now, Calendar.DAY_OF_WEEK);
			spnkcalDate = new JSpinner(model);
			final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			JSpinner.DateEditor spDate = new JSpinner.DateEditor(spnkcalDate, "yyyy-MM-dd");
			JFormattedTextField ftf = spDate.getTextField();
			ftf.setHorizontalAlignment(JTextField.CENTER);
			spnkcalDate.setEditor(spDate);
			spnkcalDate.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					Date value = (Date) model.getValue();
					Date next = (Date) model.getNextValue();
					if (value != null && next != null) {
						df.format(value);
						df.format(next);
					}
				}
			});
			spnkcalDate.setBounds(403, 151, 97, 22);
		}
		return spnkcalDate;
	}

	private JButton getBtnOut() {
		if (btnOut == null) {
			btnOut = new JButton("로그아웃");
			btnOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setUserID(null);
					gender = null;
					kcalIn = 0;
					kcalOut = 0;
					arr4.clear();
					arr5.clear();
					arr6.clear();
					tafoodView.setText("");
					taactView.setText("");
					tfkcalName.setText("");
					tfkcalGender.setText("");
					tfkcalAge.setText("");
					dba.userHistory("", tauserView);
					arr6 = dba.chartdataLoad("");
					KcalChart chart = new KcalChart(arr6);
					scrollPane_6.setViewportView(chart);
					tauserView.setText("");
				}
			});
			btnOut.setBounds(660, 9, 97, 23);
		}
		return btnOut;
	}
	private JButton getButton_2() {
		if (btnLogout == null) {
			btnLogout = new JButton("로그아웃");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnOut.doClick();
				}
			});
			btnLogout.setBounds(265, 489, 97, 23);
		}
		return btnLogout;
	}
	private JLabel getLblBetaVersion() {
		if (lblBetaVersion == null) {
			lblBetaVersion = new JLabel("Beta Version");
			lblBetaVersion.setBounds(12, 497, 97, 15);
		}
		return lblBetaVersion;
	}
}
