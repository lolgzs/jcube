package jcube;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public class JCube {

	/**
	 * @param args
	 * @throws TransformerException 
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws XPathExpressionException 
	 */
	public static void main(String[] args) throws XPathExpressionException, IOException, SAXException, ParserConfigurationException, TransformerException {
		System.out.println((new SVGCubeFile(args[0])).fusion(args[1]));
	}

}
