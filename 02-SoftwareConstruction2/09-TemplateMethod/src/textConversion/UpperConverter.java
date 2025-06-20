package textConversion;

public class UpperConverter extends GeneralConverter {
	public UpperConverter() {
		super();
	}
	
	@Override
	protected String applyCaseConversion(String txt) {
		String convTxt = txt.toUpperCase();
		return convTxt;
	}

}
