package br.venson.net.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class EstacaoMeteorologica implements Sujeito {

    private double temperatura;
    private double umidade;
    private double pressao;

    private final List<Observador> observadores = new ArrayList<>();

    @Override
    public void registrarObservador(Observador observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    @Override
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        Medicao medicao = new Medicao(temperatura, umidade, pressao);
        // Percorre uma copia para que um observador possa se remover durante o aviso.
        for (Observador observador : new ArrayList<>(observadores)) {
            observador.atualizar(medicao);
        }
    }

    public void setMedicoes(double temperatura, double umidade, double pressao) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pressao = pressao;

        // A estacao nao sabe mais quem esta ouvindo, so avisa a lista.
        notificarObservadores();
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getUmidade() {
        return umidade;
    }

    public double getPressao() {
        return pressao;
    }
}
