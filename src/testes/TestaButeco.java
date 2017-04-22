package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import busines.Buteco;
import persistence.Cliente;
import persistence.Log;

public class TestaButeco {

	@Before
	public void setUp() throws Exception {
		Buteco  bar = new Buteco();
		Cliente cli = new Cliente("","","","","");
		Log 	log = new Log();
	}

	@Test
	public void testInsereCliente() {
		Buteco  bar = new Buteco();
		Cliente cli = new Cliente("","","","","");
		Log 	log = new Log();
		assertEquals(true, bar.InsereCliente(cli));
		
	}
	@Test
	public void testRemoveCliente() {
		Buteco  bar = new Buteco();
		Cliente cli = new Cliente("carlos","111","F","34","2");
		Log 	log = new Log();
		bar.InsereCliente(cli);
		assertEquals(true, bar.RemoveCliente("111"));
		assertEquals(false, bar.RemoveCliente("111"));
	}
	@Test
	public void testMostraClientes() {
		Buteco  bar = new Buteco();
		Cliente cli = new Cliente("carlos","111","F","34","2");
		Log 	log = new Log();
		bar.InsereCliente(cli);
		String aux = bar.MostraClientes();
		assertEquals(bar.MostraClientes(), aux);
	}
	@Test
	public void testBuscaCliente() {
		Buteco  bar = new Buteco();
		Cliente cli = new Cliente("carlos","111","F","34","2");
		Log 	log = new Log();
		bar.InsereCliente(cli);
		String aux = bar.BuscaCliente("111");
		assertEquals(bar.BuscaCliente("111"), aux);
	}
	@Test
	public void testBuscaQuantidade() {
		Buteco  bar = new Buteco();
		Cliente cli = new Cliente("carlos","111","F","34","2");
		Log 	log = new Log();
		bar.InsereCliente(cli);
		String aux = bar.BuscaQuantidade();
		assertEquals(bar.BuscaQuantidade(), aux);
	}
}
