package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class DescribeLayoutButtonSection implements com.sforce.ws.bind.XMLizable , IDescribeLayoutButtonSection{

    /**
     * Constructor
     */
    public DescribeLayoutButtonSection() {}

    /**
     * element : detailButtons of type {urn:partner.soap.sforce.com}DescribeLayoutButton
     * java type: com.sforce.soap.partner.DescribeLayoutButton[]
     */
    private static final com.sforce.ws.bind.TypeInfo detailButtons__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","detailButtons","urn:partner.soap.sforce.com","DescribeLayoutButton",1,-1,true);

    private boolean detailButtons__is_set = false;

    private com.sforce.soap.partner.DescribeLayoutButton[] detailButtons = new com.sforce.soap.partner.DescribeLayoutButton[0];

    @Override
    public com.sforce.soap.partner.DescribeLayoutButton[] getDetailButtons() {
      return detailButtons;
    }

    @Override
    public void setDetailButtons(com.sforce.soap.partner.IDescribeLayoutButton[] detailButtons) {
      this.detailButtons = castArray(com.sforce.soap.partner.DescribeLayoutButton.class, detailButtons);
      detailButtons__is_set = true;
    }

    protected void setDetailButtons(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, detailButtons__typeInfo)) {
        setDetailButtons((com.sforce.soap.partner.DescribeLayoutButton[])__typeMapper.readObject(__in, detailButtons__typeInfo, com.sforce.soap.partner.DescribeLayoutButton[].class));
      }
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       __typeMapper.writeObject(__out, detailButtons__typeInfo, detailButtons, detailButtons__is_set);
    }

    @Override
    public void load(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __typeMapper.consumeStartTag(__in);
      loadFields(__in, __typeMapper);
      __typeMapper.consumeEndTag(__in);
    }

    protected void loadFields(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
        setDetailButtons(__in, __typeMapper);
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[DescribeLayoutButtonSection ");
      sb.append(" detailButtons='").append(com.sforce.ws.util.Verbose.toString(detailButtons)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private <T,U> T[] castArray(Class<T> clazz, U[] array) {
        if (array == null) {
            return null;
        }
        T[] retVal = (T[]) java.lang.reflect.Array.newInstance(clazz, array.length);
        for (int i=0; i < array.length; i++) {
            retVal[i] = (T)array[i];
        }

        return retVal;
	}
}
