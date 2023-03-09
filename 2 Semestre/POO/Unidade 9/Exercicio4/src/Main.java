import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class Main {
	public static void main(String[] args) throws IOException {
		ArrayList<ClimaDoDia> clima = new ArrayList<>();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("d/M/y");
		File arquivoSelecionado = null;
		JFileChooser chooser = new JFileChooser();
		int resposta = chooser.showOpenDialog(null);
		
		if (resposta == JFileChooser.APPROVE_OPTION) {
			arquivoSelecionado = chooser.getSelectedFile();
			try (FileInputStream fis = new FileInputStream(arquivoSelecionado)){
				DataInputStream dis = new DataInputStream(fis);
				while (true) {
					String dataStr = dis.readUTF();
					char char1 = dis.readChar();
					char char2 = dis.readChar();
					int velocidade = dis.readInt();
					int indice = dis.readInt();
					double temperatura = dis.readDouble();
					ClimaDoDia c = new ClimaDoDia(LocalDate.parse(dataStr, f), "" +char1+char2, velocidade, indice, temperatura);
					clima.add(c);
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  catch (EOFException eof) {
				System.out.println("Fim do arquivo.");
			}
			
			try (FileOutputStream fos = new FileOutputStream("ClimaDoDia - váriosObjetos.dat")){
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				for (ClimaDoDia cd: clima) {
					oos.writeObject(cd);
				}
			} catch (IOException ioe) {
				System.out.println(ioe);
			}
		}
	}
}
