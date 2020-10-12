package com.Models;

public class Chirp {
	private double duration;
    private double amplitude;
    private int frequency;
    
    public double getDuration() {
        return this.duration;
    }

    public double getAmplitude() {
        return this.amplitude;
    }

    public int getFrequency() {
        return this.frequency;
    }


    public void setDuration(double newDuration) {
        this.duration = newDuration;
    }

    public void setAmplitude(double newAmplitude) {
        this.amplitude = newAmplitude;
    }

    public void setFrequency(int newFrequency) {
        this.frequency = newFrequency;
    }


    public Chirp(double Duration, double Amplitude, int Frequency) {
        this.duration = Duration;
        this.amplitude = Amplitude;
        this.frequency = Frequency;
    }
    
    public Chirp() {
    	this.duration = 0;
    	this.amplitude = 0;
    	this.frequency = 0;
    }

    public String generateInsertSQL() {
        return "INSERT INTO chirps (Duration, Amplitude, Frequency) VALUES " + this.duration + ", " + this.amplitude + ", " + this.frequency + ";";
    }
}
