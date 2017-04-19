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
	
	public boolean MostraClientes(){
		boolean achou = false;
		int cont = 0;
		for(Cliente c : Cliente) {
			  System.out.println("Nome:" + c.getNome() + "\n" +
					  			 "Cpf:" + c.getCpf()  + "\n" +
					  			 "Gênero:" + c.getGenero() + "\n" +
					  			 "Idade:" + c.getIdade() + "\n"); 
			  cont++;
		}
		if (cont > 0){
			return true;
		}
		else return false;
	}
	
	public Boolean BuscaCliente(String cpf){
		boolean achou = false;
		
		Iterator<Cliente> it = Cliente.iterator();
		while (it.hasNext()) {
		   Cliente clie = (persistence.Cliente) it.next();
		   if (clie.getCpf().startsWith(cpf)){
			   System.out.println("Nome:" + clie.getNome() + "\n" +
			  			 "Cpf:" + clie.getCpf()  + "\n" +
			  			 "Gênero:" + clie.getGenero() + "\n" +
			  			 "Idade:" + clie.getIdade() + "\n");  
			return true;   
		   }
	    }
		return false;
	}
	
	public boolean BuscaQuantidade(){
		int cont = 0,contm = 0,contf = 0,contS = 0, contN = 0;
		double percentualM = 0;
		double percentualF = 0;
		
		
		Iterator<persistence.Cliente> it = Cliente.iterator();
		while (it.hasNext()) {
			Cliente clie = (persistence.Cliente) it.next();
				cont ++;
			if (clie.getGenero() == "Masculino"){
				contm ++;
			}
			else {
				contf ++;
			}
			if (clie.getSocio() == 0){
				contN ++;
			}
			else{
				contS ++;
			}
	    }
		
		percentualM = (100*contm)/cont;
		percentualF = 100 - percentualM;
		
		System.out.println("Qtd. Clientes Homens :" + contm + "\n" );
		System.out.println("Qtd. Clientes Mulheres :" + contf + "\n" );
		System.out.println("Percentual Homens :" + percentualM + "\n" );
		System.out.println("Percentual Mulheres :" + percentualF + "\n" );
		System.out.println("Qtd. Sócios :" + contS + "\n" );
		System.out.println("Qtd. Não Sócios :" + contN + "\n" );
		if (cont > 0) {
			return true;
		}
		else{
			return false;
		}
	}
	
}