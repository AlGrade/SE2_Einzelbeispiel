package com.example.se2_einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView numberInput = findViewById(R.id.numberInput);
        TextView answerFromServer = findViewById(R.id.textView_answer);
        TextView sortedNumbers = findViewById(R.id.textView_sortedNumbers);

        final Button sendButton = findViewById(R.id.button_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ServerConnection connection = new ServerConnection(numberInput.getText().toString());

                Thread serverThread = new Thread(connection);
                serverThread.start();

                try {
                    serverThread.join();
                    answerFromServer.setText(connection.responseFromServer);
                } catch (InterruptedException e) {
                    answerFromServer.setText("connection not possible");
                    e.printStackTrace();
                }
            }
        });

        final Button sortButton = findViewById(R.id.button_sort);
        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NumberSorter sorter = new NumberSorter(numberInput.getText().toString());
                sortedNumbers.setText(sorter.sortedNumber);
            }
        });

    }
}