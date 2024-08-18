package desafio_do_banco;

public class Main {

	public static void main(String[] args) {
		Cliente eber = new Cliente();
		eber.setNome("Eber");
		
		Conta cc = new ContaCorrente(eber);
		Conta poupanca = new ContaPoupanca(eber);
		
		cc.depositar(100);		
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		

	}

}
