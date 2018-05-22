package com.tinkoff.bottom.sheet;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author Vitaly Kirillov
 */
public class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.ViewHolder> {

    private boolean vertical;

    ColorsAdapter(boolean vertical) {
        this.vertical = vertical;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView = new TextView(parent.getContext());
        if (vertical) {
            textView.setLayoutParams(new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UiUtils.dpToPx(50)));
        } else {
            textView.setLayoutParams(new ViewGroup.MarginLayoutParams(UiUtils.dpToPx(50), UiUtils.dpToPx(50)));
        }

        textView.setGravity(Gravity.CENTER);
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private static String[] colors = new String[]{"#FE4445", "#FF8800", "#FFBB34", "#99CC01", "#0099CB", "#33B5E6"};

        ViewHolder(View itemView) {
            super(itemView);
        }

        void bind(int index) {
            int colorIndex = index < colors.length ? index : index % colors.length;
            int color = Color.parseColor(colors[colorIndex]);
            itemView.setBackgroundColor(color);
        }
    }
}
