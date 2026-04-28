package stackExample;

public class Test2 {

	public static void main(String[] args) {
		List myList = new List();
		
		myList.addToFront("L");
		myList.addToEnd("u");
		myList.addToEnd("c");
		myList.addToEnd("h");
		myList.addToEnd("o");
		
		myList.print();
		
		for (Element e: myList) {
			System.out.println(e.getContents());
		}
	}

}
