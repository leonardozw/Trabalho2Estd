class Program{

    //Random Vector
    public static int[] createVector1000(){
        int vector[] = new int[1000];
        int max = vector.length;
        int min = 1;
        int range = max-min+1;
        for(int i = 0; i < vector.length; i++){
            int rand = (int) (Math.random() * range) + min;
            vector[i] = rand;
        }
        return vector;
    }

    public static int[] createVector500(){
        int vector[] = new int[500];
        int max = vector.length;
        int min = 1;
        int range = max-min+1;
        for(int i = 0; i < vector.length; i++){
            int rand = (int) (Math.random() * range) + min;
            vector[i] = rand;
        }
        return vector;
    }

    public static int[] createVector100(){
        int vector[] = new int[100];
        int max = vector.length;
        int min = 1;
        int range = max-min+1;
        for(int i = 0; i < vector.length; i++){
            int rand = (int) (Math.random() * range) + min;
            vector[i] = rand;
        }
        return vector;
    }

    //Swap
    public static void swap(int v[], int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
       
    //Bubble Sort
    public static void bubblesort1(int v[]) {
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = i + 1; j < v.length; j++) {
                if (v[i] > v[j]) { 
                    swap(v, i, j);
                } 
            }
        }
    }
       
    public static void bubblesort2(int v[]) {
        boolean troca;
        do {
            troca = false;
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i] > v[i + 1]) { 
                    swap(v, i, i + 1);
                    troca = true;
                 }
            }
        } while (troca);
    }

    //Insertion Sort
    public static void insertionsort(int v[]) {
        int pivo, j;
        for (int i = 1; i < v.length; i++) {
            pivo = v[i];
            j = i - 1;
            
            while (j >= 0 && pivo < v[j]) {
                v[j + 1] = v[j]; 
                j--;
            }
            v[j + 1] = pivo;
        }
    }
       
    //Heap Sort
    public static void heapify(int v[], int n, int i) {
        int raiz = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        
        if (esquerda < n && v[esquerda] > v[raiz]) raiz = esquerda; 
        if (direita < n && v[direita] > v[raiz]) raiz = direita; 
        
        if (raiz != i) { 
            swap(v, i, raiz); 
            heapify(v, n, raiz); 
        }
    }

    public static void heapsort(int v[]) {
        for (int i = v.length / 2 - 1; i >= 0; i--) {
        heapify(v, v.length, i);
        }

        for (int i = v.length - 1; i > 0; i--) {
        swap(v, 0, i); 
        
        heapify(v, i, 0); 
        }
    }
    
    //Merge Sort
    public static void merge(int v[], int inicio, int meio, int fim) {
        int aux[] = new int[fim - inicio + 1];
        int i = inicio, j = meio + 1, k = 0;

        while (i <= meio && j <= fim) { 
            aux[k++] = v[i] <= v[j] ? v[i++] : v[j++];
        }
        while (i <= meio) aux[k++] = v[i++]; 
        while (j <= fim) aux[k++] = v[j++]; 
        
        for (i = inicio, k = 0; i <= fim; i++, k++) { 
            v[i] = aux[k];
        }
    }

    public static void mergesort(int v[]) {
        mergesort(v, 0, v.length - 1);
    }

    public static void mergesort(int v[], int inicio, int fim) {
        int meio = (inicio + fim) / 2;
        
        if (inicio < fim) {
            mergesort(v, inicio, meio); 
            mergesort(v, meio + 1, fim);
            
            merge(v, inicio, meio, fim); 
        }
    }

    public static void mergesortBU(int v[]) {
        mergesortBU(v, 0, v.length - 1);
    }

    public static void mergesortBU(int v[], int inicio, int fim) {
        int i, meio;
        for (meio = 1; meio < fim - inicio + 1; meio = 2 * meio) { 
            for (i = inicio; i <= fim - meio; i += 2 * meio) { 
                int j = (i + (2 * meio)) - 1;
                if (j > fim) j = fim;
                merge(v, i, i + meio - 1, j); 
            }
        }
    }

    //Quick Sort
    public static int partition(int v[], int inicio, int fim) {
        int pivo = v[fim]; 
        int i = (inicio - 1);   
        for (int j = inicio; j <= fim - 1; j++) {
            if (v[j] < pivo) { 
                i++; 
        
                swap(v, i, j); 
            }
        }
        swap(v, i + 1, fim); 
        return i + 1; 
    }

    public static void quicksort(int v[]) {
        quicksort(v, 0, v.length - 1);
    }

    public static void quicksort(int v[], int inicio, int fim) {
        if (inicio < fim) {
            int meio = partition(v, inicio, fim);
            quicksort(v, inicio, meio - 1); 
            quicksort(v, meio + 1, fim); 
        }
    }   
       
    public static void main(String[] args) {
        int vector1000[] = createVector1000();
        int vector500[] = createVector500();
        int vector100[] = createVector100();
        int vector0[] = new int[0];
        long avgtest[] = new long[10];
        long res = 0;

        
        /*
        bubblesort1
        bubblesort2;
        heapsort;
        insertionsort;
        mergesort;
        mergesortBU;
        quicksort;
        */

        //0
        for(int i = 0; i < 10; i++){
            long start1 = System.nanoTime();
            mergesortBU(vector0);
            long end1 = System.nanoTime();
            res = end1-start1;
            avgtest[i] = res;
        }
        for(int i = 0; i < 10; i++){
            System.out.print(avgtest[i]+" ");
            res += avgtest[i];
        }
        System.out.println("avg:" + res/10);
        
        //100
        for(int i = 0; i < 10; i++){
            long start1 = System.nanoTime();
            quicksort(vector100);
            long end1 = System.nanoTime();
            res = end1-start1;
            avgtest[i] = res;
        }
        for(int i = 0; i < 10; i++){
            System.out.print(avgtest[i]+" ");
            res += avgtest[i];
        }
        System.out.println("avg:" + res/10);
        //500
        for(int i = 0; i < 10; i++){
            long start1 = System.nanoTime();
            quicksort(vector500);
            long end1 = System.nanoTime();
            res = end1-start1;
            avgtest[i] = res;
        }
        for(int i = 0; i < 10; i++){
            System.out.print(avgtest[i]+" ");
            res += avgtest[i];
        }
        System.out.println("avg:" + res/10);
        //1000
        for(int i = 0; i < 10; i++){
            long start1 = System.nanoTime();
            quicksort(vector1000);
            long end1 = System.nanoTime();
            res = end1-start1;
            avgtest[i] = res;
        }
        for(int i = 0; i < 10; i++){
            System.out.print(avgtest[i]+" ");
            res += avgtest[i];
        }
        System.out.println("avg:" + res/10);

        /*for(int i : vector){
            System.out.print(i);
        }*/
        
    }
       
}
