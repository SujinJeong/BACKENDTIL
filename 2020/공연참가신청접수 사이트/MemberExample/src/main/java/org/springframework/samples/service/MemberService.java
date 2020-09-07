package org.springframework.samples.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.samples.controller.MemberRegistRequest;
import org.springframework.samples.model.MemberInfo;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	private static Map<String, MemberInfo> memberMap = new HashMap<String, MemberInfo>();

	public MemberService() {
	}
	
	public Map<String, MemberInfo> getMembersMap(){
		return memberMap;
	}

	public List<MemberInfo> getMembers() {
		return new ArrayList<MemberInfo>(memberMap.values());
	}
	
	// 이메일 중복확인을 위한 method
	public Boolean isMemberInfo(String memberId) {
		return memberMap.containsKey(memberId);
	}

	// email로 멤버 정보 받아오기 위한 method
	public MemberInfo getMemberInfo(String memberId) {
		return memberMap.get(memberId);
	}
	
	// 멤버 삭제를 위한 method
	public void removeMember(String memberId) {
		memberMap.remove(memberId);
	}
	
	// form으로 입력받은 새로운 멤버 members에 추가
	public MemberInfo registerNewMember(MemberRegistRequest memRegReq) {
		MemberInfo mi = new MemberInfo(
							memRegReq.getEmail(),
							memRegReq.getName(),
							memRegReq.getPassword(),
							memRegReq.getPhonenum(),
							memRegReq.getAddress(), 
							memRegReq.getType(),
							memRegReq.getSong(),
							Integer.parseInt(memRegReq.getTime()),
							memRegReq.getIsFirst(),
							memRegReq.getRequirements());
		memberMap.put(mi.getEmail(), mi);
		return mi;
	}

}
