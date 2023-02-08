package com.mjc.stage2;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;
import com.mjc.stage2.exception.HandlingException;
import com.mjc.stage2.parser.AbstractTextParser;
import com.mjc.stage2.parser.ChainParserBuilder;
import com.mjc.stage2.parser.LexemeParser;
import com.mjc.stage2.parser.WordParser;
import com.mjc.stage2.reader.impl.DataReaderImpl;

public class Test
{
    public static void main(String[] args)
    {
        String text = null;
        try
        {
            text = new DataReaderImpl().readFile("G:\\My Drive\\IT\\Epam\\MJC School\\stage2-module4-task3\\task3-handling\\src\\main\\resources\\data\\textdata.txt");
        }
        catch (HandlingException e)
        {
            throw new RuntimeException(e);
        }
        ChainParserBuilder chainParserBuilder = new ChainParserBuilder();
        chainParserBuilder.setParser(new LexemeParser()).setParser(new WordParser());

        AbstractTextParser parser = chainParserBuilder.build();

        AbstractTextComponent sentenceTextComponent = new TextComponent(TextComponentType.SENTENCE);
        parser.parse(sentenceTextComponent, text);

        System.out.println("That's it");


    }
}
