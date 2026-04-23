package app.avegram.translator;

public class DeepLTranslator {

    private static volatile DeepLTranslator instance;

    private DeepLTranslator() {
    }

    public static DeepLTranslator getInstance() {
        if (instance == null) {
            synchronized (DeepLTranslator.class) {
                if (instance == null) {
                    instance = new DeepLTranslator();
                }
            }
        }
        return instance;
    }

    public Result translate(String text, String from, String to) throws Exception {
        var r = app.nekogram.translator.DeepLTranslator.getInstance().translate(text, from, to);
        Result out = new Result();
        out.translation = r.translation;
        return out;
    }

    public static class Result {
        public String translation;
    }
}
