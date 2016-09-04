package fr.gagoi.pwal_network.serialize;

public interface DataConverter {

	public byte[] toData(DataBase dataBase);
	public DataBase fromData(byte[] data);
}
