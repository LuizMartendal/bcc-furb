//Luiz Henrique Martendal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TelaRadar{
	List<ObjetoVoador> objetos = new ArrayList<>();
	
	public void criaEspacoAereo() {
		double[] c = new double[2];
		int a = 0;
		Random r = new Random();
		c[0] = r.nextInt(-15000, -20000);
		c[1] = -20000;
		a = 1000;
		Balao b = new Balao(c, a);
		objetos.add(b);
		c[0] = -19000;
		c[1] = -20000;
		a = 1000;
		Aeronave a1 = new Aeronave(c, a, "decolando", "FURB", 10);
		objetos.add(a1);
		c[0] = -19000;
		c[1] = -20000;
		a = 1000;
		Aeronave a2 = new Aeronave(c, a, "pousando", "FURB", 20);
		objetos.add(a2);
		c[0] = -21000;
		c[1] = -30000;
		a = 2000;
		Aeronave a3 = new Aeronave(c, a, "decolando", "FURB", 15);
		objetos.add(a3);
		c[0] = -19000;
		c[1] = -30000;
		a = 3000;
		Aeronave a4 = new Aeronave(c, a, "decolando", "FURB", 30);
		objetos.add(a4);
		c[0] = -19000;
		c[1] = -31000;
		a = 4000;
		Aeronave a5 = new Aeronave(c, a, "pousando", "FURB", 10);
		objetos.add(a5);
		c[0] = -24000;
		c[1] = -25000;
		a = 5000;
		Passaro p = new Passaro(c, a, "Pombo");
		objetos.add(p);
	}
	
	public List<ObjetoVoador> cicloSimulador(){
		for (ObjetoVoador o: objetos) {
			o.movimentar();
		}
		return this.verificaColisao();
	}
	
	public List<ObjetoVoador> verificaColisao(){
		List<ObjetoVoador> l = new ArrayList<>();
		for (ObjetoVoador o : objetos) {
			for (ObjetoVoador o2: objetos) {
				if (o.getAltura() == o2.getAltura() && o.getCoordenada() == o2.getCoordenada()) {
					l.add(o);
				}
			}
		}
		return l;
	}
	
	public Path exportaEspacoAereo() {
		objetos.sort(null);
		File f = new File("objetos.txt");
		
		try (FileWriter fw = new FileWriter(f)){
			for (ObjetoVoador o: objetos) {
				fw.write(o.toString() + "\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Path.of(f.getAbsolutePath());
	}

}
