package com.smallhat.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.ArrayList;
import java.util.List;

public class ChatsFragment extends Fragment {
    private RecyclerView chatList;
    private SwipeRefreshLayout swipeRefresh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats, container, false);
        chatList = view.findViewById(R.id.chatList);
        swipeRefresh = view.findViewById(R.id.swipeRefresh);

        chatList.setLayoutManager(new LinearLayoutManager(getContext()));
        chatList.setAdapter(new ChatAdapter(getChatData()));

        swipeRefresh.setOnRefreshListener(() -> {
            swipeRefresh.setRefreshing(false);
        });

        return view;
    }

    private List<ChatItem> getChatData() {
        List<ChatItem> list = new ArrayList<>();
        list.add(new ChatItem("💰", "黄金信号助手", "BTC 现价 65774.5", "刚刚", 3, true));
        list.add(new ChatItem("🤖", "AI 中转站", "Groq 免费模型已接入", "11:00", 0, true));
        list.add(new ChatItem("🎮", "GameStation", "50款游戏在线玩 →", "昨天", 0, false));
        list.add(new ChatItem("📊", "订单流监控", "BTC 买盘堆积 2.3x", "昨天", 1, true));
        list.add(new ChatItem("✦", "SmallHat AI", "有什么可以帮你？", "昨天", 0, true));
        return list;
    }

    static class ChatItem {
        String avatar, name, lastMsg, time;
        int unread;
        boolean online;
        ChatItem(String avatar, String name, String lastMsg, String time, int unread, boolean online) {
            this.avatar = avatar;
            this.name = name;
            this.lastMsg = lastMsg;
            this.time = time;
            this.unread = unread;
            this.online = online;
        }
    }

    class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
        List<ChatItem> items;
        ChatAdapter(List<ChatItem> items) { this.items = items; }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder h, int i) {
            ChatItem c = items.get(i);
            h.avatar.setText(c.avatar);
            h.name.setText(c.name);
            h.lastMsg.setText(c.lastMsg);
            h.time.setText(c.time);
            if (c.unread > 0) {
                h.unreadBadge.setVisibility(View.VISIBLE);
                h.unreadBadge.setText(String.valueOf(c.unread));
            } else {
                h.unreadBadge.setVisibility(View.GONE);
            }
        }

        @Override
        public int getItemCount() { return items.size(); }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView avatar, name, lastMsg, time, unreadBadge;
            ViewHolder(View v) {
                super(v);
                avatar = v.findViewById(R.id.chatAvatar);
                name = v.findViewById(R.id.chatName);
                lastMsg = v.findViewById(R.id.chatLastMsg);
                time = v.findViewById(R.id.chatTime);
                unreadBadge = v.findViewById(R.id.chatUnread);
            }
        }
    }
}
