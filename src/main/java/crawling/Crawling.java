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
			
			Elements title_elem = doc.select(".sumTit .hd_3");
			// �ҷ��� �±׸� Element ��ҷ� ��ȯ
			
			int num = title_elem.text().indexOf("�ݱ�");
			String title = title_elem.text().substring(num+3);
			// title�� ���̹��� �Ǿ����� �ʾ�, title �տ��� substring���� ������
			//System.out.println(title);
			
			Elements info_elem = doc.select(".artReadJobSum > .tbRow > .tbCol");
			Elements career = info_elem.get(0).select(".tbList dd .col_1");
			Element pay = info_elem.get(1).select(".tbList dd").get(1);
			// ������ ������� ���԰� ��� ����, �޿� ���ǿ� ���ؼ� ����
			System.out.println(pay.text());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
