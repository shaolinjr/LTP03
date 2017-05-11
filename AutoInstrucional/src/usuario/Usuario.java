package usuario;

import utilitarios.Console;
import utilitarios.LtpUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;

import cadastro.ListaClientes;
import cadastro.ListaProdutos;
import cadastro.ListaVendas;

import dados.Cliente;
import dados.ItemVenda;
import dados.Produto;
import dados.Venda;
import erros.SisVendasException;

public class Usuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (new File("Clientes.obj").exists()) {
			lerClientes();
		}
		if (new File("Produtos.obj").exists()) {
			lerProdutos();		
		}
		
		if (new File("Vendas.obj").exists()) {
			lerVendas();	
		}
		
		menu();
		
		gravarClientes();
		gravarProdutos();
		gravarVendas();
	}
	
	/**
	 * Método para apresentar um menu para facilitar o uso pelo usuário
	 */
	private static void menu (){
		int opcao = 0;
		
		do {
			System.out.println("********* MENU *********");
			System.out.println("----- Cliente -----");
			System.out.println("1. Incluir novo cliente");
			System.out.println("2. Alterar cliente pelo CPF");
			System.out.println("3. Excluir cliente pelo CPF");
			System.out.println("4. Consultar cliente pelo CPF");
			System.out.println("5. Consultar cliente pelo nome");
			System.out.println("----- Produtos -----");
			System.out.println("6. Incluir novo produto");
			System.out.println("7. Alterar produto pelo código");
			System.out.println("8. Excluir produto pelo código");
			System.out.println("----- Vendas -----");
			System.out.println("9. Incluir uma venda");
			System.out.println("10. Excluir uma venda");
			System.out.println("11. Consultar vendas pelo período\n   de data decrescente");
			System.out.println("12. Consultar estatísticas de vendas\n    por período de vendas");
			System.out.println("13. Sair");
			
			opcao = Console.readInt("\nDigite sua opção: ");
			
			switch(opcao){
			// Cliente
				case 1:
					incluirCliente();
					break;
				case 2:
					alterarClienteCPF();
					break;
				case 3:
					deletarClienteCPF();
					break;
			
				case 4:
					consultarClienteCPF();
					break;
				case 5:
					consultarClienteNome();
					break;
			// Produtos
				case 6:
					incluirProduto();
					break;
					
				case 7:
					alterarProdutoCodigo();
					break;
				case 8:
					deletarProdutoCodigo();
					break;
			// Vendas
				case 9:
					break;
				case 10:
					break;
				case 11:
					break;
				case 12:
					break;
				case 13:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida");
					break;
			}
			
			if (opcao == 13){
				break;
			}
		}while (true);
	}

	// Métodos de leitura e gravação
	private static void lerClientes() {
		try {
			ObjectInputStream inp = new ObjectInputStream(new FileInputStream("Clientes.obj"));
			ListaClientes.cadClientes = (HashMap<String,Cliente>)inp.readObject();
			inp.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void gravarClientes() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Clientes.obj"));
			out.writeObject(ListaClientes.cadClientes);
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void lerProdutos() {
		try {
			ObjectInputStream inp = new ObjectInputStream(new FileInputStream("Produtos.obj"));
			ListaProdutos.cadProdutos = (HashMap<Integer,Produto>)inp.readObject();
			// temos que pegar o ultimo codigo e usá-lo como referencia
			// nem sempre o tamanho do cadProdutos vai representar de forma real
			// ex: quando apagar algum dado sem ser o ultimo, o tamanho do cadProdutos irá mudar
			// e o codigo terá uma posição a menos, sobrescrevendo todos os próximos itens que estiverem na 
			// sequencia
			ArrayList<Produto> produtos = new ArrayList<>();
			for(Produto produto: ListaProdutos.cadProdutos.values()){
				produtos.add(produto);
			}
			
			// pegamos o codigo do ultimo produto cadastrado e continuamos a sequencia
			// dessa forma eliminamos o possivel bug de sequencia após apagar algum registro
			Produto.setNumero(produtos.get(produtos.size() - 1).getCodigo()); // Atualizando a variavel de geração de numeros
			
			inp.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void gravarProdutos() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Produtos.obj"));
			out.writeObject(ListaProdutos.cadProdutos);
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void lerVendas() {
		try {
			ObjectInputStream inp = new ObjectInputStream(new FileInputStream("Vendas.obj"));
			ListaVendas.regVendas = (HashMap<Integer,Venda>)inp.readObject();
			inp.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void gravarVendas (){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Vendas.obj"));
			out.writeObject(ListaVendas.regVendas);
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Métodos para manipulação das classes ligadas à Cliente
	
	/**
	 * Método para incluir novo cliente na Lista de Clientes cadastrados
	 */
	private static void incluirCliente (){
		// validar CPF -> formato e não podem existir mais de um na lista de cliente
		String cpf;
		String nome;
		String email;
		String telefone;
		GregorianCalendar dataInclusao;
//		ListaClientes clientes;
		while (true){
			cpf = Console.readLine("Digite seu CPF: ");
			
			if(!LtpUtil.validarCPF(cpf)){
				System.out.println("CPF inválido!");
				continue;
			}
			// formato válido, verificar se já foi cadastrado!
			try {
				ListaClientes.buscarClienteCpf(cpf);
				System.out.println("Cliente com este CPF já cadastrado. Tente novamente");
				continue;
			}catch (SisVendasException e){
				// se cair aqui tudo bem!
				break;
			}
		}
		
		while(true){
			// validar nome
			nome = Console.readLine("Digite seu nome: ");
			
			if(!nome.matches("[A-Za-z\\s]{1,}\\s[A-Za-z]{1,}")){
				System.out.println("Nome inválido.Deve possuir pelo menos duas palavras!");
				continue;
			}else{
				break;
			}
		}
		
		while(true){
			// validar telefone
			telefone = Console.readLine("Digite seu telefone: ");
			if (telefone.isEmpty()){
				System.out.println("Telefone não pode ficar em branco!");
				continue;
			}else{
				break;
			}
		}
		while(true){
			// validar email
			email = Console.readLine("Digite seu email: ");
			if (!LtpUtil.validarEmail(email)){
				System.out.println("Email inválido!");
				continue;
			}else{
				break;
			}
		}
		
		dataInclusao = new GregorianCalendar();
		// incluir cliente
		Cliente cliente = new Cliente(cpf, nome, telefone, email, dataInclusao, dataInclusao);
		try {
			ListaClientes.incluirCliente(cliente);
			System.out.println("Cliente cadastrado com sucesso!");
		}catch (Exception e){
			System.out.println("Ocorreu algum erro, tente novamente!");
		}
	}
	
	private static String confirmarMudança (){
		String opcao = "S";
		
		do{
			opcao = Console.readLine("Deseja confirmar essa mudança?[S/N]: ");
			if (!opcao.equals("S") && !opcao.equals("N")){
				System.out.println("Opção inválida!");
			}
		}while (!opcao.equals("S") && !opcao.equals("N"));
		
		return opcao;
	}
	
	private static void alterarClienteCPF (){
		String cpf = "";
		String nome = "";
		String email = "";
		String telefone = "";
		Cliente cliente;
		int campo = 0;
		
		while (true){
			
			cpf = Console.readLine("Digite o cpf para realizar a alteração [X para sair]: ");
			if (cpf.equals("X")){
				break;
			}else if(!LtpUtil.validarCPF(cpf) && !cpf.equals("X")){
				System.out.println("CPF inválido!");
				continue;
			}
			// formato válido, verificar se já foi cadastrado!
			try {
				cliente  = ListaClientes.buscarClienteCpf(cpf);
				System.out.println("\n***** DADOS *****\n");
				System.out.println(cliente.toString());
				// mostrar campos para modificar
				do{
					System.out.println("Campos: ");
					System.out.println("0. Cancelar");
					System.out.println("1. Nome");
					System.out.println("2. Telefone");
					System.out.println("3. Email");
					campo = Console.readInt("Qual campo deseja modificar?: ");
					
					if (campo < 0 && campo > 3){
						System.out.println("Opção inválida");
					}else if (campo == 0){
						break;
					}
					
					switch (campo){
						case 1:
							while(true){
								// validar nome
								nome = Console.readLine("Digite o nome: ");
								if(!nome.matches("[A-Za-z\\s]{1,}\\s[A-Za-z]{1,}")){
									System.out.println("Nome inválido.Deve possuir pelo menos duas palavras!");
									continue;
								}else{
									// pegar confirmação para modificar
									if(confirmarMudança().equals("S")){
										cliente.setNome(nome);
									}
									break;
								}
							}
							break;
							
						case 2:
							while(true){
								// validar telefone
								telefone = Console.readLine("Digite seu telefone: ");
								if (telefone.isEmpty()){
									System.out.println("Telefone não pode ficar em branco!");
									continue;
								}else{
									// pegar confirmação para modificar
									if(confirmarMudança().equals("S")){
										cliente.setTelefone(telefone);
									}
									break;
								}
							}
							break;
							
						case 3:
							while(true){
								// validar email
								email = Console.readLine("Digite seu email: ");
								if (!LtpUtil.validarEmail(email)){
									System.out.println("Email inválido!");
									continue;
								}else{
									// pegar confirmação para modificar
									if(confirmarMudança().equals("S")){
										cliente.setEmail(email);
									}
									break;
								}
							}
							break;
					}
					// setando data de alteração
					cliente.setDataUltAlteracao(new GregorianCalendar());
				}while(campo != 0 && (campo > 0 && campo < 4));
				
			}catch (SisVendasException e){
				System.out.println(e.getMessage());
				continue; // decidimos ficar pedindo o usuário até ele digitar corretamente ou sair
			}		
			
		}
		
		if (cpf == "X"){
			return; // saimos da funcao e voltamos para o menu
		}
	}
	
	private static void consultarClienteCPF(){
		String cpf;
		Cliente cliente;
		while (true){
			cpf = Console.readLine("Digite seu cpf: ");
			
			if(!LtpUtil.validarCPF(cpf)){
				System.out.println("CPF inválido!");
				continue;
			}
 
			try {
				cliente = ListaClientes.buscarClienteCpf(cpf);
				System.out.println(cliente.toString());
				break;
			}catch (SisVendasException e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	private static void deletarClienteCPF(){
		String cpf;
		String confirmacao = "X";
		Cliente cliente;
		while (true){
			cpf = Console.readLine("Digite seu CPF [X para sair]: ");
			if(cpf.equals("X")){
				break;
			}else if(!LtpUtil.validarCPF(cpf)){
				System.out.println("CPF inválido!");
				continue;
			}
			// formato válido, verificar se já foi cadastrado!
			try {
				cliente = ListaClientes.buscarClienteCpf(cpf);
				
				if (ListaVendas.regVendas.get(cpf) != null){
					// cliente tem alguma venda em seu cpf, então nao pode ser apagado
					System.out.println("Cliente possui venda em seu CPF, não foi possível apagá-lo.");
					break;
				}else{
					// Mostrar dados, pegar confirmação e apagar usuário!
					System.out.println("\n***** Dados *****");
					System.out.println(cliente.toString());
					confirmacao = confirmarMudança();
					
					if (confirmacao.equals("S")){
						System.out.println("\nCliente excluído com sucesso!\n");
						ListaClientes.excluirCliente(cliente);	
					}else{
						continue; // voltamos no loop e pedimos um cpf, se o usuario quiser, ele pode sair com 'X'
					}
					
				}
				
			}catch (SisVendasException e){
				// se cair aqui tudo bem!
				System.out.println(e.getMessage());
				break;
			}
		}
	}
	
	private static void consultarClienteNome (){
		String nome;
		ArrayList<Cliente> clientes;
		while(true){
			// validar nome
			nome = Console.readLine("Digite o nome do cliente: ");
			
			if(nome.isEmpty()){
				System.out.println("Nome não pode ficar em branco!");
				continue;
			}else{
				break;
			}
		}
		
		try{
			clientes = ListaClientes.clientesOrdemAlfabetica(nome);
			
			for (Cliente cliente: clientes){
				System.out.println(cliente.toString()+"\n");
			}
		}catch(SisVendasException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	// Métodos para manipulação das classes ligadas à Produto
	
	private static void incluirProduto(){
		String nome;
		double precoUnitario;
		Produto produto;
		GregorianCalendar dataInclusao;
		do{
			nome = Console.readLine("Digite o nome do produto: ");
			if(nome.isEmpty()){
				System.out.println("Nome não pode ficar em branco!");
			}
		}while(nome.isEmpty());
		
		do {
			precoUnitario = Console.readDouble("Digite o valor unitário do produto: ");
			
			if (precoUnitario <= 0){
				System.out.println("Valor não deve ficar em branco e deve ser positivo e diferente que 0.");
			}
		}while(precoUnitario <= 0);
		
		dataInclusao = new GregorianCalendar();
		
		produto = new Produto(nome, precoUnitario, dataInclusao, dataInclusao);
//		System.out.println("Qtd de registros produto: "+ ListaProdutos.cadProdutos.size());
//		produto.setNumero(ListaProdutos.cadProdutos.size()); //atualizando o numero do registro
		ListaProdutos.incluirProduto(produto);
	}
	
	private static void alterarProdutoCodigo (){
		int codigo;
		String nome;
		double precoUnitario;
		Produto produto;
		int opcao;
		String confirmacao;
		do{
			codigo = Console.readInt("Digite o código do produto: ");
			
			if(codigo < 0){
				System.out.println("Código inválido!");
			}
		}while(codigo < 0);
		
		try {
			produto = ListaProdutos.buscarProdutoCodigo(codigo);
			// aqui encontramos o produto, então devemos mostrar os dados
			System.out.println("\n***** Dados *****");
			System.out.println(produto.toString());
			
			do {
				System.out.println("\n***** Campos *****");
				System.out.println("0. Cancelar");
				System.out.println("1. Nome");
				System.out.println("2. Preço Unitário");
				opcao = Console.readInt("Qual campo deseja modificar?: ");
				
				switch(opcao){
					case 1:
						do{
							nome = Console.readLine("Digite o nome do produto: ");
							if(nome.isEmpty()){
								System.out.println("Nome não pode ficar em branco!");
							}
						}while(nome.isEmpty());
						confirmacao = confirmarMudança();
						
						if (confirmacao.equals("S")){
							produto.setNome(nome);
							produto.setDataUltAlteracao(new GregorianCalendar());
						}
							
						break;
					case 2:
						do {
							precoUnitario = Console.readDouble("Digite o valor unitário do produto: ");
							
							if (precoUnitario <= 0){
								System.out.println("Valor não deve ficar em branco e deve ser positivo e diferente que 0.");
							}
						}while(precoUnitario <= 0);
						
						confirmacao = confirmarMudança();
						
						if(confirmacao.equals("S")){
							produto.setPrecoUnitario(precoUnitario);
							produto.setDataUltAlteracao(new GregorianCalendar());
						}
						
						break;
				}
			}while(opcao != 0);
			
			
		}catch (SisVendasException e){
			System.out.println(e.getMessage());
		}
	}
	
	private static void deletarProdutoCodigo (){
		int codigo;
		Produto produto;
		boolean existeVendas = false;
		String confirmar = "S";
		do{
			codigo = Console.readInt("Digite o código do produto: ");
			
			if(codigo < 0){
				System.out.println("Código inválido!");
			}
		}while(codigo < 0);
		
		try{
			produto  = ListaProdutos.buscarProdutoCodigo(codigo);
			// nao pode ter nenhuma venda para esse produto
			for (Venda venda: ListaVendas.regVendas.values()){
				ArrayList<ItemVenda> vendasItem = venda.getVendaItens();
				for (ItemVenda item: vendasItem){
					if(item.getProduto() == produto){
						System.out.println("\nExistem vendas registradas para esse produto. Portanto ele não pode ser excluído");
						existeVendas = true;
						break;
					}
				}
				if(existeVendas == true){
					break;
				}
			}
			if(existeVendas == false){
				System.out.println("\n***** DADOS *****");
				System.out.println(produto.toString());
				confirmar = confirmarMudança();
				
				if(confirmar.equals("S")){
					ListaProdutos.excluirProduto(produto);
					System.out.println("\nProduto excluído com sucesso!");
				}
			}
		}catch (SisVendasException e){
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	private static void consultarProdutoNome (){
		String nome;
		ArrayList<Produto> produtos;
		do{
			nome = Console.readLine("Digite o nome do produto: ");
			if(nome.isEmpty()){
				System.out.println("Nome não pode ficar em branco!");
			}
		}while(nome.isEmpty());
		
		try{
			produtos = ListaProdutos.produtosOrdemAlfabetica(nome);
			
			for (Produto produto: produtos){
				System.out.println("\n"+produto.toString());
			}
			
		}catch(SisVendasException e){
			System.out.println(e.getMessage());
		}
	}

	// Métodos para manipulação das classes ligadas à Venda
	private static void incluirVenda (){
		// validar existencia de cpf cadastrado
		String cpf;
		String dataVenda;
		ArrayList<ItemVenda> itensVenda = new ArrayList<>();
		int quantidade;
		float valor;
		boolean itemExiste = false;
		Produto produto;
		Cliente cliente = null; // eclipse pediu para inicializar como null;
		GregorianCalendar data;
		
		while (true){
			cpf = Console.readLine("Digite seu CPF: ");
			
			if(!LtpUtil.validarCPF(cpf)){
				System.out.println("CPF inválido!");
				continue;
			}
			// formato válido, verificar se já foi cadastrado!
			try {
				cliente = ListaClientes.buscarClienteCpf(cpf);
				continue;
			}catch (SisVendasException e){	
				System.out.println(e.getMessage());
				break;
			}
			
		}
		
		while(true){
			dataVenda = Console.readLine("Digite a data da venda: ");
			data = new GregorianCalendar(Integer.parseInt(dataVenda.substring(0,3)), Integer.parseInt(dataVenda.substring(4,6)), Integer.parseInt(dataVenda.substring(7))); 
			if(!LtpUtil.validarData(dataVenda) || dataVenda.isEmpty() || data.compareTo(new GregorianCalendar()) == -1){
				System.out.println("Data inválida! Tente novamente.");
				continue;
			}else{
				break;
			}
		}
		
		// validar itens de venda
		while (true){
			int codProduto;
			// buscando produto por codigo
			do{
				codProduto = Console.readInt("Digite o código do produto [-1 para sair]: ");
				if(codProduto == -1){
					break;
				}else if(codProduto < 0){
					System.out.println("Código inválido, deve ser maior ou igual a zero: ");
				}
			}while(codProduto < 0);
			
			// saindo do loop quando o usuário nao quiser mais cadastrar nenhum produto
			if(codProduto == -1){
				break;
			}
			
			try{
				produto = ListaProdutos.buscarProdutoCodigo(codProduto);
				// verificar se já existe produto em algum item de venda
				for (ItemVenda prod: itensVenda){
					if (prod.getProduto().equals(prod)){
						System.out.println("Produto já colocado na lista de vendas");
						itemExiste = true;
						break;
					}
				}
				if (itemExiste){
					continue; // pedimos um novo produto, ja que o ultimo já tinha sido colocado na lista
				}
			}catch(SisVendasException e){
				System.out.println(e.getMessage());
				continue;
			}
			
			do{
				quantidade = Console.readInt("Digite a quantidade:");
				if(quantidade <= 0){
					System.out.println("Valor inválido! Tem que ser maior que zero.");
				}
			}while(quantidade <= 0);
			
			valor = (float)produto.getPrecoUnitario() * quantidade;
			ItemVenda item = new ItemVenda(produto, produto.getPrecoUnitario(), valor, quantidade);
			itensVenda.add(item);
			
		}
		// aqui o usuario já colocou tudo o que queria naquela venda
		Venda venda = new Venda(cliente, data, itensVenda);
		ListaVendas.incluirVenda(venda); //incluindo a venda
	}
	
	private static void excluirVenda (){
		int codVenda = 0;
		Venda venda;
		do {
			codVenda = Console.readInt("Digite o código da venda para exclusão: ");
			
			if(codVenda < 0){
				System.out.println("Código inválido");
			}
		}while(codVenda < 0);
		
		try{
			venda = ListaVendas.buscarVendaCodigo(codVenda);
			System.out.println(venda.toString());
			
			if(confirmarMudança().equals("S")){
				ListaVendas.excluirVenda(venda);
			}
		}catch(SisVendasException e){
			System.out.println(e.getMessage());
		}
	}
}
