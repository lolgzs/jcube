package jcube;

import org.w3c.dom.Element;

public class FaceToSVGVisitor implements IFaceVisitor {

	private Element blocNode;
	private Element templateNode;
	private XMLDocument doc;

	public FaceToSVGVisitor(XMLDocument doc, Element blocNode,
			Element templateNode) {
		this.blocNode = blocNode;
		this.templateNode = templateNode;
		this.doc = doc;
	}

	@Override
	public void visitTitle(String title) {
		this.blocNode.setTextContent(title);
	}

	@Override
	public void visitCheat(int cheatNumber, Cheat cheat) {
		Element cheatNode = (Element) this.templateNode.cloneNode(false);
		this.templateNode.getParentNode().appendChild(cheatNode);

		Float y = cheatNumber * 10
				+ Float.parseFloat(this.templateNode.getAttribute("y"));
		cheatNode.setAttribute("y", y.toString());

		cheat.acceptVisitor(new CheatToSVGVistor(
				this.newCheatTitleNodeOn(cheatNode), 
				this.newCheatContentNodeOn(cheatNode)));
	}

	public Element newCheatContentNodeOn(Element cheatNode) {
		Element content = this.doc.createElement("tspan");
		cheatNode.appendChild(content);
		return content;
	}

	public Element newCheatTitleNodeOn(Element cheatNode) {
		Element title = this.doc.createElement("tspan");
		title.setAttribute("style", "font-weight: bold");
		cheatNode.appendChild(title);
		return title;
	}
}
