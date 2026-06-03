import java.io.Serializable;

public class RodadaAtual implements Serializable {
    private Competidor competidor;
    private MesaDeJogo mesa;
    private int acertosAtuais;

    public RodadaAtual(Competidor competidor, MesaDeJogo mesa, int acertos) {
        this.competidor = competidor;
        this.mesa = mesa;
        this.acertosAtuais = acertos;
    }

    public Competidor getCompetidor() { return competidor; }
    public MesaDeJogo getMesa() { return mesa; }
    public int getAcertosAtuais() { return acertosAtuais; }
}