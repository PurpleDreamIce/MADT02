package com.example.madt02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity {

    private Spinner spCounterSelection;
    private EditText txtEnteredText;
    private TextView tvCharsCount;

    protected void onCreate(Bundle savedInstanceState, Context context) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtEnteredText = findViewById(R.id.txtEnteredText);
        this.tvCharsCount = findViewById(R.id.tvCharsCount);
        this.spCounterSelection = findViewById(R.id.spCounterSelection);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( context: this, R.array.selection_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spCounterSelection.setAdapter(adapter);

    }
    public void onBtnCountCharsClick(View view, Context context, Object text) {
        String spinnerSelection = spCounterSelection.getSelectedItem().toString();
        String charSelectionOption = getResources().getString(R.string.selection_chars);

        if(spinnerSelection.equalsIgnoreCase(charSelectionOption)){
            String userEnteredText = this.txtEnteredText.getText().toString();
            int enteredTextLengthInChars = WordCounter.getCharsCount(userEnteredText);
            this.tvCharsCount.setText(String.valueOf(enteredTextLengthInChars));
        }
        else {
            Toast.makeText( context: this, text: "No", Toast.LENGTH_LONG).show());
        }
    }
}