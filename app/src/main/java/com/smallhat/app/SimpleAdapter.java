package com.smallhat.app;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.VH> {
    List<String[]> items;
    SimpleAdapter(List<String[]> items) { this.items = items; }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup p, int i) {
        View v = LayoutInflater.from(p.getContext()).inflate(R.layout.item_chat, p, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int i) {
        String[] d = items.get(i);
        h.avatar.setText(d[0]);
        h.name.setText(d[1]);
        h.lastMsg.setText(d[2]);
        h.time.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() { return items.size(); }

    class VH extends RecyclerView.ViewHolder {
        TextView avatar, name, lastMsg, time, unreadBadge;
        VH(View v) {
            super(v);
            avatar = v.findViewById(R.id.chatAvatar);
            name = v.findViewById(R.id.chatName);
            lastMsg = v.findViewById(R.id.chatLastMsg);
            time = v.findViewById(R.id.chatTime);
            unreadBadge = v.findViewById(R.id.chatUnread);
        }
    }
}
