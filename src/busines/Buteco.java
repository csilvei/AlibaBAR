package busines;

import persistence.Cliente;
import java.util.ArrayList;
import java.util.Iterator;

public class Buteco {
	ArrayList<Cliente> Cliente = new ArrayList<Cliente>();
	//
	public Buteco(){
	
	}
	
	public Boolean InsereCliente(Cliente cli){
		if(Cliente.add(cli)){
			return true;
		}
		return false;
	}
	
	public Boolean RemoveCliente(String cpf){
		
		Iterator<Cliente> it = Cliente.iterator();
		while (it.hasNext()) {
		   Cliente clie = (persistence.Cliente) it.next();
		   if (clie.getCpf().startsWith(cpf)){
			   it.remove(); //Única forma de remover enquanto percorre
			   return true;  
		   }
	    }
		return false;
	}
	
	public String MostraClientes(){
		String cliente = "";
		
		for(Cliente c : Cliente) {
			  cliente = cliente + "\n" +
					    "Nome:" + c.getNome() + "\n" +
					  	"Cpf:" + c.getCpf()  + "\n" +
					  	"Gênero:" + c.getGenero() + "\n" +
					  	"Idade:" + c.getIdade() + "\n"; 
			  
		}
		return cliente;
	}
	
	public String BuscaCliente(String cpf){
		String cliente = "";
		
		Iterator<Cliente> it = Cliente.iterator();
		while (it.hasNext()) {
		   Cliente clie = (persistence.Cliente) it.next();
		   if (clie.getCpf().startsWith(cpf)){
			   cliente ="Nome:" + clie.getNome() + "\n" +
			  			 "Cpf:" + clie.getCpf()  + "\n" +
			  			 "Gênero:" + clie.getGenero() + "\n" +
			  			 "Idade:" + clie.getIdade() + "\n" + 
			   			 "Numero Sócio: " + clie.getSocio();
			return cliente;   
		   }
	    }
		return cliente;
	}
	
	
	public String BuscaQuantidade(){
		int cont = 0,contm = 0,contf = 0,contS = 0, contN = 0;
		double percentualM = 0;
		double percentualF = 0;
		String Retorno = null;
		
		
		Iterator<persistence.Cliente> it = Cliente.iterator();
		while (it.hasNext()) {
			Cliente clie = (persistence.Cliente) it.next();
				cont ++;
			if (clie.getGenero() == "M"){
				contm ++;
			}
			else {
				contf ++;
			}
			if (clie.getSocio() == "0"){
				contN ++;
			}
			else{
				contS ++;
			}
	    }
		
		percentualM = (100*contm)/cont;
		percentualF = 100 - percentualM;
		
		Retorno =  
		"Qtd. Clientes Homens :" + contm + "\n"      +
		"Qtd. Clientes Mulheres :" + contf + "\n"    + 
		"Percentual Homens :" + percentualM + "\n"   +
		"Percentual Mulheres :" + percentualF + "\n" +
		"Qtd. Sócios :" + contS + "\n"               + 
		"Qtd. Não Sócios :" + contN + "\n";
		
		return Retorno;
	}
	
}