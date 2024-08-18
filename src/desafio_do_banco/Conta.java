package desafio_do_banco;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Conta implements IConta {
	private static int SEQUENCIAL = 1;
	private static final int AGENCIA_PADRAO = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected List<Transacao> historico = new ArrayList<>();

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		if (valor > 0 && saldo >= valor) {
			saldo -= valor;
			adicionarTransacao("Saque", valor, "Saque realizado");
		} else {
			System.out.println("Saque inválido ou saldo insuficiente.");
		}
	}

	@Override
	public void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
			adicionarTransacao("Depósito", valor, "Depósito realizado");
		} else {
			System.out.println("Valor de depósito inválido.");
		}
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if (valor > 0 && saldo >= valor) {
			System.out.println("Iniciando transferência de R$ " + valor + " da conta " + this.numero + " para a conta "
					+ contaDestino.getNumero());
			this.sacar(valor);
			contaDestino.depositar(valor);
			adicionarTransacao("Transferência", valor, "Transferência para conta " + contaDestino.getNumero());
			contaDestino.adicionarTransacao("Transferência", valor, "Transferência recebida da conta " + this.numero);
			System.out.println("Transferência realizada: R$ " + valor);
		} else {
			System.out.println("Transferência inválida ou saldo insuficiente.");
		}
	}

	public void adicionarTransacao(String tipo, double valor, String descricao) {
		String dataAtual = Transacao.formatarData(LocalDateTime.now());
		historico.add(new Transacao(tipo, valor, dataAtual, descricao));
	}

	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta ===");
		System.out.println("Titular: " + this.cliente.getNome());
		System.out.println("Agencia: " + this.agencia);
		System.out.println("Numero: " + this.numero);
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		imprimirHistorico();
	}

	private void imprimirHistorico() {
		System.out.println("=== Histórico de Transações ===");
		for (Transacao transacao : historico) {
			System.out.println(transacao);
		}
	}

	// Getters e Setters
	public int getNumero() {
		return numero;
	}
}
