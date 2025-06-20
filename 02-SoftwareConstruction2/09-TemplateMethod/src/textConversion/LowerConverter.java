package textConversion;

public class LowerConverter extends GeneralConverter {
	public LowerConverter() {
		super();
	}
	
	@Override
	protected String applyCaseConversion(String txt) {
		String convTxt = txt.toLowerCase();
		return convTxt;
	}

}
