# Atividade-de-Programa-o-Orientada-a-Objetos

1. Qual é o principal conceito de Programação Orientada a Objetos?
O principal conceito da Programação Orientada a Objetos é organizar o programa por meio de objetos, que possuem características chamadas atributos e comportamentos chamados métodos.

A principal representação é a classe, que funciona como um modelo para criar objetos. Uma das principais linguagens utilizadas é Java. Nela, uma classe pode ser implementada utilizando a palavra class.

public class Pessoa {
    private String nome;

    public void falar() {
        System.out.println("Olá!");
    }
}
2. Encapsulamento
Encapsulamento é proteger os atributos de uma classe, impedindo que sejam acessados ou alterados diretamente de qualquer maneira.

Ele é importante porque oferece mais segurança, controle e organização ao código. Normalmente, os atributos são declarados como private e acessados pelos métodos:

get: utilizado para consultar um valor.
set: utilizado para alterar um valor.
public class Pessoa {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
3. Construtor
Um construtor é um método especial que possui o mesmo nome da classe e não apresenta tipo de retorno. Ele é executado quando um objeto é criado e serve para inicializar seus atributos.

public Pessoa(String nome) {
    this.nome = nome;
}
4. Herança e polimorfismo
Herança é o recurso que permite que uma classe receba atributos e métodos de outra classe. Seu principal benefício é o reaproveitamento de código.

Ela se relaciona com o polimorfismo porque objetos das classes filhas podem ser tratados como objetos da classe pai. Cada classe filha também pode apresentar um comportamento diferente ao sobrescrever um método herdado.

5. Sistema da empresa de transporte
O sistema cadastra clientes e comércios como remetente ou destinatário, recebe a distância da entrega e compara os custos de avião, barco, moto, carro e van para escolher a opção mais barata.

Diagrama de classes
Diagrama de classes

Implementação
O código completo está no arquivo Main.java.

Os valores das taxas são exemplos utilizados para que o sistema consiga comparar os transportes.

Conceitos aplicados
Encapsulamento: atributos privados e métodos públicos.
Construtores: inicialização dos objetos.
Herança: Cliente e Comercio herdam de ParteEntrega; os veículos herdam de Transporte.
Polimorfismo: diferentes veículos são tratados como Transporte durante a comparação.
