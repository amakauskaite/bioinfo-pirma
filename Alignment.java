import java.lang.reflect.Array;
import java.util.ArrayList;

public class Alignment {

    // Transposes the triplets to amino acids and counts the frequency of the acid in the sequence
    public ArrayList<String> transpose(ArrayList<String> toTranspose) {
        ArrayList<String> transposedList = new ArrayList<String>();
        double codonFreq[][] = new double[toTranspose.size()][22];

        for (int j = 0; j < toTranspose.size(); j++) {
            StringBuilder transposed = new StringBuilder("");
            int n = toTranspose.get(j).length();

            // Goes through triplets and transposes to acids
            for (int i = 0; i < n; i = i + 3) {
                switch (toTranspose.get(j).substring(i, i + 3)) {
                    case "ATT":
                    case "ATC":
                    case "ATA":
                        transposed.append("I");
                        //adds to sum of this acid's occurence
                        codonFreq[j][0] += 1;
                        //adds to sum of total acid occurences
                        codonFreq[j][21] += 1;
                        break;
                    case "CTT":
                    case "CTC":
                    case "CTA":
                    case "CTG":
                    case "TTA":
                    case "TTG":
                        transposed.append("L");
                        codonFreq[j][1] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "GTT":
                    case "GTC":
                    case "GTA":
                    case "GTG":
                        transposed.append("V");
                        codonFreq[j][2] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "TTT":
                    case "TTC":
                        transposed.append("F");
                        codonFreq[j][3] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "ATG":
                        transposed.append("M");
                        codonFreq[j][4] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "TGT":
                    case "TGC":
                        transposed.append("C");
                        codonFreq[j][5] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "GCT":
                    case "GCC":
                    case "GCA":
                    case "GCG":
                        transposed.append("A");
                        codonFreq[j][6] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "GGT":
                    case "GGC":
                    case "GGA":
                    case "GGG":
                        transposed.append("G");
                        codonFreq[j][7] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "CCT":
                    case "CCC":
                    case "CCA":
                    case "CCG":
                        transposed.append("P");
                        codonFreq[j][8] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "ACT":
                    case "ACC":
                    case "ACA":
                    case "ACG":
                        transposed.append("T");
                        codonFreq[j][9] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "TCT":
                    case "TCC":
                    case "TCA":
                    case "TCG":
                    case "AGT":
                    case "AGC":
                        transposed.append("S");
                        codonFreq[j][10] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "TAT":
                    case "TAC":
                        transposed.append("Y");
                        codonFreq[j][11] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "TGG":
                        transposed.append("W");
                        codonFreq[j][12] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "CAA":
                    case "CAG":
                        transposed.append("Q");
                        codonFreq[j][13] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "AAT":
                    case "AAC":
                        transposed.append("N");
                        codonFreq[j][14] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "CAT":
                    case "CAC":
                        transposed.append("H");
                        codonFreq[j][15] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "GAA":
                    case "GAG":
                        transposed.append("E");
                        codonFreq[j][16] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "GAT":
                    case "GAC":
                        transposed.append("D");
                        codonFreq[j][17] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "AAA":
                    case "AAG":
                        transposed.append("K");
                        codonFreq[j][18] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "CGT":
                    case "CGC":
                    case "CGA":
                    case "CGG":
                    case "AGA":
                    case "AGG":
                        transposed.append("R");
                        codonFreq[j][19] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    case "TAA":
                    case "TAG":
                    case "TGA": //STOP
                        transposed.append("*");
                        codonFreq[j][20] += 1;
                        codonFreq[j][21] += 1;
                        break;
                    default:
                        //for testing purposes
                        System.out.println("Klaida! Tokio kodono negali buti! " + toTranspose.get(j).substring(i, i + 3));
                        break;
                }
            }

            transposedList.add(transposed.toString());


        }

        //prints out the codon frequency table
        for (int i = 0; i < toTranspose.size(); i++) {
            System.out.print((i + 1) + ": ");
            for (int j = 0; j < 21; j++) {
                // zero sums are printed out in cyan
                if (codonFreq[i][j] == 0)
                    System.out.print("\033[0;36m0,000 \033[0m");
                // if the frequency is equal or greater than 10%, it it printed out in blue
                else if ((codonFreq[i][j] / codonFreq[i][21]) >= 0.1) {
                    System.out.print("\033[0;34m");
                    System.out.print(String.format("%.3f",(codonFreq[i][j] / codonFreq[i][21])) + "\033[0m ");
                } else System.out.print(String.format("%.3f", (codonFreq[i][j] / codonFreq[i][21])) + " ");

            }
            System.out.println();
        }

        return transposedList;
    }

    // Counting the frequency of dicodons
    public void dicodons(ArrayList<String> acids) {

        ArrayList<String> foundPairs = new ArrayList<String>();
        //ArrayList<Integer> pairCount = new ArrayList<Integer>();

        int n = acids.size();
        // Finding all dicodon posibilities in the sequences
        for (int i = 0; i<n; i++)
        {
            String seq = acids.get(i);
            for (int j=0; j<seq.length(); j=j+2)
            {
                if (j+2<seq.length()&&!foundPairs.contains(seq.substring(j, j+2)))
                {
                    foundPairs.add(seq.substring(j, j+2));
                    //pairCount.add(0);
                }
                /*else
                {
                    //pairCount.set(foundPairs.indexOf(seq.substring(j, j+2)), pairCount.get(foundPairs.indexOf(seq.substring(j, j+2)))+1);

                }*/
            }
        }

        System.out.println("Rasti dikodonai:");
        System.out.print("  ");
        for (String pair: foundPairs
             ) {
            System.out.print(" "+pair+" ");

        }

        int m = foundPairs.size();
        double dicodonFreq[][] = new double[n][m];


        System.out.println("Dikodonu dazniai:");

        for (int i=0; i<n; i++)
        {
            String seq = acids.get(i);
            for (int j=0; j<seq.length(); j=j+2)
            {
                for (int k=0; k<m; k++)
                {
                    if (j+2<seq.length()&&seq.substring(j, j+2).equals(foundPairs.get(k)))
                    {
                        dicodonFreq[i][k]+=1;
                    }
                }
                //if (j+2<seq.length()&&)
            }
        }

        //prints out the dicodon frequency table
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ": ");
            for (int j = 0; j < m; j++) {
                // zero sums are printed out in cyan
                if (dicodonFreq[i][j] == 0)
                    System.out.print("\033[0;36m0.0 \033[0m");

                 else System.out.print(dicodonFreq[i][j] + " ");

            }
            System.out.println();
        }


    }


}
