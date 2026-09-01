import java.util.ArrayList;
import java.util.List;

abstract class ParteEntrega {
    private String nome;
    private String endereco;

    public ParteEntrega(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }
}

class Cliente extends ParteEntrega {
    private String cpf;

    public Cliente(String nome, String endereco, String cpf) {
        super(nome, endereco);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}

class Comercio extends ParteEntrega {
    private String cnpj;

    public Comercio(String nome, String endereco, String cnpj) {
        super(nome, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
}

abstract class Transporte {
    private String tipo;
    private double taxaFixa;
    private double custoPorKm;

    public Transporte(String tipo, double taxaFixa, double custoPorKm) {
        this.tipo = tipo;
        this.taxaFixa = taxaFixa;
        this.custoPorKm = custoPorKm;
    }

    public String getTipo() {
        return tipo;
    }

    public double calcularCusto(double distancia) {
        return taxaFixa + custoPorKm * distancia;
    }
}

class Aviao extends Transporte {
    public Aviao() {
        super("Avião", 250.00, 0.12);
    }
}

class Barco extends Transporte {
    public Barco() {
        super("Barco", 100.00, 0.18);
    }
}

class Moto extends Transporte {
    public Moto() {
        super("Moto", 10.00, 0.80);
    }
}

class Carro extends Transporte {
    public Carro() {
        super("Carro", 20.00, 0.55);
    }
}

class Van extends Transporte {
    public Van() {
        super("Van", 40.00, 0.40);
    }
}

class Entrega {
    private ParteEntrega remetente;
    private ParteEntrega destinatario;
    private double distancia;
    private List<Transporte> transportes;

    public Entrega(ParteEntrega remetente, ParteEntrega destinatario, double distancia) {
        if (distancia <= 0) {
            throw new IllegalArgumentException("A distância deve ser maior que zero.");
        }

        this.remetente = remetente;
        this.destinatario = destinatario;
        this.distancia = distancia;

        transportes = new ArrayList<>();
        transportes.add(new Aviao());
        transportes.add(new Barco());
        transportes.add(new Moto());
        transportes.add(new Carro());
        transportes.add(new Van());
    }

    public Transporte escolherTransporteMaisBarato() {
        Transporte maisBarato = transportes.get(0);

        for (Transporte transporte : transportes) {
            double custoAtual = transporte.calcularCusto(distancia);
            double menorCusto = maisBarato.calcularCusto(distancia);

            if (custoAtual < menorCusto) {
                maisBarato = transporte;
            }
        }

        return maisBarato;
    }

    public void exibirEntrega() {
        Transporte escolhido = escolherTransporteMaisBarato();
        double valor = escolhido.calcularCusto(distancia);

        System.out.println("Remetente: " + remetente.getNome());
        System.out.println("Destinatário: " + destinatario.getNome());
        System.out.println("Distância: " + distancia + " km");
        System.out.println("Transporte mais barato: " + escolhido.getTipo());
        System.out.printf("Valor da entrega: R$ %.2f%n", valor);
    }
}

public class Main {
    public static void main(String[] args) {
        Comercio remetente = new Comercio(
                "Loja Central",
                "Rua das Flores, 100",
                "12.345.678/0001-90");

        Cliente destinatario = new Cliente(
                "João da Silva",
                "Avenida Brasil, 500",
                "123.456.789-00");

        Entrega entrega = new Entrega(remetente, destinatario, 300.0);
        entrega.exibirEntrega();
    }
}
