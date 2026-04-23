package org.avegram.ave.translate.source.fallback;

import app.avegram.translator.GoogleAppTranslator;

public class GoogleTranslatorAve {

    public static String translate(String text, String from, String to) throws Exception {
        var translator = GoogleAppTranslator.getInstance();

        var result = translator.translate(text, from, to);
        return result.translation;
    }
}
