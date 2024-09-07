package com.example.spisokpokupok;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddActivity extends AppCompatActivity {

    private EditText newItemEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);

        //инициализация EditText и Button
        newItemEditText = findViewById(R.id.editText);
        Button saveItemButton = findViewById(R.id.btnSave);

        //обработка нажатия на кнопку
        saveItemButton.setOnClickListener(v -> {
            String newItem = newItemEditText.getText().toString().trim();
            if(!newItem.isEmpty()) {
                // создаем Intent для возврата результата
                Intent resultIntent = new Intent();
                resultIntent.putExtra("newItem", newItem); // передаем новую покупку
                setResult(RESULT_OK, resultIntent); // устанавливаем результат как успешный
                finish(); // закры
            }
            else {
                //показываем сообщение
                Toast.makeText(this,"Пусто", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}