import java.util.Scanner;
class Candidate {
    int Candidate_Id;
    String name;
    int aptitude;
    int technical;
    int communication;
    Candidate(int Candidate_Id, String name, int aptitude,
              int technical, int communication) {
        this.Candidate_Id = Candidate_Id;
        this.name = name;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
    }
    int getTotalScore() {
        return aptitude + technical + communication;
    }
}
public class CandidateDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Candidate[] candidates = new Candidate[N];
        for (int i = 0; i < N; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int aptitude = sc.nextInt();
            int technical = sc.nextInt();
            int communication = sc.nextInt();
            candidates[i] = new Candidate(
                id, name, aptitude, technical, communication
            );
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int total1 = candidates[i].getTotalScore();
                int total2 = candidates[j].getTotalScore();
                if (total1 < total2 ||
                   (total1 == total2 &&
                    candidates[i].Candidate_Id > candidates[j].Candidate_Id)) {
                    Candidate temp = candidates[i];
                    candidates[i] = candidates[j];
                    candidates[j] = temp;
                }
            }
        }
        for (int i = 0; i < K; i++) {
            System.out.println(
                candidates[i].Candidate_Id + " " +
                candidates[i].name + " " +
                candidates[i].getTotalScore()
            );
        }
        sc.close();
    }
}
