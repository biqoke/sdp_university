import java.io.*;
import java.nio.charset.StandardCharsets;

class EnglishRussianDictionary implements Dictionary {
    private static final String DICTIONARY_FILE_PATH = "dictionary.txt";

    @Override
    public void addWord(Word word) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DICTIONARY_FILE_PATH, true))) {
            writer.println(word.getEnglishWord() + "," + word.getRussianTranslation());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String translate(String englishWord) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(DICTIONARY_FILE_PATH), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equalsIgnoreCase(englishWord)) {
                    return parts[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Перевод невозможен";
    }
}
