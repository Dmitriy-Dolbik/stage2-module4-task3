package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

import com.mjc.stage2.entity.AbstractTextComponent;

public class ChainParserBuilder{
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }


    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser build() {
        int size = parsers.size();
        for (int i = 0; i < size -1; i++){
            parsers.get(i).setNextParser(parsers.get(i+1));
        }
        return parsers.get(0);
    }
}
