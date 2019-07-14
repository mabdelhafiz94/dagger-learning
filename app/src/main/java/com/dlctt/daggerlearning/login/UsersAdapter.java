package com.dlctt.daggerlearning.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dlctt.daggerlearning.R;
import com.dlctt.daggerlearning.model.pojo.User;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder>
{
    private ArrayList<User> mData;

    UsersAdapter(ArrayList<User> data)
    {
        this.mData = data;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.user_item_layout, parent, false);
        return new UserViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position)
    {
        User item = mData.get(position);

        holder.userInfoText.setText(item.toString());
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }

    void setData(ArrayList<User> mData)
    {
        this.mData = mData;
    }

    class UserViewHolder extends RecyclerView.ViewHolder
    {
        TextView userInfoText;


        UserViewHolder(View itemView)
        {
            super(itemView);
            userInfoText = itemView.findViewById(R.id.user_info_text);
        }
    }
}
