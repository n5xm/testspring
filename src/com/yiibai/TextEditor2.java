package com.yiibai;

public class TextEditor2 {
	private SpellChecker spellChecker;

	public TextEditor2(SpellChecker spellChecker) {
		System.out.println("Inside TextEditor constructor.");
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
