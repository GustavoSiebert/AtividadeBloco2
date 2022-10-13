// Maria Eduarda de Sousa, Maria Eduarda Krutzsch, Victor do Amaral

import java.time.LocalDate;
public class TelefoneResidencial {
    private String nome;
    private String endereco;
    private LocalDate dataInstalacao;
    private String numero;
    private boolean temConexaoComInternet;
    private double valorFinal = 15;

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
        numero.replace("(", "");
        numero.replace(")", "");
        numero.replace(" ", "");
        numero.replace("-", "");

        this.numero = numero;
    }

    public boolean TemConexaoComInternet() {
        return temConexaoComInternet;
    }

    public void SetConexaoInternetTrue() {
        this.temConexaoComInternet = true;
    }

    public void SetConexaoInternetFalse() {
        this.temConexaoComInternet = false;
    }

    public double GetPagamentoFinal() {
        return valorFinal;
    }
}