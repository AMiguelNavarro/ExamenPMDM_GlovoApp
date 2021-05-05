package com.example.glovo.listadoCategorias;

import android.content.Context;
import com.example.glovo.beans.Categoria;
import java.util.ArrayList;

public interface ListadoCategoriasContrato {

    interface Vista {
        void listadoCategoriasCorrecto(ArrayList<Categoria> listaCategorias);
        void listadoCategoriasError(String error);
    }

    interface Presenter{
        void getCategorias(Context context);
    }

    interface Modelo{

        interface OnListenerCategoria{
            void onCorrecto(ArrayList<Categoria> listaCategorias);
            void onError(String error);
        }

        void getCategoriasWS(Context context, ListadoCategoriasContrato.Modelo.OnListenerCategoria listener);

    }

}
