package app.br.com.listadecompras.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Date;
import java.util.List;

import app.br.com.listadecompras.R;
import app.br.com.listadecompras.controller.CategoriaController;
import app.br.com.listadecompras.controller.ProdutoController;
import app.br.com.listadecompras.model.Categoria;
import app.br.com.listadecompras.model.Produto;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;

    NavigationView navigationView;

    Menu menu;
    MenuItem nav_preto;
    MenuItem nav_vermelho;
    MenuItem nav_azul;

    TextView txtTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab =   findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Action Button Clicado", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        txtTitulo = findViewById(R.id.txtTitulo);

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.content_fragment, new ModeloVermelhoFragment()).commit();

        manterCategoria();
        manterProduto();
    }

    private void manterCategoria() {
        CategoriaController controller =
                new CategoriaController();
        Categoria obj = new Categoria();

        obj.setNomeDaCategoria("Registro alterado");
        obj.setId(1);
        List<Categoria> listaDeCategorias = controller.listar();

        for (Categoria o: listaDeCategorias) {

            Log.i("db_log", "manterCategoria: ID"+o.getNomeDaCategoria());
            
        }



    }
    private void manterProduto(){
        ProdutoController controller = new ProdutoController();

        Produto obj = new Produto();

        obj.setNomeDoProduto("Produto teste2");
        obj.setUnidadeDeMedida("UN");
        obj.setQuantidade(11.55);
        obj.setPrecoPago(9.50);
        obj.setDataDaInclusao(new Date());
        obj.setCodigoDeBarras("0102030406");
        //obj.setImagem();nulo por enquanto
        obj.setId(3);
        controller.delete(obj);

        controller.insert(obj);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // TODO: opter ID para a opção selecionada no MENU DRAWER
        if (id == R.id.nav_meus_produtos) {

            menu = navigationView.getMenu();

            nav_preto = menu.findItem(R.id.nav_meus_produtos);
            nav_preto.setTitle("Meus Produtos");

            nav_vermelho = menu.findItem(R.id.nav_minhas_compras);
            nav_vermelho.setTitle("Minhas Compras");

            nav_azul = menu.findItem(R.id.nav_compartilhar);
            nav_azul.setTitle("Compartilhar");

            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new ModeloPretoFragment()).commit();

        } else if (id == R.id.nav_minhas_compras) {

            menu = navigationView.getMenu();

            nav_preto = menu.findItem(R.id.nav_meus_produtos);

            nav_preto.setTitle("Preto");

            nav_vermelho = menu.findItem(R.id.nav_minhas_compras);
            nav_vermelho.setTitle("Vermelho Ativado");

            nav_azul = menu.findItem(R.id.nav_compartilhar);
            nav_azul.setTitle("Azul");

            // TODO: Mudar a cor de todos os itens do menu programaticamente
            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new ModeloVermelhoFragment()).commit();

        } else if (id == R.id.nav_compartilhar) {

            menu = navigationView.getMenu();

            nav_preto = menu.findItem(R.id.nav_meus_produtos);
            nav_preto.setTitle("Preto");

            nav_vermelho = menu.findItem(R.id.nav_minhas_compras);
            nav_vermelho.setTitle("Vermelho");

            nav_azul = menu.findItem(R.id.nav_compartilhar);
            nav_azul.setTitle("Azul Ativado");

            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new ModeloAzulFragment()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
