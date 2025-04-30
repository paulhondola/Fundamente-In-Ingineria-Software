import java.util.List;

public class T implements X {

	private List<X> obj;

	public void add(X a) {
		obj.add(a);
	}

	@Override
	public int m() {
		int sum = 0;
		for (X x : obj) {
			sum += x.m();
		}
		return sum;
	}
}
