import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Criptografia {
	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser();
		File arquivoSelecionado = null;
		int resposta = chooser.showOpenDialog(null);
		
		if (resposta == JFileChooser.APPROVE_OPTION) {
			arquivoSelecionado = chooser.getSelectedFile();
			JOptionPane.showMessageDialog(null, "Caminho do arquivo selecionado: " + arquivoSelecionado.getAbsolutePath());
			String nomeArq = arquivoSelecionado.getAbsolutePath();
			String nomeSaida = arquivoSelecionado.getName().substring(0, arquivoSelecionado.getName().length() - 4) + "-saida.txt";
			int chave = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com uma chave de 1-200"));
			
			try {
				FileReader origem = new FileReader(nomeArq);
				FileWriter destino = new FileWriter(nomeSaida);
				
				int lido = origem.read();
				int gravado;
				while (lido != -1) {
					gravado = conversao(lido, chave);
					destino.write(gravado);
					lido = origem.read();
				}
				
				origem.close();
				destino.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado.");
		}
	}
	
	private static int conversao(int lido, int chave) {
		int novo = lido + chave;
		if (novo > 255) {
			novo = novo - 256;
		}
		return novo;
	}
}
