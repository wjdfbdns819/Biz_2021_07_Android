package com.callor.cacao.service;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.callor.cacao.adpter.ChattAdapter;
import com.callor.cacao.model.Chatt;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class FirebaseServiceImplV1 implements ChildEventListener {
    
    /*
     ChattAdapter 객체가 하는 일
      RecyclerView와 연동하여 데이터를 화면에 그리기 위한 중간 연결도구
      
      Adapter를 MainActivity로 부터 전달받아서
      firebase database에 데이터가 추가되면
      데이터를 가져와서 화면에 그리기 위한 코드를 작성한다
     */
    private ChattAdapter apdapter;

    public FirebaseServiceImplV1(ChattAdapter apdapter) {
        this.apdapter = apdapter;
    }
    
    /*
       CUD 중에서 새로운 데이터가 추가되는(Insert, Create) event가 발생하면 실행되는 method
       
        이 method에서 데이터이터가 추가되었다는 신호를 받으면 데이터를 가져와서
        Adapter의 chattList에 데이터를 추가한다
        그리고 RecylerView에게 알림을 전한다 
     */
    @Override
    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
        Chatt chattVO = snapshot.getValue(Chatt.class);
        apdapter.addChatList(chattVO);
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}