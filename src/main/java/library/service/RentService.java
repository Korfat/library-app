package library.service;

import java.util.List;

import library.entity.Rent;

public interface RentService {
    void add(Rent rent);

    List<Rent> listRents();
}
