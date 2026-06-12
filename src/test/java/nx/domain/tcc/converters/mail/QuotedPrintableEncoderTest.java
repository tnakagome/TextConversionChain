package nx.domain.tcc.converters.mail;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nx.domain.tcc.AbstractConverter;

public class QuotedPrintableEncoderTest {
	@Test
	public void testEncoding1() {
		AbstractConverter encoder = new QuotedPrintableEncoder();
		String result = encoder.convert("⚠");
		assertEquals("=?UTF-8?Q?=E2=9A=A0?=", result);
	}
}
