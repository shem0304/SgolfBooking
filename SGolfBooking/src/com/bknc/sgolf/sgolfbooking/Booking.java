package com.bknc.sgolf.sgolfbooking;

import org.codehaus.jackson.annotate.JsonProperty;

public class Booking {
	@JsonProperty("hand_phone_no")
	public String hand_phone_no;
	@JsonProperty("booking_status")
	public String booking_status;
	@JsonProperty("booking_status")
	public String player_count;
	@JsonProperty("booking_status")
	public String leftright_gubn;
	@JsonProperty("booking_status")
	public String booking_date_time;
	@JsonProperty("booking_status")
	public String game_kind;
	@JsonProperty("remark")
	public String remark;
	@JsonProperty("shop_code")
	public String shop_code;
	public String getHand_phone_no() {
		return hand_phone_no;
	}
	public void setHand_phone_no(String hand_phone_no) {
		this.hand_phone_no = hand_phone_no;
	}
	public String getBooking_status() {
		return booking_status;
	}
	public void setBooking_status(String booking_status) {
		this.booking_status = booking_status;
	}
	public String getPlayer_count() {
		return player_count;
	}
	public void setPlayer_count(String player_count) {
		this.player_count = player_count;
	}
	public String getLeftright_gubn() {
		return leftright_gubn;
	}
	public void setLeftright_gubn(String leftright_gubn) {
		this.leftright_gubn = leftright_gubn;
	}
	public String getBooking_date_time() {
		return booking_date_time;
	}
	public void setBooking_date_time(String booking_date_time) {
		this.booking_date_time = booking_date_time;
	}
	public String getGame_kind() {
		return game_kind;
	}
	public void setGame_kind(String game_kind) {
		this.game_kind = game_kind;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getShop_code() {
		return shop_code;
	}
	public void setShop_code(String shop_code) {
		this.shop_code = shop_code;
	}
	

}
