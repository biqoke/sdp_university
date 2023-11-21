class EnglishRussianDictionaryFactory implements DictionaryFactory {
    @Override
    public Dictionary createDictionary() {
        return new EnglishRussianDictionary();
    }
}