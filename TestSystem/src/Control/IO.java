package Control;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import Paper.PType;
import Paper.Page;
import Paper.Record;

public class IO {
	private static SAXBuilder builder = new SAXBuilder();
	
	//清空四个文件
	public static void clear(){
		String si="xml/surveyInfo.xml";
		String ti="xml/testInfo.xml";
		String sri="xml/surveyRecordInfo.xml";
		String tri="xml/testRecordInfo.xml";
		Element rsi=new Element("totalInfo");
		Element rti=new Element("totalInfo");
		Element rsri=new Element("totalInfo");
		Element rtri=new Element("totalInfo");
		try {
			Document doc1=new Document(rsi);
			FileOutputStream out1=new FileOutputStream(si);
			XMLOutputter outputter1 = new XMLOutputter();  
	        Format f1 = Format.getPrettyFormat();  
	        outputter1.setFormat(f1);  
	        outputter1.output(doc1, out1);  
	        out1.close();
	        
	        Document doc2=new Document(rti);
			FileOutputStream out2=new FileOutputStream(ti);
			XMLOutputter outputter2 = new XMLOutputter();  
	        Format f2 = Format.getPrettyFormat();  
	        outputter2.setFormat(f2);  
	        outputter2.output(doc2, out2);  
	        out2.close();
	        
	        Document doc3=new Document(rsri);
			FileOutputStream out3=new FileOutputStream(sri);
			XMLOutputter outputter3 = new XMLOutputter();  
	        Format f3 = Format.getPrettyFormat();  
	        outputter3.setFormat(f3);  
	        outputter3.output(doc3, out3);  
	        out3.close();
	        
	        Document doc4=new Document(rtri);
			FileOutputStream out4=new FileOutputStream(tri);
			XMLOutputter outputter4 = new XMLOutputter();  
	        Format f4 = Format.getPrettyFormat();  
	        outputter4.setFormat(f4);  
	        outputter4.output(doc4, out4);  
	        out4.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//根据page的类型，得到所有的survey或所有的test的名字的列表
	public static List<String> readAllPage(PType pt){
		String filename = "xml/"+pt.getTypeIndex()+"Info.xml";
		Element root=null;
		List<String> pageName = new LinkedList<String>();
		try {
			InputStream input = new FileInputStream(filename);
			Document document = builder.build(input);//获得文档对象
			root = document.getRootElement();//获得根节点
			
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Element> pageList = root.getChildren("pageName");
		for(int i=0; i<pageList.size(); i++){
			pageName.add(pageList.get(i).getText());
		}
		
		return pageName;
	}
	
	//从xml文件中读出对象的方法
	private static List<Object> objectXMLDecoder(String objSource){  
		       
		List<Object> objList = new ArrayList<Object>();
		File fin = new File(objSource);
		try{
			FileInputStream fis = new FileInputStream(fin);   
			XMLDecoder decoder = new XMLDecoder(fis);   
			Object obj = null;   
		  
			while( (obj = decoder.readObject()) != null){   
				objList.add(obj);   
		    }  
			fis.close();   
			decoder.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		        
		return objList;   
	}
	
	//根据page的名字和page的类型，读出一个page对象
	public static Page readPage(String name,PType pt){
		String filename="xml/"+pt.getTypeIndex()+"/"+name+".xml";
		List<Object> objList=null;
		try{
			objList=objectXMLDecoder(filename);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return (Page)objList.get(0);
	}
	
	//在page的信息里面加入一个page
	private static void addPagetoInfo(Page page){
		String pernam=page.getPersonName();
		String pagnam=page.getPageName();
		String filename="xml/"+page.getTypeIndex()+"Info.xml";
		
		Element ele = new Element("pageName");
		ele.setText(pagnam);
		ele.setAttribute("personName", pernam);
		Element root=null;
		try {
			InputStream input = new FileInputStream(filename);
			Document document = builder.build(input);//获得文档对象
			root = document.getRootElement();//获得根节点
			input.close();
			
			root.addContent(ele);
			Document doc=new Document(root);
			FileOutputStream out=new FileOutputStream(filename);
			XMLOutputter outputter = new XMLOutputter();  
	        Format f = Format.getPrettyFormat();  
	        outputter.setFormat(f);  
	        outputter.output(doc, out);  
	        out.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//判断是否有重名的page
	private static boolean hasPage(Page page){
		String pagnam=page.getPageName();
		List<String> allpagename=readAllPage(page.getType());
		boolean result=false;
		for(int i=0;i<allpagename.size();i++){
			if(allpagename.get(i).equals(pagnam)){
				result=true;
				break;
			}
		}
		return result;
	}
	
	//写入一个page对象，根据该对象之前是否存在，来决定是否需要在page信息里面添加一个元素
	public static void writePage(Page page){
		boolean has=hasPage(page);
		if(has==false){
			addPagetoInfo(page);
		}
		String filename="xml/"+page.getTypeIndex()+"/"+page.getPageName()+".xml";
		try {   
	        OutputStream out = new FileOutputStream(filename);   
	        XMLEncoder encoder = new XMLEncoder(out);   
	        encoder.writeObject(page);   
	        out.close();   
	        encoder.close();   
	    }
		catch (Exception e) {   
	        e.printStackTrace();   
	    }   
	}
	
	//得到某个page类型下的所有record的名字
	private static List<String> getAllRecord(PType pt){
		String filename = "xml/"+pt.getTypeIndex()+"RecordInfo.xml";
		Element root=null;
		List<String> recordName = new LinkedList<String>();
		try {
			InputStream input = new FileInputStream(filename);
			Document document = builder.build(input);//获得文档对象
			root = document.getRootElement();//获得根节点
			
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Element> recordList = root.getChildren("recordName");
		for(int i=0; i<recordList.size(); i++){
			recordName.add(recordList.get(i).getText());
		}
		
		return recordName;
	}
	
	//根据某个record的名字，读出某个record对象
	public static Record readRecord(String name,PType pt){
		String filename="xml/"+pt.getTypeIndex()+"record/"+name+".xml";
		List<Object> objList=null;
		try{
			objList=objectXMLDecoder(filename);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return (Record)objList.get(0);
	}
	
	//在record信息里面添加一个元素
	private static void addRecordtoInfo(Record re,PType pt){
		String pernam=re.getPersonName();
		String pagnam=re.getPageName();
		String recnam=pagnam+"-"+pernam;
		
		String filename="xml/"+pt.getTypeIndex()+"RecordInfo.xml";
		
		Element ele = new Element("recordName");
		ele.setText(recnam);
		ele.setAttribute("personName", pernam);
		ele.setAttribute("pageName", pagnam);
		Element root=null;
		try {
			InputStream input = new FileInputStream(filename);
			Document document = builder.build(input);//获得文档对象
			root = document.getRootElement();//获得根节点
			input.close();
			
			root.addContent(ele);
			Document doc=new Document(root);
			FileOutputStream out=new FileOutputStream(filename);
			XMLOutputter outputter = new XMLOutputter();  
	        Format f = Format.getPrettyFormat();  
	        outputter.setFormat(f);  
	        outputter.output(doc, out);  
	        out.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//判断是否已经有了重名的record
	private static boolean hasRecord(String recnam,PType pt){
		List<String> allrec=getAllRecord(pt);
		boolean result=false;
		for(int i=0;i<allrec.size();i++){
			if(allrec.get(i).equals(recnam)){
				result=true;
				break;
			}
		}
		return result;
	}
	
	//写入一个record对象，写入前先判断一下这个对象之前是否存在，如果存在就不需要在record信息里面加入一个元素了
	public static void writeRecord(Record re,PType pt){
		String recnam=re.getPageName()+"-"+re.getPersonName();
		boolean has=hasRecord(recnam,pt);
		if(has==false){
			addRecordtoInfo(re,pt);
		}
		
		String filename="xml/"+pt.getTypeIndex()+"record/"+recnam+".xml";
		try {   
	        OutputStream out = new FileOutputStream(filename);   
	        XMLEncoder encoder = new XMLEncoder(out);   
	        encoder.writeObject(re);   
	        out.close();   
	        encoder.close();   
	    }
		catch (Exception e) {   
	        e.printStackTrace();   
	    }   

	}
	
	//根据page的名字得到这个page下的所有record的名字列表
	private static List<String> getAllRecordbyPagNam(String pagnam,PType pt){
		String filename = "xml/"+pt.getTypeIndex()+"RecordInfo.xml";
		Element root=null;
		List<String> recordName = new LinkedList<String>();
		try {
			InputStream input = new FileInputStream(filename);
			Document document = builder.build(input);//获得文档对象
			root = document.getRootElement();//获得根节点
			
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Element> recordList = root.getChildren("recordName");
		for(int i=0; i<recordList.size(); i++){
			Element cur=recordList.get(i);
			String pn=cur.getAttributeValue("pageName");
			if(pn.equals(pagnam)){
				recordName.add(cur.getText());
			}
		}
		
		return recordName;
	}
	
	//得到某个page名字下的所有record对象列表
	public static List<Record> getAllRecordbyPage(String pagnam,PType pt){
		List<String> allrecord=getAllRecordbyPagNam(pagnam,pt);
		List<Record> recordList=new LinkedList<Record>();
		for(int i=0;i<allrecord.size();i++){
			Record cur=readRecord(allrecord.get(i),pt);
			recordList.add(cur);
		}
		return recordList;
	}
	
	//根据一个人的名字，得到这个名字下的所有page名字列表
	public static List<String> getAllPagebyPerNam(String pernam,PType pt){
		String filename = "xml/"+pt.getTypeIndex()+"Info.xml";
		Element root=null;
		List<String> pageName = new LinkedList<String>();
		try {
			InputStream input = new FileInputStream(filename);
			Document document = builder.build(input);//获得文档对象
			root = document.getRootElement();//获得根节点
			
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Element> pageList = root.getChildren("pageName");
		for(int i=0; i<pageList.size(); i++){
			Element cur=pageList.get(i);
			String pn=cur.getAttributeValue("personName");
			if(pn.equals(pernam)){
				pageName.add(cur.getText());
			}
		}
		
		return pageName;
	}
	
	//根据一个人的名字，得到这个名字下的所有record的名字列表
	public static List<String> getAllRecordbyPerNam(String pernam,PType pt){
		String filename = "xml/"+pt.getTypeIndex()+"RecordInfo.xml";
		Element root=null;
		List<String> recordName = new LinkedList<String>();
		try {
			InputStream input = new FileInputStream(filename);
			Document document = builder.build(input);//获得文档对象
			root = document.getRootElement();//获得根节点
			
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Element> recordList = root.getChildren("recordName");
		for(int i=0; i<recordList.size(); i++){
			Element cur=recordList.get(i);
			String pn=cur.getAttributeValue("personName");
			if(pn.equals(pernam)){
				recordName.add(cur.getText());
			}
		}
		
		return recordName;
	}
}
