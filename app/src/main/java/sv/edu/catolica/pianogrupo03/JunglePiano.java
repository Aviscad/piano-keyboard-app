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
import android.widget.ImageView;

public class JunglePiano extends AppCompatActivity {
    private ImageView ivLeon, ivElefante, ivBuho , ivOso, ivTigre, ivRana, ivPollito;
    private int leon, buho, tigre, oso, rana, pollito, elefante;
    private SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jungle_piano);

        setTitleColor(Color.WHITE);

        ivLeon = findViewById(R.id.ivLeon);
        ivElefante = findViewById(R.id.ivElefante);
        ivBuho = findViewById(R.id.ivBuho);
        ivOso = findViewById(R.id.ivOso);
        ivTigre = findViewById(R.id.ivTigre);
        ivRana = findViewById(R.id.ivRana);
        ivPollito = findViewById(R.id.ivPollito);

        //Inicializando soundPool y cargando audios
        soundPool = new SoundPool(7, AudioManager.STREAM_MUSIC, 0);
        leon = soundPool.load(getApplicationContext(), R.raw.sonido_leon, 1);
        elefante = soundPool.load(getApplicationContext(), R.raw.sonido_elefante, 1);
        buho = soundPool.load(getApplicationContext(), R.raw.sonido_buho, 1);
        oso = soundPool.load(getApplicationContext(), R.raw.sonido_oso, 1);
        tigre = soundPool.load(getApplicationContext(), R.raw.sonido_tigre, 1);
        rana = soundPool.load(getApplicationContext(), R.raw.sonido_rana, 1);
        pollito = soundPool.load(getApplicationContext(), R.raw.sonido_pollito, 1);


        ivLeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(leon, 1,1,0,0, 1);
            }
        });

        ivElefante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(elefante, 1,1,0,0, 1);
            }
        });

        ivBuho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(buho, 1,1,0,0, 1);
            }
        });

        ivOso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(oso, 1,1,0,0, 1);
            }
        });


        ivTigre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(tigre, 1,1,0,0, 1);
            }
        });

        ivRana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(rana, 1,1,0,0, 1);
            }
        });


        ivPollito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(pollito, 1,1,0,0, 1);
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