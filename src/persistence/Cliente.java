package persistence;

public class Cliente {
	private String nome;
	private String cpf;
	private String idade;
	private String genero;
	private String socio;

	public Cliente(String nome, String cpf, String genero, String idade, String socio) {
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.idade = idade;
		this.socio = socio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSocio() {
		return socio;
	}

	public void setSocio(String socio) {
		this.socio = socio;
	}
	
	public Boolean validaNome(String nome){
		boolean Retorno = false;
		Retorno = nome.isEmpty();
		return Retorno;
	}
	
	public Boolean validaCPF(String cpf){
		boolean Retorno = true;
		int auxcpf = 0;
		
		if (cpf.isEmpty() == true){
			Retorno = false;
			return Retorno;
		}
		
		try{
			auxcpf = Integer.parseInt(cpf);
		}
		catch(Exception ex){
		  Retorno = false;
		  return Retorno;
		}
		
		if (cpf.length() > 11){
			Retorno = false;
			return Retorno;
		}
		
		return Retorno;
	}
	
	public Boolean validaIdade(String idade){
		boolean Retorno = true;
		int auxint = 0;
		
		if (idade.isEmpty() == true){
			Retorno = false;
			return Retorno;
		}
		
		try{
			auxint = Integer.parseInt(idade);
		}
		catch(Exception ex){
		  Retorno = false;
		  return Retorno;
		}
		
		if (auxint < 0 || auxint > 99){
			Retorno = false;
			return Retorno;
		}
		
		return Retorno;
		
	}
	
}
