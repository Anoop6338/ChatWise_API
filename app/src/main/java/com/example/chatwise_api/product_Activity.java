package com.example.chatwise_api;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class product_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiInterface service = retrofit.create(ApiInterface.class);
        Call<MyData> call = service.getProducts();

        call.enqueue(new Callback<MyData>() {
            @Override
            public void onResponse(Call<MyData> call, Response<MyData> response) {
                //if api call is succes then use data t=of api and use in your app
                if (response.isSuccessful()) {
                    MyData data = response.body();
                    if(data !=null){
                        List<Product> products = data.getProducts();
                        customAdapter = new CustomAdapter(products);
                        recyclerView.setAdapter(customAdapter);


                        Log.d("ProductActivity", "Number of products: " + products.size());
                        recyclerView.getAdapter().notifyDataSetChanged();

                    }
                    else{
                        Toast.makeText(product_Activity.this, "Response Body is empty", Toast.LENGTH_SHORT).show();
                    }
               }
                else {
                    Toast.makeText(product_Activity.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MyData> call, Throwable t) {
                // if api call fails
                Toast.makeText(product_Activity.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
                Log.d("product_Activity", "error messages : "+t.getMessage(), t);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}