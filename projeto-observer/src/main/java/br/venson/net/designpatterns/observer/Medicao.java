package br.venson.net.designpatterns.observer;

// Agrupa os dados de uma leitura da estacao. Se um dia entrar velocidade do
// vento, por exemplo, a assinatura de atualizar(...) continua a mesma.
public record Medicao(double temperatura, double umidade, double pressao) {
}
