package com.example.ticket;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private List<BusStop> busStopsList;
    private EditText searchEditText;
    private RecyclerView busStopsRecyclerView;
    private BusStopAdapter busStopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("busStops");

        // Initialize views
        searchEditText = findViewById(R.id.searchEditText);
        busStopsRecyclerView = findViewById(R.id.busStopsRecyclerView);
        busStopsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        busStopsList = new ArrayList<>();
        busStopAdapter = new BusStopAdapter(busStopsList);
        busStopsRecyclerView.setAdapter(busStopAdapter);

        // Add item decoration to RecyclerView
        int margin = getResources().getDimensionPixelSize(R.dimen.recycler_view_item_margin);
        busStopsRecyclerView.addItemDecoration(new MarginItemDecoration(margin));

        // Load data from CSV to Firebase
        uploadCSVToFirebase();
    }

    private void uploadCSVToFirebase() {
        busStopsList = new ArrayList<>();
        InputStream inputStream = getResources().openRawResource(R.raw.route_detail);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String busNumber = parts[1];
                    String stopNumber = parts[2];
                    String stopName = parts[3];
                    String routeId = parts[0];

                    BusStop busStop = new BusStop(busNumber, stopNumber, stopName, routeId);
                    busStopsList.add(busStop);

                    String key = databaseReference.push().getKey();
                    databaseReference.child(key).setValue(busStop);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchBusStops(View view) {
        String searchText = searchEditText.getText().toString().trim();

        if (TextUtils.isEmpty(searchText)) {
            Toast.makeText(this, "Please enter a bus number", Toast.LENGTH_SHORT).show();
            return;
        }

        List<BusStop> searchResult = new ArrayList<>();
        for (BusStop busStop : busStopsList) {
            if (busStop.getBusNumber().equalsIgnoreCase(searchText)) {
                searchResult.add(busStop);
            }
        }

        if (searchResult.isEmpty()) {
            Toast.makeText(this, "No stops found for bus number " + searchText, Toast.LENGTH_SHORT).show();
        } else {
            busStopAdapter = new BusStopAdapter(searchResult);
            busStopsRecyclerView.setAdapter(busStopAdapter);
        }
    }

    public void openTicketPriceActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ticketPrice.class);
        startActivity(intent);
    }
}
