package com.example.chernovinternetshop;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chernovinternetshop.databinding.ItemBinding;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {
    ItemBinding binding;
    LayoutInflater lInflater;
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
//            binding = ItemBinding.bind(tmp);
        }
        Book b = getBook(i);
        ((TextView) tmp.findViewById(R.id.tvCost)).setText("Cost: " + String.valueOf(b.getCost()));
        ((TextView) tmp.findViewById(R.id.tvIdenf)).setText("Identificator: " + String.valueOf(b.getIdent()));
        ((TextView) tmp.findViewById(R.id.tvName)).setText("Name: " + String.valueOf(b.getName()));
//        binding.tvCost.setText("Cost: " + String.valueOf(b.getCost()));
//        binding.tvIdenf.setText("Identificator: " + String.valueOf(b.getIdent()));
//        binding.tvName.setText("Name: " + String.valueOf(b.getName()));
        return tmp;
    }

    Book getBook(int position) {
        return ((Book) getItem(position));
    }
}
