package ProjectHouse;

public class WareHouse1DTO {
	private String num, name, company;
	private int amount,price, volume;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public WareHouse1DTO() {

	}
	public WareHouse1DTO(String num, String name, String company, int amount, int price, int volume) {
		this.num = num;
		this.name = name;
		this.company = company;
		this.amount = amount;
		this.price = price;
		this.volume = volume;
	}
	@Override
	public String toString() {
		return "WareHouse1DTO [num=" + num + ", name=" + name + ", company=" + company + ", amount=" + amount
				+ ", price=" + price + ", volume=" + volume + "]";
	}
	 	
}
