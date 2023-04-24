package crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {
	
	public static void main(String[] args) {
		// ���ڸ��� ���� ũ�Ѹ�
		String URL = "https://www.jobkorea.co.kr/Recruit/GI_Read/41689949";
		
		try {
			Document doc = Jsoup.connect(URL).get();
			// URL�� ������ �ҽ� �ҷ�����
			
			Elements elem = doc.select(".sumTit .hd_3");
			// �ҷ��� �±׸� Element ��ҷ� ��ȯ
			
			int num = elem.text().indexOf("�ݱ�");
			String title = elem.text().substring(num+3);
			// title�� ���̹��� �Ǿ����� �ʾ�, title �տ��� substring���� ������
			System.out.println(title);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
