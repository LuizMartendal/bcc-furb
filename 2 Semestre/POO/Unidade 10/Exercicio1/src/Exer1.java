import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class Exer1 {
	private static LinkedList<Veiculo> veiculos = new LinkedList<>();
	
	public static void main(String[] args) {
		Veiculo v1 = new Veiculo("123", "CeltA´zul", 2022, "Dorivaldo");
		veiculos.add(v1);
		Veiculo v2 = new Veiculo("1234", "Uno", 2000, "Daniel");
		veiculos.add(v2);
		Veiculo v3 = new Veiculo("1235", "Sandero", 2001, "Gustavo");
		veiculos.add(v3);
		Veiculo v4 = new Veiculo("1236", "Monza", 2010, "Gabriel");
		veiculos.add(v4);
		Veiculo v5 = new Veiculo("1237", "Maréa", 2021, "Luiz");
		veiculos.add(v5);
		Veiculo v6 = new Veiculo("1238", "Chevette", 2019, "Marcel");
		veiculos.add(v6);
		Veiculo v7 = new Veiculo("1239", "Fusca", 2022, "Julio");
		veiculos.add(v7);
		Veiculo v8 = new Veiculo("1230", "Gol Bola", 2008, "Michael Jackson");
		veiculos.add(v8);
		Veiculo v9 = new Veiculo("12311", "Palio", 2023, "Camaleão");
		veiculos.add(v9);
		Veiculo v0 = new Veiculo("12312", "Corsa", 2022, "Depraved");
		veiculos.add(v0);
		
		System.out.println(veiculos);
		veiculos.remove(v0);
		veiculos.remove(6);
		System.out.println(veiculos);
		ListIterator<Veiculo> li = veiculos.listIterator(veiculos.size() - 2);
		System.out.println(veiculos);
		Veiculo v = li.previous();
		li.remove();
		System.out.println(v + " " + veiculos);
		
		Collections.shuffle(veiculos);
		System.out.println(veiculos);
		Collections.sort(veiculos);
		System.out.println(veiculos);
		
		ComparaAnoPlaca c = new ComparaAnoPlaca();
		Collections.shuffle(veiculos);
		veiculos.sort(c);
		System.out.println(veiculos);
	}
	
}
