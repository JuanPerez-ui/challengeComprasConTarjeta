package com.aluracursos.challenge3.principal;

import com.aluracursos.challenge3.modelos.Compra;
import com.aluracursos.challenge3.modelos.CuentaUsuario;

import java.util.Collections;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int salir = 1;
        String descripcion;
        double valor;

        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el limite de la tarjeta");
        double limite = lectura.nextDouble();
        CuentaUsuario nuevoUsuario = new CuentaUsuario(limite);



        while (salir != 0){
            System.out.println("Escriba la descripcion de la compra");
            descripcion= lectura.next();

            System.out.println("Ingrese el valor de la compra");
            valor=lectura.nextDouble();

            Compra compra= new Compra(valor,descripcion);
            boolean compraRealizada = nuevoUsuario.lanzarCompra(compra);

            if (compraRealizada){
                System.out.println("Compra realizada");
                System.out.println("Escriba 0 para salir o 1 para continuar");
                salir= lectura.nextInt();
            }else {
                System.out.println("Saldo insuficiente");
                salir=0;
            }
        }

        System.out.println("***********************************");
        System.out.println("COMPRAS REALIZADAS");

        Collections.sort(nuevoUsuario.getListaDeCompras());

        for (Compra compra : nuevoUsuario.getListaDeCompras()){
            System.out.println(compra.getDescripcion() + " - $" + compra.getValor());
        }

        System.out.println("***********************************");
        System.out.println("SALDO DE LA TARJETA: $" + nuevoUsuario.getSaldoUsuario());


    }
}
