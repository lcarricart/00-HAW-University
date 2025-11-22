package stackExample;

public class Test {
	public static void main(String[] args) {
		System.out.println("[Exercise 1]");
		Stack names = new Stack();
		names.push("Alice");
		System.out.println("New item pushed in the stack: " + names.top());
		names.push("Bob");
		System.out.println("New item pushed in the stack: " + names.top());
		names.pop();
		System.out.println("Stack empty? " + names.empty());
		names.pop();
		System.out.println("New item pushed in the stack: " + names.top());
		
		List myList = new List();
		myList.print();
		
		System.out.println("\n[Exercise 2]");
		myList.addToFront("Bobby Fischer");
		myList.addToFront("Richard");
		myList.addToFront("Alice");
		myList.print();
		
		if (myList.search(" Fischer")) {
			System.out.println("Bobby is in the list!");
		} else {
			System.out.println("The searched item isn't contained in the list");
		}
		
		System.out.println("\n[Exercise 3]");
		myList.includeAt(1, "Dan");
		myList.print();
		
		System.out.println("\n[Exercise 4]: Try adding something outside the limit of our list (position 7)");
		
		// myList.empty();
		//myList.addToFront("Bobby Fischer");
		//myList.addToFront("Richard");
		//myList.addToFront("Alice");
		//myList.print();
	}
}
