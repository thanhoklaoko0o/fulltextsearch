package com.gcs.agoda;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;

/*
 *(C) Copyright 2020
 *@author USER
 *@date   Jan 2, 2020	
 *@version 1.0
 */
public class CustomAuthorAnalyzer extends Analyzer{

	@Override
	protected TokenStreamComponents createComponents(String fieldName) {
		Tokenizer source = new WhitespaceTokenizer();
        TokenStream filter = new LowerCaseFilter(source);
        return new TokenStreamComponents(source, filter);
	}

}
