package com.example.chernovinternetshop;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chernovinternetshop.databinding.ActivityMainBinding;

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

public class MainActivity extends AppCompatActivity{
    ActivityMainBinding binding;

    int[] img = {R.drawable.ic_launcher_background};
    String[] bookNames = {
            "Путешествие в неизвестность",
            "Тени прошлого",
            "Мир без границ",
            "Подземный город",
            "Звездный путь",
            "Секреты времени",
            "Сказки о волшебстве",
            "Искусство меча",
            "Приключения без остановки",
            "Под лунным светом"
    };
    int[] bookPrices = {
            2000,   // Стоимость книги "Путешествие в неизвестность"
            1500,   // Стоимость книги "Тени прошлого"
            2500,   // Стоимость книги "Мир без границ"
            3000,   // Стоимость книги "Подземный город"
            1800,   // Стоимость книги "Звездный путь"
            2200,   // Стоимость книги "Секреты времени"
            1000,   // Стоимость книги "Сказки о волшебстве"
            2700,   // Стоимость книги "Искусство меча"
            3500,   // Стоимость книги "Приключения без остановки"
            2900    // Стоимость книги "Под лунным светом"
    };
    ArrayList<Book> books = new ArrayList<Book>();
    View footer;
    int count = 0;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        createBooks();
        BookAdapter ba = new BookAdapter(books, this);
        intent = new Intent(this, BasketActivity.class);
        binding.lvMain.setAdapter(ba);
        footer = createFooter("Book in Basket: " + String.valueOf(count));
        binding.lvMain.addFooterView(footer);
//        binding.btnBasket.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("dsa", String.valueOf(books.get(0).getCheck()));
//                intent.putExtra("Books", books);
//                startActivity(intent);
//            }
//        });

    }

    void createBooks() {
        for (int i = 0; i < bookNames.length; i++) {
            Book book = new Book(i, bookPrices[i], bookNames[i], false, img[0]);
            books.add(book);
        }
    }

    View createFooter(String text) {
        View v = getLayoutInflater().inflate(R.layout.footer, null);
        ((TextView) v.findViewById(R.id.tvFooter)).setText(text);
        View b = getLayoutInflater().inflate(R.layout.footer, null);
        ((Button) b.findViewById(R.id.btnBasket)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("dsa", String.valueOf(books.get(0).getCheck()));
                intent.putExtra("Books", books);
                startActivity(intent);
            }
        });
        return v;
    }
    CompoundButton.OnCheckedChangeListener clickListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) count++;
            else count--;
            createFooter("Book in Basket: " + String.valueOf(count));
        }
    };

}