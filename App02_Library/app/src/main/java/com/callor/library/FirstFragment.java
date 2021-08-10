package com.callor.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.callor.library.apdapter.BookAdapter;
import com.callor.library.config.Naver;
import com.callor.library.databinding.FragmentFirstBinding;
import com.callor.library.model.BookDTO;
import com.callor.library.service.NaverAPIServiceV1;

import java.util.List;

public class FirstFragment extends Fragment {

    // fragment_first.xml 을 Binding하라 라는 의미가 된다.
    // *.xml 파일이 마치 java class가 된것 처럼 코딩을 할수 있다
    private FragmentFirstBinding binding;

    private BookAdapter bookAdapter;
    private List<BookDTO> bookDTOList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        bookAdapter = null ; // new BookAdapter();
        /**
         * Adpater를 생성하고
         * Adapter와 RecyclerView 연결하는 코드를
         * Activity, Fragment와 같은 부분에서 처리를 해야 하는데
         *
         * NaverApiServiceV1에게 역할을 대신 수행하도록 한다
         * 그러기 위해서 Adapter, RecyclerView 등이 담긴 binding 객체를
         * 생성자의 매개변수로 전달한다.
         *
         */
        NaverAPIServiceV1 nService
                = new NaverAPIServiceV1(bookAdapter,binding);
        nService.getNaverBooks("자바");

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}