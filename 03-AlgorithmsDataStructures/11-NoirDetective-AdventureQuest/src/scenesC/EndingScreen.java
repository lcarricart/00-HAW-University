package scenesC;

import scenes.NodeScene;

public class EndingScreen extends NodeScene {
    
    // These variables hold the specific details of how the game ended
    private String missionStatus;
    private String detailedReason;
    private String detectiveRank;
    private int finalScore;

    public EndingScreen(String uniqueName) {
        super(uniqueName);
        // Default values (initialization happens in constructors usually, remember!!)
        this.missionStatus = "UNKNOWN";
        this.detailedReason = "Signal lost...";
        this.detectiveRank = "F";
        this.finalScore = 0;
    }

    // Call this method right before switching to this scene to customize the ending
    public void setReport(String status, String reason, String rank, int score) {
        this.missionStatus = status;
        this.detailedReason = reason;
        this.detectiveRank = rank;
        this.finalScore = score;
    }
    
    // Based on all the paths the user went through (reflected on the score), the setReport() is crafter here
    private void analyseReport(int finalScore) {
    	if (finalScore == 0) {
    		setReport(
			    "KILLED IN ACTION", 
			    "Subject refused to engage. Neutralized by debt collector (Sal) while sleeping. Zero survival instinct exhibited.", 
			    "F", 
			    0
			);
    	} else if (finalScore == 50) {
    		setReport(
			    "COLD CASE", 
			    "The lead on Sal proved inconclusive. Investigation stalled due to lack of further actions.", 
			    "C", 
			    50
			);
    	} else if (finalScore == 80) {
    		setReport(
			    "MISSION SUCCESS", 
			    "Target location confirmed via digital forensics. Suspect evaded capture, but the trail to the Shipyards is open.", 
			    "B+", 
			    80
			);
    	} else if (finalScore == 100) {
    		setReport(
			    "EXEMPLARY PERFORMANCE", 
			    "High-value intel recovered. Security override codes obtained. Enemy faction (Korov Syndicate) identified.", 
			    "S", 
			    100
			);
    	}
    }
    
    public void setPartialScore(int partialScore) {
    	this.finalScore += partialScore;
    }

    @Override
    public void start() {
    	analyseReport(finalScore);
    	
        System.out.println("___________________________________________________________");
        System.out.println("|                                                         |");
        System.out.println("|                 N.C.P.D. CASE FILE 209                  |");
        System.out.println("|                    - FINAL REPORT -                     |");
        System.out.println("|_________________________________________________________|");
        System.out.println("");
        System.out.println("  > OPERATIVE: Jack");
        System.out.println("  > MISSION STATUS: [" + missionStatus.toUpperCase() + "]");
        System.out.println("");
        System.out.println("  > DEBRIEFING:");
        System.out.println("    " + detailedReason);
        System.out.println("");
        System.out.println("-----------------------------------------------------------");
        System.out.println("  PERFORMANCE EVALUATION");
        System.out.println("-----------------------------------------------------------");
        System.out.println("");
        System.out.println("  > INTEL GATHERED: " + finalScore + "/100");
        System.out.println("");
        System.out.println("  > DETECTIVE RANK:  [" + detectiveRank + "]");
        System.out.println("");
        System.out.println("___________________________________________________________");
        
        // Dynamic message based on rank (Optional flavor text)
        if (detectiveRank.equals("S")) {
            System.out.println("  \"Damn fine work. Your deductive skills are legendary.\"");
        } 
        else if (detectiveRank.equals("B+")) {
            System.out.println("  \"Solid work. The client is pleased.\"");
        } 
        else if (detectiveRank.equals("C")) {
            System.out.println("  \"You left too many loose ends. Sloppy, but not your fault...\"");
        } 
        else if (detectiveRank.equals("F")) {
            System.out.println("  \"You're lucky to be alive. Try harder next time.\"");
        }
        
        System.out.println("___________________________________________________________");
        System.out.println("");
        System.out.println("[PRESS ENTER TO EXIT]");
    }
}