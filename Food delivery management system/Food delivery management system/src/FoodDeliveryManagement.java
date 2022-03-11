import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FoodDeliveryManagement extends JFrame {

	private JPanel contentPane;
	private JCheckBox chkExtraCheese;
	private JCheckBox chkLettuce;
	private JCheckBox chkOnion;
	private JCheckBox chkFries;
	private JRadioButton rdbDineIn;
	private JRadioButton rdbTakeAway;
	private JRadioButton rdbDelivery;
	private JCheckBox chkBacon;
	private JComboBox cboFlavour;
	private JRadioButton rdoSmall;
	private JRadioButton rdoMedium;
	private JRadioButton rdoLarge;
	private JButton btnBillOut;
	private JButton btnOrderAgain;
	private String[] flavour = {"Bigmac","Doule quater pounder with cheese","Macdouble","Cheese burger","Hamburger"};
	private JLabel lblsmallprice;
	private JLabel lblmediumprice;
	private JLabel lbllargeprice;
	private double addOnPrice = 0.00;
	private JCheckBox chkExtraMeat;
	private JLabel txaorderdetails;
	private JTextArea txaOrderDetails;
	private JLabel lblquantity;
	private int qty;
	String service = "";
	double burgerPrice = 0;
	double subTotalVal = 0;
	double serviceFeeVal = 0;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	double totalPrice = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodDeliveryManagement frame = new FoodDeliveryManagement();
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
	public FoodDeliveryManagement() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				loadFlavours();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 551);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Burger Flavour:");
		lblNewLabel.setBounds(10, 11, 151, 14);
		contentPane.add(lblNewLabel);
		
		cboFlavour = new JComboBox();
		cboFlavour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPrice();
			}
		});
		cboFlavour.setBounds(10, 36, 220, 20);
		contentPane.add(cboFlavour);
		
		JLabel sad = new JLabel("Size and Price:");
		sad.setBounds(10, 67, 151, 14);
		contentPane.add(sad);
		
		rdoSmall = new JRadioButton(" Kids Meal");
		buttonGroup.add(rdoSmall);
		rdoSmall.setBounds(20, 91, 109, 23);
		contentPane.add(rdoSmall);
		
		rdoLarge = new JRadioButton("Large Meal");
		buttonGroup.add(rdoLarge);
		rdoLarge.setBounds(20, 143, 109, 23);
		contentPane.add(rdoLarge);
		
		rdoMedium = new JRadioButton("Medium Meal");
		buttonGroup.add(rdoMedium);
		rdoMedium.setBounds(20, 117, 109, 23);
		contentPane.add(rdoMedium);
		
		JLabel lblNewLabel_2 = new JLabel("Add Ons:");
		lblNewLabel_2.setBounds(10, 173, 151, 14);
		contentPane.add(lblNewLabel_2);
		
		chkExtraCheese = new JCheckBox("Extra Cheese");
		chkExtraCheese.setBounds(10, 194, 119, 23);
		contentPane.add(chkExtraCheese);
		
		chkLettuce = new JCheckBox("Extra Lettuce");
		chkLettuce.setBounds(10, 248, 119, 23);
		contentPane.add(chkLettuce);
		
		chkOnion = new JCheckBox("Extra Onion");
		chkOnion.setBounds(147, 194, 97, 23);
		contentPane.add(chkOnion);
		
		chkFries = new JCheckBox("Extra Fries");
		chkFries.setBounds(147, 222, 97, 23);
		contentPane.add(chkFries);
		
		chkBacon = new JCheckBox("Extra Bacon");
		chkBacon.setBounds(147, 248, 97, 23);
		contentPane.add(chkBacon);
		
		JLabel lblChoose = new JLabel("Choose:");
		lblChoose.setBounds(10, 278, 107, 14);
		contentPane.add(lblChoose);
		
		rdbDineIn = new JRadioButton("Dine In");
		buttonGroup_1.add(rdbDineIn);
		rdbDineIn.setBounds(20, 296, 109, 23);
		contentPane.add(rdbDineIn);
		
		rdbTakeAway = new JRadioButton("Take Away");
		buttonGroup_1.add(rdbTakeAway);
		rdbTakeAway.setBounds(20, 322, 109, 23);
		contentPane.add(rdbTakeAway);
		
		rdbDelivery = new JRadioButton("Delivery");
		buttonGroup_1.add(rdbDelivery);
		rdbDelivery.setBounds(20, 346, 109, 23);
		contentPane.add(rdbDelivery);
		
		JLabel sss = new JLabel("Quantity:");
		sss.setBounds(10, 376, 107, 14);
		contentPane.add(sss);
		
		JButton btnNewButton = new JButton("-");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				qty--;
				lblquantity.setText(String.valueOf(qty));
			}
		});
		btnNewButton.setBounds(10, 401, 48, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qty++;
				lblquantity.setText(String.valueOf(qty));
			}
		});
		btnNewButton_1.setBounds(112, 401, 49, 23);
		contentPane.add(btnNewButton_1);
		
		btnBillOut = new JButton("Bill Out");
		btnBillOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showOrderDetails();
				
				try {
					TimeUnit.SECONDS.sleep(2);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int result = JOptionPane.showConfirmDialog(null,"Order success.. Want to continue?", "Swing Tester",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			            
				if(result == JOptionPane.YES_OPTION)
				{
					DeliveryDetails fdm = new DeliveryDetails();
					fdm.setVisible(true);
	            }
			}
		});
		btnBillOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOrderDetails();
				
			}
		});
		btnBillOut.setBounds(30, 444, 110, 23);
		contentPane.add(btnBillOut);
		
		btnOrderAgain = new JButton("Order Again");
		btnOrderAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderAgain(); 
			}
		});
		btnOrderAgain.setBounds(30, 478, 110, 23);
		contentPane.add(btnOrderAgain);
		
		lblsmallprice = new JLabel("");
		lblsmallprice.setHorizontalAlignment(SwingConstants.CENTER);
		lblsmallprice.setBounds(135, 95, 76, 14);
		contentPane.add(lblsmallprice);
		
		lblmediumprice = new JLabel("");
		lblmediumprice.setHorizontalAlignment(SwingConstants.CENTER);
		lblmediumprice.setBounds(135, 122, 76, 14);
		contentPane.add(lblmediumprice);
		
		lbllargeprice = new JLabel("");
		lbllargeprice.setHorizontalAlignment(SwingConstants.CENTER);
		lbllargeprice.setBounds(135, 147, 76, 14);
		contentPane.add(lbllargeprice);
		
		chkExtraMeat = new JCheckBox("Extra Meat");
		chkExtraMeat.setBounds(10, 222, 119, 23);
		contentPane.add(chkExtraMeat);
		
		txaorderdetails = new JLabel("Order Details:");
		txaorderdetails.setBounds(245, 11, 170, 14);
		contentPane.add(txaorderdetails);
		
		txaOrderDetails = new JTextArea();
		txaOrderDetails.setBounds(240, 34, 322, 467);
		contentPane.add(txaOrderDetails);
		
		lblquantity = new JLabel("1");
		lblquantity.setForeground(new Color(0, 0, 0));
		lblquantity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblquantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblquantity.setBounds(56, 401, 54, 23);
		contentPane.add(lblquantity);
	}
	private void loadFlavours() {
		for(String flavours : flavour) {
			cboFlavour.addItem(flavours);
		}
	}
	private void showPrice() {
		if (cboFlavour.getSelectedIndex() == 0) {
			lblsmallprice.setText("550.00");
			lblmediumprice.setText("790.00");
			lbllargeprice.setText("980.00");
		}		
		else if (cboFlavour.getSelectedIndex() == 1){
			lblsmallprice.setText("700.00");
			lblmediumprice.setText("950.00");
			lbllargeprice.setText("1280.00");
		}
		else if (cboFlavour.getSelectedIndex() == 2){
			lblsmallprice.setText("750.00");
			lblmediumprice.setText("890.00");
			lbllargeprice.setText("1100.00");
		}
		else if (cboFlavour.getSelectedIndex() == 3){
			lblsmallprice.setText("700.00");
			lblmediumprice.setText("890.00");
			lbllargeprice.setText("1000.00");
		}
		else{
			lblsmallprice.setText("600.00");
			lblmediumprice.setText("720.00");
			lbllargeprice.setText("900.00");
		}
	}
	private String addOn() {
		String addOns = "";
		if(chkExtraCheese.isSelected()) {
			addOnPrice += 150.00;
			addOns = addOns + "\n\t" + chkExtraCheese.getText() + "\t\t" + "150.00";
		}
		 if(chkExtraMeat.isSelected()) {
			 addOnPrice += 450.00;
			 addOns = addOns + "\n\t" + chkExtraMeat.getText() + "\t\t" + "450.00";
		 }
		 if(chkLettuce.isSelected()) {
			 addOnPrice += 100.00;
			 addOns = addOns + "\n\t" + chkLettuce.getText() + "\t\t" + "100.00";
		 }
		 if(chkOnion.isSelected()) {
			 addOnPrice += 100.00;
			 addOns = addOns + "\n\t" + chkOnion.getText() + "\t\t" + "100.00"; 
		 }
		if(chkFries.isSelected()) {
			addOnPrice += 250.00;
			 addOns = addOns + "\n\t" + chkFries.getText() + "\t\t" + "250.00";
		}
		if(chkBacon.isSelected()) {
			addOnPrice += 300.00;
			 addOns = addOns + "\n\t" + chkBacon.getText() + "\t\t" + "300.00";
		}
		
		return addOns;
	}
	 private String sizeOfBurger() {
		String size = "";
		if(rdoSmall.isSelected())
			size = rdoSmall.getText();
		else if(rdoMedium.isSelected())
			size = rdoMedium.getText();
		else
			size = rdoLarge.getText();
		
		return size;
	}
	 private double priceOfBurger() {
		 burgerPrice = 0;
		 if(rdoSmall.isSelected())
			 burgerPrice = Double.parseDouble(lblsmallprice.getText());
		 else if(rdoMedium.isSelected())
			 burgerPrice = Double.parseDouble(lblmediumprice.getText());
		 else
			 burgerPrice = Double.parseDouble(lbllargeprice.getText());
		 
		 
		 return burgerPrice;
	 }
	 private String serviceMethod() {
		 service = "";
		 
		 if(rdbDineIn.isSelected())
			 service = "Dine In";
		 else if(rdbTakeAway.isSelected())
			 service = "Take Away";
		 else
			 service = "Delivery" + "\t\t" + "300.00";
		 
		return service;
	 }
		private double serviceFee(){
			serviceFeeVal = 0;
			
			 if(rdbDineIn.isSelected())
				 serviceFeeVal = 0.00;
			 else if(rdbTakeAway.isSelected())
				 serviceFeeVal = 0.00;
			 else
				serviceFeeVal = 300.00; 
			 
			return serviceFeeVal;
		}
		private double subTotal() {
			subTotalVal = 0;
			
			subTotalVal = addOnPrice + priceOfBurger(); 
			
			return subTotalVal;
		}
		private void orderAgain() {
			
			txaOrderDetails.setText(null);
			rdoSmall.setSelected(false);
			
			chkExtraCheese.setSelected(false);
			
			lblquantity.setText("1");
			
			
			serviceFeeVal = 0;
			totalPrice = 0;
			addOnPrice = 0;
			subTotalVal = 0;
			burgerPrice = 0;
		}
		 
	private void showOrderDetails() {
		totalPrice = 0;
		int quantity = Integer.parseInt(lblquantity.getText());

		totalPrice = (subTotal() * quantity)  + serviceFee();

		txaOrderDetails.setText("\nFlavour: \t" + cboFlavour.getSelectedItem() + "\n\nSIZE: \t" + sizeOfBurger() + 
							"\n\nPRICE: \t\t\t" + priceOfBurger() + "\n\nADD ONS: \t" + addOn() + "\n\nSERVICE:  \t" + serviceMethod()
							+ "\n\nQUANTITY: \t\t\t" + "x" + quantity + "\n\n**********************************************"
							+ "\n\nTOTAL PRICE: \t\t\t" + totalPrice);	
		
	} 
	
}
