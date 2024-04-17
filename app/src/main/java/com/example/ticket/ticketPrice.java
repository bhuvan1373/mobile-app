package com.example.ticket;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ticketPrice extends AppCompatActivity {

    EditText editTextNumberOfPersons, editTextTicketCost;
    Button buttonAddTickets, buttonRemoveTickets;
    TextView textViewTotalTickets;

    int totalTickets = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_price);

        editTextNumberOfPersons = findViewById(R.id.editTextNumberOfPersons);
        editTextTicketCost = findViewById(R.id.editTextTicketCost);
        buttonAddTickets = findViewById(R.id.buttonAddTickets);
        buttonRemoveTickets = findViewById(R.id.buttonRemoveTickets);
        textViewTotalTickets = findViewById(R.id.textViewTotalTickets);

        buttonAddTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberOfPersons = Integer.parseInt(editTextNumberOfPersons.getText().toString());
                double ticketCost = Double.parseDouble(editTextTicketCost.getText().toString());
                totalTickets += numberOfPersons;
                textViewTotalTickets.setText("Total Tickets: " + totalTickets + " Cost: RS." + (totalTickets * ticketCost));
            }
        });

        buttonRemoveTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberOfPersons = Integer.parseInt(editTextNumberOfPersons.getText().toString());
                double ticketCost = Double.parseDouble(editTextTicketCost.getText().toString());
                if (totalTickets >= numberOfPersons) {
                    totalTickets -= numberOfPersons;
                    textViewTotalTickets.setText("Total Tickets: " + totalTickets + " Cost: Rs." + (totalTickets * ticketCost));
                } else {
                    textViewTotalTickets.setText("Not enough tickets to remove!");
                }
            }
        });
    }
}
