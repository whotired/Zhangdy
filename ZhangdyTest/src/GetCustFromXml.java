import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xpath.domapi.XPathEvaluatorImpl;
import org.w3c.dom.Document;
import org.w3c.dom.xpath.XPathNSResolver;
import org.w3c.dom.xpath.XPathResult;


public class GetCustFromXml {
	static String GET_XMDETAILS = "SELECT SNAPSHOT FROM SHOP390.TORDERDISPLAY WHERE ORDERID = ? ";
	static String CUST_XPATH = "//td[@headers='CustomerNumber']/child::text()";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xml = "<table style='margin-left:10px;width:555px' border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"ibm-data-table\" summary=\"Order basics table\"><tr><th id=\"DateModified\" scope=\"col\" class=\"ibm-table-row\"  style=\"white-space:nowrap\"><b>Last modified</b></th><td headers=\"DateModified\" style=\"width:100%\">2013-09-03 10.22.44</td></tr><tr><th id=\"CustomerNumber\" scope=\"col\" class=\"ibm-table-row\"  style=\"white-space:nowrap\"><b>Customer number</b></th><td headers=\"CustomerNumber\" style=\"width:100%\">327600</td></tr></table>";
		GetCustFromXml getXml = new GetCustFromXml();
		String cust = getXml.parseXml(xml);
		System.out.println(cust);
	}
	public String parseXml(String xmlDetail){
		if (null == xmlDetail) {
            return "";
        }
		String custNum = "";
        Document requestInDom = buildDoc(xmlDetail);
        XPathEvaluatorImpl evaluator = new XPathEvaluatorImpl(requestInDom);
        XPathNSResolver resolver = evaluator.createNSResolver(requestInDom.getDocumentElement());
        XPathResult stringResult = null;
        String resultHolder = null;

        stringResult = (XPathResult) evaluator.evaluate(CUST_XPATH, requestInDom, resolver,
                XPathResult.STRING_TYPE, null);
        resultHolder = stringResult.getStringValue();
        if (null != resultHolder && !"".equals(resultHolder)) {
            
        	custNum = resultHolder.trim();
        }
        return custNum;
	}
//	public String getCustXmlDetail(String orderid) {
//		DBAccess dbAccess = null;
//        String detail = null;
//        try {
//            dbAccess = new DBAccess();
//            dbAccess.openConnection(ShopzDatabase.SHOPZ);
//            DBStatement dbstmt = new DBStatement(GET_XMDETAILS);
//            dbstmt.setValue(1, orderid);
//            char[] clob = dbAccess.sendClobQuery(dbstmt, ShopzDatabase.SHOPZ);
//            detail = (clob == null) ? null : new String(clob);
//        } catch (CannotOpenConnectionException e) {
//            e.printStackTrace();
//        } catch (Exception e){
//        	e.printStackTrace();
//        }
//        finally {
//        	try {
//                dbAccess.closeConnection(ShopzDatabase.SHOPZ);
//            } catch (DBAccessException e1) {
//            }
//        }
//        return detail;
//	}
	protected Document buildDoc(String xmlDetails)  {
        Document requestInDom = null;
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlDetails
                    .getBytes());
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            requestInDom = builder.parse(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestInDom;
    }
}
