package fr.gagoi.pwal_network.serialize;

public class DataBase implements DataConverter{

	private String name;
	
	public DataBase(String name) {
		this.name = name;
	}

	@Override
	public byte[] toData(DataBase dataBase) {
		byte[] b = null;
		return b;
	}

	@Override
	public DataBase fromData(byte[] data) {
		return new DataBase(name);
	}

}
