package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

public class WordParser extends AbstractTextParser
{


    @Override
    public void parse(final AbstractTextComponent abstractTextComponent, final String string)
    {
        /*char[] chars = string.toCharArray();
        for (char character : chars) {
            AbstractTextComponent symbolLeaf = new SymbolLeaf(TextComponentType.SYMBOL, character);
            abstractTextComponent.add(symbolLeaf);
        }*/

        char[] arr = string.toCharArray();
        for (char elem : arr)
        {
            abstractTextComponent.add(new SymbolLeaf(TextComponentType.WORD, elem));
        }
    }

}
