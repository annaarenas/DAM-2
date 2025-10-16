import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        HashMap<Book, LinkedList<Member>> bookLoans = new HashMap<>();

        LinkedList<Member> members1 = new LinkedList<>();
        Member member1 = new Member("Alice", 1);
        Member member2 = new Member("Bob", 2);

        members1.add(member1);
        members1.add(member2);
        bookLoans.put(new Book("IT", "Stephen King"), members1);

        LinkedList<Member> members2 = new LinkedList<>();
        Member member3 = new Member("Charlie", 3);
        Member member4 = new Member("Diana", 4);

        members2.add(member3);
        members2.add(member4);
        bookLoans.put(new Book("El Plan Maestro", "Javier Sierra"), members2);

        LinkedList<Member> members3 = new LinkedList<>();
        Member member5 = new Member("Eve", 5);
        Member member6 = new Member("Frank", 6);

        members3.add(member5);
        members3.add(member6);

        bookLoans.put(new Book("Un cuento perfecto", "Elisabet Benavent"), members3);


        for (HashMap.Entry<Book, LinkedList<Member>> entry : bookLoans.entrySet()) {
            Book book = entry.getKey();
            LinkedList<Member> members = entry.getValue();

            System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor());
            System.out.println("Members:");
            for (Member member : members) {
                System.out.println("- " + member.getName() + " (ID: " + member.getMemberId() + ")");
            }
            System.out.println();
        }

    }
}