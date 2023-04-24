package crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {
	
	public static void main(String[] args) {
		// 잡코리아 버전 크롤링
		String URL = "https://www.jobkorea.co.kr/Recruit/GI_Read/41689949";
		
		try {
			Document doc = Jsoup.connect(URL).get();
			// URL의 페이지 소스 불러오기
			
			Elements elem = doc.select(".sumTit .hd_3");
			// 불러올 태그를 Element 요소로 변환
			
			int num = elem.text().indexOf("닫기");
			String title = elem.text().substring(num+3);
			// title에 네이밍이 되어있지 않아, title 앞에서 substring으로 끊어줌
			System.out.println(title);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
