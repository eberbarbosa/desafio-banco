package desafio_do_banco;

public class Main {

	public static void main(String[] args) {
		Cliente eber = new Cliente();
		eber.setNome("Eber");

		ContaCorrente cc = new ContaCorrente(eber);
		ContaPoupanca poupanca = new ContaPoupanca(eber);

		cc.depositar(500);
		cc.sacar(100);
		cc.transferir(150, poupanca);

		poupanca.depositar(200);

		System.out.println("Extrato Conta Corrente:");
		cc.imprimirExtrato();

		System.out.println("\nExtrato Conta Poupança:");
		poupanca.imprimirExtrato();
	}
}
