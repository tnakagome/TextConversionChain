package nx.domain.tcc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.nio.charset.Charset;

import org.junit.Test;

public class EncodingTest {
    @Test
    public void ISO_2022_JP_test() {
        Charset c = Charset.forName(Encoding.ISO_2022_JP.name);
        assertNotNull(c);
        assertEquals("ISO-2022-JP", c.displayName());
    }

    @Test
    public void EUC_JP_test() {
        Charset c = Charset.forName(Encoding.EUC_JP.name);
        assertNotNull(c);
        assertEquals("EUC-JP", c.displayName());
    }

    @Test
    public void SJIS_test() {
        Charset c = Charset.forName(Encoding.SJIS.name);
        assertNotNull(c);
        assertEquals("Shift_JIS", c.displayName());
    }

    @Test
    public void UTF8_test() {
        Charset c = Charset.forName(Encoding.UTF8.name);
        assertNotNull(c);
        assertEquals("UTF-8", c.displayName());
    }
}
