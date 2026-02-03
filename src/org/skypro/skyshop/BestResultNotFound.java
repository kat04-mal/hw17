package org.skypro.skyshop;

public class BestResultNotFound extends Exception{
    public BestResultNotFound(String searchQuery){
        super("Не найден наиболее подходящий результат для запроса: '" + searchQuery + "'");
    }
}
