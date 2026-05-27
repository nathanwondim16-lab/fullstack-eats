package com.pluralsight.io;

import com.pluralsight.interfaces.FileRepository;
import com.pluralsight.models.Order;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;


public class ReceiptsFileManager implements FileRepository<Order> {

    @Override
    public void save(Order order) {
        Path path = Path.of("data/receipts.csv");

        try(PrintWriter printWriter = new PrintWriter(new FileWriter("receipts.csv", true))) {
            if(Files.exists(path)) {

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}