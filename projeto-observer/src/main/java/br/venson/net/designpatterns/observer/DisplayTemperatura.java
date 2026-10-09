package br.venson.net.designpatterns.observer;

public class DisplayTemperatura implements Observador {

    @Override
    public void atualizar(Medicao medicao) {
        System.out.println("Temperatura atual: " + medicao.temperatura() + "C");
    }
}
