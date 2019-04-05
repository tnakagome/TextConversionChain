<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*,java.time.ZonedDateTime,nx.domain.tcc.*" %>
<!doctype html>
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=utf-8" />
<TITLE>Text Conversion Chain Usage</TITLE>
<LINK rel=stylesheet type="text/css" href="usage.css" />
</HEAD>
<BODY>
<H3>Text Formats</H3>
<P>
<TABLE>
<COL width="270px"><COL width="630px">
<TR><TH>Value Type</TH><TH>Format</TH></TR>
<TR>
<TD>Date/Time</TD>
<TD><%= System.getProperty("dateTimeFormat") %>
(See <A href="https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#patterns">here</A> for details.)</TD>
</TR>
<TR>
<TD>Date/Time (millisecond)</TD>
<TD><%= System.getProperty("millisecDateTimeFormat") %>
(See <A href="https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#patterns">here</A> for details.)</TD>
</TR>
<TR>
<TD>Date/Time (microsecond)</TD>
<TD><%= System.getProperty("microsecDateTimeFormat") %>
(See <A href="https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#patterns">here</A> for details.)</TD>
</TR>
<TR>
<TD>Hexadecimal</TD>
<TD>Should not be prefixed with "0x". Use the "Remove 0x" converter to remove it from source.</TD>
</TR>
</TABLE>
<P>
Local date-time is interpreted according to this server's time zone:
<%= ZonedDateTime.now().getZone() %> (<%= ZonedDateTime.now().getOffset() %>).
<H3>Converters</H3>
<TABLE>
<COL width="270px"><COL width="630px">
<TR><TH>Converter</TH><TH>Description</TH>
<%
Converters converters = (Converters)application.getAttribute("converters");
Iterator<String> it = converters.getSelectorEntries().iterator();
while (it.hasNext()) {
    AbstractConverter converter = converters.get(it.next());
    if (converter.signature == "Null" || converter.signature == "Empty")
        continue;
    out.write("<tr><td>");
    out.write(converter.displayString);
    out.write("</td><td>");
    String help = converter.getShortHelp();
    if (help == null || help.length() == 0)
        help = "&nbsp;";
    out.write(help);
    out.write("</td></tr>\n");
}
%>
</TABLE>
</BODY>
</HTML>
