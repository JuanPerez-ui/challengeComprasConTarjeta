package com.aluracursos.challenge3.modelos;

import java.util.ArrayList;
import java.util.List;

public class CuentaUsuario {
    private double saldoUsuario;
    private double limite;
    private List<Compra> listaDeCompras;

    public CuentaUsuario(double limite) {
        this.limite = limite;
        this.saldoUsuario=limite;
        this.listaDeCompras=new ArrayList<>();
    }

    public boolean lanzarCompra (Compra compra){
        if (this.saldoUsuario >= compra.getValor() ){
            this.saldoUsuario -= compra.getValor();
            this.listaDeCompras.add(compra);
            return true;
        }else{
            return false;
        }
    }

    public double getSaldoUsuario() {
        return saldoUsuario;
    }

    public double getLimite() {
        return limite;
    }

    public List<Compra> getListaDeCompras() {
        return listaDeCompras;
    }


}
