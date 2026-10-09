package br.venson.net.designpatterns.observer;

// Display novo: foi so criar a classe. A EstacaoMeteorologica nao mudou.
public class DisplayUmidade implements Observador {

    @Override
    public void atualizar(Medicao medicao) {
        System.out.println("Umidade relativa: " + medicao.umidade() + "%");
    }
}
