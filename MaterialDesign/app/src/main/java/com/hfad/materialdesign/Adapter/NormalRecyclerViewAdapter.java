package com.hfad.materialdesign.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hfad.materialdesign.R;

import java.util.ArrayList;
import java.util.List;

public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder>
{
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private List<String> mTitle;

    public NormalRecyclerViewAdapter(Context context)
    {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mTitle = getStringList();
    }


    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position)
    {
        holder.mTextView.setText(mTitle.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mTitle.size();
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder
    {
        TextView mTextView;

        public NormalTextViewHolder(View itemView)
        {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_view);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Log.d("NormalTextViewHolder", "onClick");
                }
            });
        }
    }

    /**
     * String数组
     *
     * @return
     */
    public List<String> getStringList()
    {
        List<String> strings = new ArrayList<>();
        for (int i = 1; i <= 20; i++)
        {
            strings.add(i + "");
        }
        return strings;
    }
}
