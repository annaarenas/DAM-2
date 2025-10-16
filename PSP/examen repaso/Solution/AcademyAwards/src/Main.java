import java.util.List;

public class Main {
    public static final String THE_OSCAR_AWARD_TSV = "the_oscar_award.tsv";

    public static void main(){
        List<Nomination> nominations = new FileHandler().readNominationFile(THE_OSCAR_AWARD_TSV);
        
    }
}
