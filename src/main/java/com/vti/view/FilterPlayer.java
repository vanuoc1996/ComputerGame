package com.vti.view;

public class FilterPlayer {
	private int minPlayHours;
	private int maxPlayHours;

	public FilterPlayer() {
	}

	public FilterPlayer(int minPlayHours, int maxPlayHours) {
		this.minPlayHours = minPlayHours;
		this.maxPlayHours = maxPlayHours;
	}

	public int getMinPlayHours() {
		return minPlayHours;
	}

	public void setMinPlayHours(int minPlayHours) {
		this.minPlayHours = minPlayHours;
	}

	public int getMaxPlayHours() {
		return maxPlayHours;
	}

	public void setMaxPlayHours(int maxPlayHours) {
		this.maxPlayHours = maxPlayHours;
	}

}
