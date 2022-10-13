// Maria Eduarda de Sousa, Maria Eduarda Krutzsch, Victor do Amaral
import java.time.LocalDate;

public class TelefoneEspecializado {
	private String nome;
	private String endereco;
	private LocalDate dataInstalacao;
	private String numero;
	private int quantidadeOcorrencias;
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

	public String GetNumero() {
		return numero;
	}

	public void SetNumero(String numero) {
		if (numero.length() == 13) {
			numero.replace("(", "");
			numero.replace(")", "");
			numero.replace(" ", "");
			numero.replace("-", "");
			this.numero = numero;
		}
	}

	public int GetQuantidadeOcorrencias() {
		return quantidadeOcorrencias;
	}

	public void SetQuantidadeOcorrencias(int quantidadeOcorrencias) {
		this.quantidadeOcorrencias = quantidadeOcorrencias;
	}

	public double GetValorFinal() {
		return valorFinal;
	}
	
	public void SetValorAPagar() {
		
		if (this.quantidadeOcorrencias > 50000)
			this.valorFinal = 187.82;

		 else if (this.quantidadeOcorrencias >= 10001)
			this.valorFinal = 123.90;

		  else if (this.quantidadeOcorrencias >= 5001)
			this.valorFinal = 98.50;

		  else if (this.quantidadeOcorrencias >= 1001)
			this.valorFinal = 67.80;

		  else if (this.quantidadeOcorrencias >= 1)
			this.valorFinal = 50;
	}
}
