package test.zhangdy;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DOMTest domTest = new DOMTest();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse(new File("bookstore.xml"));//put into project dir
			
			DocumentType dt = dom.getDoctype();
			NamedNodeMap ents = dt.getEntities();
			System.out.println("Document Entities as below");
			for (int i = 0; i < ents.getLength(); i++){
				Node ent = ents.item(i);
				domTest.printNode(ent);
			}
			
			System.out.println("Document nodes as below");
			Node root = dom.getDocumentElement();
			if (dom.hasChildNodes()){
				domTest.getChildInfo(dom);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	public void getChildInfo(Node node){
		printNode(node);
		
		if (node.hasChildNodes()){
			System.out.println(node.getNodeName() + ": sub node as below");
			NodeList list = node.getChildNodes();
			for(int i = 0; i < list.getLength(); i++){
				Node subNode = list.item(i);
				getChildInfo(subNode);
			}
		}
		
		if (node.hasAttributes()){
			System.out.println(node.getNodeName() + ": attributes as below");
			NamedNodeMap atts = node.getAttributes();
			for (int i = 0; i < atts.getLength(); i++){
				Node att = atts.item(i);
				printNode(att);
			}
		}
	}
	public void printNode (Node node){
		System.out.println("node name = " + node.getNodeName());
		System.out.println("node value = " + node.getNodeValue());
		System.out.println("node type = " + node.getNodeType());
	}

}
