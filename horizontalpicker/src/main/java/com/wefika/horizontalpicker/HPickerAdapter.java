package com.wefika.horizontalpicker;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class HPickerAdapter extends RecyclerView.Adapter<HPickerVH> {

    private Context context;
    private List<String> list;
    private RecyclerView recyclerView;
    private int[] drawableList;

    public HPickerAdapter(Context context, List<String> list, RecyclerView recyclerView) {
        this.context = context;
        this.list = list;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public HPickerVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_horizontal_picker, viewGroup, false);
        return new HPickerVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HPickerVH hPickerVH, int i) {
        final int position = i;
//        hPickerVH.imageVew.setImageResource(drawableList[position]);
//        hPickerVH.textView.setText(list.get(position));
        hPickerVH.imageVew.setImageResource(R.drawable.tarti);
        hPickerVH.imageVew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerView != null) {
                    recyclerView.smoothScrollToPosition(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void swapData(List<String> newList) {
        list = newList;
        notifyDataSetChanged();
    }

}
