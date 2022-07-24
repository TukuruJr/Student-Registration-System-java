package com.java.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.java.student_model_class.Student;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class REGISTRATION implements ActionListener{

	private JFrame frame;
	private JTextField getid;
	private JTextField getsurname;
	private JTextField getfname;
	private JTextField getlname;
	private JTextField getadm;
	private JTextField getemail;
	private JTextField getmobile;
	private JTextField guardian;
	private JTextField gemail;
	private JTextField gmobile;
	private JTable table;
    private JComboBox getcourse,getdepartment,
                     getfaculty,getgender;
    private JButton btnRegister,btnUpdateInfo,btnDelete,btnClear; 
    private Connection conn;
    private PreparedStatement pst;
    private JLabel lblfrancode;
    private JLabel lblSearchStudentAdm;
    private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					REGISTRATION window = new REGISTRATION();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public REGISTRATION() throws SQLException, ClassNotFoundException {
		initialize();
		LoadTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(139, 0, 0));
		frame.setBounds(100, 100, 837, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentRegistrationSystem = new JLabel("STUDENT REGISTRATION SYSTEM");
		lblStudentRegistrationSystem.setForeground(new Color(255, 255, 0));
		lblStudentRegistrationSystem.setBounds(295, 25, 343, 15);
		frame.getContentPane().add(lblStudentRegistrationSystem);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(24, 49, 783, 370);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIdNo = new JLabel("ID NO");
		lblIdNo.setForeground(new Color(0, 0, 0));
		lblIdNo.setBounds(25, 59, 56, 15);
		panel.add(lblIdNo);
		
		getid = new JTextField();
		getid.setBounds(122, 53, 211, 28);
		panel.add(getid);
		getid.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(345, 0, 17, 367);
		panel.add(separator);
		
		JLabel lblSurname = new JLabel("SURNAME");
		lblSurname.setForeground(Color.BLACK);
		lblSurname.setBounds(25, 93, 77, 15);
		panel.add(lblSurname);
		
		getsurname = new JTextField();
		getsurname.setColumns(10);
		getsurname.setBounds(122, 87, 211, 28);
		panel.add(getsurname);
		
		JLabel lblFirstname = new JLabel("FIRSTNAME");
		lblFirstname.setForeground(Color.BLACK);
		lblFirstname.setBounds(25, 133, 91, 15);
		panel.add(lblFirstname);
		
		getfname = new JTextField();
		getfname.setColumns(10);
		getfname.setBounds(122, 127, 211, 28);
		panel.add(getfname);
		
		JLabel lblLastname = new JLabel("LASTNAME");
		lblLastname.setForeground(Color.BLACK);
		lblLastname.setBounds(25, 173, 91, 15);
		panel.add(lblLastname);
		
		getlname = new JTextField();
		getlname.setColumns(10);
		getlname.setBounds(122, 167, 211, 28);
		panel.add(getlname);
		
		JLabel lblReg = new JLabel("REG: ");
		lblReg.setForeground(Color.BLACK);
		lblReg.setBounds(25, 18, 91, 15);
		panel.add(lblReg);
		
		getadm = new JTextField();
		getadm.setColumns(10);
		getadm.setBounds(122, 12, 211, 28);
		panel.add(getadm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(new TitledBorder(null, "CONTACT IFO", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		panel_1.setBounds(25, 214, 317, 144);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setBounds(12, 30, 70, 15);
		panel_1.add(lblEmail);
		
		getemail = new JTextField();
		getemail.setColumns(10);
		getemail.setBounds(94, 24, 211, 28);
		panel_1.add(getemail);
		
		JLabel lblMobile = new JLabel("MOBILE");
		lblMobile.setForeground(Color.BLACK);
		lblMobile.setBounds(12, 78, 70, 15);
		panel_1.add(lblMobile);
		
		getmobile = new JTextField();
		getmobile.setColumns(10);
		getmobile.setBounds(94, 76, 211, 28);
		panel_1.add(getmobile);
		
		JLabel lblCourse = new JLabel("COURSE");
		lblCourse.setForeground(Color.BLACK);
		lblCourse.setBounds(373, 18, 70, 15);
		panel.add(lblCourse);
		
		getcourse = new JComboBox();
		getcourse.setModel(new DefaultComboBoxModel(new String[] {"IT", "ROBOTICS", "COMPUTER SCIENCE", "PURE MATHS", "PURE CHEMISTRY", "CIVIL ENGINEERING"}));
		getcourse.setForeground(Color.ORANGE);
		getcourse.setBackground(new Color(102, 51, 0));
		getcourse.setBounds(473, 13, 216, 24);
		panel.add(getcourse);
		
		JLabel lblDepartment = new JLabel("DEPARTMENT");
		lblDepartment.setForeground(Color.BLACK);
		lblDepartment.setBounds(373, 59, 98, 15);
		panel.add(lblDepartment);
		
		getdepartment = new JComboBox();
		getdepartment.setModel(new DefaultComboBoxModel(new String[] {"", "MATHEMATICS", "COMPUTING"}));
		getdepartment.setForeground(Color.ORANGE);
		getdepartment.setBackground(new Color(102, 51, 0));
		getdepartment.setBounds(473, 54, 216, 24);
		panel.add(getdepartment);
		
		getfaculty = new JComboBox();
		getfaculty.setModel(new DefaultComboBoxModel(new String[] {"", "SCIENCE AND TECHNOLOGY", "ENGINEERING"}));
		getfaculty.setBackground(new Color(153, 51, 0));
		getfaculty.setForeground(Color.ORANGE);
		getfaculty.setBounds(473, 95, 216, 24);
		panel.add(getfaculty);
		
		JLabel lblFaculty = new JLabel("FACULTY");
		lblFaculty.setForeground(Color.BLACK);
		lblFaculty.setBounds(373, 106, 98, 15);
		panel.add(lblFaculty);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setForeground(Color.BLACK);
		lblGender.setBounds(380, 146, 70, 15);
		panel.add(lblGender);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "PARENT/GUARDIAN INFO", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(374, 173, 397, 185);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblGuardian = new JLabel("GUARDIAN");
		lblGuardian.setForeground(Color.BLACK);
		lblGuardian.setBounds(22, 39, 88, 15);
		panel_2.add(lblGuardian);
		
		guardian = new JTextField();
		guardian.setColumns(10);
		guardian.setBounds(116, 33, 269, 28);
		panel_2.add(guardian);
		
		JLabel lblEmail_1 = new JLabel("EMAIL");
		lblEmail_1.setForeground(Color.BLACK);
		lblEmail_1.setBounds(22, 96, 88, 15);
		panel_2.add(lblEmail_1);
		
		gemail = new JTextField();
		gemail.setColumns(10);
		gemail.setBounds(116, 90, 269, 28);
		panel_2.add(gemail);
		
		JLabel lblEmail_1_1 = new JLabel("MOBILE");
		lblEmail_1_1.setForeground(Color.BLACK);
		lblEmail_1_1.setBounds(22, 144, 88, 15);
		panel_2.add(lblEmail_1_1);
		
		gmobile = new JTextField();
		gmobile.setColumns(10);
		gmobile.setBounds(116, 138, 269, 28);
		panel_2.add(gmobile);
		
		getgender = new JComboBox();
		getgender.setModel(new DefaultComboBoxModel(new String[] {"", "MALE", "FEMALE"}));
		getgender.setForeground(Color.ORANGE);
		getgender.setBackground(new Color(102, 51, 0));
		getgender.setBounds(473, 134, 216, 24);
		panel.add(getgender);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "OPERATIONS", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_3.setBackground(Color.GREEN);
		panel_3.setBounds(16, 431, 791, 54);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		btnRegister = new JButton("REGISTER");
		btnRegister.setForeground(Color.CYAN);
		btnRegister.setBackground(Color.BLUE);
		btnRegister.setBounds(55, 17, 117, 25);
		btnRegister.setFocusable(false);
		btnRegister.addActionListener(this);
		panel_3.add(btnRegister);
		
		btnUpdateInfo = new JButton("UPDATE INFO");
		btnUpdateInfo.setForeground(Color.CYAN);
		btnUpdateInfo.setBackground(Color.BLUE);
		btnUpdateInfo.setBounds(245, 17, 138, 25);
		btnUpdateInfo.setFocusable(false);
		btnUpdateInfo.addActionListener(this);
		panel_3.add(btnUpdateInfo);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.CYAN);
		btnDelete.setBackground(Color.BLUE);
		btnDelete.setBounds(454, 17, 117, 25);
		btnDelete.setFocusable(false);
		btnDelete.addActionListener(this);
		panel_3.add(btnDelete);
		
		btnClear = new JButton("CLEAR");
		btnClear.setForeground(Color.CYAN);
		btnClear.setBackground(Color.BLUE);
		btnClear.setBounds(633, 17, 117, 25);
		btnClear.setFocusable(false);
		btnClear.addActionListener(this);
		panel_3.add(btnClear);
		
		table = new JTable();
		table.setFont(new Font("Dialog", Font.BOLD, 12));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				getsurname.setText((String)table.getValueAt(row, 0));
				getfname.setText((String)table.getValueAt(row, 1));
				getlname.setText((String)table.getValueAt(row, 2));
				getid.setText(table.getValueAt(row, 3)+"");
				getadm.setText((String)table.getValueAt(row, 4));
				getemail.setText((String)table.getValueAt(row, 5));
				getmobile.setText((String)table.getValueAt(row, 6));
				getcourse.setSelectedItem(table.getValueAt(row, 7));
				getdepartment.setSelectedItem(table.getValueAt(row, 8));
				getfaculty.setSelectedItem(table.getValueAt(row, 9));
				getgender.setSelectedItem(table.getValueAt(row, 10));
				guardian.setText((String)table.getValueAt(row, 11));
				gemail.setText((String)table.getValueAt(row, 12));
				gmobile.setText((String)table.getValueAt(row, 13));
			}
		});
		table.setForeground(new Color(0, 255, 51));
		table.setBackground(new Color(0, 0, 51));
		table.setBounds(12, 516, 801, 196);
		frame.getContentPane().add(table);
		
		lblfrancode = new JLabel("@francode");
		lblfrancode.setFont(new Font("Z003", Font.BOLD | Font.ITALIC, 16));
		lblfrancode.setForeground(new Color(51, 255, 51));
		lblfrancode.setBounds(35, 12, 97, 27);
		frame.getContentPane().add(lblfrancode);
		
		lblSearchStudentAdm = new JLabel("SEARCH STUDENT:  ADM");
		lblSearchStudentAdm.setForeground(new Color(255, 255, 255));
		lblSearchStudentAdm.setBounds(124, 489, 180, 15);
		frame.getContentPane().add(lblSearchStudentAdm);
		
		search = new JTextField();
		search.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		search.setBackground(new Color(51, 51, 0));
		search.setForeground(new Color(255, 51, 0));
		search.addActionListener(this);
		search.setBounds(322, 487, 254, 27);
		frame.getContentPane().add(search);
	
		search.setColumns(10);
	}
	
	
	
	/**
	 * handle button clicks
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		
		
		//instantiate our model class
		Student st = new Student(getsurname.getText(),getfname.getText(),getlname.getText(),getadm.getText(),
				                  getemail.getText(),getmobile.getText(),getcourse.getSelectedItem().toString(),
				                  getdepartment.getSelectedItem().toString(),getfaculty.getSelectedItem().toString(),
				                  getgender.getSelectedItem().toString(),guardian.getText(),gemail.getText(),
				                  gmobile.getText(),Integer.parseInt(getid.getText()));

		
		
		if(ev.getSource().equals(btnClear)) {
			Clear();
		}
		
		
		
		else if(ev.getSource().equals(btnRegister)) {
			//register a student
			try {
				Connect();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				PreparedStatement ps = conn.prepareStatement("select * from students where idno = ? and adm = ?");
				ps.setInt(1, st.getIdno());
				ps.setString(2, st.getAdm());
				if(ps.executeQuery().next()) {
					//student already registered
					JOptionPane.showMessageDialog(frame, "Student Already Registered  try Updating!!","Register error",JOptionPane.WARNING_MESSAGE);
					return;
				}else {
				
				pst = conn.prepareStatement("insert into students values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pst.setString(1, st.getSurname());
				pst.setString(2, st.getFirstname());
				pst.setString(3, st.getLastname());
				pst.setInt(4, st.getIdno());
				pst.setString(5, st.getAdm());
				pst.setString(6, st.getEmail());
				pst.setString(7, st.getMobile());
				pst.setString(8, st.getCourse());
				pst.setString(9, st.getDepartment());
				pst.setString(10, st.getFaculty());
				pst.setString(11, st.getGender());
				pst.setString(12, st.getGuardian());
				pst.setString(13, st.getGuardianemail());
				pst.setString(14, st.getGuardiancontact());
				
				int success = pst.executeUpdate();
				if(success>0) {
					//success
					LoadTable();
					JOptionPane.showMessageDialog(frame, "Student Registered Successfully!!");
				}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		else if(ev.getSource().equals(btnUpdateInfo)) {
			//register a student
			try {
				Connect();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				
				pst = conn.prepareStatement("update students set surname =?,firstname=?,lastname=?,idno=?,email=?,mobile=?,course=?,department=?,faculty=?,gender=?,"
						+ "guardian=?,guardian_email=?,guardian_contact=? where adm = ?");
				pst.setString(1, st.getSurname());
				pst.setString(2, st.getFirstname());
				pst.setString(3, st.getLastname());
				pst.setInt(4, st.getIdno());
				pst.setString(5,st.getEmail());
				pst.setString(6,st.getMobile() );
				pst.setString(7, st.getCourse());
				pst.setString(8, st.getDepartment() );
				pst.setString(9,st.getFaculty());
				pst.setString(10,st.getGender() );
				pst.setString(11,st.getGuardian() );
				pst.setString(12,st.getGuardianemail());
				pst.setString(13, st.getGuardiancontact());
				pst.setString(14,st.getAdm()  );
				
				int success = pst.executeUpdate();
				if(success>0) {
					//success
					LoadTable();
					JOptionPane.showMessageDialog(frame, "Student Info Updated Successfully!!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		
		
		
		else if(ev.getSource().equals(btnDelete)) {
			try {
				Connect();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				
				pst = conn.prepareStatement("delete from students where adm = ?");
				pst.setString(1, st.getAdm());
				
				
				int ok = JOptionPane.showConfirmDialog(frame, "Delete this record?");
				if(ok==JOptionPane.OK_OPTION) {
					//success
					pst.execute();
					LoadTable();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		else if(ev.getSource().equals(search)) {
			try {
				Connect();
					pst = conn.prepareStatement("select * from students where adm=?");
					pst.setString(1, search.getText());
					if(pst.executeQuery().next()) {
					table.setModel(DbUtils.resultSetToTableModel(pst.executeQuery()));}
					else {
						JOptionPane.showMessageDialog(frame, "Student Not Registered ","Register error",JOptionPane.WARNING_MESSAGE);
					}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	
	//a method to establish a connection
	private boolean Connect() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost/student","root","");
		return(conn!=null);
		
	}
	
	//a method to clear all fields
	private void Clear() {
		getid.setText("");
		getfname.setText("");
		getlname.setText("");
		getsurname.setText("");
		getemail.setText("");
		getmobile.setText("");
		getadm.setText("");
		getcourse.setSelectedIndex(0);
		getfaculty.setSelectedIndex(0);
		getdepartment.setSelectedIndex(0);
		guardian.setText("");
		gemail.setText("");
		gmobile.setText("");
		getgender.setSelectedIndex(0);
	}
	
	private void LoadTable() throws SQLException, ClassNotFoundException {
		Connect();
		PreparedStatement pst = conn.prepareStatement("select * from students");
		table.setModel(DbUtils.resultSetToTableModel(pst.executeQuery()));
	}
	
}
