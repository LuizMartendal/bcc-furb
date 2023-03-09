import java.util.Comparator;

public class ComparaAnoPlaca implements Comparator<Veiculo>{

	@Override
	public int compare(Veiculo o1, Veiculo o2) {
		if (o1.getAno() > o2.getAno()) {
			return 10;
		}
		if (o1.getAno() < o2.getAno()) {
			return -10;
		}
		return o1.compareTo(o2);
	}

}
