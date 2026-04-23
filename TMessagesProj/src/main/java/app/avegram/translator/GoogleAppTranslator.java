package app.avegram.translator;

public class GoogleAppTranslator {

    private static volatile GoogleAppTranslator instance;

    private GoogleAppTranslator() {
    }

    public static GoogleAppTranslator getInstance() {
        if (instance == null) {
            synchronized (GoogleAppTranslator.class) {
                if (instance == null) {
                    instance = new GoogleAppTranslator();
                }
            }
        }
        return instance;
    }

    public Result translate(String text, String from, String to) throws Exception {
        var r = app.nekogram.translator.GoogleAppTranslator.getInstance().translate(text, from, to);
        Result out = new Result();
        out.translation = r.translation;
        return out;
    }

    public static class Result {
        public String translation;
    }
}
