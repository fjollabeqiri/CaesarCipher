package caesar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

public class Ruaj extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ruaj frame = new Ruaj(null,null);
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
	public Ruaj(String text,String celesi) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Acer\\Desktop\\rsz_save_as.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 450, 196);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRuajFajllin = new JButton("Ruaj fajllin...");
		btnRuajFajllin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fs=new JFileChooser(new File("c://"));
				fs.setDialogTitle("Save a File");
				fs.setFileFilter(new FileTypeFilter(".txt","Text File"));
				int result=fs.showSaveDialog(null);
				if(result==JFileChooser.APPROVE_OPTION){
					File fi=fs.getSelectedFile();
					try{
						FileWriter fw=new FileWriter(fi.getPath());
						fw.write(text);
						fw.flush();
						fw.close();
					}
					catch(Exception e2){
						JOptionPane.showMessageDialog(null,e2.getMessage());				
					}
				}
			}
		});
		btnRuajFajllin.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnRuajFajllin.setBounds(55, 56, 139, 48);
		contentPane.add(btnRuajFajllin);
		
		JButton btnRuajCelesin = new JButton("Ruaj celesin...");
		btnRuajCelesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fs=new JFileChooser(new File("c://"));
				fs.setDialogTitle("Save a File");
				fs.setFileFilter(new FileTypeFilter(".txt","Text File"));
				int result=fs.showSaveDialog(null);
				if(result==JFileChooser.APPROVE_OPTION){
					File fi=fs.getSelectedFile();
					try{
						FileWriter fw=new FileWriter(fi.getPath());
						fw.write(celesi);
						fw.flush();
						fw.close();
					}
					catch(Exception e2){
						JOptionPane.showMessageDialog(null,e2.getMessage());				
					}
				}
			}
		});
		btnRuajCelesin.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnRuajCelesin.setBounds(250, 56, 139, 48);
		contentPane.add(btnRuajCelesin);
	}
}
