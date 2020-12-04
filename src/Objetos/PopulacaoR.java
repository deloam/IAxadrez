package Objetos;

//Define uma população
public class PopulacaoR {

    private Rainha[] individuos;
    private int tamPopulacao;

    //Construtor dos Individuos(Rainhas)
    public PopulacaoR(int tamPop, boolean individuosAleatorios) {
        tamPopulacao = tamPop;
        individuos = new Rainha[tamPop];

        for (int i = 0; i < individuos.length; i++) {
            if (individuosAleatorios) {
                individuos[i] = new Rainha(true);
            } else {
                individuos[i] = null;
            }
        }
    }

    /*
     Seta um individuo(Rainha) em uma certa Posição
     individuo Rainha
      posicao posição em vetor (não valor da posição)
     */
    public void setIndividuo(Rainha individuo, int posicao) {
        individuos[posicao] = individuo;
    }

    public void setIndividuo(Rainha individuo) {
        for (int i = 0; i < individuos.length; i++) {
            if (individuos[i] == null) {
                individuos[i] = individuo;
                return;
            }
        }
    }

    public void ordenaPopulacao() {
        boolean trocou = true;
        while (trocou) {
            trocou = false;
            for (int i = 0; i < individuos.length - 1; i++) {
                if (individuos[i].getAptidao() > individuos[i + 1].getAptidao()) {
                    Rainha temp = individuos[i];
                    individuos[i] = individuos[i + 1];
                    individuos[i + 1] = temp;
                    trocou = true;
                }
            }
        }
    }
// retorna a quantidade de individuos validos
    public int getNumIndividuos() {
        int num = 0;
        for (Rainha individuo : individuos) {
            if (individuo != null) {
                num++;
            }
        }
        return num;
    }

    public double getMediaAptidao() {
        return getTotalAptidao() / getNumIndividuos();
    }

    public double getTotalAptidao() {
        double total = 0;
        for (Rainha individuo : individuos) {
            if (individuo != null) {
                total += individuo.getAptidao();
            }
        }
        return total;
    }
// retornna o tamanho da população
    public int getTamPopulacao() {
        return tamPopulacao;
    }
// retorna uma rainha em determinda posição
    public Rainha getIndivduo(int pos) {
        return individuos[pos];
    }
// retorna os individuas (rainhas)
    public Rainha[] getIndividuos() {
        return individuos;
    }
}