package ProjectHouse;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ware1MD extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfNum;
	private JTextField tfName;
	private JTextField tfCom;
	private JTextField tfAmount;
	private JTextField tfPrice;
	private JTextField tfVolume;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	
	private WareHouse1DTO dto;
	private WareHouse1DAO dao;
	private Vector<String> col;
	private DefaultTableModel model;
	
	private WareHouseList whl;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Ware1MD frame = new Ware1MD();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public Ware1MD(WareHouseList whl) {
		this();
		this.whl=whl;
	}
	
	
	/**
	 * Create the frame.
	 */
	public Ware1MD() {
		setTitle("1번 창고 현황");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 142, 410, 223);
		contentPane.add(scrollPane);
		
		dao= new WareHouse1DAO();
		col= new Vector<String>();
		col.add("제품번호");
	    col.add("제품명");
	    col.add("제조사");
	    col.add("재고량");
	    col.add("가격");
	    col.add("차지량(%)");
	    
	   list();
	    
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx=table.getSelectedRow();
				tfNum.setEditable(false);
				tfNum.setText(table.getValueAt(idx, 0)+"");
				tfName.setText(table.getValueAt(idx, 1)+"");
				tfCom.setText(table.getValueAt(idx, 2)+"");
				tfAmount.setText(table.getValueAt(idx, 3)+"");
				tfPrice.setText(table.getValueAt(idx, 4)+"");
				tfVolume.setText(table.getValueAt(idx, 5)+"");
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("제품번호");
		lblNewLabel.setBounds(12, 10, 57, 15);
		contentPane.add(lblNewLabel);
		
		tfNum = new JTextField();
		tfNum.setBounds(81, 7, 116, 21);
		contentPane.add(tfNum);
		tfNum.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("제품명");
		lblNewLabel_1.setBounds(12, 35, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		tfName = new JTextField();
		tfName.setBounds(81, 32, 116, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("제조사");
		lblNewLabel_2.setBounds(12, 60, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		tfCom = new JTextField();
		tfCom.setBounds(81, 57, 116, 21);
		contentPane.add(tfCom);
		tfCom.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("재고량");
		lblNewLabel_3.setBounds(231, 10, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		tfAmount = new JTextField();
		tfAmount.setBounds(300, 7, 116, 21);
		contentPane.add(tfAmount);
		tfAmount.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("가격");
		lblNewLabel_4.setBounds(231, 35, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(300, 32, 116, 21);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("차지량(%)");
		lblNewLabel_5.setBounds(231, 60, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		tfVolume = new JTextField();
		tfVolume.setBounds(300, 57, 116, 21);
		contentPane.add(tfVolume);
		tfVolume.setColumns(10);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result=dao.insertWare(dto);
				if(result==1) {
					JOptionPane.showMessageDialog(
							Ware1MD.this, "상품이 추가되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnAdd.setBounds(35, 109, 97, 23);
		contentPane.add(btnAdd);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result=dao.UpdateWare(dto);
				if(result==1) {
					JOptionPane.showMessageDialog(
							Ware1MD.this, "상품정보가 수정되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnUpdate.setBounds(167, 109, 97, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=tfNum.getText();
				int result=0;
				int response=JOptionPane.showConfirmDialog(Ware1MD.this, "상품자료를 삭제하시겠습니까?");
				if(response==JOptionPane.YES_OPTION) {
					result=dao.deleteWare(num);
				}
				if(result==1) {
					JOptionPane.showMessageDialog(Ware1MD.this, "상품자료를 삭제하겠습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnDelete.setBounds(303, 109, 97, 23);
		contentPane.add(btnDelete);
	}
	
	public void list() {
		model=new DefaultTableModel(dao.listWare(),col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}
	
	public void clear() {
		tfNum.setText("");
		tfName.setText("");
		tfCom.setText("");
		tfAmount.setText("");
		tfPrice.setText("");
		tfVolume.setText("");
		tfNum.requestFocus();
		tfNum.setEditable(true);
	}
	
	public void input() {
		String num=tfNum.getText();
		String name=tfName.getText();
		String company=tfCom.getText();
		int amount=Integer.parseInt(tfAmount.getText());
		int price=Integer.parseInt(tfPrice.getText());
		int volume=Integer.parseInt(tfVolume.getText());
		dto=new WareHouse1DTO(num, name, company, amount, price, volume);
	}
	
}
