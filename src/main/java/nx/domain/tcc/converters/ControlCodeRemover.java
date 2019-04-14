package nx.domain.tcc.converters;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import nx.domain.tcc.AbstractConverter;

public class ControlCodeRemover extends AbstractConverter {
    private static String controlCodes =  new String("\r\n\t");

    public ControlCodeRemover() {
        super("ControlCodeRemover", "Remove control codes");
        this.shortHelp = "Remove control codes like CR, LF, TAB.";
    }

    @Override
    public String convert(String source) {
        StringBuilder buffer = new StringBuilder(source.length() * 2);
        StringCharacterIterator it = new StringCharacterIterator(source);
        for (char c = it.first(); c != CharacterIterator.DONE; c = it.next()) {
        	if (controlCodes.indexOf(c) < 0)
                buffer.append(c);
        }
        return buffer.toString();
    }

}
