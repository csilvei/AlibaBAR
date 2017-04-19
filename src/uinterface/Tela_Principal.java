package uinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Principal {

	private JFrame Main;

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
		Main.setTitle("AlibaBAR");
		Main.setBounds(100, 100, 450, 300);
		Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnCheckin = new JButton("Check-in");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCheckin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Tela_Cadastro TC = new Tela_Cadastro();
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
				Tela_Lista_Clientes TLC = new Tela_Lista_Clientes();
				TLC.setVisible(true);
				dispose();
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
				TP.setVisible(true);
				dispose();
			}
		});
		
		JButton btnVisoGeral = new JButton("Vis\u00E3o Geral");
		btnVisoGeral.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tela_Censo TCC = new Tela_Censo();
				TCC.setVisible(true);
				dispose();
			}
		});
		
		JButton btnEncerrarANoite = new JButton("Encerrar a Noite");
		btnEncerrarANoite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		GroupLayout groupLayout = new GroupLayout(Main.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(155)
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(26)
									.addComponent(btnListaDeClientes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(71)
									.addComponent(btnCheckin)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnEncerrarANoite, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnPesquisaPorCpf, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnVisoGeral, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCheckout))))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
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
					.addContainerGap(20, Short.MAX_VALUE))
		);
		Main.getContentPane().setLayout(groupLayout);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
}
