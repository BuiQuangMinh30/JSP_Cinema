package com.fpt.edu.entity;

import java.time.LocalDateTime;

public class Refund {
	private int id;
	private int durationBeforeAfter;
	private LocalDateTime timeRefund;
	private Double percent;
	public Refund() {
		super();
	}
	public Refund(int durationBeforeAfter, LocalDateTime timeRefund, Double percent) {
		super();
		this.durationBeforeAfter = durationBeforeAfter;
		this.timeRefund = timeRefund;
		this.percent = percent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDurationBeforeAfter() {
		return durationBeforeAfter;
	}
	public void setDurationBeforeAfter(int durationBeforeAfter) {
		this.durationBeforeAfter = durationBeforeAfter;
	}
	public LocalDateTime getTimeRefund() {
		return timeRefund;
	}
	public void setTimeRefund(LocalDateTime timeRefund) {
		this.timeRefund = timeRefund;
	}
	public Double getPercent() {
		return percent;
	}
	public void setPercent(Double percent) {
		this.percent = percent;
	}	
	
	
}
