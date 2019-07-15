package com.dlctt.daggerlearning.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.dlctt.daggerlearning.R;
import com.dlctt.daggerlearning.model.pojo.User;
import com.dlctt.daggerlearning.utils.ListItemCallback;

import java.util.ArrayList;

public class UsersAdapter extends ListAdapter<User, UsersAdapter.UserViewHolder>
{
    private ArrayList<User> users;
    private final ListItemCallback<User> userListItemCallback;

    UsersAdapter(@NonNull DiffUtil.ItemCallback<User> diffCallback, ListItemCallback<User> userListItemCallback)
    {
        super(diffCallback);
        users = new ArrayList<>();
        this.userListItemCallback = userListItemCallback;
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
        holder.bind(getItem(position));
    }

    void addMoreUsers(ArrayList<User> newUsers)
    {
        users.addAll(newUsers);
        submitList(new ArrayList<>(users));
    }

    void clearUsers()
    {
        users.clear();
        submitList(new ArrayList<User>());
    }

    class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView userInfoText;

        UserViewHolder(View itemView)
        {
            super(itemView);
            userInfoText = itemView.findViewById(R.id.user_info_text);
            itemView.setOnClickListener(this);
        }

        void bind(User item)
        {
            userInfoText.setText(item.toString());
        }

        @Override
        public void onClick(View v)
        {
            int adapterPosition = getAdapterPosition();
            int layoutPosition = getLayoutPosition();
            if (adapterPosition == layoutPosition)
                userListItemCallback.onItemClicked(getItem(adapterPosition));
        }
    }
}
