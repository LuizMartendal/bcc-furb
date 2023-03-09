

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AdicionarDados {
	//private static ArrayList<Dirigente> dirigentes = new ArrayList<>();
	//private static ArrayList<ComissaoTecnica> comissao = new ArrayList<>();
	static DateTimeFormatter f = DateTimeFormatter.ofPattern("d/M/y");
	//private static ArrayList<Jogador> jogadores = new ArrayList<>();
	
	public static void main(String[] args) throws IOException  {
		//Dirigente
		/*Dirigente dirigente1 = new Dirigente("Luiz Henrique Martendal", "+5547997731104", "+5547997949527", "luiz@dirigente.com");
		Dirigente dirigente2 = new Dirigente("Daniel de Paula", "+5547996942087", "+5547988317001", "daniel@dirigente.com");
		dirigentes.add( dirigente1);
		dirigentes.add(dirigente2);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dirigentes-dados.json"))){
			for (Dirigente d: dirigentes) {
				oos.writeObject(d);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*ArrayList<Dirigente> teste1 = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dirigentes-dados.json"))){
			while (true){
				teste1.add((Dirigente)ois.readObject());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(EOFException eof) {
			System.out.println("Leu tudo...");
		}
		System.out.println(teste1.get(0).getName() + " " + teste1.get(1).getName());*/
		
		// Comissão técnica
		/*ComissaoTecnica c1 = new ComissaoTecnica("Rafael Leão", "Leão", "assistant", LocalDate.parse("31/02/1994", f));
		ComissaoTecnica c2 = new ComissaoTecnica("João Félix", "Félix", "main couch", LocalDate.parse("08/08/1995", f));
		ComissaoTecnica c3 = new ComissaoTecnica("Gonçalo Ramos", "Ramos", "personal trainer", LocalDate.parse("28/07/1993", f));
		comissao.add(c1);
		comissao.add(c2);
		comissao.add(c3);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("comissaoTecnica-dados.json"))){
			for (ComissaoTecnica c: comissao) {
				oos.writeObject(c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*ArrayList<ComissaoTecnica> teste2 = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("comissaoTecnica-dados.json"))){
			while (true){
				teste2.add((ComissaoTecnica)ois.readObject());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(EOFException eof) {
			System.out.println("Leu tudo...");
		}
		System.out.println(teste2.get(0).getName() + " " + teste2.get(1).getName() + " " + teste2.get(2).getName());*/
		
		//Jogadores
		/*Jogador j1 = new Jogador(01, "Mário Rui", "Rui", 1.91, 100.0, LocalDate.parse("12/11/1994", f), "goalkeeper", "Admiralteyets Leningrad");
		jogadores.add(j1);
		Jogador j2 = new Jogador(02, "João Cancelo", "Cancelo", 1.80, 100.0, LocalDate.parse("06/10/1994", f), "right-sided", "Arsenal");
		jogadores.add(j2);
		Jogador j3 = new Jogador(03, "Rúben Dias", "Dias", 1.74, 60.0, LocalDate.parse("01/11/1993", f), "left-sided", "Barcelona");
		jogadores.add(j3);
		Jogador j4 = new Jogador(04, "Diogo Dalot", "Dalot", 1.84, 80.0, LocalDate.parse("24/04/1993", f), "wing", "Bayern");
		jogadores.add(j4);
		Jogador j5 = new Jogador(05, "Tiago Djaló", "Djaló", 1.74, 80.0, LocalDate.parse("26/03/1992", f), "defender", "Chelsea");
		jogadores.add(j5);
		Jogador j6 = new Jogador(06, "Nuno Mendes", "Mendes", 1.76, 85.0, LocalDate.parse("15/05/1994", f), "wing", "Internazionale");
		jogadores.add(j6);
		Jogador j7 = new Jogador(07, "Danilo Pereira", "Danilo", 1.78, 80.0, LocalDate.parse("13/05/1993", f), "midside", "Juventus");
		jogadores.add(j7);
		Jogador j8 = new Jogador(8, "Bruno Fernandes", "Bruno", 1.93, 90.0, LocalDate.parse("12/02/1994", f), "attacker", "Juventus");
		jogadores.add(j8);
		Jogador j9 = new Jogador(9, "William Carvalho", "Carvalho", 1.71, 60.0, LocalDate.parse("17/09/1992", f), "attacker", "Liverpool");
		jogadores.add(j9);
		Jogador j10 = new Jogador(10, "João Mário", "João", 1.88, 75.0, LocalDate.parse("02/07/1994", f), "wing", "Milan");
		jogadores.add(j10);
		Jogador j11 = new Jogador(11, "Bernardo Silva", "Bernardo", 1.86, 80.0, LocalDate.parse("31/06/1995", f), "midside", "Liverpool");
		jogadores.add(j11);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("jogadores-dados.json"))){
			for (Jogador j: jogadores) {
				oos.writeObject(j);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*ArrayList<Jogador> teste3 = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("jogadores-dados.json"))){
			while (true){
				teste3.add((Jogador)ois.readObject());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(EOFException eof) {
			System.out.println("Leu tudo...");
		}
		String str = "";
		for (Jogador j: teste3) {
			str += j.getName() + " ";
		}
		str += teste3.size();
		System.out.println(str);*/
		
		//arquivo json com informação dos comissarios
		String c1 = "{name:\"Rafael Leão\", nickname:\"Leão\", role:\"Assistant\", age:28}";
		String c2 = "{name:\"João Félix\", nickname:\"Félix\", role:\"Main couch\", age:27}";
		String c3 = "{name:\"Gonçalo Ramos\", nickname:\"Ramos\", role:\"Personal trainer\", age:29}";
		FileWriter fw = new FileWriter("comissaoTecnica.json");
		fw.write(c1);
		fw.write(c2);
		fw.write(c3);
		fw.close();
	}
	
}
