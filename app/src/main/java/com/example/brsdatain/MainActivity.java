package com.example.brsdatain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> vehicleInfo;
    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //View rootView = inflater.inflate(R.layout.activity_main, container, false);
        recyclerView = findViewById(R.id.vehicle_info_recycler);
        vehicleInfo = Arrays.asList(getResources().getStringArray(R.array.vehicle_info_strings));
        Button button = findViewById(R.id.getButton);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                System.out.println("hej");
            }
        });

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, vehicleInfo);
        recyclerView.setAdapter(viewPagerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>{

        private List<String> vehicleInfo;
        private Context context;

        public ViewPagerAdapter(Context context, List<String> vehicleInfo){
            this.context = context;
            this.vehicleInfo = vehicleInfo;
        }

        public class ViewHolder extends  RecyclerView.ViewHolder{

            TextView vehicleInfoTextField;

            public ViewHolder(View view){
                super(view);

                vehicleInfoTextField = view.findViewById(R.id.vehicle_info);

            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            //inflater.inflate(R.layout.card, parent, false);
            View view = inflater.inflate(R.layout.card, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.vehicleInfoTextField.setText(vehicleInfo.get(position));

        }


        @Override
        public int getItemCount() {
            return vehicleInfo.size();
        }
    }
}