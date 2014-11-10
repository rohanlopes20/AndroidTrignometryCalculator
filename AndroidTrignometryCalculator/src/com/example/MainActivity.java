package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener 
{
	final int MENU_RESET_ID = 1;
	final int MENU_QUIT_ID = 2;
  EditText etNum1;
  EditText etNum2;
  EditText etNum3;

  Button btnsin;
  Button btncos;
  Button btncosec;
  Button btnsec;
  Button btntan;
  Button btncot;
 
  Button btnsinAdd;
  Button btnsinSub;
  Button btncosAdd;
  Button btncosSub;
  Button btntanAdd;
  Button btntanSub;
  Button btncotAdd;
  Button btncotSub;
  TextView tvResult;
  TextView tvResult1;

  String oper = "";
  String s="";

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
	 
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  
    // find the elements
    etNum1 = (EditText) findViewById(R.id.etNum1);
    etNum2 = (EditText) findViewById(R.id.etNum2);
    etNum3 = (EditText) findViewById(R.id.etNum3);

    btnsin = (Button) findViewById(R.id.btnsin);
    btncos = (Button) findViewById(R.id.btncos);
    btncosec= (Button) findViewById(R.id.btncosec);
    btnsec = (Button) findViewById(R.id.btnsec);
    btntan = (Button) findViewById(R.id.btntan);
    btncot = (Button) findViewById(R.id.btncot);
    
    btnsinAdd = (Button) findViewById(R.id.btnAdd);
    btnsinSub = (Button) findViewById(R.id.btnSub);
    btncosAdd= (Button) findViewById(R.id.btnMult);
    btncosSub = (Button) findViewById(R.id.btnDiv);
    btntanAdd = (Button) findViewById(R.id.btntanplus);
    btntanSub = (Button) findViewById(R.id.btntanminus);
    btncotAdd= (Button) findViewById(R.id.btncotplus);
    btncotSub = (Button) findViewById(R.id.btncotminus);

    tvResult = (TextView) findViewById(R.id.tvResult);

    tvResult1 = (TextView) findViewById(R.id.tvResult1);

    // set a listener
    btnsin.setOnClickListener(this);
    btncos.setOnClickListener(this);
    btncosec.setOnClickListener(this);
    btnsec.setOnClickListener(this);
    btntan.setOnClickListener(this);
    btncot.setOnClickListener(this);
    btnsinAdd.setOnClickListener(this);
    btnsinSub.setOnClickListener(this);
    btncosAdd.setOnClickListener(this);
    btncosSub.setOnClickListener(this);
    btntanAdd.setOnClickListener(this);
    btntanSub.setOnClickListener(this);
    btncotAdd.setOnClickListener(this);
    btncotSub.setOnClickListener(this);

  
    
  }

  @Override
  public void onClick(View v) {
    // TODO Auto-generated method stub
    float num1 = 0;
    float num2 = 0;
    float num3 = 0;
    float result = 0;
    float result1 = 0;
    
    // check if the fields are empty
   if (TextUtils.isEmpty(etNum3.getText().toString())&&TextUtils.isEmpty(etNum1.getText().toString())||
      TextUtils.isEmpty(etNum2.getText().toString())) 
   {
  return;
 }
   
    num3 = Float.parseFloat(etNum3.getText().toString());
    // read EditText and fill variables with numbers
    num1 = Float.parseFloat(etNum1.getText().toString());
    num2 = Float.parseFloat(etNum2.getText().toString());
    
   

    // defines the button that has been clicked and performs the corresponding operation
    // write operation into oper, we will use it later for output
    switch (v.getId()) {
    case R.id.btnsin:
        s ="Sin";
        result1 = (float)Math.sin(Math.toRadians(num3)); 
        break;
    case R.id.btncos:
        s ="Cos";
        result1 = (float)Math.cos(Math.toRadians(num3)); 
        break;
    case R.id.btncosec:
        s ="cosec";
        result1 = 1/(float)Math.sin(Math.toRadians(num3)); 
        break;
    case R.id.btnsec:
        s ="sec";
        result1 = 1/(float)Math.cos(Math.toRadians(num3)); 
        break;
    case R.id.btntan:
        s ="tan";
        result1 = (float)Math.tan(Math.toRadians(num3)); 
        break;
    case R.id.btncot:
        s ="cot";
        result1 = 1/(float)Math.tan(Math.toRadians(num3)); 
        break;
        
    case R.id.btnAdd:
      oper = "+";
      s ="Sin";
      result = ((float)Math.sin(Math.toRadians(num1))*(float)Math.cos(Math.toRadians(num2)))+((float)Math.cos(Math.toRadians(num1))*(float)Math.sin(Math.toRadians(num2))); 
      break;
    case R.id.btnSub:
      oper = "-";
      s ="Sin";
      result = ((float)Math.sin(Math.toRadians(num1))*(float)Math.cos(Math.toRadians(num2)))-((float)Math.cos(Math.toRadians(num1))*(float)Math.sin(Math.toRadians(num2))); 
      break;
    case R.id.btnMult:
      oper = "+";
      s ="Cos";
      result = ((float)Math.cos(Math.toRadians(num1))*(float)Math.cos(Math.toRadians(num2)))-((float)Math.sin(Math.toRadians(num1))*(float)Math.sin(Math.toRadians(num2))); 
      break;
    case R.id.btnDiv:
      oper = "-";
      s ="Cos";
      result = ((float)Math.cos(Math.toRadians(num1))*(float)Math.cos(Math.toRadians(num2)))+((float)Math.sin(Math.toRadians(num1))*(float)Math.sin(Math.toRadians(num2))); 
      break;
    case R.id.btntanplus:
        oper = "+";
        s ="tan";
        result = ((float)Math.tan(Math.toRadians(num1))+(float)Math.tan(Math.toRadians(num2)))/(1-(float)Math.tan(Math.toRadians(num1))*(float)Math.tan(Math.toRadians(num2))); 
        break;
      case R.id.btntanminus:
        oper = "-";
        s ="tan";
        result = ((float)Math.tan(Math.toRadians(num1))-(float)Math.tan(Math.toRadians(num2)))/(1+(float)Math.tan(Math.toRadians(num1))*(float)Math.tan(Math.toRadians(num2))); 
        break;
      case R.id.btncotplus:
        oper = "+";
        s ="Cot";
        result =1/((float)Math.tan(Math.toRadians(num1))+(float)Math.tan(Math.toRadians(num2)))/(1-(float)Math.tan(Math.toRadians(num1))*(float)Math.tan(Math.toRadians(num2)));  
        break;
      case R.id.btncotminus:
        oper = "-";
        s ="Cot";
        result =1/((float)Math.tan(Math.toRadians(num1))-(float)Math.tan(Math.toRadians(num2)))/(1+(float)Math.tan(Math.toRadians(num1))*(float)Math.tan(Math.toRadians(num2))); 
        break;
    default:
      break;
    }
   if(v.getId()==R.id.btnsin||v.getId()==R.id.btncos
    	||v.getId()==R.id.btncosec||v.getId()==R.id.btnsec||v.getId()==R.id.btntan||v.getId()==R.id.btncot)
    {
    tvResult.setText(s+"("+num3+")"+" = " + result1);
    }// form the output line
   else
    {
    	tvResult1.setText(s+"("+num1 + " " + oper + " " + num2 + ")"+" = " + result);
    }
   
  }
}
