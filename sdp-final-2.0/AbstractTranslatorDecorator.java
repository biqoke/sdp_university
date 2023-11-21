public abstract class AbstractTranslatorDecorator implements Translator {
    private Translator translator;

    public AbstractTranslatorDecorator(Translator translator) {
        this.translator = translator;
    }

    @Override
    public String translateToRussian(String englishWord) {
        return translator.translateToRussian(englishWord);
    }

    @Override
    public long getLastTranslationTime() {
        return translator.getLastTranslationTime();
    }
}
