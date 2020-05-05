package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Duration;

//jst a basic java application to calculate the price based on the order placed

public class MainActivity extends AppCompatActivity {

    boolean haswhippedcream;
    boolean addchoco;

    int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    //increment function gets executed when we press the plus button
    public void Increment(View view){
        if(count<100)
        {   count = count+1;
            display(count);}
        else
            Toast.makeText(this," Maximum of 100 coffees is allowed!",Toast.LENGTH_SHORT).show();

    }

    //Decrement function gets executed when we press the minus button
    public void Decrement(View view){

        if(count>=2)
        {
            count = count-1;
            display(count);
        }
        else
            Toast.makeText(this,"cannot have less than 1 coffee",Toast.LENGTH_SHORT).show();

    }

    public void display(int count){
        EditText text_view = findViewById(R.id.Quantity_text_view);
        text_view.setText(""+count );
    }
    //on submit order the quantity and the price gets displayed


    private int price(){
        int res;

        if((haswhippedcream)&&(addchoco)){
            res = (count)*(5+1+2) ;
        }
        else if (haswhippedcream){
            res = (count)*(5+1) ;
        }
        else if (addchoco){
            res = (count)*(5+2) ;
        }
        else{
            res = count*5;
        }

        return res;
    }

    public String display_name(){
        EditText disp_name = findViewById(R.id.textView5);
        String name = disp_name.getText().toString();

        return name;
    }


    public void submitOrder(View view){

        CheckBox checkbox1 = findViewById(R.id.checkBox1);
         haswhippedcream = checkbox1.isChecked();

        CheckBox checkbox2 = findViewById(R.id.checkBox2);
         addchoco = checkbox2.isChecked();

        String message;
        message = display_name();
        message += "\n"+ getString(R.string.Quantity)+" :" + count ;
        message += "\n Price   :  "+ price();
        message += "\n"+ getString(R.string.add_whipped_cream)+"?? :"+ haswhippedcream;
        message += "\n "+ getString(R.string.add_choco)+"??  :"+ addchoco;
        message += "\n  Thank you !! ";

//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:"));
//        intent.putExtra(Intent.EXTRA_SUBJECT,"JUST JAVA APP FOR"+display_name());
//        intent.putExtra(Intent.EXTRA_TEXT,message);
//        if(intent.resolveActivity(getPackageManager())!=null)
//            startActivity(intent);



        TextView textview = findViewById(R.id.order_summary_text_view);
        textview.setText(message);
    }





}
