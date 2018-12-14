package _00_Java.XML;
import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DemoXML {
	/*
	//利用DOM4J输出XML文件
	public static void main(String[] args) throws Exception {
		// 1.定义要输出的数据内容;
		String ids [] = new String [] {"001","002"};
		String names [] = new String [] {"PP" , "DD"};
		String ages [] = new String [] {"22" , "33"};
		String tels [] = new String [] {"110" , "119"};
		// 2.定义一个文档保存要输出的数据;
		Document document = DocumentHelper.createDocument();
		// 3.向document对象中增加元素;
		Element contractElement = document.addElement("contract");
		// 4.使用循环进行子元素的追加
		for (int x = 0 ; x < ids.length ; x ++) {
			// 在contractElement元素下增加memberElement元素;并在memberElement元素中增加属性名称及属性内容;
			Element memberElement = contractElement.addElement("member");
			memberElement.addAttribute("id", ids[x]);
			// 在memberElement元素下增加nameElement元素;并在nameElement元素中增加文本内容;
			Element nameElement = memberElement.addElement("name");
			nameElement.addText(names[x]);
			// 在memberElement节点下创建节点 ageElement;并在ageElement元素中增加文本内容;
			Element ageElement = memberElement.addElement("age");
			ageElement.addText(ages[x]);
			// 在memberElement节点下创建节点telElement;并在telElement元素中增加文本内容;
			Element telElement = memberElement.addElement("tel");
			telElement.addText(tels[x]);
		}
		// 5.准备进行文档输出,进行输出格式化;并设置输出编码;
		//OutputFormat outputFormat = OutputFormat.createCompactFormat();
		OutputFormat outputFormat = OutputFormat.createPrettyPrint();
		outputFormat.setEncoding("UTF-8");
		// 6.定义输出文件位置;并进行输出;输出完成后关闭资源;
		File file = new File("D:" + File.separator + "pp.xml");
		XMLWriter writer = new XMLWriter(new FileOutputStream(file),outputFormat);
		writer.write(document);
		writer.close();
	}
	*/
	
	//利用DOM4J读取XML文件
	public static void main(String args []) throws Exception {
		// 1.设置读取的文件路径;
		File file = new File("D:" + File.separator + "pp.xml");
		// 2.定义SAX解析器读取;
		SAXReader sax = new SAXReader();
		// 3.将读取的XML文件转化为[Document]对象;
		Document document =sax.read(file);	//读取整个文档数据;
		// 4.取得[Document]对象中根元素
		Element rootElement = document.getRootElement();
		// 5.取得指定名称的所有子元素,返回[Iterator]对象;
		Iterator<Element> iter = rootElement.elementIterator("member");
		while (iter.hasNext()) {
			Element member = iter.next();
			// 取得member元素中的"id"属性的内容;
			System.out.println("id = " + member.attributeValue("id"));
			// 取得member元素中"name"、"age"、"tel"子元素的文本内容;
			System.out.println("name = " + member.elementText("name"));
			System.out.println("age = " + member.elementText("age"));
			System.out.println("tel = " + member.elementText("tel"));
		}
	}
}

