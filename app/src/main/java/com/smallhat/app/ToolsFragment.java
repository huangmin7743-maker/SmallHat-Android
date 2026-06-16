package com.smallhat.app;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class ToolsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tools, container, false);

        v.findViewById(R.id.toolBot).setOnClickListener(x ->
            Toast.makeText(getContext(), "黄金信号已就绪", Toast.LENGTH_SHORT).show());
        v.findViewById(R.id.toolOrder).setOnClickListener(x ->
            Toast.makeText(getContext(), "订单流已就绪", Toast.LENGTH_SHORT).show());
        v.findViewById(R.id.toolGame).setOnClickListener(x ->
            Toast.makeText(getContext(), "GameStation 已就绪", Toast.LENGTH_SHORT).show());
        v.findViewById(R.id.toolAI).setOnClickListener(x ->
            Toast.makeText(getContext(), "AI 中转站已就绪", Toast.LENGTH_SHORT).show());
        return v;
    }
}
