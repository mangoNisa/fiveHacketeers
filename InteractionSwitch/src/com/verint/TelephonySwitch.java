package com.verint;


public class TelephonySwitch implements Switch {

	private int currentTime;
	private boolean isSwitchOn = false;
	private int difficultyRating;
	private int tickTime;
	private CallGenerator generator;
	private InteractionManager interactionManager;
	private int peakGeneratorCounter;

	public TelephonySwitch(CallGenerator generator,InteractionManager interactionManager,int difficulty, int tickTime) {
		this.difficultyRating = difficulty;
		this.tickTime = tickTime;
		this.generator = generator;
		this.interactionManager = interactionManager;
	}
	
	@Override
	public void turnOn() {
		isSwitchOn = true;		
	}

	@Override
	public boolean isOn() {
		return isSwitchOn ;
	}

	@Override
	public synchronized void tick() {
		currentTime++;
        generateNewWork();
        angryCustomersHangUp();
	}


    /* Generate a number between 0 and 100. If this number is lower than the difficulty
    rating (also 0 to 100) then a new contact will be created and added to the list. */
    private void generateNewWork() {
    	int workloadModifier = generatePeakWorkload();
    	   	
    	System.out.println("workloadModifier:" + workloadModifier);
        int workScore = (int) Math.floor(Math.random()*101);
        System.out.println("workScore:["+workScore+"] difficultyRating["+difficultyRating+"]");
        if(workScore < difficultyRating + workloadModifier) {
        	interactionManager.add(generator.newInteraction(currentTime));
        }
    }

	private int generatePeakWorkload() {
		peakGeneratorCounter++;
    	int workloadModifier = 0; 
    	if(peakGeneratorCounter >500 && peakGeneratorCounter < 1000){
    		workloadModifier = 20;
    	}
    	if(peakGeneratorCounter == 1000){
    		peakGeneratorCounter = 0;
    	}
		return workloadModifier;
	}

    private void angryCustomersHangUp() {
    	interactionManager.dropCustomers(currentTime);
    }
	@Override
	public synchronized long getTickTime() {
		return tickTime;
	}

	@Override
	public void turnOff() {
		isSwitchOn = false;
	}

	public InteractionManager getInteractionManager() {
		return interactionManager;
	}
	
}
