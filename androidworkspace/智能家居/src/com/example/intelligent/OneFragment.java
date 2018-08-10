package com.example.intelligent;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class OneFragment extends Fragment {

    private String content1;
    public OneFragment(String content1) {
        this.content1 = content1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_fg,container,false);
        TextView txt_content1 = (TextView) view.findViewById(R.id.txt_content1);
        txt_content1.setText(content1);
        return view;
    }
}