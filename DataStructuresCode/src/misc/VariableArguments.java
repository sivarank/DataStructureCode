package misc;

public class VariableArguments {

	public static void main(String[] args) {
		VariableArguments va = new VariableArguments();
		va.test(1);
		va.test(2,2);
		va.test(3,3,3);
	}

	private void test(int ...a) {
		for(int i : a) {
			System.out.println(i);
		}
	}

}
