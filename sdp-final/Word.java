class Word {
    private String englishWord;
    private String russianTranslation;

    public Word(String englishWord, String russianTranslation) {
        this.englishWord = englishWord;
        this.russianTranslation = russianTranslation;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public String getRussianTranslation() {
        return russianTranslation;
    }
}