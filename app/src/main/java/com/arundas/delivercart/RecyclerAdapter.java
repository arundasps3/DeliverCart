package com.arundas.delivercart;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arundas.delivercart.R;

import java.util.List;


public class RecyclerAdapter  extends RecyclerView .Adapter<RecyclerAdapter.MyViewHolder>

{



  MyViewHolder holder;


  private List<String>list;


  public RecyclerAdapter(List<String>list)
  {

this.list=list;
  }
  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


   TextView textview = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout,parent,false);
   MyViewHolder myViewHolder= new MyViewHolder(textview);

    return myViewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     holder.VersionName.setText(list.get(position));


  }

  @Override
  public int getItemCount() {
    return list.size();
  }












  public static class MyViewHolder extends RecyclerView.ViewHolder
  {
  TextView VersionName;

    public MyViewHolder(@NonNull TextView itemView) {
      super(itemView);

      VersionName= itemView;
    }
  }

  public interface OnNoteListner
  {
    void OnNoteClick(int position);
  }


}
