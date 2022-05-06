package application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Map;


public class FleschScore {
	private static ArrayList<String> words = new ArrayList<>();
	
	public static double calcScores(String text) {
		words.clear();
		
		int totalWords = countWords(text); 
		int totalSentences = countSentences(text);
		
		int totalSyllables = 0;
		
		for(String w: words) {
			totalSyllables += countSyllables(w); 
		}
		
		double score = 206.835 - 1.015 * (totalWords / totalSentences) - 84.6 * (totalSyllables / totalWords);
		
		return score; 
	}
	
	/**
	 * Function to calculate errors per 100 words. 
	 * @return
	 */
	public static int countErrors() {
		
		// Load Dictionary
		Map<String, String> dict = FileIO.getDictionary();
		
		// count incorrect words
		int count = 0; 
		
		for(String w: words) {
			if(dict.get(w.toLowerCase()) == null) {
				count++;
			}
		}
		
		double avg = (count * 100.0) / words.size(); 
		
		return (int) Math.ceil(avg);
	}
	
	public static int countSyllables(String word) {
		int num = 0;
		String pattern = "[AEIOUYaeiouy]+";
		Pattern tokenSplitter = Pattern.compile(pattern);
		Matcher m = tokenSplitter.matcher(word);

		String lastToken = "";
		while (m.find()) {
			num++;
			lastToken = m.group();
		}
		if (lastToken.equals("e") && num > 1 && word.charAt(word.length() - 1) == 'e') {
			num--;
		}
		return num;
	}

	public static int countSentences(String str) {
		int num = 0;
		String pattern = "[^.?!]+";
		Pattern tokenSplitter = Pattern.compile(pattern);
		Matcher m = tokenSplitter.matcher(str);
		while (m.find()) {
			num++;
		}
		return num;
	}

	public static int countWords(String str) {
		int num = 0;
		words.clear();

		String pattern = "[A-Za-z]+";
		Pattern tokenSplitter = Pattern.compile(pattern);
		Matcher m = tokenSplitter.matcher(str);

		while (m.find()) {
			System.out.println(m.group());
			words.add(m.group());
			num++;
		}
		return num;
	}
	
}
