package com.mjc.stage2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.impl.RectangleObserver;
import com.mjc.stage2.repository.RectangleRepository;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class Test
{
    public static void main(String[] args)
    {
        RectangleRepository rectangleRepository =  RectangleRepository.getInstance();
        RectangleWarehouse rectangleWarehouse = RectangleWarehouse.getInstance();
        for (int i = 0; i < 10; i++)
        {
            double sizeA = i+1;
            double sizeB = (i+1)*2;

            Rectangle rectangle = new Rectangle(i, sizeA, sizeB);
            rectangle.addObserver(new RectangleObserver());
            rectangleRepository.add(rectangle);

            rectangleWarehouse.put(i, new RectangleValues(sizeA*sizeB, (sizeA+sizeB)*2));
        }

        for (Rectangle rectangle : rectangleRepository.getRectangles()){
            System.out.println(rectangle);
        }

        for (int i = 0; i < 10; i++)
        {
            System.out.println(rectangleWarehouse.get(i));
        }

        Rectangle rectangle = rectangleRepository.getRectangles().get(2);
        rectangle.setSideA(100);

        for (Rectangle rectangleFrom : rectangleRepository.getRectangles()){
            System.out.println(rectangleFrom);
        }

        for (int i = 0; i < 10; i++)
        {
            System.out.println(rectangleWarehouse.get(i));
        }

    }
}
