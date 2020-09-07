import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class test {
	
	@Test                                                                                 
    public void T01_전화번호_패턴_정규식(){
		String phone = "010-2222-2222";
		
		Pattern p = Pattern.compile("^01\\d{1}-\\d{3,4}-\\d{4}$");
		Matcher m = p.matcher(phone);
        
		if (!m.find()) {
			System.out.print("전화번호 패턴 확인 실패");
		} 
		else
			System.out.print("전화번호 패턴 성공");
    	}
}
