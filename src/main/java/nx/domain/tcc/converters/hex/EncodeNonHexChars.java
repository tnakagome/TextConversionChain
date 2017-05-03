package nx.domain.tcc.converters.hex;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import nx.domain.tcc.AbstractConverter;

/**
 * Encode characters that are not 0-9 A-F a-f into a hexadecimal string.
 * For example, "{ }" will be converted to "7b207d".
 */
public class EncodeNonHexChars extends AbstractConverter {

    public EncodeNonHexChars() {
        super("EncodeNonHexChars", "Encode non-hexadecimal chars");
        this.shortHelp = "Convert characters into UTF-8 codes. 0-9, A-F, and a-f remain as they are.";
    }

    @Override
    public String convert(String source) {
        StringBuilder buffer = new StringBuilder(source.length() * 2);
        CharacterIterator it = new StringCharacterIterator(source);
        char c = it.first();
        while (c != StringCharacterIterator.DONE) {
            if (isHexadecimalChar(c)) {
                buffer.append(c);
            }
            else {
                byte upper = (byte)((c & 0xf0) >> 4);
                byte lower = (byte)(c & 0x0f);
                buffer.append(String.format("%x%x", upper, lower));
            }
            c = it.next();
        }
        return buffer.toString();
    }

    private final String HEXADECIMAL_CHARS = "0123456789ABCDEFabcdef";

    boolean isHexadecimalChar(final char c) {
        return (HEXADECIMAL_CHARS.indexOf(c) >= 0);
    }
}
