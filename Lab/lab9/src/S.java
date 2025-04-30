public class S implements X {

	private T objT;

	public S(T x) {
		this.objT = x;
	}

	@Override
	public int m() {
		return 1 + objT.m();
	}
}
