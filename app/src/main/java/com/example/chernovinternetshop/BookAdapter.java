package com.example.chernovinternetshop;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.example.chernovinternetshop.databinding.ItemBinding;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter{
    ItemBinding binding;
    LayoutInflater lInflater;
    Intent intent;
    Context ctx;
    ArrayList<Book> books = new ArrayList<Book>();

    public BookAdapter(ArrayList<Book> books, Context c) {
        this.ctx = c;
        this.books = books;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int i) {
        return books.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
            View tmp = view;
            if (tmp == null) {
                tmp = lInflater.inflate(R.layout.item, viewGroup, false);
            }
            binding = ItemBinding.bind(tmp);
            Book b = getBook(i);
            binding.tvCost.setText("Cost: " + String.valueOf(b.getCost()));
            binding.tvIdenf.setText("Identificator: " + String.valueOf(b.getIdent()));
            binding.tvName.setText("Name: " + String.valueOf(b.getName()));
            binding.ivPicture.setImageResource(R.drawable.ic_launcher_background);
            binding.cbBox.setOnCheckedChangeListener(clickListener);
            binding.cbBox.setTag(i);
            binding.cbBox.setChecked(b.getCheck());
            return tmp;

    }

    Book getBook(int position) {
        return ((Book) getItem(position));
    }

    OnCheckedChangeListener clickListener = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            getBook((Integer) buttonView.getTag()).setCheck(isChecked);

        }
    };

}
