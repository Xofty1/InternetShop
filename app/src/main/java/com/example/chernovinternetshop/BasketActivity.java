package com.example.chernovinternetshop;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chernovinternetshop.databinding.ActivityBasketBinding;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity {
    ActivityBasketBinding binding;
    ArrayList<Book> books;
    ArrayList<Book> checkedBooks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        binding = ActivityBasketBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        Intent intentToMain = new Intent(this, MainActivity.class);
        books = (ArrayList<Book>) intent.getSerializableExtra("Books");
        makeBasket();
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentToMain);
            }
        });

    }

    void makeBasket() {
        for (Book b : books) {
            if (b.getCheck()) {
                checkedBooks.add(b);
            }
        }
        LayoutInflater lf = getLayoutInflater();
        for (Book b : checkedBooks) {
            View v = lf.inflate(R.layout.checked, binding.linLayout, false);
            TextView tvCost = v.findViewById(R.id.tvCost);
            tvCost.setText(String.valueOf((b.getCost())));
            TextView tvName = v.findViewById(R.id.tvName);
            tvName.setText(String.valueOf((b.getName())));
            TextView tvIdenf = v.findViewById(R.id.tvIdenf);
            tvIdenf.setText(String.valueOf((b.getIdent())));
            v.getLayoutParams().width = ActionBar.LayoutParams.MATCH_PARENT;
            binding.linLayout.addView(v);
        }
    }
}