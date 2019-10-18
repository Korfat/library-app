package library.dao;

import java.util.List;

import library.entity.Rent;

public interface RentDao {
    void add(Rent rent);

    List<Rent> listRents();
}
