package uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import busines.Buteco;
import persistence.Log;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tela_Checkout extends JFrame {

	private JPanel contentPane;
	private JTextField txtcpf;
	private Buteco bar;
	private Log    log;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Checkout frame = new Tela_Checkout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void params(Buteco Bar,Log log){
		this.bar = Bar;
		this.log = log;
	}
	/**
	 * Create the frame.
	 */
	public Tela_Checkout() {
		setTitle("Checkout");
		setBounds(100, 100, 389, 158);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Informe o cpf para checkout:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtcpf = new JTextField();
		txtcpf.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cpf = "";
				cpf = txtcpf.getText();
				
				if(bar.BuscaCliente(cpf) != ""){
					JOptionPane.showMessageDialog(txtcpf, "O cliente abaixo esta indo embora:" + "\n"
												  + bar.BuscaCliente(cpf) + "\n +"
												  		+ "tem Tenha uma boa Noite!", "A GERÊNCIA DIZ:", 0);
					log.Escreve(bar.BuscaCliente(cpf),false);
					bar.RemoveCliente(cpf);
					dispose();
				}else{
					JOptionPane.showMessageDialog(txtcpf, "Por Favor Aguarda, para falar com o gerente!", "Mensagem de Erro", 0);
				}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(87)
					.addComponent(btnConfirmar)
					.addGap(34)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(110, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(53, Short.MAX_VALUE)
					.addComponent(txtcpf, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
					.addGap(44))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(94)
					.addComponent(lblNewLabel)
					.addContainerGap(106, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(11)
					.addComponent(txtcpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfirmar)
						.addComponent(btnSair))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
