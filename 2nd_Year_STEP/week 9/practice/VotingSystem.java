public class VotingSystem {
    public void processVote(String voterId, String candidate) {
        class VoteValidator {
            public boolean validate() {
                return voterId != null && voterId.matches("VOTER\\d{3}");
            }
        }

        VoteValidator validator = new VoteValidator();
        if (validator.validate()) {
            System.out.println("Voter " + voterId + " vote for " + candidate + " is accepted.");
        } else {
            System.out.println("Voter " + voterId + " is invalid. Vote rejected.");
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.processVote("VOTER001", "Alice");
        system.processVote("VOTER123", "Bob");
        system.processVote("INVALID1", "Charlie");
        system.processVote(null, "David");
    }
}