public class NameGenerator{
	
	public static String generateStarWarsName(String[] entrada) {
		String[] nome_completo = entrada[0].split(" ");
		String nome_mae = entrada[1];
		String cidade_q_nasceu = entrada[2];
		
		String primeiro_nome = nome_completo[0];
		String ultimo_nome = nome_completo[nome_completo.length - 1];
		
		
		String nomeStarWars = "";
		String nome = "" + ultimo_nome.charAt(0) + ultimo_nome.charAt(1) + ultimo_nome.charAt(2) + primeiro_nome.charAt(0) + primeiro_nome.charAt(1);
		String sobrenome = "" + nome_mae.charAt(0) + nome_mae.charAt(1) + cidade_q_nasceu.charAt(0) + cidade_q_nasceu.charAt(1) + cidade_q_nasceu.charAt(2);
		nomeStarWars = "Seu nome em Star Wars seria:" + nome.toUpperCase() + " " + sobrenome.toUpperCase() ;
		return nomeStarWars;
	}
}