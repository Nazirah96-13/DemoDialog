package sg.edu.rp.c346.id17032457.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //Step 1a
    Button btnDemo1;
    Button btnDemo2;
    Button btnDemo3;
    Button btnDemo4;
    Button btnDemo5;


    //Exercise 3
    Button btnDemoEx3;
    TextView txtViewEx3;



    TextView txtView2;
    TextView txtView3;
    TextView txtView4;
    TextView txtView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 1b
        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        txtView2 = findViewById(R.id.textViewDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        txtView3 = findViewById(R.id.textViewDemo3);

        btnDemo4 = findViewById(R.id.buttonDemo4);
        txtView4 = findViewById(R.id.textViewDemo4);

        btnDemo5 = findViewById(R.id.btnDemo5);
        txtView5 = findViewById(R.id.txtView5);

        //Ex3
        btnDemoEx3 = findViewById(R.id.btnExercise3);
        txtViewEx3 = findViewById(R.id.textViewEx3);



        //Step 2
        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create  the Dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);


                //Set the dialog details
                /*myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("Demo 1-Simple Dialog.");
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
            public void onClick(View v) {
                //Create  the Dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                Log.i("debug", "1");

                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below");
                myBuilder.setCancelable(false);

                //Configure "positive" button

                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txtView2.setText("You have selected Yes");
                    }
                });
                //Configure "negative" button
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txtView2.setText("You have selected No");
                    }
                });
                myBuilder.setNegativeButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();



                btnDemo3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Inflate the input.xml layout file
                        LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                        View viewDialog = inflater.inflate(R.layout.input, null);

                        //Obtain the UI Component in the input.xml layout
                        //It needs to be defined as "final", so that it can used in the onClick() method later
                        final EditText etInput = viewDialog.findViewById(R.id.editTextInput1);

                        //Create  the Dialog builder
                        AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                        myBuilder.setView(viewDialog);
                        myBuilder.setTitle("Demo 3-Text Input Dialog");

                        //Configure "positive" button

                        myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                //Extract the text entered by the user
                                String message = etInput.getText().toString();

                                //Set the text to the Textview
                                txtView3.setText(message);
                            }
                        });


                        myBuilder.setNegativeButton("Cancel", null);
                        AlertDialog myDialog = myBuilder.create();
                        myDialog.show();


                    }


                });


             //Ex3
                btnDemoEx3.setOnClickListener(new View.OnClickListener() {
                       @Override
                        public void onClick(View view) {
                           //Inflate the input.xml layout file
                           LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                           View viewDialog = inflater.inflate(R.layout.input2, null);

                           //Obtain the UI Component in the input.xml layout
                           //It needs to be defined as "final", so that it can used in the onClick() method later
                           final EditText etInput1 = viewDialog.findViewById(R.id.editTextInput1);
                           final EditText etInput2 = viewDialog.findViewById(R.id.editTextInput2);

                           //Create  the Dialog builder
                           AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                           myBuilder.setView(viewDialog);
                           myBuilder.setTitle("Exercise 3");

                           //Configure "positive" button

                           myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int which) {

                                   //Extract the text entered by the user
                                   String num1 = etInput1.getText().toString();
                                   String num2 = etInput2.getText().toString();
                                   int total = Integer.parseInt(num1) + Integer.parseInt(num2);

                                   //Set the text to the Textview
                                   txtViewEx3.setText("The sum is"+ total);
                               }
                           });


                           myBuilder.setNegativeButton("Cancel", null);
                           AlertDialog myDialog = myBuilder.create();
                           myDialog.show();








                       }


                });



              btnDemo4.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                        //Create the listener to set the date
                      Log.i("debug", "1");
                      DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener(){
                        public void  onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                            txtView4.setText("Date:" + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);

                        }


                      };


                    //Create the date picker dialog

                      //DatePickerDialog myDateDialog = new  DatePickerDialog(MainActivity.this, myDateListener, 2014, 11,31);

                      //This is to getCurrent Date
                     Calendar now = Calendar.getInstance();
                     int year = now.get(Calendar.YEAR);
                     int month = now.get(Calendar.MONTH);
                     int day = now.get(Calendar.DAY_OF_MONTH);
                     DatePickerDialog myDateDialog = new  DatePickerDialog(MainActivity.this, myDateListener, year,month, day);
                     myDateDialog.show();





                      }
              });

                btnDemo5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Create the listener to set the date

                       TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                           @Override
                           public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                               txtView5.setText("Time " +hourOfDay+ " : "+ minute);
                           }
                       };



                        //Create the date picker dialog

                        //TimePickerDialog myTimeDialog = new  TimePickerDialog(MainActivity.this, myTimeListener, 20, 00,true);

                        //This is to getCurrent Date
                        Calendar now = Calendar.getInstance();
                        int hour = now.get(Calendar.HOUR_OF_DAY);
                        int min = now.get(Calendar.MINUTE);



                        TimePickerDialog myTimeDialog = new  TimePickerDialog(MainActivity.this, myTimeListener, hour,min,true);
                        myTimeDialog.show();



                    }
                });






            }

        });
    }
}