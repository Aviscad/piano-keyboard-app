package sv.edu.catolica.pianogrupo03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnDo, btnRe, btnMi, btnFa, btnSol, btnLa, btnSi;
    private int mDo, mRe, mMi, mFa, mSol, mLa, mSi;
    Toast t;
    private SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitleColor(Color.WHITE);
        btnDo = findViewById(R.id.btnDo);
        btnRe = findViewById(R.id.btnRe);
        btnMi = findViewById(R.id.btnMi);
        btnFa = findViewById(R.id.btnFa);
        btnSol = findViewById(R.id.btnSol);
        btnLa = findViewById(R.id.btnLa);
        btnSi = findViewById(R.id.btnSi);


        //Inicializando soundPool y cargando audios
        soundPool = new SoundPool(7, AudioManager.STREAM_MUSIC, 0);
        mDo = soundPool.load(getApplicationContext(), R.raw.nota_do, 1);
        mRe = soundPool.load(getApplicationContext(), R.raw.nota_re, 1);
        mMi = soundPool.load(getApplicationContext(), R.raw.nota_mi, 1);
        mFa = soundPool.load(getApplicationContext(), R.raw.nota_fa, 1);
        mSol = soundPool.load(getApplicationContext(), R.raw.nota_sol, 1);
        mLa = soundPool.load(getApplicationContext(), R.raw.nota_la, 1);
        mSi = soundPool.load(getApplicationContext(), R.raw.nota_si, 1);


        //Teclas de Piano
        btnDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(mDo, 1,1,0,0, 1);
                makeToast("Do");
            }

        });

        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(mRe, 1,1,0,0, 1);
                makeToast("Re");
            }
        });

        btnMi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(mMi, 1,1,0,0, 1);
                makeToast("Mi");
            }
        });

        btnFa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(mFa, 1,1,0,0, 1);
                makeToast("Fa");
            }
        });

        btnSol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(mSol, 1,1,0,0, 1);
                makeToast("Sol");
            }
        });

        btnLa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(mLa, 1,1,0,0, 1);
                makeToast("La");
            }
        });

        btnSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(mSi, 1,1,0,0, 1);
                makeToast("Si");
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
                    checkSoundAndToast();
                break;

            case R.id.op_salir:
                checkSoundAndToast();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    //Cuadro de dialogo selectivo
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
                    checkSoundAndToast();
                }else if(which ==1){
                    Intent toJunglePiano = new Intent(getApplicationContext(), JunglePiano.class);
                    startActivity(toJunglePiano);
                    checkSoundAndToast();
                } else if(which == 2){
                    Intent toInstrumentsPiano = new Intent(getApplicationContext(), InstrumentsPiano.class);
                    startActivity(toInstrumentsPiano);
                    checkSoundAndToast();
                }
            }
        });
        cuadroOpciones.create();
        cuadroOpciones.show();

    }


    //Parar todos los sonidos y toast (metodo salir)
    public void checkSoundAndToast(){
        if(t!=null){
            t.cancel();
            soundPool.autoPause();
            soundPool.release();
            finish();
        } else {
            soundPool.autoPause();
            soundPool.release();
            finish();
        }
    }

    //Crear toast
    private void makeToast(String mensaje){
        if(t != null){ t.cancel(); }
        t = Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBackPressed() {
        checkSoundAndToast();
        super.onBackPressed();
    }

}