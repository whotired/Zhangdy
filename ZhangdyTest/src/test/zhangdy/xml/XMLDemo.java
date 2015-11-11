package test.zhangdy.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**  
*  
* @author wangxiao  
* DOM生成与解析XML文档  
*/   
public class XMLDemo {   
    private static Document document;   
    private String fileName;   
    public static void init() {   
        try {   
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
            DocumentBuilder builder = factory.newDocumentBuilder();   
            document = builder.newDocument();   
        } catch (ParserConfigurationException e) {   
            System.out.println(e.getMessage());   
        }   
    }   
    public static String createXml(String fileName, String ToUserName, String FromUserName, String CreateTime, String MsgType, String Content, String FuncFlag) {   
    	Element root = document.createElement("xml");   
        document.appendChild(root);   
          
        Element toUserName = document.createElement("ToUserName");  
        toUserName.appendChild(document.createCDATASection(ToUserName));   
        root.appendChild(toUserName);  
  
        Element fromUserName = document.createElement("FromUserName");  
        fromUserName.appendChild(document.createCDATASection(FromUserName));   
        root.appendChild(fromUserName);  
          
        Element createTime = document.createElement("CreateTime");  
        createTime.appendChild(document.createTextNode(String.valueOf(new Date().getTime())));   
        root.appendChild(createTime);  
          
        Element msgType = document.createElement("MsgType");  
        msgType.appendChild(document.createCDATASection(MsgType));   
        root.appendChild(msgType);  
          
        Element content = document.createElement("Content");  
        content.appendChild(document.createCDATASection(Content));   
        root.appendChild(content);  
          
        Element funcFlag = document.createElement("FuncFlag");  
        funcFlag.appendChild(document.createCDATASection(FuncFlag));   
        root.appendChild(funcFlag); 
          
        TransformerFactory tf = TransformerFactory.newInstance();   
        try {   
//            Transformer transformer = tf.newTransformer();
        	Transformer transformer = TransformerFactory.newInstance()
					.newTransformer(
							new StreamSource("eFFOrder.xsl"));
            DOMSource source = new DOMSource(document); 
            File file = new File("XMLDemo.dtd");
            if (file.exists()) System.out.println("DTD file exists"); 
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "XMLDemo.dtd");
//            transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");   
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");   
            StringWriter writer = new StringWriter();  
            StreamResult result = new StreamResult(writer);   
            transformer.transform(source, result);   
            System.out.println("生成XML文件成功!");   
            return writer.getBuffer().toString();  
        } catch (Exception e) {   
            System.out.println(e.getMessage());   
        }  
        return FuncFlag;   
    }  
    public static void parserXml(InputStream value) {   
        try {   
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();   
            DocumentBuilder db = dbf.newDocumentBuilder();  
            Document document = db.parse(value);   
            NodeList employees = document.getChildNodes();   
            for (int i = 0; i < employees.getLength(); i++) {   
                Node employee = employees.item(i);   
                NodeList employeeInfo = employee.getChildNodes();   
                for (int j = 0; j < employeeInfo.getLength(); j++) {   
                    Node node = employeeInfo.item(j);   
                    NodeList employeeMeta = node.getChildNodes();   
                    for (int k = 0; k < employeeMeta.getLength(); k++) {   
                    System.out.println(node.getNodeName() + ":" + employeeMeta.item(k).getTextContent());   
                    }   
                }   
            }   
            System.out.println("解析完毕");   
        } catch (FileNotFoundException e) {   
            System.out.println(e.getMessage());   
        } catch (ParserConfigurationException e) {   
            System.out.println(e.getMessage());   
        } catch (SAXException e) {   
            System.out.println(e.getMessage());   
        } catch (IOException e) {   
            System.out.println(e.getMessage());   
        }   
    }   
//public static void createXml(String fileName, String ToUserName, String FromUserName, String CreateTime, String MsgType, String Content, String FuncFlag) {     
    public static void main(String[] args) {  
      XMLDemo.init();  
      String str = XMLDemo.createXml("D:/demo2.xml","ToUserName<>", "FromUserName&", "CreateTime", "MsgType", "Content", "FuncFlag");  
      System.out.println(str);  
          
//      String line = "<xml><ToUserName><![CDATA[gh_d306a11695ae]]></ToUserName>";  
//       String linenew = line.replace("<![CDATA[", "").replace("]]>", "");  
//           
//         String key = linenew.substring(1, linenew.indexOf(">"));  
//         String value = linenew.substring(key.length()+2, linenew.indexOf("</"));  
//         System.out.println(key+"  "+value); 
    	
    	
//        String source = "<xml><ToUserName><![CDATA[oRDIJj7TLbdhBGjEknLLS4lJ_KDE]]></ToUserName><FromUserName><![CDATA[gh_d306a11695ae]]></FromUserName><CreateTime>1359049881672</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[this is testtestetsetsetsetet]]></Content><FuncFlag>0</FuncFlag></xml>";  
//        String key = "Content";  
//        String result = "";  
//          
//        source = source.replace(" ", "").replace("\n", "").replace("\t", "").replace("<![CDATA[", "").replace("]]>", "");  
//        String ftag = "<"+key+">";  
//        String ltag = "</"+key+">";  
//        if(source.contains(ftag) && source.contains(ltag)) {  
//            result = source.substring(source.indexOf(ftag)+ftag.length(), source.indexOf(ltag));  
//        }  
//        System.out.println(result);  
    }  
} 
