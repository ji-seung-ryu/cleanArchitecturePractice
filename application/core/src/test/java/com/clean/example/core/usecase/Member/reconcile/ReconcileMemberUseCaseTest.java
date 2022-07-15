package com.clean.example.core.usecase.Member.reconcile;

import com.clean.example.core.usecase.job.OnFailure;
import com.clean.example.core.usecase.job.OnSuccess;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class ReconcileMemberUseCaseTest {
    GetAllMemberId getAllMemberId = mock(GetAllMemberId.class);
    GetMemberName getMemberName = mock(GetMemberName.class);
    UpdateMemberName updateMemberName = mock(UpdateMemberName.class);
    
    OnSuccess onSuccess = mock(OnSuccess.class);
    OnFailure onFailure = mock(OnFailure.class);
    
    ReconcileMemberUseCase reconcileMemberUseCase = new ReconcileMemberUseCase(getAllMemberId, getMemberName, updateMemberName);

    @Test 
    public void updatesMemberName() throws Exception{
    	givenThereIsAMemberWithMemberId("memberId1");
    	givenMemberHasMemberName("memberId1","memberName1");
    	
    	reconcileMemberUseCase.reconcile(onSuccess, onFailure);
    	
    	thenTheMemberHasBeenUpdated("memberId1","memberName1");


    }
    
    private void givenThereIsAMemberWithMemberId (String... memberId) {
        when(getAllMemberId.getAllMemberId()).thenReturn(Arrays.asList(memberId));
    }
    
    private void givenMemberHasMemberName (String memberId, String MemberName) {
    	when(getMemberName.getMemberName(memberId)).thenReturn(MemberName); 	
    }
    private void thenTheMemberHasBeenUpdated(String MemberId, String MemberName) {
        verify(updateMemberName).updateMemberName(MemberId, MemberName);
    }
    
    private void thenASuccessHasBeenAudited() {
        verify(onSuccess).auditSuccess();
    }

    private void thenAFailureHasBeenAudited() {
        verify(onFailure).auditFailure();
    }

}
