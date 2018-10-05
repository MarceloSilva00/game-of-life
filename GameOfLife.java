public class GameOfLife {


    static class Generation{
        private int num = 0;
        private int[][] generation = new int[15][15];
        private int[][] nextgeneration = new int[15][15];
        // 1- alive  2- dead

        public int getNum() {
            return this.num;
        }

        public int[][] getGeneration(){
            return generation;
        }


        public void nextgeneration() {
            num++;
            int count;
            for(int i=0; i<generation.length; i++){
                for(int j=0; j<generation[i].length; j++){
                    // Dead cells verify if change to live
                    count=0;
                    // CIMA
                    if(i-1>=0 && j-1>=0)
                        if(generation[i-1][j-1]==1)
                            count++;
                    if(i-1>=0)
                        if(generation[i-1][j]==1)
                            count++;
                    if(i-1>=0 && j+1<=generation[i].length-1)
                        if(generation[i-1][j+1]==1)
                            count++;
                    // MEIO
                    if(j-1>=0)
                        if(generation[i][j-1]==1)
                            count++;
                    if(j+1<=generation[i].length-1)
                        if(generation[i][j+1]==1)
                            count++;
                    // BAIXO
                    if(i+1<=generation.length-1 && j-1>=0)
                        if(generation[i+1][j-1]==1)
                            count++;
                    if(i+1<generation.length)
                        if(generation[i+1][j]==1)
                            count++;
                    if(i+1<generation.length && j+1<=generation[i].length-1)
                        if(generation[i+1][j+1]==1)
                            count++;


                    if(generation[i][j]==1){
                        if(count==2 || count==3){
                            nextgeneration[i][j]=1;
                        }else{
                            nextgeneration[i][j]=0;
                        }

                    }else{
                        if(count==3){
                            nextgeneration[i][j]=1;
                        }
                        else{
                            nextgeneration[i][j]=0;
                        }
                    }
                }
            }
            for(int i=0;i<generation.length;i++){
                for(int j=0; j<generation[i].length;j++){
                    generation[i][j] = nextgeneration[i][j];
                }
            }
        }

        public Generation() {
            this.generation[4][6]= 1;
            this.generation[5][5]= 1;
            this.generation[5][6]= 1;
            this.generation[5][7]= 1;
            this.generation[6][5]= 1;
            this.generation[6][7]= 1;
            this.generation[7][6]= 1;
        }
    }

    public static void main(String[] args){

        Generation generation = new Generation();


        for(int i=0; i<11 ; i++){
            System.out.println();
            System.out.println("---------------- "+ generation.getNum() + " ----------------");
            printGen(generation.getGeneration());
            generation.nextgeneration();
        }

    }

    public static void printGen(int[][] gen){
        for(int i=0; i<gen.length; i++){
            for(int j=0; j<gen[i].length; j++){
                if(gen[i][j]==1){
                    System.out.printf("#");
                }else{
                    System.out.printf(" ");
                }

            }
            System.out.println();
        }
    }


}
