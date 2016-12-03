package sim.app.nqueens;

import sim.engine.SimState;
import sim.engine.Steppable;
/**
 *
 * @author bruno
 */
public class Queen implements Steppable {

   
        private int linha;
        private int coluna;
    private boolean conflito = true;
        private int []colunaAntiga = new int[4];

        public Queen(){
       
        }
        
        public Queen(int l, int c){
            this.linha = l;
            this.coluna = c;
        }

        public void Queen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
    public void step(SimState state) {
        
    }

/**
     * @return the linha
     */
    public int getLinha() {
        return linha;
    }

    /**
     * @param linha the linha to set
     */
    public void setLinha(int linha) {
        this.linha = linha;
    }

    /**
     * @return the coluna
     */
    public int getColuna() {
        return coluna;
    }

    /**
     * @param coluna the coluna to set
     */
    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
       

    /**
     * @return the conflito
     */
    public boolean isConflito() {
        return conflito;
    }

    /**
     * @param conflito the conflito to set
     */
    public void setConflito(boolean conflito) {
        this.conflito = conflito;
    }
    
    public void recebeColuna(int []b){
       this.colunaAntiga = b;
    }
    
     /**
     * @return the colunaAntiga
     */
    public int[] getColunaAntiga() {
        return colunaAntiga;
    }

    /**
     * @param colunaAntiga the colunaAntiga to set
     */
    public void setColunaAntiga(int []colunaAntiga) {
        this.colunaAntiga = colunaAntiga;
    }

     

}