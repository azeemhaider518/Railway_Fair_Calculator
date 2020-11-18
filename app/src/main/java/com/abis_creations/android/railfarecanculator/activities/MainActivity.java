package com.abis_creations.android.railfarecanculator.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.abis_creations.android.railfarecanculator.R;
import com.abis_creations.android.railfarecanculator.adapters.SpinnerAdapter;
import com.abis_creations.android.railfarecanculator.models.Station;
import com.abis_creations.android.railfarecanculator.utils.CONSTANTS;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    ArrayList<Station> stationList;
    SpinnerAdapter spinnerAdapter;
    Spinner spFrom;
    Spinner spTo;

    int selectedFrom;
    int selectedTo;
    Button btnCalculate;
    double estimatedDuration;
    float estimatedDistance;
    double estimatedFare;

    RadioButton rdbPeak;
    RadioButton rdbOffPeak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find Views by Ids
        spFrom=findViewById(R.id.sp_from);
        spTo=findViewById(R.id.sp_to);
        btnCalculate=findViewById(R.id.btn_calculate);
        rdbPeak=findViewById(R.id.rdb_peak_hours);
        rdbOffPeak=findViewById(R.id.rdb_off_peak_hours);


        // Initialize Spinners with values
        setUpSpinners();

        // when user clicks on
        spFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedFrom=stationList.get(i).getStationId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedFrom=stationList.get(0).getStationId();
            }
        });

        spTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedTo=stationList.get(i).getStationId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedTo=stationList.get(0).getStationId();
            }
        });


        int currentTime=getCurrentTime();
        if((currentTime>=07 && currentTime<9) || (currentTime>=18 && currentTime<20) ){
//        Peak time
            rdbPeak.setChecked(true);
        }else {
            rdbOffPeak.setChecked(true);
        }


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedFrom==selectedTo){
                Toast.makeText(MainActivity.this, "Please Change atleast one station", Toast.LENGTH_SHORT).show();
                }else{

                    calculateFare(selectedFrom,selectedTo);
                }
            }
        });

    }

    private void calculateFare(int selectedFrom, int selectedTo) {

        Station stationInfo = new Station();

        if (selectedFrom == 0 && selectedTo == 1) {
            float f = (float) (1.2);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(1);
        } else if (selectedFrom == 0 && selectedTo == 2) {
            float f = (float) (1.2 + 1.5);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(2);
        } else if (selectedFrom == 0 && selectedTo == 3) {
            float f = (float) (1.2 + 1.5 + 1.8);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(3);
        } else if (selectedFrom == 0 && selectedTo == 4) {
            float f = (float) (1.2 + 1.5 + 1.8 + 1.3);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(4);
        } else if (selectedFrom == 0 && selectedTo == 5) {
            float f = (float) (1.2 + 1.5 + 1.8 + 1.3 + 1.9);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(5);


        } else if (selectedFrom == 1 && selectedTo == 2) {
            float f = (float) (1.5);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(1);
        } else if (selectedFrom == 1 && selectedTo == 3) {
            float f = (float) (1.5 + 1.8);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(2);
        } else if (selectedFrom == 1 && selectedTo == 4) {
            float f = (float) (1.5 + 1.8 + 1.3);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(3);
        } else if (selectedFrom == 1 && selectedTo == 5) {
            float f = (float) (1.5 + 1.8 + 1.3 + 1.9);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(4);
        } else if (selectedFrom == 1 && selectedTo == 0) {
            float f = (float) (1.5 + 1.8 + 1.3 + 1.9 + 1.4);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(5);


        } else if (selectedFrom == 2 && selectedTo == 3) {
            float f = (float) (1.8);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(1);
        } else if (selectedFrom == 2 && selectedTo == 4) {
            float f = (float) (1.8 + 1.3);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(2);
        } else if (selectedFrom == 2 && selectedTo == 5) {
            float f = (float) (1.8 + 1.3 + 1.9);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(3);
        } else if (selectedFrom == 2 && selectedTo == 0) {
            float f = (float) (1.8 + 1.3 + 1.9 + 1.4);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(4);
        } else if (selectedFrom == 2 && selectedTo == 1) {
            float f = (float) (1.8 + 1.3 + 1.9 + 1.4 + 1.2);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(5);


        } else if (selectedFrom == 3 && selectedTo == 4) {
            float f = (float) (1.3);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(1);
        } else if (selectedFrom == 3 && selectedTo == 5) {
            float f = (float) (1.3 + 1.9);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(2);
        } else if (selectedFrom == 3 && selectedTo == 0) {
            float f = (float) (1.3 + 1.9 + 1.4);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(3);
        } else if (selectedFrom == 3 && selectedTo == 1) {
            float f = (float) (1.3 + 1.9 + 1.4 + 1.2);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(4);
        } else if (selectedFrom == 3 && selectedTo == 2) {
            float f = (float) (1.3 + 1.9 + 1.4 + 1.2 + 1.5);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(5);


        } else if (selectedFrom == 4 && selectedTo == 5) {
            float f = (float) (1.9);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(1);
        } else if (selectedFrom == 4 && selectedTo == 0) {
            float f = (float) (1.9 + 1.4);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(2);
        } else if (selectedFrom == 4 && selectedTo == 1) {
            float f = (float) (1.9 + 1.4 + 1.2);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(3);
        } else if (selectedFrom == 4 && selectedTo == 2) {
            float f = (float) (1.9 + 1.4 + 1.2 + 1.5);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(4);
        } else if (selectedFrom == 4 && selectedTo == 3) {
            float f = (float) (1.9 + 1.4 + 1.2 + 1.5 + 1.8);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(5);


        } else if (selectedFrom == 5 && selectedTo == 0) {
            float f = (float) (1.4);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(1);
        } else if (selectedFrom == 5 && selectedTo == 1) {
            float f = (float) (1.4 + 1.2);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(2);
        } else if (selectedFrom == 5 && selectedTo == 2) {
            float f = (float) (1.4 + 1.2 + 1.5);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(3);
        } else if (selectedFrom == 5 && selectedTo == 3) {
            float f = (float) (1.4 + 1.2 + 1.5 + 1.8);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(4);
        } else if (selectedFrom == 5 && selectedTo == 4) {
            float f = (float) (1.4 + 1.2 + 1.5 + 1.8 + 1.3);
            stationInfo.setDistanceBetweenStations(f);
            stationInfo.setNoOfStops(5);
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        if (rdbPeak.isChecked()) {
            estimatedDistance = stationInfo.getDistanceBetweenStations();
            int noOfStops = stationInfo.getNoOfStops();
            double stopTime = (noOfStops * CONSTANTS.PEAK_STOP_TIME) / 60;
            estimatedDuration = Double.parseDouble(decimalFormat.format(estimatedDistance + stopTime));
            double fare = estimatedDistance * CONSTANTS.PEAK_FARE_PER_KM;
            estimatedFare = Double.parseDouble(decimalFormat.format(fare));

        } else {
            estimatedDistance = stationInfo.getDistanceBetweenStations();
            double noOfStops = stationInfo.getNoOfStops();
            double stopTime = (noOfStops * CONSTANTS.OFF_PEAK_STOP_TIME) / 60;
            estimatedDuration = Double.parseDouble(decimalFormat.format(estimatedDistance + stopTime));
            double fare = estimatedDistance * CONSTANTS.OFF_PEAK_FARE_PER_KM;
            estimatedFare = Double.parseDouble(decimalFormat.format(fare));
        }

        // Final Rpounding Off

        String estimateFare = String.valueOf(estimatedFare);
        if (estimateFare.length() == 5) {
            estimateFare = estimateFare.substring(0, estimateFare.length() - 1);
            int lastIndx = estimateFare.length();
            estimateFare = estimateFare.substring(0,lastIndx-1)+ '0';
        } else if(estimateFare.length()==4){
            int lastIndx = estimateFare.length();
            estimateFare = estimateFare.substring(0,lastIndx-1)+ '0';
        }else {
            estimateFare=estimateFare+"0";
        }



        String estimateDuration=String.valueOf(estimatedDuration);
        int lastIndex=estimateDuration.length();
        int decimalIndex=estimateDuration.indexOf(".");
        int integralPart=Integer.parseInt(estimateDuration.substring(0,decimalIndex));
        int decimalPart=Integer.parseInt(estimateDuration.substring(decimalIndex+1,lastIndex));


        if (decimalPart>0){
            estimateDuration=String.valueOf(integralPart+1);
        }else {
            estimateDuration=String.valueOf(integralPart);
        }



        AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this)
                .setTitle(stationList.get(selectedFrom).getStationName()+"  ====> "+stationList.get(selectedTo).getStationName())
                .setMessage("\n  Estimated Distance : "+ estimatedDistance+" km\n  Estimated Duration : "+estimateDuration+ " min\n  Estimated Fare : $"+estimateFare)
                .setPositiveButton("Ok",null)
                .setCancelable(false);

        alertDialog.show();
    }


    private int getCurrentTime() {
        Calendar currentTime=Calendar.getInstance();

        return currentTime.get(Calendar.HOUR_OF_DAY);
    }

    private void setUpSpinners() {

        String[] stationName={
                "Sengkang",
                "Compassvale",
                "Rumbia",
                "Bakau",
                "Kangkar",
                "Ranggung",
        };
        int[] stationLogo={
                R.drawable.compassvale,
                R.drawable.compassvale,
                R.drawable.compassvale,
                R.drawable.compassvale,
                R.drawable.compassvale,
                R.drawable.compassvale,
        };

        stationList=new ArrayList<>();
        for (int i = 0; i <stationName.length ; i++) {
            Station station=new Station();

            station.setStationId(i);
            station.setStationName(stationName[i]);
            station.setStationLogo(stationLogo[i]);

            stationList.add(station);
        }

        spinnerAdapter=new SpinnerAdapter(this,stationList);
        spFrom.setAdapter(spinnerAdapter);
        spTo.setAdapter(spinnerAdapter);
    }


}
