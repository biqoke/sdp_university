public class DictionaryAdapter implements Translator {
    private Dictionary dictionary;
    private long lastTranslationTime;

    public DictionaryAdapter(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public String translateToRussian(String englishWord) {
        long startTime = System.currentTimeMillis();
        String translation = dictionary.translate(englishWord);
        long endTime = System.currentTimeMillis();
        lastTranslationTime = endTime - startTime;
        return translation;
    }

    @Override
    public long getLastTranslationTime() {
        return lastTranslationTime;
    }
}
