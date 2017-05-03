package nx.domain.tcc.converters;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;

import nx.domain.tcc.AbstractConverter;

public class EntityReferenceConverter extends AbstractConverter {

    private static HashMap<Character, String> targetCharMap;

    static {
        targetCharMap = new HashMap<Character, String>();
        targetCharMap.put(' ',  "&nbsp;");
        targetCharMap.put('<',  "&lt;");
        targetCharMap.put('>',  "&gt;");
        targetCharMap.put('"',  "&quot;");
        targetCharMap.put('\'', "&apos;");
        targetCharMap.put('&',  "&amp;");
    };

    public EntityReferenceConverter() {
        super("EntityReference", "text → HTML entity reference");
        this.shortHelp = "Encode space, <, >, \" and & into HTML character entity reference like \"&amp;nbsp;\".";
    }

    @Override
    public String convert(String source) {
        StringBuilder buffer = new StringBuilder(source.length() * 2);
        StringCharacterIterator it = new StringCharacterIterator(source);
        for (char c = it.first(); c != CharacterIterator.DONE; c = it.next()) {
            String replacement = targetCharMap.get(c);
            if (replacement != null)
                buffer.append(replacement);
            else
                buffer.append(c);
        }
        return buffer.toString();
    }

}
