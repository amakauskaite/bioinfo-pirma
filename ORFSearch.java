import java.util.ArrayList;

public class ORFSearch {

    String start = "ATG";
    String stop1 = "TAA";
    String stop2 = "TAG";
    String stop3 = "TGA";
    ArrayList<String> orf = new ArrayList<>();

    public ArrayList<String> findORF (String fullSequence, ArrayList<String> orfs)
    {

        orf = orfs;
        int n = fullSequence.length();

        //Forward search, first frame
        for (int i = 0; i<n; i=i+3)
        {
            //Checks if the triplet is the START codon
            if (i+3 <= n && fullSequence.substring(i, i+3).equals(start))
            {
                //System.out.println("--> ATG pozicija:" + i);
                // If it's the start of an ORF - find the end of it and return the index from where to search further
                i = newI(i, n, fullSequence);
            }

            //findEndCodon(fullSequence, i, n);
        }
        //Forward search, second frame
        for (int i = 1; i<fullSequence.length(); i+=3)
        {
            if (i+3 <= n && fullSequence.substring(i, i+3).equals(start))
            {
                //System.out.println("--> ATG pozicija:" + i);
                i = newI(i, n, fullSequence);
            }
        }
        //Forward search, third frame
        for (int i = 2; i<fullSequence.length(); i+=3) {
            if (i + 3 <= n && fullSequence.substring(i, i + 3).equals(start)) {
                //System.out.println("--> ATG pozicija:" + i);
                i = newI(i, n, fullSequence);
            }
        }
        return orf;

        // NOTE: this function only searches forward, so for backwards search, pass the flipped sequence through the parameters

    }

    // True when the triplet equals one of the possible STOP triplets
    public boolean isEnd(String codon)
    {
        if(codon.equals(stop1)||codon.equals(stop2)||codon.equals(stop3))
            return true;
        else return false;
    }

    // Returns new iterator value (from where to continue searching) after the end of the ORF is found
    //Also, adds new found ORF to list
    public int newI(int i, int n, String fullSequence){
        for (int j = i; j < n; j = j + 3) {
            if (j + 3 <= n && isEnd(fullSequence.substring(j, j + 3))) {
                //System.out.println("<-- Pab. pozicija: " + j+3);

                // Only adds to list if the ORF is longer than 100bp
                if (j-i>=100)
                {
                    //System.out.println("Sis kodonas ilgenis uz 100");
                    // Prints start and end positions
                    System.out.println((i+1)+"->"+(j+3));
                    //Adds orf to ORF list
                    orf.add(fullSequence.substring(i, j+3));
                }

                return j+3;
                //break;
            }
        }
        return n;
    }
}
