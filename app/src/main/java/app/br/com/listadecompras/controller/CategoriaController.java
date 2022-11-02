package app.br.com.listadecompras.controller;

import java.util.List;

import app.br.com.listadecompras.model.Categoria;
import io.realm.Realm;

public class CategoriaController implements ICrud<Categoria>{


    @Override
    public void insert(Categoria obj) {

        Realm realm = Realm.getDefaultInstance();

        Number primaryKey = realm.where(Categoria.class).max("id");
        final int autoIncrementPrimaryKey =
                (primaryKey==null) ? 1 : primaryKey.intValue() + 1;

        obj.setId(autoIncrementPrimaryKey);

        realm.beginTransaction();
        realm.copyToRealm(obj);
        realm.commitTransaction();
        realm.close();

    }

    @Override
    public void update(Categoria obj) {

        Realm realm = Realm.getDefaultInstance();

        Categoria categoria = realm.where(Categoria.class).equalTo("id", obj.getId()).findFirst();

        if (categoria != null){

            realm.beginTransaction();
            categoria.setNomeDaCategoria(obj.getNomeDaCategoria());
            categoria.setImagemCategoria(obj.getImagemCategoria());
            realm.commitTransaction();

        }
        realm.close();

    }

    @Override
    public void delete(Categoria obj) {

    }

    @Override
    public void deleteByID(Categoria obj) {

    }

    @Override
    public List<Categoria> listar(Categoria obj) {
        return null;
    }
}
