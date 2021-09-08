package modelo.heranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AB")
public class AlunoBolsista extends Aluno{

    private double valorBolsa;

    public AlunoBolsista(Long matricula, String nome, double valorBolsa) {
        super(matricula, nome);
        this.valorBolsa = valorBolsa;
    }

    public AlunoBolsista() {
    }

    public double getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(double valorBolsa) {
        this.valorBolsa = valorBolsa;
    }
}
