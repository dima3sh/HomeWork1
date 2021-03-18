package com.mobile.card;

public class Client {

    private String nameClient;
    private final int ageClient;
    private final String clientNumber;

    public Client(String nameClient, int ageClient, String clientNumber) {
        this.nameClient = nameClient;
        this.ageClient = ageClient;
        this.clientNumber = clientNumber;
    }

    public int getAgeClient() {
        return ageClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nameClient='" + nameClient + '\'' +
                ", ageClient=" + ageClient +
                ", clientNumber=" + clientNumber +
                '}';
    }
}