package nx.domain.tcc.converters;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nx.domain.tcc.AbstractConverter;
import nx.domain.tcc.converters.hex.HexToUTF8Converter;

public class EntityReferenceDecoderTest {
    @Test
    public void testDecimal() {
        final String input = "&#-29;&#-125;&#-122;&#-29;&#-126;&#-71;&#-29;&#-125;&#-120;";
        AbstractConverter converter = new EntityReferenceDecoder();
        String result = converter.convert(input);
        assertEquals("e38386e382b9e38388", result);
        converter = new HexToUTF8Converter();
        assertEquals("テスト", converter.convert(result));
    }

    @Test
    public void testDecimalWithWords() {
        final String input = "&#-29;&#-125;&#-122;TEST&#-29;&#-126;&#-71;DATA&#-29;&#-125;&#-120;";
        AbstractConverter converter = new EntityReferenceDecoder();
        String result = converter.convert(input);
        assertEquals("e38386TESTe382b9DATAe38388", result);
    }

    @Test
    public void testHexadecimal() {
        final String input = "&#xe3;&#x83;&#x86;&#xe3;&#x82;&#xb9;&#xE3;&#x83;&#x88;";
        AbstractConverter converter = new EntityReferenceDecoder();
        String result = converter.convert(input);
        assertEquals("e38386e382b9e38388", result);
        converter = new HexToUTF8Converter();
        assertEquals("テスト", converter.convert(result));        
    }

    @Test
    public void testHexaecimalWithWords() {
        final String input = "&#xe3;&#x83;&#x86;TEST&#xe3;&#x82;&#xb9;DATA&#xE3;&#x83;&#x88;";
        AbstractConverter converter = new EntityReferenceDecoder();
        String result = converter.convert(input);
        assertEquals("e38386TESTe382b9DATAe38388", result);
    }
}
