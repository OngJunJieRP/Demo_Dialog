package sg.edu.rp.c346.id19032110.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1;
    Button btnDemo2;
    Button btndemo3;
    Button btnExercise;
    Button btnDemo4;
    Button btnDemo5;
    TextView textViewDemo2;
    TextView textViewDemo3;
    TextView textViewExercise;
    TextView textViewDemo4;
    TextView textViewDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        btndemo3 = findViewById(R.id.buttonDemo3);
        btnExercise = findViewById(R.id.buttonExercise);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);
        textViewDemo2 = findViewById(R.id.textViewDemo2);
        textViewDemo3 = findViewById(R.id.textViewDemo3);
        textViewExercise = findViewById(R.id.textViewExercise);
        textViewDemo4 = findViewById(R.id.textViewDemo4);
        textViewDemo5 = findViewById(R.id.textViewDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creating the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                // Set the dialog details
                /*
                myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);
                */

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("DISMISS", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 buttons Dialog");
                myBuilder.setMessage("Select one fo the buttons below");
                myBuilder.setCancelable(false);

                // Configure the 'Positive button
                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textViewDemo2.setText("You have selected Positive");
                    }
                });

                myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textViewDemo2.setText("You have selected Negative");
                    }
                });

                // Configure the 'neutral' button
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btndemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input,null);
                //Obtain the UI component in the input.xml layout
                //It needs to be defined as "final" so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog); // Set the view of the dialog
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Extract the text entered by the user
                        String message = etInput.getText().toString();
                        //Set the text to the TextView
                        textViewDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.number_input,null);
                //Obtain the UI component in the input.xml layout
                //It needs to be defined as "final" so that it can used in the onClick() method later
                final EditText etNumInput1 = viewDialog.findViewById(R.id.editTextNum1);
                final EditText etNumInput2 = viewDialog.findViewById(R.id.editTextNum2);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog); // Set the view of the dialog
                myBuilder.setTitle("EXERCISE 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Extract the text entered by the user
                        String num1 = etNumInput1.getText().toString();
                        String num2 = etNumInput2.getText().toString();

                        int num_1 = Integer.parseInt(num1);
                        int num_2 = Integer.parseInt(num2);

                        int Total = num_1 + num_2;
                        //Set the text to the TextView
                        textViewExercise.setText("The sum is " + Total);
                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        textViewDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                // Create the Date Picker Dialog
                //DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, 2014,11,31);
                //myDateDialog.show();

                // Create the Date Picker Dialog to show the current date when it first opened
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, year, month, day);
                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        textViewDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                // Create the Time Picker Dialog
              //  TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        //myTimeListener, 20,60,false);

                //myTimeDialog.show();

                // Create the Date Picker Dialog to show the current date when it first opened
                Calendar now = Calendar.getInstance();
                int hour = now.get(Calendar.HOUR);
                int minute = now.get(Calendar.MINUTE);

                TimePickerDialog  myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, hour,minute, false);
                myTimeDialog.show();
            }
        });
    }
}
