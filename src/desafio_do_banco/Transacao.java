package desafio_do_banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
	private String tipo;
	private double valor;
	private String data;
	private String descricao;

	public Transacao(String tipo, double valor, String data, String descricao) {
		this.tipo = tipo;
		this.valor = valor;
		this.data = data;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return String.format("%s - %s: R$ %.2f (%s)", data, tipo, valor, descricao);
	}

	public static String formatarData(LocalDateTime dataHora) {
		return dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}
