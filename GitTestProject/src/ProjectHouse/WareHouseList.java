package ProjectHouse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class WareHouseList extends JFrame {

	private JPanel contentPane;
    private WareHouse1DTO dto1;
    private WareHouse1DAO dao1;
    private int sum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WareHouseList frame = new WareHouseList();
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
	public WareHouseList() {
		setTitle("구민물산 물류창고 현황");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnWare1 = new JButton("1번 창고");
		btnWare1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ware1MD wh1=new Ware1MD(WareHouseList.this);
				wh1.setVisible(true);
				wh1.setLocation(200, 200);
			}
		});
		btnWare1.setBounds(12, 42, 97, 23);
		contentPane.add(btnWare1);
		
		JButton btnWare2 = new JButton("2번 창고");
		btnWare2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ware2MD wh2=new Ware2MD(WareHouseList.this);
				wh2.setVisible(true);
				wh2.setLocation(300, 300);
			}
		});
		btnWare2.setBounds(12, 95, 97, 23);
		contentPane.add(btnWare2);
	
		JLabel lblWare1 = new JLabel("경기도 시흥시 OO구 XXXX번지");
		lblWare1.setBounds(121, 46, 197, 15);
		contentPane.add(lblWare1);
				
		JLabel lblWare2 = new JLabel("충남 당진군 AA읍 CLEL번지");
		lblWare2.setBounds(121, 99, 197, 15);
		contentPane.add(lblWare2);
	}
	
	
	

}
