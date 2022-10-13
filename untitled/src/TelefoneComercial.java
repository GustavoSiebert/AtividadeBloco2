// Maria Eduarda de Sousa, Maria Eduarda Krutzsch, Victor do Amaral
import java.time.LocalDate;

public class TelefoneComercial {
	private String nome;
	private String endereco;
	private LocalDate dataInstalacao;
	private String numero;
	private String atividade;
	private double valorFinal;

	public String GetNome() {
		return nome;
	}

	public void SetNome(String nome) {
		this.nome = nome;
	}

	public String GetEndereco() {
		return endereco;
	}

	public void SetEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDate GetDataInstalacao() {
		return dataInstalacao;
	}

	public void SetDataInstalacao(LocalDate dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}

	public double GetValorFinal() {
		return valorFinal;
	}

	public void SetValorAPagar() {
		if (this.dataInstalacao.isBefore(LocalDate.of(2019, 01, 01)))
			this.valorFinal = 25;
		else
			this.valorFinal = 37.50;
	}

	public String GetAtividade() {
		return atividade;
	}

	public void SetAtividade(String atividade) {
		this.atividade = atividade;
	}

	public String GetNumero() {

		return numero;
	}

	public void SetNumero(String numero) {
		numero.replace("(", "");
		numero.replace(")", "");
		numero.replace(" ", "");
		numero.replace("-", "");
		this.numero = numero;
	}


}
