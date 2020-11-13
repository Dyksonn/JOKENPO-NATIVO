package com.example.jo_ken_p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        ImageView imagemResultado = findViewById(R.id.imgResult);
        TextView textoResult = findViewById(R.id.txtResult);

        int numero = new Random().nextInt( 3 ); // 0, 1, 2
        String[] opcoes = { "pedra", "papel", "tesoura" };
        String opcaoApp = opcoes[ numero ];

        switch ( opcaoApp ) {
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (opcaoSelecionada == "tesoura" && opcaoApp == "pedra" ) ||
                (opcaoSelecionada == "papel" && opcaoApp == "tesoura") ||
                (opcaoSelecionada == "pedra" && opcaoApp == "papel")
        ) {//App ganhador
            textoResult.setText("Você Perdeu :(");
        } else if(
                (opcaoSelecionada == "tesoura" && opcaoApp == "papel") ||
                (opcaoSelecionada == "pedra" && opcaoApp == "tesoura") ||
                (opcaoSelecionada == "papel" && opcaoApp == "pedra")
        ){//Usuario ganhado
            textoResult.setText("Você ganhou :)");
        } else {//Empate
            textoResult.setText("Empatamos ;)");
        }

    }

}