package com.example.chernovinternetshop;

import androidx.appcompat.app.AppCompatActivity;
import com.example.chernovinternetshop.databinding.ActivityMainBinding;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
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
    ArrayList<Book> books =  new ArrayList<Book>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);
        createBooks();
        BookAdapter ba = new BookAdapter(books,this);

        binding.lvMain.setAdapter(ba);


    }
    void createBooks(){
        for (int i = 0; i < bookNames.length; i++) {
            Book book = new Book(i,bookPrices[i],bookNames[i]);
            books.add(book);
        }
    }
}