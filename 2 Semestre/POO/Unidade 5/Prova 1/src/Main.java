import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		String str = "";
		;
		try (FileReader fr = new FileReader("texto.txt")){
			int indice = fr.read();
			while (indice != -1) {
				str += (char)indice;
				indice = fr.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException eofe) {
			System.out.println("Arquivo lido.");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(str);
	}
}
