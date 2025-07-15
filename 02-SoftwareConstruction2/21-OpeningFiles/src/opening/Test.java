package opening;

public class Test {
	private static final int EOF = -1;
	private static void counter(MyFiles f, int i) {
		int h = (i /100);
		int hByte = h + 48;
		f.write(hByte);
		int t = ((i - (h*100)) / 10);
		int tByte = t + 48;
		f.write(tByte);
		int e = (i - (h * 100) - (t * 10)) + 48;
		f.write(e);
		
	}

	public static void main(String[] args) {
		MyFiles f = new MyFiles("c://myOwnData//myData.txt", "c://myOwnData//myData.txt");
		//f.open("c://myOwnData//myData.txt");
		
		//f.write(64);
		for(int i = 0; i < 128; i++) {
			counter(f, i);
			
			/*int h = (i /100);
			int hByte = h + 48;
			f.write(hByte);
			int t = ((i - (h*100)) / 10);
			int tByte = t + 48;
			f.write(tByte);
			int e = (i - (h * 100) - (t * 10)) + 48;
			f.write(e);
			*/
		
			f.write(' ');
			f.write(i);
			f.write('\n');
			
		}
		int readByte;
		do {
			readByte = f.read();
		System.out.println((char)(readByte) );
		} while ( readByte != EOF);
		f.close();

	}

}
