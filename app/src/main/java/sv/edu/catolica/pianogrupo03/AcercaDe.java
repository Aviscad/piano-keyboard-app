package sv.edu.catolica.pianogrupo03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
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
                finish();
                break;

            case R.id.op_salir:
                finish();
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
                    finish();
                }else if(which ==1){
                    Intent toJunglePiano = new Intent(getApplicationContext(), JunglePiano.class);
                    startActivity(toJunglePiano);
                    finish();
                } else if(which == 2){
                    Intent toInstrumentsPiano = new Intent(getApplicationContext(), InstrumentsPiano.class);
                    startActivity(toInstrumentsPiano);
                    finish();
                }
            }
        });
        cuadroOpciones.create();
        cuadroOpciones.show();

    }


    @Override
    public void onBackPressed() {
        finish();
    }
}