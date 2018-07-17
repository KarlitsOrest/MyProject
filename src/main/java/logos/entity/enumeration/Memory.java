package logos.entity.enumeration;

public enum Memory {
	GIGABYTE8("GIGABYTE8"),
	GIGABYTE16("GIGABYTE16"),
	GIGABYTE32("GIGABYTE32"),
	GIGABYTE64("GIGABYTE64"),
	GIGABYTE128("GIGABYTE128"),
	GIGABYTE256("GIGABYTE256"),
	GIGABYTE512("GIGABYTE512"),
	GIGABYTE1000("GIGABYTE1000");
	private String memory;

	private Memory(String memory) {
		this.memory = memory;
	}

	public String getMemory() {
		return memory;
	}


}

