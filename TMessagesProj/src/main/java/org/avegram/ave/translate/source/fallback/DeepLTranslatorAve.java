package org.avegram.ave.translate.source.fallback;

import app.nekogram.translator.DeepLTranslator;

public class DeepLTranslatorAve {

    public static String translate(String text, String from, String to) throws Exception {
        var translator = DeepLTranslator.getInstance();

        var result = translator.translate(text, from, to);
        return result.translation;
    }
}
