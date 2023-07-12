package pf.dto;

public class RplanVO {
	private int rseq;
	private int mseq;
	private String name;
	private int charge;
	private String dataplan;
	private String timeplan;
	private String textplan;

	public int getRseq() {
		return rseq;
	}
	public void setRseq(int rseq) {
		this.rseq = rseq;
	}
	public int getMseq() {
		return mseq;
	}
	public void setMseq(int mseq) {
		this.mseq = mseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public String getDataplan() {
		return dataplan;
	}
	public void setDataplan(String dataplan) {
		this.dataplan = dataplan;
	}
	public String getTimeplan() {
		return timeplan;
	}
	public void setTimeplan(String timeplan) {
		this.timeplan = timeplan;
	}
	public String getTextplan() {
		return textplan;
	}
	public void setTextplan(String textplan) {
		this.textplan = textplan;
	}
}
