package uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistence.Cliente;
import persistence.Log;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.ChangeListener;

import busines.Buteco;

import javax.swing.event.ChangeEvent;

public class Tela_Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtcpf;
	private JTextField txtidade;
	private JTextField txtnumsocio;
	private Buteco     bar;
	private Log        log;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cadastro frame = new Tela_Cadastro();
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
	public Tela_Cadastro() {
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Cliente Cli = new Cliente("","","","","");
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblGnero = new JLabel("G\u00EAnero:");
		lblGnero.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNumScio = new JLabel("Num. S\u00F3cio:");
		lblNumScio.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblDados = new JLabel("Dados do Cliente:");
		lblDados.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtcpf = new JTextField();
		txtcpf.setColumns(10);
		
		txtidade = new JTextField();
		txtidade.setColumns(10);
		
		txtnumsocio = new JTextField();
		txtnumsocio.setColumns(10);
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		
		rdbtnFeminino.setSelected(true);
		rdbtnMasculino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnFeminino.setSelected(false);	
			}
		});
		
		rdbtnFeminino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnMasculino.setSelected(false);	
			}
		});
		
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String nome = "";
				String idade = "";
				String cpf = "";
				String socio = "";
				boolean sexo = true; //true Masculino false Feminino 
				boolean erro = false;
				
				 nome = "";
				 idade = "";
				 cpf = "";
				 socio = "";
				 sexo = true; //true Masculino false Feminino 
				 erro = false;
				
				nome  = txtNome.getText();
				idade = txtidade.getText();
				cpf   = txtcpf.getText();
				socio = txtnumsocio.getText();
				
				if(Cli.validaNome(nome) == true){
					JOptionPane.showMessageDialog(txtNome, "Por Favor Informe o seu nome!", "Mensagem de Erro", 0);
					txtNome.setText("");
					txtNome.grabFocus();
					erro = true;
				}else if(Cli.validaCPF(cpf) == false){
					JOptionPane.showMessageDialog(txtcpf, "Informe o CPF somente com Números!(max. 11 digitos)", "Mensagem de Erro", 0);
					txtcpf.setText("");
					txtcpf.grabFocus();
					erro = true;
				}else if(Cli.validaIdade(idade) == false){
					JOptionPane.showMessageDialog(txtidade, "Informa uma Idade valida!", "Mensagem de Erro", 0);
					txtidade.setText("");
					txtidade.grabFocus();
					erro = true;
				}
				
				if(rdbtnFeminino.isSelected() == true){
					sexo = false;
				}
				
				if(erro == false){
					
					Cli.setNome(nome);
					Cli.setCpf(cpf);
					Cli.setIdade(idade);
					Cli.setSocio(socio);
					if(sexo == true){
					Cli.setGenero("M");
					}else{
						Cli.setGenero("F");
					}
					if(bar.InsereCliente(Cli) == true){
						JOptionPane.showMessageDialog(txtnumsocio, "Bem Vindo ao AlibaBAR!", "Mensagem de Boas Vindas", 0);
						log.Escreve(bar.BuscaCliente(cpf), true);
						dispose();
					}else{
						JOptionPane.showMessageDialog(txtnumsocio, "Desculpe seu nome não esta na lista!", "Mensagem de Erro", 0);
					}
				}	
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblIdade, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblGnero, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblNumScio))
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnConfirmar)
							.addGap(30)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDados, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtcpf, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtidade, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(rdbtnFeminino)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnMasculino))
						.addComponent(txtnumsocio, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDados)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(txtcpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdade)
						.addComponent(txtidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGnero)
						.addComponent(rdbtnFeminino)
						.addComponent(rdbtnMasculino))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumScio)
						.addComponent(txtnumsocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfirmar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
