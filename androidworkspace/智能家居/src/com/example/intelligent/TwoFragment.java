package com.example.intelligent;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class TwoFragment extends Fragment {

    private String content2;
    private Button Tbutton1;
    public TwoFragment(String content1) {
        this.content2 = content2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two_fg,container,false);
        TextView txt_content1 = (TextView) view.findViewById(R.id.txt_content2);
        Button Tbutton1=(Button)view.findViewById(R.id.Tbutton1);
        txt_content1.setText(content2);
          return view;
    }

     
}