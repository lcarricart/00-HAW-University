package stackExample;

public class Test {
	public static void main(String[] args) {
		Stack names = new Stack();
		names.push("Alice");
		System.out.println("New item pushed in the stack: " + names.top());
		names.push("Bob");
		System.out.println("New item pushed in the stack: " + names.top());
		names.pop();
		System.out.println("Stack empty? " + names.empty());
		names.pop();
		System.out.println("New item pushed in the stack: " + names.top());
	}
}
