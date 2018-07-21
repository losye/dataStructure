package neu.learning.thread;

public enum TrafficLamp {
	RED(50){
		@Override
		public TrafficLamp nextLamp() {
			return GREEN;
		}	
	},
	YELLOW(5){
		@Override
		public TrafficLamp nextLamp() {
			return RED;
		}	
	},
	GREEN(60){
		@Override
		public TrafficLamp nextLamp() {
			return YELLOW;
		}	
	};
	public abstract TrafficLamp nextLamp();
	private int time;
	private TrafficLamp(int time){
		this.time = time;
	}
}
