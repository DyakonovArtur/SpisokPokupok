package com.example.spisokpokupok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ShoppingListAdapter extends ArrayAdapter<String> {

    //Конструктор адаптера - принимает контекст (MainActivity) и список покупок (shoppingList)
    public ShoppingListAdapter(@NonNull Context context, ArrayList<String> shoppingList) {
        super(context, 0, shoppingList);
    }

    //метод getView вызывает для каждого элемнета списка, чтобы создать или обновить представление для этого элемента
    //position - место позиции в списке, convertView - представление которое можно использовать повторно, parent - родитель
    //представление в которое будет вставлено это представление
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(item);

        return convertView;
    }

}
