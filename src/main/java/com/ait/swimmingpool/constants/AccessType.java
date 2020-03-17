package com.ait.swimmingpool.constants;

public enum AccessType {

	NOT_AUTHENTICATED(0), MANAGER(1), STAFF(2), CUSTOMER(3);

	private int accessId;

	private AccessType(int accessId) {
		this.accessId = accessId;
	}

	public int getAccessType() {
		return accessId;
	}

//test
	public static void main(String[] args) {
		System.out.println(NOT_AUTHENTICATED.getAccessType());
		System.out.println(MANAGER.getAccessType());
		System.out.println(STAFF.getAccessType());
		System.out.println(CUSTOMER.getAccessType());
	}

}
