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
			
			Elements title_elem = doc.select(".sumTit .hd_3");
			// 불러올 태그를 Element 요소로 변환
			
			int num = title_elem.text().indexOf("닫기");
			String title = title_elem.text().substring(num+3);
			// title에 네이밍이 되어있지 않아, title 앞에서 substring으로 끊어줌
			//System.out.println(title);
			
			Elements info_elem = doc.select(".artReadJobSum > .tbRow > .tbCol");
			Elements career = info_elem.get(0).select(".tbList dd .col_1");
			Element pay = info_elem.get(1).select(".tbList dd").get(1);
			// 공고의 헤더에서 신입과 경력 구분, 급여 조건에 대해서 추출
			System.out.println(pay.text());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
