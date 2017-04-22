package uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import busines.Buteco;
import persistence.Log;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tela_Pesquisa extends JFrame {

	private JPanel contentPane;
	private JTextField txtCPF_Pesquisa;
	private Buteco bar;
	private Log    log;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Pesquisa frame = new Tela_Pesquisa();
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
	public Tela_Pesquisa() {
		setTitle("Consulta por CPF");
		setBounds(100, 100, 450, 124);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblcpf = new JLabel("Digite o CPF:");
		lblcpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtCPF_Pesquisa = new JTextField();
		txtCPF_Pesquisa.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cpf;
				cpf = txtCPF_Pesquisa.getText();
				if(bar.BuscaCliente(cpf) != ""){
					JOptionPane.showMessageDialog(txtCPF_Pesquisa, "O cliente abaixo esta no bar:" + "\n"
												  + bar.BuscaCliente(cpf), "A GERÊNCIA DIZ:", 0);
					log.Escreve(bar.BuscaCliente(cpf),false);
					dispose();
				}else{
					JOptionPane.showMessageDialog(txtCPF_Pesquisa, "Cliente não esta no bar!", "Mensagem de Erro", 0);
					txtCPF_Pesquisa.setText("");
				}
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblcpf)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtCPF_Pesquisa, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblcpf)
						.addComponent(txtCPF_Pesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(202, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
