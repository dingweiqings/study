

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Dom4jXmlParse {

	public static void main(String[] args) throws Exception {
        select();//查询所有name的值
        //select2();//查询id=stu1的学生的name的值
    }
    //查询所有name的值
    private static void select() throws Exception {
        SAXReader saxReader=new SAXReader();
      ///  Document document=saxReader.read("src/main/java/1.xml");
        Document document=saxReader.read("src/main/java/applicationContext.xml");
        List<Element>list=document.selectNodes("//bean[@id='student']");
        System.out.println("获取元素 "+list.size());
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i).getName());
    }
    //查询id=stu1的学生的name的值
    private static void select2() throws Exception {
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read("src/1.xml");
        Node node=document.selectSingleNode("//student[@id='stu1']/name");
        System.out.println(node.getText());
    }
}