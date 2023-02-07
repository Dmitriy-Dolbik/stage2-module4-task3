package com.mjc.stage2;

import java.util.ArrayList;
import java.util.List;

import com.mjc.stage2.impl.ManufactureFilteringStrategy;
import com.mjc.stage2.impl.MaxPriceFilteringStrategy;

public class Test
{
    public static void main(String[] args)
    {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Item1", 34.0, "Manufacture1"));
        productList.add(new Product("Item2", 30.0, "Manufacture1"));
        productList.add(new Product("Item3", 70.0, "Manufacture2"));
        productList.add(new Product("Item4", 120.3, "Manufacture3"));
        productList.add(new Product("Item5", 49.0, "Manufacture2"));
        productList.add(new Product("Item6", 83.0, "Manufacture1"));
        productList.add(new Product("Item7", 72.0, "Manufacture4"));

        ShopStock shopStock = new ShopStock(productList);
        List<Product> filteringList = shopStock.executeFilteringStrategy(new ManufactureFilteringStrategy("Manufacture1"));
        List<Product> filteringList2 = shopStock.executeFilteringStrategy(new MaxPriceFilteringStrategy(70.0));

        filteringList.forEach(System.out::println);
        filteringList2.forEach(System.out::println);
    }
}

