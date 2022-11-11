package tapir;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import juego.Juego;

public class TestingSetup {
	public static void setup() {
		HashMap<Integer, String> mapObjectsToCallSequence = null; 
		HashMap<String, String> mapMethodsToSymbols = null; 
		Pattern regularExpression = null; 
		Matcher matcher = null;
		
		//Specification of the test class\
		TestingCore.mapClassToTestingInformation = new HashMap<>();
			
		
		// Testing setup for Account class
		//Definition of the methods and their corresponding symbols
		mapObjectsToCallSequence = new HashMap<>(); 
		mapMethodsToSymbols = new HashMap<String, String>();
		mapMethodsToSymbols.put("juego.Juego.<init>", "c");
		mapMethodsToSymbols.put("juego.Juego.iniciar", "i");
		mapMethodsToSymbols.put("juego.Juego.accionar", "a");
		mapMethodsToSymbols.put("juego.Juego.ganar", "g");
		mapMethodsToSymbols.put("juego.Juego.perder", "p");

		//Definition of the regular expression
		regularExpression = Pattern.compile("cia*(g|p)*");
		//Initializing the regular expressions controller
		matcher = regularExpression.matcher("");	
		// All information related to how the Juego class is testing is store in a TestingInformation instance
		TestingInformation ti = new TestingInformation(Juego.class.toString(), mapObjectsToCallSequence, mapMethodsToSymbols, regularExpression, matcher, true);
		TestingCore.mapClassToTestingInformation.put(Juego.class.toString(), ti);
		
	}
	
}
