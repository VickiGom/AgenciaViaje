package com.example.agenciaviaje;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText fechaOb ,nombreOb, edadOb,numeroBoletoOb,precioOb;
    private Spinner spnDestino, spnTipo;
    private TextView nombreUnoLb, edadUnoLb, numeroBoletoUnoLb, destinoUnoLb,tipoUnoLb,precioUnoLb,fechaUnoLb,subLb,totalLb,impLb,desLb;
    private Button btnMostrar, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Boleto bol = new Boleto();
        fechaOb= (EditText) findViewById(R.id.fechaOb);
        fechaOb.setOnClickListener(this);
        nombreOb= (EditText) findViewById(R.id.nombreOb);
        edadOb= (EditText) findViewById(R.id.edadOb);
        numeroBoletoOb= (EditText) findViewById(R.id.numeroBoletoOb);
        precioOb= (EditText) findViewById(R.id.precioOb);
        btnMostrar= (Button) findViewById(R.id.btnMostrar);
        btnLimpiar= (Button) findViewById(R.id.btnLimpiar);
        spnDestino =(Spinner) findViewById(R.id.spnDestino);
        spnTipo =(Spinner) findViewById(R.id.spnTipo);
        nombreUnoLb = (TextView) findViewById(R.id.nombreUnoLb);
        edadUnoLb = (TextView) findViewById(R.id.edadUnoLb);
        numeroBoletoUnoLb = (TextView) findViewById(R.id.numeroBoletoUnoLb);
        destinoUnoLb = (TextView) findViewById(R.id.destinoUnoLb);
        tipoUnoLb = (TextView) findViewById(R.id.tipoUnoLb);
        precioUnoLb = (TextView) findViewById(R.id.precioUnoLb);
        fechaUnoLb = (TextView) findViewById(R.id.fechaUnoLb);
        subLb = (TextView) findViewById(R.id.subLb);
        totalLb = (TextView) findViewById(R.id.totalLb);
        impLb = (TextView) findViewById(R.id.impLb);
        desLb = (TextView) findViewById(R.id.desLb);
        btnLimpiar.setVisibility(View.INVISIBLE);
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fechaOb.getText().toString().matches("") || nombreOb.getText().toString().matches("") || edadOb.getText().toString().matches("") ||
                        numeroBoletoOb.getText().toString().matches("") || precioOb.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de rellenar todos los espacios",Toast.LENGTH_SHORT).show();
                }else{

                    bol.setFecha(fechaOb.getText().toString());
                    bol.setId(Integer.parseInt(numeroBoletoOb.getText().toString()));
                    bol.setNombre(nombreOb.getText().toString());
                    bol.setPrecio(Double.parseDouble(precioOb.getText().toString()));

                    fechaOb.setVisibility(View.INVISIBLE);
                    nombreOb.setVisibility(View.INVISIBLE);
                    numeroBoletoOb.setVisibility(View.INVISIBLE);
                    edadOb.setVisibility(View.INVISIBLE);
                    precioOb.setVisibility(View.INVISIBLE);
                    spnDestino.setVisibility(View.INVISIBLE);
                    spnTipo.setVisibility(View.INVISIBLE);
                    nombreUnoLb.setText("Nombre: "+bol.getNombre());
                    edadUnoLb.setText("Edad: "+ Integer.parseInt(edadOb.getText().toString()));
                    numeroBoletoUnoLb.setText("No. boleto: "+bol.getId());
                    destinoUnoLb.setText("Destino: "+bol.getDestino());
                    tipoUnoLb.setText("Tipo de viaje: "+bol.getTipo());
                    precioUnoLb.setText("Precio: "+bol.getPrecio());
                    fechaUnoLb.setText("Fecha: "+bol.getFecha());
                    subLb.setText("Subtotal: "+bol.mostrarSubtotal());
                    totalLb.setText("Total: "+(bol.mostrarTotal()-bol.mostrarDescuento(Integer.parseInt(edadOb.getText().toString()))));
                    impLb.setText("Impuesto: "+bol.mostrarImpuesto());
                    desLb.setText("Descuento: "+bol.mostrarDescuento(Integer.parseInt(edadOb.getText().toString())));
                    edadUnoLb.setTranslationY(-130);
                    numeroBoletoUnoLb.setTranslationY(-220);
                    destinoUnoLb.setTranslationY(-345);
                    tipoUnoLb.setTranslationY(-500);
                    precioUnoLb.setTranslationY(-910);
                    fechaUnoLb.setTranslationY(-850);
                    subLb.setTranslationY(-980);
                    totalLb.setTranslationY(-980);
                    impLb.setTranslationY(-980);
                    desLb.setTranslationY(-980);
                    btnMostrar.setVisibility(View.INVISIBLE);
                    btnLimpiar.setVisibility(View.VISIBLE);
                    fechaOb.setText("");
                    nombreOb.setText("");
                    edadOb.setText("");
                    numeroBoletoOb.setText("");
                    precioOb.setText("");
                }
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edadUnoLb.setTranslationY(0);
                numeroBoletoUnoLb.setTranslationY(0);
                destinoUnoLb.setTranslationY(0);
                tipoUnoLb.setTranslationY(0);
                precioUnoLb.setTranslationY(0);
                fechaUnoLb.setTranslationY(0);
                subLb.setTranslationY(0);
                totalLb.setTranslationY(0);
                impLb.setTranslationY(0);
                desLb.setTranslationY(0);
                nombreUnoLb.setText("Nombre: ");
                edadUnoLb.setText("Edad: ");
                numeroBoletoUnoLb.setText("Numero de boleto: ");
                destinoUnoLb.setText("Destino: ");
                tipoUnoLb.setText("Tipo de viaje: ");
                precioUnoLb.setText("Precio: ");
                fechaUnoLb.setText("Fecha: ");
                subLb.setText("");
                totalLb.setText("");
                impLb.setText("");
                desLb.setText("");
                btnMostrar.setVisibility(View.VISIBLE);
                btnLimpiar.setVisibility(View.INVISIBLE);
                fechaOb.setVisibility(View.VISIBLE);
                nombreOb.setVisibility(View.VISIBLE);
                numeroBoletoOb.setVisibility(View.VISIBLE);
                edadOb.setVisibility(View.VISIBLE);
                precioOb.setVisibility(View.VISIBLE);
                spnDestino.setVisibility(View.VISIBLE);
                spnTipo.setVisibility(View.VISIBLE);
            }
        });
        ArrayAdapter<String> Adaptador =new
                ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,
                getResources().getStringArray(R.array.destinosEs));
        ArrayAdapter<String> Adaptador2 =new
                ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,
                getResources().getStringArray(R.array.tiposBoleto));
        spnDestino.setAdapter(Adaptador);
        spnTipo.setAdapter(Adaptador2);
        spnDestino.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Selecciono " + adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
                bol.setDestino(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
        spnTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Selecciono tipo " + adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
                bol.setTipo(Integer.parseInt(adapterView.getItemAtPosition(i).toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
    }


    @Override
    public void onClick(View v) {
        int dia,mes,año;
        final Calendar c= Calendar.getInstance();
        dia=c.get(Calendar.DAY_OF_MONTH);
        mes=c.get(Calendar.MONTH);
        año=c.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                fechaOb.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        },dia,mes,año);
        datePickerDialog.show();
    }



}