package jcube;

import javax.xml.xpath.XPathExpressionException;

public interface IFacesVisitor {

	public abstract void visitFace(Face face, Integer i)
			throws XPathExpressionException;

}