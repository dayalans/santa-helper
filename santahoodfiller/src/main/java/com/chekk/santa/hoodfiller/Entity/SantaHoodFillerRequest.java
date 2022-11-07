package com.chekk.santa.hoodfiller.Entity;

public class SantaHoodFillerRequest {
	private int hood_capacity;
	private int[] present_weights;

	public int getHood_capacity() {
		return hood_capacity;
	}

	public void setHood_capacity(int hood_capacity) {
		this.hood_capacity = hood_capacity;
	}

	public int[] getPresent_weights() {
		return present_weights;
	}

	public void setPresent_weights(int[] present_weights) {
		this.present_weights = present_weights;
	}

}
