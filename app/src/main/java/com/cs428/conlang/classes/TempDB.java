import java.util.HashMap;
import java.util.Map;

public class TempDB {

    private static TempDB instance = null;
    Map<String, Word> words;

    private TempDB() {
        words = new HashMap<String, Word>();
    }

    public static synchronized TempDB getInstance() {
        if (instance == null) {
            instance = new TempDB();
        }
        return instance;
    }

    public void insert(Word word) {
        words.put(word.getLatinizedSpelling(), word);
    }

    public Word find(String latinizedSpelling) {
        return words.get(latinizedSpelling);
    }

    public void remove(String latinizedSpelling) {
        words.remove(latinizedSpelling);
    }
}
