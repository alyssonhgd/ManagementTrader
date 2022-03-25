package com.example.managementtrader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthRegistrar;
import com.google.firebase.auth.FirebaseUser;

public class actCadastro extends AppCompatActivity {
    private static final String TAG = "Login sucedido";
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_cadastro);
        EditText editLogin;
        EditText editSenha;
        //Cliq em voltar cahama metodo
        Button bttVoltar = (Button) findViewById(R.id.bttVoltar);
        bttVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                metodoVoltar(v);
            }

        });
        //Clique em cadastrar
        Button bttCadastrar = (Button) findViewById(R.id.bttCadastrar);
        bttCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editLogin = (EditText) findViewById(R.id.editEmail);
                EditText editSenha = (EditText) findViewById(R.id.editSenha);
                String email = editLogin.getText().toString();
                String senha = editSenha.getText().toString();
                Cadastrar(v,email,senha);
            }
        });
    }

    private void Cadastrar(final View v, String email, String senha) {
        mAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(actCadastro.this, "Usuário Cadastrado com sucesso!",Toast.LENGTH_SHORT).show();
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");

                            FirebaseUser user = mAuth.getCurrentUser();
                            metodoVoltar(v);
                        } else {
                            Toast.makeText(actCadastro.this, "Falha no Cadastro! Tente Novamente!",
                                    Toast.LENGTH_SHORT).show();
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        }
                    }


                });
    }

    private void metodoVoltar(View v) {
        Intent intent = new Intent(actCadastro.this,Act_Login.class);
        finish();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }




}