/*
====================XML、DOM、SAX、DOM4J

==========XML(eXtend Mark Language)扩展标记语言
=====XML和HTML
	HTML标签元素是固定的,用户无法使用自定义的标签,扩展性不足(JSP中提供的标签编程,目的就是扩充标签解决此问题);
	XML扩展标记语言,其中的元素标签可以实现自定义,且可以明确的表示元素中内容的作用;是标准结构化的程序结构,每一个元素中应填写的内容都已经明确的标记出来了;
	XML专注于配置文件的编写、数据的传输;
=====XML语法定义要求
	第一部分(前导声明)=定义XML公共属性
		语句=[<?xml version="1.0" encoding="UTF-8"?>](固定写法);"version"表示XML的版本,从发展开始到现在一直都是"1.0";"encoding"表示XML文件编码,统一都是"UTF-8";
	第二部分(代码主体)=编写程序的核心元素
		XML文件只能有唯一一个根节点;
		所有的节点必须完结,例=<元素></元素>或<元素/>;
		每个元素下可以包含多个任意多个子元素(建议不超过3层);
		每个元素中定义的文字信息,XML也会将其作为节点;
		可以为元素设置属性=多个属性使用空格分开,属性内容必须使用双引号“"”声明;例=[<div id="mydiv">],其中的"div"是元素,"id"是属性;
		特殊符号需要转义，如：“<”=“&lt”;、“>”=“&gt;”、“"”=“&quot;”、“'”=“&apos”、“&”=“$amps;”;
		文档注释=<![CDATA[此处是注释内容]]>

==========DOM(Document Object Model)文档对象模型
	说明=XML文件都是以一种树状的形式显示,W3C定义有一个与XML显示结构类似的DOM树的开发模式,实现DOM解析;DOM可以实现XML或HTML中元素的动态处理;
		DOM会将XML文件中的根元素、子元素、属性、元素内容文本都看作为[Node]节点,然后将这些节点转化为DOM树的结构(详见截图);DOM解析的核心类,包=[org.w3c.dom]
	拆解说明=[Node]父接口主要有4个子接口,[Document]操作文档,[Element]操作元素,[Attr]操作属性,[Text]操作文本;
=====文档解析工厂类=[DocumentBuilderFactory]=[javax.xml.parsers.DocumentBuilderFactory]
	说明=须先通过[DocumentBuilderFactory]和[DocumentBuilder]类创建[Document]对象,然后对其中元素、子元素、属性等操作;此类的构造方法使用了"protected"权限声明,属于构造封装;
	方法=取得[DocumentBuilderFactory]类的实例化对象=[public static DocumentBuilderFactory newInstance()]
	方法=取得[DocumentBuilder]类的实例化对象=[public abstract DocumentBuilder newDocumentBuilder() throws ParserConfigurationException]
=====文档解析类=[DocumentBuilder]=[javax.xml.parsers.DocumentBuilder]
	方法=
		创建一个新文档=[public abstract Document newDocument()]
		从文档文件解析文档=[public Document parse(File f) throws SAXException,IOException]
		从输入流解析文档=[public Document parse(InputStream is) throws SAXException,IOException]
=====节点接口=[Node]=[org.w3c.dom Interface Node]
	说明=DOM中将所有的内容(元素、属性、文本内容等)都看作是[Node]对象;[Node]接口是文档中所有操作的父接口;
		主要子接口=[Document]、[Element]、[Attr]、[Text],所以这些接口都可以使用[Node]父接口的方法;
	方法=
		追加子节点=[public Node appendChild(Node newChild) throws DOMException]
		取得一个节点的所有子节点=[public NodeList getChildNodes()]
		取得第一个子节点=[public Node getFirstChild()];
		取得最后一个子节点=[public Node getLastChild()]
		取得节点名称=[public String getNodeName()]
		取得节点类型=[public short getNodeType()]
		取得节点内容=[public String getNodeValue() throws DOMException]
		取得父节点=[public Node getParentNode()]
		判断是否有子节点=[public boolean hasChildNodes()]
		删除子节点=[public Node removeChild(Node oldChild) throws DOMException]
		替换子节点=[public Node replaceChild(Node newChild,Node oldChild) throws DOMException]
		设置节点内容=[public void setNodeValue(String nodeValue) throws DOMException]
=====[NodeList]接口=[org.w3c.dom Interface NodeList]
	说明=[NodeList]接口包含多个[Node]接口对象;
	方法=
		取得节点个数=[public int getLength()];
		取得指定索引的节点对象=[public Node item(int index)];
			返回值是[Node]节点,可强制向下转型为[Document]、[Element]、[Attr]、[Text]接口对象;
=====文档操作接口=[Document]=[org.w3c.dom Interface Document]=[public interface Document extends Node]
	说明=[Document]接口操作DOM树及实际操作(也就是说*.xml文件在程序中使用[Document]描述)，DOM树上的所有元素都是通过Node接口描述的;此接口继承自[org.w3c.dom Interface Node]父接口;
	方法=
		创建元素=[public Element createElement(String tagName) throws DOMException]
			返回值是[Element]接口对象;
		创建属性=[public Attr createAttribute(String name) throws DOMException]
			返回值是[Attr]接口对象;
		创建文本=[public Text createTextNode(String data)]
			返回值是[Text]接口对象;
		取得指定名称的元素=[public NodeList getElementsByTagName(String tagname)]
			返回值是[NodeList]接口对象;
=====元素操作接口=[Element]=[org.w3c.dom Interface Element]=[public interface Element extends Node]
	方法=
		取得指定属性的内容=[public String getAttribute(String name)]
		取得指定属性节点对象=[public Attr getAttributeNode(String name)]
		查询当前元素下的指定元素的名称全部对象=[public NodeList getElementsByTagName(String name)]
			返回值是[NodeList]接口对象;
		取得标签名称=[public String getTagName()]
		判断指定属性是否存在=[public boolean hasAttribute(String name)]
		删除属性=[public void removeAttribute(String name) throws DOMException]
		删除属性内容=[public Attr removeAttributeNode(Attr oldAttr) throws DOMException]
		设置属性及内容=[public void setAttribute(String name,String value) throws DOMException]
=====属性操作接口=[Attr]=[org.w3c.dom Interface Attr]
	方法=
		取得属性名称=[public String getName()]
		取得属性内容=[public String getValue()]
		设置属性内容=[public void setValue(String value) throws DOMException]
=====读取XML文件
	说明=读取XML文件就是一个核心的解析过程,解析(读取)XML文件就是要将读取的数据转化为DOM树保存;
	注意=目标是取得节点的内容,那么不应是元素节点,而是要取得文本节点,然后再使用取得节点内容方法[getNodeValue()],取得的是字符串数据,
	总结=	[Document]中的[getElementsByTagName()]方法是以整个XML文件为目标进行查找的;
			[Element]中的[getElementsByTagName()]方法是以当前元素为目标进行查找的;
			[NodeList]返回的类型([item()]方法)是Node接口对象,须根据实际情况转型;
			可以取得节点名字及父节点;
=====生成XML文件(了解)
	说明=DOM规定了解析XML文件的操作,流程=[DocumentBuilderFactory]->[DocumentBuilder]->[Document],但未规定输出操作;DOM树转换为XML文件输出这个操作本身不是重点,
		主要是观察掌握[Node]接口的各个子接口先后关系=元素创建、文本节点创建、元素追加。可以使用如下几个类实现XML文件的输出=
		输出转换工厂类=[javax.xml.transform.TransformerFactory]
			方法=
				实例化本类对象=[public static TransformerFactory newInstance(String factoryClassName,ClassLoader classLoader) throws TransformerFactoryConfigurationError]
				取得[Transformer]类对象=[public abstract Transformer newTransformer() throws TransformerConfigurationException]
				取得[Transformer]类对象=[public abstract Transformer newTransformer(Source source) throws TransformerConfigurationException]
		转换工具类=[javax.xml.transform.Transformer]
			方法=
				设置输出属性=[public abstract void setOutputProperty(String name,String value) throws IllegalArgumentException]
				转换输出=[public abstract void transform(Source xmlSource,Result outputTarget) throws TransformerException]
		数据源操作接口=[javax.xml.transform Interface Source]
		此接口子类=[javax.xml.transform.dom.DOMSource]
			此类构造方法=[public DOMSource(Node n)];接受参数[Node];
		设置输出位置接口=[javax.xml.transform Interface Result]
		此接口的子类=[javax.xml.transform.stream.StreamResult],可以实现通过IO流保存;
			此类构造方法-设置输出的位置=[public void setOutputStream(OutputStream outputStream)];接收参数[OutputStream];
=====修改XML文件
	说明=修改XML文件和读取XML、生成XML一样，都是操作DOM树的内容;
	修改操作-删除=如果想要删除一个元素,前提是找到该元素的父元素,才能执行删除;
		取得父节点=使用[Node]接口的[getParentNode()]方法取得;
		删除子节点=使用[Node]接口的[removeChild()]方法;
	注意=因为DOM树是动态维护的,一个节点删除之后索引数据也会重新建立,如删除了第1个后,第2个就变成了第1个,所以循环删除节点时,应固定删除第1个;
	截图=删除子节点;将元素的属性转换为该元素的子元素保存;
=====读取、生成、修改XML文件总结=
	说明=读取、生成、修改XML文件,都是操作DOM树;但如果一个XML文件很大(如4GB)时,想要使用DOM进行读取操作,需要将DOM变为DOM树,而DOM树是保存在内存中的,
	则会因为内存问题无法操作;通过DOM读取XML文件只适合读取小型的XML文件(1MB以内);

==========SAX解析(Sample API for XML)简单API的XML解析工具
	说明=W3C组织只定义了DOM操作标准,但是DOM存在的问题是=如果想要解析(读取)XML文件,需在内存中形成DOM树,正是因为在DOM树存在于内存中,所以DOM操作不适合读取大文件;
		民间开发的XML解析标准=SAX解析;SAX使用顺序式的方式进行文件读取,所有的内容不是一次性读取到内存中,解决的DOM解析的缺点;
		使用SAX解析,须定义一个属于自己的SAX解析器工具类,此类须继承一个特定的父类[DefaultHandler],可以覆写父类的方法,才可以成为一个SAX解析器;
=====[DefaultHandler]=[org.xml.sax.helpers.DefaultHandler]
	方法=
		开始读取文档=[public void startDocument() throws SAXException]
		开始读取元素=[public void startElement(String uri,String localName,String qName,Attributes attributes) throws SAXException]
		元素内容=[public void characters(char[] ch,int start,int length) throws SAXException]
		结束读取元素=[public void endElement(String uri,String localName,String qName) throws SAXException]
		结束读取文档=[public void endDocument() throws SAXException]
	同时需要如下类进行加载XML文件操作;
=====SAX解析器工厂类=[javax.xml.parsers.SAXParserFactory]=[public abstract class SAXParserFactory extends Object]
	说明=此类构造方法被私有化了,须使用如下方法=
		取得工厂类对象=[public static SAXParserFactory newInstance()]
		取得SAX解析器类[SAXParser]对象=[public abstract SAXParser newSAXParser() throws ParserConfigurationException,SAXException]
=====SAX解析器=[javax.xml.parsers.SAXParser]
	设置要解析的XML文件=[public void parse(File f,DefaultHandler dh) throws SAXException, IOException]
	设置要解析的XML输入流=[public void parse(InputSource is,DefaultHandler dh) throws SAXException,IOException]
=====SAX解析总结
	说明=SAX解析过程中,遇到开始元素就会触发[startElement()]方法,元素内有内容就会触发[characters()]方法,如果内容为空则输出空内容(不是NULL),遇到元素结束就会触发[endElement()]方法,
=====SAX解析器应用=SAX与简单JAVA类
	说明=简单Java类的结构与XML文件的结构组成是一样的,XML文件里面可能存在多个简单Java类对象,可以将XML文件的内容转化为Java类,使用集合保存输出;
		SAX解析只能用来读取,不能修改;

==========DOM4J
	说明=DOM4J产生的背景,就是解决了DOM和SAX的缺点,同时具有较好的读取和修改数据功能;DOM4J=[dom4j-1.6.1.jar]是第三方的开发程序,需要配置到CLASSPATH中;
		DOM4J的API文档=[https://www.oschina.net/uploads/doc/dom4j-1.6.1/index.html]
		[DocumentHelper]Document创建类=[org.dom4j.DocumentHelper]
			在DOM中,Document的创建需要[DocumentBuilderFactory]和[DocumentBuilder]两个类,使用较麻烦;
			在DOM4J,Document的创建由[DocumentHelper]类完成;
		[Document]操作接口=[org.dom4j Interface Document]=[public interface Document extends Branch]
		[Element]操作接口=[org.dom4j Interface Element]=[public interface Element extends Branch]
			[Document]和[Element]继承自[Branch]接口;
		[Branch]分支接口=[org.dom4j Interface Branch]=[public interface Branch extends Node]
			[Branch]继承自[Node]接口;
		[Node]节点接口=[org.dom4j Interface Node]=[public interface Node extends Cloneable]
=====[DocumentHelper]=创建工具类[org.dom4j.DocumentHelper]
	说明=此类可以创建Document、Element、Attribute各个对象;DOM4J在创建Document对象时简化了DOM中的Text对象;
	方法=
		创建文档[Document]对象=[public static Document createDocument()]
		创建文档[Document]对象,同时设置根元素[public static Document createDocument(Element rootElement)]
		创建元素[Element]对象=[public static Element createElement(String name)]
		创建属性[Attribute]对象=[public static Attribute createAttribute(Element owner,String name,String value)]
=====[Document]=操作接口=[org.dom4j Interface Document]
	方法=
		取得根元素=[public Element getRootElement()]
		设置根元素=[public void setRootElement(Element rootElement)]
		设置XML文件编码=[public void setXMLEncoding(String encoding)]
=====[Branch]=分支接口=[org.dom4j Interface Branch]
	方法=
		增加节点对象=[public void add(Node node)]
		增加子元素=[public Element addElement(String name)]
		取得指定索引的节点=[public Node node(int index) throws IndexOutOfBoundsException]
		取得节点个数=[public int nodeCount()]
		删除节点=[public boolean remove(Node node)]
=====[Node]=节点接口=[org.dom4j Interface Node]
	方法=
		取得父节点=[public Element getParent()]
		取得节点的内容=[public String getText()]
		设置节点的内容=[public void setText(String text)]
=====[OutputFormat]数据格式化输出类=[org.dom4j.io.OutputFormat]
	方法=
		紧凑型输出=[public static OutputFormat createCompactFormat()];标准输出,输出的文件没有换行;
		好看型输出=[public static OutputFormat createPrettyPrint()];
		设置输出编码=[public void setEncoding(String encoding)]
=====[XMLWriter]=输出数据类=[org.dom4j.io.XMLWriter]
	方法=
		构造方法=[public XMLWriter(OutputStream out,OutputFormat format) throws UnsupportedEncodingException]
		内容输出=[public void write(Document doc) throws IOException]
=====利用DOM4J输出XML文件
	例=详见本类;
=====利用DOM4J读取XML文件
	说明=读取XML文件,使用SAX读取比较方便,在DOM4J中特别内置了SAX解析器专门用于读取XML文件;
	[SAXReader]=SAX解析器类=[org.dom4j.io.SAXReader]
		方法=
			读取文件转化为[Document]对象返回=[public Document read(File file) throws DocumentException]
			读取输入流转化为[Document]对象返回=[public Document read(InputStream input) throws DocumentException]
	[Element]=读取元素接口=[org.dom4j Interface Element]
		方法=
			取得所有子元素,返回[Iterator]=[public Iterator elementIterator()]
			取得所有子元素,返回[List]=[public List elements()]
			取得指定名称的所有子元素,返回[Iterator]=[public Iterator elementIterator(String name)]
			取得指定名称的所有子元素,返回[List]=[public List elements(String name)]
			取得元素内容=[public String elementText(String name)]
			去掉左右空格后取得元素内容=[public String elementTextTrim(String name)]
			删除属性=[public boolean remove(Attribute attribute)]
			取得属性内容=[public String attributeValue(String name)]
	例=详见本类;
=====总结
	DOM4J=DOM可修改XML文件的特点 + SAX读取大文件的特点;
	使用DOM4J工作实现读取和输出XML文件,较直接使用DOM和SAX简单;以后此类操作都建议使用DOM4J完成;HTML文件无法使用DOM4J;

=====HTML、JavaScript和DOM操作
	说明=HTML文件都存在一个根元素"<heml>",HTML文档内容都在"<body>"元素中定义;如果要操作一个HTML文件,须先将其转化为DOM树的结构;
		观察截图[13015_HTML与DOM树.JPG],发现HTML文件也是一颗DOM树,可以使用所有DOM标准方法(包=org.w3c.dom)进行操作;
=====利用JavaScript取得HTML元素
	说明=JavaScript中能使用的函数,在[org.w3c.dom]这个包中的都支持,所以可以使用JavaScript(DOM)操作HTML文档;可以在此包中查找要使用的方法;如下面的方法=
	文档操作接口=[Document]=[org.w3c.dom Interface Document]
		在整个文档中取得指定ID的元素=[public Element getElementById(String elementId)]
		在整个文档中取得指定名称的元素=[public NodeList getElementsByTagName(String tagname)]
	元素操作接口=[Element]=[org.w3c.dom Interface Element]
		取得该元素中指定名称的子元素=[public NodeList getElementsByTagName(String name)]
	JavaScript中函数=
		动态绑定事件=[元素名称.addEventListener("事件类型",处理函数,处理阶段{false})];处理阶段指冒泡时处理或触发时处理;例=[button.addEventListener("click",show,false)]
	注意=[NodeList]和JavaScript对应的函数名称不同=
		[NodeList]方法=[getLength()];
		JavaScript函数=[length];
	总结=使用JavaScript(DOM)操作HTML文档,以后编写程序,就不应该出现固定的事件绑定了,应该动态绑定事件,且如果元素过多(如100个按钮),可以实现自动生成元素;
=====动态创建下拉菜单
	说明=例=[DemoJava\WebRoot\pages_dom\js_dom.html]
=====动态操作表格
	说明=动态操作表格,建议先定义好表格元素,只使用DOM操作表格中的"<tr>"和"<td>"元素;
		例=[DemoJava\WebRoot\pages_dom\js_dom.html]
=====总结
	总结=DOM操作离不开创建元素、追加节点、删除节点、取出节点操作;
	利用JavaScript和DOM操作,对HTML页面的很容易实现动态效果;
*/

