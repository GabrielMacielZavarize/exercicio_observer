package br.venson.net.designpatterns.observer;

public class Main {

    public static void main(String[] args) {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica();

        // O painel e montado aqui fora. A estacao so recebe quem quer ouvir.
        DisplayTemperatura temperatura = new DisplayTemperatura();
        DisplayEstatisticas estatisticas = new DisplayEstatisticas();
        estacao.registrarObservador(temperatura);
        estacao.registrarObservador(estatisticas);

        System.out.println("-- medicao 1");
        estacao.setMedicoes(25.0, 60.0, 1013.0);

        // Registro em tempo de execucao: entra um display de umidade.
        estacao.registrarObservador(new DisplayUmidade());

        System.out.println("-- medicao 2");
        estacao.setMedicoes(27.0, 55.0, 1010.0);

        // Remocao em tempo de execucao: o display de temperatura sai do painel.
        estacao.removerObservador(temperatura);

        // Como Observador tem um metodo so, da pra registrar ate um lambda.
        estacao.registrarObservador(m -> {
            if (m.temperatura() > 30) {
                System.out.println("ALERTA: calor acima de 30C");
            }
        });

        System.out.println("-- medicao 3");
        estacao.setMedicoes(32.0, 40.0, 1008.0);
    }
}
