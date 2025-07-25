package com.wefika.horizontalpicker;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class HPickerVH extends RecyclerView.ViewHolder {

    ImageView imageVew;
//    TextView textView;

    public HPickerVH(@NonNull View itemView) {
        super(itemView);
        imageVew = itemView.findViewById(R.id.itemHorizontalPicker);
    }

}
