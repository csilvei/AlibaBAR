package uinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import busines.Buteco;
import persistence.Log;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class Tela_Principal {

	private JFrame Main;
	private JTextField hidtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Principal window = new Tela_Principal();
					window.Main.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela_Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Main = new JFrame();
		Main.getContentPane().setBackground(Color.LIGHT_GRAY);
		Main.setTitle("AlibaBAR");
		Main.setBounds(100, 100, 450, 300);
		Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Buteco  bar = new Buteco();
		Log log     = new Log();
		JButton btnCheckin = new JButton("Check-in");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCheckin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Tela_Cadastro TC = new Tela_Cadastro();
				TC.params(bar, log);
				TC.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNome = new JLabel("AlibaBAR");
		lblNome.setFont(new Font("Vivaldi", Font.BOLD, 17));
		
		JButton btnCheckout = new JButton("Check-out");
		btnCheckout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Tela_Checkout CO = new Tela_Checkout();
				CO.params(bar, log);
				CO.setVisible(true);
				dispose();
			}
		});
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnListaDeClientes = new JButton("Lista de Clientes");
		btnListaDeClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Clientes;
				Clientes = bar.MostraClientes();
				
				if(bar.MostraClientes() != ""){
					JOptionPane.showMessageDialog(hidtxt, "Lista de Clientes no AlibaBAR" + "\n"
												  + Clientes , "A GERÊNCIA DIZ:", 0);
				}else{
					JOptionPane.showMessageDialog(hidtxt, "Não há Clientes no BAR!", "Mensagem de Erro", 0);
				}
			}
		});
		btnListaDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnPesquisaPorCpf = new JButton("Pesquisa por CPF");
		btnPesquisaPorCpf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tela_Pesquisa TP = new Tela_Pesquisa();
				TP.params(bar, log);
				TP.setVisible(true);
				dispose();
			}
		});
		
		JButton btnVisoGeral = new JButton("Vis\u00E3o Geral");
		btnVisoGeral.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Clientes;
				Clientes = bar.BuscaQuantidade();
				
				if(bar.BuscaQuantidade() != ""){
					JOptionPane.showMessageDialog(hidtxt, "Visão Geral do AlibaBAR" + "\n"
												  + Clientes , "A GERÊNCIA DIZ:", 0);
				}else{
					JOptionPane.showMessageDialog(hidtxt, "Não há Clientes no BAR!", "Mensagem de Erro", 0);
				}
			}
		});
		
		JButton btnEncerrarANoite = new JButton("Encerrar a Noite");
		btnEncerrarANoite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		hidtxt = new JTextField();
		hidtxt.setBackground(Color.LIGHT_GRAY);
		hidtxt.setEnabled(false);
		hidtxt.setEditable(false);
		hidtxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(Main.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(155)
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(26)
									.addComponent(btnListaDeClientes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(71)
									.addComponent(btnCheckin)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnEncerrarANoite, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnPesquisaPorCpf, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnVisoGeral, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCheckout)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(177)
							.addComponent(hidtxt, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(hidtxt, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCheckin)
						.addComponent(btnCheckout))
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnListaDeClientes)
						.addComponent(btnPesquisaPorCpf)
						.addComponent(btnVisoGeral))
					.addGap(56)
					.addComponent(btnEncerrarANoite)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		Main.getContentPane().setLayout(groupLayout);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
}
