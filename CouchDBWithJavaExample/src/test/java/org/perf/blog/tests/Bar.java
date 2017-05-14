package org.perf.blog.tests;

import com.perf.blog.config.Document;

public class Bar extends Document {
	private String bar;
	
	public Bar() {
		
	}
	
	public Bar(String id) {
		this.setId(id);
	}

	public String getBar() {
		return bar;
	}

	public void setBar(String bar) {
		this.bar = bar;
	}

	@Override
	public String toString() {
		return "Bar [bar=" + bar + "]";
	}
}
