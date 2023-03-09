import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class Histograma {
	public int[] histograma(Path p) throws IOException {
		int[] vetor = new int[256];
		FileInputStream arq = new FileInputStream(p.toFile());
		int byteLido;
		while ((byteLido = arq.read()) != -1){
			vetor[byteLido]++;
		}
		arq.close();
		return vetor;
	}
}
