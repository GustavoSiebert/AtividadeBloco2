// Maria Eduarda de Sousa, Maria Eduarda Krutzsch, Victor do Amaral
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class Main {

	private JFrame frame;
	private JTextField tfNomeUsuarioRes;
	private JTextField tfEndInstalacaoRes;
	private JTextField tfDataInstalacaoRes;
	private JTextField tfTelefoneRes;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfNomeUsuarioCom;
	private JTextField tfEndInstalacaoCom;
	private JTextField tfDataInstalacaoCom;
	private JTextField tfTelefoneCom;
	private JTextField tfRamoAtividadeCom;
	private JTextField tfNomeUsuarioEsp;
	private JTextField tfEnderecoInstalacaoEsp;
	private JTextField tfDataInstalacaoEsp;
	private JTextField tfTelefoneEsp;
	private JTextField tfQtdeOcorrenciasEsp;
	private HashMap<String, TelefoneResidencial> telefonesResidenciais = new HashMap<>();
	private HashMap<String, TelefoneComercial> telefonesComerciais = new HashMap<>();
	private HashMap<String, TelefoneEspecializado> telefonesEspecializados = new HashMap<>();
	private DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private JTextField tfTelefoneConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() { CriacaoApp(); }

	/**
	 * Initialize the contents of the frame.
	 */

	private void AddPaineis(JTabbedPane tabbedPane) throws ParseException {


		MaskFormatter mskTelefone = new MaskFormatter("(##) #####-####");
		MaskFormatter mskData = new MaskFormatter("##/##/####");


		JPanel painelComercial = new JPanel();
		tabbedPane.addTab("Telefone Comercial", null, painelComercial, null);
		SetTelefoneComercialPainel(painelComercial,mskTelefone,mskData);

		JPanel painelResidencial = new JPanel();
		tabbedPane.addTab("Telefone Residencial", null, painelResidencial, null);
		SetTelefoneResidencialPainel(painelResidencial,mskTelefone,mskData);

		JPanel painelEspecializado = new JPanel();
		tabbedPane.addTab("Telefone Especializado", null, painelEspecializado, null);
		SetTelefoneEspecializadoPainel(painelEspecializado,mskTelefone,mskData);

		JPanel painelBusca = new JPanel();
		tabbedPane.addTab("Busca", null, painelBusca, null);
		SetBuscaPainel(painelBusca,mskTelefone,mskData);
	}

	private void SetTelefoneResidencialPainel(JPanel painel, MaskFormatter mskTelefone, MaskFormatter mskData)
	{
		painel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Nome de usu\u00E1rio:");
		lblNewLabel_3.setBounds(69, 53, 114, 14);
		painel.add(lblNewLabel_3);

		tfNomeUsuarioRes = new JTextField();
		tfNomeUsuarioRes.setBounds(242, 50, 183, 20);
		painel.add(tfNomeUsuarioRes);
		tfNomeUsuarioRes.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Endere\u00E7o de Instala\u00E7\u00E3o:");
		lblNewLabel_4.setBounds(69, 91, 151, 14);
		painel.add(lblNewLabel_4);

		tfEndInstalacaoRes = new JTextField();
		tfEndInstalacaoRes.setBounds(242, 88, 183, 20);
		painel.add(tfEndInstalacaoRes);
		tfEndInstalacaoRes.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Data de instala\u00E7\u00E3o:");
		lblNewLabel_5.setBounds(69, 128, 114, 14);
		painel.add(lblNewLabel_5);

		tfDataInstalacaoRes = new JFormattedTextField(mskData);
		tfDataInstalacaoRes.setBounds(242, 125, 183, 20);
		painel.add(tfDataInstalacaoRes);
		tfDataInstalacaoRes.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Telefone:");
		lblNewLabel_6.setBounds(69, 163, 77, 14);
		painel.add(lblNewLabel_6);

		tfTelefoneRes = new JFormattedTextField(mskTelefone);
		tfTelefoneRes.setBounds(242, 160, 183, 20);
		painel.add(tfTelefoneRes);
		tfTelefoneRes.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Possui conex\u00E3o \u00E0 internet?");
		lblNewLabel_7.setBounds(69, 202, 162, 14);
		painel.add(lblNewLabel_7);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 29, 483, 2);
		painel.add(separator);

		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(25, 4, 97, 20);
		painel.add(lblNewLabel);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Sim");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(242, 198, 53, 23);
		painel.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton.setActionCommand("True");

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("N\u00E3o");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(311, 198, 53, 23);
		painel.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_1.setActionCommand("False");

		JButton btnCadastrarTelResidencial = new JButton("Registrar");
		btnCadastrarTelResidencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelefoneResidencial telefoneResidencial = new TelefoneResidencial();
				LocalDate data = LocalDate.parse(tfDataInstalacaoRes.getText(), formatador);

				telefoneResidencial.SetNome(tfNomeUsuarioRes.getText());
				telefoneResidencial.SetEndereco(tfEndInstalacaoRes.getText());
				telefoneResidencial.SetDataInstalacao(data);
				telefoneResidencial.SetNumero(tfTelefoneRes.getText());
				String botao = buttonGroup.getSelection().getActionCommand();
				if (botao == "True") {
					telefoneResidencial.SetConexaoInternetTrue();
				} else {
					telefoneResidencial.SetConexaoInternetFalse();
				}

				telefonesResidenciais.put(telefoneResidencial.GetNumero(), telefoneResidencial);

				tfDataInstalacaoRes.setText("");
				tfNomeUsuarioRes.setText("");
				tfEndInstalacaoRes.setText("");
				tfTelefoneRes.setText("");

				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

			}
		});

		btnCadastrarTelResidencial.setBounds(191, 239, 89, 23);
		painel.add(btnCadastrarTelResidencial);
	}

	private void SetTelefoneComercialPainel(JPanel painel, MaskFormatter mskTelefone, MaskFormatter mskData )
	{
		painel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Cadastro");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(25, 4, 97, 20);
		painel.add(lblNewLabel_1);

		JLabel lblNewLabel_3_1 = new JLabel("Nome de usu\u00E1rio:");
		lblNewLabel_3_1.setBounds(92, 49, 114, 14);
		painel.add(lblNewLabel_3_1);

		tfNomeUsuarioCom = new JTextField();
		tfNomeUsuarioCom.setColumns(10);
		tfNomeUsuarioCom.setBounds(265, 46, 183, 20);
		painel.add(tfNomeUsuarioCom);

		JLabel lblNewLabel_4_1 = new JLabel("Endere\u00E7o de Instala\u00E7\u00E3o:");
		lblNewLabel_4_1.setBounds(92, 87, 151, 14);
		painel.add(lblNewLabel_4_1);

		tfEndInstalacaoCom = new JTextField();
		tfEndInstalacaoCom.setColumns(10);
		tfEndInstalacaoCom.setBounds(265, 84, 183, 20);
		painel.add(tfEndInstalacaoCom);

		JLabel lblNewLabel_5_1 = new JLabel("Data de instala\u00E7\u00E3o:");
		lblNewLabel_5_1.setBounds(92, 124, 114, 14);
		painel.add(lblNewLabel_5_1);

		tfDataInstalacaoCom = new JFormattedTextField(mskData);
		tfDataInstalacaoCom.setColumns(10);
		tfDataInstalacaoCom.setBounds(265, 121, 183, 20);
		painel.add(tfDataInstalacaoCom);

		JLabel lblNewLabel_6_1 = new JLabel("Telefone:");
		lblNewLabel_6_1.setBounds(92, 159, 77, 14);
		painel.add(lblNewLabel_6_1);

		tfTelefoneCom = new JFormattedTextField(mskTelefone);
		tfTelefoneCom.setColumns(10);
		tfTelefoneCom.setBounds(265, 156, 183, 20);
		painel.add(tfTelefoneCom);

		JLabel lblNewLabel_7_1 = new JLabel("Ramo de atividade:");
		lblNewLabel_7_1.setBounds(92, 198, 162, 14);
		painel.add(lblNewLabel_7_1);

		tfRamoAtividadeCom = new JTextField();
		tfRamoAtividadeCom.setColumns(10);
		tfRamoAtividadeCom.setBounds(265, 195, 183, 20);
		painel.add(tfRamoAtividadeCom);

		JButton btnCadastrarComercial = new JButton("Registrar");
		btnCadastrarComercial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelefoneComercial telefoneComercial = new TelefoneComercial();
				LocalDate data = LocalDate.parse(tfDataInstalacaoCom.getText(), formatador);

				telefoneComercial.SetNome(tfNomeUsuarioCom.getText());
				telefoneComercial.SetEndereco(tfEndInstalacaoCom.getText());
				telefoneComercial.SetDataInstalacao(data);
				telefoneComercial.SetNumero(tfTelefoneCom.getText());
				telefoneComercial.SetAtividade(tfRamoAtividadeCom.getText());
				telefoneComercial.SetValorAPagar();

				telefonesComerciais.put(telefoneComercial.GetNumero(), telefoneComercial);

				tfDataInstalacaoCom.setText("");
				tfNomeUsuarioCom.setText("");
				tfEndInstalacaoCom.setText("");
				tfTelefoneCom.setText("");
				tfRamoAtividadeCom.setText("");

				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			}
		});
		btnCadastrarComercial.setBounds(214, 235, 89, 23);
		painel.add(btnCadastrarComercial);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 31, 488, 2);
		painel.add(separator_1);
	}

	private void SetTelefoneEspecializadoPainel(JPanel painel, MaskFormatter mskTelefone, MaskFormatter mskData)
	{
		painel.setLayout(null);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 35, 483, 2);
		painel.add(separator_2);

		JLabel lblNewLabel_2 = new JLabel("Cadastro");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(25, 4, 97, 20);
		painel.add(lblNewLabel_2);

		JLabel lblNewLabel_3_2 = new JLabel("Nome de usu\u00E1rio:");
		lblNewLabel_3_2.setBounds(69, 49, 114, 14);
		painel.add(lblNewLabel_3_2);

		tfNomeUsuarioEsp = new JTextField();
		tfNomeUsuarioEsp.setColumns(10);
		tfNomeUsuarioEsp.setBounds(242, 46, 183, 20);
		painel.add(tfNomeUsuarioEsp);

		JLabel lblNewLabel_4_2 = new JLabel("Endere\u00E7o de Instala\u00E7\u00E3o:");
		lblNewLabel_4_2.setBounds(69, 87, 151, 14);
		painel.add(lblNewLabel_4_2);

		tfEnderecoInstalacaoEsp = new JTextField();
		tfEnderecoInstalacaoEsp.setColumns(10);
		tfEnderecoInstalacaoEsp.setBounds(242, 84, 183, 20);
		painel.add(tfEnderecoInstalacaoEsp);

		JLabel lblNewLabel_5_2 = new JLabel("Data de instala\u00E7\u00E3o:");
		lblNewLabel_5_2.setBounds(69, 124, 114, 14);
		painel.add(lblNewLabel_5_2);

		tfDataInstalacaoEsp = new JFormattedTextField(mskData);
		tfDataInstalacaoEsp.setColumns(10);
		tfDataInstalacaoEsp.setBounds(242, 121, 183, 20);
		painel.add(tfDataInstalacaoEsp);

		JLabel lblNewLabel_6_2 = new JLabel("Telefone:");
		lblNewLabel_6_2.setBounds(69, 159, 77, 14);
		painel.add(lblNewLabel_6_2);

		tfTelefoneEsp = new JFormattedTextField(mskTelefone);
		tfTelefoneEsp.setColumns(10);
		tfTelefoneEsp.setBounds(242, 156, 183, 20);
		painel.add(tfTelefoneEsp);

		JLabel lblNewLabel_7_2 = new JLabel("Quantidade de ocorr\u00EAncias:");
		lblNewLabel_7_2.setBounds(69, 198, 162, 14);
		painel.add(lblNewLabel_7_2);

		tfQtdeOcorrenciasEsp = new JTextField();
		tfQtdeOcorrenciasEsp.setColumns(10);
		tfQtdeOcorrenciasEsp.setBounds(242, 195, 183, 20);
		painel.add(tfQtdeOcorrenciasEsp);

		JButton btnCadastrarTelComercial = new JButton("Registrar");
		btnCadastrarTelComercial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelefoneEspecializado telefoneEspecializado = new TelefoneEspecializado();
				LocalDate data = LocalDate.parse(tfDataInstalacaoEsp.getText(), formatador);

				telefoneEspecializado.SetNome(tfNomeUsuarioEsp.getText());
				telefoneEspecializado.SetEndereco(tfEnderecoInstalacaoEsp.getText());
				telefoneEspecializado.SetDataInstalacao(data);
				telefoneEspecializado.SetNumero(tfTelefoneEsp.getText());
				telefoneEspecializado.SetQuantidadeOcorrencias(Integer.parseInt(tfQtdeOcorrenciasEsp.getText()));
				telefoneEspecializado.SetValorAPagar();

				telefonesEspecializados.put(telefoneEspecializado.GetNumero(), telefoneEspecializado);

				tfDataInstalacaoEsp.setText("");
				tfNomeUsuarioEsp.setText("");
				tfEnderecoInstalacaoEsp.setText("");
				tfTelefoneEsp.setText("");
				tfQtdeOcorrenciasEsp.setText("");

				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			}
		});
		btnCadastrarTelComercial.setBounds(191, 235, 89, 23);
		painel.add(btnCadastrarTelComercial);
	}

	private void SetBuscaPainel(JPanel painel, MaskFormatter mskTelefone, MaskFormatter mskData)
	{
		painel.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("N\u00FAmero de telefone \u00E0 consultar:");
		lblNewLabel_8.setBounds(47, 81, 181, 14);
		painel.add(lblNewLabel_8);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 34, 488, 2);
		painel.add(separator_3);

		JLabel lblNewLabel_9 = new JLabel("Dados para consulta");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_9.setBounds(25, 4, 181, 25);
		painel.add(lblNewLabel_9);

		JButton btnConsultarTelefoneDados = new JButton("Consultar");
		btnConsultarTelefoneDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensagem = "";
				for (TelefoneResidencial telefone : telefonesResidenciais.values()) {
					if (telefone.GetNumero().equals(tfTelefoneConsulta.getText())) {

						mensagem = "Nome do usu�rio: " + telefone.GetNome() + "\nEndere�o de instala��o: "
								+ telefone.GetEndereco() + "\nData de instala��o: "
								+ telefone.GetDataInstalacao() + "\nN�mero de telefone: " + telefone.GetNumero();

						String temConexaoInternet = telefone.TemConexaoComInternet() ? "Sim" : "N�o";

						mensagem += "\nPossui conex�o � internet? " + temConexaoInternet;
						mensagem += "\nValor a pagar: " + telefone.GetPagamentoFinal();
					}
				}
				for (TelefoneComercial telefone : telefonesComerciais.values()) {
					if (telefone.GetNumero().equals(tfTelefoneConsulta.getText())) {
						mensagem = "Nome do usu�rio: " + telefone.GetNome() + "\nEndere�o de instala��o: "
								+ telefone.GetEndereco() + "\nData de instala��o: "
								+ telefone.GetDataInstalacao() + "\nN�mero de telefone: " + telefone.GetNumero()
								+ "\nRamo de atividade: " + telefone.GetAtividade() + "\nValor a pagar: "
								+ telefone.GetValorFinal();

					}
				}
				for (TelefoneEspecializado telefone : telefonesEspecializados.values()) {
					if (telefone.GetNumero().equals(tfTelefoneConsulta.getText())) {
						mensagem = "Nome do usu�rio: " + telefone.GetNome() + "\nEndere�o de instala��o: "
								+ telefone.GetEndereco() + "\nData de instala��o: "
								+ telefone.GetDataInstalacao() + "\nN�mero de telefone: " + telefone.GetNumero()
								+ "\nQuantidade de ocorr�ncias: " + telefone.GetQuantidadeOcorrencias() + "\nValor a pagar: "
								+ telefone.GetValorFinal();
					}
				}
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		btnConsultarTelefoneDados.setBounds(374, 77, 89, 23);
		painel.add(btnConsultarTelefoneDados);

		JLabel lblNewLabel_10 = new JLabel("Verificar potencial de faturamento");
		lblNewLabel_10.setBounds(47, 142, 181, 14);
		painel.add(lblNewLabel_10);

		JButton btnVerificarFaturamento = new JButton("Consultar");
		btnVerificarFaturamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double potencialFaturamento = 0;
				for (int contador = 1; contador <= telefonesResidenciais.size(); contador++) {
					potencialFaturamento += 15.00;
				}

				for (TelefoneComercial telefone : telefonesComerciais.values()) {
					potencialFaturamento += telefone.GetValorFinal();
				}
				for (TelefoneEspecializado telefone : telefonesEspecializados.values()) {
					potencialFaturamento += telefone.GetValorFinal();
				}
				JOptionPane.showMessageDialog(null, "Potencial de faturamento: " + potencialFaturamento);
			}
		});
		btnVerificarFaturamento.setBounds(238, 138, 89, 23);
		painel.add(btnVerificarFaturamento);

		tfTelefoneConsulta = new JFormattedTextField(mskTelefone);
		tfTelefoneConsulta.setBounds(224, 78, 103, 20);
		painel.add(tfTelefoneConsulta);
		tfTelefoneConsulta.setColumns(10);
	}

	private void CriacaoApp() {
		try {
			frame = new JFrame();
			frame.setBounds(100, 100, 529, 340);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
			tabbedPane.setBounds(0, 0, 600, 301);
			frame.getContentPane().add(tabbedPane);

			AddPaineis(tabbedPane);
		}
		catch(Exception exception)
		{
			JOptionPane.showMessageDialog(null, exception.getLocalizedMessage());
		}
	}
}