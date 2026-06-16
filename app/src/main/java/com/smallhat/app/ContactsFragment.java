package com.smallhat.app;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ContactsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView list = v.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"💰", "黄金信号机器人", "在线 · 自动推送信号"});
        data.add(new String[]{"🤖", "AI 中转站", "在线 · API代理服务"});
        data.add(new String[]{"🎮", "GameStation", "离线 · 游戏平台"});
        data.add(new String[]{"📊", "订单流监控", "在线 · 自动分析"});

        list.setAdapter(new SimpleAdapter(data));
        return v;
    }
}
