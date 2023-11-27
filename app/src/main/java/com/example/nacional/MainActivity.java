package com.example.nacional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Mqtt mqttManager;
    EditText Nombre;
    EditText Director;
    EditText Sipnosis;
    EditText Opinion;
    EditText Calificacion;
    Button Agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = findViewById(R.id.agreganombre);
        Director = findViewById(R.id.agregadirector);
        Sipnosis = findViewById(R.id.agregasipnosis);
        Opinion = findViewById(R.id.agregaopinion);
        Calificacion = findViewById(R.id.agregacalificacion);
        Agregar = findViewById(R.id.btncalificar);

        mqttManager = new Mqtt(getApplicationContext());
        mqttManager.connectToMqttBroker();

        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mqttManager.publishMessage(Nombre.getText().toString());
                    mqttManager.publishMessage(Director.getText().toString());
                    mqttManager.publishMessage(Sipnosis.getText().toString());
                    mqttManager.publishMessage(Opinion.getText().toString());
                    mqttManager.publishMessage(Calificacion.getText().toString());
                    }
            });
        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}