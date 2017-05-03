package nx.domain.tcc.converters;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;

import nx.domain.tcc.AbstractConverter;

public class ControlCodeConverter extends AbstractConverter {
    private static HashMap<Character, String> codeMap;

    static {
        codeMap = new HashMap<Character, String>();
        codeMap.put('\r', "\\r");
        codeMap.put('\n', "\\n");
        codeMap.put('\t', "\\t");
    }

    public ControlCodeConverter() {
        super("ControlCode", "Visualize control codes");
        this.shortHelp = "Visualize control codes like CR, LF, TAB.";
    }

    @Override
    public String convert(String source) {
        StringBuilder buffer = new StringBuilder(source.length() * 2);
        StringCharacterIterator it = new StringCharacterIterator(source);
        for (char c = it.first(); c != CharacterIterator.DONE; c = it.next()) {
            String replacement = codeMap.get(c);
            if (replacement != null)
                buffer.append(replacement);
            else
                buffer.append(c);
        }
        return buffer.toString();
    }

}
