package com.flm.dto;

public class Userdto {
	

	
	
		
		private String username;
		private String email;
		private String password;
		private String phone;
		private String account_number;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAccount_number() {
			return account_number;
		}
		public void setAccount_number(String account_number) {
			this.account_number = account_number;
		}
		public Userdto(String username, String email, String password, String phone, String account_number) {
			super();
			this.username = username;
			this.email = email;
			this.password = password;
			this.phone = phone;
			this.account_number = account_number;
		}
		public Userdto() {
			
		}
		@Override
		public String toString() {
			return "Userdto [username=" + username + ", email=" + email + ", password=" + password + ", phone=" + phone
					+ ", account_number=" + account_number + "]";
		}
		
	}


