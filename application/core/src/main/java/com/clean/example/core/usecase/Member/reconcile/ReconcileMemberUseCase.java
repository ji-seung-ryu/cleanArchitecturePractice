package com.clean.example.core.usecase.Member.reconcile;

import com.clean.example.core.usecase.job.OnFailure;
import com.clean.example.core.usecase.job.OnSuccess;

import java.util.List;

public class ReconcileMemberUseCase {
	
    public static final int MAX_MEMBER_NAME_LENGTH = 25;

	private final GetAllMemberId getAllMemberId;
	private final GetMemberName getMemberName;
	private final UpdateMemberName updateMemberName;
	
	public ReconcileMemberUseCase (GetAllMemberId getAllMemberId, GetMemberName getMemberName, UpdateMemberName updateMemberName) {
		this.getAllMemberId = getAllMemberId;
		this.getMemberName = getMemberName;
		this.updateMemberName = updateMemberName;
	}
	
	public void reconcile (OnSuccess onSuccess, OnFailure onFailure) {
		List<String> allMemberId = getAllMemberId.getAllMemberId();
		
		for (String memberId : allMemberId) {
			String memberName = getMemberName.getMemberName(memberId);
			
			if (isInvalid (memberName)) {
				onFailure.auditFailure();
				continue;
			}
			updateMemberName.updateMemberName(memberId, memberName);
			onSuccess.auditSuccess();
			
		}
	}
	
	
	private boolean isInvalid (String memberName) {
		return memberName.length() > MAX_MEMBER_NAME_LENGTH;
	}
}
