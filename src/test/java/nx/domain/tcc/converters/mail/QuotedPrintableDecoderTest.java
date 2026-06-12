package nx.domain.tcc.converters.mail;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nx.domain.tcc.AbstractConverter;

public class QuotedPrintableDecoderTest {
	@Test
	public void testDecodeQuotedPrintable1() {
		AbstractConverter decoder = new QuotedPrintableDecoder();
		String result = decoder.convert("=?utf-8?q?=E2=9A=A0=EF=B8=8F=E2=9A=A0=EF=B8=8FYOUR_COMPUTER?=\n"
				+ "=?utf-8?q?_HAS_BEEN_COMPROMISED=2E_CHECK_THIS_MESSAGE_NOW!?=");
		assertEquals("⚠️⚠️YOUR COMPUTER HAS BEEN COMPROMISED. CHECK THIS MESSAGE NOW!", result);
	}
}
