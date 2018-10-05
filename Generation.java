public class Generation {
    private int num = 0;
    private int[][] generation;
    private int[][] nextGeneration;
    // 1- alive  2- dead

    public Generation(int[][] seed, int height, int width) {
        if(seed.length > height) {
            throw new IllegalArgumentException();
        }

        if(seed.length > 0 && seed[0].length > width) {
            throw new IllegalArgumentException();
        }

        generation = new int[height][width];
        nextGeneration = new int[height][width];

        for(int i = 0; i < seed.length; i++) {
            for(int j = 0; j < seed[i].length; j++) {
                generation[i][j] = seed[i][j];
            }
        }
    }

    public int getNum() {
        return this.num;
    }

    public int[][] getGeneration(){
        return generation;
    }

    public void nextGeneration() {
        num++;
        int count;
        for(int i=0; i<generation.length; i++){
            for(int j=0; j<generation[i].length; j++){
                // Dead cells verify if change to live
                count=0;
                // TOP
                if(i-1>=0 && j-1>=0)
                    if(generation[i-1][j-1]==1)
                        count++;
                if(i-1>=0)
                    if(generation[i-1][j]==1)
                        count++;
                if(i-1>=0 && j+1<=generation[i].length-1)
                    if(generation[i-1][j+1]==1)
                        count++;
                // MID
                if(j-1>=0)
                    if(generation[i][j-1]==1)
                        count++;
                if(j+1<=generation[i].length-1)
                    if(generation[i][j+1]==1)
                        count++;
                // BOTTOM
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
                        nextGeneration[i][j]=1;
                    }else{
                        nextGeneration[i][j]=0;
                    }

                }else{
                    if(count==3){
                        nextGeneration[i][j]=1;
                    }
                    else{
                        nextGeneration[i][j]=0;
                    }
                }
            }
        }
        for(int i=0;i<generation.length;i++){
            for(int j=0; j<generation[i].length;j++){
                generation[i][j] = nextGeneration[i][j];
            }
        }
    }

    public static void print(int[][] gen, char alive, char dead) {
        for(int i=0; i<gen.length; i++){
            for(int j=0; j<gen[i].length; j++){
                if(gen[i][j]==1){
                    System.out.print(alive);
                }else{
                    System.out.print(dead);
                }

            }
            System.out.println();
        }
    }

}

