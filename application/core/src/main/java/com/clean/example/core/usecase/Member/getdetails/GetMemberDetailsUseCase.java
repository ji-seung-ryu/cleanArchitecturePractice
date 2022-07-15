package com.clean.example.core.usecase.Member.getdetails;

import com.clean.example.core.entity.Member;

public class GetMemberDetailsUseCase {
	private final GetMemberDetails getMemberDetails;
	
	public GetMemberDetailsUseCase (GetMemberDetails getMemberDetails) {
		this.getMemberDetails = getMemberDetails;
	}
	
	public Member getMemberDetails(String memberId) {
		Member member = getMemberDetails.getDetails(memberId);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		
		return member;
	}
}
