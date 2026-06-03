public interface ElementoVisivel {
    String obterAparencia();
    String buscarSimbolo();
    boolean estaExposta();
    void mudarStatusExposicao(boolean status);
}