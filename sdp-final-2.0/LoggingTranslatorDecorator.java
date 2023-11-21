public class LoggingTranslatorDecorator implements Translator {
    private Translator translator;

    public LoggingTranslatorDecorator(Translator translator) {
        this.translator = translator;
    }

    @Override
    public String translateToRussian(String englishWord) {
        long startTime = System.currentTimeMillis();
        String translation = translator.translateToRussian(englishWord);
        long endTime = System.currentTimeMillis();
        System.out.println("Перевод слова '" + englishWord + "' занял " + (endTime - startTime) + " миллисекунд.");
        return translation;
    }

    @Override
    public long getLastTranslationTime() {
        return translator.getLastTranslationTime();
    }
}
