/**
 *
 * @author İsmail BOZKURT
 */
public class Graf {
    int V;
    int E;
    Kenar kenar[];

    public Graf(int dugum, int kenar) {
        this.V = dugum;
        this.E = kenar;
        this.kenar = new Kenar[kenar];
        for (int i = 0; i < kenar; ++i) {
            this.kenar[i] = new Kenar();
        }
    }

    public void bellmanFord(Graf graf, int dugum) {
        int V = graf.V;
        int E = graf.E;

        int mesafe[] = new int[V];

        for (int i = 0; i < V; i++) {
            mesafe[i] = 99999;
//            mesafe[i] = Integer.MAX_VALUE;
        }
        mesafe[dugum] = 0;

        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = graf.kenar[j].dugum;
                int v = graf.kenar[j].komsu;
                int agirlik = graf.kenar[j].agirlik;
                if (mesafe[u] != 99999 && mesafe[u] + agirlik < mesafe[v]) {
                    mesafe[v] = mesafe[u] + agirlik;
                }
            }
        }
        
        for (int j = 0; j < E; ++j) { 
            int u = graf.kenar[j].dugum; 
            int v = graf.kenar[j].komsu; 
            int agirlik = graf.kenar[j].agirlik; 
            if (mesafe[u] != 99999 && mesafe[u] + agirlik < mesafe[v]) { 
                System.out.println("NEGATIF AGIRLIK DONGUSU MEVCUT"); 
                return; 
            } 
        }
        yazdir(mesafe, V);
    }
    void yazdir(int mesafe[], int V) 
    { 
        System.out.println("DUGUMDEN KOSELERE UZAKLIKLAR"); 
        for (int i = 0; i < V; ++i) 
            System.out.println(i + "\t\t" + mesafe[i]); 
    }
}