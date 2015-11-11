<!-- 
This XSL style sheet is used by the FulfillmentOrderFormatter.createStreamResultXML() 
method to add a DOCTYPE declaration to the top of the StreamResult that is generated.
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml"  cdata-section-elements="ToUserName FromUserName"/>

<xsl:template match="/">

<xsl:copy-of select="node()" />
</xsl:template>


</xsl:stylesheet>
