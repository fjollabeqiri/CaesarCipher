package caesar;

import javax.swing.JFileChooser;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CaesarAlgorithm {

	private JFrame frmAlgoritmiICezarit;
	private JButton btnSave;
	private JButton btnOpen;
	private JButton btnEnkripto;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCelesi;
	private JLabel lblTekstiEnkriptuar;
	private JLabel lblInfo;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTextArea txtTeksti;
	private JTextArea txtEnkriptuar;
	private JScrollPane scrollPane_1;
	private JTextArea txtDekriptuar;
	private JScrollPane scrollPane_2;
	private JLabel lblXc;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JButton btnTransfer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaesarAlgorithm window = new CaesarAlgorithm();
					window.frmAlgoritmiICezarit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CaesarAlgorithm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlgoritmiICezarit = new JFrame();
		frmAlgoritmiICezarit.setResizable(false);
		frmAlgoritmiICezarit.setIconImage(Toolkit.getDefaultToolkit().getImage(CaesarAlgorithm.class.getResource("/caesar/images/kk.jpg")));
		frmAlgoritmiICezarit.setTitle("Enkriptimi/Dekriptimi ");
		frmAlgoritmiICezarit.setBounds(100, 100, 754, 576);
		frmAlgoritmiICezarit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlgoritmiICezarit.getContentPane().setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Zgjedh fajllin ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(49, 105, 318, 144);
		frmAlgoritmiICezarit.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnSave.setBounds(12, 106, 70, 25);
		panel_1.add(btnSave);
		
		btnOpen = new JButton("Open");
		btnOpen.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnOpen.setBounds(84, 106, 75, 25);
		panel_1.add(btnOpen);
		
		txtTeksti = new JTextArea();
		txtTeksti.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtTeksti.setWrapStyleWord(true);
		txtTeksti.setLineWrap(true);
		txtTeksti.setBounds(14, 19, 300, 47);
		panel_1.add(txtTeksti);
		
		JScrollPane scrollPane = new JScrollPane(txtTeksti);
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(12, 18, 300, 75);
		panel_1.add(scrollPane);
		
		JLabel label = new JLabel("");
		label.setToolTipText("Fshij");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				txtTeksti.setText("");
			}
		});
		label.setIcon(new ImageIcon(CaesarAlgorithm.class.getResource("/caesar/images/del.png")));
		label.setBounds(287, 106, 25, 25);
		panel_1.add(label);
		
		btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTeksti.getText()!="")
				{
					txtEnkriptuar.setText(txtTeksti.getText());
				}
			}
		});
		btnTransfer.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnTransfer.setBounds(163, 106, 106, 25);
		panel_1.add(btnTransfer);
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs=new JFileChooser(new File("c:\\"));
				fs.setDialogTitle("Open a File");
				fs.setFileFilter(new FileTypeFilter(".txt","Text File"));
				fs.setFileFilter(new FileTypeFilter(".doc","Word File"));
				fs.setFileFilter(new FileTypeFilter(".docx","Word File"));
				fs.setFileFilter(new FileTypeFilter(".jpg","JPEG File"));
				int result=fs.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION){
				  try{
					File fi=fs.getSelectedFile();
					BufferedReader br=new BufferedReader(new FileReader(fi.getPath()));
					String s="";
					String line="";
					while((line=br.readLine())!=null){
						s+=line;
						
					}
					txtTeksti.setText(s);
					if(br!=null){
						br.close();
					}
				  }
				  catch(Exception e2){
					  JOptionPane.showMessageDialog(null,e2.getMessage());
				  }
				}
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs=new JFileChooser(new File("c://"));
				fs.setDialogTitle("Save a File");
				fs.setFileFilter(new FileTypeFilter(".txt","Text File"));
				int result=fs.showSaveDialog(null);
				if(result==JFileChooser.APPROVE_OPTION){
					String content = txtTeksti.getText();
					File fi=fs.getSelectedFile();
					try{
						FileWriter fw=new FileWriter(fi.getPath());
						fw.write(content);
						fw.flush();
						fw.close();
					}
					catch(Exception e2){
						JOptionPane.showMessageDialog(null,e2.getMessage());				
					}
				}
			}
		});
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Enkripto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(49, 252, 318, 243);
		frmAlgoritmiICezarit.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnEnkripto = new JButton("Enkripto");
		btnEnkripto.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnEnkripto.setBounds(12, 28, 106, 31);
		panel_2.add(btnEnkripto);
		
		lblTekstiEnkriptuar = new JLabel("Fajlli i enkriptuar:");
		lblTekstiEnkriptuar.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTekstiEnkriptuar.setBounds(12, 66, 137, 23);
		panel_2.add(lblTekstiEnkriptuar);
		
		JLabel lblEnkriptodekriptoFajllat = new JLabel("ENKRIPTO/DEKRIPTO FAJLLAT SIPAS ALGORITMIT TE CEZARIT");
		lblEnkriptodekriptoFajllat.setForeground(new Color(30, 144, 255));
		lblEnkriptodekriptoFajllat.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblEnkriptodekriptoFajllat.setBounds(37, 26, 673, 28);
		frmAlgoritmiICezarit.getContentPane().add(lblEnkriptodekriptoFajllat);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dekripto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(379, 252, 318, 243);
		frmAlgoritmiICezarit.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		txtEnkriptuar = new JTextArea();
		txtEnkriptuar.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtEnkriptuar.setWrapStyleWord(true);
		txtEnkriptuar.setLineWrap(true);
		txtEnkriptuar.setBounds(12, 102, 298, 128);
		panel_2.add(txtEnkriptuar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Zgjedh celesin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(379, 105, 318, 144);
		frmAlgoritmiICezarit.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblVleraECelesit = new JLabel("Vlera e celesit:");
		lblVleraECelesit.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblVleraECelesit.setBounds(16, 83, 110, 23);
		panel.add(lblVleraECelesit);
		
		txtCelesi = new JTextField();
		txtCelesi.setForeground(Color.RED);
		txtCelesi.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtCelesi.setHorizontalAlignment(SwingConstants.CENTER);
		txtCelesi.setBounds(138, 83, 170, 22);
		panel.add(txtCelesi);
		txtCelesi.setEnabled(false);
		txtCelesi.setColumns(10);
		
		JLabel lblFajlliIDekriptuar = new JLabel("Fajlli i dekriptuar:");
		lblFajlliIDekriptuar.setBounds(12, 66, 138, 23);
		lblFajlliIDekriptuar.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		panel_3.add(lblFajlliIDekriptuar);
		
		scrollPane_2 = new JScrollPane(txtDekriptuar);
		scrollPane_2.setBounds(12, 102, 294, 128);
		panel_3.add(scrollPane_2);
		
		txtDekriptuar = new JTextArea();
		txtDekriptuar.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		scrollPane_2.setViewportView(txtDekriptuar);
		txtDekriptuar.setWrapStyleWord(true);
		txtDekriptuar.setLineWrap(true);
		
		label_1 = new JLabel("");
		label_1.setToolTipText("Fshij");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				txtDekriptuar.setText("");
			}
		});
		label_1.setIcon(new ImageIcon(CaesarAlgorithm.class.getResource("/caesar/images/del.png")));
		label_1.setBounds(287, 70, 19, 16);
		panel_3.add(label_1);
		
		JRadioButton rdbtnCelesRandom = new JRadioButton("Celes random");
		rdbtnCelesRandom.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		rdbtnCelesRandom.setBounds(6, 43, 123, 31);
		panel.add(rdbtnCelesRandom);
		rdbtnCelesRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCelesi.setText(null);
				txtCelesi.setEnabled(false);
				Random rand= new Random();
				int n=rand.nextInt(25);		
				txtCelesi.setText(String.valueOf(n));
			}
		});
		buttonGroup.add(rdbtnCelesRandom);
		
		lblInfo = new JLabel("");
		lblInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInfo.setBounds(16, 118, 292, 16);
		panel.add(lblInfo);
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfo.setForeground(Color.RED);
		
		scrollPane_1 = new JScrollPane(txtEnkriptuar);
		scrollPane_1.setBounds(12, 102, 294, 128);
		panel_2.add(scrollPane_1);
		
		lblXc = new JLabel("");
		lblXc.setToolTipText("Fshij");
		lblXc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				txtEnkriptuar.setText("");
			}
		});
		lblXc.setIcon(new ImageIcon(CaesarAlgorithm.class.getResource("/caesar/images/del.png")));
		lblXc.setBounds(287, 70, 19, 16);
		panel_2.add(lblXc);
		
		label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (txtCelesi.getText()!=""){
				Ruaj w =new Ruaj(txtEnkriptuar.getText(),txtCelesi.getText());
				w.setVisible(true);}
				else{
					lblInfo.setText("NO");;
				}
				
	   	  }
		});
		label_2.setToolTipText("Ruaj");
		label_2.setIcon(new ImageIcon(CaesarAlgorithm.class.getResource("/caesar/images/rsz_3rsz_save_as.png")));
		label_2.setBounds(267, 70, 19, 16);
		panel_2.add(label_2);
		

		JRadioButton rdbtnCelesI = new JRadioButton("Celes i perzgjedhur");
		rdbtnCelesI.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		rdbtnCelesI.setBounds(137, 43, 171, 31);
		panel.add(rdbtnCelesI);
		
		
		btnEnkripto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String plainTeksti;
				int celesi;    
				plainTeksti = txtTeksti.getText();
				plainTeksti = plainTeksti.replaceAll("[^a-z A-ZëËÇç+-=()/.,*&^%$#@!~]+","");
	            
	            try{    
	            	    lblInfo.setText("");
		        	    celesi=Integer.parseInt(txtCelesi.getText()); 
		        	    txtEnkriptuar.setText("");
		        
		        	    if(celesi<= 28)
		        	     { 
		                 char[] karakteret = plainTeksti.toCharArray();  
		         
		                 for(int i = 0; i < plainTeksti.length(); i++)
		                   { 
		                	 char c = karakteret[i];  
		                	 char cipherTeksti = enkripto(c, celesi);  
		                	 String output = Character.toString(cipherTeksti);  
		                	 txtEnkriptuar.append(output);                        
		                   }      
		                  }
		        	    else
		        	      {
			                lblInfo.setText("Jepni nje vlere me te vogel se 28!");
			                txtCelesi.setText(null);
			                txtCelesi.requestFocusInWindow();
			                //txtEnkriptuar.append(null);
		        	      }
		        	 }
	    
	            catch (Exception h)
	                {	
	        	   		lblInfo.setText("Cakto celesin!");
		                txtCelesi.requestFocusInWindow();
		            }
			}   
     
			public char enkripto(char c, int celesi)
			{ 
				String alfabetiShqip = "abcçdeëfghijklmnopqrstuvwxyzABCÇDEËFGHIJKLMNOPQRSTUVWXYZ+-=()/.,*&^%$#@!~";
				int i = 0;
				while (i < 73)
				{  
					if(i<28){
						char[] alfabeti1=alfabetiShqip.substring(0, 28).toCharArray();
						if (c == alfabeti1[i]) 
							return alfabeti1[(i + celesi)%28];
						}
					else if (i>=28 && i<56){
						char[] alfabeti2=alfabetiShqip.substring(28, 56).toCharArray();
						if (c == alfabeti2[i-28]) 
							return alfabeti2[(i-28 + celesi)%28];
						}
					else
					{
            		  char[] alfabeti3=alfabetiShqip.substring(56).toCharArray();
                      if (c == alfabeti3[i-56]) 
                          return alfabeti3[(i-56 + celesi)%17];
					}
					i++;    
				}
                return c;
            }
			});
		
		
	rdbtnCelesI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCelesi.setText(null);
				if(rdbtnCelesI.isSelected()){
					txtCelesi.setEnabled(true);
					txtCelesi.requestFocusInWindow();
					txtCelesi.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent e) {
								  char vchar=e.getKeyChar();
								  if(!((Character.isDigit(vchar)) || vchar==e.VK_BACK_SPACE) )
								  {
							       Toolkit.getDefaultToolkit().beep();     
								   e.consume();
								  }
						}
					});	
				}
			}
		});
		buttonGroup.add(rdbtnCelesI);
		
		JButton btnDekripto = new JButton("Dekripto");
		btnDekripto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cipherTeksti;
	            int celesi; 
	            cipherTeksti = txtEnkriptuar.getText();
	            cipherTeksti = cipherTeksti.replaceAll("[^a-zA-Z ëËÇç+-=()/.,*&^%$#@!~]+","");
	                     
	            try{
	            	celesi = Integer.parseInt(txtCelesi.getText());
	            	lblInfo.setText("");
	            	txtDekriptuar.setText("");
	            	if(celesi<= 28) 
	            	 {  
	            		char[] karakteret = cipherTeksti.toCharArray();
	            		for(int i = 0; i < cipherTeksti.length(); i++)
	            		 {     
	            			char c = karakteret[i];   
	            			char plainTeksti = dekripto(c, celesi);   
	            			String output = Character.toString(plainTeksti);
	            			txtDekriptuar.append(output);
	            	   	 }
	            	 }
	            	else
	            	 {
	            		lblInfo.setText("Jepni nje vlere me te vogel se 28!");
	   	                txtCelesi.setText(null);
	   	                txtCelesi.requestFocusInWindow();
	   	                txtDekriptuar.append(null);
	   	             }
	            	}
	            
	            catch (Exception j)
	                {
	            	lblInfo.setText("Cakto celesin!");
	            	txtCelesi.requestFocusInWindow();
	                }       
			}
	    
			public char dekripto(char c, int celesi)
			{
				String alfabetiShqip = "abcçdeëfghijklmnopqrstuvwxyzABCÇDEËFGHIJKLMNOPQRSTUVWXYZ+-=()/.,*&^%$#@!~";
				int i = 0;
				
				while (i < 73)
				{  
					if(i<28)
					 {
						char[] alfabeti1=alfabetiShqip.substring(0, 28).toCharArray();
						if (c == alfabeti1[i]) 
							return alfabeti1[(i - celesi + 28)%28];
					 }
					else if (i>=28 && i<56)
					 {
						char[] alfabeti2=alfabetiShqip.substring(28, 56).toCharArray();
						if (c == alfabeti2[i-28]) 
							return alfabeti2[(i - celesi)%28];
					 }
					else
					 {
						char[] alfabeti3=alfabetiShqip.substring(56).toCharArray();
						if (c == alfabeti3[i-56]) 
							return alfabeti3[(i-56 - celesi + 34)%17];
					 }
					i++;
				}
				return c;
			} 
			
			
		});
		
		btnDekripto.setBounds(12, 28, 108, 31);
		btnDekripto.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		panel_3.add(btnDekripto);
		
		label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fs=new JFileChooser(new File("c://"));
				fs.setDialogTitle("Save a File");
				fs.setFileFilter(new FileTypeFilter(".txt","Text File"));
				int result=fs.showSaveDialog(null);
				if(result==JFileChooser.APPROVE_OPTION){
					String content = txtDekriptuar.getText();
					File fi=fs.getSelectedFile();
					try{
						FileWriter fw=new FileWriter(fi.getPath());
						fw.write(content);
						fw.flush();
						fw.close();
					}
					catch(Exception e2){
						JOptionPane.showMessageDialog(null,e2.getMessage());				
					}
				}
			}
			
		});
		label_3.setToolTipText("Ruaj");
		label_3.setIcon(new ImageIcon(CaesarAlgorithm.class.getResource("/caesar/images/rsz_3rsz_save_as.png")));
		label_3.setBounds(267, 70, 19, 16);
		panel_3.add(label_3);
	}
}
