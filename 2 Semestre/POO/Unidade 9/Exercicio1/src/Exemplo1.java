import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exemplo1 {
	
	public static void main(String[] args) throws IOException {
		// try with resources
		try (FileWriter fw = new FileWriter("ArqTextoExerc1.txt")){
			fw.write("12345");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileOutputStream fos = new FileOutputStream("ArqBinarioExerc1.dat");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeInt(12345);
		dos.close();
		
		FileReader fr = new FileReader("ArqTextoExerc1.txt");
		BufferedReader br = new BufferedReader(fr);
		String s = br.readLine();
		System.out.println("Arquivo texto lido como texto = " + s);
		br.close();
		
		fr = new FileReader("ArqBinarioExerc1.dat");
		br = new BufferedReader(fr);
		s = br.readLine();
		System.out.println("Arquivo binário lido com texto = " + s);
		br.close();
		
		FileInputStream fit = new FileInputStream("ArqBinarioExerc1.dat");
		DataInputStream dis = new DataInputStream(fit);
		int inteiro = dis.readInt();
		System.out.println("Arquivo binário lido como binário = " + inteiro);
		dis.close();
		
		fit = new FileInputStream("ArqTextoExerc1.txt");
		dis = new DataInputStream(fit);
		inteiro = dis.readInt();
		System.out.println("Arquivo texto lido como binário = " + inteiro);
		dis.close();
	}
}
