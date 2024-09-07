package com.example.spisokpokupok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> shoppingList;
    private ShoppingListAdapter adapter;
    private static final int REQUEST_CODE_ADD_ITEM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        shoppingList = new ArrayList<>();
        shoppingList.add("Хлеб");
        shoppingList.add("Молоко");
        shoppingList.add("Рис");

        ListView listView = findViewById(R.id.shoppingListView);
        adapter = new ShoppingListAdapter(this, shoppingList);
        listView.setAdapter(adapter);
    }
    //обработка результат с AddActivity
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //проверка что результат пришел с правильного экрана и успешный
        if (requestCode == REQUEST_CODE_ADD_ITEM && resultCode == RESULT_OK) {
            if (data != null) {
                String newItem = data.getStringExtra("newItem"); // получаем новую покупку
                if(newItem != null && !newItem.isEmpty()) {
                    shoppingList.add(newItem); // добавляем покупку в список
                    adapter.notifyDataSetChanged(); // обновляем адаптер
                }
            }
        }

    }

    public void btnClick(View v) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivityForResult(intent, REQUEST_CODE_ADD_ITEM);
    }
}