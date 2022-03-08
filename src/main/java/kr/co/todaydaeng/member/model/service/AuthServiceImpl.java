package kr.co.todaydaeng.member.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.co.todaydaeng.member.model.dao.MemberDAO;
import kr.co.todaydaeng.member.model.vo.Member;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private MemberDAO mDAO;
	
	public String getAccessToken(String authorize_code) {
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";

		try {
			URL url = new URL(reqURL);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=81af0dfe58ccf188fe47f9f421528ad2"); 
			sb.append("&redirect_uri=http://localhost/login/kakao"); 
			sb.append("&code=" + authorize_code);
			bw.write(sb.toString());
			bw.flush();

			// 결과 코드가 200이라면 성공
			int responseCode = conn.getResponseCode();
			System.out.println("2. 액세스 토큰 요청 responseCode(200번대가 나와야함) : " + responseCode);

			// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("## response body : " + result);

			// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			access_Token = element.getAsJsonObject().get("access_token").getAsString();
			refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

			System.out.println("## access_token과 refresh_token 추출");
			System.out.println("## access_token : " + access_Token);
			System.out.println("## refresh_token : " + refresh_Token);

			br.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return access_Token;
	}

	public HashMap<String, Object> getUserInfo(String access_Token) {
		// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_Token);

			int responseCode = conn.getResponseCode();
			System.out.println("3. 사용자 정보 요청 responseCode : " + responseCode);

			// BufferedReader : Scanner같은거
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("## response body : " + result);

			// json object 파싱
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
			
			// 고유 id (식별자)
			String id = element.getAsJsonObject().get("id").toString();
			
			// properties중 닉네임 필수 동의 항목
			String nickname = properties.getAsJsonObject().get("nickname").getAsString();

			// properties중 이미지 동의 유무 처리
			String profile_image;
			boolean profile_image_needs_agreement = kakao_account.getAsJsonObject().get("profile_image_needs_agreement").getAsBoolean();
			if (profile_image_needs_agreement) profile_image = null;
			else profile_image = properties.getAsJsonObject().get("profile_image").getAsString();

			// kakao_account에 계정 동의 유무 처리
			String email;
			boolean email_needs_agreement = kakao_account.getAsJsonObject().get("email_needs_agreement").getAsBoolean();
			if(email_needs_agreement) email = null;
			else email = kakao_account.getAsJsonObject().get("email").getAsString();

			userInfo.put("socialId", id);
			userInfo.put("nickname", nickname);
			userInfo.put("email", email);
			userInfo.put("profile_image", profile_image);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfo;
	}
	
	//네이버
	public String getNaverAccessToken(String authorize_code) {
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";

		try {
			URL url = new URL(reqURL);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=yvOnjHEnLyapFHXdjTK2"); 
			sb.append("&client_secret=kcE_FkNdMd"); 
			sb.append("&redirect_uri=http://localhost/login/naver"); 
			sb.append("&code=" + authorize_code);
			bw.write(sb.toString());
			bw.flush();

			// 결과 코드가 200이라면 성공
			int responseCode = conn.getResponseCode();
			System.out.println("2. 액세스 토큰 요청 responseCode : " + responseCode);

			// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("## response body : " + result);

			// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			access_Token = element.getAsJsonObject().get("access_token").getAsString();
			refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

			System.out.println("## access_token과 refresh_token 추출");
			System.out.println("## access_token : " + access_Token);
			System.out.println("## refresh_token : " + refresh_Token);

			br.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return access_Token;
	}
	
	public HashMap<String, Object> getNaverUserInfo(String access_Token) {
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		
		String reqURL = "https://openapi.naver.com/v1/nid/me";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_Token);

			int responseCode = conn.getResponseCode();
			System.out.println("3. 사용자 정보 요청 responseCode : " + responseCode);

			// BufferedReader(Scanner같은거)
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("## response body : " + result);

			// json object 파싱
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			JsonObject response = element.getAsJsonObject().get("response").getAsJsonObject();
			
			// response중 동의 항목
			//식별값
			String id = response.getAsJsonObject().get("id").getAsString(); 
			
			//필수동의
			String nickname = response.getAsJsonObject().get("nickname").getAsString(); 
			userInfo.put("socialId", id);
			userInfo.put("nickname", nickname);
			
			//선택동의(이메일)
			if(response.has("email")) {
				String email = response.getAsJsonObject().get("email").getAsString(); 
				userInfo.put("email", email);
			}
			
			//선택동의(프로필)
			if(response.has("profile_image")) {
				String profile_image = response.getAsJsonObject().get("profile_image").getAsString(); 
				userInfo.put("profile_image", profile_image);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfo;
	}

	@Override
	public Member selectSocialId(String socialId) {
		return mDAO.selectSocialId(socialId);
	}

	@Override
	public int socialJoin(Member member) {
		return mDAO.joinMember(member);
	}
	
	@Override
	public int updateLoginDate(Member m) {
		return mDAO.updateLoginDate(m);
	}
}
