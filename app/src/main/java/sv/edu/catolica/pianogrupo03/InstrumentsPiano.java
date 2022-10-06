package sv.edu.catolica.pianogrupo03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class InstrumentsPiano extends AppCompatActivity {
    private SoundPool soundPool;
    private int guitarra, tambor, arpa, sax, violin, trompeta, banjo;
    private ImageButton ibTambor, ibArpa, ibViolin, ibBanjo, ibSax, ibTrompeta, ibGuitarra;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruments_piano);

        setTitleColor(Color.WHITE);

        ibTambor = findViewById(R.id.ivTambot);
        ibArpa = findViewById(R.id.ivArpa);
        ibViolin = findViewById(R.id.ivViolin);
        ibBanjo = findViewById(R.id.ivBanjo);
        ibSax = findViewById(R.id.ivSax);
        ibTrompeta = findViewById(R.id.ivTrompeta);
        ibGuitarra = findViewById(R.id.ivGuitarra);


        //Inicializando soundPool y cargando audios
        soundPool = new SoundPool(7, AudioManager.STREAM_MUSIC, 0);
        tambor = soundPool.load(getApplicationContext(), R.raw.sonido_tambor, 1);
        arpa = soundPool.load(getApplicationContext(), R.raw.sonido_arpa, 1);
        violin = soundPool.load(getApplicationContext(), R.raw.sonido_violin, 1);
        banjo = soundPool.load(getApplicationContext(), R.raw.sonido_banjo, 1);
        sax = soundPool.load(getApplicationContext(), R.raw.sonido_sax, 1);
        trompeta = soundPool.load(getApplicationContext(), R.raw.sonido_trompeta, 1);
        guitarra = soundPool.load(getApplicationContext(), R.raw.sonido_guitarra, 1);


        //Botones

        ibTambor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(tambor, 1,1,0,0, 1);
            }
        });

        ibArpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(arpa, 1,1,0,0, 1);
            }
        });

        ibViolin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(violin, 1,1,0,0, 1);
            }
        });

        ibBanjo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(banjo, 1,1,0,0, 1);
            }
        });

        ibSax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sax, 1,1,0,0, 1);
            }
        });

        ibTrompeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(trompeta, 1,1,0,0, 1);
            }
        });

        ibGuitarra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(guitarra, 1,1,0,0, 1);
            }
        });
    }

    //Normal Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.op_cambiarTipo:
                tiposPiano();
                break;

            case R.id.op_acerca:
                Intent toAcerdaDe = new Intent(getApplicationContext(), AcercaDe.class);
                startActivity(toAcerdaDe);
                checkSound();
                break;

            case R.id.op_salir:
                checkSound();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void tiposPiano(){
        final String[] opciones = {"Piano Tradicional", "Piano Infantil de la Selva", "Piano de Instrumentos Musicales"};

        AlertDialog.Builder cuadroOpciones = new AlertDialog.Builder(this);
        cuadroOpciones.setTitle("Tipos de Piano");
        cuadroOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == 0){
                    Intent toNormalPiano = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(toNormalPiano);
                    checkSound();
                }else if(which ==1){
                    Intent toJunglePiano = new Intent(getApplicationContext(), JunglePiano.class);
                    startActivity(toJunglePiano);
                    checkSound();
                } else if(which == 2){
                    Intent toInstrumentsPiano = new Intent(getApplicationContext(), InstrumentsPiano.class);
                    startActivity(toInstrumentsPiano);
                    checkSound();
                }

            }
        });
        cuadroOpciones.create();
        cuadroOpciones.show();

    }


    //Parar todos los sonidos y salir (metodo salir)
    public void checkSound(){
        soundPool.autoPause();
        soundPool.release();
        finish();
    }

    @Override
    public void onBackPressed() {
        checkSound();
        super.onBackPressed();
    }

}