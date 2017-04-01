package br.com.aexo.testtrader;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class TestTrader {

	private JFrame frmTraderTest;
	private JTextField location;
	private JTextField lot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestTrader window = new TestTrader();
					window.frmTraderTest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestTrader() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTraderTest = new JFrame();
		frmTraderTest.setTitle("Trader Test");
		frmTraderTest.setBounds(100, 100, 343, 189);
		frmTraderTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTraderTest.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblSalvarEm = new JLabel("Salvar Em:");
		frmTraderTest.getContentPane().add(lblSalvarEm, "2, 2, right, default");
		
		location = new JTextField();
		frmTraderTest.getContentPane().add(location, "4, 2, 13, 1");
		location.setColumns(10);
		
		JLabel lblLote = new JLabel("Lote:");
		frmTraderTest.getContentPane().add(lblLote, "2, 6, 1, 3, right, default");
		
		lot = new JTextField();
		frmTraderTest.getContentPane().add(lot, "4, 6, 7, 3, fill, default");
		lot.setColumns(10);
		lot.setText("0.10");
		
		JButton btnNewButton = new JButton("buy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					List<String> lines = Arrays.asList(lot.getText());
					Files.write(Paths.get(location.getText()+"/buy.txt"), lines, StandardCharsets.UTF_8,
					        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
					} catch (Exception ex){
						ex.printStackTrace();
					}
			}
		});
		frmTraderTest.getContentPane().add(btnNewButton, "12, 6");
		
		JButton btnNewButton_1 = new JButton("sell");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					List<String> lines = Arrays.asList(lot.getText());
					Files.write(Paths.get(location.getText()+"/sell.txt"), lines, StandardCharsets.UTF_8,
					        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
					} catch (Exception ex){
						ex.printStackTrace();
					}
			}
		});
		
		JButton Close = new JButton("Close");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				// close
				List<String> lines = Arrays.asList();
				Files.write(Paths.get(location.getText()+"/close.txt"), lines, StandardCharsets.UTF_8,
				        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
				} catch (Exception ex){
					ex.printStackTrace();
				}
				
			}
		});
		Close.setHorizontalAlignment(SwingConstants.RIGHT);
		frmTraderTest.getContentPane().add(Close, "14, 6, 1, 3");
		frmTraderTest.getContentPane().add(btnNewButton_1, "12, 8");
	}
}
