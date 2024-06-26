package com.yuyu.module.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.yuyu.module.R
import com.yuyu.module.utils.ChatVO

import java.util.ArrayList

import jp.wasabeef.glide.transformations.CropCircleTransformation

class ChatAdapter(private val context: Context) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    private val TAG: String = ChatAdapter::class.java.simpleName
    private val vo: ArrayList<ChatVO> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.my_card_view, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(vo[position].photoUrl)
                .bitmapTransform(CropCircleTransformation(context))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.img)
        holder.txt.text = "${vo[position].email}: ${vo[position].message}"
    }

    override fun getItemCount() = vo.size

    fun add(chatVO: ChatVO) {
        vo.add(chatVO)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txt: TextView = view.findViewById(R.id.text_view) as TextView
        val img: ImageView = view.findViewById(R.id.image_view) as ImageView
    }

}

/*
package com.yuyu.module.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yuyu.module.R;
import com.yuyu.module.utils.ChatVO;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private final String TAG = ChatAdapter.class.getSimpleName();

    private Context context;
    private ArrayList<ChatVO> vo;

    public ChatAdapter(Context context) {
        this.context = context;
        vo = new ArrayList<>();
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(vo.get(position).getPhotoUrl())
                .bitmapTransform(new CropCircleTransformation(context))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.img);
        holder.txt.setText(vo.get(position).getEmail() + ": " + vo.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return vo.size();
    }

    public void add(ChatVO chatVO) {
        vo.add(chatVO);
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;

        ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.image_view);
            txt = (TextView) view.findViewById(R.id.text_view);
        }
    }
}*/
