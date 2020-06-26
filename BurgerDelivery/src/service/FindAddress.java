package service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import service.AddressData;

public class FindAddress {
	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}
	//* 공공데이타포털(http://www.data.go.kr) 오픈 API 이용
	
	// 서비스명 : 통합검색 5자리 우편번호 조회서비스
	// 새 우편번호(2015-08-01부터) 오픈 API 주소
	// http://openapi.epost.go.kr/postal/retrieveNewAdressAreaCdSearchAllService/retrieveNewAdressAreaCdSearchAllService/getNewAddressListAreaCdSearchAll
	
	// [in] s : 검색어 (도로명주소[도로명/건물명] 또는 지번주소[동/읍/면/리])
	// [in] p : 읽어올 페이지(1부터), l : 한 페이지당 출력할 목록 수(최대 50까지)
	// [out] v[i*3 +0]=우편번호, v[i*3 +1]=도로명주소, v[i*3 +2]=지번주소, v.Count/3=표시할 목록 수
	// [out] n[0]=검색한 전체 목록(우편번호) 개수, n[1]=읽어온 페이지(1부터)
	// 반환값 : 에러메시지, null == OK
	public static ArrayList<AddressData> find(String s, int p)
	{
		HttpURLConnection con = null;
		ArrayList<AddressData> aDataList = new ArrayList<AddressData>();
		try
		{
			String url =
			"http://openapi.epost.go.kr/postal/retrieveNewAdressAreaCdSearchAllService/retrieveNewAdressAreaCdSearchAllService/getNewAddressListAreaCdSearchAll"
			+ "?ServiceKey=BdZPrBmptDvirZJfIbmewI11T%2BnUiHdQJRBzkaX8OWb79%2Bja1fQhdJ2rJ27Wm5Bx841XfpLq0xUxpzwKe99%2FSg%3D%3D" // 서비스키
			+ "&countPerPage=" + 50 // 페이지당 출력될 개수를 지정(최대 50)
			+ "&currentPage=" + p // 출력될 페이지 번호
			+ "&srchwrd=" + URLEncoder.encode(s,"UTF-8");
			
//			con = (HttpURLConnection) url.openConnection();
//			con.setRequestProperty("Accept-language", "ko");
			
			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			Document doc = dBuilder.parse(url);
			
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("newAddressListAreaCdSearchAll");
			System.out.println("파싱할 리스트 수 : "+ nList.getLength());
			
			for(int temp = 0; temp < nList.getLength(); temp++){		
				Node nNode = nList.item(temp);
				if(nNode.getNodeType() == Node.ELEMENT_NODE){
					Element eElement = (Element) nNode;
					
//					System.out.println(getTagValue("lnmAdres", eElement));
					AddressData aData = new AddressData();
					aData.setZipNo(getTagValue("zipNo", eElement));
					aData.setRnAdres(getTagValue("rnAdres", eElement));
					aData.setLnmAdres(getTagValue("lnmAdres", eElement));
					aDataList.add(aData);
				}	// for end
			}	// if end
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aDataList;
	}
}
/*
package service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FindAddress {
	//* 공공데이타포털(http://www.data.go.kr) 오픈 API 이용
	
	// 서비스명 : 통합검색 5자리 우편번호 조회서비스
	// 새 우편번호(2015-08-01부터) 오픈 API 주소
	// http://openapi.epost.go.kr/postal/retrieveNewAdressAreaCdSearchAllService/retrieveNewAdressAreaCdSearchAllService/getNewAddressListAreaCdSearchAll
	
	// [in] s : 검색어 (도로명주소[도로명/건물명] 또는 지번주소[동/읍/면/리])
	// [in] p : 읽어올 페이지(1부터), l : 한 페이지당 출력할 목록 수(최대 50까지)
	// [out] v[i*3 +0]=우편번호, v[i*3 +1]=도로명주소, v[i*3 +2]=지번주소, v.Count/3=표시할 목록 수
	// [out] n[0]=검색한 전체 목록(우편번호) 개수, n[1]=읽어온 페이지(1부터)
	// 반환값 : 에러메시지, null == OK
	public static String find(String s, int p, int l, List<String> v, int[] n)
	{
		HttpURLConnection con = null;
		
		try
		{
			URL url = new URL(
			"http://openapi.epost.go.kr/postal/retrieveNewAdressAreaCdSearchAllService/retrieveNewAdressAreaCdSearchAllService/getNewAddressListAreaCdSearchAll"
			+ "?ServiceKey=BdZPrBmptDvirZJfIbmewI11T%2BnUiHdQJRBzkaX8OWb79%2Bja1fQhdJ2rJ27Wm5Bx841XfpLq0xUxpzwKe99%2FSg%3D%3D" // 서비스키
			+ "&countPerPage=" + l // 페이지당 출력될 개수를 지정(최대 50)
			+ "&currentPage=" + p // 출력될 페이지 번호
			+ "&srchwrd=" + URLEncoder.encode(s,"UTF-8") // 검색어
			);
			
			con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Accept-language", "ko");
			
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
	        DocumentBuilder bd = fac.newDocumentBuilder();
	        Document doc = bd.parse(con.getInputStream());
	        
			boolean bOk = false; // <successYN>Y</successYN> 획득 여부
			s = null; // 에러 메시지
			
			String nn;
			Node nd;
			NodeList ns = doc.getElementsByTagName("cmmMsgHeader");
			if (ns.getLength() > 0)
			for (nd = ns.item(0).getFirstChild(); nd != null; nd = nd.getNextSibling())
			{
//				System.out.println(nd.getTextContent());
				nn = nd.getNodeName();
				
				if (!bOk)
				{
					if (nn.equals("successYN")) // 성공 여부
					{
						if (nd.getTextContent().equals("Y")) bOk = true; // 검색 성공
					}
					else if (nn.equals("errMsg")) // 에러 메시지
					{
						s = nd.getTextContent();
					}
				}
				else
				{
					if (nn.equals("totalCount")) // 전체 검색수
					{
						n[0] = Integer.parseInt(nd.getTextContent());
					}
					else if (nn.equals("currentPage")) // 현재 페이지 번호
					{
						n[1] = Integer.parseInt(nd.getTextContent());
					}
				}
			}
			
			if (bOk)
			{
				ns = doc.getElementsByTagName("newAddressListAreaCdSearchAll");
				for (p = 0; p < ns.getLength(); p++)
				for (nd = ns.item(p).getFirstChild(); nd != null; nd = nd.getNextSibling())
				{
				//	nn = nd.getNodeName();
				//	if (nn.equals("zipNo") || // 우편번호
				//		nn.equals("lnmAdres") || // 도로명 주소
				//		nn.equals("rnAdres")) // 지번 주소
				//	{
						System.out.println(nd.getTextContent());
						v.add(nd.getTextContent());
				//	}
				}
	        }
			
			if (s == null)
			{ // OK!
				if (v.size() < 3)
					s = "검색결과가 없습니다.";
			}
		}
		catch(Exception e)
		{
			s = e.getMessage();
		}
		
		if (con != null)
			con.disconnect();

		return s;
	}
}
 

 * */