/*
=====问题=HTML和XML的区别?
	HTML中元素是固定的;			HTML中的元素主要负责页面显示;
	XML中的元素是由用户自定义的;	XML中的元素主要负责数据结构的描述;
=====问题=DOM和SAX的区别?
	DOM和SAX都是XML解析(读取)的标准方式,
	DOM(Document Object Model)文档对象模型,是W3C定义的标记语言的标准操作,在DOM操作中须将标记转换为内存中的DOM树进行处理,DOM可以实现数据的读取与修改功能,DOM不能读取大型文件;
	SAX(Sample API for XML)简单API的XML解析工具,采用顺序式的方式进行文档数据读取,适合于读取大型文档数据,但是SAX只能读取不具备修改文档功能;
*/

/*
=====问题=HTML和XML的区别?
	HTML中元素是固定的;			HTML中的元素主要负责页面显示;
	XML中的元素是由用户自定义的;	XML中的元素主要负责数据结构的描述;
=====问题=DOM和SAX的区别?
	DOM和SAX都是XML解析(读取)的标准方式,
	DOM(Document Object Model)文档对象模型,是W3C定义的标记语言的标准操作,在DOM操作中须将标记转换为内存中的DOM树进行处理,DOM可以实现数据的读取与修改功能,DOM不能读取大型文件;
	SAX(Sample API for XML)简单API的XML解析工具,采用顺序式的方式进行文档数据读取,适合于读取大型文档数据,但是SAX只能读取不具备修改文档功能;
*/

/*
=====补充=
	补充1=在定义XML时还会用到另两门技术
		DTD=文档定义结构,指按照顺序定义文档;
		Schema=使用XSD的方式定义的模式匹配,里面的元素顺序可以由用户决定;
*/