import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ORFSearch find = new ORFSearch();
        Alignment align = new Alignment();
        ArrayList<String> orfs = new ArrayList<>();

        orfs = find.findORF(Data.plazmide, orfs);
        orfs = find.findORF(Data.plazmine_rev, orfs);
        orfs = find.findORF(Data.test, orfs);
        orfs = find.findORF(Data.test_rev, orfs);

        System.out.println("\nRastos "+orfs.size()+" ORF sekos:");
        for(int i = 0; i<orfs.size(); i++)
        {
            System.out.println((i+1)+". ilgis: "+orfs.get(i).length()+"bp\n"+orfs.get(i));
        }

        orfs = align.transpose(orfs);
        System.out.println("\nTransposed:");
        for(int i = 0; i<orfs.size(); i++)
        {
            System.out.println((i+1)+". ilgis: "+orfs.get(i).length()+"\n"+orfs.get(i));
        }

        align.dicodons(orfs);

    }
}
