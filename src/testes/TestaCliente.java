package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import persistence.Cliente;

public class TestaCliente {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void TestavalidaNome() {
		Cliente dados = new Cliente("","","","","");
		assertEquals(true,dados.validaNome(""));
		assertEquals(false,dados.validaNome("Paulo"));
	}
	
	@Test
	public void TestavalidaCPF() {
		Cliente dados = new Cliente("","","","","");
		assertEquals(false,dados.validaCPF(""));
		assertEquals(false,dados.validaCPF("sdasdada"));
		assertEquals(false,dados.validaCPF("12345678900000"));
	}
	
	@Test
	public void TestavalidaIdade() {
		Cliente dados = new Cliente("","","","","");
		assertEquals(false,dados.validaCPF(""));
		assertEquals(false,dados.validaCPF("asdadada"));
	}
}
